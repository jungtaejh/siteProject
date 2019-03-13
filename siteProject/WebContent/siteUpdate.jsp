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
<jsp:useBean id="dto" class="site.SiteDTO"/>
<jsp:setProperty property="*" name="dto"/>

<%
	SiteDAO dao = new SiteDAO();
	dao.update(dto);
%>

아이디 : <%= dto.getId() %><br>
이름 : <%= dto.getName() %><br>
주소 : <%= dto.getAddr() %><br>

업데이트가 완료되었습니다.

</body>
</html>