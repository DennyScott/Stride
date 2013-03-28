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
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="javascript/Stride.js"></script>
        <script type="text/javascript" src="javascript/jquery-1.2.6.js"></script>
        <script type="text/javascript" src="javascript/sonic.js"></script>


        <title>Profile</title>
    </head>
    <body class="badges-page">
        <div id="in"></div>
        <div id ="wholePage">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainbar-full" class="user-show-new">
                <div class="subheader">
                    <h1 id="user-displayname">${bean.getUser().getUser()}</h1>

                    <%
                        if (session.getAttribute("id").equals(request.getParameter("id"))) {
                    %>
                    <div id="tabs">
                        <a class="otherTab" href="Users" title="View">View</a>
                        <a href="Users?edit=true" class="youarehere">Edit</a>
                    </div>
                    <%}%>
                </div>
                <div id="user-info-container">
                    <div id="large-user-info" class="user-header">
                        <div class="user-header-left">
                            <div class="gravatar">
                                <div class>
                                    <form method="POST" action="Users?id=${id}&edit=true&submit=true" id="edited" enctype="multipart/form-data">
                                        <a href="#" id="uplink" onclick="getFile()"><img src="ProfilePicture?id=${bean.getUser().getUserID()}" alt width="128px" height="128px" class="logo"/></a>
                                    
                                    
                                </div>
                                
                                <div class="reputation">
                                    <span>
                                        ${bean.getUser().getReputation()}
                                    </span>
                                    Reputation
                                </div>
                                <div class="badges center">
                                    <span>
                                        <span>
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
                                                <td class="italic"><input type="text" name ="firstName" value="${bean.getUser().getFirstName()}" /></td>
                                            </tr>
                                            <tr>
                                                <th></th>
                                                <td>Last Name:</td>
                                                <td class="italic"><input type="text" name ="lastName" value="${bean.getUser().getLastName()}" /></td>
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
                                            <tr>
                                                <th></th>
                                                <td>Anonymous:</td>
                                                <td><input type="checkbox" name="isAnon" value="ON" checked="checked" /></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                            <div style="opacity:0"><input type="file" id="profilePic" class="profilePic" name="profilePic"></div>
                            </div>
                        </div>

                        <div class="user-about-me2">
                            <p>
                                <textarea id="styled" onfocus=" setbg('#e5fff3');" onblur="setbg('white')" name="bio">${bean.getUser().getBio()}</textarea>
                            </p>
                        </div>
                        <input class="submitRight" type="submit" value="Save Profile" />
                        </form>
                        <br class="clear">
                    </div>
                </div>

                <div class="subheader user-tabs-nav">

                </div>

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
                                                <a href="Question?id=${answer.getQuestionID()}" class="answer-hyperlink">
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
                                                <div class="mini-counts">${question.getCount()}</div>
                                            </td>
                                            <td class="answer-hyperlink">
                                                <a href="Question?id=${question.getQuestionID()}" class="answer-hyperlink">
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
                                                </span>
                                                <span class="badge${badge.getColor()}"></span>&nbsp;${badge.getBadge()}
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
                    <!--Votes Cast -->
                    <div id="user-panel-questions" class="user-panel user-panel-left">
                        <div class="subheader">
                            <h1>
                                <span class="count">40</span>
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
        </div>
    </body>
</html>
