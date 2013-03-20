<%-- 
    Document   : RecentBadges
    Created on : 2-Mar-2013, 11:21:21 AM
    Author     : portForward
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
   <div class="module" id="recent-badges">
                    <h4 id="h-recent-badges">Recent Badges</h4>
                    <table>
                        <tbody>
                            <!--Badges -->
                            <c:forEach items="${bean.getBadges()}" var="badge">
                            <tr>
                                <td>
                                    <a href="badges?id=${badge.getBadge().getId()}" title="${badge.getBadge().getBadge()}" class="badge"><span class="badge${badge.getBadge().getColor().getColor()}"></span> ${badge.getBadge().getBadge()}</a>
                                    <a href="users?id=${badge.getUserID()}">${badge.getUserName()}</a>
                                </td>

                            </tr>
                            </c:forEach>
                            <!-- End of Badge -->
                            
                        </tbody>
                    </table>
                </div>