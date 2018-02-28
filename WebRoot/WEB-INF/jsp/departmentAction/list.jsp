<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>部门管理</title>
<%@ include file="/WEB-INF/jsp/public/header.jspf" %>
<link href="${pageContext.request.contextPath}/ht/style/css/cmd.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/metro-blue/easyui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/icon.css" rel="stylesheet" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>
<body>
<div class="bumen-header">
<a href="department_addUI.do?parentId=%{ #parent.id }" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="width:80px;color:#FFF;">添加部门</a>
</div>
<table id="table-bumen" >
	<!--显示数据列表-->
        <tbody  datakey="departmentList">
        <s:iterator value="departmentList">
			<tr >
				<td> 
					<s:a action="department_list?parentId=%{id}">${name}</s:a>
				</td>
				<td>${parent.name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
					<s:a action="department_delete?id=%{id}&parentId=%{parent.id}" onclick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')">删除</s:a>
					<s:a action="department_editUI?id=%{id}">修改</s:a>
				</td>
			</tr>
        </s:iterator>
        </tbody>
</table>
            <%-- 当不是顶级部门列表页面时，才需要显示返回上一级的按钮 --%>
            <s:if test="#parent != null"> 
	            <s:a action="department_list?parentId=%{#parent.parent.id}">返回上一级</s:a>
            </s:if>
<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，列表页面只显示一层的（同级的）部门数据，默认显示最顶级的部门列表。<br />
	2，点击部门名称，可以查看此部门相应的下级部门列表。<br />
	3，删除部门时，同时删除此部门的所有下级部门。
</div>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
</body>
</html>

