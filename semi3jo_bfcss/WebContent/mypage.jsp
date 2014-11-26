<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("utf-8");%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Insert title here</title>

</head>

<body>

<!-- 로그인 했는지 검사하기 empty는 세션스코프의 login이 있나없나를 확인함-->
<c:if test="${empty sessionScope.id }">

	<script type="text/javascript">

		alert("로그인 후 이용해 주세요.");

		location.href="login.ma?cmd=main";

	</script>

</c:if>



<!-- sessionScope객체는 생략가능! -->

<!-- login.id하면 login에 dto객체가 담겨져 있으므로 그안의 id를 뽑아내갰다는의미 -->

<jsp:include page="right.jsp" flush="true"/><br/>
[${sessionScope.name }]님 환영합니다.<br/>
여기는 mypage입니다.
				
</body>
</html>