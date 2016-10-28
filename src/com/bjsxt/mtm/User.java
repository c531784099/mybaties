package com.bjsxt.mtm;

import java.util.List;

public class User {
	private Integer uid;
	private String uname;
	private Dept dept;
	private List<Post> plist;
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public List<Post> getPlist() {
		return plist;
	}
	public void setPlist(List<Post> plist) {
		this.plist = plist;
	}

}
