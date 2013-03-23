/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.AnswerVote;
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
 * Data Accessor for AnswerVote Object
 *
 * @author Travis
 */
public class AnswerVoteDA {

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
     * Check to see if the given AnswerVote is empty
     *
     * @param newAV the AnswerVote to check
     * @return true if the given AnswerVote is empty
     */
    private static boolean isEmpty(AnswerVote newAV) {
        if (newAV == null) {
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
     * Adds a new AnswerVote to the database
     *
     * @param newAV New AnswerVote to be added to the database
     * @return True if the AnswerVote was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(AnswerVote newAV) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String sqlString = "INSERT into AnswerVote VALUES ";
        String answerString = "(\"" + newAV.getUserID() + seperateValue() + newAV.getAnswerID() + seperateValue() + (newAV.isUp()?1:0) + seperateValue() + dateFormat.format(date) + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newAV)) {
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
     * Updates the AnswerVote object found in the database
     *
     * @param newAV The AnswerVote to update in the database
     * @return True if the AnswerVote was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(AnswerVote newAV) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String sqlString = "Update AnswerVote set Vote_Up = \"" + (newAV.isUp()?1:0) + "\", Submitted = \"" + dateFormat.format(date) + "\" where User_ID = " + newAV.getUserID() + " AND Answer_ID = " + newAV.getAnswerID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newAV)) {
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
     * Queries the Database for the given SQL Statement
     *
     * @param findAV The AnswerVote being searched for
     * @return The found AnswerVote
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public AnswerVote query(int userID, int answerID) throws IOException, ClassNotFoundException, SQLException {

        AnswerVote findAV = new AnswerVote();
        String SQLString = "SELECT * FROM AnswerVote WHERE User_ID = " + userID + " AND Answer_ID = " + answerID;
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                findAV.setUserID(Integer.parseInt(resultSet.getString(1)));
                findAV.setAnswerID(Integer.parseInt(resultSet.getString(2)));
                if (Integer.parseInt(resultSet.getString(3)) != 0) {
                    findAV.setUp(true);
                } else {
                    findAV.setUp(false);
                }
                findAV.setSubmitted(resultSet.getString(4));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return findAV;
    }

    /**
     * Deletes the given AnswerVote from the Database
     *
     * @param userID The userID of the AnswerVote to delete
     * @param answerID The Answer_ID of the AnswerVote to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int userID, int answerID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM AnswerVote WHERE User_ID = " + userID + " AND Answer_ID = " + answerID;

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
}
