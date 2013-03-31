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
        int spot = -1;
        for (int i = 0; i<newAnswers.size(); i++){
            if(newAnswers.get(i).isChosen()){
                spot = i;
                break;
            }
        }
        
        if(spot>-1){
            Answers temp = newAnswers.remove(spot);
            newAnswers.add(0, temp);
        }
        
        return newAnswers;
    }
    
    public Answers getAnswer(int id) {

        ModelObjects.Answer answer = new ModelObjects.Answer();
        try {
            answer = new AnswerDA().query(id);
        } catch (IOException ex) {
            Logger.getLogger(AnswerAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Answers newAnswers;

        
            newAnswers= adaptAnswer(answer);
        
        
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
        a.setChosen(answer.isChosen());
        try {
            UserDA uda = new UserDA();
            ModelObjects.User user = uda.query(answer.getUserID());
            a.setAuthor(user.getUsername());
            a.setImg(user.getProfilePictureLink());
            a.setGold(user.getGoldCount());
            a.setSilver(user.getSilverCount());
            a.setBronze(user.getBronzeCount());
            a.setReputation(user.getReputation());
            

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
