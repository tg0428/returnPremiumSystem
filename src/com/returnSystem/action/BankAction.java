package com.returnSystem.action;

import com.opensymphony.xwork2.ActionSupport;
import com.returnSystem.dao.userDao;
import com.returnSystem.dao.impl.userImpl;

public class BankAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String YHKH; //银行卡号
	private String KHH;	 //开户行
	private String ZJHM; //身份证号
	public String getZJHM() {
		return ZJHM;
	}
	public void setZJHM(String zJHM) {
		ZJHM = zJHM;
	}

	private String tojsp;
	
	public String getTojsp() {
		return tojsp;
	}
	public void setTojsp(String tojsp) {
		this.tojsp = tojsp;
	}
	public String getYHKH() {
		return YHKH;
	}
	public void setYHKH(String yHKH) {
		YHKH = yHKH;
	}
	public String getKHH() {
		return KHH;
	}
	public void setKHH(String kHH) {
		KHH = kHH;
	}
	
	public String saveInfo() throws Exception{
		
		tojsp = "return.jsp";
		userDao udao = new userImpl();
		String sql = "update user set KHH = '"+KHH+"', YHKH = '" +YHKH+"', state = 2 where ZJHM ='"+ ZJHM+"'";
		udao.update(sql);
		tojsp = "success.jsp";
		return SUCCESS;
	}
}
