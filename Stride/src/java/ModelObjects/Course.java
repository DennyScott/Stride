/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelObjects;

/**
 *
 * @author Travis
 */
public class Course {
    private int courseID;
    private String name;
    private int questionsTotal;
    private String description;

    /**
     * Returns the course ID for the Course
     * @return The Course ID of the course
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * Set the course ID of the Course
     * @param courseID The new Course ID of the course
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * Gets the name of the Course
     * @return The Name of the Course Object
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Course object
     * @param name The new name of the Course object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the total questions within the course
     * @return The total questions in the course
     */
    public int getQuestionsTotal() {
        return questionsTotal;
    }

    /**
     * Sets the total questions within the course
     * @param questionsTotal The total question to set the Course to
     */
    public void setQuestionsTotal(int questionsTotal) {
        this.questionsTotal = questionsTotal;
    }

    /**
     * Get the description of the course
     * @return The description of the Course
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the Description of the course
     * @param description The new description of the course
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
