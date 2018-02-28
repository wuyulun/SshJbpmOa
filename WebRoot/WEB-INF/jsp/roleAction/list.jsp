<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>岗位管理</title>
<link href="${pageContext.request.contextPath}/ht/style/css/cmd.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/metro-blue/easyui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/icon.css" rel="stylesheet" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>
<body>
<div class="gangwei-header">
<a href="role_addUI.do" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="width:80px">添加岗位</a>
</div>
<table id="table-gangwei">

		<!--显示数据列表-->
        <tbody >
            
		<s:iterator value="roleList">
			<tr >
	<td>${name}&nbsp;</td><td>${description}&nbsp;</td><td><s:a action="role_editUI?id=%{id}">修改</s:a><s:a action="role_delete?id=%{id}" style="margin:0 10px;" onclick="return confirm('确定要删除吗？')">删除</s:a><s:a action="role_setPrivilegeUI?id=%{id}">设置权限</s:a></td>
			</tr>
		</s:iterator>	
			
        </tbody>
    </table>

<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
</body>
</html>

