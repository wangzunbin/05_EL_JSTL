<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${pro==null?"新增":"编辑" }学生</h2>
	<form action="/product?cmd=saveOrUpdate" method="post">
		<input type="hidden" name="id" value="${pro.id}">
		商品名称: <input name="productName" value="${pro.productName}"><br>
		商品分类: <input name="dir_id" value="${pro.dir_id}"><br>
		售价: <input name="salePrice" value="${pro.salePrice}"><br>
		供应商: <input name="supplier" value="${pro.supplier}"><br>
		商标: <input name="brand" value="${pro.brand}"><br>
		折价: <input name="cutoff" value="${pro.cutoff}"><br>
		成本价: <input name="costPrice" value="${pro.costPrice}"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>