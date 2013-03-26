/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.CourseAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.AskQuestionPage;
import Beans.RecentBadges;
import Beans.Tags;
import Jobs.Download;
import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class AskQuestionModel {

    public AskQuestionPage getPage() {

        AskQuestionPage page = new AskQuestionPage();

        //Side Content
        ArrayList<Tags> tags;
        ArrayList<RecentBadges> recent;

        TagAdapter ta = new TagAdapter();
        RecentBadgeAdapter rba = new RecentBadgeAdapter();
        CourseAdapter ca = new CourseAdapter();
        page.setCourses(ca.getAllCourses());

        tags = ta.getRecent(5);
        recent = rba.getRecent(5);
        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();
        
        page.setBadges(recent);
        page.setAd(ad);
        page.setRecent(tags);
        
        return page;
    }
}
