<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	$.ajax({
		url : "${root}/sql/test",
        type: "get",
        data : { "id" : "3" },
        success : function(data){
            alert(data);
        }
	});
});
</script>
<body>

</body>
</html>