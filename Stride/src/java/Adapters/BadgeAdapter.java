package Adapters;

import DataAccessors.BadgeCollectedDA;
import DataAccessors.BadgeDA;
import ModelObjects.Badge;
import ModelObjects.RecentBadge;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Multiple ways to Collect data from the Badge Tables, in the form of ModelObects. These Badges are then 
 * passed through the adaptBadge method, returning to the caller a "Beans.Badges" object. 
 * All data that needs to be "collected" from the database pertaining to Badges must go through here.
 * 
 * @author Team Port Forward
 */
public class BadgeAdapter {
    
    /**
     * Collect Badge from Badge Table using the id of the badge.
     * 
     * @param id int id of the desired badge
     * @return Beans.Badges object of the desire badge.
     */
    public Beans.Badges getBadge(int id){
        BadgeDA bm = new BadgeDA();
        Beans.Badges badge = new Beans.Badges();
        try {
            badge = adaptBadge(bm.query(id));
        } catch (IOException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return badge;
    }
    
    /**
     * Collect Badges based on color (Gold:1, Silver:2, Bronze:3), from the Badge
     * Table.
     * 
     * @param color Gold:1, Silver:2, Bronze:3
     * @param start Where in the database to start collected data
     * @param total The total amount after start to collect
     * @return An ArrayList<Beans.Badges> of the desired color.
     */
    public ArrayList<Beans.Badges> getBadgeByColor(int color, int start, int total){
        ArrayList<Beans.Badges> returnBadge = new ArrayList<Beans.Badges>();
        try {
            ArrayList<ModelObjects.Badge> badges = new BadgeDA().collectAllColorBadge(color, start, total);
            for(ModelObjects.Badge badge:badges){
                returnBadge.add(adaptBadge(badge));
            }
        } catch (IOException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnBadge;
        
    }
    
    /**
     * Collect badges owned by a user, by querying their ID through the BadgeCollected
     * Table.
     * 
     * @param id int Id of the desired user.
     * @return An ArrayList<Beans.Badges> of the user.
     */
    public ArrayList<Beans.Badges> getUserBadges(int id){
        ArrayList<Beans.Badges> returnBadge = new ArrayList<Beans.Badges>();
        try {
            ArrayList<Badge> bc = new BadgeCollectedDA().collectBadges(id);
            for(Badge b:bc){
                returnBadge.add(adaptBadge(b));
            }
        } catch (IOException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnBadge;
    }
    
    /**
     * Collect all the users whoe have recently earned badges of a single badge. This is done through
     * the BadgeCollected table, gathering User ID's, then query on users.
     * 
     * @param id The ID of the desire Badge
     * @param limit The amount of "recent" users desired.
     * @return An ArrayList<Beans.Users> who have recently earned this badge.
     */
    public ArrayList<Beans.Users> getRecentBadgeByID(int id, int limit){
        ArrayList<Beans.Users> returnUsers = new ArrayList<Beans.Users>();
        UserAdapter ua = new UserAdapter();
        try {
            ArrayList<RecentBadge> bc = new BadgeCollectedDA().collectRecentBadge(limit, id);
            
            for(RecentBadge b:bc){
                //Collect User Id's then pass them for query
                returnUsers.add(ua.getUser(b.getUserID()));
            }
        } catch (IOException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnUsers;
    }
    
    /**
     * Collect Recently earned badges by a single user. This is done by querying the
     * BadgeCollected table with a userID.
     * 
     * @param id User ID 
     * @param start Where to start in the table
     * @param total The total amount of entries collected after start
     * @return An ArrayList<Beans.Badges> of the collected Badges.
     */
    public ArrayList<Beans.Badges> getRecentBadges(int id, int start, int total){
        ArrayList<Beans.Badges> returnBadge = new ArrayList<Beans.Badges>();
        try {
            ArrayList<Badge> bc = new BadgeCollectedDA().collectRecentUserBadges(id, start, total);
            for(Badge b:bc){
                returnBadge.add(adaptBadge(b));
            }
        } catch (IOException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnBadge;
    }
    
    /**
     * Adapt the ModelObects.Badges to the Beans.Badges Object. The Beans.Badges is used for 
     * view (front-end) work. They often contain extra data over the ModelObjects. The Model Objects
     * relate to exactly how the database is set up.
     * 
     * @param badge The to be converted ModelObject.Badge
     * @return The Converted Beans.Badges object.
     */
    public Beans.Badges adaptBadge(ModelObjects.Badge badge){
        Beans.Badges returnBadge = new Beans.Badges();
        
        returnBadge.setBadge(badge.getName());
        returnBadge.setColor(badge.getColor());
        returnBadge.setDescription(badge.getDescription());
        returnBadge.setId(badge.getBadgeID()+"");
        returnBadge.setTotal(badge.getCount());
        
        return returnBadge;
    }
}
