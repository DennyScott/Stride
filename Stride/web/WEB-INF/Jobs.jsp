<%-- 
    Document   : Jobs
    Created on : 19-Mar-2013, 1:37:52 PM
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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript" src="fancybox/jquery.fancybox.pack.js"></script>
        <script type="text/javascript" src="javascript/sonic.js"></script>
        <script type="text/javascript"
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCW6_9Jrezyd36n1VGcWHHK9JGHr67aITs&sensor=false">
        </script>

        <style type="text/css">

        </style>
        <script type="text/javascript">
            function initialize() {
                var location = new google.maps.LatLng(49.8956935, -97.1389392);
                
                var mapOptions = {
                    center: location,
                    zoom: 11,
                    mapTypeId: google.maps.MapTypeId.ROADMAP,
                    scrollwheel:true
                };
                var map = new google.maps.Map(document.getElementById("map-canvas"),
                mapOptions);
            <c:forEach items="${bean.getAd()}" var="ad" varStatus="count">
                    var contentString = "${ad.getTitle()}";
                    var jobLocation = new google.maps.LatLng(${ad.getLoc().getLatitude()},
                ${ad.getLoc().getLongitude()})
                        var marker${count.count} = new google.maps.Marker({
                            map:map,
                            draggable:false,
                            animation: google.maps.Animation.DROP,
                            position:jobLocation
                    
                        });
                
                        var infoWindow${count.count} = new google.maps.InfoWindow({
                            content:contentString
                        });
                
                        google.maps.event.addListener(marker${count.count},'click',function(){
                            infoWindow${count.count}.open(map,marker${count.count})
                        });
            </c:forEach>
                }
                google.maps.event.addDomListener(window, 'load', initialize);
        </script>

        <title>Jobs</title>
    </head>
    <body>
        <div id="in"></div>
        <div id="wholePage">
        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainContent">

                <div class="mainHeader">
                    <h1 id="topQuestions">
                        Jobs in Winnipeg
                    </h1>



                </div>
                <div class="question">
                    <div class="welovestride">
                        <div class="fl">
                            <p class="italic">
                                Below is a map of current jobs found in Winnipeg. Beneath the map is a listing for each job found.
                            </p>
                            <br>
                            <p class="italic">
                                If no jobs are displayed, click the button below for up-to-date jobs.
                            </p>
                            <br>
                            <a href="" onclick="load()">Find Jobs</a>

                        </div>
                    </div>
                    <div class="mapbox">
                        <div id="map-canvas" style="width: 100%; height: 100%"></div>
                    </div>
                </div>


            </div>

            <div id="questions" class="content-padding">
                <c:if test = "${bean.getAd() != null}">
                    <c:forEach items="${bean.getAd()}" var="ad" varStatus="count">
                        <div class="question-summary">
                            <div class="statscontainer">
                                <div class="statsarrow"></div>

                                <div class="views2" title="Date"> ${ad.getDate()} <!--Change views here --></div>
                            </div>

                            <!--Question Summary -->
                            <div class="tagSummary">
                                <h3>
                                    <a href="Jobs?id=${count.count-1}" class="question-hyperlink">${ad.getTitle()}<!--Enter Kijiji Title--></a>
                                </h3>
                                <div class="tagexcerpt">${ad.getDescription()}<!--Enter Description here--></div>
                            </div>
                            <a href="${ad.getUrl()}">Go to Site</a>
                        </div>
                    </c:forEach>
                </c:if>



            </div>

            <div id="mapSideContent">

                <%@include file="recentTags.jsp" %>

                <%@include file="recentBadges.jsp" %>
            </div>
        </div>

        <span class="cbt"></span>





    </div>

    <script type="text/javascript" src="javascript/wmd.js"></script>

    <jsp:include page = "footerShortcut.jsp" />
</div>
</body>
</html>
