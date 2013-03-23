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
public class UserModel {
    
    public boolean addUser(ModelObjects.User user){
        DataAccessors.UserDA um = new DataAccessors.UserDA();
        try {
            return um.add(user);
        } catch (IOException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
