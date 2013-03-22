/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The QuestionVote Bean and Model Object
 * @author Travis
 */
public class QuestionVote {
    
    private int userID;
    private int questionID;
    private boolean up;
    private String submitted;

    /**
     * Gets the UserID of the Vote
     * @return The UserID of the Vote
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the UserID of the Vote
     * @param userID The new userID of the Vote
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the Question ID of the Vote
     * @return the question ID of the Vote 
     */
    public int getQuestionID() {
        return questionID;
    }

    /**
     * Sets the Question ID of the Vote
     * @param questionID The new Question ID of the Vote
     */
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    /**
     * 
     * @return 
     */
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }
    
    
    
    
}
