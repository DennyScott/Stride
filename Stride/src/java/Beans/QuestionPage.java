/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class QuestionPage {

    private Question question; 
    private ArrayList<Tags> Tags;
    private ArrayList<Comments> Comments;
    private ArrayList<Answers> answers;
    private ArrayList<Tags> recent;
    private ArrayList<RecentBadges> badges;
    private ArrayList<KijAd> ad;

    public ArrayList<KijAd> getAd() {
        return ad;
    }

    public void setAd(ArrayList<KijAd> ad) {
        this.ad = ad;
    }

    public ArrayList<RecentBadges> getBadges() {
        return badges;
    }

    public void setBadges(ArrayList<RecentBadges> badge) {
        this.badges = badge;
    }

    public Question getQuestionSlot() {
        return question;
    }

    public void setQuestionSlot(Question questionSlot) {
        this.question= questionSlot;
    }

    public int getCount() {
        return question.getCount();
    }

    public void setCount(int count) {
        question.setCount(count);
    }
    
    public ArrayList<Beans.Tags> getRecent() {
        return recent;
    }

    public void setRecent(ArrayList<Beans.Tags> recent) {
        this.recent = recent;
    }

    public QuestionPage() {
    }

    
    public String getTitle() {
        return question.getTitle();
    }

    public String getSchool() {
        return question.getSchool();
    }

    public void setSchool(String school) {
        question.setSchool(school);
    }

    public void setTitle(String newTitle) {

        question.setTitle(newTitle);
    }

    public String getQuestion() {
        return question.getQuestion();
    }

    public void setQuestion(String newQuestion) {
        question.setQuestion(newQuestion);
    }

    public String getSubmitted() {
        return question.getSubmitted();
    }

    public void setSubmitted(String newSubmitted) {
        question.setSubmitted(newSubmitted);
    }

    public String getAuthor() {
        return question.getAuthor();
    }

    public void setAuthor(String newAuthor) {
        question.setAuthor(newAuthor);
    }

    public int getVotes() {
        return question.getVotes();
    }

    public void setVotes(int newVote) {
        question.setVotes(newVote);
    }

    public ArrayList<Tags> getTags() {
        return Tags;
    }

    public void setTags(ArrayList<Tags> newTags) {
        Tags = newTags;
    }

    public ArrayList<Comments> getComments() {
        return Comments;
    }

    public void setComments(ArrayList<Comments> newComments) {
        Comments = newComments;
    }
    
    public ArrayList<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answers> answers) {
        this.answers = answers;
    }

    public String getQuestionID() {
        return question.getQuestionID();
    }

    public void setQuestionID(String newQuestionID) {
        question.setQuestionID(newQuestionID);
    }

    public String getAuthorID() {
        return question.getAuthorID();
    }

    public void setAuthorID(String newAuthorID) {
        question.setAuthorID(newAuthorID);
    }
}
