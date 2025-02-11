package com.Eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Eshop.dao.Basedao;
import com.Eshop.entity.esm_address;
import com.Eshop.entity.esm_category;
import com.Eshop.entity.esm_user;


public class esm_addressDao {
	public static int insert(esm_address address){
	
		String sql = "insert into esm_address values(null,?, ?, ?, ?, ?, ?, ?)";
		
		Object[] params = {
			
				address.getUSER_ID(),
				address.getNAME(),
				address.getPHONE(),
				address.getSTATE(),
				address.getCOUNTY(),
				address.getCODE(),
				address.getCOMMENT()
				
		};
		return Basedao.exectuIUD(sql, params);
		
	}
	
	
	public static int update(esm_address address) {
	String sql = "update esm_address set NAME=?, PHONE=?, STATE=?, COUNTY=?, CODE=?, COMMENT=? where ADDRESS_ID = ?";
	Object[] params = {

			address.getNAME(),
			address.getPHONE(),
			address.getSTATE(),
			address.getCOUNTY(),
			address.getCODE(),
			address.getCOMMENT(),
			address.getADDRESS_ID()
			};
return Basedao.exectuIUD(sql, params);
	}
	
public static int del(int address_id) {
		
		String sql = "delete from esm_address where ADDRESS_ID=?";
		
		Object[] params = {address_id};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	public static esm_address selectByAddressID(int address_id) {
		esm_address a = null;
		//declare result set
		ResultSet rs = null;
		//obtain connection object
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		try {
			String sql = "select * from esm_address a where ADDRESS_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, address_id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 a = new esm_address(
						 	rs.getInt("ADDRESS_ID"),
						 	rs.getString("USER_ID"),
						 	rs.getString("NAME"),
						 	rs.getString("PHONE"),
						 	rs.getString("STATE"),
						 	rs.getString("COUNTY"),
						 	rs.getString("CODE"),
						 	rs.getString("COMMENT")
						 );
				 
				 
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return a;
		
	}
	
	public static ArrayList<esm_address> selectByID(String id) {

		ArrayList<esm_address> a = new ArrayList<esm_address>();
		
		//declare result set
		ResultSet rs = null;
		//obtain connection object
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_address where USER_ID=?";
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, id);
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				esm_address address = new esm_address(
						 	rs.getInt("ADDRESS_ID"),
						 	rs.getString("USER_ID"),
						 	rs.getString("NAME"),
						 	rs.getString("PHONE"),
						 	rs.getString("STATE"),
						 	rs.getString("COUNTY"),
						 	rs.getString("CODE"),
						 	rs.getString("COMMENT")
			
						 );
				 
				 a.add(address);
				
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return a;
	}
	
	
	public static ArrayList<esm_address> selectUser(String user_id) {
		ArrayList<esm_address> list = new ArrayList<esm_address>();

		ResultSet rs = null;
	
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			
			String sql = null;
			
			if(user_id!=null ){
			
				sql = "select * from esm_address where USER_ID=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				
			}else{
				sql = "select * from esm_address where USER_ID!=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				
			}
			
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_address address = new esm_address(
						 	rs.getInt("ADDRESS_ID"),
						 	rs.getString("USER_ID"),
						 	rs.getString("NAME"),
						 	rs.getString("PHONE"),
						 	rs.getString("STATE"),
						 	rs.getString("COUNTY"),
						 	rs.getString("CODE"),
						 	rs.getString("COMMENT")
						 
						 );
				 
				 
				 list.add(address);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return list;
	}
	
	
}
	
	
	
