<%-- 
    Document   : about
    Created on : 22-Mar-2013, 5:35:59 PM
    Author     : Yaphet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="javascript/Sonic.js"></script>
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <link href="css/about.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="javascript/Stride.js"></script>
        <script type="text/javascript" src="javascript/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="javascript/jquery-ui-1.10.2.custom.min.js"></script>
        <script src="javascript/waypoints.js"></script>

        <title>About</title>
    </head>
    <body onload="setZoom()">
<div id="in"></div>
        <div id ="wholePage">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content" >
            <div id="about-intro">
                <h2 id="top">Welcome to Stride!</h2>
                <div id="strideSymbol" >
                </div>
                <div class="col-full">
                    <p>

                    </p><div class="wiki-ph" data-placeholder="WikiPlaceholder-AboutThisSite">
                        <div class="wiki-ph-content"><p><strong>Stride</strong> is a question and answer site for professional and enthusiast programmers. It's built and run <em>by you</em> as part of the <a href="home">Stride</a> network of Q&amp;A sites. With your help, we're working together to build a library of detailed answers to every question about programming.</p>
                        </div> 


                    </div>
                    <p></p>

                    <p class="helper-textTop">
                        We're a little bit different from other sites. Here's how:
                    </p>
                </div>
            </div>
            <hr>
            <div id="ask">
                <div class="about-qa">
                    <h2 id="top" class="about-title">Ask questions, get answers, no distractions</h2>
                    <div class="col-l">
                        <p>Stride is all about <strong>getting answers</strong>. It's not a discussion forum. There's no chit-chat.</p>

                        <div class="just-qa" style="height: 275px;">
                            <div class="just-questions" style="position: relative; z-index: 100; top: 6.5px; left: 46px;"><p>Just questions...</p> <div id ="firstArrow" style="opacity: 1;"></div></div>
                            <div class="just-answers" style="position: relative; z-index: 100; top: 81px; left: 46px;"><p>...and answers.</p> <div id ="secondArrow" style="opacity: 1;"></div></div>
                        </div>

                        <div class="good-answers">
                            <span class="customVoteOn fl helper"></span>
                            <p>Good answers are voted up and <strong>rise to the top</strong>.</p>
                            <p class="helper-text">The best answers show up first so that they are always easy to find.</p>
                        </div>

                        <div class="accept-answers">
                            <span class="vote-accepted-on fl helper">accept</span>
                            <p>The person who asked can mark one answer as "accepted".</p>
                            <p class="helper-text">Accepting doesn't mean it's the best answer, it just means that it worked for the person who asked.</p>
                        </div>

                    </div>


                    <div id="noDistractions"class="newTest" >
                        <div class="shadow">
                            <div class="qa-block" style="position: relative; left: 0px;">
                                <div id="question-header">
                                    <h1 class="question-hyperlink">Why are function pointers and data pointers incompatible in C/C++?</h1>
                                </div>
                                <div class="about-q">
                                    <div class="votecell fl">
                                        <div class="vote">
                                            <span class="vote-up-off" style="cursor: default;"></span>
                                            <span class="vote-count-post">14</span>
                                            <span class="vote-down-off" style="cursor: default;">down vote</span>
                                            <span class="star-off" style="cursor: default;"></span>
                                            <div class="favoritecount"><b></b></div>
                                        </div>
                                    </div>

                                    <div class="postcell">
                                        <div class="post-text"><p>I have read that converting a function pointer to a data pointer and vice versa works on most platforms but is not guaranteed to work. Why is this the case? Shouldn't both be simply addresses into main memory and therefore be compatible?</p>
                                        </div> 

                                        <div class="post-taglist">
                                            <a href="" onclick="return false;" class="post-tag" title="show questions tagged 'c++'" rel="tag">c++</a> <a href="" onclick="return false;" class="post-tag" title="show questions tagged 'c'" rel="tag">c</a> <a href="" onclick="return false;" class="post-tag" title="show questions tagged 'pointers'" rel="tag">pointers</a> <a href="" onclick="return false;" class="post-tag" title="" rel="tag">function-pointers</a> 
                                        </div>

                                        <div class="post-signature owner ">
                                            <div class="user-info ">
                                                <div class="user-action-time">
                                                    asked <span title="2012-09-10 20:21:39Z" class="relativetime">Sep 10 '12 at 20:21</span>
                                                </div>
                                                <div class="user-gravatar32">
                                                    <div class="about-user1">
                                                        <div class=""><img src="http://www.gravatar.com/avatar/35f197e2a80f31500ef249c3823a44f9?s=32&amp;d=identicon&amp;r=PG" alt="" width="32" height="32"></div>
                                                    </div>
                                                </div>
                                                <div class="user-details">
                                                    gexicide<br>
                                                    <span class="reputation-score" title="reputation score" dir="ltr">1,862</span><span title="2 silver badges"><span class="badge2"></span><span class="badgecount">2</span></span><span title="12 bronze badges"><span class="badge3"></span><span class="badgecount">12</span></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="subheader answers-subheader">
                                    <h3>2 Answers</h3>
                                </div>
                                <div id ="first"class="about-a">
                                    <div class="votecell fl">
                                        <div class="vote">
                                            <span class="vote-up-off" style="cursor: default;"></span>
                                            <span class="vote-count-post">3</span>
                                            <span class="vote-down-off" style="cursor: default;">down vote</span>
                                        </div>
                                    </div>

                                    <div class="postcell">
                                        <div class="post-text">
                                            <p>Pointers to void are supposed to be able to accommodate a pointer to any kind of data -- but not necessarily a pointer to a function. Some systems have different requirements for pointers to functions than pointers to data (e.g, there are DSPs with different addressing for data vs. code, medium model on MS-DOS used 32-bit pointers for code but only 16-bit pointers for data).</p>

                                        </div>

                                        <div class="post-signature ">
                                            <div class="user-info ">
                                                <div class="user-action-time">
                                                    answered <span title="2011-02-07 18:00:56Z" class="relativetime">Feb 7 '11 at 18:00</span>
                                                </div>
                                                <div class="user-gravatar32">
                                                    <div class="about-user2">
                                                        <div class=""><img src="http://www.gravatar.com/avatar/d8962238339d771f0348967be6f97b1b?s=32&amp;d=identicon&amp;r=PG" alt="" width="32" height="32"></div>
                                                    </div>
                                                </div>
                                                <div class="user-details">
                                                    Jerry Coffin<br>
                                                    <span class="reputation-score" title="reputation score 172450" dir="ltr">172k</span><span title="10 gold badges"><span class="badge1"></span><span class="badgecount">10</span></span><span title="124 silver badges"><span class="badge2"></span><span class="badgecount">124</span></span><span title="355 bronze badges"><span class="badge3"></span><span class="badgecount">355</span></span>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                                <div id="second" class="about-a">
                                    <div class="votecell fl">
                                        <div class="vote">
                                            <span class="vote-up-off" style="cursor: default;"></span>
                                            <span class="vote-count-post">3</span>
                                            <span class="vote-down-off" style="cursor: default;">down vote</span>
                                            <span class="vote-accepted-off" style="cursor: default;">accept</span>
                                        </div>
                                    </div>

                                    <div class="postcell">
                                        <div class="post-text">
                                            <p>An architecture doesn't have to store code and data in the same memory. With a Harvard architecture, code and data are stored in completely different memory. Most architectures are Von Neumann architectures with code and data in the same memory but C doesn't limit itself to only certain types of architectures if at all possible.</p>

                                        </div>


                                        <div class="post-signature ">
                                            <div class="user-info ">
                                                <div class="user-action-time">
                                                    answered <span title="2012-09-10 20:26:03Z" class="relativetime">Sep 10 '12 at 20:26</span>
                                                </div>
                                                <div class="user-gravatar32">
                                                    <div class="about-user2">
                                                        <div class=""><img src="http://www.gravatar.com/avatar/155591985f31e211ef897f8393c489e4?s=32&amp;d=identicon&amp;r=PG" alt="" width="32" height="32"></div>
                                                    </div>
                                                </div>
                                                <div class="user-details">
                                                    Dirk Holsopple<br>
                                                    <span class="reputation-score" title="reputation score" dir="ltr">4,486</span><span title="1 gold badge"><span class="badge1"></span><span class="badgecount">1</span></span><span title="4 silver badges"><span class="badge2"></span><span class="badgecount">4</span></span><span title="17 bronze badges"><span class="badge3"></span><span class="badgecount">17</span></span>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                                <div id="third">
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <hr>


            <div class="about-tags">
                <h2 class="about-title">Tags make it easy to find interesting questions</h2> 

                <div class="col-l">
                    <p>All questions are <strong>tagged</strong> with their subject areas. Each can have up to 5 tags, since a question might be related to several subjects.</p>
                    <p><strong>Click any tag</strong> to see a list of questions with that tag, or go to the <a href="Tags">tag list</a> to browse for topics that interest you.</p>
                    <div class="arrow2Marker" style="position: relative; z-index: 100; top: -35.5px; left: 116px; opacity: 1;"></div>
                </div>

                <div class="tagBlock">
                    <div class="shadow tagColumn">
                        <div class="qa-block" style="position: relative; left: 0px;">
                            <div id="question-header">
                                <h1 class="question-hyperlink">Why are function pointers and data pointers incompatible in C/C++?</h1>
                            </div>

                            <div class="about-q">
                                <div class="votecell fl">
                                    <div class="vote">
                                        <span class="vote-up-off" style="cursor: default;"></span>
                                        <span class="vote-count-post">14</span>
                                        <span class="vote-down-off" style="cursor: default;">down vote</span>
                                        <span class="star-off" style="cursor: default;"></span>
                                        <div class="favoritecount"><b></b></div>
                                    </div>
                                </div>

                                <div class="postcell">
                                    <div class="post-text"><p>I have read that converting a function pointer to a data pointer and vice versa works on most platforms but is not guaranteed to work. Why is this the case? Shouldn't both be simply addresses into main memory and therefore be compatible?</p>
                                    </div> 

                                    <div class="post-taglist">
                                        <a href="" onclick="return false;" class="post-tag" title="show questions tagged 'c++'" rel="tag">c++</a> <a href="" onclick="return false;"class="post-tag" title="show questions tagged 'c'" rel="tag">c</a> <a href="" onclick="return false;" class="post-tag" title="show questions tagged 'pointers'" rel="tag">pointers</a> <a href="" onclick="return false;" class="post-tag" title="" rel="tag">function-pointers</a> 
                                    </div>

                                    <div class="post-signature owner ">
                                        <div class="user-info ">
                                            <div class="user-action-time">
                                                asked <span title="2012-09-10 20:21:39Z" class="relativetime">Sep 10 '12 at 20:21</span>
                                            </div>
                                            <div class="user-gravatar32">
                                                <div class="about-user1">
                                                    <div class=""><img src="http://www.gravatar.com/avatar/35f197e2a80f31500ef249c3823a44f9?s=32&amp;d=identicon&amp;r=PG" alt="" width="32" height="32"></div>
                                                </div>
                                            </div>
                                            <div class="user-details">
                                                gexicide<br>
                                                <span class="reputation-score" title="reputation score" dir="ltr">1,862</span><span title="2 silver badges"><span class="badge2"></span><span class="badgecount">2</span></span><span title="12 bronze badges"><span class="badge3"></span><span class="badgecount">12</span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <hr>

            <div class="about-reputation">
                <h2 class="about-title">You earn reputation when people vote on your posts</h2>

                <div class="about-rep-score col-l">
                    <p>Your reputation score goes up when others <strong>vote up</strong> your questions, answers and edits.</p>
                    <div class="arrow3Marker" style="position: relative; z-index: 100; top: -44.5px; left: 119px; opacity: 1;"></div>
                </div>

                <div class="repArea">
                    <div class="shadow">

                        <div class="all-rep-block" style="position: relative; left: 0px;">
                            <div class="user-info-rep">
                                <div class="about-gravatar"></div>
                                <div class="user-details">
                                    John Doe<br>United States
                                    <br>
                                    <span class="reputation-score" title="reputation score" dir="ltr">245</span>
                                    <span title="3 gold badges"><span class="badge1"></span><span class="badgecount">3</span></span>
                                    <span title="22 silver badges"><span class="badge2"></span><span class="badgecount">22</span></span>
                                    <span title="74 bronze badges"><span class="badge3"></span><span class="badgecount">74</span></span>
                                </div>
                            </div>

                            <div class="fr user-info-mini">
                                <div class="rep-block fl">
                                    <span class="rep-up">+5</span>
                                    question voted up
                                </div>
                                <div class="rep-block fl">
                                    <span class="rep-up">+10</span>
                                    answer voted up
                                </div>
                                <div class="rep-block fl">
                                    <span class="rep-up">+15</span>
                                    answer is accepted
                                </div>
                                <div class="rep-block fl">
                                    <span class="rep-up">+2</span>
                                    edit approved
                                </div>
                            </div>
                        </div>

                    </div>
                </div>


                <div class="about-rep-privs col-l">
                    <p>As you earn reputation, you'll <a href="" onclick="return false;">unlock new privileges</a> like the ability to vote, comment, and even edit other people's posts.</p>
                    <div class="arrow4Marker" style="position: relative; z-index: 100; top: -48.5px; left: 81px; opacity: 1;"></div>
                </div>

                <div class="repArea2 repPrivTable">
                    <div class="">
                        <div class="content-block" style="position: relative; left: 0px;">
                            <table>
                                <thead>
                                    <tr><th>Reputation</th><th>Privilege</th></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>15</th>
                                        <td>Vote up</td>
                                    </tr>
                                    <tr>
                                        <th>50</th>
                                        <td>Leave comments</td>
                                    </tr>
                                    <tr>
                                        <th>125</th>
                                        <td>Vote down (costs <strong>1</strong> rep on answers)</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="about-rep-privs-2 col-l">
<p>At the highest levels, you'll have access to special <strong>moderation tools</strong>. You'll be able to work alongside our <a href="" onclick="return false;">community moderators</a> to keep the site focused and helpful.</p>                    <div class="arrow5Marker" style="position: relative; z-index: 100; top: -48.5px; left: 81px; opacity: 1;"></div>
                </div>

                <div class="repArea3 repPrivTable2">
                    <div class="">
                        <div class="content-block" style="position: relative; left: 0px;">
                            <table>
                                <thead>
                                    <tr><th>Reputation</th><th>Privilege</th></tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>2000</th>
                                        <td>Edit other people's posts</td>
                                    </tr>
                                    <tr>
                                        <th>3000</th>
                                        <td>Vote to close, reopen, or migrate questions</td>
                                    </tr>
                                    <tr>
                                        <th>10000</th>
                                        <td>Access to moderation tools</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

            <hr>

            <div class="about-offtopic">
                <h2 class="about-title">Get answers to practical, detailed questions</h2>

                <div class="col-l on-topic-text">
                    <p>Focus on questions about an <strong>actual problem</strong> you have faced. Include details about what you have tried and exactly what you are trying to do.</p>
                    <div  id="arrow6Marker" style="position: relative; z-index: 100; top: -22.5px; left: 76px; opacity: 1;"></div>
                </div>

                <div id="askAboutTopic"class="newTest">

                    <div "class="on-topic-examples content-block" style="position: relative; left: 0px;">
                        <p><strong>Ask about...</strong></p>


                        <div class="wiki-ph" data-placeholder="WikiPlaceholder-AboutOnTopic">
                            <div class="wiki-ph-content"><ul>
                                    <li>Specific programming problems</li>
                                    <li>Software algorithms</li>
                                    <li>Coding techniques</li>
                                    <li>Software development tools</li></ul>
                            </div> 


                        </div>
                    </div>
                </div>

                <div class="col-l off-topic-text">
                    <p>Not all questions work well in our format. Avoid questions that are <strong>primarily opinion-based</strong>, or that are likely to <strong>generate discussion</strong> rather than answers.</p>
                    <p class="helper-text">Questions that need improvement may be <strong>closed</strong> until someone fixes them.</p>
                    <div id="arrow7Marker" style="position: relative; z-index: 100; top: -97px; left: 76px; opacity: 1;"></div>
                </div>

                <div id="dontAskAbout" class="newTest" style="white-space:nowrap;">

                    <div  class="off-topic-examples content-block" style="position: relative; left: 0px;">
                        <p><strong>Don't ask about...</strong></p>


                        <div class="wiki-ph" data-placeholder="WikiPlaceholder-AboutOffTopic">
                            <div class="wiki-ph-content"><ul>
                                    <li>Questions you haven't <em>tried</em> to find an answer for (show your work!)</li>
                                    <li>Product or service recommendations or comparisons</li>
                                    <li>Requests for lists of things, polls, opinions, discussions, etc.</li>
                                    <li>Anything not directly related to writing computer programs</li>
                                </ul>
                            </div> 


                        </div>
                    </div>

                </div>

            </div>

            <hr>

            <div class="about-editing">
                <h2 class="about-title">Improve posts by editing or commenting</h2>

                <div class="col-l">
                    <div class="editing" style="height: 153px;">
                        <p>Our goal is to have the <strong>best answers</strong> to every question, so if you see questions or answers that can be improved, you can <strong>edit</strong> them.</p>
                        <p class="helper-text">Use edits to fix mistakes, improve formatting, or clarify the meaning of a post.</p>
                        <div id="arrow8Marker" style="position: relative; z-index: 100; top: -40px; left: 155px; opacity: 1;"></div>
                    </div>

                    <div class="commenting">
                        <p>Use <strong>comments</strong> to ask for more information or clarify a question or answer.</p>

                        <p class="helper-text">You can always comment on <strong>your own</strong> questions and answers.  Once you earn 50 reputation, you can comment on anybody's post.</p>

                        <p>Remember: we're all here to learn, so be friendly and helpful!</p>

                        <div id="arrow9Marker" style="position: relative; z-index: 100; top: -75px; left: 145px; opacity: 1;"></div>
                    </div>
                </div>

                <div id="editingBlock"class="newTest">
                    <div class=" shadow">
                        <div class="qa-block qa-answer" style="position: relative; left: 0px;">
                            <div class="">
                                <div class="votecell fl">
                                    <div class="vote">
                                        <span class="vote-up-off" style="cursor: default;">up vote</span>
                                        <span class="vote-count-post">9</span>
                                        <span class="vote-down-off" style="cursor: default;">down vote</span>
                                    </div>
                                </div>

                                <div class="postcell">
                                    <div class="post-text postCellFont">
                                        <p>An architecture doesn't have to store code and data in the same memory. With a Harvard architecture, code and data are stored in completely different memory. Most architectures are Von Neumann architectures with code and data in the same memory but C doesn't limit itself to only certain types of architectures if at all possible.</p>

                                    </div>

                                    <p class="post-menu-new"><a class="edit" style="cursor: default;">edit</a></p>

                                    <div class="post-signature">
                                        <div class="user-info ">
                                            <div class="user-action-time">
                                                answered <span title="2012-09-10 20:26:03Z" class="relativetime">Sep 10 '12 at 20:26</span>
                                            </div>
                                            <div class="user-gravatar32">
                                                <div class="about-user2">
                                                    <div class=""><img src="http://www.gravatar.com/avatar/155591985f31e211ef897f8393c489e4?s=32&amp;d=identicon&amp;r=PG" alt="" width="32" height="32"></div>
                                                </div>
                                            </div>
                                            <div class="user-details">
                                                Dirk Holsopple<br>
                                                <span class="reputation-score" title="reputation score" dir="ltr">4,486</span><span title="1 gold badge"><span class="badge1"></span><span class="badgecount">1</span></span><span title="4 silver badges"><span class="badge2"></span><span class="badgecount">4</span></span><span title="17 bronze badges"><span class="badge3"></span><span class="badgecount">17</span></span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="comments postCellFont">
                                        <div class="comment-entry border-red"> <p>+1 also even if code and data are stored in the same place in physical hardware, software and memory access often prevent running data as code without operating system "approval".  DEP and the like. <br>- Michael Graczyk <span title="2012-09-10 23:05:33Z" class="relativetime">Sep 10 '12 at 23:05</span></p></div>
                                    </div>
                                    <p><a class="comments-link" style="cursor: default;">add comment</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <hr>

            <div class="about-badges">

                <h2 class="about-title">Unlock badges for special achievements</h2>

                <div class="col-l">
                    <p>Badges are special achievements you earn for participating on the site.  They come in three levels: bronze, silver, and gold.</p>

                    <div class="informed-badge" style="opacity: 1;">
                        <p>In fact, you can earn a badge just for reading this page:</p>

                        <table class="badges-page">
                            <tbody><tr>
                                    <td class="badge-cellAbout">
                                        <a href="" onclick="return false;" title="bronze badge: Read the entire about page" class="badge"><span class="badge3"></span>&nbsp;Informed</a>

                                    </td>
                                    <td>
                                        Read the entire <a href="/about">about</a> page
                                    </td>
                                </tr>

                            </tbody></table>
                    </div>
                </div>

                <div id="aboutBadgesBlock" class="newTest">
                    <div class="col-rBadges shadow">
                        <div class="qa-block" style="position: relative; left: 0px;">
                            <table class="badges-page">
                                <tbody>
                                    <tr>
                                        <td class="badge-cell">
                                            <a href="" onclick="return false;" title="bronze badge: Asked first question with score of 1 or more" class="badge"><span class="badge3"></span>&nbsp;Student</a>

                                        </td>
                                        <td>
                                            Asked first question with score of 1 or more
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="badge-cell">
                                            <a href="" onclick="return false;" title="bronze badge: First edit" class="badge"><span class="badge3"></span>&nbsp;Editor</a>

                                        </td>
                                        <td>
                                            First edit
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="badge-cell">
                                            <a href="" onclick="return false;" title="silver badge: Answer score of 25 or more" class="badge"><span class="badge2"></span>&nbsp;Good Answer</a>

                                        </td>
                                        <td>
                                            Answer score of 25 or more
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="badge-cell">
                                            <a href="" onclick="return false;" title="silver badge: Voted 300 or more times" class="badge"><span class="badge2"></span>&nbsp;Civic Duty</a>

                                        </td>
                                        <td>
                                            Voted 300 or more times
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="badge-cell">
                                            <a href="" onclick="return false;" title="gold badge: Asked a question with 10,000 views" class="badge"><span class="badge1"></span>&nbsp;Famous Question</a>

                                        </td>
                                        <td>
                                            Asked a question with 10,000 views
                                        </td>
                                    </tr>

                                </tbody>
                            </table>

                            <p><a href="Badges">see all badges</a></p>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script type="text/javascript" src="javascript/about.js"></script>



        <jsp:include page = "footerShortcut.jsp" />
        </div>
    </body>
</html>
