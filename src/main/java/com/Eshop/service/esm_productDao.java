package com.Eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Eshop.dao.Basedao;
import com.Eshop.entity.esm_product;
import com.Eshop.service.esm_cartDao;


public class esm_productDao {
	
	public static int insert(esm_product p) {
		String sql = "insert into esm_product values(null, ?, ?,?,?,?,?,?)";
		
		
		Object[] params = {
					p.getPRODUCT_NAME(),
					p.getPRODUCT_DESCRIPTION(),
					p.getPRODUCT_PRICE(),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_FID(),
					p.getPRODUCT_CID(),
					p.getPRODUCT_FILENAME()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static ArrayList<esm_product> selectAll() {
		ArrayList<esm_product> list = new ArrayList<esm_product>();
	
		ResultSet rs = null;

		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_product p = new esm_product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	public static ArrayList<esm_product> selectAllByKeywords(String keywords) {
		ArrayList<esm_product> list = new ArrayList<esm_product>();
	
		ResultSet rs = null;

		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_product where PRODUCT_NAME like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keywords+"%");
			rs = ps.executeQuery();
			
			 
			 while(rs.next()) {
				 esm_product p = new esm_product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static esm_product selectById(int id) {
		esm_product p = null;
		
		ResultSet rs = null;
		
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_product where PRODUCT_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  p = new esm_product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return p;
	}
	
	public static ArrayList<esm_product> selectAllByFid(int fid) {
		ArrayList<esm_product> list = new ArrayList<esm_product>();

		ResultSet rs = null;
	
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_product where PRODUCT_FID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_product p = new esm_product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<esm_product> selectAllByCid(int cid) {
		ArrayList<esm_product> list = new ArrayList<esm_product>();
	
		ResultSet rs = null;
	
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_product where PRODUCT_CID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_product p = new esm_product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
						 );
				 
				 
				 list.add(p);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
	public static ArrayList<esm_product> selectAllById(ArrayList<Integer> ids) {
		ArrayList<esm_product> lastlylist = new ArrayList<esm_product>();
		
		 esm_product p = null;
		
		ResultSet rs = null;
	
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
		    for(int i=0; i<ids.size(); i++) {
			
				String sql = "select * from esm_product where PRODUCT_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, ids.get(i));
				rs = ps.executeQuery();
				 
				 while(rs.next()) {
					 p = new esm_product(
							 	rs.getInt("PRODUCT_ID"),
							 	rs.getString("PRODUCT_NAME"),
							 	rs.getString("PRODUCT_DESCRIPTION"),
							 	rs.getInt("PRODUCT_PRICE"),
							 	rs.getInt("PRODUCT_STOCK"),
							 	rs.getInt("PRODUCT_FID"),
							 	rs.getInt("PRODUCT_CID"),
							 	rs.getString("PRODUCT_FILENAME")
							 );
					 
					 
					 lastlylist.add(p);
					 
				 }
		    }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return lastlylist;
	}
	public static esm_product selectByID(String id) {

		esm_product p = null;
		
		//declare result set
		ResultSet rs = null;
		//obtain connection object
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_product  where PRODUCT_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, id);
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 p = new esm_product(
						 	rs.getInt("PRODUCT_ID"),
						 	rs.getString("PRODUCT_NAME"),
						 	rs.getString("PRODUCT_DESCRIPTION"),
						 	rs.getInt("PRODUCT_PRICE"),
						 	rs.getInt("PRODUCT_STOCK"),
						 	rs.getInt("PRODUCT_FID"),
						 	rs.getInt("PRODUCT_CID"),
						 	rs.getString("PRODUCT_FILENAME")
			
						 );
				 	 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return p;
	}
	
	public static int update(esm_product p) {
		String sql = "update esm_product set PRODUCT_NAME=?, PRODUCT_DESCRIPTION=?,PRODUCT_PRICE=?,PRODUCT_STOCK=?,PRODUCT_FID=?,PRODUCT_CID=?,PRODUCT_FILENAME=? where PRODUCT_ID = ?";
		
		Object[] params = {
					p.getPRODUCT_NAME(), 
					p.getPRODUCT_DESCRIPTION(),
					p.getPRODUCT_PRICE(),
					p.getPRODUCT_STOCK(),
					p.getPRODUCT_FID(),
					p.getPRODUCT_CID(),
					p.getPRODUCT_FILENAME(),
					p.getPRODUCT_ID()
					};
		esm_cartDao.update(p.getPRODUCT_FILENAME(), p.getPRODUCT_NAME(), p.getPRODUCT_PRICE(), p.getPRODUCT_STOCK(), p.getPRODUCT_ID());
		return Basedao.exectuIUD(sql, params);
	}
	public static int del(int id) {
		
		String sql = "delete from esm_product where PRODUCT_ID=?";
		
		Object[] params = {id};
		
		return Basedao.exectuIUD(sql, params);
	}
}
