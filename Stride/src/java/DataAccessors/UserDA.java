/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Travis
 */
public class UserDA {

    /**
     * Will create a basic connection to the local Stride database
     *
     * @return A Connection to the database
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    private static Connection connectDB() throws ClassNotFoundException, SQLException, IOException {
        String url = "jdbc:mysql://localhost:3306/Stride";
        String driver = "com.mysql.jdbc.Driver";
        String dbUname = "portForward";
        String dbPass = "stfor3909";

        // Load database driver if it's not already loaded.
        Class.forName(driver);
        // Establish network connection to database.
        Connection connection = DriverManager.getConnection(url, dbUname, dbPass);
        // Create a statement for executing queries.


        return connection;
    }

    /**
     * Check to see if the given User is empty
     *
     * @param newAV the User to check
     * @return true if the given User is empty
     */
    private static boolean isEmpty(User newUser) {
        if (newUser == null) {
            return true;
        }
        return false;
    }

    /**
     * Separates values being added to the database
     *
     * @return The String used to separates values
     */
    private static String seperateValue() {
        return "\"" + ", " + "\"";
    }

    /**
     * Adds a new User to the database
     *
     * @param newUser New User to be added to the database
     * @return True if the User was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(User newUser) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into User VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newUser.getUsername() + seperateValue() + newUser.getPassword() + seperateValue() + newUser.getFirstName() + seperateValue() + newUser.getLastName() + seperateValue() + newUser.getEmailAddress() + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + subDate + seperateValue() + subDate + seperateValue() + newUser.getProfilePictureLink() + seperateValue() + newUser.getBiography() + seperateValue() + newUser.getRank() + seperateValue() + (newUser.isAnonymous() ? 1 : 0) + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + "0" + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newUser)) {
                return false;
            }

            statement.executeUpdate(sqlString + answerString);
            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Updates the User object found in the database
     *
     * @param newUser The User to update in the database
     * @return True if the User was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(User newUser) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "Update User set Profile_Picture_Path = \"" + newUser.getProfilePictureLink() + "\", Last_Logged_In = \"" + subDate + "\", Number_Of_Questions = \"" + newUser.getNumberOfQuestions() + "\", Number_Of_Answers = \"" + newUser.getNumberOfAnswers() + "\", Votes = \"" + newUser.getVotes() + "\", Biography = \"" + newUser.getBiography() + "\", Rank = \"" + newUser.getRank() + "\", Is_Anonymous = \"" + (newUser.isAnonymous() ? 1 : 0) + "\", Gold_Count = \"" + newUser.getGoldCount() + "\", Silver_Count = \"" + newUser.getSilverCount() + "\", Bronze_Count = \"" + newUser.getBronzeCount() + "\", Reputation = \"" + newUser.getReputation() + "\"  where User_ID = " + newUser.getUserID();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newUser)) {
                return false;
            }

            statement.executeUpdate(sqlString);
            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Queries the Database for the given User
     *
     * @param User_ID The User_ID being searched for
     * @return The found User
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User query(int User_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM User WHERE User_ID = ";
        User returnUser = new User();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + User_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnUser.setUserID(Integer.parseInt(resultSet.getString(1)));
                returnUser.setUsername(resultSet.getString(2));
                returnUser.setPassword(resultSet.getString(3));
                returnUser.setFirstName(resultSet.getString(4));
                returnUser.setLastName(resultSet.getString(5));
                returnUser.setEmailAddress(resultSet.getString(6));
                returnUser.setNumberOfQuestions(Integer.parseInt(resultSet.getString(7)));
                returnUser.setNumberOfAnswers(Integer.parseInt(resultSet.getString(8)));
                returnUser.setVotes(Integer.parseInt(resultSet.getString(9)));
                returnUser.setCreated(resultSet.getString(10));
                returnUser.setLastLoggedIn(resultSet.getString(11));
                returnUser.setProfilePictureLink(resultSet.getString(12));
                returnUser.setBiography(resultSet.getString(13));
                returnUser.setRank(resultSet.getString(14));
                returnUser.setAnonymous(resultSet.getBoolean(15));                
                returnUser.setGoldCount(Integer.parseInt(resultSet.getString(16)));
                returnUser.setSilverCount(Integer.parseInt(resultSet.getString(17)));
                returnUser.setBronzeCount(Integer.parseInt(resultSet.getString(18)));
                returnUser.setReputation(Integer.parseInt(resultSet.getString(19)));


            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnUser;
    }

    /**
     * Deletes the given User from the Database
     *
     * @param user The user_ID of the User to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int userID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM User WHERE User_ID = ";
        User returnUser = new User();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + userID);


            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
}
