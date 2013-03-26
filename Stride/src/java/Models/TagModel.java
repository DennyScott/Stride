/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.TagDA;
import DataAccessors.TagLinkDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class TagModel {
    
    public boolean addTag(ModelObjects.Tag tag,int questionID){
        TagDA td = new TagDA();
        TagLinkDA tld = new TagLinkDA();
        try {
            int id = td.add(tag);
            tld.add(questionID, id);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void incrementCount(int id){
        try {
            TagDA tda = new TagDA();
            tda.incrementCount(id);
        } catch (IOException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void decrementCount(int id){
        try {
            TagDA tda = new TagDA();
            tda.decrementCount(id);
        } catch (IOException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
