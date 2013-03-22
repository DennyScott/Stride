/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import java.io.IOException;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class DB {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private JspWriter out;
    private Connection connection;
    private Statement statement;
    public boolean isConnected = false;

    public void setVar(HttpServletRequest _request, HttpServletResponse _response, JspWriter _out) {
        request = _request;
        response = _response;
        out = _out;
    }

    private void login() throws IOException {

        if (isConnected) {
            return;
        }

        String url = "jdbc:mysql://localhost:3306/Stride";
        String driver = "com.mysql.jdbc.Driver";
        String dbUname = "portForward";
        String dbPass = "stfor3909";

        try {
            // Load database driver if it's not already loaded.
            Class.forName(driver);
            // Establish network connection to database.
            connection = DriverManager.getConnection(url, dbUname, dbPass);
            // Create a statement for executing queries.
            statement = connection.createStatement();

            isConnected = true;
        } catch (ClassNotFoundException cnfe) {
            out.println("<h3>Error loading driver: " + cnfe + "</h3>");
        } catch (SQLException sqle) {
            out.println("<h3>Error with connection: " + sqle + "</h3>");
        }
    }

    private void logoff() throws IOException {

        if (!isConnected) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException sqle) {
            out.println("<h3>Error with connection: " + sqle + "</h3>");
        }

        isConnected = false;
    }

    public void action() throws IOException {
        String action = request.getParameter("bAction");

        if (action == null) {
            return;
        }

        if (action.equals("Login")) {
            login();
        }

        if (action.equals("Logoff")) {
            logoff();
        }

        if (action.equals("Update")) {
            update();
        }

        if (action.equals("Query")) {
            query();
        }
    }

    public void update() throws IOException {
        if (!isConnected) {
            return;
        }

        String update = request.getParameter("update");
        if (update == null || update.equals("")) {
            out.println("Please specify an update for the database!<br />");
            return;
        }

        try {
            statement.executeUpdate(update);
        } catch (SQLException sqle) {
            out.println("<h3>Error with update query: " + sqle + "</h3>");
        }
    }

    public void query() throws IOException {
        if (!isConnected) {
            return;
        }

        String query = request.getParameter("query");
        if (query == null || query.equals("")) {
            out.println("Please specify a query to query the database!<br />");
            return;
        }

        try {
            ResultSet resultSet = statement.executeQuery(query);
            out.println("<table cellpadding=\"4\" border=\"1\">");
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            for (int i = 1; i <= cn; i++) {
                out.println("<th>" + result.getColumnName(i) + "</th>");
            }
            while (resultSet.next()) {
                out.println("<tr>");
                for (int i = 1; i <= cn; i++) {
                    out.println("<td>" + resultSet.getString(i) + "</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException sqle) {
            out.println("<h3>Error with update query: " + sqle + "</h3>");
        }
    }
}
