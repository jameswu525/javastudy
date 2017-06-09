package org.jimmy.mvcdemo.entity;

import org.jimmy.mvc.entity.Entity;

public class UserEntity extends Entity<UserEntity> {
	private String id = null;
	private String username = null;
	private String password = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserEntity(boolean isSuccess, String msg) {
		super(isSuccess, msg);
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
