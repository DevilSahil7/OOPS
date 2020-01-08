package com.stockmanagement.stock;

import java.io.IOException;
import java.util.List;


import com.stockmanagement.controller.Controller;
import com.stockmanagement.model.StockDetails;
import com.stockmanagement.operations.Operations;
import com.stockmanagement.utility.Utility;

public class StockManagement {

	public static void main(String[] args) throws IOException {
		Operations operations = new Operations();
		Controller controller = new Controller();
		int choice;
		List<StockDetails> list = controller.readFile();
		System.out.println("++++++Stock Details++++++");
		for(StockDetails sd : list) {
			System.out.println("Stock value of "+sd.getShareName().toUpperCase()+" for 1 share is "+sd.getPrice());
			System.out.println("Total stock value of "+sd.getShareName().toUpperCase()+" for "+sd.getNoOfShare()+" shares is "+sd.getNoOfShare()*sd.getPrice());
		}
		System.out.println();
		do {
		System.out.println("1.Add stock\n2.Remove stock\n3.Calculate total share\n4.Calculate total share in market\nEnter your choice: ");
		choice = Utility.integerInput();
		switch(choice) {
		case 1:
			List<StockDetails> read1 = controller.readFile();
			List<StockDetails> list1 = operations.addStock(read1);
			controller.writeFile(list1);
			break;
		case 2:
			List<StockDetails> read2 = controller.readFile();
			List<StockDetails> list2 = operations.removeStock(read2);
			controller.writeFile(list2);
			break;
		case 3:
			List<StockDetails> read3 = controller.readFile();
			operations.totalShare(read3);
			break;
		case 4:
			List<StockDetails> read4 = controller.readFile();
			operations.totalShareMarket(read4);
			break;
		case 5:
			System.out.println("Thank you!");
			return;
			default:
				System.out.println("Enter correct choice!");
		}
		}while(choice!=5);

	}

}
