/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import Beans.Tags;

/**
 *
 * @author Denny
 */
public class Blurb {
    private Question question;
    private ArrayList<Tags> Tags;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ArrayList<Tags> getTags() {
        return Tags;
    }

    public void setTags(ArrayList<Tags> Tags) {
        this.Tags = Tags;
    }
}

