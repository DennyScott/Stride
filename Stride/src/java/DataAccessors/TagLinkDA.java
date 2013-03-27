/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.Question;
import ModelObjects.Tag;
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
public class TagLinkDA {

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

    public boolean exists(int questionID, int tagID) throws IOException, ClassNotFoundException, SQLException {
        String sqlString = "SELECT * FROM TagLink WHERE Question_ID = " + questionID + " AND Tag_ID = " + tagID;

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();

            try {
                int testInt;
                while (resultSet.next()) {
                    testInt = (Integer.parseInt(resultSet.getString(1)));
                    return true;
                }

            } catch (Exception e) {
                return false;
            }
            connection.close();
        } catch (SQLException sqle) {
            return false;
        }



        return false;

    }

    /**
     * Adds a new Question-Tag Link to the database
     *
     * @param questionID New Question to be added to the database
     * @param tagID New TagID to be added to database
     * @return True if the Question-Tag Link was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(int questionID, int tagID) throws IOException, ClassNotFoundException, SQLException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into TagLink VALUES ";
        String answerString = "(\"" + questionID + seperateValue() + tagID + seperateValue() + subDate + "\")";

        try {
            if (!exists(questionID, tagID)) {
                Connection connection = connectDB();

                Statement statement = connection.createStatement();

                statement.executeUpdate(sqlString + answerString);
                connection.close();
            }

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Collects all Tags within a given Question
     *
     * @param Question_ID The Question_ID of the searched Question
     * @return An ArrayList containing all the Tags of a given Question
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Tag> collectQuestionTags(int Question_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM TagLink WHERE Question_ID = ";
        ArrayList<Tag> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + Question_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Tag returnTag = new Tag();
                returnTag.setTagID(Integer.parseInt(resultSet.getString(2)));
                returnList.add(returnTag);
            }
            TagDA findTag = new TagDA();
            for (int i = 0; i < returnList.size(); i++) {
                returnList.set(i, findTag.query(returnList.get(i).getTagID()));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }
    
    public ArrayList<Tag> collectTagRecentQuestions(int tagID, int startPosition, int totalAmount) throws IOException, ClassNotFoundException, SQLException {

        ArrayList<Tag> returnList = new ArrayList();
        String SQLString = "SELECT * FROM TagLink WHERE tagID = " + tagID + "ORDER BY Last_Updated DESC LIMIT " + (totalAmount + startPosition);
        TagLinkDA tl = new TagLinkDA();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Tag returnTag = new Tag();
                returnTag.setTagID(Integer.parseInt(resultSet.getString(2)));
                returnList.add(returnTag);
            }
            TagDA findTag = new TagDA();
            for (int i = 0; i < returnList.size(); i++) {
                returnList.set(i, findTag.query(returnList.get(i).getTagID()));
            }


            connection.close();

            while (returnList.size() > 10) {
                returnList.remove(returnList.size() - 1);
            }

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Collects all Questions that contain a given Tag
     *
     * @param tagID The ID of the Tag being searched for
     * @return An ArrayList containing all Questions with a given Tag
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Question> collectTagQuestions(int tagID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM TagLink WHERE Tag_ID = ";
        ArrayList<Question> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + tagID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Question returnQuestion = new Question();
                returnQuestion.setQuestionID(Integer.parseInt(resultSet.getString(1)));
                returnList.add(returnQuestion);
            }

            QuestionDA findModel = new QuestionDA();
            for (int i = 0; i < returnList.size(); i++) {
                returnList.set(i, findModel.query(returnList.get(i).getQuestionID()));
            }



            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

/**
 * Collect recent tags that have been submitted
 * @param tagsReturned The amount of tags to be returned
 * @return An array list of recent tags
 * @throws IOException
 * @throws ClassNotFoundException
 * @throws SQLException 
 */
    public ArrayList<Tag> collectRecentTags(int tagsReturned) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM TagLink ORDER BY Submitted DESC LIMIT " + tagsReturned;
        ArrayList<Tag> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Tag returnTag = new Tag();
                returnTag.setTagID(Integer.parseInt(resultSet.getString(2)));
                returnList.add(returnTag);
            }

            TagDA findTag = new TagDA();
            for (int i = 0; i < returnList.size(); i++) {
                returnList.set(i, findTag.query(returnList.get(i).getTagID()));
            }



            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Deletes the given Question-Tag Link from the Database
     *
     * @param questionID The questionID of the Question-Tag to delete
     * @param tagID The TagID of the Question-Tag to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int questionID, int tagID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM TagLink WHERE Tag_ID = ";
        String SQLStringTwo = "AND Question_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + tagID + SQLStringTwo + questionID);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
}
