/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.Question;
import ModelObjects.QuestionComment;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Travis
 */
public class QuestionCommentDA {

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
     * Check to see if the given QuestionComment is empty
     *
     * @param newAV the QuestionComment to check
     * @return true if the given QuestionComment is empty
     */
    private static boolean isEmpty(QuestionComment newQuestionComment) {
        if (newQuestionComment == null) {
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
     * Adds a new QuestionComment to the database
     *
     * @param newQuestionComment New QuestionComment to be added to the database
     * @return True if the QuestionComment was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(QuestionComment newQuestionComment) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into QuestionComment VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newQuestionComment.getComment() + seperateValue() + newQuestionComment.getComponentID() + seperateValue() + subDate + seperateValue() + newQuestionComment.getUserID() + seperateValue() + subDate + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newQuestionComment)) {
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
     * Updates the QuestionComment object found in the database
     *
     * @param newQuestionComment The QuestionComment to update in the database
     * @return True if the QuestionComment was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(QuestionComment newQuestionComment) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "Update QuestionComment set Comment = \"" + newQuestionComment.getComment() + "\", Last_Updated = \"" + subDate + "\" where Comment_ID = " + newQuestionComment.getCommentID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newQuestionComment)) {
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
     * Queries the Database for the given QuestionComment
     *
     * @param Comment_ID The Comment_ID being searched for
     * @return The found QuestionComment
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public QuestionComment query(int Comment_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM QuestionComment WHERE Comment_ID = ";
        QuestionComment returnComment = new QuestionComment();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + Comment_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnComment.setCommentID(Integer.parseInt(resultSet.getString(1)));
                returnComment.setComment(resultSet.getString(2));
                returnComment.setComponentID(Integer.parseInt(resultSet.getString(3)));
                returnComment.setSubmitted(resultSet.getString(4));
                returnComment.setUserID(Integer.parseInt(resultSet.getString(5)));
                returnComment.setLastUpdated(resultSet.getString(6));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnComment;
    }

    /**
     * Deletes the given QuestionComment from the Database
     *
     * @param commentID The Comment_ID of the QuestionComment to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int commentID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM QuestionComment WHERE Comment_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + commentID);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Collects all the Comments belonging to a given Question
     *
     * @param questionID The ID of the question being searched with
     * @return An ArrayList of all Comments belonging to a Question
     */
    public ArrayList<QuestionComment> getQuestionComments(int questionID) {
        String SQLString = "SELECT * FROM QuestionComment WHERE Question_ID = ";
        ArrayList<QuestionComment> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + questionID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                QuestionComment returnComment = new QuestionComment();
                returnComment.setCommentID(Integer.parseInt(resultSet.getString(1)));
                returnComment.setComment(resultSet.getString(2));
                returnComment.setComponentID(Integer.parseInt(resultSet.getString(3)));
                returnComment.setSubmitted(resultSet.getString(4));
                returnComment.setUserID(Integer.parseInt(resultSet.getString(5)));
                returnComment.setLastUpdated(resultSet.getString(6));
                returnList.add(returnComment);
            }
            connection.close();

        } catch (SQLException sqle) {
            return null;
        } catch (ClassNotFoundException cnf) {
            return null;
        } catch (IOException ioe) {
            return null;
        }

        return returnList;
    }
}
