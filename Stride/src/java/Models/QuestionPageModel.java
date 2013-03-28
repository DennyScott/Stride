/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.AnswerAdapter;
import Adapters.CommentAdapter;
import Adapters.QuestionAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.Answers;
import Beans.Comments;
import Beans.QuestionPage;
import Beans.RecentBadges;
import Beans.Tags;
import Jobs.Download;
import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class QuestionPageModel {
    
    public QuestionPage getQuestion(int id) {
        //Main Content
        ArrayList<Comments> qComments;
        ArrayList<Answers> answer ;
        ArrayList<Tags> questionTags;
        
        
        
        //Side Content
        ArrayList<Tags> tags;
        ArrayList<RecentBadges> recent;
        //Main Content
        QuestionPage qp = new QuestionPage();
        QuestionAdapter qa = new QuestionAdapter();
        AnswerAdapter aa = new AnswerAdapter();
        TagAdapter ta = new TagAdapter();
        RecentBadgeAdapter rba = new RecentBadgeAdapter();
        CommentAdapter ca = new CommentAdapter();
        qComments = ca.collectQuestionComments(id);
        answer = aa.getAnswers(id);
        questionTags = ta.collectQuestionTags(id);
        

        //Side Content

        tags = ta.getRecent();
        recent = rba.getRecent(5);
        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();
        
        qp.setAd(ad);

        qp.setComments(qComments);
        qp.setTags(questionTags);
        qp.setAnswers(answer);
        qp.setBadges(recent);
        qp.setQuestionObject(qa.query(id));
        qp.setRecent(tags);
        
        QuestionModel qm = new QuestionModel();
        qm.incrementVisits(id);
        
        return qp;

    }
}
