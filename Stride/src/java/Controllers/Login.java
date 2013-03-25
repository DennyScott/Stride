/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Error;
import Models.LoginModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 3909-050-001
 */
public class Login extends HttpServlet {

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
        HttpSession session = request.getSession(true);


        //If the user does not insert a value in or the user is logged in and clicks the logout button, do the following
        if ((request.getParameter("jspUsername") == null || request.getParameter("jspPassword") == null)) {

            //Scenario: Request parameters are null because the user is already logged in and then proceeds to click the logout button
            //Check to see if the user is associated with a username, if so then...
            if (session.getAttribute("Name") != null) {

                ///Change the Name attribute in the session to null and redirect them to the login to sign back in
                session.setAttribute("Name", null);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
                rd.forward(request, response);

            } else {

                //Else this is the first time that the user has logged in and redirect them to the login page
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
                rd.forward(request, response);
            }

        } //The user has entered a username and password, do the following
        else {
            //Login and userName Lookup, to be used with a database
            String loginUsername = request.getParameter("jspUsername").trim();
            String loginPassword = request.getParameter("jspPassword").trim();

            LoginModel loginModel = new LoginModel();

            try {
                if (loginModel.isValid(loginUsername, loginPassword, request, response)) {
                    //Set a name attribute in a session for userName;
                    session.setAttribute("Name", loginUsername);


                    RequestDispatcher sentToNext = request.getRequestDispatcher("home");
                    sentToNext.forward(request, response);

                } else {
                    //forward to error page

                    beanForward("Invalid password/username" + "<br/>" + "Note: Passwords are case sensitive", "WEB-INF/login.jsp", response, request);
                }
            } catch (ClassNotFoundException cnfe) {
                //Email technician

                beanForward("Error loading driver: " + cnfe, "WEB-INF/login.jsp", response, request);
            } catch (SQLException sqle) {

                //Email Technician

                beanForward("Error with connection: " + sqle, "WEB-INF/login.jsp", response, request);
            }


        }



    }

    public void beanForward(String message, String destination, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {

        //Create error bean
        Beans.Error error = new Beans.Error();

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
