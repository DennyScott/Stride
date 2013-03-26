/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class Tag {

    private int tagID;
    private String title;
    private String description;
    private int count;

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}