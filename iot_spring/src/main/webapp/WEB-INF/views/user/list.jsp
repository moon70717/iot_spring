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
	width: 50%; 
	height: 400px;
	margin-top: 5%;
	margin-left: auto;
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
		mygrid.setInitWidths("150,150,150,150");  
		mygrid.setColAlign("left,left,left,left");   
		mygrid.setColTypes("ro,ed,ed,ed");  
		mygrid.setColSorting("int,str,str,str");   
		mygrid.init();
		/* data json을 ajax로 받게 변경할것 */
/* 		alert("${userList}"); */
		var data = {
			rows : [ {
				id : 1,
				data : [ "A Time to Kill", "John Grisham", "100", "4500" ]
			}, {
				id : 2,
				data : [ "Blood and Smoke", "Stephen King", "1000", "4500" ]
			}, {
				id : 3,
				data : [ "The Rainmaker", "John Grisham", "-200", "4500" ]
			} ]
		};
		data={rows : [ 
			{ 
				id:1,
				data : [ "1", "홍길동", "red", "2018-01-07 16:24:47.0" ]
			}, { 
				id:2,
				data : [ "2", "금길동", "gold", "2018-01-07 16:24:47.0" ]
			}, { 
				id:3,
				data : [ "3", "백길동", "white", "2018-01-07 16:24:47.0" ]
			}]
		};
		/* ,
		{ 
			id:4,
			data : [ 4, 청길동, blue3, 2018-01-07 16:24:47.0 ]
		} */
		alert("${userList}");
		alert(data);
		mygrid.parse("${userList}", "json");
	</script>
</body>
</html>
