package com.dj.bbs.vo;

import java.util.Date;

public class BbsVO {
	private String id;
	private int num;
	private String title;
	private String ownerId;
	private String ownerName;
	private Date registDate;
	private String content;
	private String contentPath;
	private String isFile;
	private String isDelete;
	
	
	
	@Override
	public String toString() {
		return "BbsVO [id=" + id + ", num=" + num + ", title=" + title + ", ownerid=" + ownerId + ", ownerName="
				+ ownerName + ", registDate=" + registDate + ", content=" + content + ", contentPath=" + contentPath
				+ ", isFile=" + isFile + ", isDelete=" + isDelete + "]";
	}
	public String getContentPath() {
		return contentPath;
	}
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsFile() {
		return isFile;
	}
	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	
}




