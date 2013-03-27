/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.QuestionDA;
import DataAccessors.RecentDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class QuestionModel {
    
    public int addQuestion(ModelObjects.Question question){
        QuestionDA qm = new QuestionDA();
        RecentDA ra = new RecentDA();
        try {
            int id = qm.add(question);
            ra.add(id);
            UserModel um = new UserModel();
            um.incrementQuestions(question.getUserID());
            CourseModel cm = new CourseModel();
            cm.incrementQuestion(question.getUserID());
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
    
    public void incrementVotes(int id){
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
    
    public void decrementVotes(int id){
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
    
    public void decrementVisits(int id){
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
    
    public void incrementVisits(int id){
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
    
    public void decrementAnswers(int id){
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
    
    public void incrementAnswers(int id){
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
