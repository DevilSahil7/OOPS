package com.stockmanagement.stock.operations;

import java.util.List;

import com.stockmanagement.stock.model.StockDetails;
import com.stockmanagement.stock.utility.Utility;

/**
 * Purpose: To perform different operations on stock
 * 
 * @author Sahil Kudake
 *
 */
public class Operations {

	StockDetails stockDetails = new StockDetails();

	public List<StockDetails> addStock(List<StockDetails> list) { //method to add new stock
		//taking required data from user
		System.out.println("Enter name of stock: ");
		stockDetails.setShareName(Utility.stringInput());
		System.out.println("Enter number of stocks: ");
		stockDetails.setNoOfShare(Utility.integerInput());
		System.out.println("Enter price of stock: ");
		stockDetails.setPrice(Utility.integerInput());
		list.add(stockDetails); //adding data to list
		System.out.println("Details added successfully!");
		return list; //returning list of data
	}

	public List<StockDetails> removeStock(List<StockDetails> list) { //method to remove stock from file
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getShareName()); //showing all data by name
		}
		System.out.println("Enter name of stock to remove: ");
		String nameOfStock = Utility.stringInput();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getShareName().equalsIgnoreCase(nameOfStock)) { //matching user input in list
				list.remove(i); //removing found data form list
				System.out.println("Stock removed!");
				break;
			}
		}
		return list;
	}

	public void totalShare(List<StockDetails> list) { //method to calculate total shares
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getShareName()); //showing all shares by name
		}
		System.out.println("Enter stock name you want to calculate total: ");
		String stockName = Utility.stringInput();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getShareName().equalsIgnoreCase(stockName)) { //matching user input in list of stock
				float totalSharePrice = list.get(i).getPrice() * list.get(i).getNoOfShare(); //calculating total share price
				System.out.println("Total price of " + list.get(i).getShareName() + " is " + totalSharePrice); //displaying total share price
				break;
			}
		}
	}

	public void totalShareMarket(List<StockDetails> list) { //method to calculate total share price in markent
		float temp = 0;
		for(int i = 0; i<list.size(); i++) {
			float totalShare = list.get(i).getNoOfShare()*list.get(i).getPrice(); //calculating price of each share
			temp = temp+totalShare; //adding price of each share to make grand total
		}
		System.out.println("Total price of shares in market is: "+temp); //showing grand total
	}
}
