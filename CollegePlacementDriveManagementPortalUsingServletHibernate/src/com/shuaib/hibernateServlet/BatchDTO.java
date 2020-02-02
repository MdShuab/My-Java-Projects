package com.shuaib.hibernateServlet;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BatchDTO {
	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator = "auto")
	
	private int bid;
	private String bname;
	private String bfname;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName = "bid")
	private List<StudentDTO> slist;
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBfname() {
		return bfname;
	}
	public void setBfname(String bfname) {
		this.bfname = bfname;
	}
	
	public List<StudentDTO> getSlist() {
		return slist;
	}
	public void setSlist(List<StudentDTO> slist) {
		this.slist = slist;
	}
	
	
	
	
	

}
