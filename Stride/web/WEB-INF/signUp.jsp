<%-- 
    Document   : signUp
    Created on : 16-Mar-2013, 4:16:23 PM
    Author     : Yaphet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="javascript/Stride.js"></script>
        <script type="text/javascript" src="javascript/yaphet.js"></script>
        <title>Sign Up</title>
    </head>
    <body onload="setZoom()">
        <div id="in"></div>
        <div id ="wholePage">
            <jsp:include page = "bannerShortcut.jsp" />
            <jsp:include page = "headerShortcut.jsp" />

            <div id="content">
                <div id="mainContent">

                    <div class="mainHeader">
                        <h1 id="topQuestions">
                            Create Account
                        </h1>
                    </div>
                    <h1><span style="color:red;">${error.getErrorMessage()}</span></h1>
                    <p>
                        function signUpPage()<br>
                        { 
                        <br>
                        //Welcome to Stride.com <br>
                        //To sign up, simply fill in the following fields <br>
                        //Note: Passwords are case sensitive <br><br>

                        <&shy;form action ="/" method="post">
                    </p>
                    <br>

                    <form id="new" action="SignUp" method="post" autocomplete="on">
                        <&shy;input type="text" name="<span style="color:orangered; font-weight: bold;">Email</span>" value="<input type="text" name="email">"> <br>
                        <&shy;input type="text" name="<span style="color:orangered; font-weight: bold;">UserName</span>" value="<input type="text" name="signUpUsername">"> <br>
                        <&shy;input type="password" name="<span style="color:orangered; font-weight: bold;">Password</span>" value="<input type="password" name="signUpPassword" maxlength="15">"><br>
                        <&shy;input type="password" name="<span style="color:orangered; font-weight: bold;">Re-Enter Password</span>" value="<input type="password" name="signUpPasswordReconfirm" maxlength="15">"><br>

                        <&shy;input type="submit" value="<input type="submit" value="Sign Up">"><br><br>
                    </form>

                    <p><&shy;/form>; <br>
                        }
                    </p>

                </div>
            </div>

            <jsp:include page = "footerShortcut.jsp" />
        </div>
    </body>
</html>
