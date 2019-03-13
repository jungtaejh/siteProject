<%@page import="site.SiteBbsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="site.SiteBbsDAO"></jsp:useBean>
<%
   ArrayList<SiteBbsDTO> list = dao.selectAll();
   out.print("전체 회원 수는 : " + list.size() + "<br>");
   %>
   <table border="1">
   <tr>
      <td>아이디</td>
      <td>패스워드</td>
      <td>제목</td>
      <td>내용</td>
      <td>날짜</td>
   </tr>
   
   <%
   for(int i = 0; i < list.size(); i++){
      SiteBbsDTO dto = list.get(i);
   %>
   <tr>
      <td><%= dto.getBid() %></td>
      <td><%= dto.getPw() %></td>
      <td><%= dto.getTitle() %></td>
      <td><%= dto.getContent() %></td>
      <td><%= dto.getBbsDate() %></td>
   </tr>
   <%   
   }
  
%>
</table>


</body>
</html>