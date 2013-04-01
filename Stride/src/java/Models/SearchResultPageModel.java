/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.BadgeAdapter;
import Adapters.QuestionAdapter;
import Adapters.RecentBadgeAdapter;
import Adapters.TagAdapter;
import Beans.Blurb;
import Beans.RecentBadges;
import Beans.SearchResultPage;
import Beans.Tags;
import Jobs.Download;
import Jobs.KijAd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denny
 */
public class SearchResultPageModel {

    public SearchResultPage getPage(String keyword) {

        SearchResultPage page = new SearchResultPage();
        ArrayList<Tags> tags;
        ArrayList<RecentBadges> recent;
        TagAdapter ta = new TagAdapter();
        RecentBadgeAdapter rba = new RecentBadgeAdapter();
        BadgeAdapter ba = new BadgeAdapter();
        //Side Content
        tags = ta.getRecent();
        recent = rba.getRecent(5);

        page.setBadges(recent);
        page.setRecent(tags);

        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();
        QuestionAdapter qa = new QuestionAdapter();

        page.setAd(ad);
        
        SearchModel sm = new SearchModel();
        try {
            ArrayList<Beans.Question> questions = qa.adaptQuestionList(sm.searchKeyword(keyword));
            
            ArrayList<Blurb> blurb = new ArrayList<Blurb>();

        for (Beans.Question q : questions) {
            Blurb temp = new Blurb();
            temp.setQuestion(q);
            temp.setTags(ta.collectQuestionTags(Integer.parseInt(q.getQuestionID())));
            blurb.add(temp);
        }

        page.setQuestions(blurb);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchResultPageModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SearchResultPageModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page;
    }
}
