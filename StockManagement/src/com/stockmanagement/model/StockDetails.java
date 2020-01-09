package com.stockmanagement.model;

/**
 * Purpose: To set and get values for particular fields
 * 
 * @author Sahil Kudake
 *
 */
public class StockDetails {

	public String shareName;
	public int noOfShare;
	public float price;
	public String getShareName() {
		return shareName;
	}
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	public int getNoOfShare() {
		return noOfShare;
	}
	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "StockDetails [shareName=" + shareName + ", noOfShare=" + noOfShare + ", price=" + price + "]";
	}
	
	
}
