package com.Eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Eshop.dao.Basedao;
import com.Eshop.entity.esm_cart;


public class esm_cartDao {
	public static int insert(esm_cart cart){
		String sql = "insert into esm_cart values(null,?,?,?,?,?,?,?,1)";
		
		Object[] params = {
				cart.getCart_p_filename(),
				cart.getCart_p_name(),
				cart.getCart_p_price(),
				cart.getCart_quantity(),
				cart.getCart_p_stock(),
				cart.getCart_p_id(),
				cart.getCart_u_id()
				
		};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	
	public static esm_cart getCartShop(int id) {
		esm_cart es =null;

		ResultSet rs = null;
	
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_cart where CART_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
		
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new esm_cart(
						 	rs.getInt("CART_ID"),
						 	rs.getString("CART_P_FILENAME"),
						 	rs.getString("CART_P_NAME"),
						 	rs.getInt("CART_P_PRICE"),
						 	rs.getInt("CART_QUANTITY"),
						 	rs.getInt("CART_P_STOCK"),
						 	rs.getInt("CART_P_ID"),
						 	rs.getString("CART_U_ID"),
						 	rs.getInt("CART_VALID")
						 );
				 
				 
				
				 
	
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	
	

	public static esm_cart getCartShop(String uid, String pid) {
		esm_cart es =null;
	
		ResultSet rs = null;

		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_cart where CART_U_ID=? and CART_P_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(pid));
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 es = new esm_cart(
						 rs.getInt("CART_ID"),
						 	rs.getString("CART_P_FILENAME"),
						 	rs.getString("CART_P_NAME"),
						 	rs.getInt("CART_P_PRICE"),
						 	rs.getInt("CART_QUANTITY"),
						 	rs.getInt("CART_P_STOCK"),
						 	rs.getInt("CART_P_ID"),
						 	rs.getString("CART_U_ID"),
						 	rs.getInt("CART_VALID")
						 );
				 
				 
				
				 
	
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return es;	
	}
	
	
	public static ArrayList<esm_cart> getCart(String id){
		ArrayList<esm_cart> list = new ArrayList<esm_cart>();
		
		ResultSet rs = null;
	
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_cart where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_cart c = new esm_cart(
						 	rs.getInt("CART_ID"),
						 	rs.getString("CART_P_FILENAME"),
						 	rs.getString("CART_P_NAME"),
						 	rs.getInt("CART_P_PRICE"),
						 	rs.getInt("CART_QUANTITY"),
						 	rs.getInt("CART_P_STOCK"),
						 	rs.getInt("CART_P_ID"),
						 	rs.getString("CART_U_ID"),
						 	rs.getInt("CART_VALID")
						 );
				 
				 
				
				 
				 
				 list.add(c);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	public static int updatenum(int esid, int count){
		
		String sql = "update esm_cart set CART_QUANTITY=? where CART_ID=? ";
		
		Object[] params = {count, esid};
		
		return Basedao.exectuIUD(sql, params);
		
	}
	
	public static int getDeleteDD(int id) {
		String sql="delete from esm_cart where CART_ID=?";
		
		Object[] params={id};
		
		return Basedao.exectuIUD(sql, params);
	}
	public static int update(String p_filename, String p_name, int p_price, int p_stock, int p_id){
		String sql = "update esm_cart set CART_P_FILENAME=?, CART_P_NAME=?, CART_P_PRICE=?,CART_P_STOCK=? where CART_P_ID = ?";
		Object[] params = {
				p_filename,
				p_name,
				p_price,
				p_stock,
				p_id
				};
	return Basedao.exectuIUD(sql, params);
	}
	public static int returnNum(String user_id) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from esm_cart where CART_U_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
		    rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 count = rs.getInt(1);
			 }
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}

		return count;
	}
}
