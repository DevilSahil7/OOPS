package com.stockmanagement.stock;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.stockmanagement.stock.controller.Controller;
import com.stockmanagement.stock.model.StockDetails;
import com.stockmanagement.stock.operations.Operations;

/**
 * Purpose: To manage stock reposrt of company and users
 * 
 * @author Sahil Kudake
 *
 */
public class StockManagement {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Operations operations = new Operations();
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		List<StockDetails> list = controller.readFile(); //reading json file 
		System.out.println("++++++Stock Details++++++");
		//showing all stock details
		for(StockDetails sd : list) {
			System.out.println("Stock value of "+sd.getShareName().toUpperCase()+" for 1 share is "+sd.getPrice());
			System.out.println("Total stock value of "+sd.getShareName().toUpperCase()+" for "+sd.getNoOfShare()+" shares is "+sd.getNoOfShare()*sd.getPrice());
		}
		System.out.println();
		do {
			//performing different operations by users choice
		System.out.println("1.Add stock\n2.Remove stock\n3.Calculate total share\n4.Calculate total share in market\nEnter your choice: ");
		try {
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			List<StockDetails> read1 = controller.readFile(); //reading json file
			List<StockDetails> list1 = operations.addStock(read1); //method to add new stock
			controller.writeFile(list1); //writing data in json file
			break;
		case 2:
			List<StockDetails> read2 = controller.readFile(); //reading json file
			List<StockDetails> list2 = operations.removeStock(read2); //method to remove stock
			controller.writeFile(list2);	//writing data in json file
			break;
		case 3:
			List<StockDetails> read3 = controller.readFile(); //reading json file
			operations.totalShare(read3); //method to calculate total shares
			break;
		case 4:
			List<StockDetails> read4 = controller.readFile(); //reading json file
			operations.totalShareMarket(read4); //method to calculate total shares in market
			break;
		case 5:
			System.out.println("Thank you!");
			return;
			default:
				System.out.println("Enter correct choice!");
		}
		}catch (InputMismatchException e) {
			System.out.println("Enter integers only!");
			sc.next();
		}
		}while(choice!=5);

	}

}
