<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="totalsite.board.BoardDto" %>
<jsp:include page="../../right.jsp" flush="true"/>
<br/><br/><br/><br/><br/>
<html>
<head> <title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
<jsp:useBean id="dao" class="totalsite.board.BoardDao"/>
<script>
	function check() {
	   if (document.form.pass.value == "") {
		 alert("������ ���� �н����带 �Է��ϼ���.");
	     form.pass.focus();
		 return false;
		 }
	   document.form.submit();
	}
</script>
</head> 
<%
	int num = Integer.parseInt(request.getParameter("num"));
BoardDto dto = dao.getBoard(num);
String content = dto.getContent().replace("<br/>", "\n");
%>
<body>
<center>
<br><br>
<table width=460 cellspacing=0 cellpadding=3>
  <tr>
   <td bgcolor=#FF9018  height=21 align=center class=m>�����ϱ�</td>
  </tr>
</table>

<form name=form method=post action="UpdateProc.jsp" >
<input type="hidden" name="num" value="<%=num %>" /> <!-- UpdateProc.jsp�� num �Ѱ��ֱ� -->
<table width=70% cellspacing=0 cellpadding=7>
 <tr>
  <td align=center>
   <table border=0>
    <tr>
     <td width=20%>�� ��</td>
     <td width=80%>${sessionScope.name }<input type = "hidden" name = "name" value="${sessionScope.name }"></td>
    </tr>
    <tr>
	 <td width=20%>E-Mail</td>
	 <td width=80%>${sessionScope.dto.email }<input type = "hidden" name = "email" value="${sessionScope.dto.email }"></td>
	</tr>
	<tr>
     <td width=20%>�� ��</td>
     <td width=80%>
	  <input type=text name=subject size=50 maxlength=50 value="<%=dto.getSubject() %>">
	 </td>
    <tr>
     <td width=20%>�� ��</td>
     <td width=80%>
	  <textarea name=content rows=10 cols=50><%=content %></textarea>
	 </td>
    </tr>
	<tr>
     <td width=20%>��� ��ȣ</td> 
     <td width=80%><input type=password name=pass size=15 maxlength=15>
      �����ÿ��� ��й�ȣ�� �ʿ��մϴ�.</td>
    </tr>
	<tr>
     <td colspan=2 height=5><hr size=1></td>
    </tr>
	<tr>
     <td colspan=2>
	  <input type=Button value="�����Ϸ�" onClick="check()">
      <input type=reset value="�ٽü���"> 
      <input type=button value="�ڷ�" onClick="history.back()">
	 </td>
    </tr> 
   </table>
  </td>
 </tr>
</table>
</form> 
</center>
</body>
</html>