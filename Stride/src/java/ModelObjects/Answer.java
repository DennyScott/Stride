/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The Answer Bean
 * @author Travis
 */
public class Answer {

    private int answerID;
    private String answer;
    private int questionID;
    private int userID;
    private String submitted;
    private String lastUpdated;
    private int votes;
    private boolean chosen;

    /**
     * Gets the userID 
     * @return The user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the userID
     * @param userID The new user ID to be set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the answer ID
     * @return TheAnwer ID
     */
    public int getAnswerID() {
        return answerID;
    }

    /**
     * Sets the answer ID
     * @param answerID The new Answer ID to be set
     */
    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    /**
     * Gets the Answer String
     * @return The Answer String to be returned
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Return the Last Updated Time
     * @return The Last Updated Time
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the Last Updated Time
     * @param lastUpdated The Last Updated Time
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Sets the answer String
     * @param answer The new Answer String
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Get the Question ID associated with the Answer
     * @return The Question ID
     */
    public int getQuestionID() {
        return questionID;
    }

    /**
     * Sets the Question ID associated with the Answer
     * @param questionID 
     */
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    /**
     * Gets the time submitted of the Answer
     * @return The time Submitted
     */
    public String getSubmitted() {
        return submitted;
    }

    /**
     * Sets the time submitted of the Answer
     * @param submitted The new time submitted
     */
    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    /**
     * Gets the amount of votes for the Answer
     * @return The amount of vote for answer
     */
    public int getVotes() {
        return votes;
    }

    /**
     * Sets the Votes to the new vote amount
     * @param votes The new amount for the Vote
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
    
    
}
