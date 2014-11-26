<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:include page="../../right.jsp" flush="true"/> 
<br/><br/><br/><br/><br/>
<html>
<head><title>JSPBoard</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
<br><br>
<table width=80% cellspacing=0 cellpadding=3>
 <tr>
  <td bgcolor=#FFCD12 height=25 align=center>글쓰기</td>
 </tr>
</table>
<br>
<table width=80% cellspacing=0 cellpadding=3 align=center>
<form name=post method=post action="PostProc.jsp" >
<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>"/>
 <tr>
  <td align=center>
   <table border=0 width=100% align=center>
    <tr>
     <td width=10%>성 명</td>
     <td width=90%>${sessionScope.name }<input type = "hidden" name = "name" value="${sessionScope.name }"></td>
    </tr>
    <tr>
	 <td width=10%>E-Mail</td>
	 <td width=90%>${sessionScope.dto.email }<input type = "hidden" name = "email" value="${sessionScope.dto.email }"></td>
	</tr>
    <tr>
     <td width=10%>홈페이지</td>
     <td width=90%><input type=text name=homepage size=40 maxlength=30></td>
    </tr>
    <tr>
     <td width=10%>제 목</td>
     <td width=90%><input type=text name=subject size=50 maxlength=30></td>
    </tr>
    <tr>
     <td width=10%>내 용</td>
     <td width=90%><textarea name=content rows=10 cols=50></textarea></td>
    </tr>
    <!-- 
    <tr>
     <td width=10%>첨부 파일</td>
     <td width=90%><input type="file" name="upFile1"/></td>
    </tr>
	-->
    <tr>
     <td width=10%>비밀 번호</td> 
     <td width=90% ><input type=password name=pass size=15 maxlength=15></td>
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