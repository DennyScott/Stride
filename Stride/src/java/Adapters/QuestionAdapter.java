/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DataAccessors.CourseDA;
import DataAccessors.QuestionDA;
import DataAccessors.RecentDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class QuestionAdapter {

    public ArrayList<Beans.Question> collectQuestions(int startPosition, int Amount) {

        RecentDA rm = new RecentDA();
        ArrayList<Beans.Question> returnList = new ArrayList<Beans.Question>();
        try {
            ArrayList<ModelObjects.Question> q = rm.collectQuestions(startPosition, Amount);

            for (ModelObjects.Question preQuestion : q) {
                returnList.add(adaptQuestion(preQuestion));
            }

        } catch (IOException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnList;
    }
    
    public int getBountyCount(){
        QuestionDA qda = new QuestionDA();
        return qda.countOpenBounties();
    }
    
     public ArrayList<Beans.Question> collectUnansweredQuestions(int startPosition, int Amount) {

        QuestionDA qd = new QuestionDA();
        ArrayList<Beans.Question> returnList = new ArrayList<Beans.Question>();
        try {
            ArrayList<ModelObjects.Question> q = qd.collectUnanweredQuestions(startPosition, Amount);

            for (ModelObjects.Question preQuestion : q) {
                returnList.add(adaptQuestion(preQuestion));
            }

        } catch (IOException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnList;
    }


    public ArrayList<ModelObjects.Question> collectRecentUserQuestions(int id, int startPosition, int Amount) {

        QuestionDA rm = new QuestionDA();

        ArrayList<ModelObjects.Question> q = rm.collectRecentUserQuestions(id, startPosition, Amount);



        return q;
    }

    public ArrayList<Beans.Question> getQuestionByCourse(int id, int start, int total) {

        ArrayList<ModelObjects.Question> questions = new QuestionDA().collectCourseQuestion(id, start, total);

        return adaptQuestionList(questions);

    }

    public Beans.Question query(int id) {
        QuestionDA qda = new QuestionDA();
        try {
            return adaptQuestion(qda.query(id));
        } catch (IOException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Beans.Question();
    }

    public ArrayList<Beans.Question> getQuestionsUser(int id) {
        ArrayList<Beans.Question> questions = new ArrayList<Beans.Question>();
        ArrayList<ModelObjects.Question> oldQues = new QuestionDA().getUserQuestion(id);
        for (ModelObjects.Question q : oldQues) {
            try {
                questions.add(adaptQuestion(q));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return questions;
    }
    
    public ArrayList<Beans.Question> collectOpenBounties(int startPosition, int totalAmount){
        ArrayList<Beans.Question> returnList = new ArrayList<Beans.Question>();
        
        QuestionDA qda = new QuestionDA();
        ArrayList<ModelObjects.Question> questions = qda.collectOpenBounties(startPosition, totalAmount);
        
        for(ModelObjects.Question question:questions){
            try {
                returnList.add(adaptQuestion(question));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnList;
    }
    
    public ArrayList<Beans.Question> collectRecentAnsweredBounties(int userID, int startPosition, int totalAmount){
        ArrayList<Beans.Question> returnList = new ArrayList<Beans.Question>();
        
        QuestionDA qda = new QuestionDA();
        ArrayList<ModelObjects.Question> questions = qda.collectRecentAnsweredBountyQuestion(userID, startPosition, totalAmount);
        
        for(ModelObjects.Question question:questions){
            try {
                returnList.add(adaptQuestion(question));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnList;
    }

    
    public ArrayList<Beans.Question> collectOpenUserBounties(int userID, int startPosition, int totalAmount){
        ArrayList<Beans.Question> returnList = new ArrayList<Beans.Question>();
        
        QuestionDA qda = new QuestionDA();
        ArrayList<ModelObjects.Question> questions = qda.collectUserOpenBounties(userID, startPosition, totalAmount);
        
        for(ModelObjects.Question question:questions){
            try {
                returnList.add(adaptQuestion(question));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnList;
    }

    
    public ArrayList<Beans.Question> adaptQuestionList(ArrayList<ModelObjects.Question> question) {
        ArrayList<Beans.Question> returnQuestion = new ArrayList<Beans.Question>();
        for (ModelObjects.Question q : question) {
            try {
                returnQuestion.add(adaptQuestion(q));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnQuestion;
    }

    public Beans.Question adaptQuestion(ModelObjects.Question preQuestion) throws ClassNotFoundException, IOException, SQLException {
        Beans.Question returnQuestion = new Beans.Question();

        returnQuestion.setAuthorID(preQuestion.getUserID() + "");
        returnQuestion.setCount(preQuestion.getVisits());
        returnQuestion.setQuestionID(preQuestion.getQuestionID() + "");
        returnQuestion.setTitle(preQuestion.getTitle());
        returnQuestion.setQuestion(preQuestion.getQuestion());
        returnQuestion.setSubmitted(preQuestion.getSubmitted());
        returnQuestion.setVotes(preQuestion.getVotes());
        returnQuestion.setLastUpdated(preQuestion.getLastUpdated());
        returnQuestion.setAnswers(preQuestion.getAnswers());
        returnQuestion.setCourseID(preQuestion.getCourseID() + "");
        returnQuestion.setAnswered(preQuestion.isAnswered());
        returnQuestion.setBounty(preQuestion.getBounty());

        UserAdapter ua = new UserAdapter();
        Beans.Users user = ua.getUser(preQuestion.getUserID());
        returnQuestion.setUser(user);

        CourseDA cm = new CourseDA();
        ModelObjects.Course course = cm.query(preQuestion.getCourseID());
        returnQuestion.setSchool(course.getName());

        return returnQuestion;



    }
}
