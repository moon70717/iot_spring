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
	var bodyLayout, aLay, dbTree;
	var formObj=[{type:"settings",offsetTop:12,name:"connectionInfo",labelAlign:"left"},
		{type:"input",name:"ciName",label:"커넥션이름",required:true},
		{type:"input",name:"ciUrl",label:"접속 url",required:true},
		{type:"input",name:"ciPort",label:"포트 번호",validate:"ValidInteger",required:true},
		{type:"input",name:"ciDatabase",label:"접속 데이터베이스",required:true},
		{type:"input",name:"ciUser",label:"커넥션 아이디",required:true},
		{type:"input",name:"ciPwd",label:"비밀번호",required:true},
		{type:"input",name:"uId",label:"유저 아이디",required:true},
		{type:"input",name:"ciEtc",label:"기타"},
		{type:"block",blockOffset:0,list:[
			{type:"button",name:"saveBtn",value:"저장"},
			{type:"newcolumn"},
			{type:"button",name:"cancelBtn",value:"취소"}
		]}
	];
	var formObj2=[{type:"settings",offsetTop:12,name:"connectionInfo",labelAlign:"left"},
		{type:"input",name:"ciNo",label:"수정할 번호",required:true},
		{type:"input",name:"ciName",label:"커넥션이름",required:true},
		{type:"input",name:"ciUrl",label:"접속 url",required:true},
		{type:"input",name:"ciPort",label:"포트 번호",validate:"ValidInteger",required:true},
		{type:"input",name:"ciDatabase",label:"접속 데이터베이스",required:true},
		{type:"input",name:"ciUser",label:"커넥션 아이디",required:true},
		{type:"input",name:"ciPwd",label:"비밀번호",required:true},
		{type:"input",name:"uId",label:"유저 아이디",required:true},
		{type:"input",name:"ciEtc",label:"기타"},
		{type:"block",blockOffset:0,list:[
			{type:"button",name:"saveBtn",value:"저장"},
			{type:"newcolumn"},
			{type:"button",name:"cancelBtn",value:"취소"}
		]}
	];
	function callback(res) {
		console.log(res);
		dbTree = aLay.attachTreeView({
			items : res.dbList
		});
		//dbTree.setImagePath("${rPath}/dx/skins/web/imgs/dhxtree_web/");
		//dbTree.enableDragAndDrop(true);
	}
	function successCallback(res){
		console.log(res.msg);
	}
	dhtmlxEvent(window, "load", function() {
		bodyLayout = new dhtmlXLayoutObject(document.body, "4L");
		aLay = bodyLayout.cells("a");
		aLay.setWidth(300);
		aLay.setText("Connection Info List");
		var aToolbar = aLay.attachToolbar();
		aToolbar.addButton("adddb", 1, "add Connector");
		aToolbar.addButton("condb", 2, "Connection");
		aToolbar.attachEvent("onClick", function(id) {
			alert(id);
		})
		var au = new AjaxUtil("${root}/connection/db_list", null, "get");
		au.setCallbackSuccess(callback);
		au.send();
		
		var aLay2=bodyLayout.cells("b");
		aLay2.setWidth(450);
		aLay2.setText("insert");
		var form=aLay2.attachForm(formObj);
		form.attachEvent("onButtonClick",function(id){
			if(id=="saveBtn"){
				alert("??");
				if(form.validate()){
					form.send("${root}/connection/insert","post",successCallback);	
				}
			}else if(id=="cancelBtn"){
				form.clear();
			}
		});
		
		var last;
		var au = new AjaxUtil("${root}/connection/db_list", null, "get");
		au.setCallbackSuccess(function a(res) {
			console.log("last= "+res);
			last=res;
		});
		au.send();
		
		
		var aLay3=bodyLayout.cells("c");
		var Grid=aLay3.attachGrid();
		Grid.setImagePath("./codebase/imgs/");
		Grid.setHeader("uiNo,uiName,uiId,3,4");
		Grid.setInitWidths("50,80,90");
		Grid.setColAlign("left,left,left");
		Grid.setColTypes("ro,ed,ed");
		Grid.setColSorting("str,str,str");
		Grid.setColumnIds("uiNo,uiName,uiId,3,4");
		Grid.init();
		
		var aLay4=bodyLayout.cells("d");
		aLay4.setWidth(450);
		aLay4.setText("수정");
		var form4=aLay4.attachForm(formObj2);
		form4.attachEvent("onButtonClick",function(id){
			if(id=="saveBtn"){
				alert("??");
				if(form4.validate()){
					form4.send("${root}/connection/insert","post",successCallback);	
				}
			}else if(id=="cancelBtn"){
				form4.clear();
			}
		});
</script>
<body>

</body>
</html>