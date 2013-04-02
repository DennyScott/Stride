/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Adapters.AnswerAdapter;
import Adapters.BadgeAdapter;
import Adapters.BountyAdapter;
import Adapters.CourseAdapter;
import Adapters.QuestionAdapter;
import Adapters.TagAdapter;
import Adapters.UserAdapter;
import Adapters.VoteAdapter;
import Beans.Badges;
import Beans.MyUserPage;
import Beans.Question;
import Beans.SingleUserPage;
import Beans.Tags;
import java.util.ArrayList;

/**
 *
 * @author Denny
 */
public class ProfilePage {
    
    public SingleUserPage getPage(int id) {
        SingleUserPage page = new SingleUserPage();
        page.setUser(new UserAdapter().getUser(id));
        QuestionAdapter qa = new QuestionAdapter();
        ArrayList<ModelObjects.Question> questions = qa.collectRecentUserQuestions(id, 0, 5);
        ArrayList<Question> q = qa.adaptQuestionList(questions);
        page.setQuestions(q);
        page.setAnswers(new AnswerAdapter().getRecentAnswers(id, 0, 5));
        page.setCourses(new CourseAdapter().getCourseUser(q));
        ArrayList<Tags> tag = new TagAdapter().collectUserTags(questions, id);
        page.setTags(tag);

        page.setTagTimes(tag.size());
        ArrayList<ModelObjects.AnswerVote> av = new VoteAdapter().getUserAnswerVotes(id);
        ArrayList<ModelObjects.QuestionVote> qv = new VoteAdapter().getUserQuestionVotes(id);

        int votesUp = 0;
        int votesDown = 0;
        int questionVotes = 0;
        int answerVotes = 0;

        for (ModelObjects.AnswerVote aVote : av) {
            answerVotes++;
            if (aVote.isUp()) {
                votesUp++;

            } else {
                votesDown++;
            }
        }
        for (ModelObjects.QuestionVote qVote : qv) {
            questionVotes++;
            if (qVote.isUp()) {
                votesUp++;

            } else {
                votesDown++;
            }
        }
        page.setTotalVotes(answerVotes + questionVotes);
        page.setAnswerVotes(answerVotes);
        page.setQuestionVotes(questionVotes);
        page.setVotesDown(votesDown);
        page.setVotesUp(votesUp);

        ArrayList<Badges> userBadges = new BadgeAdapter().getRecentBadges(id, 0, 10);
        page.setUserBadges(userBadges);

        return page;
    }
    
     public MyUserPage getMyPage(int id) {
        MyUserPage page = new MyUserPage();
        page.setUser(new UserAdapter().getUser(id));
        QuestionAdapter qa = new QuestionAdapter();
        ArrayList<ModelObjects.Question> questions = qa.collectRecentUserQuestions(id, 0, 5);
        ArrayList<Question> q = qa.adaptQuestionList(questions);
        page.setQuestions(q);
        page.setAnswers(new AnswerAdapter().getRecentAnswers(id, 0, 5));
        page.setCourses(new CourseAdapter().getCourseUser(q));
        ArrayList<Tags> tag = new TagAdapter().collectUserTags(questions, id);
        page.setTags(tag);

        page.setTagTimes(tag.size());
        ArrayList<ModelObjects.AnswerVote> av = new VoteAdapter().getUserAnswerVotes(id);
        ArrayList<ModelObjects.QuestionVote> qv = new VoteAdapter().getUserQuestionVotes(id);

        int votesUp = 0;
        int votesDown = 0;
        int questionVotes = 0;
        int answerVotes = 0;

        for (ModelObjects.AnswerVote aVote : av) {
            answerVotes++;
            if (aVote.isUp()) {
                votesUp++;

            } else {
                votesDown++;
            }
        }
        for (ModelObjects.QuestionVote qVote : qv) {
            questionVotes++;
            if (qVote.isUp()) {
                votesUp++;

            } else {
                votesDown++;
            }
        }
        page.setTotalVotes(answerVotes + questionVotes);
        page.setAnswerVotes(answerVotes);
        page.setQuestionVotes(questionVotes);
        page.setVotesDown(votesDown);
        page.setVotesUp(votesUp);

        ArrayList<Badges> userBadges = new BadgeAdapter().getRecentBadges(id, 0, 10);
        page.setUserBadges(userBadges);
        
        page.setBountyAnswers(qa.collectRecentAnsweredBounties(id, 0, 5));
        page.setOpenBounties(qa.collectOpenBounties(0, 10));
        page.setRecievedBounties(new BountyAdapter().getAwardedBounties(id, 0, 5));
        page.setMyBounties(qa.collectOpenUserBounties(id, 0, 5));

        return page;
    }
}
