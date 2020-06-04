package com.lcvc.intern_choose.model;


import java.io.Serializable;

/**
 * 管理账户
 * 说明：UserDetails为spring security的专属方法
 */
public class Admin implements Serializable {
	private Integer id;

	private String username;//用户名

	private String password;//用户密码

	private String name;//姓名



	public Admin() {
	}

	public Admin(Integer id){
		super();
		this.id=id;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}