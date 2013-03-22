/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The AnswerComment Bean and Model Object
 * @author Travis
 */
public class AnswerComment implements Comment {
    private int commentID;
    private String comment;
    private int answerID;
    private String submitted;
    private int userID;
    private String lastUpdated;

    /**
     * Gets the ID of the Answer Comment
     * @return The ID of the Answer Comment
     */
    @Override
    public int getCommentID() {
        return commentID;
    }

    /**
     * Sets the ID of the Answer Comment
     * @param commentID The ID of the Answer Comment
     */
    @Override
    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    /**
     * Gets the Comment String
     * @return The Comment String
     */
    @Override
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment String
     * @param comment The new Comment String to replace the old one
     */
    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the Answer ID of the Comment
     * @return The Answer ID for the comment
     */
    @Override
    public int getComponentID() {
        return answerID;
    }

    /**
     * Sets the AnswerID of the given Comment
     * @param componentID The new AnswerID of the comment
     */
    @Override
    public void setComponentID(int componentID) {
        this.answerID = componentID;
    }

    /**
     * Gets the submitted time of the comment
     * @return The Submitted time of the Comment
     */
    @Override
    public String getSubmitted() {
        return submitted;
    }

    /**
     * Sets the submitted time of the comment
     * @param submitted The new submitted time of the comment
     */
    @Override
    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    /**
     * Gets the UserID associated with the comment
     * @return The UserID associated with the comment
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the userID of the comment
     * @param userID The new userID of the comment
     */
    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the last update of the Comment
     * @return The last update of the comment
     */
    @Override
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the last updated time
     * @param lastUpdated The new last updated time
     */
    @Override
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
