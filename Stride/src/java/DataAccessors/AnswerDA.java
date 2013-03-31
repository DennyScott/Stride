/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.*;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Travis
 */
public class AnswerDA {

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
     * Check to see if the given Answer is empty
     *
     * @param newAV the Answer to check
     * @return true if the given Answer is empty
     */
    private static boolean isEmpty(Answer newAnswer) {
        if (newAnswer == null) {
            return true;
        }
        return false;
    }
    
    /**
     * Use to get all Answers from a User
     *
     * @param userID The ID of the User to be searched with
     * @return An ArrayList containing all Answers from a User
     */
    public ArrayList<Answer> collectRecentUserAnswers(int userID, int startPosition, int totalAmount) {
        String SQLString = "SELECT * FROM Answer WHERE User_ID = " + userID + " ORDER BY Last_Updated DESC LIMIT " + (totalAmount + startPosition);
        ArrayList<Answer> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Answer returnAnswer = new Answer();
                returnAnswer.setAnswerID(Integer.parseInt(resultSet.getString(1)));
                returnAnswer.setAnswer(resultSet.getString(2));
                returnAnswer.setQuestionID(Integer.parseInt(resultSet.getString(3)));
                returnAnswer.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnAnswer.setVotes(Integer.parseInt(resultSet.getString(5)));
                returnAnswer.setSubmitted(resultSet.getString(6));
                returnAnswer.setLastUpdated(resultSet.getString(7));
                returnAnswer.setChosen(resultSet.getBoolean(8));
                returnList.add(returnAnswer);
            }

            for (int i = startPosition - 1; i >= 0; i--) {
                returnList.remove(i);
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

    /**
     * Separates values being added to the database
     *
     * @return The String used to separates values
     */
    private static String seperateValue() {
        return "\"" + ", " + "\"";
    }

    /**
     * Adds a new Answer to the database
     *
     * @param newAnswer New Answer to be added to the database
     * @return True if the Answer was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(Answer newAnswer) throws IOException, ClassNotFoundException, SQLException {

        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into Answer VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newAnswer.getAnswer() + seperateValue() + newAnswer.getQuestionID() + seperateValue() + newAnswer.getUserID() + seperateValue() + "0" + seperateValue() + subDate + seperateValue() + subDate + seperateValue() + "0" + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newAnswer)) {
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
     * Updates the Answer object found in the database
     *
     * @param newAnswer The Answer to update in the database
     * @return True if the Answer was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(Answer newAnswer) throws IOException, ClassNotFoundException, SQLException {

        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "Update Answer set Answer = \"" + newAnswer.getAnswer() + "\", Last_Updated = \"" + subDate + "\", Chosen = \"" + (newAnswer.isChosen() ? 1 : 0) + "\" where Answer_ID = " + newAnswer.getAnswerID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newAnswer)) {
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
     * @param Answer_ID The Answer_ID being searched for
     * @return The found Answer
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Answer query(int Answer_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM Answer WHERE Answer_ID = ";
        Answer returnAnswer = new Answer();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + Answer_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnAnswer.setAnswerID(Integer.parseInt(resultSet.getString(1)));
                returnAnswer.setAnswer(resultSet.getString(2));
                returnAnswer.setQuestionID(Integer.parseInt(resultSet.getString(3)));
                returnAnswer.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnAnswer.setVotes(Integer.parseInt(resultSet.getString(5)));
                returnAnswer.setSubmitted(resultSet.getString(6));
                returnAnswer.setLastUpdated(resultSet.getString(7));
                returnAnswer.setChosen(resultSet.getBoolean(8));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnAnswer;
    }

    /**
     * Deletes the given Answer from the Database
     *
     * @param answerID The Answer_ID of the Answer to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int answerID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM Answer WHERE Answer_ID = ";
        Answer returnAnswer = new Answer();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + answerID);


            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Get all Answer belonging to a given Question
     *
     * @param questionID The id of the question all Answers will pertain to
     * @return An ArrayList of Answers belonging to the Question
     */
    public ArrayList<Answer> getQuestionAnswers(int questionID) {
        String SQLString = "SELECT * FROM Answer WHERE Question_ID = ";
        ArrayList<Answer> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + questionID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Answer returnAnswer = new Answer();
                returnAnswer.setAnswerID(Integer.parseInt(resultSet.getString(1)));
                returnAnswer.setAnswer(resultSet.getString(2));
                returnAnswer.setQuestionID(Integer.parseInt(resultSet.getString(3)));
                returnAnswer.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnAnswer.setVotes(Integer.parseInt(resultSet.getString(5)));
                returnAnswer.setSubmitted(resultSet.getString(6));
                returnAnswer.setLastUpdated(resultSet.getString(7));
                returnAnswer.setChosen(resultSet.getBoolean(8));
                returnList.add(returnAnswer);
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

    /**
     * Use to get all Answers from a User
     *
     * @param userID The ID of the User to be searched with
     * @return An ArrayList containing all Answers from a User
     */
    public ArrayList<Answer> getUserAnswers(int userID) {
        String SQLString = "SELECT * FROM Answer WHERE User_ID = ";
        ArrayList<Answer> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + userID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Answer returnAnswer = new Answer();
                returnAnswer.setAnswerID(Integer.parseInt(resultSet.getString(1)));
                returnAnswer.setAnswer(resultSet.getString(2));
                returnAnswer.setQuestionID(Integer.parseInt(resultSet.getString(3)));
                returnAnswer.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnAnswer.setVotes(Integer.parseInt(resultSet.getString(5)));
                returnAnswer.setSubmitted(resultSet.getString(6));
                returnAnswer.setLastUpdated(resultSet.getString(7));
                returnAnswer.setChosen(resultSet.getBoolean(8));
                returnList.add(returnAnswer);
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

    /**
     * Updates the Answer object found in the database
     *
     * @param newAnswer The Answer to update in the database
     * @return True if the Answer was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean incrementVotes(int answerID) throws IOException, ClassNotFoundException, SQLException {

        Answer found = query(answerID);
        String sqlString = "Update Answer set Votes = \"" + (found.getVotes() + 1) + "\" where Answer_ID = " + answerID;
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(sqlString);
            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Updates the Answer object found in the database
     *
     * @param newAnswer The Answer to update in the database
     * @return True if the Answer was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean decrementVotes(int answerID) throws IOException, ClassNotFoundException, SQLException {

        Answer found = query(answerID);
        String sqlString = "Update Answer set Votes = \"" + (found.getVotes() - 1) + "\" where Answer_ID = " + answerID;
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(sqlString);
            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
    
        public boolean chosen(int answerID) throws IOException, ClassNotFoundException, SQLException {

        Answer found = query(answerID);
        String sqlString = "Update Answer set Chosen = \"" + "1" + "\" where Answer_ID = " + answerID;
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(sqlString);
            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
}
