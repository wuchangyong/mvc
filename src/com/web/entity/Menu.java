package com.web.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Menu implements Serializable{
	private int mid;
	
	private String name;
	
	private String url;
	
	//此菜单是否在欢迎界面左边的树形菜单中展示 1表示要展示 0表示不展示
	private int isshow = 1;
	
	private int level;
	
	//此菜单的父级菜单id 若此菜单是根菜单 则此属性为-1
	private int parentid;

	public Menu() {}

	public Menu(int mid, String name) {
		this.mid = mid;
		this.name = name;
	}

	public Menu(String name, String url, int isshow, int parentid) {
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.parentid = parentid;
	}

	public Menu(int mid, String name, String url, int isshow, int level,
			int parentid) {
		this.mid = mid;
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentid = parentid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	
}
