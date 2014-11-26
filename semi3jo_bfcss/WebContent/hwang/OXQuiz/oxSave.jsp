<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head><title>JSPBoard</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="/BootstrapApp/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="/BootstrapApp/bootstrap/js/bootstrap.js"></script>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>문제 등록</h1>
<center>
<br><br>
<table width=80% cellspacing=0 cellpadding=3>
 <tr>
  <td bgcolor=84F399 height=25 align=center>문제 등록</td>
 </tr>
</table>
<br>
<table width=80% cellspacing=0 cellpadding=3 align=center>
<form name=post method=post action="oxSave_proc.jsp" >
 <tr>
  <td align=center>
   <table border=0 width=100% align=center>
    <tr>
     <td width=10%>USER ID</td>
     <td width=90%><input type=text name=userID size=10 maxlength=10></td>
    </tr>
	<tr>
	<td width=10%>카테고리</td>
	<td>
	<select name="category">
		<option value="word">단어</option>
		<option value="num">수</option>
		<option value="voice">태</option>
		<option value="tense">시제</option>
	</select>
	<td>
	</tr>
     <td width=10%>문제</td>
     <td width=90%><input type=text name=quiz size=100 maxlength=100></td>
    </tr>
    <tr>
     <td width=10%>답</td>
     <td width=90%><input type=text name=answer size=10 maxlength=10></td>
    <tr>
     <td width=10%>해설</td>
     <td width=90%><textarea name=explanation rows=3 cols=100></textarea></td>
    </tr>
     <td colspan=2><hr size=1></td>
    </tr>
    <tr>
     <td><input type=submit value="등록" >&nbsp;&nbsp;
         <input type=reset value="다시쓰기">&nbsp;&nbsp;
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