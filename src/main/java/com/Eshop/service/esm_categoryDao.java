package com.Eshop.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Eshop.dao.Basedao;
import com.Eshop.entity.esm_category;

/**

 * @author Administrator
 *
 */
public class esm_categoryDao {
	public static ArrayList<esm_category> selectAll() {
		ArrayList<esm_category> list = new ArrayList<esm_category>();

		ResultSet rs = null;

		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_category cate = new esm_category(
						 	rs.getInt("CATE_ID"),
						 	rs.getString("CATE_NAME"),
						 	rs.getInt("CATE_PARENT_ID")
						 
						 );
				 
				 
				 list.add(cate);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	/**
	 * @param flag  flag="father" flag="child"
	 * @return
	 */
	
	public static ArrayList<esm_category> selectCat(String flag) {
		ArrayList<esm_category> list = new ArrayList<esm_category>();

		ResultSet rs = null;
	
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			
			String sql = null;
			
			if(flag!=null && flag.equals("father")){
			
				sql = "select * from esm_category where CATE_PARENT_ID=0";
			}else{
				sql = "select * from esm_category where CATE_PARENT_ID!=0";
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_category cate = new esm_category(
						 	rs.getInt("CATE_ID"),
						 	rs.getString("CATE_NAME"),
						 	rs.getInt("CATE_PARENT_ID")
						 
						 );
				 
				 
				 list.add(cate);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	
	public static esm_category selectById(int id) {

		esm_category cate = null;
		
	
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select *  from esm_category  where CATE_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 cate = new esm_category(
						 	rs.getInt("CATE_ID"),
						 	rs.getString("CATE_NAME"),
						 	rs.getInt("CATE_PARENT_ID")
			
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return cate;
	}
	
	
	
	/**
	
	 * @param cate
	 * @return
	 */
	
	public static int insert(esm_category cate) {
		String sql = "insert into esm_category values(null, ?, ?)";
		
		Object[] params = {
					cate.getCATE_NAME(), 
					cate.getCATE_PARENT_ID()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	

	public static int update(esm_category cate) {
		String sql = "update esm_category set CATE_NAME=?, CATE_PARENT_ID=?  where CATE_ID = ?";
		
		Object[] params = {
					cate.getCATE_NAME(),
					cate.getCATE_PARENT_ID(),
					cate.getCATE_ID()
					};
		
		return Basedao.exectuIUD(sql, params);
}

	
	public static int del(int id) {
		String sql = "delete from esm_category where CATE_ID=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
		
	}
	
	
	

}