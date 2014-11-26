<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="/semi3jo_bfcss/bootstrap/css/bootstrap.css" rel="stylesheet" />
<script src="/semi3jo_bfcss/bootstrap/js/jquery-2.1.1.js"></script>
<script src="/semi3jo_bfcss/bootstrap/js/bootstrap.js"></script>
</head>
<style>
	body {
		margin-top: 10px;
	}
</style>
<body>
	<div class="container">
		<div class="row">
			<div class="span6">
				<ul class="nav nav-pills">
					<li class="active"><a href="mypage.jsp">메인</a></li>
					<li><a href="/semi3jo_bfcss/hwang/board/List.jsp">게시판</a></li>
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">OX문제<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="/semi3jo_bfcss/hwang/OXQuiz/oxLoad_all.jsp">All</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="/semi3jo_bfcss/hwang/OXQuiz/oxLoad_word.jsp">단어</a></li>
							<li><a tabindex="-1" href="/semi3jo_bfcss/hwang/OXQuiz/oxLoad_grammar.jsp">문법</a></li>
						</ul>			
					</li>
					<li><a href="/semi3jo_bfcss/lee/word.jsp">단어</a></li>
					<li><a href="/semi3jo_bfcss/calendar.jsp">일정</a></li>
				</ul>
			</div>
			<div class="span6">
				<ul class="nav nav-pills">
					<li class="active"><a><%=session.getAttribute("name") %></a></li>
					<li><a href="/semi3jo_bfcss/member_modify.ma?cmd=m_modify">회원정보수정</a></li>
					<li><a href="/semi3jo_bfcss/member_dropout.jsp">그룹탈퇴</a></li>
					<li><a href="/semi3jo_bfcss/logout.ma?cmd=logout" target="_parent">로그아웃</a></li>	
				</ul>
			</div>
		</div>
	</div>
</body>
</html>