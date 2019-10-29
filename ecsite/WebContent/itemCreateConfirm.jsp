<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
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
		<p>ItemCreateConfirm</p>
	</div>
	<div>
		<h3>登録する内容は以下でよろしいでしょうか。</h3>
		<table>
			<s:form action="CreateCompleteAction">
			<tr id="box">
				<td>
					<label>商品名:</label>
				</td>
				<td>
					<s:property value="itemName" escape="false"/>
				</td>
			</tr>
			<tr id="box">
				<td>
					<label>値段:</label>
				</td>
				<td>
					<s:property value="itemValue" escape="false"/>
				</td>
			</tr>
			<tr id="box">
				<td>
					<label>個数:</label>
				</td>
				<td>
					<s:property value="itemStock" escape="false"/>
				</td>
			</tr>
			<tr>
				<td>
					<s:submit value="完了"/>
				</td>
			</tr>

			</s:form>
		</table>
	</div>
</div>

</body>
</html>