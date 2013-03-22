/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The BadgeCollected Bean and Model
 *
 * @author Travis
 */
public class BadgeCollected {

    private int userID;
    private int badgeID;
    private String submitted;

    /**
     * Gets the UserID of the BadgeCollected Object
     *
     * @return The UserID of the BadgeCollected Object
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the UserID of the BadgeCollected Object
     *
     * @param userID The new userID of the BadgeCollected Object
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the Badge ID of the BadgeCollected object
     *
     * @return The Badge ID of the Badge Collected
     */
    public int getBadgeID() {
        return badgeID;
    }

    /**
     * Sets the BadgeId of the BadgeCollected Object
     *
     * @param badgeID The new BadgeID of the BadgeCollected Object
     */
    public void setBadgeID(int badgeID) {
        this.badgeID = badgeID;
    }

    /**
     * Gets the submitted time of the BadgeCollected object
     *
     * @return The time submitted
     */
    public String getSubmitted() {
        return submitted;
    }

    /**
     * Sets the submission time of the BadgeCollected object
     *
     * @param submitted The new submission time of the BadgeCollected object
     */
    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }
}
