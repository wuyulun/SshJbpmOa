<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加车辆</title>
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
<div id="add-cheliang-panel">
	<div class="add-cheliang-textbox">
    <s:form action="Car_addCar">
        <div style="float:left;margin-left:32px;width:700px;margin-bottom:50px;">
            <lable>品牌：</lable>
            <s:textfield name="brand" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-left:32px;margin-bottom:50px;">
            <lable>座位：</lable>
            <s:textfield name="seat" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-left:16px;margin-bottom:50px;">
            <lable>车牌号：</lable>
            <s:textfield name="number" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-bottom:50px;">
            <lable>采购时间：</lable>
            <s:textfield name="buytime" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="margin-bottom:30px;float:right;margin-right:250px;">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);" class="easyui-linkbutton" style="width:100px;height:39px;margin:20px;margin-bottom:55px;">取消</a>
        </div>
    </s:form>
    </div>
</div>


</body>
</html>
