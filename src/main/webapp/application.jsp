<%--
  Created by IntelliJ IDEA.
  User: ydlee
  Date: 12/10/2018
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("euc-kr");

    application.setAttribute("myKey", "key111");
    String serverInfo = application.getServerInfo();
    String mimeType = application.getMimeType("request1.html");
    String realPath = application.getRealPath("/");

    application.log("application ");
%>

serverInfo : <%= serverInfo %><br />
mimeType : <%= mimeType %><br />
realPath : <%= realPath %><Br />
