package com.medi.model;

import java.io.Serializable;
import java.util.Date;

public class UserDetails implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 85784568543073014L;
	private String userID;
	private String userName;
	private String password;
	private Date lastLogin;
	private int Status;
	private String role;
	
	public UserDetails() {
		super();
	}
	
	
	

	public UserDetails(String userID, String userName, String password, Date lastLogin, int status, String role) {
		
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.lastLogin = lastLogin;
		Status = status;
		this.role = role;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

}
