package com.niit.autoback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Suppliers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierid;
	private String suppliername;
	private String supplierdescription;
	
	private int categoryid;
	
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplierdescription() {
		return supplierdescription;
	}
	public void setSupplierdescription(String supplierdescription) {
		this.supplierdescription = supplierdescription;
	}
	
	}
