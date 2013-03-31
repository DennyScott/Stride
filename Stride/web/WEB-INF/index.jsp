<%-- 
    Document   : index
    Created on : 24-Jan-2013, 4:44:46 PM
    Author     : Denny
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="javascript/yaphet.js"></script>
        <script type="text/javascript" src="javascript/Stride.js"></script>
        <script type="text/javascript" src="javascript/sonic.js"></script>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

        <title>Stride</title>
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
                            Top Questions
                        </h1>
                        <div id="tabs">
                            <a class="youarehere" href="home" title="You are here!">Interesting</a>
                            <a href="home" class="otherTab">
                                <span class="quick-need">100</span>
                                Open Bounties
                            </a>
                            <a href="home?hot=true" class="otherTab">Votes</a>
                        </div>
                    </div>

                    <div id="question-list">

                        <!-- Question -->
                        <c:forEach items="${bean.getQuestions()}" var="question" varStatus="count">
                            <c:if test="${bean.getCookieSize() ge count.count}">
                                <div class="question-summary" style="background-color: rgba(200,200,200,0.5)"id="${question.getQuestion().getQuestionID()}">
                                </c:if>
                                <c:if test="${bean.getCookieSize() lt count.count}">
                                    <div class="question-summary" id="${question.getQuestion().getQuestionID()}">
                                    </c:if>

                                    <div onclick="window.location.href='home?id=${question.getQuestion().getQuestionID()}'" class="cp" >
                                        <div class="votes">
                                            <div class="mini-counts">${question.getQuestion().getVotes()}</div>
                                            <div class="prefix">votes</div>
                                        </div>

                                        <div class="unanswered">
                                            <div class="mini-counts">${question.getQuestion().getAnswers()}</div>
                                            <div class="prefix">answers</div>
                                        </div>

                                        <div class="views">
                                            <div class="mini-counts">${question.getQuestion().getCount()}</div>
                                            <div class="prefix">views</div>
                                        </div>
                                    </div>

                                    <div class="summary">
                                        <h3>
                                            <a href="home?id=${question.getQuestion().getQuestionID()}" class ="question-hyperlink" title="title here">
                                                ${question.getQuestion().getTitle()}
                                            </a>
                                        </h3>

                                        <div class="tags">
                                            <c:forEach items="${question.getTags()}" var="tags">
                                                <a href="tags?id=${tags.getID()}" class="post-tag" title="Title about ${tags.getTag()}" rel="tag">${tags.getTag()}</a>
                                            </c:forEach>
                                        </div>

                                        <div class="started">
                                            <span class="started-link">
                                                <span title="2013-01-25 05:46:00" class="relativetime">${question.getQuestion().getSubmitted()}</span>
                                            </span>
                                            <a href="Users?id=${question.getQuestion().getAuthorID()}">${question.getQuestion().getUser().getUser()}</a>
                                            <span class="reputation-score" title="reputation-score" dir="ltr">${question.getQuestion().getUser().getReputation()}</span>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                            <!-- End of Question -->
                        </div>
                    </div>

                    <div id="sideContent">
                        <jsp:include page="newUserWelcome.jsp" />

                        <%@include file="recentTags.jsp" %>

                        <%@include file="recentJobs.jsp" %>

                        <%@include file="recentBadges.jsp" %>

                    </div>



                </div>

                <jsp:include page = "footerShortcut.jsp" />
            </div>
    </body>
</html>
