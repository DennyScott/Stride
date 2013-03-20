/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yaphet
 */
public class mySQLServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Prepare Statement
        PreparedStatement preparedStatementVar;

        //LoginValidation
        ResultSet loginValidation;

        //Login and userName Lookup, to be used with a database
        String loginUsername = request.getParameter("jspUsername");
        String loginPassword = request.getParameter("jspPassword");

        //JDBC variables
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/loginDB";
        String username = "root"; // No username/password required
        String password = "yottajoule"; // for desktop access to MS Access.

        try {


            Class.forName(driver);
            // Establish network connection to database.
            Connection connection = DriverManager.getConnection(url, username, password);
//            out.println("ids\n" + "==========");
//
//            // Create a statement for executing queries.
//            Statement statementInsert = connection.createStatement();
//
//            String sql = "INSERT INTO Employees VALUES ('10')";
//            statementInsert.executeUpdate(sql);
//
//            // Create a statement for executing queries.
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM Employees";
//
//            // Send query to database and store results.
//            ResultSet resultSet = statement.executeQuery(query);
//
//            // Print results.
//            while (resultSet.next()) {
//                out.print(resultSet.getString("id") + " ");
//            }


            //Login Steps

//            preparedStatementVar = connection.prepareStatement("select * from loginTable where loginUsername=? and loginPassword COLLATE Latin1_General_CS =?");
            preparedStatementVar = connection.prepareStatement("select * from loginTable where loginUsername=? and loginPassword =?");

            preparedStatementVar.setString(1, loginUsername);
            preparedStatementVar.setString(2, loginPassword);

            loginValidation = preparedStatementVar.executeQuery();
            if (loginValidation.next()) {

                HttpSession session = request.getSession(true);
                session.setAttribute("validUserName", loginUsername);

                //Send to the welcome page
                RequestDispatcher sendToWelcome = request.getRequestDispatcher("loginWelcome.jsp");
                sendToWelcome.forward(request, response);

//                RequestDispatcher rd1 = request.getRequestDispatcher("Welcome.jsp");
//                rd1.include(request, response);
//                out.println("<h3>welcome " + " " + loginUsername + "</h3>");
//                or
//                response.sendRedirect("Welcome.jsp");
//                out.println("<form method=\"post\" action=\"mySQL.html\">");
//                out.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");
//                out.println("</form>");

            } else {
                RequestDispatcher rd2 = request.getRequestDispatcher("loginError.jsp");
                rd2.include(request, response);
                //or
                //response.sendRedirect("./Login.html");
            }
            //close connection
            connection.close();


            /* TODO output your page here. You may use following sample code. */
        } catch (ClassNotFoundException cnfe) {
            out.println("Error loading driver: " + cnfe);
        } catch (SQLException sqle) {
            out.println("Error with connection: " + sqle);
        }
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