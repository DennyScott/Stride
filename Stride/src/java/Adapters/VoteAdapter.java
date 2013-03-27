/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DataAccessors.AnswerVoteDA;
import DataAccessors.QuestionVoteDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class VoteAdapter {
    
    public ArrayList<ModelObjects.QuestionVote> getUserQuestionVotes(int id){
        QuestionVoteDA qv = new QuestionVoteDA();
        try {
            return qv.queryUser(id);
            
        } catch (IOException ex) {
            Logger.getLogger(VoteAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VoteAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VoteAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<ModelObjects.QuestionVote>();
    }
    
    public ArrayList<ModelObjects.AnswerVote> getUserAnswerVotes(int id){
        AnswerVoteDA qv = new AnswerVoteDA();
        try {
            return qv.query(id);
            
        } catch (IOException ex) {
            Logger.getLogger(VoteAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VoteAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VoteAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<ModelObjects.AnswerVote>();
    }
    
    
}
