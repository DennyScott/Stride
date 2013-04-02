<%-- 
    Document   : index
    Created on : 24-Jan-2013, 4:44:46 PM
    Author     : Denny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <link href="css/wmd.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="javascript/Stride.js"></script>
        <script type="text/javascript" src="javascript/sonic.js"></script>
        <script type="text/javascript" src="javascript/ask.js"></script>
        <script type="text/javascript" src="javascript/wmd.js"></script>
        <script type="text/javascript" src="javascript/showdown.js"></script>
        
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


        <title>Ask a Question</title>
    </head>
    <body onload="setZoom()">
<div id="in"></div>
        <div id ="wholePage">
        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">


            <div id="mainContent" class="ask-mainbar">
                <div class="subheader">
                    <h1 id="user-displayname">Ask a Question</h1>
                </div>
                <form method="POST" action="Ask" name="question">
                    <div class="form-item ask-title">
                        <table class="ask-title-table">
                            <tbody>
                                <tr>
                                    <td class="ask-title-cell-key">
                                        <label for="title">Title</label>
                                    </td>
                                    <td class="ask-title-cell-value">
                                        <input type="text" maxlength="300" tabindex="100" class="actual-edit-overlay" autocomplete="off" 
                                               style="opacity:1; position: absolute; background-color: white; color:black; -webkit-text-fill-color: black; width:610px;
                                               height: 16px; line-height: normal; font-family: 'Helvetica Neue';font-size: 13px; text-align:start; border: 1px solid rgb(153,153,153);"
                                               disabled="disabled">
                                        <input id="title" name="title" type="text" maxlength="300" tabindex="100" class="ask-title-field edit-field-overlayed" autocomplete="off" style="opacity: 1; z-index:1; position:relative;">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <br><br>
                        <div id="question-suggestions"></div>
                    </div>

                    <div id="post-editor" class="post-editor">
                        <div class="wmd-container">
                            <div id="wmd-button-bar" class="wmd-button-bar">

                            </div>


                            <textarea id="wmd-input" class="wmd-input" name="post-text" cols="92" rows="15" tabindex="101" style="opacity:1; height:213px;"></textarea>
                        </div>

                        <div class="fl" style="margin-top: 8px; height: 24px;">&nbsp;</div>  
                        <div id="draft-saved" class="draft-saved-community-option fl" style="margin-top: 8px; height:24px; display:none;">draft saved</div>
                        <div id="draft-discarded" class="draft-discarded-community-option fl" style="margin-top: 8px; height:24px; display:none;">draft discarded</div>
                        <div id="wmd-preview" class="wmd-preview"></div>
                        <div></div>

                        <div class="edit-block">
                            <input id="fkey" name="fkey" type="hidden" value="dflakdfj9879asf986a8">
                            <input id="author" name="author" type="text">
                        </div>


                    </div>

                    <div class="form-item">
                        <label>Tags</label>
                        <span class="note">Please separate each tag with a comma. (eg. "Java, 3909, Web-Design")</span>
                        <input id="tagnames" name="tagnames" type="text" size="60" value tabindex="103" style="display:none;">

                        <span style></span>
                        <div class="courseOverlay">
                            <input type="text" name="tags"tabindex="103" style="width: 666px;">
                            <label>Courses</label>
                            <span class="note">Please select the Course this question is for.</span><br>
                            <select class="courseSelection" id="courseSelection" name="courseSelection">
                                <c:forEach items="${bean.getCourses()}" var="course">
                                    <option value="${course.getId()}">${course.getCourse()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br><br>

                        <!--Bounty-->
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <div id="toogleBounty">
                                            <input type="checkbox" id="check" class="toogleBounty"/><label for="check">Bounty</label>
                                    </td>
                                    <td>
                                        <button id="help" type="button" style="margin-top:5px;">Button with icon only</button>
                                    </td>
                                </tr>

                            <input type="text" name ="bounty" id="resizable"/>

                    </div>
                    <div id="dialog" title="What is a Bounty?">
                        <p>Bounties allow you to pay a chosen amount of your reputation to other users in exchange for "increased" interest in answering the question. When choosing the best answer, that user will receive your bounty.</p>
                    </div>
                    </tr>
                    </tbody>
                    </table>
                    <span></span>

            </div>

        </div>

        <div id="question-only-section" class="postQuestion">
            <div class="form-submit cbt">
                <input id="submit" type="submit" value="Post Your Question" tabindex="120">
            </div>
        </div>
    </form>






    <div id="askSideContent">
         <jsp:include page="newUserWelcome.jsp" />


        <%@include file="recentJobs.jsp" %>
        <%@include file="recentTags.jsp" %>



    </div>

</div>

<script type="text/javascript" src="javascript/wmd.js"></script>

<jsp:include page = "footerShortcut.jsp" />
        </div>
</body>
</html>
