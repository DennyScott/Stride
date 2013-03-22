/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The AnswerVote Bean and Model
 *
 * @author Travis
 */
public class AnswerVote {

    private int userID;
    private int answerID;
    private boolean up;
    private String submitted;

    /**
     * Return the userID associated with the AnswerVote
     *
     * @return The UserID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the UserID of the associated AnswerVote
     *
     * @param userID The new userID to be set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Returns the answerID associated with the AnswerVote
     *
     * @return The answerID
     */
    public int getAnswerID() {
        return answerID;
    }

    /**
     * Sets the answerID of the associated AnswerVote
     *
     * @param answerID The new answerID to be set
     */
    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    /**
     * Used to show if the vote was up or down, up being true
     *
     * @return true if the vote was up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * Sets the vote_up to the given boolean value, true being up
     *
     * @param up The new vote for the Answer
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * gets the submitted time of the AnswerVote
     *
     * @return The Submission time of the AnswerVote
     */
    public String getSubmitted() {
        return submitted;
    }

    /**
     * Sets the submitted time of the AnswerVote
     *
     * @param submitted The submitted time of the AnswerVote
     */
    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }
}
