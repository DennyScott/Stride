/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.QuestionPage;
import Beans.Front;
import Models.AnswerModel;
import Models.QModel;
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
public class Home extends HttpServlet {

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

            if (request.getParameter("submit") != null) {
                boolean submit = request.getParameter("submit").equals("true") ? true : false;
                if (submit) {
                    if (request.getParameter("post-text") != null) {
                        ModelObjects.Answer answer = new ModelObjects.Answer();
                        answer.setAnswer(request.getParameter("post-text"));
                        answer.setQuestionID(Integer.parseInt((String)request.getParameter("id")));
                        answer.setUserID(Integer.parseInt((String)request.getSession().getAttribute("id")));
                        
                        AnswerModel ua = new AnswerModel();
                        ua.addAnswer(answer);
                    } else {
                        getQuestion(request,response);
                    }
                }
            } else {
                getQuestion(request,response);
            }
        } else {
            Front front = QModel.getFront();
            request.setAttribute("bean", front);
            forwardBean(request, response, "WEB-INF/index.jsp");

        }

    }

    public void getQuestion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        QuestionPage question = QModel.getQuestion(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("bean", question);
        forwardBean(request,response,"WEB-INF/question.jsp");

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
