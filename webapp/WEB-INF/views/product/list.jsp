<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
<style type="text/css">
td {
	text-align: center;
}

th {
	text-align: center;
}

table {
	margin: 0 auto;
}

h2 {
	text-align: center;
}

#add {
	text-align: center;
	margin-bottom: 50px;
}
</style>
</head>
<body>
	<h2>商品列表</h2>
	<div id="add">
		<a href="/product?cmd=edit">新增学生</a>
	</div>
	<div>
		<table cellpadding="0" cellspacing="0" width="60%" border="1">
			<tr style="background-color: yellow;">
				<th>编号</th>
				<th>产品名称</th>
				<th>商品分类</th>
				<th>售价</th>
				<th>供应商</th>
				<th>商标</th>
				<th>折价</th>
				<th>成本价</th>
				<th>操作</th>

			</tr>
			<c:forEach items="${list}" var="pro" varStatus="vs">
				<tr style="background-color: ${vs.count%2==0?'pink':''};">
					<td>${pageScope.pro.id }</td>
					<td>${pageScope.pro.productName }</td>
					<td>${pageScope.pro.dir_id }</td>
					<td>${pageScope.pro.salePrice }</td>
					<td>${pageScope.pro.supplier }</td>
					<td>${pageScope.pro.brand }</td>
					<td>${pageScope.pro.cutoff }</td>
					<td>${pageScope.pro.costPrice }</td>
					<td><a href="/product?cmd=delete&id=${pageScope.pro.id }" />删除
						| <a href="/product?cmd=edit&id=${pageScope.pro.id }" />编辑</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>