<%-- 
    Document   : RecentTags
    Created on : 2-Mar-2013, 11:21:21 AM
    Author     : portForward
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="module" id="recent-tags">
    <h4 id="h-recent-tags">Recent Tags</h4>
    <div id="recent-tags-list">
        <!--Recent Tags -->
        <c:forEach items="${bean.getRecent()}" var="tag">
            <a href="Tags?id=${tag.getID()}" title="Show Questions tagged ${tag.getTag()}" class="post-tag" rel="tag">
                ${tag.getTag()}
            </a>
            &nbsp;
            <span class="item-multiplier">
                <span class="item-multiplier-x">x</span>
                &nbsp;
                <span class="item-multiplier-count">${tag.getCount()}</span>
            </span>
            <br>
        </c:forEach>
    </div>
</div>