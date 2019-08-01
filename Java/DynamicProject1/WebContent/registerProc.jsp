<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="user.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="user.UserBean" scope="page"/>
<jsp:setProperty name="user" property="*" />
<%
	UserDAO userDAO = new UserDAO();
	
	int result = userDAO.register(user);
%>

<script>
<%	if(result == 0) { %>
		alert('회원가입 성공')
		location.href = 'login.jsp';
<%  } else if(result == -1) { %>
		alert('이미 존재하는 아이디 입니다.')
		history.back()
<%  } else { %>
		alert('데이터베이스 오류')
		history.back()
<%  }  %>

</script>