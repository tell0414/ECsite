<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="header.jsp" />
<div id="main">
	<div id="top">
		<p>UserList</p>
	</div>
	<h3>ユーザー情報は以下になります。</h3>
	<table border="1">
	<tr>
		<th>Id</th>
		<th>パスワード</th>
		<th>名前</th>
		<th>登録日</th>
	</tr>
	<s:iterator value="userList">
		<tr>
			<td><s:property value="Id"/></td>
			<td><s:property value="Pass"/></td>
			<td><s:property value="Name"/></td>
			<td><s:property value="Date"/></td>
		</tr>

	</s:iterator>

	</table>
</div>

</body>
</html>