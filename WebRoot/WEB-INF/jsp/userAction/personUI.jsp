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
<div id="add-user-panel">
	<div class="add-user-textbox">
   <s:form action="user_person">
        <s:hidden name="id"></s:hidden>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:17px;">
          <lable>登录名：</lable>
                        <s:textfield name="loginName" readonly="true" cssClass="easyui-textbox" style="width:200px;height:32px;"/> *
							（登录名要唯一）
	
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
         <lable>密码：</lable>
                        <s:textfield name="password"  cssClass="easyui-textbox" style="width:200px;height:32px;"/> *
                                                         （请更改文本框中加密字符串作为用户登陆密码）
				
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
           <lable>姓名：</lable>
                       <s:textfield name="name" readonly="true" cssClass="easyui-textbox" style="width:200px;height:32px;"/> *
                    
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;">
           <lable>联系电话：</lable>
                        <s:textfield name="phoneNumber" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
                   
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:14px;">
            <lable>E-mail：</lable>
                       <s:textfield name="email" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
                 
        </div>
        <div style="margin-bottom:30px;float:right;margin-right:350px;">
            <input type="image" onclick="return confirm('确认修改密码为${password}?')" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);" class="easyui-linkbutton" style="width:100px;height:39px;margin:20px;margin-bottom:55px;color:#FFF;">取消</a>
        </div>
    </s:form>
    </div>
</div>
<!--说明-->	
<div id="Description"> 
	说明：<br />
	1，密码框中显示为加密数字。<br />
	2，请更改密码框中数字，密码框中数字将作为下一次登陆密码。<br />
	3，不更改请点击取消按钮。
</div>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
</body>
</html>

