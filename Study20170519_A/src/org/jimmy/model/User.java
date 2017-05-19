package org.jimmy.model;

public class User {
	String username;
	String sexing;
	public User(String n, String s) {
		this.username = n;
		this.sexing = s;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSexing() {
		return sexing;
	}
	public void setSexing(String sexing) {
		this.sexing = sexing;
	}
	
}
