<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>我要订餐</title>
<link href="${pageContext.request.contextPath}/ht/style/css/cmd.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/metro-blue/easyui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/icon.css" rel="stylesheet" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>

<body>
<div style="float:left;width:40%;height:300px;margin:20px;">
    <div id="woyaodingcan-zaocan" style="height:200px;">
        <div class="woyaodingcan" id="wucan">
        <h1 id="quxiao-wucan">午餐</h1>
        <a id="wucan-anniu" href="<s:url action="dining_cancel"/>" class="easyui-linkbutton" style="width:100px;height:60px;"><span style="font-size:16px;font-weight:bold;">我要下饭牌</span></a>
        </div>
    </div>
</div>
<div style="float:left;width:40%;height:300px;margin:20px;">
    <div id="woyaodingcan-wancan" style="height:200px;">
        <div class="woyaodingcan" id="wancan">
        <h1 id="quxiao-wancan">晚餐</h1>
        <a id="wancan-anniu" href="<s:url action="dining_book"/>" class="easyui-linkbutton" style="width:100px;height:60px;"><span style="font-size:16px;font-weight:bold;">我要报名</span></a>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
</body>
</html>


