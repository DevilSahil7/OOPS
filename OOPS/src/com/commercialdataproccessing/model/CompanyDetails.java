package com.commercialdataproccessing.model;

public class CompanyDetails {

	public String companyName;
	public int noOfShares;
	public float price;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CompanyDetails [companyName=" + companyName + ", noOfShares=" + noOfShares + ", price=" + price + "]";
	}
	
	
}
