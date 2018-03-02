<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="demo"></div>
<script>
var x=document.getElementById("demo");
var now;
function getLocation(){
    if (navigator.geolocation){
        now=navigator.geolocation.getCurrentPosition(showPosition);
        console.log(now);
    }else{
        x.innerHTML="Geolocation is not supported by this browser.";
    }
}
function showPosition(position){
    x.innerHTML="Latitude: " + position.coords.latitude + "<br />Longitude: " + position.coords.longitude; 
}
getLocation();
</script>
</body>
</html>