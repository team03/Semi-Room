<%@page import="java.util.Vector"%>
<%@page import="oxquiz.OxDto"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="/semi3jo_bfcss/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="/semi3jo_bfcss/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<jsp:useBean id="dao" class="oxquiz.OxDao" />
<h1>OX ���� ä�� ���</h1>
<%
request.getParameter("euc-kr");
int intPage = 1;
if(request.getParameter("intPage")!=null){
	intPage = Integer.valueOf(request.getParameter("intPage"));
}

Vector v = dao.getQuizList_num(intPage);
OxDto dto=null;
String quiz[] = new String[v.size()];
String quiz2[] = new String[v.size()];

int cnt=0;
String param[] = new String[v.size()];
for(int i=0; i<v.size(); i++){
	param[i] =(String)request.getParameter("result"+i);
	dto= (OxDto)v.get(i);
	if(param[i].equals(dto.getAnswer()))
		cnt++;
}
%>

		<form name="f" method="post" action="result.jsp">
		<table border=1px width=100% height=10px cellpadding=2 cellspacing=0>
			<tr bgcolor=#FFDF24 height=50px>
				<th align="center"> ��ȣ </th>
				<th align="center"> ���� </th>
				<th align="center"> ���� </th>
				<th align="center"> �����Ѵ� </th>
				<th align="center"> ����� </th>
				<th align="center"> ��ϳ�¥ </th>
			</tr>
		
		<%
		for(int i=0; i<v.size(); i++){
			dto= (OxDto)v.get(i);
			quiz[i]=dto.getQuiz();
			
			if(dto.getAnswer().equals("1")){
				quiz2[i]=quiz[i].replace("(", "(<b><font color='blue'>").replace("/", "</font></b>/");
			}
			else{
				quiz2[i]=quiz[i].replace("/", "/<b><font color='blue'>").replace(")", "</font></b>)");
			}
		%>
		<tr>
		<tr height=40px>
		
			<td><%=i+1 %><%if(!param[i].equals(dto.getAnswer())){ %>
				<img src="/semi3jo_bfcss/hwang/images/x.jpg" width = 40 height= 40/> <%}else{ %>
				<img src="/semi3jo_bfcss/hwang/images/o.png" width = 40 height= 40/><%} %></td>
			<td><%=quiz2[i] %></td>
			<td><%=dto.getAnswer() %></td>
			<td><%=param[i] %></td>
			<td><%=dto.getUserID() %></td>
			<td><%=dto.getRegdate() %></td>
		</tr>
		<%
			}
		
		%>
		</table>
		<br/><br/><br/>
		<h1>�����ؼ�</h1>
		
		<%
			for(int i=0; i<v.size(); i++){
				dto= (OxDto)v.get(i);
		%>
		
		<b><%=i+1%>��:</b> 	<%=dto.getExplanation() %><br/>
		
		<%
			}
		%>
		
<br/><br/><br/>
<h3>����� ������ <%=cnt %></h3>

<a href="oxMain.jsp">ó������</a>
</form>
<form name="f" method="post"  action="oxLoad_grammar.jsp">	
	<input type="hidden" name="intPage" value="<%=intPage+1 %>">
	<button type="submit">��Ǯ��</button>
</form>

</body>
</html>