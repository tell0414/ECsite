<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/styyle.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="main">
	<div id="top">
		<p>ItemList</p>
	</div>
	<h3>商品情報は以下になります。</h3>
	<table border="1">
		<tr>
			<th>商品名</th>
			<th>値段</th>
			<th>在庫</th>
		</tr>
	<s:iterator value="itemList">
		<tr>
			<th><s:property value="itemN"/></th>
			<th><s:property value="itemP"/></th>
			<th><s:property value="itemS"/></th>
		</tr>

	</s:iterator>

	<s:form action="ItemListDeleteConfirmAction">
		<s:submit value="削除"/>
	</s:form>
	</table>
</div>

</body>
</html>