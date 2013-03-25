<div id="hireme" onclick="window.location='./Jobs?search=true'">
                    <a href="./Jobs?search=true" class="top subheader">Winnipeg Jobs</a>
                    <ul class="jobs">
                        <c:forEach items="${bean.getAd()}" var="ad" varStatus="count">
                            <c:if test="${count.count<10}">
                        <li>
                            ${ad.getTitle()}
                        </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>