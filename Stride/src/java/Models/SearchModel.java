/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.CourseDA;
import DataAccessors.QuestionDA;
import DataAccessors.UserDA;
import ModelObjects.Course;
import ModelObjects.Question;
import ModelObjects.QuestionSearchNode;
import ModelObjects.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Travis
 */
public class SearchModel {

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

    public ArrayList<Question> searchKeyword(String search) throws ClassNotFoundException, IOException {
        ArrayList<Question> returnList = new ArrayList<Question>();
        ArrayList<QuestionSearchNode> qsnArray = new ArrayList<QuestionSearchNode>();
        if (!search.isEmpty()) {
            String[] tokens = search.split("\\s+");
            ArrayList<Question> questions = collectQuestions(tokens);
            for (String s : tokens) {
                qsnArray = scoreQuestions(questions, s);
            }
           qsnArray = sortQuestions(qsnArray);
           
           for(QuestionSearchNode qsn : qsnArray){
               returnList.add(qsn.getFoundQuestion());
           }


        }
        return returnList;
    }

    private ArrayList<QuestionSearchNode> sortQuestions(ArrayList<QuestionSearchNode> questions) {
        ArrayList<QuestionSearchNode> returnList = new ArrayList<QuestionSearchNode>();


        while (questions.size() > 0) {
            QuestionSearchNode foundNode = new QuestionSearchNode();
            int indexInt = 0;
            for (int i = 0; i < questions.size(); i++) {
                QuestionSearchNode qsn = questions.get(i);
                if (qsn.getPopularity() >= foundNode.getPopularity()) {
                    foundNode = qsn;
                    indexInt = i;
                }
            }
            returnList.add(foundNode);
            questions.remove(indexInt);
        }
        return returnList;
    }

    private ArrayList<QuestionSearchNode> scoreQuestions(ArrayList<Question> questions, String word) {
        ArrayList<QuestionSearchNode> searchList = new ArrayList<QuestionSearchNode>();
        for (Question q : questions) {
            boolean found = false;
            QuestionSearchNode foundNode = new QuestionSearchNode();
            for (QuestionSearchNode check : searchList) {
                if (check.getFoundQuestion().getQuestionID() == q.getQuestionID()) {
                    found = true;
                    foundNode = check;
                }
            }
            if (!found) {
                QuestionSearchNode qsn = new QuestionSearchNode();
                qsn.setFoundQuestion(q);
                qsn.increasePopularity(scoreString(q.getTitle(), word));
                qsn.increasePopularity(scoreString(q.getQuestion(), word));
                qsn.increasePopularity(scoreCourse(q.getCourseID(), word));
                qsn.increasePopularity(scoreUser(q.getUserID(), word));
                searchList.add(qsn);
            } else {
                foundNode.increasePopularity(scoreString(q.getTitle(), word));
                foundNode.increasePopularity(scoreString(q.getQuestion(), word));
                foundNode.increasePopularity(scoreCourse(q.getCourseID(), word));
                foundNode.increasePopularity(scoreUser(q.getUserID(), word));
            }
        }
        return searchList;
    }

    private int scoreString(String scoreString, String word) {
        int index = 0;
        int returnInt = 0;
        while (index >= 0 && index < scoreString.length()) {
            index = scoreString.indexOf(word, index);
            returnInt++;
            if(index != -1){
                index++;
            }
        }
        return returnInt;
    }

    private int scoreCourse(int courseid, String word) {
        try {
            CourseDA cda = new CourseDA();
            Course foundCourse = cda.query(courseid);
            int returnInt = 0;
            returnInt += scoreString(foundCourse.getDescription(), word);
            returnInt += scoreString(foundCourse.getName(), word);

            return returnInt;

        } catch (IOException ex) {
            Logger.getLogger(SearchModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    private int scoreUser(int userID, String word) {
        try {
            UserDA uda = new UserDA();
            User foundUser = uda.query(userID);

            int returnInt = 0;
            returnInt += scoreString(foundUser.getUsername(), word);
            returnInt += scoreString(foundUser.getFirstName(), word);
            returnInt += scoreString(foundUser.getLastName(), word);

            return returnInt;

        } catch (IOException ex) {
            Logger.getLogger(SearchModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private ArrayList<Question> collectQuestions(String[] tokens) throws ClassNotFoundException, IOException {
        String sqlAddition = "TITLE LIKE \"%" + tokens[0] + "%\"";
        int i = 1;
        while (i < tokens.length) {
            sqlAddition += " OR TITLE LIKE \"%" + tokens[i] + "%\"";
            i++;
        }

        String SQLString = "SELECT * FROM Question WHERE " + sqlAddition + " ORDER BY Last_Updated DESC LIMIT " + 10;
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

            QuestionDA findQuestion = new QuestionDA();
            for (int x = 0; x < returnList.size(); x++) {
                returnList.set(x, findQuestion.query(returnList.get(x).getQuestionID()));
            }
            connection.close();
            return returnList;
        } catch (SQLException sqle) {
            return null;
        }
    }
}
