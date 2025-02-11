package com.Eshop.entity;

public class esm_address {
	public int ADDRESS_ID;
	public String USER_ID;
	public String NAME;
	public String PHONE;
	public String STATE;
	public String COUNTY;
	public String CODE;
	public String COMMENT;
	
	public esm_address(int address_id, String user_id, String name, String phone, 
			          String state, String county, 
			          String code, String comment) {
		this.ADDRESS_ID = address_id;
		this.USER_ID = user_id;
		this.NAME = name;
		this.PHONE = phone;
		this.STATE = state;
		this.COUNTY = county;
		this.CODE = code;
		this.COMMENT = comment;
}
	
	



	public int getADDRESS_ID() {
		return ADDRESS_ID;
	}





	public void setADDRESS_ID(int aDDRESS_ID) {
		ADDRESS_ID = aDDRESS_ID;
	}





	public String getUSER_ID() {
		return USER_ID;
	}



	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}



	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getCOUNTY() {
		return COUNTY;
	}

	public void setCOUNTY(String cOUNTY) {
		COUNTY = cOUNTY;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getCOMMENT() {
		return COMMENT;
	}

	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}
	
}
