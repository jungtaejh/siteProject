<%@page import="site.SiteBbsDTO"%>
<%@page import="site.SiteBbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- html -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">

	<%
		String id = request.getParameter("bid");
			SiteBbsDAO dao = new SiteBbsDAO();
			SiteBbsDTO dto = dao.select(id);
	%>


아이디 : <%= dto.getBid() %><br>
비밀번호 : <%= dto.getPw() %><br>
주제 : <%= dto.getTitle() %><br>
내용 : <%= dto.getContent() %><br>
날짜 : <%= dto.getBbsDate() %><br>
	
</body>
</html>