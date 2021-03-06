/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yaphet
 */
public class LoginModel {

    public boolean isValid(String loginUsername, String loginPassword, HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

        //Prepare Statement
        PreparedStatement preparedStatementVar;

        //LoginValidation
        ResultSet loginValidation;

        //Login and userName Lookup, to be used with a database
        loginUsername = request.getParameter("jspUsername").trim();
        loginPassword = request.getParameter("jspPassword").trim();

        //JDBC variables
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Stride";
        String username = "portForward"; // No username/password required
        String password = "stfor3909"; // for desktop access to MS Access.

        Class.forName(driver);
        // Establish network connection to database.
        Connection connection = DriverManager.getConnection(url, username, password);

        preparedStatementVar = connection.prepareStatement("select * from User where Username=? and Password =?");

        //Set query to compare rows
        preparedStatementVar.setString(1, loginUsername);
        preparedStatementVar.setString(2, loginPassword);

        //Excute the query
        loginValidation = preparedStatementVar.executeQuery();
        if (loginValidation.next()) {

            HttpSession session = request.getSession(true);

            //Set a name attribute in a session for userName;
            session.setAttribute("Name", loginUsername);
            session.setAttribute("id", loginValidation.getString(1));
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String sqlString = "Update User set Last_Logged_In = \"" + dateFormat.format(date) + "\" where User_ID = " + loginValidation.getString(1);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlString);
            connection.close();

            return true;


        } //Else user has entered an invalid userName or password
        else {

            connection.close();
            return false;

        }



    }
}
