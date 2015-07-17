<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	String KSXM = java.net.URLDecoder.decode(request.getParameter("KSXM"),"UTF-8");
	String ZJHM = java.net.URLDecoder.decode(request.getParameter("ZJHM"),"UTF-8");
	String GZDW = java.net.URLDecoder.decode(request.getParameter("GZDW"),"UTF-8");
	String KSJB = java.net.URLDecoder.decode(request.getParameter("KSJB"),"UTF-8");
	String KSLB = java.net.URLDecoder.decode(request.getParameter("KSLB"),"UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考试系统</title>
<link rel="stylesheet" href="<%=basePath %>css/main.css" type="text/css"  charset="utf-8" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath %>js/showInfo.js"></script>
</head>
<body>
<div class="content">
    	<div class="head" style="background-image: url('<%=basePath %>images/blue8.jpg');"><span style="font-size:30px">国家政策调整的资格考试吉林省考生确认参加考试系统</span></div>
        <div class="main">
        	<!--<img class="photo" src="images/black_cat.jpg"  />-->
            <div class="infor">
            <div class="title"><span>个人信息</span></div>
            	<div class="left1">
                	<span class="KSXM">姓名：<a style="font-size:16px"><%=KSXM%></a></span>
                	<span class="ZJHM">身份证号：<a style="font-size:16px"><%=ZJHM%></a></span>
                	<span class="GZDW">工作单位：<a style="font-size:16px"><%=GZDW%></a></span>
                	<span class="KSJB">报考级别：<a style="font-size:16px"><%=KSJB%></a></span>
                	<span class="KSLB">报考类别：<a style="font-size:16px"><%=KSLB%></a></span>
                </div>
        </div>
		   <div class="sure">
           		<img src="<%=basePath %>images/notice.jpg"  />
                <p>您已放弃参加考试,请认真填写下面所需的银行卡号,以及您的开户行,确认填写的银行信息无误后，点击提交按钮，提交您的信息	</p>
           </div>
           <div class="center">
           		<div class="topp" style="text-align: center;padding-left:10px"><a>请认真填写以下信息，确认无误请提交</a></div>
           		<div style="text-align: center">
	                <form action="BanksaveInfo" method="post" id="bankInfo">
	                	<input value="<%=request.getParameter("ZJHM")%>" type="hidden" name="ZJHM"/>
	                	<li style="border: none">持卡人姓名：<input class="inputin" type="text" name="KSXM" disabled='disabled' value="<%=KSXM%>" style="margin-right:24px"/></li>
	                   	<li style="border: none">银行卡号：<input class="inputin" type="text" name="YHKH"/><span id="msg1"></span></li>
	                    <li style="border: none">开户银行：<input class="inputin" type="text" name="KHH"/><span id="msg2"></span></li><a href="http://jingyan.baidu.com/article/fea4511a474e15f7bb9125c8.html" target="_black">了解查询开户行的方法</a>
	                    <div class="bot" >
		                	<input  style="float:right; margin-right:423px;"  type="reset" value="重置"/>
		                	<input  style="float:right; margin-right:10px;"   type="button" onclick="show()" id="opener" value="提交"/>
	                    </div>
	                </form>
                </div>
			</div>
        </div>  <!-- main end-->
        <div class="footer"><div style="padding-top:60px;text-align: center;font-size:15px">联系电话：89995708  85611108</div></div>

    </div>
</body>
</html>