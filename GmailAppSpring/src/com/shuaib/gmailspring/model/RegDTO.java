package com.shuaib.gmailspring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class RegDTO {

	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int uid;
	private String un;
	private String num;
	private String address;
	private String email;
	private String securityq;
	private int count;
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date loginTime;
	
	 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="uid")
	private List<InfoDTO> infolist;

	
	
	

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getSecurityq() {
		return securityq;
	}


	public void setSecurityq(String securityq) {
		this.securityq = securityq;
	}


	public Date getLoginTime() {
		return loginTime;
	}


	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUn() {
		return un;
	}


	public void setUn(String un) {
		this.un = un;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<InfoDTO> getInfolist() {
		return infolist;
	}


	public void setInfolist(List<InfoDTO> infolist) {
		this.infolist = infolist;
	}
	  
	  
	
}
