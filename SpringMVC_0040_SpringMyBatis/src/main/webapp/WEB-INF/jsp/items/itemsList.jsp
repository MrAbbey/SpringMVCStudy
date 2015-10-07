<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>查询商品列表</title>
</head>
<body>

<script type="application/javascript">
  function queryItems(){
    document.itemsForm.action = "${pageContext.request.contextPath}/items/queryItems.action";
    document.itemsForm.submit();
  }

  function deleteItems(){
    document.itemsForm.action = "${pageContext.request.contextPath}/items/deleteItems.action";
    document.itemsForm.submit();
  }
</script>

<form name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action" method="get">
  <table width="100%" border=1>
    <tr>
      <td>
        <input type="text" name="itemsCustom.name" />
      </td>
      <td>
        <input type="button" value="查询" onclick="queryItems();"/>
        <input type="button" value="批量删除" onclick="deleteItems();"/>
      </td>
    </tr>
  </table>

商品列表：
<table width="100%" border=1>
  <tr>
    <td>选择</td>
    <td>商品名称</td>
    <td>商品价格</td>
    <td>商品描述</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${itemsList}" var="item">
    <tr>
      <td>
        <input type="checkbox" name="item_ids" value="${item.id}"/>
      </td>
      <td>${item.name }</td>
      <td>${item.price }</td>
      <td>${item.detail }</td>
      <td><a href="${pageContext.request.contextPath}/items/queryItemsDetail.action?id=${item.id}">操作</a></td>
    </tr>
  </c:forEach>
</table>
</form>
</body>
</html>
