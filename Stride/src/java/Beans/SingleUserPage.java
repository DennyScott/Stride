/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class SingleUserPage {
    
    private Users user;
    private ArrayList<Question> questions;
    private ArrayList<Answers> answers;
    private ArrayList<Courses> courses;
    private ArrayList<Tags> tags;
    private int tagTimes;
    private int votesUp;
    private int votesDown;
    private int totalVotes;
    private int questionVotes;
    private int answerVotes;
    private ArrayList<Badges> userBadges;

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public ArrayList<Badges> getUserBadges() {
        return userBadges;
    }

    public void setUserBadges(ArrayList<Badges> userBadges) {
        this.userBadges = userBadges;
    }

    public int getQuestionVotes() {
        return questionVotes;
    }

    public void setQuestionVotes(int questionVotes) {
        this.questionVotes = questionVotes;
    }

    public int getAnswerVotes() {
        return answerVotes;
    }

    public void setAnswerVotes(int answerVotes) {
        this.answerVotes = answerVotes;
    }
    
    

    public int getTagTimes() {
        return tagTimes;
    }

    public void setTagTimes(int tagTimes) {
        this.tagTimes = tagTimes;
    }

    public ArrayList<Courses> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Courses> courses) {
        this.courses = courses;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answers> answers) {
        this.answers = answers;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public int getVotesUp() {
        return votesUp;
    }

    public void setVotesUp(int votesUp) {
        this.votesUp = votesUp;
    }

    public int getVotesDown() {
        return votesDown;
    }

    public void setVotesDown(int votesDown) {
        this.votesDown = votesDown;
    }
    
    
    
    
}
