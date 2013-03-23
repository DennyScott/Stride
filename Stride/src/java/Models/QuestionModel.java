/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class QuestionModel {
    
    public void addQuestion(ModelObjects.Question question){
        DataAccessors.QuestionDA qm = new DataAccessors.QuestionDA();
        try {
            qm.add(question);
        } catch (IOException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
