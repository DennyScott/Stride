/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Denny
 */
public class Comments {
    
    //Variable initialization
    private String Comment = "No comment";
    private String Submitted = "No Date";
    private String Author = "No Author";
    private int AuthorID;
    private int Votes;
    private int ID;

    public int getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(int AuthorID) {
        this.AuthorID = AuthorID;
    }
    
    //No argument constructor
    public Comments(){
        
    }
    
    //GetComment method
    public String getComment(){
        return Comment;
    }
    
    //SetComment method
    public void setComment(String newComment){
        Comment = newComment;
    }

    //GetSubmitted Method
    public String getSubmitted() {
        return Submitted;
    }

    //SetSubmitted method
    public void setSubmitted(String newSubmitted) {
        Submitted = newSubmitted;
    }

    //GetAuthor method
    public String getAuthor() {
        return Author;
    }

    //SetAuthor method
    public void setAuthor(String newAuthor) {
        Author = newAuthor;
    }

    //GetVotes method
    public int getVotes() {
        return Votes;
    }

    //SetVotes method
    public void setVotes(int newVote) {
        Votes = newVote;
    }

    //GetID method
    public int getID() {
        return ID;
    }

    //SetID method
    public void setID(int newID) {
        ID = newID;
    }
}
