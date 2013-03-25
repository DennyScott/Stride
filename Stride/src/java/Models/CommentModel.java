/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.AnswerCommentDA;
import DataAccessors.QuestionCommentDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class CommentModel {
    
    public boolean addQuestionComment(ModelObjects.QuestionComment qc){
        try {
            QuestionCommentDA qca = new QuestionCommentDA();
            qca.add(qc);
            
        } catch (IOException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean addAnswerComment(ModelObjects.AnswerComment ac){
        
        AnswerCommentDA aca = new AnswerCommentDA();
        try {
            aca.add(ac);
        } catch (IOException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
