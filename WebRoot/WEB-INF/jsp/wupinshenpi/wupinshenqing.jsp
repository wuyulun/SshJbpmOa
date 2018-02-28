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
<div id="wupinshenqing-panel">
	<div class="wupinshenqing-textbox">
    <s:form action="wupinshenpi_tijiao">
    	<div style="display:inline-block;margin-bottom:30px;margin-left:17px;">
            <lable>申请人：</lable>
            <td>${sessionScope.user.name}</td>
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
            <lable>部门：</lable>
            <td><s:textfield name="department" cssClass="easyui-textbox" data-options="required:true" style="width:200px;height:32px;"/> *</td>
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;">
            <lable>申请物品：</lable>
            <td><s:textfield name="muchGoods" cssClass="easyui-textbox" data-options="multiline:true,required:true" style="width:500px;height:120px"/> *</td>
        </div>
        <div style="margin-bottom:30px;float:right;margin-right:250px;">
            <input type="image"  src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);" class="easyui-linkbutton" style="width:100px;height:39px;margin:20px;margin-bottom:55px;color:#FFF;">取消</a>
        </div>
    </s:form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
</body>
</html>

