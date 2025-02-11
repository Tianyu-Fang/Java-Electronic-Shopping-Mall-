package com.Eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Eshop.dao.Basedao;
import com.Eshop.entity.esm_order;
import com.Eshop.entity.esm_user;


public class esm_orderDao {
	public static int insert(esm_order o) {
		String sql = "insert into esm_order values(?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d %H:%i:%S'), ?, ?, ?)";
		
		
		Object[] params = {
					o.getORDER_ID(),
					o.getUSER_ID(),
					o.getSTATUS(),
					o.getORDER_TIME(),
					o.getTOTAL_PRICE(),
					o.getADDRESS_ID(),
					o.getREMARK()
					};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static ArrayList<esm_order> selectByUser(String user_id) {
		ArrayList<esm_order> list = new ArrayList<esm_order>();
	
		ResultSet rs = null;

		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_order where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_order o = new esm_order(
						 	rs.getInt("order_id"),
						 	rs.getString("user_id"),
						 	rs.getString("status"),
						 	rs.getString("order_time"),
						 	rs.getInt("total_price"),
						 	rs.getInt("address_id"),
						 	rs.getString("remark")
						 );
				 
				 
				 list.add(o);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}	
		return list;
	}
	
	public static ArrayList<esm_order> selectAllByUser(int cpage, int count,String keyword, String user_id) {
		ArrayList<esm_order> list = new ArrayList<esm_order>();
		//declare result set
		ResultSet rs = null;
		//obtain connection object
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select * from esm_order where user_id=? and order_id like ? order by order_time desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, user_id);
				 ps.setString(2, "%"+keyword+"%");
				 ps.setInt(3, (cpage-1)*count);
				 ps.setInt(4, count);
			}else{
			
				sql = "select * from esm_order where user_id=? order by order_time desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, user_id);
				 ps.setInt(2, (cpage-1)*count);
				 ps.setInt(3, count);
			}
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_order o = new esm_order(
						 	rs.getInt("order_id"),
						 	rs.getString("user_id"),
						 	rs.getString("status"),
						 	rs.getString("order_time"),
						 	rs.getInt("total_price"),
						 	rs.getInt("address_id"),
						 	rs.getString("remark")
						 );
				 
				 
				 list.add(o);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	
	public static ArrayList<esm_order> selectAllByUserReceived(int cpage, int count,String keyword, String user_id) {
		ArrayList<esm_order> list = new ArrayList<esm_order>();
		//declare result set
		ResultSet rs = null;
		//obtain connection object
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select * from esm_order where user_id=? and status=? and order_id like ? order by order_time desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, user_id);
				 ps.setString(2, "received");
				 ps.setString(3, "%"+keyword+"%");
				 ps.setInt(4, (cpage-1)*count);
				 ps.setInt(5, count);
			}else{
			
				sql = "select * from esm_order where user_id=? and status=? order by order_time desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, user_id);
				 ps.setString(2, "received");
				 ps.setInt(3, (cpage-1)*count);
				 ps.setInt(4, count);
			}
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_order o = new esm_order(
						 	rs.getInt("order_id"),
						 	rs.getString("user_id"),
						 	rs.getString("status"),
						 	rs.getString("order_time"),
						 	rs.getInt("total_price"),
						 	rs.getInt("address_id"),
						 	rs.getString("remark")
						 );
				 
				 
				 list.add(o);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	
	public static ArrayList<esm_order> selectAllByUserPayed(int cpage, int count,String keyword, String user_id) {
		ArrayList<esm_order> list = new ArrayList<esm_order>();
		//declare result set
		ResultSet rs = null;
		//obtain connection object
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select * from esm_order where user_id=? and status=? and order_id like ? order by order_time desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, user_id);
				 ps.setString(2, "payed");
				 ps.setString(3, "%"+keyword+"%");
				 ps.setInt(4, (cpage-1)*count);
				 ps.setInt(5, count);
			}else{
			
				sql = "select * from esm_order where user_id=? and status=? order by order_time desc limit ?, ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1, user_id);
				 ps.setString(2, "payed");
				 ps.setInt(3, (cpage-1)*count);
				 ps.setInt(4, count);
			}
			
			 
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_order o = new esm_order(
						 	rs.getInt("order_id"),
						 	rs.getString("user_id"),
						 	rs.getString("status"),
						 	rs.getString("order_time"),
						 	rs.getInt("total_price"),
						 	rs.getInt("address_id"),
						 	rs.getString("remark")
						 );
				 
				 
				 list.add(o);
				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
	public static int[] totalPage(int count, String keyword, String user_id) {
		// 0,total records, 1,pages
		int arr[] = {0, 1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select count(*) from esm_order where user_id=? and order_id like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				ps.setString(2, "%"+keyword+"%");
			}else{
				sql = "select count(*) from esm_order where user_id=?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				
			}
			

			
			
			
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 arr[0]= rs.getInt(1);
				 
				 if(arr[0]%count==0){
					 arr[1] = arr[0]/count;
				 }else{
					 arr[1] = arr[0]/count+1;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return arr;
	}
	
	public static int[] totalPageReceived(int count, String keyword, String user_id) {
		// 0,total records, 1,pages
		int arr[] = {0, 1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select count(*) from esm_order where user_id=? and status=? and order_id like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				ps.setString(2, "received");
				ps.setString(3, "%"+keyword+"%");
			}else{
				sql = "select count(*) from esm_order where user_id=? and status=?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				ps.setString(2, "received");
			}
			

			
			
			
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 arr[0]= rs.getInt(1);
				 
				 if(arr[0]%count==0){
					 arr[1] = arr[0]/count;
				 }else{
					 arr[1] = arr[0]/count+1;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return arr;
	}
	public static int[] totalPagePayed(int count, String keyword, String user_id) {
		// 0,total records, 1,pages
		int arr[] = {0, 1};
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		try {
			String sql = "";
			
			if(keyword!=null) {
				sql = "select count(*) from esm_order where user_id=? and status=? and order_id like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				ps.setString(2, "payed");
				ps.setString(3, "%"+keyword+"%");
			}else{
				sql = "select count(*) from esm_order where user_id=? and status=?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, user_id);
				ps.setString(2, "payed");
			}
			

			
			
			
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 arr[0]= rs.getInt(1);
				 
				 if(arr[0]%count==0){
					 arr[1] = arr[0]/count;
				 }else{
					 arr[1] = arr[0]/count+1;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		
		
		return arr;
	}
	public static esm_order selectById(int order_id) {
	
		esm_order o = null;
		
		ResultSet rs = null;

		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_order where order_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order_id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				  o = new esm_order(
						 	rs.getInt("order_id"),
						 	rs.getString("user_id"),
						 	rs.getString("status"),
						 	rs.getString("order_time"),
						 	rs.getInt("total_price"),
						 	rs.getInt("address_id"),
						 	rs.getString("remark")
						 );
				 				 
			 }
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}	
		return o;
	}
	
	public static int updateStatus(int order_id) {
		String sql = "update esm_order set status=? where order_id = ?";
		Object[] params = {
				 "received",
				 order_id
		};
		
		return Basedao.exectuIUD(sql, params);
	}
	public static int countPayed(String user_id) {
		
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		
		try {
			String sql = "";

			sql = "select count(*) from esm_order where status=? and user_id=?";
				
			ps = conn.prepareStatement(sql);
			ps.setString(1, "payed");
			ps.setString(2, user_id);

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
public static int countReceived(String user_id) {
		
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		
		try {
			String sql = "";

			sql = "select count(*) from esm_order where status=? and user_id=?";
				
			ps = conn.prepareStatement(sql);
			ps.setString(1, "received");
			ps.setString(2, user_id);

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
