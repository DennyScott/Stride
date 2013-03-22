<%-- 
    Document   : index
    Created on : 24-Jan-2013, 4:44:46 PM
    Author     : Denny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styles.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="javascript/1.2.6.js"></script>

        <script type="text/javascript" src="javascript/showdown.js"></script>


        <title>Ask a Question</title>
    </head>
    <body>

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">


            <div id="mainContent" class="ask-mainbar">
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
                                    <input id="title" name="title" type="text" maxlength="300" tabindex="100" class="ask-title-field edit-field-overlayed" autocomplete="off" style="opacity: 0.4; z-index:1; position:relative;">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div id="question-suggestions"></div>
                </div>

                <div id="post-editor" class="post-editor">
                    <div class="wmd-container">
                        <div id="wmd-button-bar" class="wmd-button-bar">
                            <ul id="wmd-button-row" class="wmd-button-row">
                                <li id="wmd-bold-button" class="wmd-button" title="bold" style="left:0px;">
                                    <span style="background-position: 0px -20px;"></span>
                                </li>

                                <li id="wmd-italic-button" class="wmd-button" style="left:25px;">
                                    <span style="background-position: -20px -20px;"></span>
                                </li>

                                <li id="wmd-spacer1" class="wmd-spacer" style="left:50px;">
                                    <span style="background-position: -40px -20px;"></span>
                                </li>

                                <li id="wmd-link-button" class="wmd-button" style="left:75px;">
                                    <span style="background-position: -40px -20px"></span>
                                </li>

                                <li id="wmd-quote-button" class="wmd-button" style="left:100px;">
                                    <span style="background-position: -60px -20px"></span>
                                </li>

                                <li id="wmd-code-button" class="wmd-button" style="left:125px;">
                                    <span style="background-position: -80px -20px;"
                            </li>

                            <li id="wmd-image-button" class="wmd-button" style="left:150px;">
                                <span style="background-position: -100px -20px;"></span>
                            </li>

                            <li id="wmd-spacer2" class="wmd-spacer" style="left:175px;">
                                <span style="background-position: -120px -20px;"></span>
                            </li>

                            <li id="wmd-olist-button" class="wmd-button" style="left:200px;">
                                <span style="background-position: -120px -20px"></span>
                            </li>

                            <li id="wmd-ulist-button" class="wmd-button" style="left:225px;">
                                <span style="background-position: -140px -20px;"></span>
                            </li>

                            <li id="wmd-heading-button" class="wmd-button" style="left: 250px;">
                                <span style="background-position: -160px -20px"></span>
                            </li>

                            <li id="wmd-hr-button" class="wmd-button" style="left: 275px;">
                                <span style="background-position: -180px -20px"></span>
                            </li>

                            <li id="wmd-spacer3" class="wmd-spacer" style="left: 300px;">
                                <span style ="background-position: -200px -20px"></span>
                            </li>

                            <li id="wmd-undo-button" class="wmd-button" style="left:325px;">
                                <span style="background-position: -200px -20px;"
                        </li>

                        <li id="wmd-redo-button" class="wmd-button" style="left:350px;">
                            <span style="background-position: -220px -20px"></span>
                        </li>
                    </ul>
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
            <div class="actual-edit-overlay" style="width: 666px; height:28px; opacity: 1px; position: absolute;
                 background-color: white; color: black; -webkit-text-fill-color: black; line-height: 28px; font-family: 'Helvetica Neue';
                 font-size:13px; text-align: start; border: 1px solid rgb (153,153,153);" disabled="disabled">
            </div>
            <div class="tag-editor edit-field-overlayed" style="width:666px; height: 28px; opacity: 0.4; z-index: 1; position: relative;">
                <span style></span>
                <input type="text" tabindex="103" style="width: 658px;">
                <span></span>
            </div>

        </div>

        <div id="question-only-section">
            <div class="form-submit cbt">
                <input id="submit-button" type="submit" value="Post Your Question" tabindex="120">
                <a href="#" class="discard-question dno">discard</a>
            </div>
        </div>
        </form>


    </div>



    <div id="sideContent">
        <div class="newUser" id="newUserBox">
            <h4>
                Welcome!
            </h4>
            <div>
                <p>
                    Stride is a website where students of Applied Computer Science can help one another by asking and answering questions.
                </p>
                <p class="ar">
                    <a href="aboutus">about >></a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="faq">faq >></a>
                </p>
            </div>
        </div>

        <div class="module" id="recent-tags">
            <h4 id="h-recent-tags">Recent Tags</h4>
            <div id="recent-tags-list">
                <a href="someTag" title="Show Questions tagged 'TagName'" class="post-tag" rel="tag">
                    Cakes
                </a>
                &nbsp;
                <span class="item-multiplier">
                    <span class="item-multiplier-x">x</span>
                    &nbsp;
                    <span class="item-multiplier-count">89</span>
                </span>
                <br>
                <a href="someTag" title="Show Questions tagged 'TagName'" class="post-tag" rel="tag">
                    3909
                </a>
                &nbsp;
                <span class="item-multiplier">
                    <span class="item-multiplier-x">x</span>
                    &nbsp;
                    <span class="item-multiplier-count">8</span>
                </span>
                <br>
                <a href="someTag" title="Show Questions tagged 'TagName'" class="post-tag" rel="tag">
                    Java
                </a>
                &nbsp;
                <span class="item-multiplier">
                    <span class="item-multiplier-x">x</span>
                    &nbsp;
                    <span class="item-multiplier-count">60</span>
                </span>
                <br>
            </div>
        </div>

        <div class="module" id="recent-badges">
            <h4 id="h-recent-badges">Recent Badges</h4>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <a href="some badge" title="Description of badge" class="badge">Good Answer</a>
                            <a href="link to some elements">Denny Scott</a>
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <a href="some badge" title="Description of badge" class="badge">Civic Duty</a>
                            <a href="link to some elements">Denny Scott</a>
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <a href="some badge" title="Description of badge" class="badge">Necromancer</a>
                            <a href="link to some elements">Denny Scott</a>
                        </td>

                    </tr>

                    <tr>
                        <td>
                            <a href="some badge" title="Description of badge" class="badge">Notable Question</a>
                            <a href="link to some elements">Jim Smith</a>
                        </td>

                    </tr>
                </tbody>
            </table>
        </div>



    </div>



</div>

<script type="text/javascript" src="javascript/wmd.js"></script>

        <jsp:include page = "footerShortcut.jsp" />
</body>
</html>
