<%@page import="org.apache.struts2.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@page import="com.returnSystem.model.USER" %>
<%@page import="java.net.URLEncoder"%>
<%
	USER user = (USER)session.getAttribute("user");
	String name = URLEncoder.encode(URLEncoder.encode(user.getKSXM()));
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<%=basePath %>/css/main.css" type="text/css"  charset="utf-8" />
<title>操作成功</title>
</head>
<script type="text/javascript"> 
var t=3;//设定跳转的时间 
setInterval("refer()",1000); //启动1秒定时 
function refer(){  
    if(t==0){ 
        location="Loginsuccess2personal?username=<%=name%>&password=<%=user.getZJHM()%>"; //#设定跳转的链接地址 
    } 
    document.getElementById('show').innerHTML=""+t+"秒后跳转首页"; // 显示倒计时 
    t--; // 计数器递减 
    //本文转自： 
} 
</script> 
<body>
	<div class="content">
    	<div class="head" style="background-image: url('<%=basePath %>images/blue8.jpg');"><span style="font-size:30px">国家政策调整的资格考试吉林省考生确认参加考试系统</span></div>
        <div class="main">
           <div class="center" style="height:350px">
                <div style="margin-left:200px;font-size:40px"> 
           		   <img src="<%=basePath %>images/success.jpg">
                   <a style="margin-left:20px;">信息提交成功!!!!</a>
                </div>
                <span id="show" style="margin-left:450px;padding-top:50px;color:blue"></span> 
        </div>  <!-- main end-->
        <div class="footer"><div style="padding-top:60px;text-align: center;font-size:15px">联系电话：89995708  85611108</div></div>
    </div>
</body>
</html>
