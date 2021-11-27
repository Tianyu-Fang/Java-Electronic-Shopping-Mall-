package com.esm.entity;

public class esm_user {

	private String user_id;
	private String user_name;
	private String user_password;
	private String user_sex;
	private String user_birthday;
	private String user_idenity_code;
	private String user_email;
	private String user_mobile;
	private String user_address;
	private int user_status;
	public esm_user(String user_id, String user_name, String user_password, String user_sex, String user_birthday,
			String user_idenity_code, String user_email, String user_mobile, String user_address, int user_status) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_birthday = user_birthday;
		this.user_idenity_code = user_idenity_code;
		this.user_email = user_email;
		this.user_mobile = user_mobile;
		this.user_address = user_address;
		this.user_status = user_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_idenity_code() {
		return user_idenity_code;
	}
	public void setUser_idenity_code(String user_idenity_code) {
		this.user_idenity_code = user_idenity_code;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	
}
