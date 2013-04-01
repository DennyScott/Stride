/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.BountyTrans;
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
public class BountyTransDA {

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

    public int add(BountyTrans newBounty) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into BountyTransaction VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newBounty.getQuestionID() + seperateValue() + newBounty.getOwnerID() + seperateValue() + newBounty.getUserID() + seperateValue() + newBounty.getBounty() + seperateValue() + subDate + "\")";
        int id = 0;
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(sqlString + answerString, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return 0;
        }


        return id;
    }

    public ArrayList<Question> collectRecentUserQuestions(int userID, int startPosition, int totalAmount) {
        String SQLString = "SELECT * FROM BountyTransaction WHERE User_ID = " + userID + " ORDER BY Last_Updated DESC LIMIT " + (totalAmount + startPosition);
        ArrayList<Question> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
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
                returnQuestion.setAnswered(Integer.parseInt(resultSet.getString(11)) == 0 ? true : false);
                returnQuestion.setBounty(Integer.parseInt(resultSet.getString(12)));
                returnList.add(returnQuestion);
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
     * Queries the Database for the given Question
     *
     * @param Question_ID The Question_ID being searched for
     * @return The found Question
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public BountyTrans query(int Question_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM BountyTransaction WHERE Question_ID = ";
        BountyTrans returnTrans = new BountyTrans();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + Question_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnTrans.setBountyID(Integer.parseInt(resultSet.getString(1)));
                returnTrans.setQuestionID(Integer.parseInt(resultSet.getString(2)));
                returnTrans.setOwnerID(Integer.parseInt(resultSet.getString(3)));
                returnTrans.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnTrans.setBounty(Integer.parseInt(resultSet.getString(5)));
                returnTrans.setTimeCollected(resultSet.getString(6));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnTrans;
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

        String SQLString = "DELETE FROM BountyTransaction WHERE Question_ID = ";

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

    public ArrayList<BountyTrans> getUserRecentBounties(int userID, int startPosition, int totalAmount) {
        String SQLString = "SELECT * FROM BountyTransaction WHERE User_ID = " + userID + " ORDER BY Last_Updated DESC LIMIT " + (totalAmount + startPosition);
        ArrayList<BountyTrans> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                BountyTrans returnTrans = new BountyTrans();
                returnTrans.setBountyID(Integer.parseInt(resultSet.getString(1)));
                returnTrans.setQuestionID(Integer.parseInt(resultSet.getString(2)));
                returnTrans.setOwnerID(Integer.parseInt(resultSet.getString(3)));
                returnTrans.setUserID(Integer.parseInt(resultSet.getString(4)));
                returnTrans.setBounty(Integer.parseInt(resultSet.getString(5)));
                returnTrans.setTimeCollected(resultSet.getString(6));
                returnList.add(returnTrans);
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
}
