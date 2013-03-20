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

        <title>Stride</title>
    </head>
    <body>

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
                            Quick Need
                        </a>
                        <a href="home?hot=true" class="otherTab">Hot</a>
                    </div>
                </div>

                <div id="question-list">
                    
                    <!-- Question -->
                    <c:forEach items="${bean.getQuestions()}" var="question">
                    <div class="question-summary" id="${question.toString()}">
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
                                <a href="" class="started-link">
                                    <span title="2013-01-25 05:46:00" class="relativetime">${question.getQuestion().getSubmitted()}</span>
                                </a>
                                <a href="users?id=${question.getQuestion().getAuthorID()}">${question.getQuestion().getAuthor()}</a>
                                <span class="reputation-score" title="reputation-score" dir="ltr">500000</span>
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

                <%@include file="recentBadges.jsp" %>
            </div>



        </div>

        <jsp:include page = "footerShortcut.jsp" />

    </body>
</html>
