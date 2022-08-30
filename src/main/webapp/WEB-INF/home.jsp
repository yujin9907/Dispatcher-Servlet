<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
webapp밑 폴더는 다이렉트하게 찾을 수 있음
WEB-INF는 보안 폴더, 외부에서 URL로 접근할 수 없음 => 컨트룰러를 통해 요청하도록 강제시키는 역할
CV 패턴을 지키게 됨
그래서 스프링에서 JSP를 사용할 때 뷰리졸버 설정을 해준 거임.(자체적으로 적용되지 않기 때문에 스프링이 버림 ㅠㅠ)
</body>
</html>