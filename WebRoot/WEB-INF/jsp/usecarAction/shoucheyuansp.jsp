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
<table id="table-yongcheshenpi-paicheyuan">

    <tbody>
       <s:iterator value="usecarformTaskViewslist">
        <tr>
         <td>${usecarform.uapplicant.name}&nbsp;</td><td>${usecarform.applytime}&nbsp;</td><td>${usecarform.ucdepartment}&nbsp;</td><td>${usecarform.place}&nbsp;</td><td>${usecarform.people}&nbsp;</td><td>${usecarform.stuff}&nbsp;</td><td>${usecarform.usecartime}&nbsp;</td><td>${usecarform.status}&nbsp;</td><td><a href="usecar_approveUI.do?taskId=${task.id}&usecarformId=${usecarform.id}">同意</a></td>
        
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

