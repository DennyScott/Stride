/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.SingleUserPage;
import Beans.UserPage;
import Models.ProfilePage;
import Models.UserModel;
import Models.UsersPageModel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

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

                            Boolean submit = request.getParameter("submit").equals("true") ? true : false;

                            //Succesful Edit
                            if (submit) {
                                ModelObjects.User user = new ModelObjects.User();


                                try {
                                    List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                                    for (FileItem item : items) {
                                        if (item.isFormField()) {
                                            //Process Regular form fields
                                            String fn = item.getFieldName();
                                            if (fn.equals("bio")) {
                                                user.setBiography(request.getParameter("bio"));
                                            } else if (fn.equals("firstName")) {
                                                user.setFirstName(request.getParameter("firstName"));
                                            } else if (fn.equals("lastName")) {
                                                user.setLastName(request.getParameter("lastName"));
                                            } else if (fn.equals("isAnon")) {
                                                Boolean anon = request.getParameter("isAnon").equals("ON") ? true : false;
                                                user.setAnonymous(anon);
                                            }


                                        } else {

                                            String fieldName = item.getFieldName();
                                            String fileName = FilenameUtils.getName(item.getName());
                                            InputStream fileContent = item.getInputStream();
                                            File file = new File("img/" + fileName);
                                            BufferedImage image = ImageIO.read(fileContent);
                                            String extension = fileName.split(".")[1];
                                            ImageIO.write(image, extension, file);

                                        }
                                    }

                                } catch (FileUploadException ex) {
                                    System.out.println(ex.getMessage());
                                }
                                user.setProfilePictureLink(request.getParameter("profilePic"));

                                user.setUserID(Integer.parseInt((String) request.getSession().getAttribute("id")));
                                UserModel um = new UserModel();

                                um.editUser(user);

                                getUserPage(request, response);
                            } else {
                                getUserPage(request, response);
                            }

                        } else {
                            getEditUserPage(request, response);
                        }
                    } else {
                        getUserPage(request, response);
                    }
                } else {
                    getUserPage(request, response);
                }
            }
        } else {
            if (request.getParameter("id") != null) {
                getUserPage(request, response);
            } else {
                UserPage user = new UsersPageModel().getUserPage(0, 20);
                request.setAttribute("bean", user);
                forwardBean(request, response, "WEB-INF/Users.jsp");
            }
        }
    }

    private void getUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SingleUserPage user = new ProfilePage().getPage(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("bean", user);
        forwardBean(request, response, "WEB-INF/UserPage.jsp");
    }

    private void getEditUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SingleUserPage user = new ProfilePage().getPage(Integer.parseInt(request.getParameter("id")));
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
