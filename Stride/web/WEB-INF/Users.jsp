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
        <script type="text/javascript" src="javascript/Stride.js"></script>

        <title>User</title>
    </head>
    <body class="users-page" onload="setZoom()">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainbar-full">
                <div class="subheader">
                    <h1 id="h-tags">Users</h1>
                    <div id="tabs">
                        <a class="youarehere" href="Users?sort=reputation" id="firstTab" title="You are here!">Reputation</a>
                        <a href="Users?sort=newest" id="secondTab" class="otherTab">
                            Recently Joined
                        </a>
                        <a href="Users?sort=oldest" id="thirdTab" class="otherTab">Oldest</a>
                        <script type ="text/javascript">
                            var sort = "${param.sort}";
                            if(sort=="newest"){
                                silverClick();
                            }else if(sort=="oldest"){
                                bronzeClick();
                            }else{
                                goldClick();
                            }
                        </script>
                    </div>
                </div>

                <div class="page-description">

                    <br>
                    <table>
                        <tbody>
                            <tr>
                                <td>Type to find users</td>
                                <td style="padding-left:5px;">
                                    <form action="SearchUser">
                                        <input id="userfilter" name="userSearch" type="text">
                                    </form>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="user-browser">
                    <table>
                        <tbody>
                            <tr>
                                <c:forEach items="${bean.getUsers()}" var="user" varStatus="count">
                                    <c:if test="${(count.count-1)%4==0}">
                                    <tr>
                                    </c:if>

                                    <td>
                                        <div class="user-info user-hover">
                                            <div class="user-gravatar48">
                                                <a href="Users?id=${user.getUserID()}">
                                                    <div class>
                                                        <img src="ProfilePicture?id=${user.getUserID()}" alt width="48" height="48" />
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="user-details">
                                                <a href="Users?id=${user.getUserID()}">${user.getUser()}</a>
                                                <br>
                                                <span class="user-location">${user.getRank()}</span>                                                <br>
                                                <span class="reputation-score" title="reputation this week: 1500 total reputation: 545308" dir="ltr">${user.getReputation()}</span>
                                            </div>

                                        </div>
                                    </td>
                                    <c:if test="${(count.count-1)%4==3}">
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <!--
                                        <div class="pager fr">
                                            <span class="page-numbers current">1</span>
                                            <a href="/Tags?page=2$tab=popular" title="go to page 2">
                                                <span class="page-numbers">2</span>
                                            </a>
                                            <a href="/Tags?page=3$tab=popular" title="go to page 3">
                                                <span class="page-numbers">3</span>
                                            </a>
                                            <a href="/Tags?page=4$tab=popular" title="go to page 4">
                                                <span class="page-numbers">4</span>
                                            </a>
                    
                                            <span class="page-numbers dots">...</span>
                                            <a href="/Tags?page=100$tab=popular" title="go to page 100">
                                                <span class="page-numbers">100</span>
                                            </a>
                                            <a href="/Tags?page=2$tab=popular" title="go to page 2" rel="next">
                                                <span class="page-numbers next"> next</span>
                                            </a>
                    -->


                </div>
            </div>
        </div>



    </div>

    <jsp:include page = "footerShortcut.jsp" />

</body>
</html>
