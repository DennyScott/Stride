/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.AnswerDA;
import ModelObjects.Answer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class AnswerModel {

    public boolean addAnswer(ModelObjects.Answer answer) {

        answer.setAnswer(UtilityModel.filter(answer.getAnswer()));
        AnswerDA ad = new AnswerDA();
        try {
            ad.add(answer);
            QuestionModel qm = new QuestionModel();
            qm.incrementAnswers(answer.getQuestionID());
            UserModel um = new UserModel();
            um.incrementAnswers(answer.getUserID());
            if (!qm.isCreator(answer.getUserID(), answer.getQuestionID())) {
                um.increaseReputation(answer.getUserID(), 35);
            }
        } catch (IOException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void incrementVotes(int id) {
        AnswerDA ada = new AnswerDA();
        try {
            ada.incrementVotes(id);
        } catch (IOException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void decrementVotes(int id) {
        AnswerDA ada = new AnswerDA();
        try {
            ada.decrementVotes(id);
        } catch (IOException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void selectAnswer(int answerID) {
        try {
            AnswerDA ad = new AnswerDA();
            Answer answer = ad.query(answerID);
            ad.chosen(answerID);
            QuestionModel qm = new QuestionModel();
            int bounty = qm.answerSelected(answer.getQuestionID());
            UserModel um = new UserModel();
            int increaseAmount = 50 + bounty;
            um.increaseReputation(answer.getUserID(), increaseAmount);
        } catch (IOException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
