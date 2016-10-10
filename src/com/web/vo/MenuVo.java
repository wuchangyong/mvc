package com.web.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="v_menu")
public class MenuVo implements Serializable{
	
	@Id
	@Column(name="mid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mid;
	
	@Column(name="name",length=30,nullable=false)
	private String name;
	
	@Column(name="url",length=100)
	private String url;
	
	//此菜单是否在欢迎界面左边的树形菜单中展示 1表示要展示 0表示不展示
	@Column(name="isshow")
	private int isshow = 1;
	
	@Column(name="level")
	private int level;
	
	//此菜单的父级菜单id 若此菜单是根菜单 则此属性为-1
	@Column(name="parentName",length=30)
	private String parentName;

	public String toString(){
		return "{\"mid\":"+mid+",\"name\":"+name+",\"url\":"+url+",\"isshow\":"+isshow+",\"level\":"+level+",\"parentName\":"+parentName+"}";
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public MenuVo(int mid, String name, String url, int isshow, int level,
			String parentName) {
		this.mid = mid;
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentName = parentName;
	}

	public MenuVo() {}

	
	
}

