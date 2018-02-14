<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dhtmlx_toolbar1</title>
<style>
		 div#edit {
		 	 width: 100%;
		 	 height: 300px;
		 	 border: 1px solid #dfdfdf;
		 }
	</style>
<script>
		var myTabbar, editor;
		function doOnLoad() {
			myTabbar = new dhtmlXTabBar("my_tabbar");
			myTabbar.addTab("a1", "Tab 1-1", null, null, true);
			myTabbar.addTab("a2", "Tab 1-2");
			myTabbar.addTab("a3", "Tab 1-3");
			
			
			myTabbar.tabs("a2").attachHTMLString("The content can be set as <b>HTML</b> node or as <b>HTML</b> text.");
			myTabbar.tabs("a3").attachHTMLString("The content can be set as <b>HTML</b> node or as <b>HTML</b> text.");
			editor= new dhtmlXEditor("a1");
			editor.setContent("<b>Lorem");
		}
	</script>
</head>
<body onload="doOnLoad();">
	<div id="my_tabbar" style="width:395px; height:390px;"></div>
	<div id="edit"></div>
</body>
</html>