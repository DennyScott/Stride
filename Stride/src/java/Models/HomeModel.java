/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.QuestionAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.*;
import Jobs.Download;
import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class HomeModel {

    public Front getFront() {
        //Main Content
        ArrayList<Blurb> questions = new ArrayList<Blurb>();

        //Side Content
        ArrayList<Tags> tags;
        ArrayList<RecentBadges> recent;
        //Main Content
        Front front = new Front();
        QuestionAdapter qa = new QuestionAdapter();
        TagAdapter ta = new TagAdapter();
        RecentBadgeAdapter rba = new RecentBadgeAdapter();

        ArrayList<Beans.Question> q = qa.collectQuestions(0, 15);

        for (Beans.Question question : q) {
            Blurb temp = new Blurb();
            temp.setQuestion(question);
            temp.setTags(ta.collectQuestionTags(Integer.parseInt(question.getQuestionID())));
            questions.add(temp);
        }

        //Side Content

        tags = ta.getRecent(5);
        recent = rba.getRecent(5);

        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();
        front.setAd(ad);

        front.setBadges(recent);
        front.setQuestions(questions);
        front.setRecent(tags);

        return front;

    }
}
