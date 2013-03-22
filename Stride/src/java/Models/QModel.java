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

    public static SingleUserPage getUser() {
        SingleUserPage user = new SingleUserPage();
        Random rand = new Random();

        user.setVotesDown(rand.nextInt(100));
        user.setVotesUp(rand.nextInt(100));
        Users u = new Users();
        u.setBio("I'm passionate about programming and PHP. I love to be in a teamwork environment and of course I love being a technical manager. Finally, I love my work.");
        u.setEmail("DennyScott301@gmail.com");
        u.setFirstName("Denny");
        u.setLastName("Scott");
        u.setImg("img/kip.jpg");
        u.setRank("Tutor");
        u.setNumberAnswers(rand.nextInt(100));
        u.setNumberQuestions(rand.nextInt(100));
        u.setReputation(rand.nextInt(100));
        u.setUser("Kip Drordy");
        u.setUserID(1 + "");
        u.setVotes(rand.nextInt(100));
        u.setGold(rand.nextInt(100));
        u.setSilver(rand.nextInt(100));
        u.setBronze(rand.nextInt(100));
        u.setJoinedDate("Jan 12, 2012");
        u.setLastOnline("Jan 13, 2013");
        

        ArrayList<Tags> tags = new ArrayList<Tags>();
        ArrayList<Answers> answers = new ArrayList<Answers>();
        ArrayList<Question> questions = new ArrayList<Question>();
        ArrayList<Courses> courses = new ArrayList<Courses>();
        ArrayList<Badges> badge = new ArrayList<Badges>();
        
        for(int i=0; i<5; i++){
            Tags t = new Tags();
            Answers a = new Answers();
            Question q = new Question();
            Courses c = new Courses();
            
             Badges d = new Badges();
                d.setBadge("Badge " + i);
                d.setColor(1);
                d.setDescription("Im a badge");
                d.setId(i + "");
                d.setTotal(rand.nextInt());
                badge.add(d);
                
            t.setCount(rand.nextInt(100));
            t.setDescription("Tag description " + i);
            t.setID(i+"");
            t.setTag("Tag " + i);
            tags.add(t);
            
            a.setAnswer("This is how you answer " + i);
            a.setAuthor("Kip");
            a.setAuthorID(i+"");
            a.setQuestionID(i+"");
            a.setID(i+"");
            a.setLastUpdated("Jan 13, 2012");
            a.setSubmitted("Jan 13, 2012");
            a.setVotes(rand.nextInt(100));
            
            answers.add(a);
            
            q.setAnswers(rand.nextInt(100));
            q.setAuthor("Kip");
            q.setAuthorID(i+"");
            q.setCount(rand.nextInt(100));
            q.setLastUpdated("Jan 13, 2013");
            q.setQuestion("How do I do " + i);
            q.setQuestionID(i+"");
            q.setSchool("1903");
            q.setSubmitted("Jan 13, 2013");
            q.setTitle("Title to question " + i);
            q.setVotes(rand.nextInt(100));
            
            questions.add(q);
            
            c.setCourse("190" + i);
            c.setDescription("This course is above something");
            c.setId(i);
            c.setTotal(rand.nextInt(100));
            
            courses.add(c);
        }
        
        user.setUserBadges(badge);
        user.setUser(u);
        user.setAnswers(answers);
        user.setQuestions(questions);
        user.setTags(tags);
        user.setCourses(courses);
        user.setTagTimes(rand.nextInt(100));
        user.setAnswerVotes(rand.nextInt(100));
        user.setQuestionVotes(rand.nextInt(100));
        
        return user;
        
    }

    public static UserPage getUsers() {
        UserPage tag = new UserPage();
        ArrayList<Users> tags = new ArrayList<Users>();
        ArrayList<Badges> badge = new ArrayList<Badges>();

        Random rand = new Random();

        for (int i = 0; i < 40; i++) {
            Users t = new Users();
            t.setEmail("DennyScott301@gmail.com");
            t.setFirstName("Denny");
            t.setLastName("Scott");
            t.setImg("img/kip.jpg");
            t.setRank("Tutor");
            t.setNumberAnswers(rand.nextInt(100));
            t.setNumberQuestions(rand.nextInt(100));
            t.setReputation(rand.nextInt(100));
            t.setUser("Kip Drordy");
            t.setUserID(i + "");
            t.setVotes(rand.nextInt(100));

            for (int g = 0; g < 3; g++) {
                Badges c = new Badges();
                c.setBadge("Badge " + g);
                c.setColor(1);
                c.setDescription("Im a badge");
                c.setId(g + "");
                c.setTotal(rand.nextInt());
                badge.add(c);
            }
            badge = new ArrayList<Badges>();
            tags.add(t);
        }


        tag.setUsers(tags);


        return tag;
    }

    public static SingleCoursePage getCourse(int id) {

        SingleCoursePage tag = new SingleCoursePage();
        ArrayList<Tags> tags = new ArrayList<Tags>();
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Blurb> blurb = new ArrayList<Blurb>();
        ArrayList<Tags> questionTags = new ArrayList<Tags>();
        Random rand = new Random();

        Courses t = new Courses();
        t.setCourse("1903");
        t.setId(1);
        t.setTotal(rand.nextInt(100));
        t.setDescription("Programming Fundamentals 1. Learn about the basic building blocks of a program, such as Data Types, Classes, Object Oriented Programming, methods and more.");
        tag.setCourse(t);

        for (int i = 0; i < 5; i++) {
            if (i < 5) {
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i + "");
                if (i < 2) {
                    b.setColor(1);
                } else if (i < 3) {
                    b.setColor(2);
                } else {
                    b.setColor(1);
                }


                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i + "");
                rb.setUserName("Author " + i);
                bAdd1.add(rb);
            }

            if (i < 3) {
                Tags b = new Tags();
                b.setCount(rand.nextInt(100));
                b.setID(i + "");
                b.setTag("Java " + i);

                tags.add(b);

            }
        }

        for (int c = 0; c < 10; c++) {
            Question temp = new Question();
            temp.setAuthor("Denny Scott");
            temp.setAuthorID(c + "");
            temp.setCount(rand.nextInt(100));
            temp.setLastUpdated("January 13, 2012");
            temp.setQuestion("I have a question with " + c + ". This is just some words to extend the excerpt to see how the formatting would look. I'm really just rambling on to fill some space. That should do!");
            temp.setQuestionID(c + "");
            temp.setSchool("1903");
            temp.setSubmitted("January 13, 2012");
            temp.setTitle("Title to question " + c);
            temp.setVotes(rand.nextInt(100));

            Blurb b1 = new Blurb();
            b1.setQuestion(temp);

            if (c < 3) {
                Tags t1 = new Tags();
                t1.setCount(rand.nextInt(100));
                t1.setDescription("Im a tag");
                t1.setID(c + "");
                t1.setTag("Java " + c);
                questionTags.add(t1);

            }
            b1.setTags(questionTags);

            blurb.add(b1);
        }

        tag.setBadges(bAdd1);
        tag.setRecent(tags);
        tag.setQuestions(blurb);


        return tag;
    }

    public static SingleTagPage getTag() {

        SingleTagPage tag = new SingleTagPage();
        ArrayList<Tags> tags = new ArrayList<Tags>();
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Blurb> blurb = new ArrayList<Blurb>();
        ArrayList<Tags> questionTags = new ArrayList<Tags>();


        Tags t = new Tags();
        t.setID(1 + "");
        t.setTag("c#");
        Random rand = new Random();
        t.setCount(rand.nextInt(100));
        t.setDescription(" a multi-paradigm programming language encompassing strong typing, imperative, declerative, functional, generic, object-oriented (class-based), and component oriented programming disciplines.");

        tag.setTag(t);

        for (int i = 0; i < 5; i++) {
            if (i < 5) {
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i + "");
                if (i < 2) {
                    b.setColor(1);
                } else if (i < 3) {
                    b.setColor(2);
                } else {
                    b.setColor(3);
                }


                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i + "");
                rb.setUserName("Author " + i);
                bAdd1.add(rb);
            }

            if (i < 3) {
                Tags b = new Tags();
                b.setCount(rand.nextInt(100));
                b.setID(i + "");
                b.setTag("Java " + i);

                tags.add(b);

            }
        }

        for (int c = 0; c < 10; c++) {
            Question temp = new Question();
            temp.setAuthor("Denny Scott");
            temp.setAuthorID(c + "");
            temp.setCount(rand.nextInt(100));
            temp.setLastUpdated("January 13, 2012");
            temp.setQuestion("I have a question with " + c + ". This is just some words to extend the excerpt to see how the formatting would look. I'm really just rambling on to fill some space. That should do!");
            temp.setQuestionID(c + "");
            temp.setSchool("1903");
            temp.setSubmitted("January 13, 2012");
            temp.setTitle("Title to question " + c);
            temp.setVotes(rand.nextInt(100));

            Blurb b1 = new Blurb();
            b1.setQuestion(temp);

            if (c < 3) {
                Tags t1 = new Tags();
                t1.setCount(rand.nextInt(100));
                t1.setDescription("Im a tag");
                t1.setID(c + "");
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

    public static TagPage getTags() {
        TagPage tag = new TagPage();
        ArrayList<Tags> tags = new ArrayList<Tags>();

        Random rand = new Random();

        for (int i = 0; i < 40; i++) {
            Tags t = new Tags();
            t.setID(i + "");
            t.setTag("c# " + i);

            t.setCount(rand.nextInt(100));

            t.setDescription(" a multi-paradigm programming language encompassing strong typing, imperative, declerative, functional, generic, object-oriented (class-based), and component oriented programming disciplines.");
            tags.add(t);
        }


        tag.setTags(tags);


        return tag;
    }

    public static BadgePage getBadges() {
        BadgePage badge = new BadgePage();
        ArrayList<Badges> bAdd = new ArrayList<Badges>();
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            Badges b = new Badges();
            b.setBadge("Badge " + i);
            b.setId(i + "");
            b.setDescription("This is a test to see how the description would work, this is for badge " + i + " and we are seeing whether the text would wrap and look appropriate. Im making this longer to see if the word wrapping still goes into the legend.");


            b.setTotal(rand.nextInt(100));

            if (i < 10) {
                b.setColor(1);
            } else if (i < 15) {
                b.setColor(2);
            } else {
                b.setColor(3);
            }

            bAdd.add(b);
        }

        badge.setBadgeInfo(bAdd);

        for (int i = 0; i < 5; i++) {
            if (i < 5) {
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i + "");
                if (i < 2) {
                    b.setColor(1);
                } else if (i < 3) {
                    b.setColor(2);
                } else {
                    b.setColor(3);
                }


                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i + "");
                rb.setUserName("Author " + i);
                bAdd1.add(rb);
            }

            if (i < 3) {
                Tags t = new Tags();
                t.setCount(rand.nextInt(100));
                t.setID(i + "");
                t.setTag("Java " + i);

                tag.add(t);

            }
        }

        badge.setBadges(bAdd1);
        badge.setRecent(tag);

        return badge;


    }

    public static SingleBadgePage getBadge(int id) {
        SingleBadgePage badge = new SingleBadgePage();

        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        Random rand = new Random();


        Badges b = new Badges();
        b.setBadge("Badge Title ");
        b.setId("1");
        b.setDescription("This is a test to see how the description would work, this is for badge and we are seeing whether the text would wrap and look appropriate. Im making this longer to see if the word wrapping still goes into the legend.");


        b.setTotal(rand.nextInt(100));


        b.setColor(1);



        badge.setBadgeInfo(b);

        for (int i = 0; i < 5; i++) {
            if (i < 5) {
                Badges c = new Badges();
                c.setBadge("Badge " + i);
                c.setId(i + "");
                if (i < 2) {
                    c.setColor(1);
                } else if (i < 3) {
                    c.setColor(2);
                } else {
                    c.setColor(3);
                }


                RecentBadges rb = new RecentBadges();
                rb.setBadge(c);
                rb.setUserID(i + "");
                rb.setUserName("Author " + i);
                bAdd1.add(rb);
            }

            if (i < 3) {
                Tags t = new Tags();
                t.setCount(rand.nextInt(100));
                t.setID(i + "");
                t.setTag("Java " + i);

                tag.add(t);

            }
        }

        badge.setBadges(bAdd1);
        badge.setRecent(tag);

        return badge;


    }

    public static Front getFront() {

        Front frontPage = new Front();
        Blurb questions = new Blurb();

        ArrayList<Blurb> Q = new ArrayList<Blurb>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        ArrayList<RecentBadges> badge = new ArrayList<RecentBadges>();

        for (int i = 0; i < 10; i++) {
            Q.add(new Blurb());
            Blurb blurb = Q.get(i);
            Question temp = new Question();
            temp.setAuthor("Author " + i);
            temp.setAuthorID(i + "");

            Random rand = new Random();
            temp.setCount(rand.nextInt(100));
            temp.setAnswers(rand.nextInt(100));

            temp.setQuestion("This is a tempory blurb for the question.");
            temp.setQuestionID(i + "");
            temp.setSchool("3909");
            temp.setSubmitted("2013-03-12");
            temp.setTitle("This is the Title to the question " + i);
            temp.setVotes(rand.nextInt(100));

            blurb.setQuestion(temp);
            if (i < 3) {
                Tags t = new Tags();
                t.setCount(rand.nextInt(100));
                t.setID(i + "");
                t.setTag("Java " + i);

                tag.add(t);

            }

            if (i < 5) {
                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i + "");
                if (i < 2) {
                    b.setColor(1);
                } else if (i < 3) {
                    b.setColor(2);
                } else {
                    b.setColor(3);
                }


                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i + "");
                rb.setUserName("Author " + i);
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

    public static QuestionPage getQuestion(int id) {
        QuestionPage test = new QuestionPage();
        test.setQuestionSlot(new Question());

        if (id == 1) {

            test.setTitle("I'm a Test");
            test.setQuestion("Am I really a test, I'm not really sure, but I sure do know that I'm something that can fill alot of space by rambling. This extra text here is to check if we wrap for words.                                        <pre class=\"lang-cs prettyprint prettyprinted\" style>\n"
                    + "<code>\n"
                    + "Public Class Rabbit implements Bunny{\n"
                    + "public static void main(String[] args){\n"
                    + "    System.out.println(\"I'm A Rabbit\");\n"
                    + "}\n"
                    + "}\n"
                    + "</code>\n"
                    + "                                            </pre>");
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
            test.setTags((ArrayList<Tags>) t.clone());
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
            ArrayList<Answers> answerArray = new ArrayList<Answers>();
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
            for (int i = 0; i < 5; i++) {

                Badges b = new Badges();
                b.setBadge("Badge " + i);
                b.setId(i + "");

                RecentBadges rb = new RecentBadges();
                rb.setBadge(b);
                rb.setUserID(i + "");
                rb.setUserName("Author " + i);
                badge.add(rb);
                if (i < 2) {
                    b.setColor(1);
                } else if (i < 3) {
                    b.setColor(2);
                } else {
                    b.setColor(3);
                }

            }

            test.setBadges(badge);
        } else {
            test.setTitle("I'm a naughty Test");
            test.setQuestion("Am I really a test, I'm not really sure, but I sure do know that I'm something that can fill alot of space by rambling.");
            test.setSubmitted("Jan 31, 1943");

        }
        return test;
    }

    public static CoursePage getCourses() {
        CoursePage courses = new CoursePage();
        ArrayList<Courses> bAdd = new ArrayList<Courses>();
        ArrayList<RecentBadges> bAdd1 = new ArrayList<RecentBadges>();
        ArrayList<Tags> tag = new ArrayList<Tags>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            Courses b = new Courses();
            b.setCourse(i + "903");
            b.setId(i);
            b.setTotal(rand.nextInt(100));
            b.setDescription("This is a description for the course. Intro To Programming.");

            if (i < 5) {
                Badges c = new Badges();
                c.setBadge("Badge " + i);
                c.setId(i + "");
                if (i < 2) {
                    c.setColor(1);
                } else if (i < 3) {
                    c.setColor(2);
                } else {
                    c.setColor(3);
                }


                RecentBadges rb = new RecentBadges();
                rb.setBadge(c);
                rb.setUserID(i + "");
                rb.setUserName("Author " + i);
                bAdd1.add(rb);
            }

            if (i < 3) {
                Tags t = new Tags();
                t.setCount(rand.nextInt(100));
                t.setID(i + "");
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
