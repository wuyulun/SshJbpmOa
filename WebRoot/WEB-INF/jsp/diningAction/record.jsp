<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用餐记录</title>
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
<table id="table-yongcanjilu">

    <tbody>
    
    <s:iterator value="dayList">
    
        <tr>
            <td>&nbsp;${day}&nbsp;</td>
            <td><s:a action="dining_recordAmList?date=%{day}">中餐</s:a>&nbsp;<s:a action="dining_recordPmList?date=%{day}">晚餐</s:a></td>
        </tr>
        
    </s:iterator>
    
    </tbody>    
</table>
</body>
</html>
