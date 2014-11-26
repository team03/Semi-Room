<%@page import="java.util.ArrayList"%>
<%@page import="word.RandomWord"%> 
<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/semi3jo_bfcss/bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="/semi3jo_bfcss/bootstrap/css/048.css" rel="stylesheet" />
<script src="/semi3jo_bfcss/js/jquery-2.1.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../right.jsp" flush="true"/> 
<div class="container">
		<table>
		 <caption>Daily Voca</caption>
		 <colgroup>
		 <col />
		 <col />
		 </colgroup>
		 <thead>
		 <tr>
		   <th>No</th><th>Word</th> <th>Meaning</th>
		 </tr>
		 </thead>
		 <tfoot>
		 </tfoot>
		 <tbody>
<%
		RandomWord r_word = new RandomWord();
		ArrayList<String> word_list = r_word.Print_word();
		
		System.out.println("ddd"+word_list.size());
		if(word_list.size() == 0 || word_list == null) {
			r_word.Sel_word();
			word_list = r_word.Print_word();
		}
		
		for(int i=0; i<word_list.size(); i++){
			String word_mean = word_list.get(i);
			String[] data = word_mean.split(",");
			String[] word = new String[word_list.size()];
			String[] meaning = new String[word_list.size()];
			word[i] = data[0];
			meaning[i] = data[1];
%>
		 <tr>
		  <th><%=(i+1) %></th><td><%=word[i] %></td> <td><%=meaning[i] %></td>
		 </tr>
<%}%>
		 </tbody>
		 </table>
</div>
</body>
</html>