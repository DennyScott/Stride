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
        <script type="text/javascript" src="javascript/Stride.js"></script>

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
                        <a class="youarehere" href="Badges?color=1" id ="GoldBadge" title="You are here!">Gold</a>
                        <a href="Badges?color=2" class="otherTab" id="SilverBadge" ">
                            Silver
                        </a>
                        <a href="Badges?color=3" class="otherTab"id="BronzeBadge">Bronze</a>
                    </div>
                    <script type ="text/javascript">
                        var num = ${param.color};
                        if(num==1){
                            goldClick();
                        }else if(num==2){
                            silverClick();
                        }else if(num==3){
                            bronzeClick();
                        }
                    </script>
                    
                </div>
                

                        <table>
                            <tbody>
                                <c:forEach items="${bean.getBadgeInfo()}" var="badge">
                                    <tr>
                                        <td class="check-cell">
                                            
                                        </td>
                                        <td class="badge-cell">
                                            <span id ="badgeTest">
                                            <a href="Badges?id=${badge.getId()}" title="${badge.getBadge()}" class="badge"><span class="badge${badge.getColor()}"></span> ${badge.getBadge()}</a>   <span class="item-multiplier">x ${badge.getTotal()}</span>
                                            </span>
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
                            <span id ="badgeTest">
                            <a href="/badges?tab=general&filter=gold" title="gold badge: awarded rarely" class="badge"><span class="badge1"></span>&nbsp;Gold Badge</a>
                            </span>
                        </div>
                        <p>
                            Gold Badges are rare. You will have to actively work toward these. They&rsquo;re something
                            of an accomplishment!</p>
                        <div class="mb">
                            <span id ="badgeTest">
                            <a href="/badges?tab=general&filter=silver" title="silver badge: awarded occasionally" class="badge"><span class="badge2"></span>&nbsp;Silver Badge</a>
                            </span>
                        </div>
                        <p>
                            Silver badges are awarded for longer term goals. Silver badges are uncommon, but
                            definitely attainable if you&rsquo;re interested.</p>
                        <div class="mb">
                            <span id ="badgeTest">
                            <a href="/badges?tab=general&filter=bronze" title="bronze badge: awarded frequently" class="badge"><span class="badge3"></span>&nbsp;Bronze Badge</a>
                            </span>
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
