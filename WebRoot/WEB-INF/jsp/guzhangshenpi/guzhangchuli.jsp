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
<table id="table-guzhangchuli">

    <tbody>
    <s:iterator value="faultTaskViewslist">
        <tr>
            <td>${faultForm.department}&nbsp;</td><td>${faultForm.applicant.name}&nbsp;</td><td>${faultForm.type}&nbsp;</td><td>${faultForm.brand}&nbsp;</td><td>${faultForm.model}&nbsp;</td><td>${faultForm.description}&nbsp;</td><td>${faultForm.applytime}&nbsp;</td><td><a href="guzhangshenpi_shouli.do?taskId=${task.id}&faultFormId=${faultForm.id}">${faultForm.status}</a></td>
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

