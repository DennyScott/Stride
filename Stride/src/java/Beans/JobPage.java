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
public class JobPage {
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;
    private KijAd ad;

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

    public KijAd getAd() {
        return ad;
    }

    public void setAd(KijAd ad) {
        this.ad = ad;
    }
    
    
}
