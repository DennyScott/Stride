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
        <script type="text/javascript" src="javascript/1.2.6.js"></script>

        <script type="text/javascript" src="javascript/showdown.js"></script>


        <title>${bean.getTitle()}</title>
    </head>
    <body>

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="question-header">
                <h1 itemprop="name">
                    <a href="" class="question-hyperlink">
                        ${bean.getTitle()}
                    </a>
                </h1>
            </div>

            <div id="mainContent">

                <div id="question" class="question" data-questionid="00005">

                    <table>
                        <tbody>
                            <tr>
                                <td class="votecell">
                                    <div class="vote">
                                        <input type="hidden" value="00005">
                                        <a class="vote-up-off" title="This question shows research effort; it is useful and clear (click again to undo)">up vote</a>
                                        <span class="vote-count-post">${bean.getVotes()}</span>
                                        <a class="vote-down-off" title="Thi question does not show any research effort; it is unclear or not useful (click again to undo">down vote</a>
                                        <a class="star-off" href="#" title="This is a favourite question (click to undo"></a>

                                    </div>
                                </td>

                                <td class="postcell">
                                    <div>
                                        <div class="post-text" itemprop="description">

                                            <p> ${bean.getQuestion()}</p>


                                        </div>

                                        <div class="post-taglist">

                                            <c:forEach items="${bean.getTags()}" var="tag">
                                                <a href="Tags?id=${tag.getID()}" class="post-tag" title="Show me more about ${tag.getTag()}" rel="tag">${tag.getTag()}</a>
                                            </c:forEach>



                                        </div>

                                        <table class="fw">
                                            <tbody>
                                                <tr>
                                                    <td class="vt">
                                                        <div class="post-menu">
                                                            <a href="School?id=${bean.getSchool()}" title="Go to other questions from ${question.getSchool()}" class="short-link">
                                                                ${bean.getSchool()}
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
                                                                <a href="Users?id=${bean.getAuthorID()}">
                                                                    <div class>
                                                                        <img src="img/kip.jpg" alt width="32" height="32">
                                                                    </div>
                                                                </a>
                                                            </div>

                                                            <div class="user-details">
                                                                <a href="Users?id=${bean.getAuthorID()}">${bean.getAuthor()}</a>
                                                                <br>
                                                                <span class="reputation-score" title="reputation score" dir="ltr">1</span>
                                                                <span title="2 bronze badges">
                                                                    <span class="badge3"></span>
                                                                    <span class="badgecount">2</span>
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
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>

                <div id="answers">
                    <a name="tab-top"></a>
                    <div id="answers-header">
                        <div class="subheader answers-subheader">
                            <h2>${bean.getAnswers().size()} Answers</h2>

                            <div id="tabs">
                                <a class="otherTab" href="http://stackoverflow.com/questions/9805407/float-value-to-byte-array?answertab=active#tab-top" title="Answers with the latest Activity first">active</a>
                                <a class="otherTab" href="http://stackoverflow.com/questions/9805407/float-value-to-byte-array?answertab=oldest#tab-top" title="Answers with the oldest Activity first">oldest</a>
                                <a class="youarehere" href="http://stackoverflow.com/questions/9805407/float-value-to-byte-array?answertab=votes#tab-top" title="Answers with the most votes first">votes</a>


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
                                                <a class="vote-up-off" title="This answer is useful(click to undo)">up vote</a>
                                                <span class="vote-count-post">${answer.getVotes()}</span>
                                                <a class="vote-down-off" title="This answer was not useful (click to undo)">down vote</a>
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
                                                                            <img src="img/kip.jpg" alt width="32" height="32">
                                                                        </div>
                                                                    </a>
                                                                </div>

                                                                <div class="user-details">
                                                                    <a href="Users?id=${answer.getAuthorID()}">${answer.getAuthor()}</a>
                                                                    <br>
                                                                    <span class="reputation-score" title="reputation score" dir="ltr">1</span>
                                                                    <span title="2 bronze badges">
                                                                        <span class="badge3"></span>
                                                                        <span class="badgecount">2</span>
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
                    <form id="post-form" action="/questions/00005/answer/submit" method="post" class="post-form">
                        <h2 class="space">Your Answer</h2>

                       <%--    StackExchange.ready(function() {
                                initTagRenderer("".split(" "), "".split(" "));

                            prepareEditor({
                                heartbeatType: 'answer',
                                bindNavPrevention: true,
                                postfix: "",
                                onDemand: true,
                                discardSelector: ".discard-answer"
                                ,immediatelyShowMarkdownHelp:true
                            });


                        });  --%>
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

                <table>
                    <tbody>
                        <tr>
                            <td class="vm">
                                <div>
                                    <label for="display-name">Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                    <input type="text" size="30" maxlength="30" value tabindex="105" style="opacity: 1; position:absolute; background-color:white; color:white; -webkit-text-fill-color: black; width: 209px; height:16px; line-height:normal; font-size:13px; text-align:start; border:1px solid rgb(153,153,153);" class="actual-edit-overlay" disabled="disabled">
                                    <input id="display-name" name="display-name" type="text" size="30" maxlengt="30" value tabindex="105" style="opacity: 0.4; z-index:1; position:relative;" class="edit-field-overlay"> 
                                </div>
                                <div>
                                    <label for="password">Password</label>
                                    <input type="text" size="30" maxlength="30" value tabindex="105" style="opacity: 1; position:absolute; background-color:white; color:white; -webkit-text-fill-color: black; width: 209px; height:16px; line-height:normal; font-size:13px; text-align:start; border:1px solid rgb(153,153,153);" class="actual-edit-overlay" disabled="disabled">
                                    <input id="password" name="password" type="password" size="30" maxlengt="30" value tabindex="105" style="opacity: 0.4; z-index:1; position:relative;" class="edit-field-overlay"> 
                                </div>

                            </td>
                        </tr>
                    </tbody>
                </table>
        </div>

        <div class="form-submit cbt">
            <input id="submit-button" type="submit" value="Post Your Answer!" tabindex="110">
            <a href="#" class="discarded-answer dno">discard</a>
            <p class="privacy-policy-agreement">By posting your answer, you agree to the <a href="privacy policy" target="_blank">privacy policy</a> and <a href="terms of use" target="_blank">terms of use</a>.</p>
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

        <%@include file="recentTags.jsp" %>

        <%@include file="recentBadges.jsp" %>
    </div>



</div>

<script type="text/javascript" src="javascript/wmd.js"></script>

<jsp:include page = "footerShortcut.jsp" />
</body>
</html>
