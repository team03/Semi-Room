<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="dao" class="bean.JoinDAO" />
<%!
 String id;
%>
<%
 boolean result = false;
 id = (String)request.getParameter("id");
 if(id == null || id.equals("")){
	 id = "";
 }else {
 	result = dao.loginchk(id);  //member_join.html에서받아옴 
 } 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>아이디 중복 확인</title>
<script>
    function setId(){        // 중복체크를 했다는 플래그를 넘겨준다.
        opener.f.id.value = document.f1.id.value;
        opener.f.idDupChk.value = 't';
        self.close();
    }
</script>
</head>
<body>
<form name="f1" action="idCheck.jsp">
    <input type="text" name="id"  value="<%=id%>"/><input type="submit" value="검색"/>
</form>
<% if(id.equals("")){ %>

<%}else if(result == false){ %>
 <a href="#" onclick="setId()">사용가능</a>
<%}else { %>
	아이디 중복
<%} %>
</body>
</html>

