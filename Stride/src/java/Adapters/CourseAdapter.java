/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Beans.Courses;
import Beans.Question;
import DataAccessors.CourseDA;
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
    
    public ArrayList<Courses> getCourseUser(ArrayList<Question> question){
        ArrayList<Courses> courses = new ArrayList<Courses>();
        ArrayList<Integer> id = new ArrayList<Integer>();
        for(Question q: question){
            Integer i = Integer.parseInt(q.getCourseID());
            if(id.isEmpty() || id.indexOf(i)==-1){
                id.add(i);
            }
        }
        CourseDA cda = new CourseDA();
            for(Integer t:id){
            try {
                courses.add(adaptCourse(cda.query(t)));
            } catch (IOException ex) {
                Logger.getLogger(CourseAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CourseAdapter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CourseAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            return courses;
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
