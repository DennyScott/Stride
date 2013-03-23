/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.Question;
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
public class QuestionDA {

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
     * Check to see if the given Question is empty
     *
     * @param newAV the Question to check
     * @return true if the given Question is empty
     */
    private static boolean isEmpty(Question newQuestion) {
        if (newQuestion == null) {
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
     * Adds a new Question to the database
     *
     * @param newQuestion New Question to be added to the database
     * @return True if the Question was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(Question newQuestion) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into Question VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newQuestion.getQuestion() + seperateValue() + newQuestion.getUserID() + seperateValue() + "0" + seperateValue() + subDate + seperateValue() + subDate + seperateValue() + newQuestion.getTitle() + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + newQuestion.getCourseID() + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newQuestion)) {
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
     * Updates the Question object found in the database
     *
     * @param newQuestion The Question to update in the database
     * @return True if the Question was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(Question newQuestion) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String sqlString = "Update Question set Question = \"" + newQuestion.getQuestion() + "\", Last_Updated = \"" + dateFormat.format(date) + "\", Votes = \"" + newQuestion.getVotes() + "\", Times_Visited = \"" + newQuestion.getVisits() + "\", Number_Of_Answers = \"" + newQuestion.getAnswers() + "\" where Question_ID = " + newQuestion.getQuestionID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newQuestion)) {
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
     * Queries the Database for the given Question
     *
     * @param Question_ID The Question_ID being searched for
     * @return The found Question
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Question query(int Question_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM Question WHERE Question_ID = ";
        Question returnQuestion = new Question();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + Question_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnQuestion.setQuestionID(Integer.parseInt(resultSet.getString(1)));
                returnQuestion.setQuestion(resultSet.getString(2));
                returnQuestion.setUserID(Integer.parseInt(resultSet.getString(3)));
                returnQuestion.setVotes(Integer.parseInt(resultSet.getString(4)));
                returnQuestion.setSubmitted(resultSet.getString(5));
                returnQuestion.setLastUpdated(resultSet.getString(6));
                returnQuestion.setTitle(resultSet.getString(7));
                returnQuestion.setVisits(Integer.parseInt(resultSet.getString(8)));
                returnQuestion.setAnswers(Integer.parseInt(resultSet.getString(9)));
                returnQuestion.setCourseID(Integer.parseInt(resultSet.getString(10)));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnQuestion;
    }

    /**
     * Deletes the given Question from the Database
     *
     * @param questionID The Question_ID of the Question to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int questionID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM Question WHERE Question_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + questionID);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Collects all Questions belonging to a User
     *
     * @param userID The user_ID of the User to be searched with
     * @return An ArrayList containing all Questions made by a User
     */
    public ArrayList<Question> getUserQuestion(int userID) {
        String SQLString = "SELECT * FROM Question WHERE User_ID = ";
        ArrayList<Question> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + userID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Question returnQuestion = new Question();
                returnQuestion.setQuestionID(Integer.parseInt(resultSet.getString(1)));
                returnQuestion.setQuestion(resultSet.getString(2));
                returnQuestion.setUserID(Integer.parseInt(resultSet.getString(3)));
                returnQuestion.setVotes(Integer.parseInt(resultSet.getString(4)));
                returnQuestion.setSubmitted(resultSet.getString(5));
                returnQuestion.setLastUpdated(resultSet.getString(6));
                returnQuestion.setTitle(resultSet.getString(7));
                returnQuestion.setVisits(Integer.parseInt(resultSet.getString(8)));
                returnQuestion.setAnswers(Integer.parseInt(resultSet.getString(9)));
                returnQuestion.setCourseID(Integer.parseInt(resultSet.getString(10)));
                returnList.add(returnQuestion);
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
     * Collects all Questions belonging to a given Course
     *
     * @param courseID The Course_ID of a given course to be searched
     * @return An ArrayList containing all Questions belonging to a Course
     */
    public ArrayList<Question> collectCourseQuestion(int courseID) {
        String SQLString = "SELECT * FROM Question WHERE Course_ID = ";
        ArrayList<Question> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + courseID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Question returnQuestion = new Question();
                returnQuestion.setQuestionID(Integer.parseInt(resultSet.getString(1)));
                returnQuestion.setQuestion(resultSet.getString(2));
                returnQuestion.setUserID(Integer.parseInt(resultSet.getString(3)));
                returnQuestion.setVotes(Integer.parseInt(resultSet.getString(4)));
                returnQuestion.setSubmitted(resultSet.getString(5));
                returnQuestion.setLastUpdated(resultSet.getString(6));
                returnQuestion.setTitle(resultSet.getString(7));
                returnQuestion.setVisits(Integer.parseInt(resultSet.getString(8)));
                returnQuestion.setAnswers(Integer.parseInt(resultSet.getString(9)));
                returnQuestion.setCourseID(Integer.parseInt(resultSet.getString(10)));
                returnList.add(returnQuestion);
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