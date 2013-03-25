/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.AnswerDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class AnswerModel {
    
    public boolean addAnswer(ModelObjects.Answer answer){
        
        AnswerDA ad = new AnswerDA();
        try {
            ad.add(answer);
        } catch (IOException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}