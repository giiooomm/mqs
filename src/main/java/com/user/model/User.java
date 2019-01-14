package com.user.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -5809782578272943999L;
	private int id;
	private String usercode;
	private String password;
	private int states;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", usercode=" + usercode + ", password="
				+ password + ", states=" + states + "]";
	}
}
