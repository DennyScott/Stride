/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.Tag;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Travis
 */
public class TagModel {

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
    public boolean add(Tag newTag) throws IOException, ClassNotFoundException, SQLException {

        String sqlString = "INSERT into Tag VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newTag.getTitle() + seperateValue() + newTag.getDescription() + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newTag)) {
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
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnTag;
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
}
