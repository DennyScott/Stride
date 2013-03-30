<%-- 
    Document   : index
    Created on : 24-Jan-2013, 4:44:46 PM
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
        <link href="css/wmd.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="javascript/Stride.js"></script>
        <script type="text/javascript" src="javascript/Settings.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


        <script type="text/javascript" src="javascript/showdown.js"></script>

        <title>Settings</title>
    </head>
    <body onload="setZoom()">
        <div id="in"></div>
        <div id ="wholePage">
            <jsp:include page = "bannerShortcut.jsp" />
            <jsp:include page = "headerShortcut.jsp" />

            <div id="content">

                <div class="mainHeader">
                    <h1 id="topQuestions">
                        Settings
                    </h1>
                </div>

                <div id="mainContent">
                    <h3>Zoom:</h3>
                    <div id="slider"></div>
                    <span class="italic">Note, when changing zoom all content may not render as desired. When possible, use your browsers for desired zoom. (Ctrl+/Ctrl-)</span>
                    <div class="storeCookie">
                        <div>
                            <button id="store">Save Setting</button>
                            <button id="select">Select an action</button>
                        </div>
                        <ul>
                            <li onclick="restoreDefault()" class="hoverPoint">Restore to Default</li>
                        </ul>
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
