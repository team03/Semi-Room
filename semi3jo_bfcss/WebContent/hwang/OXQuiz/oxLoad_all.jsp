<%@page import="java.util.Vector"%>
<%@page import="oxquiz.OxDto"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="/semi3jo_bfcss/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="/BootstrapApp/bootstrap/js/bootstrap.js"></script>
<script>
	function fnCheck(){
		var answer = document.getElementsByClassName("result2");
		var answer2 = document.getElementsByClassName("result3");
	
		for(var i=0; i<answer.length; i++){
			if(answer[i].checked==false && answer2[i].checked==false){
			alert((i+1) + "번을 풀지 않았습니다!");
			return;
			}
		}
		
		f.submit();
	}
	
</script>
</head>
<body>
<jsp:useBean id="dao" class="oxquiz.OxDao"/>
<jsp:include page="../../right.jsp"></jsp:include> 
<h1>문제 풀기</h1>
<%
int intPage = 1;
if(request.getParameter("intPage")!=null){
	intPage = Integer.valueOf(request.getParameter("intPage"));
}
//else if(request.getParameter("intPage")>=2){
//	intPage = Integer.valueOf(request.getParameter("intPage"))+1;
//}

Vector v = dao.getQuizList(intPage);
OxDto dto=null;
String quiz[] = new String[v.size()];
String quiz2[] = new String[v.size()];



%>
		<form name="f" method="post" action="result_all.jsp">
		<input type="hidden" name="intPage" value="<%=intPage%>">
		<table class="table" border=1px width=100% height=10px cellpadding=2 cellspacing=0>
			<tr bgcolor=#FFDF24 height=50px>
				<th align="center"> 번호 </th>
				<th align="center"> 문제 </th>
				<th align="center"> 답선택 </th>
				<th align="center"> 등록자 </th>
				<th align="center"> 카테고리 </th>
				<th align="center"> 등록날짜 </th>
			</tr>
		
		<%
			if(v.isEmpty()){
		%>
		<div align="center">등록된 문제가 없습니다.</div>
		<%
			}
				else{

					for(int i=0; i<v.size(); i++){
						dto= (OxDto)v.get(i);
						quiz[i]=dto.getQuiz();
						quiz2[i]=quiz[i].replace("(", "<b><font color='blue'>(").replace(")", ")</font></b>");
				
		%>
		<tr>
		<tr height=40px>
		
			<td><%=i+1 %></td>
			<td><%=quiz2[i] %></td>
			<td><input type="radio" class="result2" name="result<%=i %>" value="1" />1 &nbsp;&nbsp;&nbsp;
			<input type="radio" class="result3" name="result<%=i %>" value="2"/>2</td>			
			<td><%=dto.getUserID() %></td>
			<td><%=dto.getCategory() %></td>
			<td><%=dto.getRegdate() %></td>
		</tr>
		<%
			}

		}
		%>
		
		</table>
		<br/><br/>

		<input type="button" value="채점하기" onclick="fnCheck()"/>
		&nbsp;&nbsp;&nbsp;<a href="oxMain.jsp">처음으로</a>
		</form>
</body>
</html>