/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.BadgeAdapter;
import Adapters.QuestionAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.BadgePage;
import Beans.RecentBadges;
import Beans.Tags;
import Jobs.Download;
import Jobs.KijAd;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class BadgesPageModel {
    
    
    
    public BadgePage getPage(int id, int start){
        
        int totalAmount = 20;
        start = start==1?0:start*totalAmount-totalAmount;
        
        BadgePage page = new BadgePage();
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
        QuestionAdapter qa = new QuestionAdapter();
        BadgeAdapter ba = new BadgeAdapter();
        
        
        page.setBadgeInfo(ba.getBadgeByColor(id, start, totalAmount));
        page.setAd(ad);
        page.setBadges(recent);
        page.setRecent(tags);
        
        return page;
    }
    
}
