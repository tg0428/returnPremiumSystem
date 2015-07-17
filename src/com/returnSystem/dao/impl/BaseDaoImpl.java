package com.returnSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.returnSystem.dao.BaseDao;
import com.returnSystem.model.USER;
import com.returnSystem.utils.DBUtils;

public class BaseDaoImpl implements BaseDao {

	@Override
	public List<USER> findByZJHM(String ZJHM,String KSXM) {
		Connection conn = DBUtils.createConn();
		String sql = "Select * from user where ZJHM = ? and KSXM = ?";
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = null;
		List<USER> list = new ArrayList<USER>();
		try {
				ps.setString(1, ZJHM);
				ps.setString(2, KSXM);
				rs = ps.executeQuery();
				while(rs.next()){
					USER user = new USER();
					user.setKSXM(rs.getString("KSXM"));
					user.setZJHM(rs.getString("ZJHM"));
					user.setGZDW(rs.getString("GZDW"));
					user.setBKZYMC(rs.getString("BKZYMC"));
					user.setBKJBMC(rs.getString("BKJBMC"));
					user.setKM_1(rs.getString("KM_1"));
					user.setKM_2(rs.getString("KM_2"));
					user.setKM_3(rs.getString("KM_3"));
					user.setKM_4(rs.getString("KM_4"));
					user.setKM_4(rs.getString("KM_4"));
					user.setKM_5(rs.getString("KM_5"));
					user.setFYKM_1(rs.getInt("FYKM_1"));
					user.setFYKM_2(rs.getInt("FYKM_2"));
					user.setFYKM_3(rs.getInt("FYKM_3"));
					user.setFYKM_4(rs.getInt("FYKM_4"));
					user.setFYKM_5(rs.getInt("FYKM_5"));
					user.setZFY(rs.getInt("ZFY"));
					user.setKHH(rs.getString("KHH"));
					user.setYHKH(rs.getString("YHKH"));
					user.setKSJB(rs.getInt("KSJB"));
					user.setBMFY(rs.getInt("BMFY"));
					user.setKSLB(rs.getString("KSLB"));
					user.setDH(rs.getString("DH"));
					user.setYX(rs.getString("YX"));
					user.setRole(rs.getString("role"));
					user.setJE(rs.getInt("JE"));
					user.setBMDS(rs.getString("BMDS"));
					user.setBMDSMC(rs.getString("BMDSMC"));
					user.setKQ(rs.getString("KQ"));
					user.setKQMC(rs.getString("KQMC"));
					list.add(user);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
			DBUtils.close(ps);
		}
		return list;
	}

	@Override
	public boolean abandonExam(String Sql) {
		Connection conn = DBUtils.createConn();
		PreparedStatement ps = DBUtils.getPs(conn, Sql);
		try {
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
			DBUtils.close(ps);
		}
		return false;
	}

	@Override
	public boolean update(String sql) {
		Connection conn = DBUtils.createConn();
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		try {
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
			DBUtils.close(ps);
		}
		return true;
	}

	@Override
	public boolean findByinfo(String ZJHM, String KSXM) {
		Connection conn = DBUtils.createConn();
		String sql = "Select * from user where ZJHM = ? and KSXM = ?";
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, ZJHM);
			ps.setString(2, KSXM);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			DBUtils.close(ps);
		}
		return false;
	}

	@Override
	public boolean checkExam(String Sql) {
		Connection conn = DBUtils.createConn();
		PreparedStatement ps = DBUtils.getPs(conn, Sql);
		try {
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
			DBUtils.close(ps);
		}
		return false;
	}

	@Override
	public List<?> findUser(String ZJHM) {
		Connection conn = DBUtils.createConn();
		String sql = "Select * from user where ZJHM = ?";
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = null;
		List<USER> list = new ArrayList<USER>();
		try {
				ps.setString(1, ZJHM);
				rs = ps.executeQuery();
				while(rs.next()){
					USER user = new USER();
					user.setKSXM(rs.getString("KSXM"));
					user.setZJHM(rs.getString("ZJHM"));
					user.setGZDW(rs.getString("GZDW"));
					user.setBKZYMC(rs.getString("BKZYMC"));
					user.setKM_1(rs.getString("KM_1"));
					user.setKM_2(rs.getString("KM_2"));
					user.setKM_3(rs.getString("KM_3"));
					user.setKM_4(rs.getString("KM_4"));
					user.setKM_4(rs.getString("KM_4"));
					user.setKM_5(rs.getString("KM_5"));
					user.setKMDM_1(rs.getInt("KMDM_1"));
					user.setKMDM_2(rs.getInt("KMDM_2"));
					user.setKMDM_3(rs.getInt("KMDM_3"));
					user.setKMDM_4(rs.getInt("KMDM_4"));
					user.setKMDM_5(rs.getInt("KMDM_5"));
					user.setFYKM_1(rs.getInt("FYKM_1"));
					user.setFYKM_2(rs.getInt("FYKM_2"));
					user.setFYKM_3(rs.getInt("FYKM_3"));
					user.setFYKM_4(rs.getInt("FYKM_4"));
					user.setFYKM_5(rs.getInt("FYKM_5"));
					user.setZFY(rs.getInt("ZFY"));
					user.setBMFY(rs.getInt("BMFY"));
					user.setKHH(rs.getString("KHH"));
					user.setYHKH(rs.getString("YHKH"));
					user.setJE(rs.getInt("JE"));
					user.setState(rs.getInt("state"));
					user.setSCXGSJ(rs.getString("SCXGSJ"));
					user.setDH(rs.getString("DH"));
					user.setYX(rs.getString("YX"));
					user.setKSLB(rs.getString("KSLB"));
					user.setKSJB(rs.getInt("KSJB"));
					user.setBKJBMC(rs.getString("BKJBMC"));
					user.setBMDS(rs.getString("BMDS"));
					user.setBMDSMC(rs.getString("BMDSMC"));
					user.setKQ(rs.getString("KQ"));
					user.setKQMC(rs.getString("KQMC"));
					list.add(user);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
			DBUtils.close(ps);
		}
		return list;
	}

	@Override
	public List<?> findRequireUser(String sql) {
		Connection conn = DBUtils.createConn();
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = null;
		List<USER> list = new ArrayList<USER>();
		try {
				rs = ps.executeQuery();
				while(rs.next()){
					USER user = new USER();
					user.setKSXM(rs.getString("KSXM"));
					user.setZJHM(rs.getString("ZJHM"));
					user.setGZDW(rs.getString("GZDW"));
					user.setBKZYMC(rs.getString("BKZYMC"));
					user.setKM_1(rs.getString("KM_1"));
					user.setKM_2(rs.getString("KM_2"));
					user.setKM_3(rs.getString("KM_3"));
					user.setKM_4(rs.getString("KM_4"));
					user.setKM_4(rs.getString("KM_4"));
					user.setKM_5(rs.getString("KM_5"));
					user.setFYKM_1(rs.getInt("FYKM_1"));
					user.setFYKM_2(rs.getInt("FYKM_2"));
					user.setFYKM_3(rs.getInt("FYKM_3"));
					user.setFYKM_4(rs.getInt("FYKM_4"));
					user.setFYKM_5(rs.getInt("FYKM_5"));
					user.setZFY(rs.getInt("ZFY"));
					user.setKHH(rs.getString("KHH"));
					user.setYHKH(rs.getString("YHKH"));
					user.setKSJB(rs.getInt("KSJB"));
					user.setBMFY(rs.getInt("BMFY"));
					user.setKSLB(rs.getString("KSLB"));
					user.setSCXGSJ(rs.getString("SCXGSJ"));
					user.setDH(rs.getString("DH"));
					user.setYX(rs.getString("YX"));
					user.setJE(rs.getInt("JE"));
					user.setBMDS(rs.getString("BMDS"));
					user.setBMDSMC(rs.getString("BMDSMC"));
					user.setKQ(rs.getString("KQ"));
					user.setKQMC(rs.getString("KQMC"));
					list.add(user);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn);
			DBUtils.close(ps);
		}
		return list;
	}

	@Override
	public List<?> search(String KSXM, String ZJHM) {
		Connection conn = DBUtils.createConn();
		if ((KSXM == null&& ZJHM == null)||(KSXM.trim().equals("")&& ZJHM.trim().equals(""))) {
			return null;
		}else{
			String sql = "select * from user where KSXM like '%" + KSXM.trim()
					+ "%' and ZJHM like '%" + ZJHM.trim() + "%'";
			PreparedStatement ps = DBUtils.getPs(conn, sql);
			ResultSet rs = null;
			List<USER> list = new ArrayList<USER>();
			try {
				rs = ps.executeQuery();
				while (rs.next()) {
					USER user = new USER();
					user.setKSXM(rs.getString("KSXM"));
					user.setZJHM(rs.getString("ZJHM"));
					user.setState(rs.getInt("state"));
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(conn);
				DBUtils.close(ps);
			}
			return list;
		}
	}
}
