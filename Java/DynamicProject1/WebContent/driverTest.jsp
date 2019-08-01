<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DB.DBConnectionMgr" %>
<%@ page import="java.sql.*"  %>
<%
	DBConnectionMgr pool = new DBConnectionMgr();
	Connection conn = null;
	
	try {
		conn = pool.getConnection();
		out.println("커넥션 풀 연동 성공");
	} catch(Exception e) {
		e.printStackTrace();
		out.println("커넥션 풀 연동 실패");
	} finally {
		pool.freeConnection(conn);
	}
	
%>