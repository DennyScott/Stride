<%-- 
    Document   : badges
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

        <title>Badges</title>
    </head>
    <body class="badges-page">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainContent">
                <div class="mainHeader">
                    <h1 id="topQuestions">
                        Badges
                    </h1>
                   
                    <div id="tabs">
                        <a class="youarehere" href="" title="You are here!">Bronze</a>
                        <a href="Badges?color=Silver" class="otherTab">
                            Silver
                        </a>
                        <a href="Badges?color=Gold" class="otherTab">Gold</a>
                    </div>
                    
                </div>
                

                        <table>
                            <tbody>
                                <c:forEach items="${bean.getBadgeInfo()}" var="badge">
                                    <tr>
                                        <td class="check-cell">
                                            
                                        </td>
                                        <td class="badge-cell">
                                            <a href="Badges?id=${badge.getId()}" title="${badge.getBadge()}" class="badge"><span class="badge${badge.getColor().getColor()}"></span> ${badge.getBadge()}</a>   <span class="item-multiplier">x ${badge.getTotal()}</span>
                                        </td>
                                        
                                        <td>
                                            ${badge.getDescription()}
                                        </td>
                                           
                                    </tr>
                                    
                                </c:forEach>
                               
                            </tbody>
                        </table>
                        
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

    </body>
</html>
