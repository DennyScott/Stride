<%-- 
    Document   : Tags
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

        <title>Badges</title>
    </head>
    <body class="badges-page">

        <jsp:include page = "bannerShortcut.jsp" />
        <jsp:include page = "headerShortcut.jsp" />

        <div id="content">

            <div id="mainbar-full">
                <div class="subheader">
                    <h1 id="h-tags">Tags</h1>
                    <div id="tabs">
                        <a class="youarehere" href="Tabs" title="You are here!">Popular</a>
                        <a href="Tabs" class="otherTab">
                            Name
                        </a>
                        <a href="Tabs" class="otherTab">New</a>
                    </div>
                </div>
                
                <div class="page-description">
                    <p>
                        A tag is a keyword or label that categorizes your question with other, similar questions. Using the right tags makes it easier for others to find and answer your question.
                    </p>
                    <br>
                    <table>
                        <tbody>
                            <tr>
                                <td>Type to find tags:</td>
                                <td style="padding-left:5px;">
                                    <input id="tagfilter" name="tagfilter" type="text">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <div id="tags_list">
                    <table id="tags-browser">
                        <tbody>
                            <tr>
                            <c:forEach items="${bean.getTags()}" var="tag" varStatus="count">
                                <c:if test="${(count.count-1)%4==0}">
                            <tr>
                            </c:if>
                                
                                <td class="tag-cell">
                                    <a href="Tags?id=${tag.getID()}" class="post-tag" title="show questions tagged " rel="tag">${tag.getTag()}</a>
                                    <span class="item-multiplier">
                                        <span class="item-multiplier-x">x</span>
                                        &nbsp;
                                        <span class="item-multiplier-count">${tag.getCount()}</span>
                                    </span>
                                    <div class="excerpt">
                                       ${tag.getDescription()}
                                    </div>
                                </td>
                                <c:if test="${(count.count-1)%4==3}">
                            </tr>
                            </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                    <div class="pager fr">
                        <span class="page-numbers current">1</span>
                        <a href="/Tags?page=2$tab=popular" title="go to page 2">
                            <span class="page-numbers">2</span>
                        </a>
                        <a href="/Tags?page=3$tab=popular" title="go to page 3">
                            <span class="page-numbers">3</span>
                        </a>
                        <a href="/Tags?page=4$tab=popular" title="go to page 4">
                            <span class="page-numbers">4</span>
                        </a>
                        
                        <span class="page-numbers dots">...</span>
                        <a href="/Tags?page=100$tab=popular" title="go to page 100">
                            <span class="page-numbers">100</span>
                        </a>
                        <a href="/Tags?page=2$tab=popular" title="go to page 2" rel="next">
                            <span class="page-numbers next"> next</span>
                        </a>
                        
                        
                    </div>
                </div>
            </div>



        </div>

        <jsp:include page = "footerShortcut.jsp" />

    </body>
</html>
