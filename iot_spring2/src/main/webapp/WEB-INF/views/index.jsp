<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<script>
/* function callback(res){
	console.log(res);
}
	var au=new AjaxUtil("/path/json",null,"get","html");
	au.send(callback); */
	$(document).ready(function(){
		("#goLogin").click(function(){
			location.href="${pPath}/user/login";
		})
	})
</script>
<body>
<h1>
	Hello world!  
</h1>

<a href="${pPath}/user/login"> login</a><br>
<a href="${pPath}/db/main">db main</a><br>
</body>
</html>
