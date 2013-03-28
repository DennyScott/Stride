/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.AskQuestionPage;
import Models.AskQuestionModel;
import Models.QuestionModel;
import Models.TagModel;
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
public class Ask extends HttpServlet {

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
        AskQuestionPage aqp = new AskQuestionModel().getPage();
        request.setAttribute("bean", aqp);
        forwardBean(request,response,"WEB-INF/ask.jsp");
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

        if (request.getSession().getAttribute("id") != null) {
            ModelObjects.Question question = new ModelObjects.Question();
            question.setAnswers(0);
           String courseID = request.getParameter("courseSelection");
            question.setCourseID(Integer.parseInt(courseID));
            question.setQuestion(request.getParameter("post-text"));
            question.setTitle(request.getParameter("title"));
            question.setVotes(0);
            question.setVisits(0);
            question.setUserID(Integer.parseInt((String) request.getSession().getAttribute("id")));

            
            
            String tags = request.getParameter("tags");
            TagModel tm = new TagModel();




            QuestionModel qm = new QuestionModel();
            int questionId = qm.addQuestion(question);
            if (tags != null) {

                String[] tokens = tags.split(",");
                for (String t : tokens) {
                    if(!(t.equals(""))){
                    ModelObjects.Tag temp = new ModelObjects.Tag();
                    temp.setDescription("");
                    temp.setTitle(t.toLowerCase().trim());
                    if (questionId != 0) {
                        tm.addTag(temp, questionId);
                    }
                    }


                }
            }
            forwardBean(request,response,"home?id="+questionId);
        }
    }
    public void forwardBean(HttpServletRequest request, HttpServletResponse response, String target)throws ServletException, IOException{
    RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
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
