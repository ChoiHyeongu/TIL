<%@ page language="java" contentType="text/ html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ page import="bbs.*" %>

<%  if(session.getAttribute("userID") == null) { 
		out.println("<script>");
		out.println("alert('로그인을 해 주세요')");
		out.println("location.href = 'login.jsp'");
		out.println("</script>");
	}
	
	request.setCharacterEncoding("utf-8");


	BbsDAO bbsDAO = new BbsDAO();
	BbsBean bbs = new BbsBean();
	
	int bbsID = bbsDAO.getNext();
	String bbsTitle = request.getParameter("bbsTitle").trim();
	String userID = (String) session.getAttribute("userID");
	String bbsDate = bbsDAO.getDate();
	String bbsContent = request.getParameter("bbsContent").trim();
	out.println("<script>");
	if(bbsID == -2 || bbsDate.equals("")) {
		out.println("alert('데이터베이스 오류')");
		out.println("history.back()");
	}
	if(bbsTitle.equals("")) {
		out.println("alert('제목을 입력해 주세요')");
		out.println("history.back()");
	}
	if(bbsContent.equals("")) {
		out.println("alert('내용을 입력해 주세요')");
		out.println("history.back()");
	}
	out.println("</script>");
	
	bbs.setBbsID(bbsID);
	bbs.setBbsTitle(bbsTitle);
	bbs.setUserID(userID);
	bbs.setBbsDate(bbsDate);
	bbs.setBbsContent(bbsContent);
	bbs.setBbsAvailable(1);
	
	int result = bbsDAO.write(bbs);
	
	out.println("<script>");
	if(result == -2) {
		out.println("alert('데이터베이스 오류')");
		out.println("location.href = 'bbs.jsp'");
	}
	else if(result == -1) {
		out.println("alert('글쓰기 실패')");
		out.println("location.href = 'bbs.jsp'");
	}
	else {
		out.println("alert('게시글 작성이 완료되었습니다.')");
		out.println("location.href = 'bbs.jsp'");
	}
	out.println("</script>");
	
%>













