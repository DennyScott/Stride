/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 * The Question Bean and Model Object
 * @author Travis
 */
public class Question {
    private int questionID;
    private int userID;
    private int visits;
    private int answers;
    private String title;
    private String question;
    private int votes;
    private int courseID;
    private String submitted;
    private String lastUpdated;

    /**
     * Gets the userID associated with the Question
     * @return The userID within the Question
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the userID associated with the question
     * @param userID The new user ID for the Question
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Return the amount of visits to the question
     * @return The amount of visits to the question
     */
    public int getVisits() {
        return visits;
    }

    /**
     * Sets how many visits the question has had
     * @param visits The new amount of visits the Question has
     */
    public void setVisits(int visits) {
        this.visits = visits;
    }
    
    /**
     * Gets how many answers the Question ha
     * @return The amount of Answers the Question has
     */
     public int getAnswers() {
        return answers;
    }

     /**
      * Sets the amount of Answers a Question has
      * @param answers The new amount of answers
      */
    public void setAnswers(int answers) {
        this.answers = answers;
    }

    /**
     * Gets the QuestionID of the Question
     * @return The QuestionID of the Question
     */
    public int getQuestionID() {
        return questionID;
    }

    /**
     * Sets the QuestionID of the Question
     * @param questionID The new questionID of the Question
     */
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    /**
     * Gets the Title of the Question 
     * @return The Title of the Question
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the Question
     * @param title The new title of the question
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the Question contained within the Question Bean
     * @return The Actual String Question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the Question String of the Question Object
     * @param question The new Question String of the Question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets the Submitted Date of the Question
     * @return The Submission Date of the Question
     */
    public String getSubmitted() {
        return submitted;
    }

    /**
     * Sets the Submission Date of the Question
     * @param submitted The new Submission date of the question
     */
    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    /**
     * Gets the amount of vote the Question has received
     * @return The amount of votes the question has received
     */
    public int getVotes() {
        return votes;
    }

    /**
     * Sets the amount of vote the question has
     * @param votes The new amount of votes for the question
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }

    /**
     * Gets the CoureID associated with this Question
     * @return The CourseID of the question
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * Sets the CourseID of the question
     * @param courseID The new course ID associated with the Question
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets the Last Updated Time of the Question
     * @return The Last Updated Time of the Question
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the last updated time of the question
     * @param lastUpdated The new Last Updated time of the Question
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    
    
    
}
