/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.CourseDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class CourseModel {
    
    public void incrementQuestion(int id){
        CourseDA cda = new CourseDA();
        try {
            cda.incrementQuestions(id);
        } catch (IOException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void decrementQuestion(int id){
        CourseDA cda = new CourseDA();
        try {
            cda.decrementQuestions(id);
        } catch (IOException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
