<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>Home画面</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="main">
	<div id="top">
		<p>Home</p>
	</div>
	<div id="text-center">
		<s:form action="HomeAction">
			<s:submit value="商品購入"/>
		</s:form>
		<s:form action="AdminAction">
			<s:submit value="管理者"/>
		</s:form>
		<s:if test="#session.login_user_id!=null">
<!-- 		login_user_idに何もなければ -->
			<p>ログアウトする場合は
				<a href='<s:url action="LogoutAction"/>'>こちら</a></p>

		</s:if>

	</div>
</div>
<div id="footer"></div>

</body>
</html>