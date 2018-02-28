<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>车辆信息</title>
<link href="${pageContext.request.contextPath}/ht/style/css/cmd.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/metro-blue/easyui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/icon.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>

<body>
<div>
<a href="<s:url action="Car_addCarUI"/>" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="width:80px">添加车辆</a>
</div>
<table id="table-cheliangxinxi">

    <tbody>
    
	<s:iterator value="carInfo">
    
        <tr>
            <td>${brand }</td>
            <td>${seat }</td>
            <td>${number }</td>
            <td>${buytime }</td>
            <td><a href="<s:url action="Car_editCarUI?id=%{id}"/>">修改</a>&nbsp;&nbsp;<a href="<s:url action="Car_deleteCar?id=%{id}"/>"">删除</a></td>
        </tr>
        
	</s:iterator>
        
	</tbody>
</table>

</body>
</html>
