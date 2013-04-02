/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataAccessors.BadgeCollectedDA;
import DataAccessors.BadgeDA;
import ModelObjects.BadgeCollected;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Travis
 */
public class BadgeModel {

    public boolean addCollected(int userID, int badgeID) {
        try {
            BadgeCollected bc = new BadgeCollected();
            bc.setBadgeID(badgeID);
            bc.setUserID(userID);
            BadgeCollectedDA bcda = new BadgeCollectedDA();
            bcda.add(bc);
            UserModel um = new UserModel();
            um.incrementBronze(userID);
            BadgeDA bda = new BadgeDA();
            bda.incrementBadge(badgeID);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(BadgeModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BadgeModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BadgeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
