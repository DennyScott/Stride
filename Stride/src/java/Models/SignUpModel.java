/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Denny
 */
public class SignUpModel {

    public boolean insert(String signUpUsername, String signUpPassword) throws SQLException, ClassNotFoundException {
        //Prepare Statement
        PreparedStatement preparedStatementVar;

        //Sign up verification
        int verified = 0;

        //SignUp username and password to be used in the database update


        //JDBC variables
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Stride";
        String username = "portForward";
        String password = "stfor3909"; // for desktop access to MS Access.

        Class.forName(driver);
        // Establish network connection to database.
        Connection connection = DriverManager.getConnection(url, username, password);

        preparedStatementVar = connection.prepareStatement("insert into User(Username,Password) values (?,?)");

        //Set the strings to be used in the update
        preparedStatementVar.setString(1, signUpUsername);
        preparedStatementVar.setString(2, signUpPassword);

        //Excute the query
        verified = preparedStatementVar.executeUpdate();
        if (verified != 0) {

            connection.close();
            return true;

        } //Else user has entered an invalid userName or password
        //NOTE: Never will be reached
        else {
            connection.close();
            return false;
        }
        //close connection




    }
}
