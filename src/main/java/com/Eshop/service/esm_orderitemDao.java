package com.Eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Eshop.dao.Basedao;
import com.Eshop.entity.esm_orderitem;

public class esm_orderitemDao {
	public static int insert(esm_orderitem i) {
		String sql = "insert into esm_orderitem values(null, ?, ?,?)";
		
		
		Object[] params = {
					i.getORDER_ID(),
					i.getPRODUCT_ID(),
					i.getPRODUCT_NUM(),		
					};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	public static ArrayList<esm_orderitem> selectByOrder(int order_id) {
		ArrayList<esm_orderitem> list = new ArrayList<esm_orderitem>();
	
		ResultSet rs = null;

		Connection conn = Basedao.getconn();
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select * from esm_orderitem where order_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order_id);
			rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 esm_orderitem i = new esm_orderitem(
						 	rs.getInt("item_id"),
						 	rs.getInt("order_id"),
						 	rs.getInt("product_id"),
						 	rs.getInt("product_num")
						 );
				 
				 
				 list.add(i);
				 
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
