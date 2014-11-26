<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link href="/BootstrapApp/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="/BootstrapApp/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<h1>OX퀴즈</h1>

<div class="span4">
			<div class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
				문제 불러오기<i class="caret"></i></a>
				<ul class="dropdown-menu">
					<li><a href="oxLoad_all.jsp">All</a></li>
					<li class="divider"/>
					<li><a href="oxLoad_word.jsp">단어</a></li>
					<li class="divider"/>
					<li><a href="oxLoad_grammar.jsp">문법</a></li>
				</ul>
			</div>
</div>
<div class="span4">
<a href="oxSave.jsp">문제 등록하기</a><br/>
</div>
</body>
</html>