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
 * Multiple ways to Collect data from the Answers Tables, in the form of ModelObects. These answers are then 
 * passed through the adaptAnswer method, returning to the caller a "Beans.Answers" object. 
 * All data that needs to be "collected" from the database pertaining to answers must go through here.
 * 
 * @author Team Port Forward
 */
public class AnswerAdapter {

    /**
     * Collect all answers pertaining to a Question ID. Listed will be all answers
     * for a single question in order of top answered, then the oldest.
     * 
     * @param id Question ID
     * @return ArrayList<Answers> in order of time.
     */
    public ArrayList<Answers> getAnswers(int id) {

        ArrayList<ModelObjects.Answer> answer = new AnswerDA().getQuestionAnswers(id);
        ArrayList<Answers> newAnswers = new ArrayList<Answers>();

        for (ModelObjects.Answer a : answer) {
            newAnswers.add(adaptAnswer(a));
        }
        //Check for answer chosen
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
    
    /**
     * Get single Answer from Answer Table, based off of the answer ID. 
     * 
     * @param id answerID of desired answer
     * @return Answers The Bean.Answers object of the desired answer
     */
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
    
    /**
     * Collect the recent posted answers of a specified user. These are ordered in the time of 
     * last submitted.
     * 
     * @param id userID of user who posted answer
     * @param start Where in the database to start (10 would be the 10th position)
     * @param stop The total amount of posts (starting after start)
     * @return ArrayList<Answers> containing the recent answers of a user
     */
    public ArrayList<Answers> getRecentAnswers(int id,int start, int stop) {

        ArrayList<ModelObjects.Answer> answer = new AnswerDA().collectRecentUserAnswers(id, start, stop);
        ArrayList<Answers> newAnswers = new ArrayList<Answers>();

        for (ModelObjects.Answer a : answer) {
            newAnswers.add(adaptAnswer(a));
        }
        
        return newAnswers;
    }
    
    /**
     * Utility method, which allows for an entire ArrayList<ModelObject.Answer> to be passed in, which
     * will singly call the adaptAnswer method, and return the adapted arraylist.
     * 
     * @param answer ArrayList<ModelObjects.Answer> The arraylist to be converted to ArrayList<Answers>
     * @return An ArrayList<Answers>
     */
    public ArrayList<Answers> adaptAnswerList(ArrayList<ModelObjects.Answer> answer){
        ArrayList<Answers> returnAnswer = new ArrayList<Answers>();
        for(ModelObjects.Answer a: answer){
            returnAnswer.add(adaptAnswer(a));
        }
        return returnAnswer;
    }

    /**
     * Adapt the ModelObects.Answer to the Beans.Answers Object. The Beans.Answers is used for 
     * view (front-end) work. They often contain extra data over the ModelObjects. The Model Objects
     * relate to exactly how the database is set up.
     * 
     * @param answer ModelObjects.Answer. To be converted
     * @return A Converted Beans.Answers object.
     */
    public Answers adaptAnswer(ModelObjects.Answer answer) {
        Answers a = new Answers();

        //Conver data
        a.setAnswer(answer.getAnswer());
        a.setAuthorID(answer.getUserID() + "");
        a.setID(answer.getAnswerID() + "");
        a.setLastUpdated(answer.getLastUpdated());
        a.setQuestionID(answer.getQuestionID() + "");
        a.setSubmitted(answer.getSubmitted());
        a.setVotes(answer.getVotes());
        a.setChosen(answer.isChosen());
        try {
            //Collect additional data outside this adapter
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
