package com.web.entity;

import java.io.Serializable;

/**
 * Job实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Job implements Serializable{

	private int jid;
	
	private String jname;

	public Job() {}

	public Job(int jid, String jname) {
		this.jid = jid;
		this.jname = jname;
	}

	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}
}
