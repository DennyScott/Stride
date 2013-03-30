/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.CourseAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.BarePage;
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
public class BarePageModel {
    
     public BarePage getPage() {
        BarePage page = new BarePage();

        //Side Content
        ArrayList<Tags> tags;
        ArrayList<RecentBadges> recent;
        TagAdapter ta = new TagAdapter();
        RecentBadgeAdapter rba = new RecentBadgeAdapter();
        //Side Content

        tags = ta.getRecent();
        recent = rba.getRecent(5);
        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();

        page.setAd(ad);
        page.setBadges(recent);
        page.setRecent(tags);
        
        return page;
               
    }
    
}
