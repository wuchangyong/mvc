package com.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	@Column(name="uid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	
	@Column(name="userName",unique=true,nullable=false,length=20)
	private String userName;
	
	@Column(name="userPass",nullable=false,length=20)
	private String userPass;
	
	@Column(name="sex")
	private int sex;
	
	@Column(name="email",length=50)
	private String email;
	
	@Column(name="education")
	private int education;
	
	@Column(name="hobbys",length=30)
	private String hobbys;
	
	@Column(name="description",length=100)
	private String description;
	
	@Column(name="avatar",length=50)
	private String avatar;

	public User() {}

	public User(int uid, String userName, String userPass, int sex,
			String email, int education, String hobbys, String description,String avatar) {
		this.uid = uid;
		this.userName = userName;
		this.userPass = userPass;
		this.sex = sex;
		this.email = email;
		this.education = education;
		this.hobbys = hobbys;
		this.description = description;
		this.avatar = avatar;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public String getHobbys() {
		return hobbys;
	}

	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
