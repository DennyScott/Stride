/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.CourseAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.CoursePage;
import Beans.RecentBadges;
import Beans.Tags;
import Jobs.Download;
import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class CoursePageModel {
     public CoursePage getPage() {
        CoursePage page = new CoursePage();

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
        page.setCourses(new CourseAdapter().getAllCourses());
        
        return page;
               
    }
    
}
