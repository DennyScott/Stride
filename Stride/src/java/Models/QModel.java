/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Denny
 */
public class QModel {
    
    public static SingleTagPage getTag(){
        
        SingleTagPage tag = new SingleTagPage();
        ArrayList<Tags> tags = new ArrayList<Tags>();
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Blurb> blurb = new ArrayList<Blurb>();
        ArrayList<Tags> questionTags = new ArrayList<Tags>();
        

            Tags t = new Tags();
            t.setID(1+"");
            t.setTag("c#");
            Random rand = new Random();
            t.setCount(rand.nextInt(100));
            t.setDescription(" a multi-paradigm programming language encompassing strong typing, imperative, declerative, functional, generic, object-oriented (class-based), and component oriented programming disciplines.");
            
            tag.setTag(t);
            
            for(int i = 0; i<5;i++){
            if(i<5){
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i+"");
                if(i<2){
                b.setColor(MedalColor.GOLD);
                }
                else if(i<3){
                    b.setColor(MedalColor.SILVER);
                }
                else{
                    b.setColor(MedalColor.BRONZE);
                }
                        
                
                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i+"");
                rb.setUserName("Author "+i);
                bAdd1.add(rb);
            }
            
            if(i<3){
            Tags b = new Tags();
            b.setCount(rand.nextInt(100));
            b.setID(i+"");
            b.setTag("Java " + i);
            
            tags.add(b);
            
            }
        }
            
            for(int c = 0; c<10; c++){
                Question temp = new Question();
                temp.setAuthor("Denny Scott");
                temp.setAuthor(c+"");
                temp.setCount(rand.nextInt(100));
                temp.setLastUpdated("January 13, 2012");
                temp.setQuestion("I have a question with " + c);
                temp.setQuestionID(c+"");
                temp.setSchool("1903");
                temp.setSubmitted("January 13, 2012");
                temp.setTitle("Title to question " + c);
                temp.setVotes(rand.nextInt(100));
                
                Blurb b1 = new Blurb();
                b1.setQuestion(temp);
                
                for(int d =0; d<3; d++){
                    Tags t1 = new Tags();
                    t1.setCount(rand.nextInt(100));
                    t1.setDescription("Im a tag");
                    t1.setID(c+"");
                    t1.setTag("Java " + c);
                    questionTags.add(t1);
                    
                }
                b1.setTags(questionTags);
                
                blurb.add(b1);
            }
            
            tag.setTag(t);
            tag.setBadges(bAdd1);
            tag.setRecent(tags);
            tag.setQuestions(blurb);
         
        
        return tag;
    }
    
    public static TagPage getTags(){
        TagPage tag = new TagPage();
        ArrayList<Tags> tags = new ArrayList<Tags>();

        Random rand = new Random();
        
        for(int i=0;i<40;i++){
            Tags t = new Tags();
            t.setID(i+"");
            t.setTag("c# " + i);
            
            t.setCount(rand.nextInt(100));
            
            t.setDescription(" a multi-paradigm programming language encompassing strong typing, imperative, declerative, functional, generic, object-oriented (class-based), and component oriented programming disciplines.");
            tags.add(t);
        }        
        
        
        tag.setTags(tags);
        
        
        return tag;
    }
    
    public static BadgePage getBadges(){
        BadgePage badge = new BadgePage();
        ArrayList<Badges> bAdd = new ArrayList<Badges>();
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        Random rand = new Random();
        
        for(int i = 0; i<20; i++){
        Badges b = new Badges();
        b.setBadge("Badge " + i);
        b.setId(i+"");
        b.setDescription("This is a test to see how the description would work, this is for badge " + i + " and we are seeing whether the text would wrap and look appropriate. Im making this longer to see if the word wrapping still goes into the legend.");
        
        
        b.setTotal(rand.nextInt(100));
        
        if(i<10){
            b.setColor(MedalColor.GOLD);
        }
        else if(i<15){
            b.setColor(MedalColor.SILVER);
        }
        else{
            b.setColor(MedalColor.BRONZE);
        }
        
        bAdd.add(b);
        }
        
        badge.setBadgeInfo(bAdd);
        
        for(int i = 0; i<5;i++){
            if(i<5){
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i+"");
                if(i<2){
                b.setColor(MedalColor.GOLD);
                }
                else if(i<3){
                    b.setColor(MedalColor.SILVER);
                }
                else{
                    b.setColor(MedalColor.BRONZE);
                }
                        
                
                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i+"");
                rb.setUserName("Author "+i);
                bAdd1.add(rb);
            }
            
            if(i<3){
            Tags t = new Tags();
            t.setCount(rand.nextInt(100));
            t.setID(i+"");
            t.setTag("Java " + i);
            
            tag.add(t);
            
            }
        }
        
        badge.setBadges(bAdd1);
        badge.setRecent(tag);
        
        return badge;
        
        
    }
    
    public static SingleBadgePage getBadge(int id){
        SingleBadgePage badge = new SingleBadgePage();
        
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        Random rand = new Random();
        
        
        Badges b = new Badges();
        b.setBadge("Badge Title ");
        b.setId("1");
        b.setDescription("This is a test to see how the description would work, this is for badge and we are seeing whether the text would wrap and look appropriate. Im making this longer to see if the word wrapping still goes into the legend.");
        
        
        b.setTotal(rand.nextInt(100));
        
       
            b.setColor(MedalColor.GOLD);
        
        
        
        badge.setBadgeInfo(b);
        
        for(int i = 0; i<5;i++){
            if(i<5){
                Badges c = new Badges();
                c.setBadge("Badge " + i);
                c.setId(i+"");
                if(i<2){
                c.setColor(MedalColor.GOLD);
                }
                else if(i<3){
                    c.setColor(MedalColor.SILVER);
                }
                else{
                    c.setColor(MedalColor.BRONZE);
                }
                        
                
                RecentBadges rb = new RecentBadges();
                rb.setBadge(c);
                rb.setUserID(i+"");
                rb.setUserName("Author "+i);
                bAdd1.add(rb);
            }
            
            if(i<3){
            Tags t = new Tags();
            t.setCount(rand.nextInt(100));
            t.setID(i+"");
            t.setTag("Java " + i);
            
            tag.add(t);
            
            }
        }
        
        badge.setBadges(bAdd1);
        badge.setRecent(tag);
        
        return badge;
        
        
    }
    
    public static Front getFront(){
        
        Front frontPage = new Front();
        Blurb questions = new Blurb();
        
        ArrayList<Blurb> Q = new ArrayList<Blurb>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        ArrayList<RecentBadges> badge = new ArrayList<RecentBadges>();
        
        for(int i = 0; i<10; i++){
            Q.add(new Blurb());
            Blurb blurb = Q.get(i);
            Question temp = new Question();
            temp.setAuthor("Author " + i);
            temp.setAuthorID(i+"");
           
            Random rand = new Random();
            temp.setCount(rand.nextInt(100));
            temp.setAnswers(rand.nextInt(100));
            
            temp.setQuestion("This is a tempory blurb for the question.");
            temp.setQuestionID(i+"");
            temp.setSchool("3909");
            temp.setSubmitted("2013-03-12");
            temp.setTitle("This is the Title to the question " + i);
            temp.setVotes(rand.nextInt(100));
            
            blurb.setQuestion(temp);
            if(i<3){
            Tags t = new Tags();
            t.setCount(rand.nextInt(100));
            t.setID(i+"");
            t.setTag("Java " + i);
            
            tag.add(t);
            
            }
            
            if(i<5){
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i+"");
                if(i<2){
                b.setColor(MedalColor.GOLD);
                }
                else if(i<3){
                    b.setColor(MedalColor.SILVER);
                }
                else{
                    b.setColor(MedalColor.BRONZE);
                }
                        
                
                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i+"");
                rb.setUserName("Author "+i);
                badge.add(rb);
            }
        blurb.setTags(tag);
        frontPage.setRecent(tag);
        }
        
        frontPage.setBadges(badge);
        frontPage.setQuestions(Q);
        frontPage.setRecent(tag);
        
        return frontPage;
    }
    
    public static QuestionPage getQuestion(int id){
        QuestionPage test = new QuestionPage();
        test.setQuestionSlot(new Question());   
        
       if(id==1){ 
        
        test.setTitle("I'm a Test");
        test.setQuestion("Am I really a test, I'm not really sure, but I sure do know that I'm something that can fill alot of space by rambling. This extra text here is to check if we wrap for words.                                        <pre class=\"lang-cs prettyprint prettyprinted\" style>\n" +
"<code>\n" +
"Public Class Rabbit implements Bunny{\n" +
"public static void main(String[] args){\n" +
"    System.out.println(\"I'm A Rabbit\");\n" +
"}\n" +
"}\n" +
"</code>\n" +
"                                            </pre>");
        test.setSubmitted("Jan 31, 1943");
        test.setQuestionID("1");
        test.setAuthor("Denny Scott");
        test.setAuthorID("1");
        test.setVotes(10);
        test.setCount(300);
        test.setSchool("1903");
        
        Tags one = new Tags();
        one.setID("1");
        one.setTag("Java");
        one.setCount(10);
        
        Tags two = new Tags();
        two.setID("2");
        two.setTag("Inheritance");
        two.setCount(5);
        
        Tags three = new Tags();
        three.setID("3");
        three.setTag("cakes");
        three.setCount(100);
        
        ArrayList<Tags> t = new ArrayList<Tags>();
        t.add(one);
        t.add(two);
        test.setTags((ArrayList<Tags>)t.clone());
        t.add(three);
        test.setRecent(t);
        
        ArrayList<Comments> c = new ArrayList<Comments>();
        Comments c1 = new Comments();
        c1.setAuthor("Travis Scott");
        c1.setComment("This was some fantastic input!");
        c1.setID(1);
        c1.setAuthorID(2);
        c1.setSubmitted("Jan 15, 2013");
        c1.setVotes(10);
        
        Comments c2 = new Comments();
        c2.setAuthor("Denny Scott");
        c2.setAuthorID(1);
        c2.setComment("It always is!");
        c2.setID(2);
        c2.setSubmitted("Jan 15, 2013");
        c2.setVotes(10);
        
        c.add(c1);
        c.add(c2);
        
        test.setComments(c);
        
        
        Answers answer = new Answers();
        Answers answer2 = new Answers();
        ArrayList<Answers> answerArray  = new ArrayList<Answers>();
        answer.setAnswer("Denny you already know the answer to this question, why would you ask something like this? You're way super cool and we all love you!");
        answer.setAuthor("Travis Scott");
        answer.setComments(c);
        answer.setID("1");
        answer.setSubmitted("Jan 15, 2013");
        answer.setVotes(10000);
        answer.setAuthorID("2");
        
        answer2.setAnswer("I always wish I could be exactly like denny, I was thinking of stealing his answer and trying to pass it off as myself!");
        answer2.setAuthor("Nick Reid");
        answer2.setComments(c);
        answer2.setID("2");
        answer2.setSubmitted("Jan 15, 2013");
        answer2.setVotes(-2);
        answer2.setAuthorID("3");
        
        answerArray.add(answer);
        answerArray.add(answer2);
        
        test.setAnswers(answerArray);
        ArrayList<RecentBadges> badge = new ArrayList<RecentBadges>();
        for(int i = 0; i<5; i++){
            
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i+"");
                
                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i+"");
                rb.setUserName("Author "+i);
                badge.add(rb);
                if(i<2){
                b.setColor(MedalColor.GOLD);
                }
                else if(i<3){
                    b.setColor(MedalColor.SILVER);
                }
                else{
                    b.setColor(MedalColor.BRONZE);
                }
            
        }
        
        test.setBadges(badge);
       }
       else{test.setTitle("I'm a naughty Test");
        test.setQuestion("Am I really a test, I'm not really sure, but I sure do know that I'm something that can fill alot of space by rambling.");
        test.setSubmitted("Jan 31, 1943");
           
       }
        return test;
    }
    
    public static CoursePage getCourses(){
        CoursePage courses = new CoursePage();
        ArrayList<Courses> bAdd = new ArrayList<Courses>();
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        Random rand = new Random();
        
        for(int i = 0; i<20; i++){
        Courses b = new Courses();
        b.setCourse(i+"903");
        b.setId(i);
        b.setTotal(rand.nextInt(100));
        b.setDescription("This is a description for the course. Intro To Programming.");
        
            if(i<5){
                Badges c = new Badges();
                c.setBadge("Badge " + i);
                c.setId(i+"");
                if(i<2){
                c.setColor(MedalColor.GOLD);
                }
                else if(i<3){
                    c.setColor(MedalColor.SILVER);
                }
                else{
                    c.setColor(MedalColor.BRONZE);
                }
                        
                
                RecentBadges rb = new RecentBadges();
                rb.setBadge(c);
                rb.setUserID(i+"");
                rb.setUserName("Author "+i);
                bAdd1.add(rb);
            }
            
            if(i<3){
            Tags t = new Tags();
            t.setCount(rand.nextInt(100));
            t.setID(i+"");
            t.setTag("Java " + i);
            
            tag.add(t);
            
            }
            bAdd.add(b);
        }
        
        courses.setCourses(bAdd);
        courses.setBadges(bAdd1);
        courses.setRecent(tag);
        
        return courses;
        
        
    }
}
