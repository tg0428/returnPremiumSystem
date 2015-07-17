<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=basePath %>css/main.css" type="text/css"  charset="utf-8" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/hasPhoneOrEmail.js"></script>
<title>考试系统</title>
<script type="text/javascript">
	
	function changeValidateCode(obj) {
		/*** 
		 *   获取当前的时间作为参数，无具体意义    
		 *   每次请求需要一个不同的参数，否则可能会返回同样的验证码     
		 *   这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
		 */
		var timenow = new Date().getTime();

		obj.src = "randPic.action?d=" + timenow;
	}
</script>  
</head>
<body>
	<div class="login">
		<form class="texta" action="Loginlogin" method="post" id="info">
			<div style="margin-bottom: 10px; margin-left: 130px">
			<s:property value="errorMsg" />
				<span id="msg"></span>
			</div>
			<p align="center"><a style="font-size:30px">国家政策调整的资格考试吉林省考生确认参加考试系统</a></p></br>
			<input type="hidden" name="ksmc" id="ksmc" value="" /> <span
				style="margin-right: 45px;">姓</span><span>名:</span><input
				class="inputin" type="text" name="name" id="name" /><br /> <span>身份证号:</span><input
				class="inputin" type="text" name="psw" id="psw" /> <span
				style="margin-right: 3px;">验&nbsp;&nbsp;证&nbsp;&nbsp;码:</span>
			<s:textfield name="code"></s:textfield>
			<img src="randPic.action" onclick="changeValidateCode(this)"
				title="点击图片刷新验证码" />
			<div class="end">
				<a style="text-decoration: none;"><input type="button"
					value="登录" onclick="hasPhoneOrEmail()" />
				</a> <input type="reset" value="重置" />
			</div>
		</form>
</body>
</html>