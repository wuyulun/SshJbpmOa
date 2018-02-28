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
<div id="yongcheshenqing-panel">
	<div class="yongcheshenqing-textbox">
    <s:form action="usecar_tijiao">
    	<div style="float:left;width:700px;margin-bottom:30px;margin-left:17px;">
            <lable style="margin-right:10px">申请人:</lable>
           <td>${sessionScope.user.name}</td>
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
            <lable>部门：</lable>
            <td><s:textfield name="ucdepartment" cssClass="easyui-textbox" data-options="required:true" style="width:200px;height:32px;"/> *</td>
        </div>
        <div style="width:700px;float:left;margin-bottom:30px;">
            <lable>起止地点：</lable>
            <td><s:textfield name="place" cssClass="easyui-textbox" data-options="required:true" style="width:200px;height:32px;"/> *</td>
        </div>
        <div style="width:700px;float:left;margin-bottom:50px;">
            <lable>用车时间：</lable>
             <td><s:textfield name="usecartime" cssClass="easyui-textbox" data-options="required:true" style="width:200px;height:32px;"/> *</td>
        </div>
        <div style="float:left;width:700px;margin-bottom:50px;margin-left:34px;">
            <lable style="margin-right:10px">人数:</lable>
             <td><s:textfield name="people" cssClass="easyui-textbox" data-options="required:true" style="width:200px;height:32px;"/> *</td>
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
            <lable>事由：</lable>
             <td><s:textfield name="stuff" cssClass="easyui-textbox" data-options="multiline:true" style="width:500px;height:120px"/> *
        </div>
        <div style="width:700px;margin-bottom:30px;float:left;margin-left:200px;">
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

