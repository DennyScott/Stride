/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Denny
 */
public class Tags {
    
    //Variable initialization
    private String Tag = "No tag";
    private String ID;
    private int count;
    private String description;

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
    
    //No argument constructor
    public Tags(){
        
    }
    
    //GetTag method
    public String getTag(){
        return Tag;
    }
    
    //SetTag method
    public void setTag(String newTag){
        Tag = newTag;
    }
    
    //GetID method
    public String getID(){
        return ID;
    }
    
    //SetID method
    public void setID(String newID){
        ID = newID;
    }
}
