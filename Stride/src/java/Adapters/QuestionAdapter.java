/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import DataAccessors.CourseDA;
import DataAccessors.RecentDA;
import DataAccessors.UserDA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class QuestionAdapter {

    public ArrayList<Beans.Question> collectQuestions(int startPosition, int Amount) {
        
        RecentDA rm = new RecentDA();
        ArrayList<Beans.Question> returnList = new ArrayList<Beans.Question>();
        try {
            ArrayList<ModelObjects.Question> q = rm.collectQuestions(startPosition, Amount);
            
            for(ModelObjects.Question preQuestion :  q){
                returnList.add(adaptQuestion(preQuestion));
            }
                        
        } catch (IOException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnList;
    }
    
    public Beans.Question adaptQuestion(ModelObjects.Question preQuestion) throws ClassNotFoundException, IOException, SQLException{
        Beans.Question returnQuestion = new Beans.Question();
       
        returnQuestion.setAuthorID(preQuestion.getUserID()+"");
        returnQuestion.setCount(preQuestion.getVisits());
        returnQuestion.setQuestionID(preQuestion.getQuestionID()+"");
        returnQuestion.setTitle(preQuestion.getTitle());
        returnQuestion.setQuestion(preQuestion.getQuestion());
        returnQuestion.setSubmitted(preQuestion.getSubmitted());
        returnQuestion.setVotes(preQuestion.getVotes());
        returnQuestion.setLastUpdated(preQuestion.getLastUpdated());
        
        UserDA um = new UserDA();
        ModelObjects.User user = um.query(preQuestion.getUserID());
        returnQuestion.setAuthor(user.getUsername());
        
        CourseDA cm = new CourseDA();
        ModelObjects.Course course = cm.query(preQuestion.getCourseID());
        returnQuestion.setSchool(course.getName());
        
        return returnQuestion;
        
        
        
    }
}
