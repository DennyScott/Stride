/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Beans.Answers;
import DataAccessors.AnswerDA;
import DataAccessors.UserDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class AnswerAdapter {

    public ArrayList<Answers> getAnswers(int id) {

        ArrayList<ModelObjects.Answer> answer = new AnswerDA().getQuestionAnswers(id);
        ArrayList<Answers> newAnswers = new ArrayList<Answers>();

        for (ModelObjects.Answer a : answer) {
            newAnswers.add(adaptAnswer(a));
        }
        
        return newAnswers;
    }
    
    public ArrayList<Answers> getRecentAnswers(int id,int start, int stop) {

        ArrayList<ModelObjects.Answer> answer = new AnswerDA().collectRecentUserAnswers(id, start, stop);
        ArrayList<Answers> newAnswers = new ArrayList<Answers>();

        for (ModelObjects.Answer a : answer) {
            newAnswers.add(adaptAnswer(a));
        }
        
        return newAnswers;
    }
    
    public ArrayList<Answers> adaptAnswerList(ArrayList<ModelObjects.Answer> answer){
        ArrayList<Answers> returnAnswer = new ArrayList<Answers>();
        for(ModelObjects.Answer a: answer){
            returnAnswer.add(adaptAnswer(a));
        }
        return returnAnswer;
    }

    public Answers adaptAnswer(ModelObjects.Answer answer) {
        Answers a = new Answers();

        a.setAnswer(answer.getAnswer());
        a.setAuthorID(answer.getUserID() + "");
        a.setID(answer.getAnswerID() + "");
        a.setLastUpdated(answer.getLastUpdated());
        a.setQuestionID(answer.getQuestionID() + "");
        a.setSubmitted(answer.getSubmitted());
        a.setVotes(answer.getVotes());
        try {
            a.setAuthor(new UserDA().query(answer.getUserID()).getUsername());

            a.setComments(new CommentAdapter().collectAnswerComments(answer.getAnswerID()));


        } catch (IOException ex) {
            Logger.getLogger(AnswerAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
