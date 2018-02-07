<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
html, body {
	width: 100%; /*provides the correct work of a full-screen layout*/
	height: 100%; /*provides the correct work of a full-screen layout*/
	overflow: hidden; /*hides the default body's space*/
	margin: 0px; /*hides the body's scrolls*/
}

div.controls {
	margin: 0px 10px;
	font-size: 14px;
	font-family: Tahoma;
	color: #404040;
	height: 80px;
}
</style>
<script>
	var bodyLayout;
	/* dhtmlxEvent(window, "load", function() {
		bodyLayout = new dhtmlXLayoutObject(document.body, "3L");
		bodyLayout.cells("a").setWidth(300);
		bodyLayout.cells("a").setText("Conection Info List");
	}) */
	function get() {
		dhtmlxEvent(window, "load", function() {
			var obj = document.getElementById("container");
			bodyLayout = new dhtmlXLayoutObject(obj, "3L");
			bodyLayout.cells("a").setWidth(300);
			bodyLayout.cells("a").setText("Conection Info List");
		})
	}
</script>
<body>
<div id="container"></div>
	<button onclick="get()">나와랏!</button>
</body>
</html>