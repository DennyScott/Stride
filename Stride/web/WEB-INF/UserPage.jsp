<%-- 
    Document   : Tags
    Created on : 24-Jan-2013, 4:44:46 PM
    Author     : Denny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <link href="css/jquery.pageslide.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="javascript/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="javascript/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="javascript/jquery.pageslide.min.js"></script>

        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <title>Profile</title>
    </head>
    <body class="badges-page">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainbar-full" class="user-show-new">
                <div class="subheader">
                    <h1 id="user-displayname">${bean.getUser().getUser()}</h1>

                    <%
                        if (session.getAttribute("id") != null) {
                            if (session.getAttribute("id").equals(request.getParameter("id"))) {
                    %>
                    <div id="tabs">
                        <a class="youarehere" href="Users?id=${id}" title="View">View</a>
                        <a href="Users?edit=true&id=${id}" class="otherTab">Edit</a>
                        <a href="#Bounty" class="first">Bounties</a>
                        <a href="#modal" class="second">Web Apps</a>

                    </div>
                    <%}
                        }%>




                </div>
                <div id="user-info-container">
                    <div id="large-user-info" class="user-header">
                        <div class="user-header-left">
                            <div class="gravatar">
                                <div class>
                                    <img src="ProfilePicture?id=${bean.getUser().getUserID()}" alt width="128px" height="128px" class="logo" />
                                </div>
                                <div class="reputation">
                                    <span>
                                        ${bean.getUser().getReputation()}
                                    </span>
                                    Reputation
                                </div>
                                <div class="badges center">
                                    <span>
                                        <span title="3 bronze">
                                            <span class="badge1"></span>
                                            <span class="badgecount">${bean.getUser().getGold()}</span>
                                        </span>
                                        <span>
                                            <span class="badge2"></span>
                                            <span class="badgecount">${bean.getUser().getSilver()}</span>
                                        </span>
                                        <span>
                                            <span class="badge3"></span>
                                            <span class="badgecount">${bean.getUser().getBronze()}</span>
                                        </span>
                                    </span>
                                </div>
                            </div>

                            <div class="data">
                                <table>
                                    <tbody>
                                        <tr>
                                            <th>bio</th>
                                            <td>First Name:</td>
                                            <td class="italic">${bean.getUser().getFirstName()}</td>
                                        </tr>
                                        <tr>
                                            <th></th>
                                            <td>Last Name:</td>
                                            <td class="italic">${bean.getUser().getLastName()}</td>
                                        </tr>
                                        <tr>
                                            <th></th>
                                            <td>Rank:</td>
                                            <td class="italic">${bean.getUser().getRank()}</td>
                                        </tr>
                                    </tbody>
                                    <tbody>
                                        <tr>
                                            <th>Website</th>
                                            <td>Member For:</td>
                                            <td class="italic">${bean.getUser().getJoinedDate()}</td>
                                        </tr>
                                        <tr>
                                            <th></th>
                                            <td>Last Seen:</td>
                                            <td class="italic">${bean.getUser().getLastOnline()}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="user-about-me">
                            <p>
                                ${bean.getUser().getBio()}
                            </p>
                        </div>
                        <br class="clear">
                    </div>
                </div>

                <div class="subheader user-tabs-nav">

                </div>

                <!--Side Content -->

                <c:if test="${not empty id}">
                    <c:if test="${param.id == id}">
                        <div id="modal" style="display:none; font-size:12px;">
                            <h2>Web Apps</h2>
                            <hr>
                            <h3>Education</h3>
                            <br>
                            <a href="home">Build Your Degree!</a><br>
                            <a href="home">Course Planner</a><br>
                            <a href="home">Video Tutoring</a><br>
                            <a href="Jobs">Find a Job!</a><br>
                            <br>
                            <hr>
                            <h3>Games</h3>
                            <br>
                            <hr>
                            <br>
                            <a href="javascript:$.pageslide.close()">Close</a>
                        </div>
                        <script>
                            $(".second").pageslide({ direction: "left", modal: true });
                        </script>

                        <div id="Bounty" style="display:none; font-size: 11px;">
                            <h2>Bounty</h2>
                            <hr>
                            <h3>Answers to Your Bounties</h3><br>
                            <c:forEach items="${bean.getBountyAnswers()}" var="answer">
                                <a href="home?id=${answer.getQuestionID()}">A Potential Answer!</a>&nbsp;&nbsp;&nbsp;
                                <span class="time">   ${answer.getSubmitted()}</span><br>
                            </c:forEach>
                            <br>
                            <hr>
                            <h3>Your Open Bounties</h3><br>
                            <c:forEach items="${bean.getMyBounties()}" var="answer">
                                <a href="home?id=${answer.getQuestionID()}">+${answer.getBounty()}  ${answer.getQuestion()}</a>

                            </c:forEach>
                            <br>
                            <br>
                            <hr>
                            <h3>Bounties Awarded</h3><br>
                            <c:forEach items="${bean.getRecievedBounties()}" var="answer">
                                <a href="home?id=${answer.getQuestionID()}">+${answer.getBounty()}  You have been awarded a Bounty!</a><br>
                            </c:forEach>
                            <br>
                            <hr>
                            <h3>Recent Open Bounties</h3><br>
                            <c:forEach items="${bean.getOpenBounties()}" var="answer">
                                <a href="home?id=${answer.getQuestionID()}">+${answer.getBounty()}  ${answer.getQuestion()}</a><br>

                            </c:forEach>

                            <br>
                            <hr>
                            <a href="javascript:$.pageslide.close()">Close</a>
                        </div>
                        <script>
                            $(".first").pageslide({ direction: "right", modal: true });
                        </script>
                    </c:if>
                </c:if>


                <div>
                    <div id="user-panel-answers" class="user-panel user-panel-left">
                        <div class="subheader">
                            <h1>
                                <span class="count">${bean.getUser().getNumberAnswers()}</span>
                                Answers
                            </h1>
                        </div>

                        <div class="user-panel-content">
                            <table class="user-answers lines">
                                <tbody>
                                    <c:forEach items="${bean.getAnswers()}" var="answer">
                                        <tr>
                                            <td class="count-cell">
                                                <div class="mini-counts">${answer.getVotes()}</div>
                                            </td>
                                            <td class="answer-hyperlink">
                                                <a href="home?id=${answer.getQuestionID()}" class="answer-hyperlink">
                                                    ${answer.getAnswer()}
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>


                        </div>
                    </div>

                    <!--Tags-->
                    <div id="user-panel-tags" class="user-panel">
                        <div class="subheader">
                            <h1>
                                <span class="count">${bean.getTagTimes()}</span>
                                Tags
                            </h1>
                        </div>

                        <div class="user-panel-content">
                            <table class="user-tags">
                                <tbody>
                                    <c:forEach items="${bean.getTags()}" var="tag" varStatus="count">
                                        <c:if test="${(count.count-1)%2==0}">
                                            <tr>
                                            </c:if>
                                            <td>
                                                <div class="answer-votes">${tag.getCount()}</div>
                                                <a href="Tags?id=${tag.getID()}" title="${tag.getDescription()}"class="post-tag">${tag.getTag()}</a>
                                                <span class="item-multiplier">
                                                    <span class="item-multiplier-x">x</span>
                                                    &nbsp;
                                                    <span class="item-multiplier-count">${tag.getCount()}</span>
                                                </span>
                                            </td>

                                            <c:if test="${(count.count-1)%2==1}">
                                            </tr>
                                        </c:if>
                                    </c:forEach>


                                </tbody>
                            </table>


                        </div>
                    </div>

                    <!--Question -->
                    <div id="user-panel-questions" class="user-panel user-panel-left">
                        <div class="subheader">
                            <h1>
                                <span class="count">${bean.getUser().getNumberQuestions()}</span>
                                Questions
                            </h1>
                        </div>

                        <div class="user-panel-content">
                            <table class="user-answers lines">
                                <tbody>
                                    <c:forEach items="${bean.getQuestions()}" var="question">
                                        <tr>
                                            <td class="count-cell">
                                                <div class="mini-counts">${question.getVotes()}</div>
                                            </td>
                                            <td class="answer-hyperlink">
                                                <a href="home?id=${question.getQuestionID()}" class="answer-hyperlink">
                                                    ${question.getTitle()}
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>


                        </div>
                    </div>

                    <!--Badges-->
                    <div id="user-panel-badges" class="user-panel">
                        <div class="subheader">
                            <h1>
                                <span class="count">${bean.getUserBadges().size()}</span>
                                Badges
                            </h1>
                        </div>

                        <div class="user-panel-content">
                            <table class="user-badges">
                                <tbody>
                                    <c:forEach items="${bean.getUserBadges()}" var="badge" varStatus="count">
                                        <c:if test="${(count.count-1)%2==0}">
                                            <tr>
                                            </c:if>
                                            <td>
                                                <span id ="badgeTest">
                                                    <a href="Badges?id=${badge.getId()}" title="${badge.getDescription()}"class="badge">

                                                        <span class="badge${badge.getColor()}"></span>&nbsp;${badge.getBadge()}
                                                    </a>
                                                </span>
                                            </td>
                                            <c:if test="${(count.count-1)%2==1}">
                                            </tr>
                                        </c:if>
                                    </c:forEach>

                                </tbody>
                            </table>


                        </div>
                    </div>
                    <!--Votes Cast -->
                    <div id="user-panel-questions" class="user-panel user-panel-left">
                        <div class="subheader">
                            <h1>
                                <span class="count">${bean.getTotalVotes()}</span>
                                Votes Cast
                            </h1>
                        </div>

                        <div class="user-panel-content">
                            <table class="votes-cast-stats">
                                <thead>
                                    <tr>
                                        <th colspan="2">all time</th>
                                        <th class="spacer">&nbsp;</th>
                                        <th colspan="2">by type</th>
                                        <th class="spacer">&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${bean.getVotesUp()}</td>
                                        <td class="desc">up</td>
                                        <td></td>
                                        <td>${bean.getQuestionVotes()}</td>
                                        <td class="desc">question</td>
                                        <td></td>

                                    </tr>

                                    <tr>
                                        <td>${bean.getVotesDown()}</td>
                                        <td class="desc">down</td>
                                        <td></td>
                                        <td>${bean.getAnswerVotes()}</td>
                                        <td class="desc">answer</td>
                                        <td></td>
                                    </tr>

                                </tbody>
                            </table>


                        </div>
                    </div>
                    <!--Courses-->
                    <div id="user-panel-courses" class="user-panel">
                        <div class="subheader">
                            <h1>
                                <span class="count">${bean.getCourses().size()}</span>
                                Courses
                            </h1>
                        </div>

                        <div class="user-panel-content">
                            <table class="user-badges">
                                <tbody>
                                    <c:forEach items="${bean.getCourses()}" var="course" varStatus="count">
                                        <c:if test="${(count.count-1)%2==0}">
                                            <tr>
                                            </c:if>
                                            <td>
                                                <a href="Courses?id=${course.getId()}" title="${course.getDescription()}"class="badge">
                                                    &nbsp;${course.getCourse()}
                                                </a>
                                            </td>

                                            <c:if test="${(count.count-1)%2==1}">
                                            </tr>
                                        </c:if>
                                    </c:forEach>

                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>


            </div>



        </div>


        <jsp:include page = "footerShortcut.jsp" />
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="javascript/jquery.pageslide.min.js"></script>
        <script>
            /* Default pageslide, moves to the right */
            $(".first").pageslide();
        
            /* Slide to the left, and make it model (you'll have to call $.pageslide.close() to close) */
            $(".second").pageslide({ direction: "left", modal: true });
        </script>
    </body>
</html>
