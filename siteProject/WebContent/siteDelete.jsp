 <%@page import="site.SiteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	SiteDAO dao = new SiteDAO();
	dao.delete(id);
	out.print("삭제가 요청되었습니다.");
%>

</body>
</html>