/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Beans.Comments;
import DataAccessors.AnswerCommentDA;
import DataAccessors.QuestionCommentDA;
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
public class CommentAdapter {
    
    public ArrayList<Comments> collectQuestionComments(int id){
       
        ArrayList<Comments> qComments = new ArrayList<Comments>();
        QuestionCommentDA qcda = new QuestionCommentDA();
        ArrayList<ModelObjects.QuestionComment> qc = qcda.getQuestionComments(id);
        for(ModelObjects.QuestionComment q:qc){
            qComments.add(adaptQuestionComments(q));
        }
        return qComments;
        
    }
    
    public ArrayList<Comments> collectAnswerComments(int id){
       
        ArrayList<Comments> qComments = new ArrayList<Comments>();
        AnswerCommentDA qcda = new AnswerCommentDA();
        ArrayList<ModelObjects.AnswerComment> qc = qcda.getAnswerComments(id);
        for(ModelObjects.AnswerComment q:qc){
            qComments.add(adaptAnswerComments(q));
        }
        return qComments;
        
    }
    
    public Comments adaptQuestionComments(ModelObjects.QuestionComment qc){
        Comments c = new Comments();
        c.setAuthorID(qc.getUserID());
        c.setComment(qc.getComment());
        c.setID(qc.getComponentID());
        c.setSubmitted(qc.getSubmitted());
        c.setVotes(0);
        
        UserDA u = new UserDA();
        try {
            c.setAuthor(u.query(c.getAuthorID()).getUsername());
        } catch (IOException ex) {
            Logger.getLogger(CommentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CommentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
        
        
    }
    
    public Comments adaptAnswerComments(ModelObjects.AnswerComment qc){
        Comments c = new Comments();
        c.setAuthorID(qc.getUserID());
        c.setComment(qc.getComment());
        c.setID(qc.getComponentID());
        c.setSubmitted(qc.getSubmitted());
        c.setVotes(0);
        
        UserDA u = new UserDA();
        try {
            c.setAuthor(u.query(c.getAuthorID()).getUsername());
        } catch (IOException ex) {
            Logger.getLogger(CommentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CommentAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
        
        
    }
    
}
    

