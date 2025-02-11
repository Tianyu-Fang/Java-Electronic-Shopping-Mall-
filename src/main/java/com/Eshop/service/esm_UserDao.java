package com.Eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Eshop.dao.Basedao;
import com.Eshop.entity.esm_user;



public class esm_UserDao {
	
	/**add into database**/
	public static int insert(esm_user u) {
		String sql = "insert into esm_user values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";
		
		Object[] params = {
					u.getUSER_ID(), 
					u.getUSER_NAME(), 
					u.getUSER_PASSWORD(),
					u.getUSER_SEX(),
					u.getUSER_BIRTHDAY(),
					u.getUSER_IDENTITY_CODE(),
					u.getUSER_EMAIL(),
					u.getUSER_MOBILE(),
					u.getUSER_ADDRESS(),
					u.getUSER_STATUS()};
		
		return Basedao.exectuIUD(sql, params);
}

/**
 * delete an user
 * @param id
 * @return
 */
public static int del(String id) {
	
	String sql = "delete from esm_user where USER_ID=? and USER_STATUS!=2";
	
	Object[] params = {id};
	
	return Basedao.exectuIUD(sql, params);
}


public static int update(esm_user u) {
	String sql = "update esm_user set USER_NAME=?, USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?, '%y-%m-%d'),USER_IDENTITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID = ?";
	
	Object[] params = {
				u.getUSER_NAME(), 
				u.getUSER_PASSWORD(),
				u.getUSER_SEX(),
				u.getUSER_BIRTHDAY(),
				u.getUSER_IDENTITY_CODE(),
				u.getUSER_EMAIL(),
				u.getUSER_MOBILE(),
				u.getUSER_ADDRESS(),
				u.getUSER_STATUS(),
				u.getUSER_ID()};
	
	return Basedao.exectuIUD(sql, params);
}







public static int selectByName(String id) {
	int count = 0;
	Connection conn = Basedao.getconn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	try {
		String sql = "select count(*) from esm_user where USER_ID=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
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


/**
 * obtain total records and pages
 * @param count
 * @return
 */

public static int[] totalPage(int count, String keyword) {
	// 0,total records, 1,pages
	int arr[] = {0, 1};
	
	Connection conn = Basedao.getconn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	try {
		String sql = "";
		
		if(keyword!=null) {
			sql = "select count(*) from esm_user where USER_NAME like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
		}else{
			sql = "select count(*) from esm_user";
			
			ps = conn.prepareStatement(sql);
			
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


public static ArrayList<esm_user> selectAll(int cpage, int count,String keyword) {
	ArrayList<esm_user> list = new ArrayList<esm_user>();
	//declare result set
	ResultSet rs = null;
	//obtain connection object
	Connection conn = Basedao.getconn();
	
	PreparedStatement ps = null;
	
	
	
	try {
		String sql = "";
		
		if(keyword!=null) {
			sql = "select * from esm_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?, ?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, "%"+keyword+"%");
			 ps.setInt(2, (cpage-1)*count);
			 ps.setInt(3, count);
		}else{
		
			sql = "select * from esm_user order by USER_BIRTHDAY desc limit ?, ?";
			 ps = conn.prepareStatement(sql);
			 
			 ps.setInt(1, (cpage-1)*count);
			 ps.setInt(2, count);
		}
		
		 
		 rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 esm_user u = new esm_user(
					 	rs.getString("USER_ID"),
					 	rs.getString("USER_NAME"),
					 	rs.getString("USER_PASSWORD"),
					 	rs.getString("USER_SEX"),
					 	rs.getString("USER_BIRTHDAY"),
					 	rs.getString("USER_IDENTITY_CODE"),
					 	rs.getString("USER_EMAIL"),
					 	rs.getString("USER_MOBILE"),
					 	rs.getString("USER_ADDRESS"),
					 	rs.getInt("USER_STATUS")
					 
					 );
			 
			 
			 list.add(u);
			 
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
 * search user by id
 * @param cpage
 * @param count
 * @param keyword
 * @return
 */
public static esm_user selectByID(String id) {

	esm_user u = null;
	
	//declare result set
	ResultSet rs = null;
	//obtain connection object
	Connection conn = Basedao.getconn();
	
	PreparedStatement ps = null;
	
	
	
	try {
		String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from esm_user m where USER_ID=?";
		
		 ps = conn.prepareStatement(sql);
		 ps.setString(1, id);
		
		 
		 rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 u = new esm_user(
					 	rs.getString("USER_ID"),
					 	rs.getString("USER_NAME"),
					 	rs.getString("USER_PASSWORD"),
					 	rs.getString("USER_SEX"),
					 	rs.getString("birthday"),
					 	rs.getString("USER_IDENTITY_CODE"),
					 	rs.getString("USER_EMAIL"),
					 	rs.getString("USER_MOBILE"),
					 	rs.getString("USER_ADDRESS"),
					 	rs.getInt("USER_STATUS")
		
					 );
			 
			 
			
			 
		 }
		 
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		Basedao.closeall(rs, ps, conn);
	}
	
	
	
	return u;
}











public static int selectByNM(String name, String pwd){
	int count =0; 
	
	Connection conn = Basedao.getconn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	try {
		String sql = "select count(*) from esm_user where USER_ID=? and USER_PASSWORD=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
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


public static int selectByNE(String name, String email) {
	int count =0; 

	Connection conn = Basedao.getconn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try {
		String sql = "select count(*) from esm_user where USER_ID=? and USER_EMAIL=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, email);
	    rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 count = rs.getInt(1);
		 }
	}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}finally{
				Basedao.closeall(rs, ps, conn);
	}
			
			
	return count;
			
	
}

public static int updatePassword(String pwd, String id) 
{
String sql = "update esm_user set USER_PASSWORD=? where USER_ID = ?";
	
	Object[] params = {
			
			pwd,
			
			id};
	
	return Basedao.exectuIUD(sql, params);
}


/**
 * search user information by user name and password
 * @param name
 * @param pwd
 * @return
 */

public static esm_user selectAdmin(String name, String pwd) {
	esm_user u = null;
	
	//declare result set
	ResultSet rs = null;
	//obtain connection object
	Connection conn = Basedao.getconn();
	
	PreparedStatement ps = null;
	
	
	
	try {
		String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from esm_user m where USER_ID=? and USER_PASSWORD=?";
		
		 ps = conn.prepareStatement(sql);
		 ps.setString(1, name);
		 ps.setString(2, pwd);
		 
		 rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 u = new esm_user(
					 	rs.getString("USER_ID"),
					 	rs.getString("USER_NAME"),
					 	rs.getString("USER_PASSWORD"),
					 	rs.getString("USER_SEX"),
					 	rs.getString("birthday"),
					 	rs.getString("USER_IDENTITY_CODE"),
					 	rs.getString("USER_EMAIL"),
					 	rs.getString("USER_MOBILE"),
					 	rs.getString("USER_ADDRESS"),
					 	rs.getInt("USER_STATUS")
		
					 );
			 
			 
			
			 
		 }
		 
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		Basedao.closeall(rs, ps, conn);
	}
	
	
	
	return u;
	
	
}



}
