/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.BadgeAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.RecentBadges;
import Beans.SingleBadgePage;
import Beans.Tags;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class SingleBadgePageModel {

    public SingleBadgePage getPage(int id,int limit){
    
    SingleBadgePage page = new SingleBadgePage();
    ArrayList<Tags> tags;
    ArrayList<RecentBadges> recent;
    TagAdapter ta = new TagAdapter();
    RecentBadgeAdapter rba = new RecentBadgeAdapter();
    BadgeAdapter ba = new BadgeAdapter();
    //Side Content
    tags  = ta.getRecent();
    recent  = rba.getRecent(5);
    
    page.setBadges(recent);
    page.setRecent(tags);
    page.setBadgeInfo(ba.getBadge(id));
    page.setUsers(ba.getRecentBadgeByID(id, limit));
    
    return page;
    }
}
