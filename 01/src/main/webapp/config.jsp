<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: ydlee
  Date: 12/10/2018
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("euc-kr");

    String sevletName = config.getServletName();
    Enumeration<String> e = config.getInitParameterNames();

    while(e.hasMoreElements()) {
    	String s = e.nextElement();
    	out.print(s + ":" +config.getInitParameter(s) + "<br />");
    }
%>
<%= sevletName %>