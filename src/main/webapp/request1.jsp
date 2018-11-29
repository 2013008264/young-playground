<%--
  Created by IntelliJ IDEA.
  User: ydlee
  Date: 12/10/2018
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("euc-kr");
    String name = request.getParameter("name");
    String studentNum = request.getParameter("studentNum");
    String gender = request.getParameter("gender");
    String major = request.getParameter("major");
    String hobby[] = request.getParameterValues("hobby");

    if(gender.equals("man")) {
    	gender = "male";
    } else {
    	gender = "female";
    }
%>

name : <%= name %><br />
student_id : <%= studentNum %><br/>
m/f : <%= gender %><br />
major : <%= major %><br />
hobby :
<%
    for(int i = 0; i < hobby.length; i++) {
    	out.println(hobby[i] + " ");
    }
%>