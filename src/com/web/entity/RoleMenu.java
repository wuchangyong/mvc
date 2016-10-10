package com.web.entity;

import java.io.Serializable;

public class RoleMenu implements Serializable{
	
	private int rmid;
	
	private int rid;
	
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
