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
public class Front {
    
    private ArrayList<Blurb> questions;
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;
    private ArrayList<KijAd> ad;
    private int cookieSize;
    private int openBounties;

    public int getOpenBounties() {
        return openBounties;
    }

    public void setOpenBounties(int openBounties) {
        this.openBounties = openBounties;
    }

    public int getCookieSize() {
        return cookieSize;
    }

    public void setCookieSize(int cookieSize) {
        this.cookieSize = cookieSize;
    }

    public ArrayList<KijAd> getAd() {
        return ad;
    }

    public void setAd(ArrayList<KijAd> ad) {
        this.ad = ad;
    }

    public ArrayList<Blurb> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Blurb> questions) {
        this.questions = questions;
    }

    public ArrayList<RecentBadges> getBadges() {
        return badges;
    }

    public void setBadges(ArrayList<RecentBadges> badges) {
        this.badges = badges;
    }

    public ArrayList<Tags> getRecent() {
        return recent;
    }

    public void setRecent(ArrayList<Tags> recent) {
        this.recent = recent;
    }

}
