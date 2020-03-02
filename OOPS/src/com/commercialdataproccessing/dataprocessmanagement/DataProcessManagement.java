package com.commercialdataproccessing.dataprocessmanagement;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.commercialdataproccessing.dataprocessmanagement.controller.Controller;
import com.commercialdataproccessing.dataprocessmanagement.model.CompanyDetails;
import com.commercialdataproccessing.dataprocessmanagement.model.CustomerDetails;
import com.commercialdataproccessing.dataprocessmanagement.model.TransactionDetails;
import com.commercialdataproccessing.dataprocessmanagement.operations.Operations;

/**
 * Purpose: To manage data processing of the stocks
 * 
 * @author Sahil Kudake
 *
 */
public class DataProcessManagement {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Controller controller = new Controller();
		Operations operations = new Operations();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1.Add company\n2.Add customer\n3.Buy share from company\n4.Sell share to company\n"
					+ "5.Total shares of all companies\n6.Total shares of all customers\n7.Exit\nEnter your choice: ");
			try {
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					List<CompanyDetails> read1 = controller.readFileCompany(); //reading json file of company
					List<CompanyDetails> list1 = operations.addCompany(read1); //method to add company
					controller.writeFileCompany(list1); //writing json file
					break;
				case 2:
					List<CustomerDetails> read2 = controller.readFileCustomer();//reading json file of customer
					List<CustomerDetails> list2 = operations.addCustomer(read2);//method to add company
					controller.writeFileCustomer(list2);//writing json file
					break;
				case 3:
					List<CompanyDetails> read5 = controller.readFileCompany();//reading json file of company
					List<CustomerDetails> read6 = controller.readFileCustomer();//reading json file of customer
					List<TransactionDetails> transactionList1 = new LinkedList<>();
					List<CustomerDetails> customerList1 = operations.buyShare(read5, read6, transactionList1); //method to buy shares
					controller.writeFileCustomer(customerList1);//writing json file
					break;
				case 4:
					List<CompanyDetails> read3 = controller.readFileCompany();//reading json file of company
					List<CustomerDetails> read4 = controller.readFileCustomer();//reading json file of customer
					List<TransactionDetails> transactionList = new LinkedList<>();
					List<CustomerDetails> customerList = operations.sellShare(read3, read4, transactionList); //method to sell shares
					controller.writeFileCustomer(customerList);//writing json file
					break;
				case 5:
					List<CompanyDetails> read7 = controller.readFileCompany();//reading json file of company
					int noOfStocksComp = operations.totalSharesOfCompanies(read7); //method to calculate total shares of company
					System.out.println("Total number of stocks of all companies are: " + noOfStocksComp);
					break;
				case 6:
					List<CustomerDetails> read8 = controller.readFileCustomer();//reading json file of customer
					int noOfStocksCust = operations.totalSharesOfCustomers(read8); //method to calculate total shares of customer
					System.out.println("Total number of stocks of all customers are: " + noOfStocksCust);
					break;
				case 7:
					System.out.println("Thank you!");
					return;

				default:
					System.out.println("Enter correct choice");
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter integer only");
				sc.next();
			}
		} while (choice != 7);
	}

}
