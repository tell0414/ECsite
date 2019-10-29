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
		<p>管理者画面</p>
	</div>
	<tr>
		<td><p>商品</p></td>
		<td>
			<s:form action="ItemCreateAction">
				<s:submit value="新規登録"/>
			</s:form>
			<s:form action="ItemListAction">
				<s:submit value="一覧"/>
			</s:form>
		</td>
		<tr>
		<br>
		<td><p>ユーザー</p></td>
		<td>
			<s:form action="UserCreateAction">
				<s:submit value="新規登録"/>
			</s:form>
			<s:form action="UserListAction">
				<s:submit value="一覧"/>
			</s:form>
		</td>
	</tr>



</div>

</body>
</html>