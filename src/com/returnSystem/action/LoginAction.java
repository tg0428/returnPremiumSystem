package com.returnSystem.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.poi.util.SystemOutLogger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.returnSystem.dao.userDao;
import com.returnSystem.dao.impl.userImpl;
import com.returnSystem.model.USER;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	private String errorMsg;
	private String name;
	private String psw;
	private String code;
	private String Job;
	private String phone;
	private String email;
	private USER user;
	private String tojsp;
	private ArrayList list;
	private ArrayList moneyList;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList getMoneyList() {
		return moneyList;
	}

	public void setMoneyList(ArrayList moneyList) {
		this.moneyList = moneyList;
	}

	private userDao udao = new userImpl();
	public String getTojsp() {
		return tojsp;
	}

	public void setTojsp(String tojsp) {
		this.tojsp = tojsp;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public USER getUser() {
		return user;
	}

	public void setUser(USER user) {
		this.user = user;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
    public  String codeReturn(){
    	String code = this.getCode();
    	return code;
    }
	public boolean checkCode(String code) throws Exception {
		String sessionCode = (String) (ActionContext.getContext().getSession().get("sessionCode"));

		if (sessionCode.equals(code)) {
			return true;
		} else {
			return false;
		}
	}

	public void CheckOrQiveUp() throws Exception{
		  
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/plain");
		  String ZJHM = URLDecoder.decode(request.getParameter("ZJHM"),"UTF-8");
		  userDao udao = new userImpl();
		  USER user = new USER();
		  List<USER> ulist = (List<USER>) udao.findUser(ZJHM); 
		  List alist = new ArrayList();
		  user = ulist.get(0);
		  for(int i=1;i<=5;i++){
			  	Method m1 = USER.class.getMethod("getKMDM_"+i);
			  	int KMDM = (Integer)m1.invoke(user);
			  	alist.add(KMDM);
		  }
		  int state = ulist.get(0).getState();
		  String time = ulist.get(0).getSCXGSJ();
		  String KHH = ulist.get(0).getKHH();
		  String YHKH = ulist.get(0).getYHKH();
		  alist.add(state);
		  alist.add(time);
		  alist.add(KHH);
		  alist.add(YHKH);
		  String str = JSONArray.fromObject(alist).toString(); 
		  response.getWriter().print(str); 
	 }
	

	public String login() throws Exception {

		boolean flag = udao.findByinfo(psw.trim(), name.trim());
		List<USER> list = (List<USER>) udao.findByZJHM(psw.trim(), name.trim());
		if (flag&&checkCode(this.code)) {

			if(list.get(0).getRole().equals("admin")){
				tojsp = "/jsp/manager.jsp";
			}else{
				this.getExamInfoList(psw.trim(), name.trim());
				Job = user.getGZDW();
				tojsp = "/jsp/personalInformation.jsp";
			}
			return SUCCESS;
		} else {
			if(!checkCode(this.code)&&flag){
				errorMsg = "验证码错误";
				tojsp = "login.jsp";
			}else if(!flag&&checkCode(this.code)){
				errorMsg = "用户信息输入错误";
				tojsp = "login.jsp";
			}else if(!checkCode(this.code)&&!flag){
				errorMsg = "请重新输入";
				tojsp = "login.jsp";
			}
			return ERROR;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void getExamInfoList(String psw,String name) throws IOException{
		
		List<USER> ulist = (List<USER>) udao.findByZJHM(psw.trim(), name.trim());
		ActionContext ac = ActionContext.getContext();
		user = ulist.get(0);
		ac.getSession().put("user",user);
		list = new ArrayList();
		list.add(user.getKM_1());
		list.add(user.getKM_2());
		list.add(user.getKM_3());
		list.add(user.getKM_4());
		list.add(user.getKM_5());
		
		moneyList = new ArrayList();
		moneyList.add(user.getFYKM_1());
		moneyList.add(user.getFYKM_2());
		moneyList.add(user.getFYKM_3());
		moneyList.add(user.getFYKM_4());
		moneyList.add(user.getFYKM_5());
		
	}
	
	public void getReturnJE() throws Exception{
		
		String ZJHM = URLDecoder.decode(request.getParameter("ZJHM"),"UTF-8");
		String KSXM = URLDecoder.decode(request.getParameter("KSXM"),"UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		List<USER> ulist = (List<USER>) udao.findByZJHM(ZJHM.trim(),KSXM.trim());
		List alist = new ArrayList();
		user = ulist.get(0);
		alist.add(user.getJE());
		alist.add(user.getFYKM_1());
		alist.add(user.getFYKM_2());
		alist.add(user.getFYKM_3());
		alist.add(user.getFYKM_4());
		alist.add(user.getFYKM_5());
		String str = JSONArray.fromObject(alist).toString(); 
		response.getWriter().print(str);
	}
	
	public void checkExam() throws Exception{
		@SuppressWarnings("deprecation")
		String checkId = request.getParameter("id");
		String ZJHM = URLDecoder.decode(request.getParameter("ZJHM"),"UTF-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		userDao udao = new userImpl();
		USER user = new USER();
		List<USER> ulist = (List<USER>) udao.findUser(ZJHM);
		user = ulist.get(0);
		int moneyBefore = user.getJE(); 
		Method m1 = USER.class.getMethod("getFYKM_"+checkId);
		Method m2 = USER.class.getMethod("getKMDM_"+checkId);
		int checkMoney = (Integer) m1.invoke(user); 
		int stat = (Integer) m2.invoke(user);//̬
		if(stat == 3){ 
				String Sql ="update user set KMDM_"+checkId+"=1,state=1,SCXGSJ='"+time+"' where ZJHM='"+ZJHM+"'";
				udao.checkExam(Sql);
		}
		
	}
	
	public void  qiveupExam() throws Exception{
			
			userDao udao = new userImpl();
			String checkId = request.getParameter("id");
			String ZJHM = URLDecoder.decode(request.getParameter("ZJHM"),"UTF-8");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			List<USER> ulist = (List<USER>) udao.findUser(ZJHM);
			user = ulist.get(0);
			int moneyBefore = user.getJE();
			Method m2 = USER.class.getMethod("getKMDM_"+checkId);
			int stat = (Integer) m2.invoke(user);//̬
			int fina = ulist.get(0).getZFY();
			if(stat == 3){
				String Sql ="update user set KMDM_"+checkId+"=2 , state=4 , JE="+fina+",SCXGSJ='"+time+"' where ZJHM='"+ZJHM+"'";
				udao.checkExam(Sql);
			}
		}
	
	public void hasPhoneOrEmail() throws Exception{
		
		String username = URLDecoder.decode(request.getParameter("name"),"UTF-8");
		String password = URLDecoder.decode(request.getParameter("psw"),"UTF-8");
		String code = URLDecoder.decode(request.getParameter("code"),"UTF-8");
		boolean flag = udao.findByinfo(password.trim(), username.trim());
		String codeFlag = this.checkCode(code)==true?"true":"false";
		ArrayList list = new ArrayList();
		if(flag){
			List<USER> ulist = (List<USER>) udao.findByZJHM(password.trim(), username.trim());
			user = ulist.get(0);
			String phone = user.getDH(); 
			String email = user.getYX();
			if(phone==null||email==null||phone.equals("")||email.equals("")){
				list.add("yesUser");
				list.add("empty");
				list.add(codeFlag);
				response.setContentType("text/html;charset=UTF-8");
				String str = JSONArray.fromObject(list).toString(); 
				response.getWriter().print(str); 
			}else{
				list.add("yesUser");
				list.add("unEmpty");
				list.add(codeFlag);
				response.setContentType("text/html;charset=UTF-8");
				String str = JSONArray.fromObject(list).toString(); 
				response.getWriter().print(str); 
			}
		}else{
			list.add("noUser");
			list.add("noCheck");
			list.add(codeFlag);
			System.out.println("用户不存在");
			response.setContentType("text/html;charset=UTF-8");
			String str = JSONArray.fromObject(list).toString(); 
			response.getWriter().print(str); 
		}
	}
	
	public String savePhoneAndEmail() throws Exception{
		
		String sql = ("update user set DH = '"+phone.trim()+"', YX = '" +email.trim()+"' where ZJHM ='"+ psw.trim()+"'");
		udao.update(sql);
		tojsp="/login.jsp";
		return SUCCESS;
	}
	
	public String success2personal() throws Exception{
		
		String username = URLDecoder.decode(request.getParameter("username"));
		String password = URLDecoder.decode(request.getParameter("password"));
		this.getExamInfoList(password.trim(), username.trim());
		System.out.println(username+password);
		List<USER> ulist = (List<USER>) udao.findByZJHM(password.trim(), username.trim());
		user = ulist.get(0);
		tojsp = "personalInformation.jsp";
		return "success";
	}
}
