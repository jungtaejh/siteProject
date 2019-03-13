<%@page import="site.SiteBbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
</head>
<body>
   
   <!-- 액션 태그 사용 -->
    <jsp:useBean id="dto" class="site.SiteBbsDTO">
    
       <!-- dto에 있는 set메소드를 자동 호출 *-- 모두 다 호출 -->
       <jsp:setProperty name="dto" property="*"/>
    </jsp:useBean>
    
    <%
        	SiteBbsDAO dao = new SiteBbsDAO();
               dao.insert(dto);
        %>
    
    <jsp:getProperty property="bid" name="dto"/>
    
      <font color="blue" size="6">게시글 업로드 완료</font>
      <hr>
      <table>
         <tr align="center">
            <td bgcolor="yellow" width="100">아 이 디</td>
            <td bgcolor="green" width="300">
               <%= dto.getBid() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">패스워드</td>
            <td bgcolor="green" width="300">
               <%= dto.getPw() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">제목</td>
            <td bgcolor="green" width="300">
               <%= dto.getTitle() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">내용</td>
            <td bgcolor="green" width="300">
               <%= dto.getContent() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">날짜</td>
            <td bgcolor="green" width="300">
               <%= dto.getBbsDate() %>
            </td>
         </tr>
      </table>
</body>
</html>