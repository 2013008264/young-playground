<%--
  Created by IntelliJ IDEA.
  User: ydlee
  Date: 12/10/2018
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("euc-kr");
    String season = request.getParameter("season");
    String fruit = request.getParameter("fruit");

    String id = (String)session.getAttribute("idKey");
    String sessionId = session.getId();
    int intelvalTime = session.getMaxInactiveInterval();

    if(id != null) {
%>
<strong><%=id %></strong> love this season and fruit
<strong><%=season %></strong>, <%=fruit %></strong><br/>
session Id : <%= sessionId %><br />
session time : <%= intelvalTime %><br />
out.println("<a href='session2.jsp'>logout</a>");

<%
    } else {
    	out.println("login fail");
    	out.println("<a href='session1.html'>login</a>");
    }
%>