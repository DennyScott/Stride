<%-- 
    Document   : LoginTestWithMySQL
    Created on : 2-Mar-2013, 3:35:05 PM
    Author     : Yaphet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="javascript/yaphet.js"></script>
        <title>Login</title>
    </head>
    <body>

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">
            <div id="mainContent">
                
                <div class="mainHeader">
                    <h1 id="topQuestions">
                        Login
                    </h1>
                </div>

                <h1><span style="color:red;">${error.getErrorMessage()}</span></h1>
                <p>
                function loginPage()<br>
                { 
                <br>
                
                //Welcome to Stride.com <br>
                //Please login to unleash the knowledge! <br><br>

                <&shy;form action ="/" method="post">
                
                </p>
                <br>

                <form id="new" action="Login" method="post" autocomplete="on">
                    <&shy;input type="text" name="<span style="color:orangered; font-weight: bold;">UserName</span>" value="<input type="text" name="jspUsername">"> <br>
                    <&shy;input type="password" name="<span style="color:orangered; font-weight: bold;">Password</span>" value="<input type="password" name="jspPassword" maxlength="15">"><br>

                    <&shy;input type="submit" value="<input type="submit" value="Login">"><br><br>
                </form>

                <p><&shy;/form>; <br>
                    }
                </p>
                <br>
                <a href="SignUp">Not Yet a User?</a>
            </div>
        </div>

        <jsp:include page = "footerShortcut.jsp" />
    </body>
</html>
