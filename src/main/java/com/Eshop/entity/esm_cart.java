package com.Eshop.entity;

public class esm_cart {
	public int CART_ID;
	public String CART_P_FILENAME;
	public String CART_P_NAME;
	public int CART_P_PRICE;
	public int CART_QUANTITY;
	public int CART_P_STOCK;
	public int CART_P_ID;
	public String CART_U_ID;
	public int CART_VALID;
	public esm_cart(int cart_id, String cart_p_filename,
			String cart_p_name, int cart_p_price, int cart_quantity,
			int cart_p_stock, int cart_p_id, String cart_u_id, int cart_valid){
		super();
		this.CART_ID = cart_id;
		this.CART_P_FILENAME = cart_p_filename;
		this.CART_P_NAME = cart_p_name;
		this.CART_P_PRICE = cart_p_price;
		this.CART_QUANTITY = cart_quantity;
		this.CART_P_STOCK = cart_p_stock;
		this.CART_P_ID = cart_p_id;
		this.CART_U_ID = cart_u_id;
		this.CART_VALID = cart_valid;
	}
	public int getCart_id() {
		return CART_ID;
	}
	public void setCart_id(int cART_ID) {
		CART_ID = cART_ID;
	}
	public String getCart_p_filename() {
		return CART_P_FILENAME;
	}
	public void setCart_p_filename(String cART_P_FILENAME) {
		CART_P_FILENAME = cART_P_FILENAME;
	}
	public String getCart_p_name() {
		return CART_P_NAME;
	}
	public void setCart_p_name(String cART_P_NAME) {
		CART_P_NAME = cART_P_NAME;
	}
	public int getCart_p_price() {
		return CART_P_PRICE;
	}
	public void setCart_p_price(int cART_P_PRICE) {
		CART_P_PRICE = cART_P_PRICE;
	}
	public int getCart_quantity() {
		return CART_QUANTITY;
	}
	public void setCart_quantity(int cART_QUANTITY) {
		CART_QUANTITY = cART_QUANTITY;
	}
	public int getCart_p_stock() {
		return CART_P_STOCK;
	}
	public void setCart_p_stock(int cART_P_STOCK) {
		CART_P_STOCK = cART_P_STOCK;
	}
	public int getCart_p_id() {
		return CART_P_ID;
	}
	public void setCart_p_id(int cART_P_ID) {
		CART_P_ID = cART_P_ID;
	}
	public String getCart_u_id() {
		return CART_U_ID;
	}
	public void setCart_u_id(String cART_U_ID) {
		CART_U_ID = cART_U_ID;
	}
	public int getCart_valid() {
		return CART_VALID;
	}
	public void setCart_valid(int cART_VALID) {
		CART_VALID = cART_VALID;
	}
	
}
