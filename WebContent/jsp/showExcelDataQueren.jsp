<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.returnSystem.model.USER,java.util.*,
java.lang.reflect.Method,com.returnSystem.dao.userDao,com.returnSystem.dao.impl.userImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试信息</title>
<style type="text/css" media="print">
.noprint { display:none;}
</style>
<script type="text/javascript">
	function dayin(){
		
		window.print();
	}
</script>
</head>
<body>
<% 
String ZJHM = request.getParameter("ZJHM");
userDao udao = new userImpl();
List<USER> list = (List<USER>) udao.findUser(ZJHM);
String[] params = new String[]{"考生姓名","身份证号","工作单位","报考类别","考试级别","考试专业"};
String[] value = new String[]{list.get(0).getKSXM(),list.get(0).getZJHM(),list.get(0).getGZDW(),
		list.get(0).getKSLB()==null?"":list.get(0).getKSLB(),
				list.get(0).getBKJBMC()==null?"":list.get(0).getBKJBMC(),
						list.get(0).getBKZYMC()==null?"":list.get(0).getBKZYMC()};

%> 
<button onclick="dayin()" class="noprint">打印</button>
<table border="1" cellspacing="0" style="border: thin;width:793.8px;height:1122.66px">
	<tr>
		<td colspan="9"  align="center" style="font-size:28px;font-family:黑体">考生参加考试确认单</td>
	</tr>
	<%
	for(int i = 0;i<value.length;i++){
	%>
	<tr>
		<td  align="center"><%=params[i] %></td>
		<td colspan="8" align="center"><%=value[i] %></td>
	</tr>
	<%} %>
	<tr>
		<td   align="center">报考明细</td>
		<td   align="center">报名费</td>
		<%
		for(int i=0;i<5;i++){
			Method m1 = USER.class.getMethod("getKM_"+(i+1));
			String ksName = (String) m1.invoke(list.get(0))==null?"":(String) m1.invoke(list.get(0)); 
			if(!ksName.equals("")){
				%>
				<td   align="center"><%=ksName %></td>
				<%
			}
		}
		%>
		<td  colspan="2" align="center">合计</td>
	</tr>
	<tr>
		<td   align="center">金额（元）</td>
		<td   align="center"><%=(Integer)USER.class.getMethod("getBMFY").invoke(list.get(0)) %></td>
		<%
		int sum = 0;
		for(int i=0;i<5;i++){
			
			Method m1 = USER.class.getMethod("getFYKM_"+(i+1));
			int FY = (Integer) m1.invoke(list.get(0));  
			if(FY!=0){
				%>
				<td   align="center"><%=FY %></td>
				<%
			}
			sum +=FY;
		}
		sum +=(Integer)USER.class.getMethod("getBMFY").invoke(list.get(0));
		%>
		<td colspan="2"  align="center"><%=sum%></td>
	</tr>
	<tr>
		<td colspan="9" align="center">我确认参加考试。    &nbsp; &nbsp; &nbsp;<br>&nbsp; &nbsp; &nbsp;申请人签名：<br>&nbsp; &nbsp; &nbsp;2015年  &nbsp; &nbsp;月    &nbsp; &nbsp; 日 </td>
	</tr>
</table>
</body>
</html>