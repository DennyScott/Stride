/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denny
 */
public class QuestionCookie extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            String scanCookies = searchCookies("scanCookies", request);
            if (!scanCookies.equals("")) {
                setCookie("questionID" + scanCookies, request.getParameter("id"),response);
                setScan(Integer.parseInt(scanCookies),response);
            }else{
                setCookie("questionID1", request.getParameter("id"),response);
                setScan(1,response);
            }

            Cookie cookie = new Cookie("questionID", request.getParameter("id"));
            cookie.setMaxAge(24 * 60 * 60 * 31);
            response.addCookie(cookie);
        }

    }

    private void setScan(int num,HttpServletResponse response) {
        if (num == 1) {
            setCookie("scanCookies","2",response);
        } else{
            setCookie("scanCookies", "1", response);
        }
    }

    private void setCookie(String name, String id, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, id);
        cookie.setMaxAge(24 * 60 * 60 * 31);
        response.addCookie(cookie);
    }

    private String searchCookies(String value, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(value)) {
                return cookies[i].getValue();
            }
        }
        return "";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
