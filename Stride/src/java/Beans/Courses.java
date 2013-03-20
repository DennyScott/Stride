/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Denny
 */
public class Courses {
    private String Course;
    private int total;
    private int id;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int count) {
        this.total = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }      

    public Courses() {
    }
}
