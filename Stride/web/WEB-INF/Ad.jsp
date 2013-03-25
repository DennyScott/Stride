<%-- 
    Document   : Ad
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
        <script type="text/javascript"
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCW6_9Jrezyd36n1VGcWHHK9JGHr67aITs&sensor=false">
        </script>
        <script type="text/javascript">
            function initialize() {
                var location = new google.maps.LatLng(${bean.getAd().getLoc().getLatitude()},
            ${bean.getAd().getLoc().getLongitude()});
                var contentString = "${bean.getAd().getTitle()}"
                var mapOptions = {
                    center: location,
                    zoom: 11,
                    mapTypeId: google.maps.MapTypeId.ROADMAP,
                    scrollwheel:true
                };
                var map = new google.maps.Map(document.getElementById("map-canvas"),
                mapOptions);
                
                var marker = new google.maps.Marker({
                    map:map,
                    draggable:false,
                    animation: google.maps.Animation.DROP,
                    position:location
                    
                });
                
                var infoWindow = new google.maps.InfoWindow({
                    content:contentString
                });
                
                google.maps.event.addListener(marker,'click',function(){
                    infoWindow.open(map,marker)
                });
            }
            google.maps.event.addDomListener(window, 'load', initialize);
        </script>

        <title>Badges</title>
    </head>
    <body class="badges-page">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainContent">
                <div class="mainHeader">
                    <h1 id="topQuestions">
                        ${bean.getAd().getTitle()}
                    </h1>

                </div>


                <table class="mb">
                    <tbody>
                        <tr>
                            <td class="check-cell">

                            </td>
                            <td class="badge-cell">
                                ${bean.getAd().getDate()}
                            </td>

                            <td>
                                ${bean.getAd().getDescription()}
                            </td>

                        </tr>
                        <tr>
                            <td>
                                
                            </td>
                            <td class="badge-cell">
                                <a href="${bean.getAd().getUrl()}">Go To Site</a>
                            </td>
                        </tr>

                    </tbody>
                </table>
                <div class="mainHeader"></div>  
             <div class="mapbox">
                    <div id="map-canvas" style="width: 100%; height: 100%"></div>
                </div>




            </div>
            <span class="cbt"></span>
            <div id="sideContent">

                

                <%@include file="recentTags.jsp" %>

                <%@include file="recentBadges.jsp" %>

            </div>



        </div>

        <jsp:include page = "footerShortcut.jsp" />

    </body>
</html>
