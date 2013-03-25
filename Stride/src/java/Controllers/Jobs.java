/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Jobs.Download;
import Jobs.KijAd;
import Models.QModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Denny
 */
public class Jobs extends HttpServlet {

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

        if (request.getParameter("search") != null) {
            boolean search = request.getParameter("search").equals("true") ? true : false;
            if (search) {
                Beans.Jobs job = QModel.getJobs();
                Download d = new Download();
                ArrayList<KijAd> ad = d.getAdsWithLocation();
                job.setAd(ad);
                HttpSession session = request.getSession();
                session.setAttribute("jobs", ad);
                request.setAttribute("bean", job);
                forwardBean(request, response, "WEB-INF/Jobs.jsp");
            }
        }
        if (request.getParameter("id") != null && request.getSession().getAttribute("jobs") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Beans.JobPage job = QModel.getJob();
            HttpSession session = request.getSession();
            KijAd ad = ((ArrayList<KijAd>) session.getAttribute("jobs")).get(id);
            job.setAd(ad);
            request.setAttribute("bean", job);

            forwardBean(request, response, "WEB-INF/Ad.jsp");
        } else {
            if (request.getSession().getAttribute("jobs") != null) {
                Beans.Jobs job = QModel.getJobs();
                HttpSession session = request.getSession();
                job.setAd((ArrayList<KijAd>) session.getAttribute("jobs"));
                request.setAttribute("bean", job);
                forwardBean(request, response, "WEB-INF/Jobs.jsp");
            } else {
                Beans.Jobs job = QModel.getJobs();
                request.setAttribute("bean", job);
                forwardBean(request, response, "WEB-INF/Jobs.jsp");
            }
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
