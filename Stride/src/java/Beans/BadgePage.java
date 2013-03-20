/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class BadgePage {
    
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;
    private ArrayList<Badges> badgeInfo;

    public ArrayList<Tags> getRecent() {
        return recent;
    }

    public void setRecent(ArrayList<Tags> recent) {
        this.recent = recent;
    }

    public ArrayList<RecentBadges> getBadges() {
        return badges;
    }

    public void setBadges(ArrayList<RecentBadges> badges) {
        this.badges = badges;
    }

    public ArrayList<Badges> getBadgeInfo() {
        return badgeInfo;
    }

    public void setBadgeInfo(ArrayList<Badges> badgeInfo) {
        this.badgeInfo = badgeInfo;
    }
    
    
}
