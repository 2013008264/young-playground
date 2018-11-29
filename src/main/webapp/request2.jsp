<%--
  Created by IntelliJ IDEA.
  User: ydlee
  Date: 12/10/2018
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("euc-kr");
    String protocol = request.getProtocol();
    String serverName = request.getProtocol();
    int serverPort = request.getServerPort();

    String remoteAddr = request.getRemoteAddr();
    String remoteHost = request.getRemoteHost();
    String method = request.getMethod();

    String requestURI = request.getRequestURI();

    StringBuffer requestURL = request.getRequestURL();
    String useBrowser = request.getHeader("User-Agent");
    String fileType = request.getHeader("Accept");
%>

protocol : <%= protocol %><br/>
server name : <%= serverName %><br/>
server port : <%= serverPort %><br/>

method : <%= method %><br />
(URL) : <%= requestURL %><br />
(URI) : <%= requestURI %><br />
browser : <%= useBrowser %><br />
file type : <%= fileType %>
