/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.*;
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
public class UserDA {

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
     * Check to see if the given User is empty
     *
     * @param newAV the User to check
     * @return true if the given User is empty
     */
    private static boolean isEmpty(User newUser) {
        if (newUser == null) {
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

    private boolean exists(String username) throws ClassNotFoundException, IOException, SQLException {
        String SQLString = "SELECT * FROM User WHERE Username = \"" + username + "\"";
        User returnUser = new User();

        Connection connection = connectDB();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SQLString);
        ResultSetMetaData result = resultSet.getMetaData();
        int cn = result.getColumnCount();
        while (resultSet.next()) {
            returnUser.setUserID(Integer.parseInt(resultSet.getString(1)));
            returnUser.setUsername(resultSet.getString(2));
            return true;
        }
        connection.close();

        return false;
    }

    /**
     * Adds a new User to the database
     *
     * @param newUser New User to be added to the database
     * @return True if the User was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(User newUser) throws IOException, ClassNotFoundException, SQLException {

        if (!exists(newUser.getUsername())) {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String subDate = dateFormat.format(date);
            String sqlString = "INSERT into User VALUES ";
            String answerString = "(" + "null" + ", " + "\"" + newUser.getUsername() + seperateValue() + newUser.getPassword() + seperateValue() + newUser.getFirstName() + seperateValue() + newUser.getLastName() + seperateValue() + newUser.getEmailAddress() + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + subDate + seperateValue() + subDate + seperateValue() + newUser.getProfilePictureLink() + seperateValue() + newUser.getBiography() + seperateValue() + "Newbie" + seperateValue() + (newUser.isAnonymous() ? 1 : 0) + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + "0" + seperateValue() + "0" + "\")";

            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newUser)) {
                return false;
            }

            statement.executeUpdate(sqlString + answerString);
            connection.close();



            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the User object found in the database
     *
     * @param newUser The User to update in the database
     * @return True if the User was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(User newUser) throws IOException, ClassNotFoundException, SQLException {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String subDate = dateFormat.format(date);
        String sqlString = "Update User set Profile_Picture_Path = \"" + newUser.getProfilePictureLink() + "\", Last_Logged_In = \"" + subDate + "\", Number_Of_Questions = " + newUser.getNumberOfQuestions() + ", First_Name = \"" + newUser.getFirstName() + "\" , Last_Name = \"" + newUser.getLastName() + "\", Number_Of_Answers = " + newUser.getNumberOfAnswers() + ", Votes = " + newUser.getVotes() + ", Biography = \"" + newUser.getBiography() + "\", Rank = \"" + newUser.getRank() + "\", Anonymous = " + (newUser.isAnonymous() ? 1 : 0) + ", Gold_Count = " + newUser.getGoldCount() + ", Silver_Count = " + newUser.getSilverCount() + ", Bronze_Count = " + newUser.getBronzeCount() + ", Reputation = " + newUser.getReputation() + "  where User_ID = " + newUser.getUserID();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newUser)) {
                return false;
            }

            statement.executeUpdate(sqlString);
            connection.close();

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        return true;
    }

    /**
     * Queries the Database for the given User
     *
     * @param User_ID The User_ID being searched for
     * @return The found User
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User query(int User_ID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM User WHERE User_ID = ";
        User returnUser = new User();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + User_ID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnUser.setUserID(Integer.parseInt(resultSet.getString(1)));
                returnUser.setUsername(resultSet.getString(2));
                returnUser.setPassword(resultSet.getString(3));
                returnUser.setFirstName(resultSet.getString(4));
                returnUser.setLastName(resultSet.getString(5));
                returnUser.setEmailAddress(resultSet.getString(6));
                returnUser.setNumberOfQuestions(Integer.parseInt(resultSet.getString(7)));
                returnUser.setNumberOfAnswers(Integer.parseInt(resultSet.getString(8)));
                returnUser.setVotes(Integer.parseInt(resultSet.getString(9)));
                returnUser.setCreated(resultSet.getString(10));
                returnUser.setLastLoggedIn(resultSet.getString(11));
                returnUser.setProfilePictureLink(resultSet.getString(12));
                returnUser.setBiography(resultSet.getString(13));
                returnUser.setRank(resultSet.getString(14));
                returnUser.setAnonymous(resultSet.getBoolean(15));
                returnUser.setGoldCount(Integer.parseInt(resultSet.getString(16)));
                returnUser.setSilverCount(Integer.parseInt(resultSet.getString(17)));
                returnUser.setBronzeCount(Integer.parseInt(resultSet.getString(18)));
                returnUser.setReputation(Integer.parseInt(resultSet.getString(19)));
                returnUser.setHighestReputation(Integer.parseInt(resultSet.getString(20)));


            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnUser;
    }
    
    public int getTotalUsers() {
        String SQLString = "SELECT Count(*) FROM User ";
        int count=0;

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                count = Integer.parseInt(resultSet.getString(1));
            }


            connection.close();

        } catch (SQLException sqle) {
            return 0;
        } catch (ClassNotFoundException cnf) {
            return 0;
        } catch (IOException ioe) {
            return 0;
        }

        return count;

    }

    public ArrayList<User> collectUsersByRep(int startPosition, int questionAmount) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM User ORDER BY Reputation DESC LIMIT " + (questionAmount + startPosition);
        ArrayList<User> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                User returnUser = new User();
                returnUser.setUserID(Integer.parseInt(resultSet.getString(1)));
                returnUser.setUsername(resultSet.getString(2));
                returnUser.setPassword(resultSet.getString(3));
                returnUser.setFirstName(resultSet.getString(4));
                returnUser.setLastName(resultSet.getString(5));
                returnUser.setEmailAddress(resultSet.getString(6));
                returnUser.setNumberOfQuestions(Integer.parseInt(resultSet.getString(7)));
                returnUser.setNumberOfAnswers(Integer.parseInt(resultSet.getString(8)));
                returnUser.setVotes(Integer.parseInt(resultSet.getString(9)));
                returnUser.setCreated(resultSet.getString(10));
                returnUser.setLastLoggedIn(resultSet.getString(11));
                returnUser.setProfilePictureLink(resultSet.getString(12));
                returnUser.setBiography(resultSet.getString(13));
                returnUser.setRank(resultSet.getString(14));
                returnUser.setAnonymous(resultSet.getBoolean(15));
                returnUser.setGoldCount(Integer.parseInt(resultSet.getString(16)));
                returnUser.setSilverCount(Integer.parseInt(resultSet.getString(17)));
                returnUser.setBronzeCount(Integer.parseInt(resultSet.getString(18)));
                returnUser.setReputation(Integer.parseInt(resultSet.getString(19)));
                returnUser.setHighestReputation(Integer.parseInt(resultSet.getString(20)));
                returnList.add(returnUser);
            }

            for (int i = startPosition - 1; i >= 0; i--) {
                returnList.remove(i);
            }
            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    public ArrayList<User> collectUsersByOldest(int startPosition, int questionAmount) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM User ORDER BY Created ASC LIMIT " + (questionAmount + startPosition);
        ArrayList<User> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                User returnUser = new User();
                returnUser.setUserID(Integer.parseInt(resultSet.getString(1)));
                returnUser.setUsername(resultSet.getString(2));
                returnUser.setPassword(resultSet.getString(3));
                returnUser.setFirstName(resultSet.getString(4));
                returnUser.setLastName(resultSet.getString(5));
                returnUser.setEmailAddress(resultSet.getString(6));
                returnUser.setNumberOfQuestions(Integer.parseInt(resultSet.getString(7)));
                returnUser.setNumberOfAnswers(Integer.parseInt(resultSet.getString(8)));
                returnUser.setVotes(Integer.parseInt(resultSet.getString(9)));
                returnUser.setCreated(resultSet.getString(10));
                returnUser.setLastLoggedIn(resultSet.getString(11));
                returnUser.setProfilePictureLink(resultSet.getString(12));
                returnUser.setBiography(resultSet.getString(13));
                returnUser.setRank(resultSet.getString(14));
                returnUser.setAnonymous(resultSet.getBoolean(15));
                returnUser.setGoldCount(Integer.parseInt(resultSet.getString(16)));
                returnUser.setSilverCount(Integer.parseInt(resultSet.getString(17)));
                returnUser.setBronzeCount(Integer.parseInt(resultSet.getString(18)));
                returnUser.setReputation(Integer.parseInt(resultSet.getString(19)));
                returnUser.setHighestReputation(Integer.parseInt(resultSet.getString(20)));
                returnList.add(returnUser);
            }

            for (int i = startPosition - 1; i >= 0; i--) {
                returnList.remove(i);
            }
            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    public ArrayList<User> collectUsersByNewest(int startPosition, int questionAmount) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM User ORDER BY Created DESC LIMIT " + (questionAmount + startPosition);
        ArrayList<User> returnList = new ArrayList();

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                User returnUser = new User();
                returnUser.setUserID(Integer.parseInt(resultSet.getString(1)));
                returnUser.setUsername(resultSet.getString(2));
                returnUser.setPassword(resultSet.getString(3));
                returnUser.setFirstName(resultSet.getString(4));
                returnUser.setLastName(resultSet.getString(5));
                returnUser.setEmailAddress(resultSet.getString(6));
                returnUser.setNumberOfQuestions(Integer.parseInt(resultSet.getString(7)));
                returnUser.setNumberOfAnswers(Integer.parseInt(resultSet.getString(8)));
                returnUser.setVotes(Integer.parseInt(resultSet.getString(9)));
                returnUser.setCreated(resultSet.getString(10));
                returnUser.setLastLoggedIn(resultSet.getString(11));
                returnUser.setProfilePictureLink(resultSet.getString(12));
                returnUser.setBiography(resultSet.getString(13));
                returnUser.setRank(resultSet.getString(14));
                returnUser.setAnonymous(resultSet.getBoolean(15));
                returnUser.setGoldCount(Integer.parseInt(resultSet.getString(16)));
                returnUser.setSilverCount(Integer.parseInt(resultSet.getString(17)));
                returnUser.setBronzeCount(Integer.parseInt(resultSet.getString(18)));
                returnUser.setReputation(Integer.parseInt(resultSet.getString(19)));
                returnUser.setHighestReputation(Integer.parseInt(resultSet.getString(20)));
                returnList.add(returnUser);
            }

            for (int i = startPosition - 1; i >= 0; i--) {
                returnList.remove(i);
            }
            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnList;
    }

    /**
     * Deletes the given User from the Database
     *
     * @param user The user_ID of the User to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int userID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM User WHERE User_ID = ";
        User returnUser = new User();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + userID);


            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }

    /**
     * Updates the User object found in the database
     *
     * @param newUser The User to update in the database
     * @return True if the User was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean incrementGold(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Gold_Count = \"" + (me.getGoldCount() + 1) + "\"  where User_ID = " + userID;

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

    public boolean decrementGold(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Gold_Count = \"" + (me.getGoldCount() - 1) + "\"  where User_ID = " + userID;

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

    public boolean incrementSilver(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Silver_Count = \"" + (me.getSilverCount() + 1) + "\"  where User_ID = " + userID;

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

    public boolean decrementSilver(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Silver_Count = \"" + (me.getSilverCount() - 1) + "\"  where User_ID = " + userID;

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

    public boolean incrementBronze(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Bronze_Count = \"" + (me.getBronzeCount() + 1) + "\"  where User_ID = " + userID;

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

    public boolean decrementBronze(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Bronze_Count = \"" + (me.getBronzeCount() - 1) + "\"  where User_ID = " + userID;

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

    public boolean incrementQuestions(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Number_Of_Questions = \"" + (me.getNumberOfQuestions() + 1) + "\"  where User_ID = " + userID;

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

    public boolean decrementQuestions(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Number_Of_Questions = \"" + (me.getNumberOfQuestions() - 1) + "\"  where User_ID = " + userID;

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

    public boolean incrementAnswers(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Number_Of_Answers = \"" + (me.getNumberOfAnswers() + 1) + "\"  where User_ID = " + userID;

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

    public boolean decrementAnswers(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Number_Of_Answers = \"" + (me.getNumberOfAnswers() - 1) + "\"  where User_ID = " + userID;

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

    public boolean incrementVotes(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Votes = \"" + (me.getVotes() + 1) + "\"  where User_ID = " + userID;

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

    public boolean decrementVotes(int userID) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Votes = \"" + (me.getVotes() - 1) + "\"  where User_ID = " + userID;

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

    public User increaseReputation(int userID, int increaseAmount) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString;
        int newRep = me.getReputation() + increaseAmount;
        if(me.getHighestReputation() > newRep){
        sqlString = "Update User set Reputation = \"" + (newRep) + "\"  where User_ID = " + userID;
        }else{
            sqlString = "Update User set Reputation = \"" + (newRep) + "\", Highest_Reputation = \"" + newRep + "\"  where User_ID = " + userID;
            
        }
        me.setReputation(me.getReputation()+increaseAmount);
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(sqlString);
            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return me;
    }

    public boolean decreaseReputation(int userID, int decreaseAmount) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Reputation = \"" + (me.getReputation() - decreaseAmount) + "\"  where User_ID = " + userID;

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

    public boolean updateRank(int userID, String newRank) throws IOException, ClassNotFoundException, SQLException {

        User me = query(userID);
        String sqlString = "Update User set Rank = \"" + newRank + "\"  where User_ID = " + userID;

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
