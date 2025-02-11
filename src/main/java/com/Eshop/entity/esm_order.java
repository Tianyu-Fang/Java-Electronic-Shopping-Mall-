package com.Eshop.entity;

public class esm_order {
	private int ORDER_ID;
	private String USER_ID;
	private String STATUS;
	private String ORDER_TIME;
	private int TOTAL_PRICE;
	private int ADDRESS_ID;
	private String REMARK;
	
	public esm_order(int order_id, String user_id,
			String status, String order_time,
			int total_price, int address_id,
			String remark)
	{
		ORDER_ID = order_id;
		USER_ID = user_id;
		STATUS = status;
		ORDER_TIME = order_time;
		TOTAL_PRICE = total_price;
		ADDRESS_ID = address_id;
		REMARK = remark;
	}

	public int getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getORDER_TIME() {
		return ORDER_TIME;
	}

	public void setORDER_TIME(String oRDER_TIME) {
		ORDER_TIME = oRDER_TIME;
	}

	public int getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}

	public void setTOTAL_PRICE(int tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public int getADDRESS_ID() {
		return ADDRESS_ID;
	}

	public void setADDRESS_ID(int aDDRESS_ID) {
		ADDRESS_ID = aDDRESS_ID;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	
}
