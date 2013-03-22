/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public interface Comment {

    public int getCommentID();

    public void setCommentID(int commentID);

    public String getComment();

    public void setComment(String comment);

    public int getComponentID();

    public void setComponentID(int componentID);

    public String getSubmitted();

    public void setSubmitted(String submitted);

    public int getUserID();

    public void setUserID(int userID);

    public String getLastUpdated();

    public void setLastUpdated(String lastUpdated);
}
