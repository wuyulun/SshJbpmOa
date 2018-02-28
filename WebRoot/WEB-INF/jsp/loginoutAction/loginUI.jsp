<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
    <meta http-equiv=Content-Type content="text/html; charset=gbk" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Itcast OA</title>
	<%@ include file="/WEB-INF/jsp/public/header.jspf" %>
	<script type="text/javascript">
		if( window.parent != window ){
			window.parent.location.href = window.location.href;
		}
	</script>
	<link href="${pageContext.request.contextPath}/ht/style/css/cmd.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/default/easyui.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/icon.css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>

<body style="background-color:#CFEDF5;">

<s:form action="loginout_login">
	        <div class="login-header">
		    	<img src="${pageContext.request.contextPath}/ht/style/images/logo.png" width="275" height="100" style="margin-left:20px;">
		        <span>综合事务管理系统</span>
		    </div>
	        <div class="login">
                    <h1>用户登陆</h1>
                    <div style="margin-top:10px;margin-bottom:40px">
                        <input class="easyui-textbox" name="loginName" style="width:300px;height:40px;padding:12px;" data-options="iconCls:'icon-user',iconAlign:'left',iconWidth:50">
                    </div>
                    <div style="margin-bottom:30px">
                        <input class="easyui-textbox" name="password" type="password" style="width:300px;height:40px;padding:12px;" data-options="iconCls:'icon-password',iconAlign:'left',iconWidth:50">
                    </div>
                    <tr>
                		<td colspan="2">
                			<!-- 显示错误消息 -->
							<div style="color:red"><s:fielderror></s:fielderror></div>
                		</td>
                	</tr>
                    <input type="image" src="${pageContext.request.contextPath}/style/blue/images/login/userLogin_button.png" style="width:200px;height:100px;"/>
                    
            </div>
</s:form>

</body>

</html>


<%-- <!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>登陆</title>
<link href="${pageContext.request.contextPath}/ht/style/css/cmd.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/default/easyui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/icon.css" rel="stylesheet" />

</head>

<body bgcolor="#CFEDF5">        
        
	<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
	
</body>
</html> --%>


	