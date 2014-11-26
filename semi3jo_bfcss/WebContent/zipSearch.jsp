<%@page import="cont.ZipDto"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<script>
	function fnSendAddr(zipcode, sido, gugun, dong, bunji){
		var addr = sido + " " + gugun + " " + dong + " " + bunji;
		opener.document.f.zip1.value = zipcode.substring(0,3);
		opener.document.f.zip2.value = zipcode.substring(4);
		opener.document.f.address.value = addr;
		
		self.close();
	}
</script>
<body>

<h2>우편번호 찾기</h2>

<form method="post" action="semi3jo.ma">
	<input type="hidden" name="cmd"	value="zipcommand"/>
	<table>
		<tr>
			<td>
				동이름 입력: <input type="text" name="dong"/>
				&nbsp;&nbsp;<input type="submit" value="검색"/>
			</td>
		</tr>
<%
	try{
		Vector vAddr = (Vector)request.getAttribute("addr");
		if(vAddr.size() == 0 || vAddr == null){
%>
	<tr><td>검색 결과가 없습니다. </td></tr>			
<% 
		}
		else{
			String bunji = "";
			for(int i=0; i<vAddr.size(); i++){
				ZipDto dto = (ZipDto)vAddr.get(i);
				if(dto.getBunji() == null){
					bunji = "";
				}
				else{
					bunji=dto.getBunji();
				}
%>
		<tr>
			<td>
				<%System.out.println("hello"); %>
				<a href="javascript:fnSendAddr('<%=dto.getZipcode() %>','<%=dto.getSido() %>',
				'<%=dto.getGugun() %>','<%=dto.getDong() %>','<%=bunji %>')">
				<%=dto.getZipcode() %>	
				<%=dto.getSido() %>		
				<%=dto.getGugun() %>		
				<%=dto.getDong() %>	
				<%=bunji %></a>
			</td>
		</tr>
<%		
			}
		}
	}
catch(NullPointerException err){}
%>
	</table>
<br/>
<input type="button" value="닫기" onclick="javascript:window.close()"/>		
</form>
</body>
</html>