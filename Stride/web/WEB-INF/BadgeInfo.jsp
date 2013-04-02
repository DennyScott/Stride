<%-- 
    Document   : BadgeInfo
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
        <script type="text/javascript" src="javascript/sonic.js"></script>
        <script type="text/javascript" src="javascript/Stride.js"></script>

        <title>Badges</title>
    </head>
    <body class="badges-page" onload="setZoom()">
        <div id="in"></div>
        <div id ="wholePage">

            <jsp:include page = "bannerShortcut.jsp" />
            <jsp:include page = "headerShortcut.jsp" />

            <div id="content">

                <div id="mainContent">
                    <div class="mainHeader">
                        <h1 id="topQuestions">
                            Badges
                        </h1>

                    </div>


                    <table class="mb">
                        <tbody>
                            <tr>
                                <td class="check-cell">

                                </td>
                                <td class="badge-cell">
                                    <a href="Badges?id=${bean.getBadgeInfo().getId()}" title="${bean.getBadgeInfo().getBadge()}" class="badge"><span class="badge${bean.getBadgeInfo().getColor()}"></span> ${bean.getBadgeInfo().getBadge()}</a>
                                </td>

                                <td>
                                    ${bean.getBadgeInfo().getDescription()}
                                </td>

                            </tr>


                        </tbody>
                    </table>
                    <div class="mainHeader"></div>  
                    <table class="mb">
                        <tbody>
                            <tr>
                                <td class="pl">
                                    <h1 class="awarded">
                                        This page has been awarded 
                                        <span class="badgeawardcount">${bean.getBadgeInfo().getTotal()}</span>
                                        times. Recently awarded to:
                                    </h1>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <div class="mb post-badge">

                        <c:forEach items="${bean.getUsers()}" var="user">

                            <div class="user-info">


                                <div class="user-gravatar48">
                                    <a href="Users?id=${user.getUserID()}">
                                        <div class>
                                            <img src="ProfilePicture?id=${user.getUserID()}" alt width="48" height="48">
                                        </div>
                                    </a>
                                </div>

                                <div class="user-details">
                                    <a href="Users?id=${user.getUserID()}">${user.getUser()}</a>
                                    <br>
                                    <span class="reputation-score" title="reputation score" dir="ltr">${user.getReputation()}</span>
                                    <span title="Badges">

                                        <span class="badge3"></span>
                                        <span class="badgecount">${user.getBronze()}</span>
                                        <span class="badge2"></span>
                                        <span class="badgecount">${user.getSilver()}</span>
                                        <span class="badge1"></span>
                                        <span class="badgecount">${user.getGold()}</span>

                                    </span>
                                </div>
                            </div>
                            <div style="float:left"><h2>${user.getUser()} has recently earned this Badge!</h2></div>
                        </div>
                    </c:forEach>





                </div>
                <span class="cbt"></span>
                <div id="sideContent">

                    <div class="module" id="badges-legend-module">
                        <h4 id="h-legend">Legend</h4>
                        <div id="badge-legend">
                            <div class="mb">
                                <a href="/badges?tab=general&filter=gold" title="gold badge: awarded rarely" class="badge"><span class="badge1"></span>&nbsp;Gold Badge</a>
                            </div>
                            <p>
                                Gold Badges are rare. You will have to actively work toward these. They&rsquo;re something
                                of an accomplishment!</p>
                            <div class="mb">
                                <a href="/badges?tab=general&filter=silver" title="silver badge: awarded occasionally" class="badge"><span class="badge2"></span>&nbsp;Silver Badge</a>
                            </div>
                            <p>
                                Silver badges are awarded for longer term goals. Silver badges are uncommon, but
                                definitely attainable if you&rsquo;re interested.</p>
                            <div class="mb">
                                <a href="/badges?tab=general&filter=bronze" title="bronze badge: awarded frequently" class="badge"><span class="badge3"></span>&nbsp;Bronze Badge</a>
                            </div>
                            <p>
                                Bronze badges are awarded for basic use of
                                Stride. They are easy to earn.</p>
                        </div>
                    </div>


                    <%@include file="recentTags.jsp" %>

                    <%@include file="recentBadges.jsp" %>

                </div>



            </div>

            <jsp:include page = "footerShortcut.jsp" />
        </div>
    </body>
</html>
