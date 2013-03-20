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
public class SingleBadgePage {
    
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;
    private Badges badgeInfo;

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

    public Badges getBadgeInfo() {
        return badgeInfo;
    }

    public void setBadgeInfo(Badges badgeInfo) {
        this.badgeInfo = badgeInfo;
    }
    
    
}
