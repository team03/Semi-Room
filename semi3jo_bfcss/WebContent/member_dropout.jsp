<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="bean.JoinDTO" %>
<jsp:useBean id="dao" class="bean.JoinDAO"/>
<%
	String id = (String)session.getAttribute("id");
	String userPass = request.getParameter("pass");
	JoinDTO dto = dao.getMemberInfo(id);
	
	if(userPass != null){
		if(userPass.equals(dto.getPw())){
			dao.m_dropout(id);
			response.sendRedirect("logout.ma?cmd=logout");
		}
		else 
%>
		<script>
			alert("�н����尡 ���� �ʽ��ϴ�.");
			history.back();
		</script>
<%
	}
%>
<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check() {
		if (document.form.pass.value == "") {
		alert("�н����带 �Է��ϼ���.");
		form.pass.focus();
		return false;
		}
		document.form.submit();
	}
</script>
</head>
<body>
<center>
<br><br>
<table width=50% cellspacing=0 cellpadding=3>
 <tr>
  <td bgcolor=#dddddd height=21 align=center>
      ������� ��й�ȣ�� �Է��� �ּ���.</td>
 </tr>
</table>
<table width=70% cellspacing=0 cellpadding=2>
<form name=form method=post action="member_dropout.jsp" >
 <tr>
  <td align=center>
   <table align=center border=0 width=91%>
    <tr> 
     <td align=center>  
	  <input type=password name="pass" size=17 maxlength=15>
	 </td> 
    </tr>
    <tr>
     <td><hr size=1 color=#eeeeee></td>
    </tr>
    <tr>
     <td align=center>
	  <input type=button value="�����Ϸ�" onClick="check()"> 
      <input type=reset value="�ٽþ���"> 
      <input type=button value="�ڷ�" onClick="history.back()">
	 </td>
    </tr> 
   </table>
  </td>
 </tr>
</form> 
</table>
</center>
</body>
</html>