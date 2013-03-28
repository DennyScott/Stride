/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.CourseAdapter;
import Adapters.QuestionAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.Blurb;
import Beans.Question;
import Beans.RecentBadges;
import Beans.SingleCoursePage;
import Beans.Tags;
import Jobs.Download;
import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class SingleCoursePageModel {

    public SingleCoursePage getPage(int id, int start) {
        SingleCoursePage page = new SingleCoursePage();

        //Side Content
        ArrayList<Tags> tags;
        ArrayList<RecentBadges> recent;
        TagAdapter ta = new TagAdapter();
        RecentBadgeAdapter rba = new RecentBadgeAdapter();
        int totalAmount = 10;
        //Side Content

        tags = ta.getRecent();
        recent = rba.getRecent(5);
        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();
        QuestionAdapter qa = new QuestionAdapter();
        CourseAdapter ca = new CourseAdapter();

        page.setAd(ad);
        page.setBadges(recent);
        page.setRecent(tags);
        page.setCourse(ca.getCourse(id));
        ArrayList<Question> questions = qa.getQuestionByCourse(id, start, totalAmount);
        ArrayList<Blurb> blurb = new ArrayList<Blurb>();

        for (Beans.Question q : questions) {
            Blurb temp = new Blurb();
            temp.setQuestion(q);
            temp.setTags(ta.collectQuestionTags(Integer.parseInt(q.getQuestionID())));
            blurb.add(temp);
        }

        page.setQuestions(blurb);
        return page;

    }
}
