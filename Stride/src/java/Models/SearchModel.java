/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.CourseDA;
import DataAccessors.UserDA;
import ModelObjects.Course;
import ModelObjects.Question;
import ModelObjects.QuestionSearchNode;
import ModelObjects.Tag;
import ModelObjects.TagSearchNode;
import ModelObjects.User;
import ModelObjects.UserSearchNode;
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

            for (QuestionSearchNode qsn : qsnArray) {
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
            if (index != -1) {
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
                findQuestion.setQuestion(resultSet.getString(2));
                findQuestion.setUserID(Integer.parseInt(resultSet.getString(3)));
                findQuestion.setVotes(Integer.parseInt(resultSet.getString(4)));
                findQuestion.setSubmitted(resultSet.getString(5));
                findQuestion.setLastUpdated(resultSet.getString(6));
                findQuestion.setTitle(resultSet.getString(7));
                findQuestion.setVisits(Integer.parseInt(resultSet.getString(8)));
                findQuestion.setAnswers(Integer.parseInt(resultSet.getString(9)));
                findQuestion.setCourseID(Integer.parseInt(resultSet.getString(10)));
                findQuestion.setAnswered(Integer.parseInt(resultSet.getString(11)) == 1 ? true : false);
                returnList.add(findQuestion);
            }
            connection.close();
            return returnList;
        } catch (SQLException sqle) {
            return null;
        }
    }

    public ArrayList<Tag> searchTag(String search) throws ClassNotFoundException, IOException {
        ArrayList<Tag> returnList = new ArrayList<Tag>();
        ArrayList<TagSearchNode> tsnArray = new ArrayList<TagSearchNode>();
        if (!search.isEmpty()) {
            String[] tokens = search.split("\\s+");
            ArrayList<Tag> tags = collectTags(tokens);
            for (String s : tokens) {
                tsnArray = scoreTags(tags, s);
            }
            tsnArray = sortTags(tsnArray);

            for (TagSearchNode tsn : tsnArray) {
                returnList.add(tsn.getTag());
            }
        }
        return returnList;
    }

    public ArrayList<User> searchUser(String search) throws ClassNotFoundException, IOException {
        ArrayList<User> returnList = new ArrayList<User>();
        ArrayList<UserSearchNode> usnArray = new ArrayList<UserSearchNode>();
        if (!search.isEmpty()) {
            String[] tokens = search.split("\\s+");
            ArrayList<User> users = collectUsers(tokens);
            for (String s : tokens) {
                usnArray = scoreUsers(users, s);
            }
            usnArray = sortUsers(usnArray);

            for (UserSearchNode usn : usnArray) {
                returnList.add(usn.getUser());
            }
        }
        return returnList;
    }

    private ArrayList<Tag> collectTags(String[] tokens) throws ClassNotFoundException, IOException {
        String sqlAddition = "Name LIKE \"%" + tokens[0] + "%\"";
        int i = 1;
        while (i < tokens.length) {
            sqlAddition += " OR Name LIKE \"%" + tokens[i] + "%\"";
            i++;
        }

        String SQLString = "SELECT * FROM Tag WHERE " + sqlAddition + " ORDER BY Name";
        ArrayList<Tag> returnList = new ArrayList();

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
            return returnList;
        } catch (SQLException sqle) {
            return null;
        }
    }

    private ArrayList<User> collectUsers(String[] tokens) throws ClassNotFoundException, IOException {
        String sqlAddition = "Username LIKE \"%" + tokens[0] + "%\"";
        int i = 1;
        while (i < tokens.length) {
            sqlAddition += " OR Username LIKE \"%" + tokens[i] + "%\"";
            i++;
        }

        String SQLString = "SELECT * FROM User WHERE " + sqlAddition + " ORDER BY Username";
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
                returnList.add(returnUser);
            }
            connection.close();
            return returnList;
        } catch (SQLException sqle) {
            return null;
        }
    }

    private ArrayList<TagSearchNode> scoreTags(ArrayList<Tag> tags, String word) {
        ArrayList<TagSearchNode> searchList = new ArrayList<TagSearchNode>();
        for (Tag t : tags) {
            boolean found = false;
            TagSearchNode foundNode = new TagSearchNode();

            for (TagSearchNode check : searchList) {
                if (check.getTag().getTagID() == t.getTagID()) {
                    found = true;
                    foundNode = check;
                }
            }
            if (!found) {
                TagSearchNode tsn = new TagSearchNode();
                tsn.setTag(t);
                tsn.increasePopularity(scoreString(t.getTitle(), word));
                tsn.increasePopularity(scoreString(t.getDescription(), word));
                if (t.getTitle().toLowerCase().equals(word.toLowerCase())) {
                    tsn.setWord(true);
                }
                searchList.add(tsn);
            } else {
                foundNode.increasePopularity(scoreString(t.getTitle(), word));
                foundNode.increasePopularity(scoreString(t.getDescription(), word));
                if (t.getTitle().toLowerCase().equals(word.toLowerCase())) {
                    foundNode.setWord(true);
                }
            }
        }
        return searchList;
    }

    private ArrayList<UserSearchNode> scoreUsers(ArrayList<User> users, String word) {
        ArrayList<UserSearchNode> searchList = new ArrayList<UserSearchNode>();
        for (User t : users) {
            boolean found = false;
            UserSearchNode foundNode = new UserSearchNode();

            for (UserSearchNode check : searchList) {
                if (check.getUser().getUserID() == t.getUserID()) {
                    found = true;
                    foundNode = check;
                }
            }
            if (!found) {
                UserSearchNode usn = new UserSearchNode();
                usn.setUser(t);
                usn.increasePopularity(scoreString(t.getUsername(), word));
                if (t.getUsername().toLowerCase().equals(word.toLowerCase())) {
                    usn.setUser(true);
                }
                searchList.add(usn);
            } else {
                foundNode.increasePopularity(scoreString(t.getUsername(), word));
                if (t.getUsername().toLowerCase().equals(word.toLowerCase())) {
                    foundNode.setUser(true);
                }
            }
        }
        return searchList;
    }

    private ArrayList<TagSearchNode> sortTags(ArrayList<TagSearchNode> tags) {
        ArrayList<TagSearchNode> returnList = new ArrayList<TagSearchNode>();


        while (tags.size() > 0) {
            TagSearchNode foundNode = new TagSearchNode();
            int indexInt = 0;
            for (int i = 0; i < tags.size(); i++) {
                if (tags.get(i).isWord()) {
                    returnList.add(tags.get(i));
                    tags.remove(i);
                }
            }
            for (int i = 0; i < tags.size(); i++) {
                TagSearchNode tsn = tags.get(i);
                if (tsn.getPopularity() >= foundNode.getPopularity()) {
                    foundNode = tsn;
                    indexInt = i;
                }
            }
            returnList.add(foundNode);
            tags.remove(indexInt);
        }
        return returnList;
    }

    private ArrayList<UserSearchNode> sortUsers(ArrayList<UserSearchNode> users) {
        ArrayList<UserSearchNode> returnList = new ArrayList<UserSearchNode>();


        while (users.size() > 0) {
            UserSearchNode foundNode = new UserSearchNode();
            int indexInt = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).isUser()) {
                    returnList.add(users.get(i));
                    users.remove(i);
                }
            }
            for (int i = 0; i < users.size(); i++) {
                UserSearchNode tsn = users.get(i);
                if (tsn.getPopularity() >= foundNode.getPopularity()) {
                    foundNode = tsn;
                    indexInt = i;
                }
            }
            returnList.add(foundNode);
            users.remove(indexInt);
        }
        return returnList;
    }
}
