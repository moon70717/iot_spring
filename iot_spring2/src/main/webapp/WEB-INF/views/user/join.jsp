<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<style>
div#winVP {
	position: relative;
	height: 100%;
	border: 1px solid #dfdfdf;
	margin: 10px;
}
</style>
<script>
	var winF, popW;
	$(document).ready(function() {
		//alert("${sessionScope.isLogin}");
		winF = new dhtmlXWindows();
		winF.attachViewportTo("winVP");
		popW = winF.createWindow("win1", 20, 30, 320, 300);
		//popW.hide(); 
		popW.button("close").hide();
		popW.button("minmax").hide();
		popW.button("park").hide();
		popW.setText("Signup");

		winF.window("win1").centerOnScreen();
		winF.window("win1").denyMove();
		winF.window("win1").denyResize();
		var formObj = [ {
			type : "settings",
			offsetTop : 12,
			name : "connectionInfo",
			labelAlign : "left"
		}, {
			type : "input",
			name : "uId",
			label : "아이디 : ",
			required : true
		}, {
			type : "password",
			name : "uPwd",
			label : "비밀번호 : ",
			required : true
		}, {
			type : "input",
			name : "uName",
			label : "uName : ",
			required : true
		}, {
			type : "input",
			name : "uEmail",
			label : "uEmail : ",
			required : true
		}, {
			type : "label",
			label : "관리자권한",
			list : [ {
				type : "radio",
				name : "admin",
				value : "1",
				label : "예"
			}, {
				type : "radio",
				name : "admin",
				value : "0",
				label : "아니오",
				checked : true
			} ]
		}, {
			type : "block",
			blockOffset : 0,
			list : [ {
				type : "button",
				name : "joinBtn",
				value : "회원가입"
			}, {
				type : "newcolumn"
			}, {
				type : "button",
				name : "cancelBtn",
				value : "취소"
			}, ]
		} ];
		var form = popW.attachForm(formObj, true);

		form.attachEvent("onButtonClick", function(id) {
			if (id == "joinBtn") {
				if (form.validate()) {
					var aud= new AjaxUtilDx("${root}/user/join",form);
					function callback(res) {
						console.log(res);
					}
					
					aud.send(callback);
					
					
				}
			} else if (id == "cancelBtn") {
				form.clear();
			}
		});
		/* if(${isLogin}){
		  popW.hide();
		} */

	})


	function setPopW(onOff) {
		if (onOff) {
			popW.show();
			return;
		}
		popW.hide();
	}
</script>
<body>
	<div id="winVP"></div>
</body>
</html>