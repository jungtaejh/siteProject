<%@page import="site.SiteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
</head>
<body>
   
   <!-- 액션 태그 사용 -->
    <jsp:useBean id="dto" class="site.SiteDTO">
    
       <!-- dto에 있는 set메소드를 자동 호출 *-- 모두 다 호출 -->
       <jsp:setProperty name="dto" property="*"/>
    </jsp:useBean>
    
    <%
        	SiteDAO dao = new SiteDAO();
               dao.insert(dto);
        %>
    
    <jsp:getProperty property="id" name="dto"/>
    
      <font color="blue" size="6">회원가입 확인</font>
      <hr>
      <table>
         <tr align="center">
            <td bgcolor="yellow" width="100">아 이 디</td>
            <td bgcolor="green" width="300">
               <%= dto.getId() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">패스워드</td>
            <td bgcolor="green" width="300">
               <%= dto.getPw() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">이 름</td>
            <td bgcolor="green" width="300">
               <%= dto.getName() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">연 락 처</td>
            <td bgcolor="green" width="300">
               <%= dto.getTel() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">주 소</td>
            <td bgcolor="green" width="300">
               <%= dto.getAddr() %>
            </td>
         </tr>
         <tr align="center">
            <td bgcolor="yellow" width="100">취 미</td>
            <td bgcolor="green" width="300">
               <%= dto.getFavorite() %>
            </td>
         </tr>
      </table>
</body>
</html>