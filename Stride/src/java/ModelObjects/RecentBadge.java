/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class RecentBadge {
    private int userID;
    private int badgeID;
    private String submission;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBadgeID() {
        return badgeID;
    }

    public void setBadgeID(int badgeID) {
        this.badgeID = badgeID;
    }

    public String getSubmission() {
        return submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
    }
    
    
    
}
