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
public class RecentModel {

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
     * Separates values being added to the database
     *
     * @return The String used to separates values
     */
    private static String seperateValue() {
        return "\"" + ", " + "\"";
    }

    public boolean exists(int questionID) throws IOException, ClassNotFoundException, SQLException {
        String sqlString = "SELECT * FROM Recent WHERE Question_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlString + questionID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();

            try {
                int testInt;
                while (resultSet.next()) {
                    testInt = (Integer.parseInt(resultSet.getString(1)));
                    return true;
                }
                connection.close();
            } catch (Exception e) {
                return false;
            }

        } catch (SQLException sqle) {
            return false;
        }



        return false;

    }

    /**
     * Adds a new Question to the database
     *
     * @param questionID New Question to be added to the database
     * @return True if the Question was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(int questionID) throws IOException, ClassNotFoundException, SQLException {

        if (exists(questionID)) {
            return update(questionID);
        } else {


            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String sqlString = "INSERT into Recent VALUES ";
            String answerString = "(" + "\"" + questionID + seperateValue() + dateFormat.format(date) + "\")";

            try {
                Connection connection = connectDB();

                Statement statement = connection.createStatement();

                statement.executeUpdate(sqlString + answerString);
                connection.close();

            } catch (SQLException sqle) {
                return false;
            }

            return true;
        }
    }

    /**
     * Updates the Recent Table found in the database
     *
     * @param questionID The Question in Recent to update in the database
     * @return True if the Recent Table was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(int questionID) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String sqlString = "Update Recent set Last_Updated = \"" + dateFormat.format(date) + "\" where Question_ID = " + questionID;
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
     * Collects All recent questions to and from the given amounts
     *
     * @param startPosition Where to start in the list of questions
     * @param questionAmount The amount of questions to return
     * @return An ArrayList of Questions found in the Query
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Question> collectQuestions(int startPosition, int questionAmount) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM Recent LIMIT " + questionAmount;
        ArrayList<Question> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Question findQuestion = new Question();
                findQuestion.setQuestionID(Integer.parseInt(resultSet.getString(1)));
                returnList.add(findQuestion);
            }

            for (int i = startPosition - 1; i >= 0; i--) {
                returnList.remove(i);
            }

            QuestionModel findQuestion = new QuestionModel();
            for (int x = 0; x < returnList.size(); x++) {
                returnList.set(x, findQuestion.query(returnList.get(x).getQuestionID()));
            }






            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Deletes the given Recent Question from the Database
     *
     * @param questionID The Recent Question to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int questionID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM Recent WHERE Question_ID = ";

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
}
