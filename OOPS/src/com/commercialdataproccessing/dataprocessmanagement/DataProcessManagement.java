package com.commercialdataproccessing.dataprocessmanagement;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.commercialdataproccessing.controller.Controller;
import com.commercialdataproccessing.model.CompanyDetails;
import com.commercialdataproccessing.model.CustomerDetails;
import com.commercialdataproccessing.model.TransactionDetails;
import com.commercialdataproccessing.operations.Operations;
import com.commercialdataproccessing.utility.Utility;

public class DataProcessManagement {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Controller controller = new Controller();
		Operations operations = new Operations();
		
		System.out.println("1.Add company\n2.Add customer\n3.Buy share from company\n4.Sell share to company\n"+
		"5.Total shares of all companies\n6.Total shares of all customers\nEnter your choice: ");
		int choice = Utility.integerInput();
		
		switch(choice) {
		case 1:
			List<CompanyDetails> read1 = controller.readFileCompany();
			List<CompanyDetails> list1 = operations.addCompany(read1);
			controller.writeFileCompany(list1);
			break;
			
		case 2:
			List<CustomerDetails> read2 = controller.readFileCustomer();
			List<CustomerDetails> list2 = operations.addCustomer(read2);
			controller.writeFileCustomer(list2);
			break;
			
		case 3:
			List<CompanyDetails> read5 = controller.readFileCompany();
			List<CustomerDetails> read6 = controller.readFileCustomer();
			List<TransactionDetails> transactionList1 = new LinkedList<>();
			List<CustomerDetails> customerList1 = operations.buyShare(read5, read6, transactionList1);
			controller.writeFileCustomer(customerList1);
			break;
			
		case 4:
			List<CompanyDetails> read3 = controller.readFileCompany();
			List<CustomerDetails> read4 = controller.readFileCustomer();
			List<TransactionDetails> transactionList = new LinkedList<>();
			List<CustomerDetails> customerList = operations.sellShare(read3, read4, transactionList);
			controller.writeFileCustomer(customerList);
			break;
			
		case 5:
			List<CompanyDetails> read7 = controller.readFileCompany();
			int noOfStocksComp = operations.totalSharesOfCompanies(read7);
			System.out.println("Total number of stocks of all companies are: "+noOfStocksComp);
			break;
			
		case 6:
			List<CustomerDetails> read8 = controller.readFileCustomer();
			int noOfStocksCust = operations.totalSharesOfCustomers(read8);
			System.out.println("Total number of stocks of all companies are: "+noOfStocksCust);
			break;
			
		default:
			System.out.println("Enter correct choice");
		}
	}

}
