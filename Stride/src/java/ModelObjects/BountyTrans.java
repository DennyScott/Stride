/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class BountyTrans {

    private int bountyID;
    private int userID;
    private int questionID;
    private int ownerID;
    private int bounty;
    private String timeCollected;

    public int getBountyID() {
        return bountyID;
    }

    public void setBountyID(int bountyID) {
        this.bountyID = bountyID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getTimeCollected() {
        return timeCollected;
    }

    public void setTimeCollected(String timeCollected) {
        this.timeCollected = timeCollected;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }
        
}
