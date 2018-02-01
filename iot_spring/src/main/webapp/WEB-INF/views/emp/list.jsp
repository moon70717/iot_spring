<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

function send(url){
	$.ajax({
		url:url,
		success: function(res){
			var dataStr="";
			for(var i=0;i<res.length;i++){
				var data=res[i];
				dataStr+="<tr>";
				dataStr+="<td>"+data.name+"</td>";
				dataStr+="<td>"+data.age+"</td>";
				dataStr+="</tr>";
			}
			$("#tb").html(dataStr);
		}
	})
}

$(document).ready(function(){
	var go=new gridObj("resultDiv");   
	go.alert("test");
	send("${root}/h2");
});
</script>
</head>
<body>
<table border="1">
	<tr>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<tbody id="tb">
	
	</tbody>
</table>
</body>
</html>