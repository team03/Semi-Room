<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8");%>
<jsp:include page="right.jsp" flush="true"/> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<link rel ="stylesheet" type = "text/css" href="test.css">

	<style type = "text/css">
	<!--
	.tcolor
	{background-color : skyblue; border-color: skyblue;}

	.t2color
	{border-style:inset; border-color:skyblue;}

	-->
	</style>
<script src="/semi3jo_bfcss/bootstrap/js/check.js"></script>  <!-- check.js 선언 -->
<script>
function fnZipSearch(){
	window.open("/semi3jo/zipSearch.jsp","","toolbars=no, width=500, height=400, status=no, scrollbars=yes, menubars=no");
}
</script>
</head>
<body>
<center>
<br><br><br><br>

	<form name="f" method="post" action = "member_modify_ok.ma">
	<input type="hidden" name="cmd" value="m_modify_ok">
	<table border  = "1" bordercolor = "blue" bgcolor = "white"  width = "700"	height = "300" align ="center">
	
	<caption><h2>회 원 정 보 수 정</font></h2></caption>

	<tr>
	<td align = "right" class = "tcolor">아이디</td>
	<td align = "left" class = "t2color">${sessionScope.dto.id }<input type = "hidden" name = "id" value="${sessionScope.dto.id }"></td>
	</tr>
	
	<tr>
	<td align = "right" class = "tcolor">비밀번호</td>
	<td align = "left" class = "t2color"><input type = "password" name = "pw" size = "10" value="${sessionScope.dto.pw }"> 비밀번호 확인 <input type = "password" name = "pw2" size = "12"> </td>
	</tr>
	
	<tr >
	<td align = "right" class = "tcolor">이름</td>
	<td align = "left" class = "t2color"><input type = "text" name = "name" size = "10" value="${sessionScope.name }"></td>
	</tr>

	<tr>
	<td align = "right" class = "tcolor">전화번호</td>
	<td align = "left" class = "t2color"><input type = "text" name = "phone" size = "20" value="${sessionScope.dto.phone }"></td>
	</tr>

	<tr>
	<td align = "right" class = "tcolor">이메일</td>
	<td align = "left" class = "t2color"><input type = "text" name = "email" size = "20" value="${sessionScope.dto.email }"></td>
	</tr>

	<tr>
	<td align = "right" class = "tcolor">주소</td>
	<td align = "left" class = "t2color"><input type = "text" name = "zip1" size = "3" value="${sessionScope.dto.zip1 }">-<input type = "text" name = "zip2" size = "3" value="${sessionScope.dto.zip2 }"> 
	<input type="button" value="조회" onclick="fnZipSearch()"><br/>
	<input type = "text" name = "address" size = "50" value="${sessionScope.address }"></td>
	</tr>

	<tr align = "center">
	<td colspan = 2  class = "t2color"><input type="submit" value="수정">&nbsp;<input type="reset" value = 재입력></td>
	</tr>

	</table>
	</form>
	
</center>
</body>
</html>