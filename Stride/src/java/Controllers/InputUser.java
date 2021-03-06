/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denny
 */
public class InputUser extends HttpServlet {

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
        
        ModelObjects.User user = new ModelObjects.User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setProfilePictureLink(request.getParameter("image"));
        user.setReputation(Integer.parseInt(request.getParameter("reputation")));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmailAddress(request.getParameter("email"));
        user.setNumberOfQuestions(Integer.parseInt(request.getParameter("numQuestions")));
        user.setNumberOfAnswers(Integer.parseInt(request.getParameter("numAnswers")));
        user.setVotes(Integer.parseInt(request.getParameter("votes")));
        user.setRank(request.getParameter("rank"));
        user.setBiography(request.getParameter("bio"));
        user.setGoldCount(Integer.parseInt(request.getParameter("gold")));
        user.setSilverCount(Integer.parseInt(request.getParameter("silver")));
        user.setBronzeCount(Integer.parseInt(request.getParameter("bronze")));
        user.setLastLoggedIn(request.getParameter("lastOnline"));
        user.setAnonymous(request.getParameter("isAnon").equals("ON")?true:false);
        
        UserModel um = new UserModel();
        um.addUser(user);
        
        PrintWriter out = response.getWriter();
        out.println(user.toString());
        
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
