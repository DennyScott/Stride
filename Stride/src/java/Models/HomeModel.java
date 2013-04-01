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

    public Front getFront(ArrayList<Integer> cookies) {
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

        //Cookies
        int size = testCookies(cookies);
        if (size == 2) {
            for(int i = 1; i>=0; i--){
            Blurb temp = new Blurb();
            Beans.Question cookieOne = qa.query(cookies.get(i));
            temp.setQuestion(cookieOne);
            temp.setTags(ta.collectQuestionTags(cookies.get(i)));
            questions.add(0, temp);
    }
        } else if (size == 1) {
            Blurb temp = new Blurb();
            Beans.Question cookieOne = qa.query(cookies.get(0));
            temp.setQuestion(cookieOne);
            temp.setTags(ta.collectQuestionTags(cookies.get(0)));
            questions.add(0, temp);
        }
        
        front.setCookieSize(size);

        //Side Content

        tags = ta.getRecent();
        recent = rba.getRecent(5);

        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();
        front.setAd(ad);

        front.setBadges(recent);
        front.setQuestions(questions);
        front.setRecent(tags);

        return front;

    }
    
    public Front getUnansweredFront(ArrayList<Integer> cookies) {
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

        ArrayList<Beans.Question> q = qa.collectUnansweredQuestions(0, 15);

        for (Beans.Question question : q) {
            Blurb temp = new Blurb();
            temp.setQuestion(question);
            temp.setTags(ta.collectQuestionTags(Integer.parseInt(question.getQuestionID())));
            questions.add(temp);
        }

        //Cookies
        int size = testCookies(cookies);
        if (size == 2) {
            for(int i = 1; i>=0; i--){
            Blurb temp = new Blurb();
            Beans.Question cookieOne = qa.query(cookies.get(i));
            temp.setQuestion(cookieOne);
            temp.setTags(ta.collectQuestionTags(cookies.get(i)));
            questions.add(0, temp);
    }
        } else if (size == 1) {
            Blurb temp = new Blurb();
            Beans.Question cookieOne = qa.query(cookies.get(0));
            temp.setQuestion(cookieOne);
            temp.setTags(ta.collectQuestionTags(cookies.get(0)));
            questions.add(0, temp);
        }
        
        front.setCookieSize(size);

        //Side Content

        tags = ta.getRecent();
        recent = rba.getRecent(5);

        Download d = new Download();
        ArrayList<KijAd> ad = d.getAds();
        front.setAd(ad);

        front.setBadges(recent);
        front.setQuestions(questions);
        front.setRecent(tags);

        return front;

    }

    private int testCookies(ArrayList<Integer> cookies) {
        if(!cookies.isEmpty()){
            if(cookies.size()==1){
                return 0;
            }
        if(cookies.get(0) == cookies.get(1)){
            cookies.set(1,0);
        }
        if (cookies.get(0) == 0 && cookies.get(1) == 0) {
            return 0;
        } else if (cookies.get(0) != 0 && cookies.get(1) == 0) {
            return 1;
        } else {
            return 2;
        }
    }
        return 0;
    }
}
