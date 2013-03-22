/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DataAccessors.BadgeModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class BadgeAdapter {
    
    public Beans.Badges getBadge(int id){
        BadgeModel bm = new BadgeModel();
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
