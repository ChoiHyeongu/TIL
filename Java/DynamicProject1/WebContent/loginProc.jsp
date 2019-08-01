<%@ page language="java" contentType="text/ html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="user.UserDAO" %> 
<%

	request.setCharacterEncoding("utf-8");
	
	String userID = request.getParameter("userID");
	String userPassword = request.getParameter("userPassword");
	
	UserDAO userDAO = new UserDAO();
	
	int result = userDAO.login(userID, userPassword);
%>

<script>
<%	if(result == 1) { %>
<% session.setAttribute("userID",userID); %>
		alert("<%= userID + " 님 반갑습니다."%>")
		location.href = 'main.jsp';
<%  } else if(result == 0) { %>
		alert('비밀번호가 틀립니다')
		location.href = 'login.jsp';
<%	} else if(result == -1) { %>
		alert('아이디가 존재하지 않습니다')
		location.href = 'login.jsp';
<%  } else { %>
		alert('데이터베이스 오류')
		location.href = 'login.jsp';
<%  }  %>

</script>