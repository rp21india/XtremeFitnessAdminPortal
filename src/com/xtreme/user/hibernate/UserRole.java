package com.xtreme.user.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="xtremusers_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_role_id ", unique=true,nullable=false)
	private Integer user_role_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "username",nullable=false)
	private User user;
	@Column(name="role", nullable=false,length=45)
	private String role;

	
	public UserRole(){}
	
	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public Integer getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
