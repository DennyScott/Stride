<%-- 
    Document   : Courses
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

        <title>Badges</title>
    </head>
    <body class="badges-page">
        <div id="in"></div>
        <div id ="wholePage">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainContent">
                <div class="mainHeader">
                    <h1 id="topQuestions">
                        Courses
                    </h1>
                   
                    
                    
                </div>

                        <table>
                            <tbody>
                                <c:forEach items="${bean.getCourses()}" var="course">
                                    <tr>
                                        <td class="check-cell">
                                            
                                        </td>
                                        <td class="badge-cell">
                                            <span id ="badgeTest">
                                            <a href="Courses?id=${course.getId()}" title="${course.getCourse()}" class="badge">${course.getCourse()}</a>   <span class="item-multiplier">x ${course.getTotal()}</span>
                                            </span>
                                            </td>
                                        
                                        <td>
                                            ${course.getDescription()}
                                        </td>
                                           
                                    </tr>
                                    
                                </c:forEach>
                               
                            </tbody>
                        </table>
                        
            </div>
            <span class="cbt"></span>
            <div id="sideContent">


                <%@include file="recentTags.jsp" %>

                <%@include file="recentBadges.jsp" %>
                
            </div>



        </div>

        <jsp:include page = "footerShortcut.jsp" />
        </div>

    </body>
</html>
