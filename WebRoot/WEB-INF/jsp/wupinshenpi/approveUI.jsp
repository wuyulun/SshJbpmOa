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


    <s:form action="wupinshenpi_shouli">
		<s:hidden name="taskId"></s:hidden>
		<s:hidden name="goodsformId"></s:hidden>
		<s:hidden name="gapproval" value="true"></s:hidden>

		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 申请信息 </div> 
        	 <tr>
            <td>申请时间：${applytime}&nbsp;</td><br /><td>申请人：${gapplicant.name}&nbsp;</td><br /><td>部门：${department}&nbsp;</td><br /><td>物品：${muchGoods}&nbsp;</td><br /><td>${donetime}&nbsp;</td>
        </tr>
        </div>
	
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 审批信息 </div> 
        </div>
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td>审批意见</td>
                        <td><s:textarea name="comment" cssClass="TextareaStyle" cssStyle="width: 500px;"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>
		
		<!-- 表单操作 -->
        <div id="InputDetailBar" style="float:none">
			<!--onclick事件在submit之前触发-->
			<input type="image" src="${pageContext.request.contextPath}/style/blue/images/button/agree.png"/>
			<input type="image" onclick="document.forms[0].gapproval.value='false'" src="${pageContext.request.contextPath}/style/blue/images/button/disagree.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
		
    </s:form>
</div>
<div class="Description">
	说明：<br />
	1，同意：本次审批通过，流程继续执行。如果所有的环节都通过，则表单的最终状态为：已通过。<br />
	2，不同意：本次审批未通过，流程结束，不再继续执行。表单的最终状态为：未通过。<br />
</div>



</body>
</html>
	