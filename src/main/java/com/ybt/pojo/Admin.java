package com.ybt.pojo;

public class Admin {
	private int id;

	private String adminName;
	private String adminPwd;

	public Admin() {
		super();
	}

	public Admin(int id, String adminName, String adminPwd) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", adminPwd=" + adminPwd + "]";
	}

}
