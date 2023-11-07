package com.nagarro.productCatalogs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Serviceabilty {
	
	@Id
	int id;
	int pincodes;
	int productid;
	int estimateddays;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPincodes() {
		return pincodes;
	}
	public void setPincodes(int pincodes) {
		this.pincodes = pincodes;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getEstimateddays() {
		return estimateddays;
	}
	public void setEstimateddays(int estimateddays) {
		this.estimateddays = estimateddays;
	}
	
	

}
