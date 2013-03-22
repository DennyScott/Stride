<%-- 
    Document   : DB
    Created on : 16-Mar-2011, 12:21:51 PM
    Author     : C. Henry
--%>

<%@ page import="DataAccessors.DB" %>
<%!    private DB db = new DB();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DB Test Page</title>
    </head>
    <body>
        <%-- Pass some variables to our object --%>
        <%	db.setVar(request, response, out);%>

        <%-- Check user's actions --%>
        <% db.action();%>

        <%-- Print login form if necessary --%>
        <% if (!db.isConnected) {%>

        <h3>Log in to the database.</h3>
        <form id="login" action="DB.jsp" method="GET" enctype="text/plain"><br />

            <input type="submit" name="bAction" value="Login" />
        </form>

        <%-- End of login form --%>
        <% } else {%>
        <h3>Connected to database.</h3>
        <%-- Logoff form --%>
        <form id="logoff" action="DB.jsp" method="GET" enctype="text/plain">

            <label for="update">Update database:</label>
            <input type="text" name="update" id="update" size="50" />
            <input type="submit" name="bAction" id="bAction" value="Update" /><br /><br />

            <label for="query">Query database:</label>
            <input type="text" name="query" id="query" size="50" />
            <input type="submit" name="bAction" id="bAction" value="Query" /><br /><br />

            <input type="submit" name="bAction" value="Logoff" />
        </form>
        

        <% }%>

    </body>
</html>
