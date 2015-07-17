package com.returnSystem.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.returnSystem.dao.userDao;
import com.returnSystem.dao.impl.userImpl;
import com.returnSystem.model.USER;
import com.returnSystem.utils.BuildExcel;

public class ExportExcelAction extends ActionSupport {

	/**
	 * 
	 */
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	private static final long serialVersionUID = 1L;
	private userDao udao = new userImpl();
	InputStream excelStream;
	String fileName;
	
	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getFileName() throws UnsupportedEncodingException {
		return fileName;
	}

	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public String ExportPersonalCheckOnExcel() throws Exception {
		
		String ZJHM = URLDecoder.decode(request.getParameter("ZJHM"),"UTF-8");
		BuildExcel build = new BuildExcel();
		List<USER> list = (List<USER>) udao.findUser(ZJHM);
		String signContent = "����ȷ���μ����п��ԣ���ȷ����Ϣ���      ȷ�����ˣ�  ";
		HSSFWorkbook wb = build.BuildSpecial("��������ȷ�ϵ�", list,signContent);
		this.workbook2InputStream(wb, ZJHM);
		return "success";
	}
	

	public String ExportPersonalQiveUpExcel() throws Exception {

		String ZJHM = URLDecoder.decode(request.getParameter("ZJHM"), "UTF-8");
		BuildExcel build = new BuildExcel();
		List<USER> list = (List<USER>) udao.findUser(ZJHM);
		String signContent = "���ѷ������п��ԣ���ȷ����Ϣ��ϣ��������˷�                               �����ˣ�  ";
		HSSFWorkbook wb = build.BuildSpecial("���������˷ѵ�", list, signContent);
		this.workbook2InputStream(wb, ZJHM);
		return "success";
	}

	public String ExportQiveUpPersonalExcel() throws Exception {
		
		String KSLB = URLDecoder.decode(request.getParameter("KSLB"));
		String sql = "select * from user where state=2 and KSLB='"+KSLB+"'";
		BuildExcel build = new BuildExcel();
		List<USER> list = (List<USER>) udao.findRequireUser(sql);
		HSSFWorkbook wb1 = build.Build("�������Կ�����Ϣ", list);
		this.workbook2InputStream(wb1, "fangqikaoshimingdan");
		return "success";
	}

	public String ExportCheckOnPersonalExcel() throws Exception {
		
		String KSLB = URLDecoder.decode(request.getParameter("KSLB"));
		String sql = "select * from user where state=1 and KSLB='"+KSLB+"'";
		System.out.println(KSLB);
		BuildExcel build = new BuildExcel();
		List<USER> list = (List<USER>) udao.findRequireUser(sql);
		HSSFWorkbook wb2 = build.Build("ȷ�ϲμӿ��Կ�����Ϣ", list);
		this.workbook2InputStream(wb2, "querenkaoshimingdan");
		return "success";
	}

	public String ExportNoOperationPersonalExcel() throws Exception {
		
		String KSLB = URLDecoder.decode(request.getParameter("KSLB"));
		String sql = "select * from user where state=3 and KSLB='"+KSLB+"'";
		BuildExcel build = new BuildExcel();
		List<USER> list = (List<USER>) udao.findRequireUser(sql);
		HSSFWorkbook wb3 = build.Build("δ���в���������Ϣ", list);
		this.workbook2InputStream(wb3, "weicaozuomingdan");
		return "success";
	}
	
	@SuppressWarnings("unused")
	private void workbook2InputStream(HSSFWorkbook workbook,String fileName) throws Exception{
		
		this.fileName = fileName;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		byte[] aa = baos.toByteArray();
		ByteArrayInputStream is = new ByteArrayInputStream(aa);  
		excelStream = is;
		baos.flush();
		baos.close();
	}
}
