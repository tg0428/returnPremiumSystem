<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
	String ZJHM = request.getParameter("psw");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.print(path+"-------"+basePath);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath %>css/main.css" type="text/css"  charset="UTF-8" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/exam.js"></script>
<script type="text/javascript" src="<%=basePath %>js/loadJson.js"></script>
<title>考试系统</title>
</head>
<body>
    	<div class="content">
    	<div class="head" style="background-image: url('<%=basePath %>images/blue8.jpg');"><span style="font-size:30px">国家政策调整的资格考试吉林省考生确认参加考试系统</span></div>
        <div class="main">
        <div class="infor">
        	<div class="title"><span>个人信息</span><span style="float:right" id="buttonArea"></span></div>
            	<div class="left1">
                	<span class="KSXM">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名 ：<a style="font-size:15px"><s:property value="user.KSXM" /></a></span>
                	<span class="ZJHM" name="psw">身份证号：<a style="font-size:15px"><s:property value="user.ZJHM"/></a></span>
                	<span class="GZDW">工作单位：<a style="font-size:15px"><s:property value="user.GZDW"/></a></span>
                	<span class="KSJB">报考级别：<a style="font-size:15px"><s:property value="user.BKJBMC"/></a></span>
                	<span class="KSLB">报考类别：<a style="font-size:15px"><s:property value="user.KSLB"/></a></span>
                	<span class="KHH"></span>
                	<span class="YHKH"></span>
                </div>
        </div>
		   <div class="sure">
           		<img src="<%=basePath %>/images/notice.jpg"/>
                <p>请确定您的信息正确与否，若确定参加考试请点击确认考试，若放弃参加考试，请点击放弃考试，在点击放弃考试后将会显示您的退费明细，请仔细核对，确认无误后点击确认按钮，进入填写银行信息界面</p>
                <a href="<%=basePath %>login.jsp" style="float:right">退出登录</a>
           </div>
           <div class="center">
           		<div class="topp"><span>报考科目</span><span id="msg" style="color:red;font-size:25px"></span><span style="float:right">科目金额</span>
           		</div>
           		<ul class="ul1">
           		<li>报名费</li>
           		<s:iterator value="list" var="val" status="st"> 
           		<s:if test="%{#val!=null&&#val!=''}">
           		<li>
                	<a id="${st.index+1}" name="KM"><s:property value="#val"/></a>
                	<!-- <input class="btn" type="button" onclick="checkOnSingle_confirm(${st.index+1})" id="${st.index+1}" value="确认考试" name="single" />
                    <input class="btn" type="button" onclick="qiveUpSingle_confirm(${st.index+1})" id="${st.index+1}" value="放弃考试"  name="single"/> -->
                </li>
                </s:if>
                </s:iterator>
                <li>合计</li>
                </ul>
                <ul class="ul2">
                <li><span style="margin-left:250px">13元</span></li>
                <s:iterator value="moneyList" var="val" status="st"> 
           		<s:if test="%{#val!=null&&#val!=''}">
           		<li>
                	<a name="money" style="margin-left:250px"><s:property value="#val"/>元</a>
                </li>
                </s:if>
                </s:iterator>
                <li><span style="margin-left:242px" id="SumMoney"></span></li>
                </ul>
					<div class="bot" style="position:relative;">
						<input style="color: white;" class="btn" type="button" onclick="checkOnAll_confirm()" id="all" value="确认考试" /> 
						<input style="color: white;" class="btn" type="button" onclick="qiveupAll_confirm()" id="all" value="放弃考试" />
					</div>
			</div>
           
        </div>  <!-- main end-->
        <div class="footer"><div style="padding-top:60px;text-align: center;font-size:15px">联系电话：89995708  85611108</div></div>

    </div>
</body>
</html>