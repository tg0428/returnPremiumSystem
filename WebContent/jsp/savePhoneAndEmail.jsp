<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ZJHM = request.getParameter("ZJHM");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
<title>信息录入</title>
</head>
<script type="text/javascript">
	
	function savePhoneAndEmail() {
		if (test()) {
			$("#info").submit();
			window.returnValue = 1;
			window.close();
		}
	}
	
	function test() {

		var phone = $("input[name=phone]").val();
		var email = $("input[name=email]").val();
		// 对电子邮件的验证
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!myreg.test(email) && phone.length != 11 ) {
			$("#msg2").text("邮箱格式有误");
			$("#msg1").text("电话格式有误");
			return false;
		}
		if (myreg.test(email) && (phone.length == 11)) {
			$("#msg2").text("正确");
			$("#msg1").text("正确");
			return true;
		}
		if (phone.length == 11 && !myreg.test(email) ) {
			$("#msg1").text("正确");
			$("#msg2").text("邮箱格式有误");
			return false;
		}
		if (phone.length != 11 && myreg.test(email) ) {
			$("#msg2").text("正确");
			$("#msg1").text("电话格式有误");
			return false;
		}
	}
</script>
<body>
<div style="height:40px;text-align:center;margin-top:10px;color:red;font-size:28px;background-color:#87ceeb;">请预留手机号码以及电子邮箱 然后重新登陆</div>
	<form action="LoginsavePhoneAndEmail" id="info" method="post" style="margin-top:20px;text-align: center;">
	    <input type="hidden" name="psw" value="<%=ZJHM %>"/>
		<label>电话:</label><input type="text" name="phone" value="" style="margin-bottom:5px;"/><span id="msg1" style="font-size:13px;color:red;position: absolute;margin-left:5px;"></span><br/>
		<label>邮箱:</label><input type="text" name="email" value=""/><span id="msg2" style="font-size:13px;color:red;position: absolute;margin-left:5px"></span><br/>
		<input type="button" value="提交信息" onclick="savePhoneAndEmail()" style="position: absolute;margin-left:40px;margin-top:10px;"/>
	</form>
</body>
</html>