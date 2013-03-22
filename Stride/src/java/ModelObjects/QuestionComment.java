/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The QuestionComment Bean and Model Object
 * @author Travis
 */
public class QuestionComment implements Comment{
    private int commentID;
    private String comment;
    private int questionID;
    private String submitted;
    private int userID;
    private String lastUpdated;

    /**
     * The CommentID for the Comment
     * @return The commentID of the comment
     */
    @Override
    public int getCommentID() {
        return commentID;
    }

    /**
     * Sets the commentID of the comment
     * @param commentID The new comment ID of the comment
     */
    @Override
    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    /**
     * Gets the comment of the QuestionComment
     * @return The String comment of the Comment
     */
    @Override
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment of the questionComment
     * @param comment The new String comment of the QuestionComment
     */
    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * The Question ID of the Comment 
     * @return The QuestionID of the Comment
     */
    @Override
    public int getComponentID() {
        return questionID;
    }

    /**
     * Sets the QuestionID of the comment
     * @param componentID The new QuestionID of the comment
     */
    @Override
    public void setComponentID(int componentID) {
        this.questionID = componentID;
    }

    /**
     * Gets the submitted time of the QuestionComment
     * @return The submission time of the comment
     */
    @Override
    public String getSubmitted() {
        return submitted;
    }

    /**
     * Sets the submission time of the Comment
     * @param submitted The new submission time of the comment
     */
    @Override
    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    /**
     * Gets the UserID of the Comment
     * @return The UserID of the comment
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the UserID of the comment
     * @param userID The new userID of the Comment
     */
    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the last updated time of the Comment
     * @return The last updated time of the comment
     */
    @Override
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the last updated time of the comment
     * @param lastUpdated The new last updated time of the comment
     */
    @Override
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
}
