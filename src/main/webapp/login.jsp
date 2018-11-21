<%@ page language="java" import="java.lang.*" pageEncoding="utf-8"%>
<%
String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI();
String params = request.getQueryString();
String loginUrl2 =baseUrl+"loginController.do?login&"+params;
response.sendRedirect(loginUrl2);

//测试地址：http://localhost:8088/jeecg/loginController.do?login&id=admin&co=8ho7vvnierzscvty&mo=29


//request.getRequestDispatcher("webpage/login/login.jsp").forward(request, response);
%>

<html>
<body>
<h2><%=loginUrl2 %></h2>
</body>
</html>
