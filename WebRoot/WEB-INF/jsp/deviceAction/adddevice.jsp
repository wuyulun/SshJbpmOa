<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加设备</title>
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
<div id="add-shebei-panel">
	<div class="add-shebei-textbox">
    <s:form action="Device_addDevice">
        <div style="float:left;width:700px;margin-bottom:30px;margin-right:50px">
            <lable>设备类型：</lable>
            <%-- <select id="add-shebei" name="shebeileixing" style="width:150px;height:32px">
            <option value="aa">台式电脑</option>
            <option>打印机</option>
            <option>笔记本电脑</option>
            </select> --%>
            <!-- <input type="text" name="device.type" class="easyui-textbox" style="width:100px;height:32px;"> -->
            <s:textfield name="type" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-bottom:50px;margin-left:31px;">
            <lable>品牌：</lable>
            <!-- <input type="text" name="device.brand" class="easyui-textbox" style="width:100px;height:32px;"> -->
            <s:textfield name="brand" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-left:31px;margin-bottom:50px;">
            <lable>型号：</lable>
            <!-- <input type="text" name="device.model" class="easyui-textbox" style="width:200px;height:32px;"> -->
            <s:textfield name="model" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-left:31px;margin-bottom:30px;">
            <lable>参数：</lable>
            <!-- <input class="easyui-textbox" name="device.parameter" style="width:200px;height:32px;"> -->
            <s:textfield name="parameter" cssClass="easyui-textbox" data-options="multiline:true" style="width:500px;height:120px;"/>
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;">
        	<lable>所在科室：</lable>
        	<%-- <select id="shebei-bumen" class="easyui-combobox" name="shebei-bumen" style="width:100px;height:32px;">
                <option>政工科</option>
                <option>公诉科</option>
                <option>侦查监督科</option>
                <option>民行科</option>
                <option>政治部</option>
                <option>控申科</option>
            </select> --%>
            <!-- <input class="easyui-textbox" name="device.department" style="width:100px;height:32px;"> -->
            <s:textfield name="department" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-bottom:50px;margin-left:16px;">
            <lable>负责人：</lable>
            <!-- <input type="text" name="device.possessor" class="easyui-textbox" style="width:100px;height:32px;"> -->
            <s:textfield name="possessor" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="float:left;width:700px;margin-bottom:50px;">
            <lable>采购时间：</lable>
            <!-- <input type="text" name="device.buytime" class="easyui-datebox" style="width:100p;height:32px;"> -->
            <s:textfield name="buytime" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
        </div>
        <div style="margin-bottom:30px;float:right;margin-right:250px;">
            <%-- <a href="<s:url action="guzhangshenpi_addDevice"/>" class="easyui-linkbutton" style="width:100px;height:40px;margin:20px">提交</a> --%>
            <!-- <a href="javascript:document.device.submit();" class="easyui-linkbutton" style="width:100px;height:40px;margin:20px">提交</a>
            <a href="###" class="easyui-linkbutton" style="width:100px;height:40px;margin:20px">取消</a> -->
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);" class="easyui-linkbutton" style="width:100px;height:39px;margin:20px;margin-bottom:55px;color:#FFF;">取消</a>
        </div>
    </s:form>
    </div>
</div>


</body>
</html>