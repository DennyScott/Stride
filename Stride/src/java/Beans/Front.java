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
public class Front {
    
    private ArrayList<Blurb> questions;
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;

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
