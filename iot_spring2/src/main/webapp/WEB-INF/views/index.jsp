<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
	$(document).ready(function() {
		$("#goLogin").click(function() {
			location.href = "${pPath}/user/login";
		})

		function clock() {
			var time = new Date(), hours = time.getHours(), minutes = time.getMinutes(), seconds = time.getSeconds();
			document.querySelectorAll('.clock')[0].innerHTML = harold(hours) + ":" + harold(minutes) + ":" + harold(seconds);

			function harold(standIn) {
				if (standIn < 10) {
					standIn = '0' + standIn
				}
				return standIn;
			}
		}
		setInterval(clock, 1000);
	})
</script>
<style>
* {
	text-align: center;
	color:black;
	text-decoration:none;
}

.clock {
	margin-top: 10%;
	font-size: 4em
}
</style>
<body>
	<div class="clock"></div>
	<h1>Hello world!</h1>

	<a href="${pPath}/user/login"> login</a>
	<br>
	<a href="${pPath}/db/main">db main</a>
	<br>
</body>
</html>
