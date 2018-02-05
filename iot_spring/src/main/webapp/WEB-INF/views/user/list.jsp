<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="http://cdn.dhtmlx.com/edge/dhtmlx.css"
	type="text/css">
<script src="http://cdn.dhtmlx.com/edge/dhtmlx.js"
	type="text/javascript"></script>
<style>
#gridbox {
	width: 500px; 
	max-width: 40%;
	height: 500px;
	margin-top: 5%;
	margin-left:35%;
}
</style>
<body>
	<div id="gridbox"></div>

	<a href="https://docs.dhtmlx.com/grid__basic_initialization.html"
		target="_blank">docs</a>

	<script>
		mygrid = new dhtmlXGridObject('gridbox');
		/* mygrid.setImagePath("./codebase/imgs/"); */
		mygrid.setHeader("uiNo,uiName,uiId,uiRegdate");  
		mygrid.setInitWidths("150,80,90,150");  
		mygrid.setColAlign("left,left,left,left");   
		mygrid.setColTypes("ro,ed,ed,ed");  
		mygrid.setColSorting("int,str,str,str");   
		mygrid.init();
		mygrid.parse("${userList}", "json");
	</script>
</body>
</html>
