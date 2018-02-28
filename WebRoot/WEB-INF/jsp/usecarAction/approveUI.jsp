<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<title>审批处理</title>
    <%@ include file="/WEB-INF/jsp/public/header.jspf" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
</head>
<body>

<!-- 标题显示 -->

<!--显示表单内容-->
<div id=MainArea>


    <s:form action="usecar_approve">
		<s:hidden name="taskId"></s:hidden>
		<s:hidden name="usecarformId"></s:hidden>

		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 申请信息 </div> 
        	 <tr>
            <td>申请时间：${applytime}&nbsp;</td><br /><td>申请人：${uapplicant.name}&nbsp;</td><br /><td>部门：${ucdepartment}&nbsp;</td><br /><td>起止地点：${place}&nbsp;</td><br /><td>事由：${stuff}&nbsp;</td><br /><td>人数：${people}&nbsp;</td><td>用车时间：${usecartime}&nbsp;</td><br /><td>审批领导：${leader.name}&nbsp;</td><br /><td>领导审批时间：${leadertime}&nbsp;</td><br /><td>状态：${status}&nbsp;</td>
        </tr>
        </div>
	
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 审批信息 </div> 
        </div>
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td>司机信息</td>
                        <td><s:textarea name="carmessage" cssClass="TextareaStyle" cssStyle="width: 500px;"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>
		
		<!-- 表单操作 -->
        <div id="InputDetailBar" style="float:none">
			<!--onclick事件在submit之前触发-->
			<input type="image" src="${pageContext.request.contextPath}/style/blue/images/button/agree.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
		
    </s:form>
</div>
 
<div class="Description">
	说明：<br />
	1，司机信息包括：车辆信息、司机信息；  <br />
</div>



</body>
</html>
	