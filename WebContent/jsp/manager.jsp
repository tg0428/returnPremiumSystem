<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<% 
	String ks1 = URLEncoder.encode("外销员从业资格考试");
	String ks2 = URLEncoder.encode("国际商务师执业资格考试");
	String ks3 = URLEncoder.encode("企业法律顾问执业资格考试");
	String ks4 = URLEncoder.encode("全国房地产经纪人考试");
	String ks5 = URLEncoder.encode("注册资产评估师执业资格考试");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/main.css" type="text/css"  charset="UTF-8" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/manager.js"></script>
<script type="text/javascript" src="<%=basePath %>js/enPage.js"></script>
<title>退费系统</title>
<style type="text/css">
a{
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="content">
    	<div class="head" style="background-image: url('<%=basePath %>images/blue8.jpg');"><span style="font-size:30px">国家政策调整的资格考试吉林省考生确认参加考试系统</span></div>
        <div class="main" style="height:500px;border:1px solid black;margin-top:2px">
        	<div style="margin:20px 20px 20px 20px;padding-left:100px;">
		        	<label style="float:left;margin-right:20px">搜索考生信息</label>
		        	<form id="searchInfo" >
		        	考生姓名: <input type="text" name="KSXM"/>&nbsp;&nbsp;&nbsp; 证件号码: <input type="text" name="ZJHM"/>&nbsp;&nbsp;&nbsp;<input type="button" value="搜索" onclick="search()"/>
		        	</form>
	        		<div id="page" style="overflow-y:auto;height:130px;position:relative;width:800px;margin-top:5px">
		        		<table  id="table" style="border:1px solid #87ceeb;">
		        		<tr style="background-color:#87ceeb;">
		        			<td width=200>考生姓名</td>
		        			<td width=500>证件号码</td>
		        			<td width=80>操作</td>
		        		</tr>
		        		</table>
		        	</div>
        	</div>
        	<div id="load" style="top:210px;position:absolute;text-align:center;margin-left:450px;width:150px;height:20px;background-color:red;color:white;display:none;">搜索中....</div>
	        <div class="bot" style="left:270px;top:320px;position:absolute;">
	        		<div style="background-color:#87ceeb">下载考试信息表</div>
			        <form action="" id="download">
			        	<input type="hidden" id="KSLB" name="KSLB" value=""/>
			        </form>
	        		<span style="margin-right:133px">外销员从业资格考试</span>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载参加考试考生名单" onclick="dCheck('<%=ks1%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载放弃考试考生名单" onclick="qCheck('<%=ks1%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载未操作考生名单" onclick="nCheck('<%=ks1%>')"/><br/>
					
					<span style="margin-right:101px">国际商务师执业资格考试</span>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载参加考试考生名单" onclick="dCheck('<%=ks2%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载放弃考试考生名单" onclick="qCheck('<%=ks2%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载未操作考生名单" onclick="nCheck('<%=ks2%>')"/><br/>
					
					<span style="margin-right:85px">企业法律顾问执业资格考试</span>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载参加考试考生名单" onclick="dCheck('<%=ks3%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载放弃考试考生名单" onclick="qCheck('<%=ks3%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载未操作考生名单" onclick="nCheck('<%=ks3%>')"/><br/>
					
					<span style="margin-right:117px">全国房地产经纪人考试</span>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载参加考试考生名单" onclick="dCheck('<%=ks4%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载放弃考试考生名单" onclick="qCheck('<%=ks4%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载未操作考生名单" onclick="nCheck('<%=ks4%>')"/><br/>
					
					<span style="margin-right:70px">注册资产评估师执业资格考试</span>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载参加考试考生名单" onclick="dCheck('<%=ks5%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载放弃考试考生名单" onclick="qCheck('<%=ks5%>')"/>
					<input style="font-size:15px;color: black;margin-top:5px"  type="button" value="下载未操作考生名单" onclick="nCheck('<%=ks5%>')"/><br/>
			</div>
		</div>
		<div class="footer"><div style="padding-top:60px;text-align: center;font-size:15px">联系电话：89995708  85611108</div></div>
	</div>
</body>
</html>