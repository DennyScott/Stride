/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.Badge;
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
public class BadgeDA {

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
     * Check to see if the given Badge is empty
     *
     * @param newAV the Badge to check
     * @return true if the given Badge is empty
     */
    private static boolean isEmpty(Badge newBadge) {
        if (newBadge == null) {
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
     * Adds a new Badge to the database
     *
     * @param newBadge New Badge to be added to the database
     * @return True if the Badge was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(Badge newBadge) throws IOException, ClassNotFoundException, SQLException {

        String sqlString = "INSERT into Badge VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newBadge.getColor() + seperateValue() + newBadge.getName() + seperateValue() + newBadge.getCount() + seperateValue() + newBadge.getDescription() + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newBadge)) {
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
     * Updates the Badge object found in the database
     *
     * @param newBadge The Badge to update in the database
     * @return True if the Badge was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(Badge newBadge) throws IOException, ClassNotFoundException, SQLException {

        String sqlString = "Update Badge set Color = \"" + newBadge.getColor() + "\", Name = \"" + newBadge.getName() + "\", Count = \"" + newBadge.getCount() + "\", Description = \"" + newBadge.getDescription() + "\" where Badge_ID = " + newBadge.getBadgeID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newBadge)) {
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
     * Queries the Database for the given Badge
     *
     * @param badgeID The Badge_ID being searched for
     * @return The found Badge
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Badge query(int badgeID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM Badge WHERE Badge_ID = ";
        Badge findBadge = new Badge();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + badgeID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                findBadge.setBadgeID(Integer.parseInt(resultSet.getString(1)));
                findBadge.setColor(Integer.parseInt(resultSet.getString(2)));
                findBadge.setName(resultSet.getString(3));
                findBadge.setCount(Integer.parseInt(resultSet.getString(4)));
                findBadge.setDescription(resultSet.getString(5));

            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return findBadge;
    }

    /**
     * Deletes the given Badge from the Database
     *
     * @param badgeID The badgeID of the Badge to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int badgeID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM Badge WHERE Badge_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + badgeID);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
}
