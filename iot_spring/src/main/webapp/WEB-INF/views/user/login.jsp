<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${rPath}/ui/css/sign.css" />
<link rel="stylesheet" href="${rPath}/ui/css/style.css" />
</head>
<body>
	<div class="result_div"></div>
	<div class="container">
		<div class="login-card">
			<h1>Log-in</h1>
			<br>
			<form>
				<input type="text" id="userId" name="userId" placeholder="UserId">
				<input type="password" id="userPwd" name="userPwd"
					placeholder="Password"> <span> <input
					type="checkbox" id="saveId" name="saveId"> <a
					onclick="alsoCheck()">Remember Id</a>
				</span> <input type="button" id="loginBtn" class="login login-submit"
					value="login" onclick="checkValue()">
			</form>

			<div class="login-help">

				<a href="/view/user/signin">Register</a>

			</div>
		</div>
	</div>
</body>
<script>
function alsoCheck(){
	var cBox=$("#saveId");
	cBox.prop("checked",!cBox.prop("checked"))
}
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

$(document).ready(function(){
   var userId = getCookie("userId");
   var saveId = getCookie("saveId");
   if(userId){
      $("#userId").val(userId);
      $("#saveId").prop("checked",true);
   }
});

        function checkValue() {
            var objs = $(".container");
            var userId = $("#userId").val().trim();
            var userPwd = $("#userPwd").val().trim();
            var saveId=$("#saveId").prop("checked");
            if (userId.length < 3) {
                alert("유저아이디 확인해!!");
                $("#userId").focus();
                return;
            } else if (userPwd.length < 3) {
                alert("비밀번호 확인해!!");
                $("#userPwd").focus();
                return;
            } else{
            	
            }
            var param = {
                uiId: userId,
                uiPwd: userPwd,
                saveId: saveId
            };

            param = "param=" + encodeURIComponent(JSON.stringify(param));
            $.ajax({
                url: '${root}/user/login',
                data: param,
                type: 'get',
                success: function() {
                    alert("${user}");
				},
				error : function(xhr, status, error) {
					alert("ㄴㄴ");
				}
		})
	}
</script>

</html>