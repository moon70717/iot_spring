<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
$.ajax({
	url : "http://openapi.seoul.go.kr:8088/464c6c704f6d6f6f38396e43794e69/json/GetParkInfo/1/500/",
    type: "get",
    success : function(res){
    	console.log(res);
    }
});
</script>
<body>

</body>
</html>