/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class SingleBadgePage {
    
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;
    private Badges badgeInfo;
    private ArrayList<KijAd> ad;
    private ArrayList<Users> users;

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    public ArrayList<KijAd> getAd() {
        return ad;
    }

    public void setAd(ArrayList<KijAd> ad) {
        this.ad = ad;
    }

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
