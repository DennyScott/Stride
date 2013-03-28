/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.Blurb;
import Beans.Question;
import Beans.RecentBadges;
import Beans.SingleTagPage;
import Beans.Tags;
import Jobs.Download;
import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class SingleTagPageModel {

    public SingleTagPage getPage(int id, int start) {
        SingleTagPage page = new SingleTagPage();

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

        page.setAd(ad);
        page.setBadges(recent);
        page.setRecent(tags);
        page.setTag(ta.getTag(id));
        ArrayList<Question> questions = ta.getQuestionByTag(id, start, totalAmount);
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
