<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#gridbox {
	min-width: 200px;
	max-width: 40%;
	height: 500px; 
	margin-top: 1%;
	margin-left: 35%;
}
</style>
<body>
	<div id="gridbox">
		<%-- <table data-toggle="table" id="userTable">
			<thead>
				<tr>
					<th data-field="uiNo">번호</th>
					<th data-field="uiName">이름</th>
					<th data-field="uiId">아이디</th>
				</tr>
			</thead>
		</table>
		<a href="${path}/emp/write">사원정보 추가</a> --%>

	</div>

	<a href="https://docs.dhtmlx.com/grid__basic_initialization.html"
		target="_blank">docs</a>
	<script>
		var vv = "uiNo";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath("./codebase/imgs/");
		mygrid.setHeader(vv+",uiName,uiId");
		mygrid.setInitWidths("50,80,90");
		mygrid.setColAlign("left,left,left");
		mygrid.setColTypes("ro,ed,ed");
		mygrid.setColSorting("str,str,str");
		mygrid.setColumnIds("uiNo,uiName,uiId");
		mygrid.init();
		//mygrid.parse("${dhtmlUserList}", "json");
		
		var au = new AjaxUtil("${root}/user/lista", null, "GET", "json");
		function callback(res) {
			console.log(res);
			mygrid.parse({
				data:res
			}, "js");
		}
		au.setCallbackSuccess(callback);
		au.send();

		/* $(document).ready(function(){
			var au = new AjaxUtil("${root}/user/lista", null, "GET", "json");
			function callback(res) {
				console.log(res);
				$("#userTable").bootstrapTable({
					data : res
				});
			}
			au.setCallbackSuccess(callback);
			au.send();			
		}); */
	</script>
</body>
</html>
