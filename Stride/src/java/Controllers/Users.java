/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.SingleUserPage;
import Beans.UserPage;
import Models.QModel;
import Models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Denny
 */
public class Users extends HttpServlet {

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


        if (request.getParameter("edit") != null) {
            Boolean edit = request.getParameter("edit").equals("true") ? true : false;

            if (edit) {
                if (request.getSession().getAttribute("id") != null) {
                    if (request.getSession().getAttribute("id").equals(request.getParameter("id"))) {
                        if (request.getParameter("submit") != null) {
                            
                            Boolean submit = request.getParameter("submit").equals("true")?true:false;
                            
                            //Succesful Edit
                            if(submit){
                                ModelObjects.User user = new ModelObjects.User();
                                user.setBiography(request.getParameter("bio"));
                                user.setFirstName(request.getParameter("firstName"));
                                user.setProfilePictureLink("img/kip.jpg");
                                user.setLastName(request.getParameter("lastName"));
                                user.setUserID(Integer.parseInt((String)request.getSession().getAttribute("id")));
                                Boolean anon = request.getParameter("isAnon").equals("ON")?true:false;
                                user.setAnonymous(anon);
                                
                                UserModel um = new UserModel();
                                
                               um.editUser(user);
                                
                                getUserPage(request,response);
                            }
                            else{
                                getUserPage(request,response);
                            }
                            
                        } else {
                            getEditUserPage(request, response);
                        }
                    } else {
                        getUserPage(request,response);
                    }
                } else {
                    getUserPage(request,response);
                }
            }
        } else {
            if (request.getParameter("id") != null) {
                getUserPage(request, response);
            } else {
                UserPage user = QModel.getUsers();
                request.setAttribute("bean", user);
                forwardBean(request, response, "WEB-INF/Users.jsp");
            }
        }
    }

    private void getUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SingleUserPage user = QModel.getUser();
        request.setAttribute("bean", user);
        forwardBean(request, response, "WEB-INF/UserPage.jsp");
    }

    private void getEditUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SingleUserPage user = QModel.getUser();
        request.setAttribute("bean", user);
        forwardBean(request, response, "WEB-INF/EditUserPage.jsp");
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
