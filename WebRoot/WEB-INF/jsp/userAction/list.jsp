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
<div class="user-header"><!--  
<a href="<s:url action="department_delete?id=%{id}&parentId=%{parent.id}"/>" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>-->
<a href="user_addUI.do" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="width:80px;color:#FFF;">用户添加</a>
</div>
<table id="table-user">
	
    <tbody>
    <s:iterator value="userList">
        <tr>
            <td>${loginName}&nbsp;</td><td>${name}&nbsp;</td><td>${department.name}&nbsp;</td><td><s:iterator value="roles">
                		${name}
                	</s:iterator>&nbsp;</td><td>${description}&nbsp;</td><td><s:a action="user_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
					<s:a action="user_editUI?id=%{id}">修改</s:a>
					<s:a action="user_initPassword?id=%{id}" onclick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</s:a></td>
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

