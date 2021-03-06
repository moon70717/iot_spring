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

.my_ftr {
	background-color: white;
	padding-top: 9px;
}

.my_ftr .text {
	font-family: Roboto, Arial, Helvetica;
	font-size: 14px;
	color: #404040;
	padding: 5px 10px;
	height: 70px;
	border: 1px solid #dfdfdf;
}
</style>
<script> 

//alert("${user}");

var bodyLayout, dbTree,winF,popW; 
var aLay, bLay, cLay;
var bTabs, bTab1, bTab2, bTab3, cTabs;
var tableInfoGrid;
var lastDb, sql, tableType;
function columnListCB(res){
	console.log(res);
	if(res.list){
		tableType="tableData";
		infoGridCB(res.list);
	}
	if(res.descList){
		tableType="tableInfo";
		infoGridCB(res.descList);
	}
}

function infoGridCB(res){
	tableInfoGrid = bTabs.tabs(tableType).attachGrid();
	var columns = res[0];
	var headerStr = "";
	var colTypeStr = "";
	for(var key in columns){
		if(key=="id") continue;
		headerStr += key + ",";
		colTypeStr += "ro,";
	}
	headerStr = headerStr.substr(0, headerStr.length-1);
	colTypeStr = colTypeStr.substr(0, colTypeStr.length-1);
    tableInfoGrid.setColumnIds(headerStr);
	tableInfoGrid.setHeader(headerStr);
	tableInfoGrid.setColTypes(colTypeStr);
    tableInfoGrid.init();
	tableInfoGrid.parse({data:res},"js");
	console.log(res);
}

function connectionListCB(res){
	dbTree = aLay.attachTreeView({
	    items: res.list
	});
	dbTree.attachEvent("onDblClick",function(id){
		var level = dbTree.getLevel(id);
		if(level==2){
			var text = dbTree.getItemText(id);
			var au = new AjaxUtil("${root}/connection/tables/" + text + "/" + id,null,"get");
			lastDb=text;
			au.send(tableListCB); 
		}else if(level==3){
			var pId= dbTree.getParentId(id);
			var dbName = dbTree.getItemText(pId);
			var tableName = dbTree.getUserData(id,"orgText");
			var au = new AjaxUtil("${root}/connection/columns/" + dbName + "/" + tableName,null,"get");
			au.send(columnListCB);
			
		}
	});
}

function tableListCB(res){
	var parentId = res.parentId;
	var i=1;
	for(var table of res.list){
		var id = parentId + "_" + i++;
		var text = table.tableName;
		if(table.tableComment!=""){
			text += "[" + table.tableComment + "]";
		}
		text += ":"+ table.tableSize + "KB"; 
		dbTree.addItem(id, text, parentId);
		dbTree.setUserData(id,"orgText",table.tableName);
	}
	dbTree.openItem(parentId);
}
function addConnectionCB(res){
	var resParse=res.xmlDoc.response;
	console.log(resParse);
}
function dbListCB(res){
	console.log(res);
	if(res.error){
		alert(res.error);
		return;
	}
	var parentId = res.parentId;
	for(var db of res.list){
		var id = db.id;
		var text = db.text;
		dbTree.addItem(id, text, parentId);
	}
	dbTree.openItem(parentId);
}
dhtmlxEvent(window,"load",function(){
	bodyLayout = new dhtmlXLayoutObject(document.body,"3L");
	bodyLayout.attachFooter("footDiv");
	aLay = bodyLayout.cells("a");
	aLay.setWidth(300);
	aLay.setText("Connection Info List");
	var aToolbar = aLay.attachToolbar();
	aToolbar.addButton("addcon",1,"add Connector");
	aToolbar.addButton("condb",2,"Connection");
	aToolbar.attachEvent("onClick",function(id){
		if(id=="condb"){
			var rowId =dbTree.getSelectedId();
			if(!rowId){
				alert("접속할 커넥션을 선택해주세요.");
				return;
			}
			var au = new AjaxUtil("${root}/connection/db_list/" + rowId,null,"get");
			au.send(dbListCB); 
		}else if(id=="addcon"){
			popW.show();
		}
	})
	var au = new AjaxUtil("${root}/connection/list",null,"get");
	au.send(connectionListCB); 
	

	bLay = bodyLayout.cells("b");
	bTabs = bLay.attachTabbar({
		align:"left",
		tabs:[
			{id:"tableInfo", text:"Table Info", style:"color:red"},
			{id:"tableData", text:"Table Datas"},
			{id:"sql", text:"<span style='color:red;'>Run Sql</span>", active:true}
		]
	});
	var sqlFormObj = [
		{type: "block", blockOffset: 10, list: [
			{type: "button", name:"runBtn",value: "실행"},
			{type: "newcolumn"},
			{type: "button", name:"cancelBtn",value: "취소"}
		]},
		{type:"input",name:"sqlTa",label:"sql",required:true,rows:10,style:"background-color:#ecf3f9;border:1px solid #39c;width:800"},
	];
	
	//키다운 이벤트
	var sqlForm = bTabs.tabs("sql").attachForm(sqlFormObj);
	sqlForm.attachEvent("onKeydown", function(inp, ev, name, value){
		if(ev.key=="F9"){
			sqlEvnet("runBtn");
		}
		if(ev.ctrlKey&&ev.key=="s"){
			console.log(ev);
			sql=sqlForm.getItemValue("sqlTa");
			setDown(1);
		}
	});
	
	function setDown(res){
		$("#downLink").prop('href',"data:application/text;charset=utf-8,"+sql);
		$("#downLink").prop('download',"insert.sql");
		$("#downLink")[0].click();
	}
	
	//여기서 select와 insert들의 분기를 해주는게 좋을듯
	//select면 c에 출력되게 insert면 log에 결과값을 넣어주게
	//주소에 애가 어떤놈인지 넣어주면 될듯
	//insert, select, update 이렇게 3개로
	sqlForm.attachEvent("onButtonClick",sqlEvnet)
	
	function sqlEvnet(id){
		if(id=="runBtn"){
			sql=sqlForm.getItemValue("sqlTa");
			$.ajax({
				url : "${root}/sqls/custom/"+lastDb,
		        type: "get",
		        data : { "sql" : sql },
		        success : customSql
			});
		}else if(id=="cancelBtn"){
			sqlForm.clear();
		}
	}
	
	//c에 테이블 달아주는부분
	function customSql(res){
		var customSqlTabT="";
		var sqlN=0;
		for(var r of res.result){
			console.log(r);
			customSqlTabT=customSqlTabT+"{id:'"+sqlN+"',text:'result"+sqlN+"'},";
			sqlN++;
		}
		
		customSqlTabT=customSqlTabT.substring(0,customSqlTabT.length-3);
		customSqlTabT="["+customSqlTabT+"', active:true}]";
		customSqlTabT=eval(customSqlTabT);
		
		cTabs = cLay.attachTabbar({
			align:"left",
			tabs:customSqlTabT
		});
		console.log(cTabs);
		for(var i=0;i<res.result.length;i++){
			if(res.result[i].length>=1){
				attGrid(res.result[i],i);
			}
		}
		$("#logDiv").append(sql+" 실행 성공<br>");
		$("#logDiv").scrollTop($("#logDiv")[0].scrollHeight);
	}
	
	//그리드 제작
	// cLay 바꿔줘야함
	//cLay가 아니라 탭으로 변경
	function attGrid(res,i){
		tableInfoGrid =cTabs.tabs(i).attachGrid();
		var columns = res[0];
		var headerStr = "";
		var colTypeStr = "";
		var styleStr=[];
		for(var key in columns){
			if(key=="id") continue;
			headerStr += key + ",";
			colTypeStr += "ro,";
			styleStr.push("color:red;");
		}
		headerStr = headerStr.substr(0, headerStr.length-1);
		colTypeStr = colTypeStr.substr(0, colTypeStr.length-1);
		//styleStr = styleStr.substr(0, styleStr.length-1);
        tableInfoGrid.setColumnIds(headerStr);
		//tableInfoGrid.setHeader(headerStr);
		tableInfoGrid.setHeader(
				headerStr,
			    null,
			    styleStr
		);
		tableInfoGrid.setColTypes(colTypeStr);
        tableInfoGrid.init();
		tableInfoGrid.parse({data:res},"js");
		console.log(res);
		
	}
	
	
	cLay = bodyLayout.cells("c");
	cLay.setText("Sql Result");
	winF = new dhtmlXWindows();
	popW = winF.createWindow("win1",20,30,320,450);
	//popW.hide(); 
	popW.setText("Add Connection Info"); 
	var formObj = [
		        {type:"settings", offsetTop:12,name:"connectionInfo",labelAlign:"left"},
				{type:"input",name:"ciName", label:"커넥션이름",required:true},
				{type:"input",name:"ciUrl", label:"접속URL",required:true},
				{type:"input",name:"ciPort", label:"PORT번호",validate:"ValidInteger",required:true},
				{type:"input",name:"ciDatabase", label:"데이터베이스",required:true},
				{type:"input",name:"ciUser", label:"유저ID", required:true},
				{type:"input",name:"uId", label:"사용자 ID", value:"123", readonly:"true"},
				{type:"password",name:"ciPwd", label:"비밀번호",required:true},
				{type:"input",name:"ciEtc", label:"설명"},
				{type: "block", blockOffset: 0, list: [
					{type: "button", name:"saveBtn",value: "저장"},
					{type: "newcolumn"},
					{type: "button", name:"cancelBtn",value: "취소"}
				]}
		];
	var form = popW.attachForm(formObj,true);
	popW.hide();
	
	form.attachEvent("onButtonClick",function(id){
		if(id=="saveBtn"){
			if(form.validate()){
				form.send("${root}/connection/insert", "post",addConnectionCB);
			}
		}else if(id=="cancelBtn"){
			form.clear();
		}
	});
	
})
</script>
<body>
	<div id="footDiv" class="my_ftr">
		<div id="logDiv" class="text" style="overflow: auto"></div>
	</div>
	<a href="#" id="downLink" style="display:none" download="#"></a>
</body>
</html>