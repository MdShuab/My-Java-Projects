package com.shuaib.gmailspring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class InfoDTO {
	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int infid;
	private String uinbox;
	private String usent;
	private String udraft;
	private String uto;
	private String status;
	private String msub;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date mailTime;
	
	
	

	public Date getMailTime() {
		return mailTime;
	}



	public void setMailTime(Date mailTime) {
		this.mailTime = mailTime;
	}



	public String getMsub() {
		return msub;
	}



	public void setMsub(String msub) {
		this.msub = msub;
	}


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}




	public String getUto() {
		return uto;
	}



	public void setUto(String uto) {
		this.uto = uto;
	}



	public int getInfid() {
		return infid;
	}



	public void setInfid(int infid) {
		this.infid = infid;
	}



	public String getUinbox() {
		return uinbox;
	}



	public void setUinbox(String uinbox) {
		this.uinbox = uinbox;
	}



	public String getUsent() {
		return usent;
	}



	public void setUsent(String usent) {
		this.usent = usent;
	}



	public String getUdraft() {
		return udraft;
	}



	public void setUdraft(String udraft) {
		this.udraft = udraft;
	}



	
	  
}
