<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="totalsite.board.BoardDto" %>
<jsp:include page="../../right.jsp" flush="true"/> 
<br/><br/><br/><br/><br/>
<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<jsp:useBean id="dao" class="totalsite.board.BoardDao"/> <!-- Dao를 쓰기 위한 인스턴스 생성 -->
</head>
<%
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
	int num = Integer.parseInt(request.getParameter("num"));
	String keyField = request.getParameter("keyField");
	String keyWord = request.getParameter("keyWord");
	BoardDto dto = dao.getBoard(num); // 함수 호출
	pageContext.setAttribute("dto", dto);
%>
<body>
<br><br> 
<table align=center width=70% border=0 cellspacing=3 cellpadding=0>
 <tr>
  <td bgcolor=#FFDF24 height=25 align=center class=m>글읽기</td>
 </tr>
 <tr>
  <td colspan=2>
   <table border=0 cellpadding=3 cellspacing=0 width=100%> 
    <tr> 
	 <td align=center bgcolor=#FFBB00 width=10%> 이 름 </td>
	 <td bgcolor=#ffffe8><%=dto.getName() %></td>
	 <td align=center bgcolor=#FFBB00 width=10%> 등록날짜 </td>
	 <td bgcolor=#ffffe8><%=dto.getRegdate() %></td>
	</tr>
    <tr>
	 <td align=center bgcolor=#FFBB00 width=10%> 메 일 </td>
	 <td bgcolor=#ffffe8 ><%=dto.getEmail() %></td> 
	 <td align=center bgcolor=#FFBB00 width=10%> 홈페이지 </td>
	 <td bgcolor=#ffffe8 ><a href="http://" target="_new">http://<%=dto.getHomepage() %></a></td> 
	</tr>
    <tr> 
     <td align=center bgcolor=#FFBB00 width=10%> 제 목</td>
     <td bgcolor=#ffffe8><%=dto.getSubject() %>
     <!-- 
     <td align=center bgcolor=#FFBB00 width=10%>첨부파일</td>
     <td bgcolor=#ffffe8><a href="download.jsp?name='<%=dto.getFilename() %>'"><%=dto.getOfilename() %></a>
   
     </td>
     -->
   </tr>
   <tr>
   <td>
   <%=dto.getContent() %>
   </td>
   </tr>
   <tr>
   <td colspan="4">
       
   </td>
   </tr>
   <tr> 
    <td colspan=4></td>
   </tr>
    <td colspan=4 align=right>
	 조회수 :<%=dto.getCount() %> 
   </td>
 
   </table>
  </td>
 </tr>
 <tr>
   <td align=center colspan=2> 
	<hr size=1>
	[ <a href="javascript:document.list.submit()">목 록</a> | 
	<a href="Update.jsp?num=<%=num%>">수 정</a> |
	<a href="Reply.jsp?num=<%=num%>">답 변</a> |
	<a href="Delete.jsp?num=<%=num%>">삭 제</a> ]<br>
  </td>
 </tr>
</table>
<form name="list" method="post" action="List.jsp">
	<input type="hidden" name="keyField" value="<%=keyField %>" />
	<input type="hidden" name="keyWord" value="<%=keyWord %>" />
</form>
</body>
</html>