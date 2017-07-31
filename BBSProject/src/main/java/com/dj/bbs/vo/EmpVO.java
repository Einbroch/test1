package com.dj.bbs.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmpVO {
	
	private String id;
	private String userid;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String addr;
	private Date createdate;
	private String alert;
	private String remeber;
	private String msg;

	@Override
	public String toString() {
		return "EmpVO [id=" + id + ", userid=" + userid + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", addr=" + addr + ", createdate=" + createdate + ", alert=" + alert
				+ ", remeber=" + remeber + ", msg=" + msg + "]";
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRemeber() {
		return remeber;
	}
	public void setRemeber(String remeber) {
		this.remeber = remeber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
}
