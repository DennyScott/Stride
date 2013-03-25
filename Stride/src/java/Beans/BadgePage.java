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
public class BadgePage {
    
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;
    private ArrayList<Badges> badgeInfo;
    private ArrayList<KijAd> ad;

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

    public ArrayList<Badges> getBadgeInfo() {
        return badgeInfo;
    }

    public void setBadgeInfo(ArrayList<Badges> badgeInfo) {
        this.badgeInfo = badgeInfo;
    }
    
    
}
