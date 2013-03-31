<%-- 
    Document   : Banner
    Created on : 2-Mar-2013, 11:14:00 AM
    Author     : Yaphet
Change March 15, 2013 - Document checks if session attribute "Name" is present.
Within this attribute is the username of the client and was stored in a session
upon login. If attribute is not null then the document finds the user's name and places it at
the top of the page, if attribute is null the document places a link so a new member can sign up
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id ="banner">
    <div id="topBar">
        <div id="user">
            <%
                if (session.getAttribute("Name") == null) {
            %>
            <a href="SignUp" class="genu">
                Not a member? Click here
            </a>
            <%            } else if (session.getAttribute("Name") != null) {
            %> 
            <p id="welcome">Welcome <a href="Users?id=${id}">${Name}</a>!</p>
            <%
                }
            %>

        </div>
        <div id ="topNav">
            <div id="topLinks">
                <%
                    if (session.getAttribute("Name") == null) {
                %>
                <span class="links-nav">
                    <a style="color: orange" href="Login">Log In</a>
                </span>
                <%            } else if (session.getAttribute("Name") != null) {
                %> 
                               <span class="links-nav">
                    <a style="color: orange" href="Login">Log Out</a>
                </span>
                <%
                    }
                %>
                <span class="lsep">|</span>
                <span class="links-nav">
                    <a href="Settings">Settings</a>
                </span>
                
                <span class="lsep">|</span>
                <span class="links-nav">
                    <a href="About">About</a>
                </span>
                
                <span class="lsep">|</span>
                <span class="links-nav">
                    <a href="www.cnn.com">Contact</a>
                </span>
                <span class="lsep">|</span>

            </div>
            <div id="search">
                <form id="search" action="Search" method="get" autocomplete="off">
                    <div>
                        <input autocomplete="off" name="searchBar" class="textbox" placeholder="search" tabindex="1" type="text" maxlength="140" size="28" value>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<br class="cb">
