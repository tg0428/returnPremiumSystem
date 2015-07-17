package com.returnSystem.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.returnSystem.dao.userDao;
import com.returnSystem.dao.impl.userImpl;
import com.returnSystem.model.USER;

public class SearchAction extends ActionSupport{

	/**
	 * 
	 */
	HttpServletResponse response = ServletActionContext.getResponse();
	private static final long serialVersionUID = 1L;
	
	private String KSXM;
	private String ZJHM;
	private ArrayList<?> list;
	
	public String getKSXM() {
		return KSXM;
	}
	public void setKSXM(String kSXM) {
		KSXM = kSXM;
	}
	public String getZJHM() {
		return ZJHM;
	}
	public void setZJHM(String zJHM) {
		ZJHM = zJHM;
	}
	public void setList(ArrayList<?> list) {
		this.list = list;
	}
	public ArrayList<?> getList() {
		return list;
	}
	
	public void search() throws Exception{
		userDao udao = new userImpl();
		list = (ArrayList<USER>)udao.search(KSXM, ZJHM);
		String str = JSONArray.fromObject(list).toString(); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		response.getWriter().print(str); 
	}
	
	public void resetInfo() throws Exception{
		
		String sql = "update user set ";
		userDao udao = new userImpl();
		USER user = (USER) udao.findUser(ZJHM).get(0);
		for(int i=1;i<=5;i++){
		  	Method m1 = USER.class.getMethod("getKMDM_"+i);
		  	int KMDM = (Integer)m1.invoke(user);
		  	if(KMDM!=0){
		  		sql += ("KMDM_"+i+"=3, ");
		  	}
		}
		sql += ("KHH=null,YHKH=null,JE=null,state=3,SCXGSJ=null,DH=null,YX=null where ZJHM='"+ZJHM+"'");
		System.out.println(sql);
		udao.update(sql);
	}
}
