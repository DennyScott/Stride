/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.QuestionDA;
import DataAccessors.RecentDA;
import ModelObjects.Question;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class QuestionModel {

    public int addQuestion(ModelObjects.Question question) {
        QuestionDA qm = new QuestionDA();
        RecentDA ra = new RecentDA();
        question.setQuestion(UtilityModel.filter(question.getQuestion()));

        try {
            int id = qm.add(question);
            ra.add(id);
            UserModel um = new UserModel();
            um.incrementQuestions(question.getUserID());
            int bounty = question.getBounty();
            if (bounty > 0) {
                um.decreaseReputation(question.getUserID(), bounty - 5);
            } else {
                um.increaseReputation(question.getUserID(), 5);
            }
            CourseModel cm = new CourseModel();
            cm.incrementQuestion(question.getCourseID());
            return id;
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean isCreator(int userID, int questionID) {
        try {
            QuestionDA qda = new QuestionDA();

            ModelObjects.Question q = qda.query(questionID);
            if (q.getUserID() == userID) {
                return true;
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
        public int getCreator(int questionID) {
        try {
            QuestionDA qda = new QuestionDA();

            ModelObjects.Question q = qda.query(questionID);
            
            return q.getUserID();
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int answerSelected(int questionID) {
        try {
            QuestionDA qda = new QuestionDA();
            int answered = qda.Answered(questionID);
            return answered;
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void incrementVotes(int id) {
        QuestionDA qda = new QuestionDA();
        try {
            qda.incrementVote(id);
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void decrementVotes(int id) {
        QuestionDA qda = new QuestionDA();
        try {
            qda.decrementVote(id);
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementVisits(int id) {
        QuestionDA qda = new QuestionDA();
        try {
            qda.decrementVisit(id);
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void incrementVisits(int id) {
        QuestionDA qda = new QuestionDA();
        try {
            qda.incrementVisit(id);
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementAnswers(int id) {
        QuestionDA qda = new QuestionDA();
        try {
            qda.decrementAnswers(id);
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void incrementAnswers(int id) {
        QuestionDA qda = new QuestionDA();
        try {
            qda.incrementAnswers(id);
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
