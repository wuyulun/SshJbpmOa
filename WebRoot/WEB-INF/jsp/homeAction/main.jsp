<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>惠阳人民检察院综合事务管理系统</title>
<link href="${pageContext.request.contextPath}/ht/style/css/cmd.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/metro-blue/easyui.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/ht/style/js/easyui/themes/icon.css" rel="stylesheet" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>

<body class="easyui-layout">
	<!-- 顶部 -->
	<div data-options="region:'north',border:false" style="height:80px;background:#CFEDF5;padding:10px">
   		<img src="${pageContext.request.contextPath}/ht/style/images/logo.png" width="200" height="70" style="float:left;">
   		<h1 style="float:left; margin-left:20px;">综合事务管理系统</h1>
        <div class="user-message">
        	<span>您好，<a href="user_personUI.do?id=${user.id}"><img border="0" width="13" height="14" src="style/images/top/user_setup.gif" /><b>${user.name}</b></a></span>&nbsp;
        	<a href="loginout_logout.do" target="_parent" id="logout">退出</a>
        </div>
        <%-- <div id="Head1Right_UserSetup">
            	<a href="user_personUI.do?id=${user.id}">
					<img border="0" width="13" height="14" src="style/images/top/user_setup.gif" /> 个人设置
				</a>
			</div>
        <div class="message">
            <span>消息</span>
            <span>待办事项</span> --%>
        </div>
    </div>
    <!-- //顶部 -->
    
    <!-- 左侧导航栏 -->
	<div data-options="region:'west',title:'导航菜单'" style="width:200px;" id="west">
    	<div id="west-nav" style="height:auto;">
    	<%-- 一级菜单 --%>
		<s:iterator value="#application.topPrivilegeList">
		<s:if test=" #session.user.hasPrivilegeByName(name) ">
		<div title="${name}" data-options="iconCls:'${icon}'">
           		<ul>
	            	<%-- 二级菜单 --%>
	            	<s:iterator value="children">
	      		 	<s:if test=" #session.user.hasPrivilegeByName(name) ">
	      		 	 	<li><a  target="mainFrame" href="${pageContext.request.contextPath}${url}.do" ><span class="${icon}">&nbsp;&nbsp;&nbsp;&nbsp;</span>${name}</a></li> 
	                </s:if>
	            	</s:iterator>
	            </ul>
	     </div>
        </s:if>
		</s:iterator>
        </div>
    </div>
    <!-- //左侧导航栏 -->
    
    <!-- 中间内容 -->
    <div id="mainPanle" data-options="region:'center'" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="首页" style="padding:20px;overflow:hidden;" id="home">
				
			<h1>欢迎使用惠阳人民检察院综合事务管理系统！</h1>

			</div>
		</div>
    </div>
    <!-- //中间内容 -->
    
    <!-- 底部 -->
    <div data-options="region:'south'" style="height:50px;" id="footer">
    	
	</div>
    </div>
    <!-- //底部 -->
    <div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
    
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
</body>
</html>


