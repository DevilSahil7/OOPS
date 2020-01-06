package com.stockmanagement.operations;

import java.util.List;

import com.stockmanagement.model.StockDetails;
import com.stockmanagement.utility.Utility;

public class Operations {

	StockDetails stockDetails = new StockDetails();

	public List<StockDetails> addStock(List<StockDetails> list) {
		System.out.println("Enter name of stock: ");
		stockDetails.setShareName(Utility.stringInput());
		System.out.println("Enter number of stocks: ");
		stockDetails.setNoOfShare(Utility.integerInput());
		System.out.println("Enter price of stock: ");
		stockDetails.setPrice(Utility.integerInput());

		list.add(stockDetails);
		System.out.println("Details added successfully!");
		return list;
	}

	public List<StockDetails> removeStock(List<StockDetails> list) {
		System.out.println("Enter name of stock to remove: ");
		String nameOfStock = Utility.stringInput();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getShareName().equalsIgnoreCase(nameOfStock)) {
				list.remove(i);
				System.out.println("Stock removed!");
				break;
			}
		}
		return list;
	}

	public void totalShare(List<StockDetails> list) {
		System.out.println("Enter stock you want to calculate total: ");
		String stockName = Utility.stringInput();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getShareName().equalsIgnoreCase(stockName)) {
				float totalSharePrice = list.get(i).getPrice() * list.get(i).getNoOfShare();
				System.out.println("Total price of " + list.get(i).getShareName() + " is " + totalSharePrice);
				break;
			}
		}
	}

	public void totalShareMarket(List<StockDetails> list) {
		float temp = 0;
		for(int i = 0; i<list.size(); i++) {
			float totalShare = list.get(i).getNoOfShare()*list.get(i).getPrice();
			temp = temp+totalShare;
		}
		System.out.println("Total price of shares in market is: "+temp);
	}
}
