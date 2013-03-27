/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DataAccessors.UserDA;
import ModelObjects.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author Denny
 */
public class UserAdapter {
    
    public ArrayList<Beans.Users> getAllUsers(int start, int end){
        UserDA um = new UserDA();
        ArrayList<Beans.Users> returnUser = new ArrayList<Beans.Users>();
        try {
            ArrayList<User> users = um.collectUsersByRep(start,end);
            for(User u: users){
                returnUser.add(adaptUser(u));
            }
        } catch (IOException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnUser;
    }
    
    public Beans.Users getUser(int id){
        UserDA um = new UserDA();
        ModelObjects.User user = new ModelObjects.User();
        try {
            user = um.query(id);
        } catch (IOException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adaptUser(user);
    }
    
    public Beans.Users adaptUser(ModelObjects.User user){
        Beans.Users returnUser = new Beans.Users();
        
        returnUser.setBio(user.getBiography());
        returnUser.setBronze(user.getBronzeCount());
        returnUser.setEmail(user.getEmailAddress());
        returnUser.setFirstName(user.getFirstName());
        returnUser.setGold(user.getGoldCount());
        returnUser.setImg("/img/"+user.getUserID()+"/"+user.getProfilePictureLink());
        returnUser.setJoinedDate(user.getCreated());
        returnUser.setLastName(user.getLastName());
        returnUser.setLastOnline(user.getLastLoggedIn());
        returnUser.setNumberAnswers(user.getNumberOfAnswers());
        returnUser.setNumberQuestions(user.getNumberOfQuestions());
        returnUser.setRank(user.getRank());
        returnUser.setReputation(user.getReputation());
        returnUser.setSilver(user.getSilverCount());
        returnUser.setUser(user.getUsername());
        returnUser.setUserID(user.getUserID()+"");
        returnUser.setVotes(user.getVotes());
        
        return returnUser;
    }
}
