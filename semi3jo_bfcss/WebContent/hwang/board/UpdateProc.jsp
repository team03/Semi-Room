<%@page import="totalsite.board.BoardDto"%>
<%@ page contentType="text/html; charset=EUC-KR"%>

<jsp:useBean id="dao" class="totalsite.board.BoardDao"/>
<jsp:useBean id="dto" class="totalsite.board.BoardDto"/>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
	
	int num = Integer.parseInt(request.getParameter("num")); //글번호 넘겨받고
	String userPass = request.getParameter("pass"); //패스워드 넘겨받고
	
	dto = dao.getBoard(num); // dto에 dao를 통한 게시글 정보 넘겨받기	
	
	if(userPass.equals(dto.getPass())){
		dto = new BoardDto();
		 
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setNum(num);
		dao.updateBoard(dto);
%>
	<script>
		alert("잘 수정되었습니다.");
		location.href="List.jsp";
	</script>
		<%
	}
	else{
%>		
	<script>
		alert("패스워드가 맞지 않습니다.");
		history.back();
	</script>
<%		
	}
%>
