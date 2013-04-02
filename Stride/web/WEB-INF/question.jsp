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
        <script type="text/javascript" src="javascript/Voting.js"></script>
        <script type="text/javascript" src="javascript/sonic.js"></script>
        <script type="text/javascript" src="javascript/showdown.js"></script>





        <title>${bean.getTitle()}</title>
    </head>
    <body onload="collectData()">

        <div id="in"></div>
        <div id ="wholePage">
        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="question-header">
                <h1 itemprop="name">
                    <a href="home?id=${bean.getQuestionID()}" name ="questionID" class="question-hyperlink">
                        ${bean.getTitle()}

                    </a>
                </h1>
            </div>

            <div id="mainContent">
                <input type="hidden" name="userData" id="userData" value="${sessionScope.id}" />
                <div id="question" class="question" data-questionid="00005">

                    <table>
                        <tbody>
                            <tr>
                                <td class="votecell">
                                    <div class="vote">
                                        <input type="hidden" value="00005">
                                        <a class="vote-up-off" onclick="questionVoteUp(${bean.getQuestionID()})" title="This question shows research effort; it is useful and clear (click again to undo)">up vote</a>
                                        <span class="vote-count-post" id="questionVote">${bean.getVotes()}</span>
                                        <a class="vote-down-off" onclick ="questionVoteDown(${bean.getQuestionID()})"title="Thi question does not show any research effort; it is unclear or not useful (click again to undo">down vote</a>
                                       
                                    </div>
                                </td>

                                <td class="postcell">
                                    <div>
                                        <div class="post-text" itemprop="description">

                                            <p> ${bean.getQuestion()}</p>


                                        </div>

                                        <div class="post-taglist">

                                            <c:forEach items="${bean.getTags()}" var="tag">
                                                <a href="Tags?id=${tag.getID()}" class="post-tag" name="tagList" title="Show me more about ${tag.getTag()}" rel="tag">${tag.getTag()}</a>
                                            </c:forEach>



                                        </div>

                                        <table class="fw">
                                            <tbody>
                                                <tr>
                                                    <td class="vt">
                                                        <div class="post-menu">
                                                            <a href="Courses?id=${bean.getCourseId()}" name="courseID" title="Go to other questions from ${question.getSchool()}" class="short-link">
                                                                Course: ${bean.getSchool()}
                                                            </a>
                                                        </div>
                                                    </td>

                                                    <td class="post-signature owner">
                                                        <div class="user-info">
                                                            <div class="user-action-time">
                                                                asked
                                                                <span title="2013-01-25 21:43:19" class="relativeTime">${bean.getSubmitted()}</span>
                                                            </div>
                                                            <div class="user-gravatar32">
                                                                <a href="Users?id=${bean.getAuthorID()}" name ="userID">
                                                                    <div class>
                                                                        <img src="ProfilePicture?id=${bean.getAuthorID()}" alt width="32" height="32">
                                                                    </div>
                                                                </a>
                                                            </div>

                                                            <div class="user-details">
                                                                <a href="Users?id=${bean.getAuthorID()}">${bean.getQuestionSlot().getUser().getUser()}</a>
                                                                <br>
                                                                <span class="reputation-score" title="reputation score" dir="ltr">${bean.getQuestionSlot().getUser().getReputation()}</span>
                                                                <span title="Badges">

                                                                    <span class="badge3"></span>
                                                                    <span class="badgecount">${bean.getQuestionSlot().getUser().getBronze()}</span>
                                                                    <span class="badge2"></span>
                                                                    <span class="badgecount">${bean.getQuestionSlot().getUser().getSilver()}</span>
                                                                    <span class="badge1"></span>
                                                                    <span class="badgecount">${bean.getQuestionSlot().getUser().getGold()}</span>

                                                                </span>
                                                            </div>
                                                        </div>
                                                    </td>

                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            
                            <tr>
                                <td class="votecell"></td>
                                <td>
                                    <div id="comments-00005" class="comments">
                                        <table>
                                            <tbody>
                                                <!--Comments Loop -->

                                                <c:forEach items="${bean.getComments()}" var="comment">
                                                    <tr id="comment-1503030" class="comment">
                                                        <td></td>
                                                        <td class="comment-text">
                                                            <div>
                                                                <span class="comment-copy">${comment.getComment()}</span>
                                                                --&nbsp;
                                                                <a href="Users?id=${comment.getAuthorID()}" title="500 reputation" class="comment-user">${comment.getAuthor()}</a>
                                                                <span class="comment-date" dir="ltr">
                                                                    <span title="2013-01-26 02:08:02" class="relativetime-clean">${comment.getSubmitted()}</span> 
                                                                </span>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>                    

                                                <!-- End of Comments Loop -->

                                            </tbody>
                                        </table>
                                        <br>
                                        <div id="addQuestionComment" class="addComment" onclick="questionComment(${bean.getQuestionID()})">Add a comment</div>

                                    </div>
                                </td>
                            </tr>
                            <c:if test="${bean.getQuestionSlot().getBounty()>0}">
                            <tr>
                                <td colspan="2">
                                    <div class="question-status bounty">
                                        <h2>
                                            This has an open bounty worth <span class="bounty-award">+${bean.getQuestionObject().getBounty()}</span> reputation from <a href="Users?id=${bean.getQuestionSlot().getUser().getUserID()}"</a>${bean.getQuestionSlot().getUser().getUser()}.
                                        </h2>
                                    </div>
                                </td>
                            </tr>
                            </c:if>
                        </tbody>
                    </table>

                </div>

                <div id="answers">
                    <a name="tab-top"></a>
                    <div id="answers-header">
                        <div class="subheader answers-subheader">
                            <h2>${bean.getAnswers().size()} Answers</h2>

                            <div id="tabs">
                                
                                <a class="youarehere" href="" title="Answers with the most votes first">votes</a>


                            </div>
                        </div>

                    </div>

                    <a name="98478"></a>
                    <!--Answer -->
                    <c:forEach items="${bean.getAnswers()}" var="answer">
                        <div id="answer-98478" class="answer" data-answerid="98478">

                            <table>
                                <tbody>

                                    <tr>
                                        <td class="votecell">
                                            <div class="vote">
                                                <input type="hidden" value="98478">
                                                <a class="vote-up-off" onclick="answerVoteUp(${answer.getID()})"title="This answer is useful(click to undo)">up vote</a>
                                                <span class="vote-count-post" id="answerVote-${answer.getID()}">${answer.getVotes()}</span>
                                                <a class="vote-down-off" onclick="answerVoteDown(${answer.getID()})"title="This answer was not useful (click to undo)">down vote</a>
                                                <c:if test="${answer.isChosen()}">
                                                    <span class="vote-accepted-on">accepted</span>
                                                </c:if>
                                            </div>
                                        </td>

                                        <td class="answercell">
                                            <div class="post-text">
                                                ${answer.getAnswer()}
                                            </div>

                                            <table class="fw">
                                                <tbody>
                                                    <tr>
                                                        <td class="vt">
                                                            <div class="post-menu">

                                                            </div>
                                                        </td>
                                                        <td class="post-signature">
                                                            <div class="user-info user-hover">

                                                                <div class="user-action-time">
                                                                    answered
                                                                    <span title="2013-01-25 21:43:19" class="relativeTime">${answer.getSubmitted()}</span>
                                                                </div>
                                                                <div class="user-gravatar32">
                                                                    <a href="Users?id=${answer.getAuthorID()}">
                                                                        <div class>
                                                                            <img src="ProfilePicture?id=${answer.getAuthorID()}" alt width="32" height="32">
                                                                        </div>
                                                                    </a>
                                                                </div>

                                                                <div class="user-details">
                                                                    <a href="Users?id=${answer.getAuthorID()}">${answer.getAuthor()}</a>
                                                                    <br>
                                                                    <span class="reputation-score" title="reputation score" dir="ltr">${answer.getReputation()}</span>
                                                                    <span title="">
                                                                        <span class="badge3"></span>
                                                                        <span class="badgecount">${answer.getBronze()}</span>
                                                                        <span class="badge2"></span>
                                                                        <span class="badgecount">${answer.getSilver()}</span>
                                                                        <span class="badge1"></span>
                                                                        <span class="badgecount">${answer.getGold()}</span>
                                                                    </span>
                                                                </div>

                                                            </div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                    <tr>
                                        <td class="votecell"></td>
                                        <td>
                                            <div id="comments-98478" class="comments">
                                                <table>
                                                    <tbody>
                                                        <!-- Comments of Answers -->
                                                        <c:forEach items="${answer.getComments()}" var="answerComment">
                                                            <tr id="comment-1503030" class="comment">
                                                                <td></td>
                                                                <td class="comment-text">
                                                                    <div>
                                                                        <span class="comment-copy">${answerComment.getComment()}</span>
                                                                        --&nbsp;
                                                                        <a href="Users?id=${answerComment.getAuthorID()}" title="2000 reputation" class="comment-user">${answerComment.getAuthor()}</a>
                                                                        <span class="comment-date" dir="ltr">
                                                                            <span title="2013-01-26 02:08:02" class="relativetime-clean">${answerComment.getSubmitted()}</span> 
                                                                        </span>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        <!--End of Answers Comments -->
                                                    </tbody>

                                                </table>
                                                <br>
                                                <div id="answerComment-${answer.getID()}" class="addComment" onclick="answerComment(${bean.getQuestionID()},${answer.getID()})">Add a comment</div>
                                                <c:if test="${not empty id}">
                                                    <c:if test="${id == bean.getAuthorID()}">
                                                        <c:if test="${not bean.getQuestionSlot().isAnswered()}">
                                                            <a href="home?id=${bean.getQuestionID()}&answer=${answer.getID()}">Select as Answer!</a>
                                                        </c:if>
                                                    </c:if>
                                                </c:if>
                                            </div>

                                            <div class="was-this-useful">

                                            </div>



                                        </td>
                                    </tr>


                                    </td>
                                    </tr>

                                </tbody>

                            </table>
                        </div>
                    </c:forEach>
                    <!--End of Answer -->

                    <a name="new-answer"></a>
                    <form id="post-form" action="home?id=${bean.getQuestionID()}&submit=true" method="post" class="post-form">
                        <h2 class="space">Your Answer</h2>


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
                        <c:if test="${empty id}">
                        <table>
                            <tbody>
                                <tr>
                                    <td class="vm">
                                        <div>
                                            <label for="display-name">Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>                                         
                                            <input id="display-name" name="jspUsername" type="text" size="30" maxlengt="30" value tabindex="105" style="opacity: 0.8; z-index:1; position:relative; color:black;" class="edit-field-overlay"> 
                                        </div>
                                        <div>
                                            <label for="password">Password</label>
                                            <input id="password" name="jspPassword" type="password" size="30" maxlengt="30" value tabindex="105" style="opacity: 0.9; z-index:1; position:relative; color:black;" class="edit-field-overlay"> 
                                        </div>

                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        </c:if>
                </div>

                <div class="form-submit cbt">
                    <input id="submit-button" type="submit" value="Post Your Answer!" tabindex="110">
                    <a href="#" class="discarded-answer dno">discard</a>
                   
                    <input type="hidden" name="legalLinksShown" value="1">
                </div>
                </form>


            </div>

            <span class="cbt"></span>

            <div id="sideContent">

                <div class="module question-stats">
                    <p class="label-key">tagged</p>



                    <div class="tagged">
                        <c:forEach items="${bean.getTags()}" var="tag">
                            <a href="Tags?id=${tag.getID()}" class="post-tag" title="Info on this tag" rel="tag">${tag.getTag()}</a>
                            &nbsp;
                            <span class="item-multiplier">
                                <span class="item-multiplier-x">x</span>
                                &nbsp;
                                <span class="item-multiplier-count">${tag.getCount()}</span>
                            </span>
                            <br>
                        </c:forEach>
                    </div>

                    <table id="qinfo">
                        <tbody>
                            <tr>
                                <td><p class="label-key">asked</p></td>
                                <td style="padding-left:10px;">
                                    <p class="label-key" title="2012-03-21 13:16:54">
                                        <b>${bean.getSubmitted()}</b>
                                    </p>
                                </td>
                            </tr>

                            <tr>
                                <td><p class="label-key">viewed</p></td>
                                <td style="padding-left:10px;">
                                    <p class="label-key" title="How many times has this page been viewed">
                                        <b>${bean.getCount()}</b>
                                    </p>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>

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
