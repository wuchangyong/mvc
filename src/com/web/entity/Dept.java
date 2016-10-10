package com.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="dept")
public class Dept implements Serializable{

	@Id
	@Column(name="did",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int did;
	
	@Column(name="dname",length=20,nullable=false,unique=true)
	private String dname;

	public Dept() {}

	public Dept(String dname) {
		this.dname = dname;
	}

	public Dept(int did, String dname) {
		this.did = did;
		this.dname = dname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
}
