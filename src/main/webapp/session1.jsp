<%--
  Created by IntelliJ IDEA.
  User: ydlee
  Date: 12/10/2018
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("euc-kr");
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    boolean flag = true;
    if(flag) {
    	session.setAttribute("idKey", id);
    	session.setMaxInactiveInterval(60 * 3);
    } else {
%>
    <script>
        alert("login fail");
        location.href = "session1.html";
    </script>
<% } %>

<h1>session example1</h1>
<form method=post action="session2.jsp">
    1.favorite season? <br />
    <input type="radio" name="season" value="spring">spring
    <input type="radio" name="season" value="summer">summer
    <input type="radio" name="season" value="autumn">autumn
    <input type="radio" name="season" value="winter">winter<br />

    2.favorite fruit? <br />
    <input type="radio" name="fruit" value="watermelon">watermelon
    <input type="radio" name="fruit" value="melon">melon
    <input type="radio" name="fruit" value="apple">apple
    <input type="radio" name="fruit" value="orange">orange <br/>
    <input type="submit" value="result">
</form>