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
import java.util.ArrayList;

/**
 *
 * @author Travis
 */
public class TagDA {

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

    public boolean exists(String tagName) throws ClassNotFoundException, IOException {
        String SQLString = "SELECT * FROM Tag WHERE Title = ";
        Tag returnTag = new Tag();
        int tagID = 0;
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + "\"" + (tagName.toLowerCase()) + "\"");
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                return true;
            }


            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return false;
    }

    /**
     * Check to see if the given Tag is empty
     *
     * @param newAV the Tag to check
     * @return true if the given Tag is empty
     */
    private static boolean isEmpty(Tag newTag) {
        if (newTag == null) {
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
     * Adds a new Tag Link to the database
     *
     * @param newTag New Tag to be added to the database
     * @return True if the Tag was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int add(Tag newTag) throws IOException, ClassNotFoundException, SQLException {
        int id = 0;
        if (exists(newTag.getTitle())) {
            Tag foundTag = this.queryTitle(newTag.getTitle());
            int changeNum = foundTag.getCount();
            changeNum++;
            foundTag.setCount(changeNum);
            update(foundTag);
            return foundTag.getTagID();
        } else {
            String sqlString = "INSERT into Tag VALUES ";
            String answerString = "(" + "null" + ", " + "\"" + newTag.getTitle() + seperateValue() + newTag.getDescription() + seperateValue() + "1" + "\")";

            try {
                Connection connection = connectDB();

                Statement statement = connection.createStatement();

                if (isEmpty(newTag)) {
                    return 0;
                }

                statement.executeUpdate(sqlString + answerString, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = statement.getGeneratedKeys();

                while (rs.next()) {
                    id = rs.getInt(1);
                }
                connection.close();

            } catch (SQLException sqle) {
                return 0;
            }

            return id;
        }
    }

    /**
     * Updates the Tag object found in the database
     *
     * @param newTag The Tag to update in the database
     * @return True if the Tag was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(Tag newTag) throws IOException, ClassNotFoundException, SQLException {

        String sqlString = "Update Tag set Title = \"" + newTag.getTitle() + "\", Description = \"" + newTag.getDescription() + "\" where Tag_ID = " + newTag.getTagID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newTag)) {
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
     * Queries the Database for the given Tag
     *
     * @param tagID The Tag_ID being searched for
     * @return The found Tag
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Tag query(int tagID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM Tag WHERE Tag_ID = ";
        Tag returnTag = new Tag();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + tagID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnTag.setTagID(Integer.parseInt(resultSet.getString(1)));
                returnTag.setTitle(resultSet.getString(2));
                returnTag.setDescription(resultSet.getString(3));
                returnTag.setCount(Integer.parseInt(resultSet.getString(4)));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnTag;
    }
    
    public int totalTags() throws IOException, ClassNotFoundException, SQLException {

        int returnNum = 0;
        String SQLString = "SELECT COUNT(*) FROM Tag";
        Tag returnTag = new Tag();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
               returnNum = Integer.parseInt(resultSet.getString(1));
            }


            connection.close();

        } catch (SQLException sqle) {
            return 0;
        }

        return returnNum;
    }

    public ArrayList<Tag> collectAllTags(int startPosition, int totalAmount) throws IOException, ClassNotFoundException, SQLException {

        ArrayList<Tag> returnList = new ArrayList();
        String SQLString = "SELECT * FROM Tag ORDER BY Count DESC LIMIT " + (totalAmount + startPosition);
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Tag returnTag = new Tag();
                returnTag.setTagID(Integer.parseInt(resultSet.getString(1)));
                returnTag.setTitle(resultSet.getString(2));
                returnTag.setDescription(resultSet.getString(3));
                returnTag.setCount(Integer.parseInt(resultSet.getString(4)));
                returnList.add(returnTag);
            }


            connection.close();

            while (returnList.size() > totalAmount) {
                returnList.remove(0);
            }

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    public ArrayList<Tag> collectRecentTags(int userID, ArrayList<Question> questions) throws IOException, ClassNotFoundException, SQLException {

        ArrayList<Tag> returnList = new ArrayList();
        String SQLString = "SELECT * FROM Tag WHERE Title = ";
        TagLinkDA tl = new TagLinkDA();
        try {
            for (Question q : questions) {
                Tag returnTag = new Tag();
                ArrayList<Tag> tempTags = tl.collectQuestionTags(q.getQuestionID());

                for (Tag t : tempTags) {
                    boolean found = false;
                    for (int i = 0; i < returnList.size(); i++) {
                        if (returnList.get(i).getTitle().equals(t.getTitle())) {
                            found = true;

                        }
                    }
                    if(!found){
                        returnList.add(t);
                    }
                }
            } //ADD ANSWERS HERE IF WANTED LATER

            while (returnList.size() > 10) {
                returnList.remove(returnList.size() - 1);
            }

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Deletes the given Tag from the Database
     *
     * @param tagID The Tag_ID of the Tag to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int tagID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM Tag WHERE Tag_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + tagID);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Queries the Database for the given Tag
     *
     * @param tagID The Tag_ID being searched for
     * @return The found Tag
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Tag queryTitle(String title) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM Tag WHERE Title = ";
        Tag returnTag = new Tag();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + "\"" + title + "\"");
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnTag.setTagID(Integer.parseInt(resultSet.getString(1)));
                returnTag.setTitle(resultSet.getString(2));
                returnTag.setDescription(resultSet.getString(3));
                returnTag.setCount(Integer.parseInt(resultSet.getString(4)));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnTag;
    }

    /**
     * Updates the Tag object found in the database
     *
     * @param newTag The Tag to update in the database
     * @return True if the Tag was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean incrementCount(int tagID) throws IOException, ClassNotFoundException, SQLException {

        Tag found = query(tagID);
        String sqlString = "Update Tag set Count = \"" + (found.getCount() + 1) + "\" where Tag_ID = " + tagID;
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

    public boolean decrementCount(int tagID) throws IOException, ClassNotFoundException, SQLException {

        Tag found = query(tagID);
        String sqlString = "Update Tag set Count = \"" + (found.getCount() - 1) + "\" where Tag_ID = " + tagID;
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
