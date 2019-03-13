<%@page import="site.SiteDTO"%>
<%@page import="site.SiteDAO"%>
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
		String id = request.getParameter("id");
			SiteDAO dao = new SiteDAO();
			SiteDTO dto = dao.select(id);
	%>


아이디 : <%= dto.getId() %><br>
비밀번호 : <%= dto.getPw() %><br>
이름 : <%= dto.getName() %><br>
연락처 : <%= dto.getTel() %><br>
주소 : <%= dto.getAddr() %><br>
취미 : <%= dto.getFavorite() %><br>
	
</body>
</html>