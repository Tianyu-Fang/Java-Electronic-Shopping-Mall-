package com.Eshop.entity;

public class esm_orderitem {
	private int ITEM_ID;
	private int ORDER_ID;
	private int PRODUCT_ID;
	private int PRODUCT_NUM;
	
	public esm_orderitem(int item_id, int order_id, int product_id, int product_num) {
		ITEM_ID = item_id;
		ORDER_ID = order_id;
		PRODUCT_ID = product_id;
		PRODUCT_NUM = product_num;
	}

	public int getITEM_ID() {
		return ITEM_ID;
	}

	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}

	public int getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public int getPRODUCT_NUM() {
		return PRODUCT_NUM;
	}

	public void setPRODUCT_NUM(int pRODUCT_NUM) {
		PRODUCT_NUM = pRODUCT_NUM;
	}
	
	
}
