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
   <s:form action="user_%{id == null ? 'add' : 'edit'}">
        <s:hidden name="id"></s:hidden>
    	<div style="float:left;width:700px;margin-bottom:30px;">
        	 <lable>所属部门：</lable>
                      
                        	<s:select name="departmentId" cssClass="easyui-combobox" data-options="editable:false" style="width:200px;height:32px;"
                        		list="departmentList" listKey="id" listValue="name"
                        		headerKey="" headerValue="==请选择部门=="
                        	/>

        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:17px;">
          <lable>登录名：</lable>
							<s:textfield name="loginName" cssClass="easyui-textbox" data-options="required:true" style="width:200px;height:32px;"/> *
							（登录名要唯一）

        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
           <lable>姓名：</lable>
                        <s:textfield name="name" cssClass="easyui-textbox" data-options="required:true" style="width:200px;height:32px;"/> *
                   
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
            <lable>性别：</lable>
                        
                        	<%--
                        	<s:radio name="gender" list="%{    #{'男':'男', '女':'女'}    }"></s:radio>
                        	 --%>
                        	<s:radio name="gender" list="%{    {'男', '女'}    }"></s:radio>
						
                    
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;">
            <lable>联系电话：</lable>
                       <s:textfield name="phoneNumber" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
                    
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:14px;">
            <lable>E-mail：</lable>
                        <s:textfield name="email" cssClass="easyui-textbox" style="width:200px;height:32px;"/>
                   
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
           <lable>备注：</lable>
                     <s:textarea name="description" cssClass="easyui-textbox" data-options="multiline:true" style="width:500px;height:120px"></s:textarea>
                   
        </div>
        <div style="float:left;width:700px;margin-bottom:30px;margin-left:34px;">
        	<lable>岗位：</lable>
        	
                        	<s:select name="roleIds" cssClass="SelectStyle"
                        		multiple="false" size="10" 
                        		list="roleList" listKey="id" listValue="name"
                        	/>
                       
        </div>
        <div style="margin-bottom:30px;float:right;margin-right:350px;">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);" class="easyui-linkbutton" style="width:100px;height:39px;margin:20px;margin-bottom:55px;color:#FFF;">取消</a>
        </div>
    </s:form>
    </div>
</div>
<div class="Description">
	说明：<br />
	1，用户的登录名要唯一，在填写时要同时检测是否可用。<br />
	2，新建用户后，密码被初始化为"1234"。<br />
	3，密码在数据库中存储的是MD5摘要（不是存储明文密码）。<br />
	4，用户登录系统后可以使用“个人设置→修改密码”功能修改密码。<br />
	5，新建用户后，会自动指定默认的头像。用户可以使用“个人设置→个人信息”功能修改自已的头像<br />
	6，修改用户信息时，登录名不可修改。
</div>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ht/style/js/cmd.js" type="text/javascript"></script>
</body>
</html>

