/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.SingleTagPage;
import Beans.TagPage;
import Models.SingleTagPageModel;
import Models.TagPageModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denny
 */
public class Tags extends HttpServlet {

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
            SingleTagPage tag;
            if (request.getParameter("page") == null) {
                tag = new SingleTagPageModel().getPage(Integer.parseInt(request.getParameter("id")), 1);

            } else {
                tag = new SingleTagPageModel().getPage(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("page")));
            }
            request.setAttribute("bean", tag);
            forwardBean(request, response, "WEB-INF/TagPage.jsp");
        } else {
            TagPage tag;
            if (request.getParameter("page") == null) {
                tag = new TagPageModel().getPage(1);
            } else {
                tag = new TagPageModel().getPage(Integer.parseInt(request.getParameter("page")));

            }
            request.setAttribute("bean", tag);
            forwardBean(request, response, "WEB-INF/Tags.jsp");
        }

    }

    public void forwardBean(HttpServletRequest request, HttpServletResponse response, String target) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
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
