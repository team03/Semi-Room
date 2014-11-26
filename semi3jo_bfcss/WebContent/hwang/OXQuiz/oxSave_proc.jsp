<%@page import="bean.DBConnectionMgr"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<% 
	request.setCharacterEncoding("euc-kr");
	response.setCharacterEncoding("euc-kr");
 %>
<jsp:useBean id="dao" class="oxquiz.OxDao" />
<jsp:useBean id="dto" class="oxquiz.OxDto" />
<jsp:setProperty property="*" name="dto"/>
<% 
	dao.insertQuiz(dto);
%>
		<script>
			alert("문제가 등록되었습니다.");
			location.href="oxMain.jsp";
		</script>