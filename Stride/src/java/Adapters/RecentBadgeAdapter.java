/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DataAccessors.BadgeCollectedDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class RecentBadgeAdapter {
    
    public ArrayList<Beans.RecentBadges> getRecent(int num){
        ArrayList<Beans.RecentBadges> recent = new ArrayList<Beans.RecentBadges>();
        BadgeCollectedDA bcm = new BadgeCollectedDA();
        try {
            ArrayList<ModelObjects.RecentBadge> rb = bcm.collectRecentBadges(num);
            for(ModelObjects.RecentBadge badge : rb){
                recent.add(adaptRecentBadge(badge));
            }
        } catch (IOException ex) {
            Logger.getLogger(RecentBadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecentBadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RecentBadgeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recent;   
    }
    
    public Beans.RecentBadges adaptRecentBadge(ModelObjects.RecentBadge rb){
        Beans.RecentBadges returnBadge = new Beans.RecentBadges();
        BadgeAdapter ba = new BadgeAdapter();
        UserAdapter ua = new UserAdapter();
        
        returnBadge.setUserName(ua.getUser(rb.getUserID()).getUser());
        returnBadge.setUserID(rb.getUserID()+"");
        returnBadge.setBadge(ba.getBadge(rb.getBadgeID()));
        
        return returnBadge;
    }
}
