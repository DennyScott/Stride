/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.Badge;
import ModelObjects.BadgeCollected;
import ModelObjects.RecentBadge;
import ModelObjects.User;
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
public class BadgeCollectedDA {

    
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

    public boolean exists(int userID, int badgeID) throws IOException, ClassNotFoundException, SQLException {
        String sqlString = "SELECT * FROM BadgeCollected WHERE User_ID = " + userID + " AND Badge_ID = " + badgeID;

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
     * Adds a new BadgeCollected to the database
     *
     * @param bc New BadgeCollected to be added to the database
     * @return True if the BadgeCollected was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(BadgeCollected bc) throws IOException, ClassNotFoundException, SQLException {


        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "INSERT into BadgeCollected VALUES ";
        String answerString = "(\"" + bc.getUserID() + seperateValue() + bc.getBadgeID() + seperateValue() + subDate + "\")";

        try {
            if (!(exists(bc.getUserID(), bc.getBadgeID()))) {
                Connection connection = connectDB();

                Statement statement = connection.createStatement();

                //ResultSet resultSet = statement.executeQuery("SELECT * From Tag WHERE " + Comment_ID);


                statement.executeUpdate(sqlString + answerString);
                connection.close();
            }
        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Queries the database for the wanted BadgeCollected
     *
     * @param badgeID The badge_ID to be searched for
     * @param userID The User_ID to be searched for
     * @return The found BadgeCollected
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public BadgeCollected query(int badgeID, int userID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM BadgeCollected WHERE Badge_ID = " + badgeID + " AND User_ID = " + userID;
        BadgeCollected findBadge = new BadgeCollected();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                findBadge.setSubmitted(resultSet.getString(3));

            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return findBadge;
    }
    
     /**
     * Collects Badges that a given User has
     *
     * @param user_ID The User_ID of a User to find the Badges of
     * @return An ArrayList of All Badges belonging to a User
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Badge> collectRecentUserBadges(int user_ID, int startPosition, int totalAmount) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM BadgeCollected WHERE User_ID = " + user_ID + " ORDER BY Submitted DESC LIMIT " + (totalAmount + startPosition);
        ArrayList<Badge> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Badge returnBadge = new Badge();
                returnBadge.setBadgeID(Integer.parseInt(resultSet.getString(2)));

                returnList.add(returnBadge);
            }
            connection.close();
            BadgeDA findBadges = new BadgeDA();
            for (int i = 0; i < returnList.size(); i++) {
                returnList.set(i, findBadges.query(returnList.get(i).getBadgeID()));
            }

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }
    
        /**
     * Returns a given amount of recent badges
     * @param badgeReturned The amount of recent badge wanted
     * @return The most recent badges in the database
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public ArrayList<RecentBadge> collectRecentBadges(int badgeReturned) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM BadgeCollected ORDER BY Submitted DESC LIMIT " + badgeReturned;
        ArrayList<RecentBadge> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                RecentBadge returnBadge = new RecentBadge();
                returnBadge.setUserID(Integer.parseInt(resultSet.getString(1)));
                returnBadge.setBadgeID(Integer.parseInt(resultSet.getString(2)));
                returnBadge.setSubmission(resultSet.getString(3));
                returnList.add(returnBadge);
            }



            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Collects Badges that a given User has
     *
     * @param user_ID The User_ID of a User to find the Badges of
     * @return An ArrayList of All Badges belonging to a User
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Badge> collectBadges(int user_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM BadgeCollected WHERE User_ID = ";
        ArrayList<Badge> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + user_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                Badge returnBadge = new Badge();
//                returnBadge.setBadgeID(Integer.parseInt(resultSet.getString(1)));
//                returnBadge.setColor(resultSet.getString(2));
//                returnBadge.setName(resultSet.getString(3));
//                returnBadge.setCount(Integer.parseInt(resultSet.getString(4)));
//                returnBadge.setDescription(resultSet.getString(5));
                returnBadge.setBadgeID(Integer.parseInt(resultSet.getString(2)));

                returnList.add(returnBadge);
            }


            connection.close();

            BadgeDA findBadges = new BadgeDA();
            for (int i = 0; i < returnList.size(); i++) {
                returnList.set(i, findBadges.query(returnList.get(i).getBadgeID()));
            }


        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Collects all Users who have a given Badge
     *
     * @param badgeID The badge ID of a badge to search with
     * @return An ArrayList of Users who have a given Badge
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<User> collectUsers(int badgeID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM BadgeCollected WHERE Badge_ID = ";
        ArrayList<User> returnList = new ArrayList();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + badgeID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                User returnUser = new User();
                returnUser.setUserID(Integer.parseInt(resultSet.getString(1)));
                returnList.add(returnUser);
            }
            connection.close();

            //Replaces the User with only an ID with an entire User object
            UserDA findUsers = new UserDA();
            for (int i = 0; i < returnList.size(); i++) {
                returnList.set(i, findUsers.query(returnList.get(i).getUserID()));
            }



        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Deletes the given BadgeCollected from the Database
     *
     * @param userID The userID of the BadgeCollected to delete
     * @param badgeID The badgeID of the BadgeCollected to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int userID, int badgeID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM BadgeCollected WHERE User_ID = ";
        String SQLStringTwo = "AND Badge_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + userID + SQLStringTwo + badgeID);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
}
