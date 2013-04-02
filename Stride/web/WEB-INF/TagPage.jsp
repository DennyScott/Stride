<%-- 
    Document   : TagPage
    Created on : 19-Mar-2013, 1:37:52 PM
    Author     : Denny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="java.util.ArrayList" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@page import="Beans.QuestionPage" %>
        <%@page import="Beans.Tags" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="javascript/1.2.6.js"></script>
        <script type="text/javascript" src="javascript/sonic.js"></script>
        <script type="text/javascript" src="javascript/Stride.js"></script>


        <title>Newest ${bean.getTag().getTag()} Questions</title>
    </head>
    <body onload="setZoom()">
        <div id="in"></div>
        <div id ="wholePage">

            <jsp:include page = "bannerShortcut.jsp" />
            <jsp:include page = "headerShortcut.jsp" />

            <div id="content">

                <div id="mainContent">

                    <div class="mainHeader">
                        <h1 id="topQuestions">
                            Tagged Questions
                        </h1>
                        <div id="tabs">
                            <a class="youarehere" href="home" title="You are here!">Newest</a>
                            <a href="home" class="otherTab">
                                Active
                            </a>
                            <a href="home?hot=true" class="otherTab">Unanswered</a>
                            <a href="home?hot=true" class="otherTab">Votes</a>
                        </div>
                    </div>
                    <div class="question">
                        <div class="welovestride">
                            <div class="fl">
                                <p class>
                                    ${bean.getTag().getTag()} is ${bean.getTag().getDescription()}
                                </p>

                            </div>
                        </div>


                    </div>

                    <div id="questions" class="content-padding">
                        <c:forEach items="${bean.getQuestions()}" var="blurb">
                            <div class="question-summary">
                                <div class="statscontainer">
                                    <div class="statsarrow"></div>
                                    <div class="stats">
                                        <div class="vote">
                                            <div class="votes">
                                                <span class="vote-count-post">
                                                    <strong><!--Enter vote here -->${blurb.getQuestion().getVotes()}</strong>
                                                </span>
                                                <div class="viewcount">votes</div>
                                            </div>
                                        </div>

                                        <div class="status unanswered">
                                            <Strong class="fontchange"><!--Entered Answers here -->${blurb.getQuestion().getAnswers()}</Strong>
                                            answers
                                        </div>
                                    </div>
                                    <div class="views2" title="1 views">${blurb.getQuestion().getCount()} Views <!--Change views here --></div>
                                </div>

                                <!--Question Summary -->
                                <div class="tagSummary">
                                    <h3>
                                        <a href="home?id=${blurb.getQuestion().getQuestionID()}" class="question-hyperlink">${blurb.getQuestion().getTitle()}<!--Enter Question Title--></a>
                                    </h3>
                                    <div class="tagexcerpt">${blurb.getQuestion().getQuestion()}<!--Enter Excerpt here--></div>
                                    <div class="tags">
                                        <!--For each tag-->
                                        <c:forEach items="${blurb.getTags()}" var="tags">
                                            <a href="Tags?id=${tags.getID()}" class="post-tag" title="" rel="tag"><!--Enter tag-->${tags.getTag()}</a>
                                        </c:forEach>
                                    </div>
                                    <div class="started fr">
                                        <div class="user-info">
                                            <div class="user-action-time">
                                                asked
                                                <span class="relativeTime"><!--time-->${blurb.getQuestion().getSubmitted()}</span>
                                            </div>
                                            <div class="user-gravatar32">
                                                <a href="">
                                                    <div class="gravatar-wrapper-32">
                                                        <img src="ProfilePicture?id=${blurb.getQuestion().getAuthorID()}" alt width="32" height="32"/>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="user-details">
                                                <a href="Users?id=${blurb.getQuestion().getAuthorID()}">${blurb.getQuestion().getUser().getUser()}<!--Name here--></a>
                                                <br>
                                                <span class="reputation-score" dir="ltr">${blurb.getQuestion().getUser().getReputation()} <!--Reputation--></span>
                                                <span title="Badges">

                                                    <span class="badge3"></span>
                                                    <span class="badgecount">${blurb.getQuestion().getUser().getBronze()}</span>
                                                    <span class="badge2"></span>
                                                    <span class="badgecount">${blurb.getQuestion().getUser().getSilver()}</span>
                                                    <span class="badge1"></span>
                                                    <span class="badgecount">${blurb.getQuestion().getUser().getGold()}</span>

                                                </span>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </c:forEach>



                    </div>
                </div>

                <span class="cbt"></span>

                <div id="sideContent">

                    <%@include file="recentJobs.jsp" %>

                    <%@include file="recentTags.jsp" %>

                    <%@include file="recentBadges.jsp" %>
                </div>



            </div>

            <script type="text/javascript" src="javascript/wmd.js"></script>

            <jsp:include page = "footerShortcut.jsp" />
        </div>
    </body>
</html>
