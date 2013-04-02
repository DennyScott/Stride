/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Adapters.AnswerAdapter;
import Beans.QuestionPage;
import Beans.Front;
import Models.AnswerModel;
import Models.CommentModel;
import Models.HomeModel;
import Models.LoginModel;
import Models.QuestionPageModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

                if (submit && request.getAttribute("submitted") == null) {
                    if (request.getParameter("post-text") != null) {
                        //Add Answer


                        //check if logged in
                        if (request.getSession().getAttribute("id") == null) {
                            
                            if(request.getParameter("jspUsername") == null || request.getParameter("jspPassword")==null){
                                forwardBean(request,response,"WEB-INF/login.jsp");
                            }
                            //Login and userName Lookup, to be used with a database
                            String loginUsername = request.getParameter("jspUsername").trim();
                            String loginPassword = request.getParameter("jspPassword").trim();

                            
                            
                            LoginModel loginModel = new LoginModel();

                            try {
                                if (loginModel.isValid(loginUsername, loginPassword, request, response)) {
                                    //Set a name attribute in a session for userName;
                                    request.getSession().setAttribute("Name", loginUsername);

                                } else {
                                    //forward to error page

                                    forwardBean(request, response, "WEB-INF/login.jsp");
                                }
                            } catch (ClassNotFoundException cnfe) {
                                //Email technician

                                forwardBean(request, response, "WEB-INF/login.jsp");
                            } catch (SQLException sqle) {

                                //Email Technician

                                forwardBean(request, response, "WEB-INF/login.jsp");
                            }
                        }
                        
                        ModelObjects.Answer answer = new ModelObjects.Answer();
                        answer.setAnswer(request.getParameter("post-text"));
                        answer.setQuestionID(Integer.parseInt((String) request.getParameter("id")));
                        answer.setUserID(Integer.parseInt((String) request.getSession().getAttribute("id")));

                        AnswerModel ua = new AnswerModel();
                        ua.addAnswer(answer);
                        request.setAttribute("submitted", "true");
                        
                        response.sendRedirect("home?id=" + answer.getQuestionID());
                    } else {
                        getQuestion(request, response);
                    }
                } else if (request.getParameter("questionComment") != null) {
                    addQuestionComment(request, response);
                } else {
                    getQuestion(request, response);
                }
            } else if (request.getParameter("questionComment") != null) {
                addQuestionComment(request, response);
            } else if (request.getParameter("answerComment") != null) {
                addAnswerComment(request, response);
            } else if (request.getParameter("answer") != null) {
                selectAnswer(request, response);
            } else {
                getQuestion(request, response);
            }
        } else {
            //Get Front Page
            HomeModel frontPage = new HomeModel();
            ArrayList<Integer> values = getCookies(request);
            Front front;
            if(request.getParameter("sort")!=null){
                if(request.getParameter("sort").equals("unanswered")){
                     front = frontPage.getUnansweredFront(values);
                }else if (request.getParameter("sort").equals("bounty")){
                    front = frontPage.getBountyFront(values);
                }else{
                     front = frontPage.getFront(values);
                }
            }else{
                 front = frontPage.getFront(values);
            }
            //Add to read Cookies
            request.setAttribute("bean", front);

            forwardBean(request, response, "WEB-INF/index.jsp");

        }

    }

    public void selectAnswer(HttpServletRequest request, HttpServletResponse response) {
        int answerID = Integer.parseInt(request.getParameter("answer"));
        Beans.Answers answer = new AnswerAdapter().getAnswer(answerID);
        if (!(Integer.parseInt(answer.getAuthorID()) == Integer.parseInt((String) request.getSession().getAttribute("id")))) {
            try {
                AnswerModel am = new AnswerModel();
                am.selectAnswer(answerID);
                getQuestion(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                getQuestion(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Integer> getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        ArrayList<Integer> values = new ArrayList<Integer>();
        int placement = 0;
        int IDOne = 0;
        int IDTwo = 0;
        try {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("questionID1")) {
                    IDOne = (Integer.parseInt(cookies[i].getValue()));
                } else if (cookies[i].getName().equals("questionID2")) {
                    IDTwo = (Integer.parseInt(cookies[i].getValue()));
                } else if (cookies[i].getName().equals("scanCookies")) {
                    placement = Integer.parseInt(cookies[i].getValue());
                }
            }
            if (placement != 0) {
                if (placement == 1) {
                    values.add(IDTwo);
                    if (IDOne != 0) {
                        values.add(IDOne);
                    }
                } else if (placement == 2) {
                    values.add(IDOne);
                    if (IDTwo != 0) {
                        values.add(IDTwo);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return values;
    }

    public void getQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionPage question = new QuestionPageModel().getQuestion(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("bean", question);
        forwardBean(request, response, "WEB-INF/question.jsp");

    }

    public void addQuestionComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean questionComment = request.getParameter("questionComment").equals("true") ? true : false;
        if (questionComment && request.getAttribute("qCommentSubmitted") == null) {
            if (request.getParameter("qComment") != null) {

                ModelObjects.QuestionComment qc = new ModelObjects.QuestionComment();
                String questionID = request.getParameter("id");
                String comment = request.getParameter("qComment");
                qc.setComment(comment);
                qc.setComponentID(Integer.parseInt(questionID));
                qc.setUserID(Integer.parseInt((String) request.getSession().getAttribute("id")));

                CommentModel cm = new CommentModel();
                cm.addQuestionComment(qc);
                request.setAttribute("qCommentSubmitted", "true");
                response.sendRedirect("home?id=" + questionID);

            } else {
                getQuestion(request, response);
            }
        } else {
            getQuestion(request, response);
        }
    }

    public void addAnswerComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean answerComment = request.getParameter("answerComment").equals("true") ? true : false;
        if (answerComment && request.getAttribute("aCommentSubmitted") == null) {
            if (request.getParameter("aComment" + request.getParameter("answer")) != null && request.getParameter("answer") != null) {

                ModelObjects.AnswerComment qc = new ModelObjects.AnswerComment();
                String answerID = request.getParameter("answer");
                String comment = request.getParameter("aComment" + answerID);
                qc.setComment(comment);
                qc.setComponentID(Integer.parseInt(answerID));
                qc.setUserID(Integer.parseInt((String) request.getSession().getAttribute("id")));

                CommentModel cm = new CommentModel();
                cm.addAnswerComment(qc);
                request.setAttribute("aCommentSubmitted", "true");
                response.sendRedirect("home?id="+request.getParameter("id"));

            } else {
                getQuestion(request, response);
            }
        } else {
            getQuestion(request, response);
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
