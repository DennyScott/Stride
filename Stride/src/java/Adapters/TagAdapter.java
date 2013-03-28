/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Beans.Tags;
import DataAccessors.TagDA;
import DataAccessors.TagLinkDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class TagAdapter {

    public ArrayList<Beans.Tags> getRecent() {
        ArrayList<Beans.Tags> tags = new ArrayList<Beans.Tags>();
        TagLinkDA tlm = new TagLinkDA();
        try {
            ArrayList<ModelObjects.Tag> t = tlm.collectRecentTags();
            for (ModelObjects.Tag tag : t) {
                tags.add(adaptTag(tag));
            }
        } catch (IOException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tags;
    }
    
    public int getTotalTags(){
        try {
            return new TagDA().totalTags();
        } catch (IOException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public Tags getTag(int id){
        try {
            return adaptTag(new TagDA().query(id));
        } catch (IOException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Tags();
    }
    
    public ArrayList<Beans.Question> getQuestionByTag(int tagID, int startPosition, int totalAmount){
        TagLinkDA tda = new TagLinkDA();
        ArrayList<Beans.Question> returnQuestion = new ArrayList<Beans.Question>();
        QuestionAdapter qa = new QuestionAdapter();
        try {
            ArrayList<ModelObjects.Question> tags =  tda.collectTagRecentQuestions(tagID, startPosition, totalAmount);
            returnQuestion = qa.adaptQuestionList(tags);
        } catch (IOException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnQuestion;
    }
    
    public ArrayList<Beans.Tags> collectAllTags(int start, int totalAmount){
        ArrayList<Beans.Tags> returnTags = new ArrayList<Beans.Tags>();
        try {
            ArrayList<ModelObjects.Tag> tags = new TagDA().collectAllTags(start, totalAmount);
            for(ModelObjects.Tag t: tags){
                returnTags.add(adaptTag(t));
            }
        } catch (IOException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnTags;
        
        
    }

    public ArrayList<Beans.Tags> collectUserTags(ArrayList<ModelObjects.Question> question,int id) {
        ArrayList<Beans.Tags> returnTag = new ArrayList<Beans.Tags>();
        TagDA tda = new TagDA();
            try {
                ArrayList<ModelObjects.Tag> tag = tda.collectRecentTags(id, question);
                for(ModelObjects.Tag t:tag){
                    if(returnTag.size()<10){
                    returnTag.add(adaptTag(t));
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        return returnTag;
    }

    public ArrayList<Beans.Tags> collectQuestionTags(int questionID) {

        TagLinkDA tlm = new TagLinkDA();
        ArrayList<Beans.Tags> tags = new ArrayList<Beans.Tags>();

        try {
            ArrayList<ModelObjects.Tag> preTag = tlm.collectQuestionTags(questionID);

            for (ModelObjects.Tag t : preTag) {
                tags.add(adaptTag(t));
            }
        } catch (IOException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TagAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tags;
    }

    public Beans.Tags adaptTag(ModelObjects.Tag t) {
        Beans.Tags tag = new Beans.Tags();
        tag.setCount(t.getCount()); //Need to add Count to Data Access
        tag.setDescription(t.getDescription());
        tag.setID(t.getTagID() + "");
        tag.setTag(t.getTitle());

        return tag;
    }
}
