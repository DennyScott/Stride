/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.AnswerComment;
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
public class AnswerCommentDA {

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
     * Check to see if the given AnswerComment is empty
     *
     * @param newAV the AnswerComment to check
     * @return true if the given AnswerComment is empty
     */
    private static boolean isEmpty(AnswerComment newAnswerComment) {
        if (newAnswerComment == null) {
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
     * Adds a new AnswerComment to the database
     *
     * @param newAnswerComment New AnswerComment to be added to the database
     * @return True if the AnswerComment was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(AnswerComment newAnswerComment) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into AnswerComment VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newAnswerComment.getComment() + seperateValue() + newAnswerComment.getComponentID() + seperateValue() + newAnswerComment.getUserID() + seperateValue() + subDate + seperateValue() + subDate + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newAnswerComment)) {
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
     * Updates the AnswerComment object found in the database
     *
     * @param newAnswerComment The AnswerComment to update in the database
     * @return True if the AnswerComment was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(AnswerComment newAnswerComment) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);

        String sqlString = "Update AnswerComment set Comment = \"" + newAnswerComment.getComment() + "\", Last_Updated = \"" + subDate + "\" where Comment_ID = " + newAnswerComment.getCommentID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newAnswerComment)) {
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
     * @param Comment_ID The Comment_ID being searched for
     * @return The found AnswerComment
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public AnswerComment query(int Comment_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM AnswerComment WHERE Comment_ID = ";
        AnswerComment returnComment = new AnswerComment();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + Comment_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnComment.setCommentID(Integer.parseInt(resultSet.getString(1)));
                returnComment.setComment(resultSet.getString(2));
                returnComment.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnComment.setComponentID(Integer.parseInt(resultSet.getString(3)));
                returnComment.setSubmitted(resultSet.getString(5));
                returnComment.setLastUpdated(resultSet.getString(6));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnComment;
    }

    /**
     * Deletes the given AnswerComment from the Database
     *
     * @param commentID The Comment_ID of the AnswerComment to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int commentID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM AnswerComment WHERE Comment_ID = ";

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
     * Returns all comments belonging to a given Answer_ID
     *
     * @param answerID The Answer_ID of the Answer the comments are connected to
     * @return All comments connected to the given Answer
     */
    public ArrayList<AnswerComment> getAnswerComments(int answerID) {
        String SQLString = "SELECT * FROM AnswerComment WHERE Answer_ID = ";
        ArrayList<AnswerComment> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + answerID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                AnswerComment returnComment = new AnswerComment();
                returnComment.setCommentID(Integer.parseInt(resultSet.getString(1)));
                returnComment.setComment(resultSet.getString(2));
                returnComment.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnComment.setComponentID(Integer.parseInt(resultSet.getString(3)));
                returnComment.setSubmitted(resultSet.getString(5));
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
