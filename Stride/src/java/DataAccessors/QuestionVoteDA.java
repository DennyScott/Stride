/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.QuestionVote;
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
public class QuestionVoteDA {

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
     * Check to see if the given QuestionVote is empty
     *
     * @param newAV the QuestionVote to check
     * @return true if the given QuestionVote is empty
     */
    private static boolean isEmpty(QuestionVote newQV) {
        if (newQV == null) {
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
     * Adds a new QuestionVote to the database
     *
     * @param newQV New QuestionVote to be added to the database
     * @return True if the QuestionVote was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(QuestionVote newQV) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into QuestionVote VALUES ";
        String answerString = "(\"" + newQV.getUserID() + seperateValue() + newQV.getQuestionID() + seperateValue() + (newQV.isUp()?1:0) + seperateValue() + subDate + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newQV)) {
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
     * Updates the QuestionVote object found in the database
     *
     * @param newQV The QuestionVote to update in the database
     * @return True if the QuestionVote was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(QuestionVote newQV) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "Update QuestionVote set Vote_Up = \"" + (newQV.isUp()?1:0) + "\", Submitted = \"" + subDate + "\" where User_ID = " + newQV.getUserID() + "AND Question_ID = " + newQV.getQuestionID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newQV)) {
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
     * Queries the Database for the given QuestionVote
     *
     * @param userID The User_ID being searched for
     * @param questionID The Question_ID being searched for
     * @return The found QuestionVote
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public QuestionVote query(int userID, int questionID) throws IOException, ClassNotFoundException, SQLException {

        QuestionVote findQV = new QuestionVote();
        String SQLString = "SELECT * FROM QuestionVote WHERE User_ID = " + userID + " AND Question_ID" + questionID;
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                findQV.setUserID(Integer.parseInt(resultSet.getString(1)));
                findQV.setQuestionID(Integer.parseInt(resultSet.getString(2)));
                if (Integer.parseInt(resultSet.getString(3)) != 0) {
                    findQV.setUp(true);
                } else {
                    findQV.setUp(false);
                }
                findQV.setSubmitted(resultSet.getString(4));

            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return findQV;
    }

    /**
     * Deletes the given QuestionVote from the Database
     *
     * @param userID The UserID of the QuestionVote to delete
     * @param questionID The quetionID of the QuestionVote to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int userID, int questionID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM QuestionVote WHERE User_ID = " + userID + "AND Question_ID = " + questionID;

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
