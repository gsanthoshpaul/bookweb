package com.niit.autoback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String suppliersname;
	private String categoryname;
	private int totalproduct;
	private String supplieraddress;
	
	public String getSuppliersname() {
		return suppliersname;
	}
	public void setSuppliersname(String suppliersname) {
		this.suppliersname = suppliersname;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public int getTotalproduct() {
		return totalproduct;
	}
	public void setTotalproduct(int totalproduct) {
		this.totalproduct = totalproduct;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
}
