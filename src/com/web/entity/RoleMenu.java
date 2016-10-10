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
@Table(name="rolemenu")
public class RoleMenu implements Serializable{
	
	@Id
	@Column(name="rmid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rmid;
	
	@Column(name="rid")
	private int rid;
	
	@Column(name="mid")
	private int mid;

	public RoleMenu() {}

	public RoleMenu(int rid, int mid) {
		this.rid = rid;
		this.mid = mid;
	}

	public RoleMenu(int rmid, int rid, int mid) {
		this.rmid = rmid;
		this.rid = rid;
		this.mid = mid;
	}

	public int getRmid() {
		return rmid;
	}

	public void setRmid(int rmid) {
		this.rmid = rmid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

}
