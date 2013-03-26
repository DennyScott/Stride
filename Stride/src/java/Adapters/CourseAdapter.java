/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Beans.Courses;
import DataAccessors.CourseDA;
import DataAccessors.QuestionDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class CourseAdapter {
    
    public ArrayList<Courses> getAllCourses(){
        CourseDA cda = new CourseDA();
        ArrayList<Courses> returnCourses = new ArrayList<Courses>();
        ArrayList<ModelObjects.Course> course;
        try {
            course = cda.getAllCourses();
            for(ModelObjects.Course c: course){
            returnCourses.add(adaptCourse(c));
            }
        } catch (IOException ex) {
            Logger.getLogger(CourseAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return returnCourses;
        
    }
    
    public Courses adaptCourse(ModelObjects.Course c){
        Courses course = new Courses();
        course.setCourse(c.getName());
        course.setDescription(c.getDescription());
        course.setId(c.getCourseID());
        course.setTotal(course.getTotal());
        return course;
    }
}
