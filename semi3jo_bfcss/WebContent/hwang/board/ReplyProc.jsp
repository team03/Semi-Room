<%@page import="totalsite.board.BoardDto"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="dao" class="totalsite.board.BoardDao" />
<jsp:useBean id="dto" class="totalsite.board.BoardDto" />
<jsp:setProperty property="*" name="dto"/>
<%
	int num = Integer.parseInt(request.getParameter("num")); //76
	BoardDto parent = dao.getBoard(num); // 부모글에 대한 정보 	
	
	dao.replyUpdatePos(parent);
	 
	dto.setPos(parent.getPos());
	dto.setDepth(parent.getDepth());
	dao.replyBoard(dto);
%>
<script>
	alert("답변글이 작성되었습니다.");
	location.href="List.jsp";
</script>