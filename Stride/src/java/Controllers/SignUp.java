 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Error;
import Models.UserModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yaphet
 */
public class SignUp extends HttpServlet {

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

        //If this is the first time the user is using the signup page then do the following
        if (request.getParameter("signUpUsername") == null || request.getParameter("signUpPassword") == null) {

            //Forward user to the signUp page
            beanForward(null, "WEB-INF/signUp.jsp", response, request);


        } //Else if the username or password they entered is blank do the following
        else if (request.getParameter("signUpUsername").trim().equals("") || request.getParameter("signUpPassword").trim().equals("")) {


            //Forward user to the signUp page
            beanForward("Passwords and usernames cannot be left blank", "WEB-INF/signUp.jsp", response, request);


        } //Else if the password and confimartion password are not the same then do the following
        else if (!request.getParameter("signUpPassword").equals(request.getParameter("signUpPasswordReconfirm"))) {


            //Forward user to the signUp page
            beanForward("Passwords are not the same", "WEB-INF/signUp.jsp", response, request);


        } //The user has entered a valid username, password, and password confirmation
        else {

            ModelObjects.User user = new ModelObjects.User();
            
            user.setUsername(request.getParameter("signUpUsername"));
            user.setPassword(request.getParameter("signUpPassword"));
            user.setProfilePictureLink(request.getParameter("image"));
            user.setEmailAddress(request.getParameter("email"));
            user.setFirstName("");
            user.setLastName("");
            user.setRank("Newbie");

                UserModel um = new UserModel();
                
        
                if (um.addUser(user)) {
                    //Forward user to the login page
                    beanForward("Thanks for signing up! <br> Now you can login!", "WEB-INF/login.jsp", response, request);

                } else {
                    //forward to error page
                }
            


        }


    }

    public void beanForward(String message, String destination, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {

        //Create error bean
        Error error = new Error();

        error.setErrorMessage(message);
        request.setAttribute("error", error);

        //Send user to the login page to use their new information to login to the website
        RequestDispatcher sentToNext = request.getRequestDispatcher(destination);
        sentToNext.forward(request, response);
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
