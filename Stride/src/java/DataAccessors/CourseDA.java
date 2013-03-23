/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessors;

import ModelObjects.Course;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Data Accessor For the Course Table
 * @author Travis
 */
public class CourseDA {

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
     * Check to see if the given Course is empty
     *
     * @param newAV the Course to check
     * @return true if the given Course is empty
     */
    private static boolean isEmpty(Course newCourse) {
        if (newCourse == null) {
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
     * Adds a new Course to the database
     *
     * @param newCourse New Course to be added to the database
     * @return True if the Course was successfully added
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean add(Course newCourse) throws IOException, ClassNotFoundException, SQLException {
        String sqlString = "INSERT into Course VALUES ";
        String answerString = "(" + "null" + ", " + "\"" + newCourse.getName() + seperateValue() + "0" + seperateValue() + newCourse.getDescription() + "\")";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newCourse)) {
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
     * Updates the Course object found in the database
     *
     * @param newCourse The Course to update in the database
     * @return True if the Course was updated correctly
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(Course newCourse) throws IOException, ClassNotFoundException, SQLException {

        String sqlString = "Update Course set Name = \"" + newCourse.getName() + "\", Questions_Total = \"" + newCourse.getQuestionsTotal() + "\", Description = \"" + newCourse.getDescription() + "\" where Course_ID = " + newCourse.getCourseID();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            if (isEmpty(newCourse)) {
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
     * Queries the Database for the given Course
     *
     * @param courseID The course_ID being searched for
     * @return The found Course
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Course query(int courseID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "SELECT * FROM Course WHERE Course_ID = ";
        Course returnCourse = new Course();
        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQLString + courseID);
            ResultSetMetaData result = resultSet.getMetaData();
            int cn = result.getColumnCount();
            while (resultSet.next()) {
                returnCourse.setCourseID(Integer.parseInt(resultSet.getString(1)));
                returnCourse.setName(resultSet.getString(2));
                returnCourse.setQuestionsTotal(Integer.parseInt(resultSet.getString(3)));
                returnCourse.setDescription(resultSet.getString(4));
            }


            connection.close();

        } catch (SQLException sqle) {
            return null;
        }

        return returnCourse;
    }

    /**
     * Deletes the given Course from the Database
     *
     * @param courseID The courseID of the Course to delete
     * @return true if the entry was deleted
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int courseID) throws IOException, ClassNotFoundException, SQLException {

        String SQLString = "DELETE FROM Course WHERE Course_ID = ";

        try {
            Connection connection = connectDB();

            Statement statement = connection.createStatement();

            statement.executeUpdate(SQLString + courseID);

            connection.close();

        } catch (SQLException sqle) {
            return false;
        }

        return true;
    }
}
