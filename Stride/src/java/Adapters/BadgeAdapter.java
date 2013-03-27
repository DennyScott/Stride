/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DataAccessors.BadgeCollectedDA;
import DataAccessors.BadgeDA;
import ModelObjects.Badge;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class BadgeAdapter {
    
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
