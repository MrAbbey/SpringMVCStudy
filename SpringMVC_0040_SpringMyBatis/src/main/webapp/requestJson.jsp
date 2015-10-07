<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
</head>
<body>
  <script type="application/javascript">
    //请求json响应json
    function request_json(){
      var user = "name=测试商品&price=99.9";
      $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath }/items/editItemSubmit_RequestJson.action",
        data:user,
        success:function(data){
          alert(data.name + ":" +data.price);
        }
      });
    }

    request_json();
  </script>
</body>
</html>
