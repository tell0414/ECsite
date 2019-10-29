<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Insert title here</title>
</head>
<body>
<div id="header"></div>
<div id="main">
	<div id="top">
		<p>ItemListDeleteConfirm</p>
	</div>
	<s:form action="ItemLstDeleteCompleteAction">
		<s:submit value="キャンセル"/>
	</s:form>

	<s:form action="ItemLstDeleteCompleteAction">
		<input type="hidden" name="deleteFlg" value="">
		<s:submit value="削除"/>
	</s:form>
</div>

</body>
</html>