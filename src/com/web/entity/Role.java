package com.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@SuppressWarnings("serial")
@Entity
@Table(name="role")
public class Role implements Serializable{

	@Id
	@Column(name="rid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	
	@Column(name="rname",length=20,unique=true,nullable=false)
	private String rname;
	
	@Transient
	private String test;

	public Role() {}

	public Role(String rname) {
		this.rname = rname;
	}

	public Role(int rid, String rname) {
		this.rid = rid;
		this.rname = rname;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
