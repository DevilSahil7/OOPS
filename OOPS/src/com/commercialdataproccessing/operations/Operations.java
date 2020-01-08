package com.commercialdataproccessing.operations;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.commercialdataproccessing.controller.Controller;
import com.commercialdataproccessing.model.CompanyDetails;
import com.commercialdataproccessing.model.CustomerDetails;
import com.commercialdataproccessing.model.TransactionDetails;
import com.commercialdataproccessing.utility.Utility;

public class Operations {

	CompanyDetails companyDetails = new CompanyDetails();
	CustomerDetails customerDetails = new CustomerDetails();
	TransactionDetails transactionDetails = new TransactionDetails();
	Controller controller = new Controller();

	public List<CompanyDetails> addCompany(List<CompanyDetails> compList) {
		System.out.println("Enter the name of company: ");
		companyDetails.setCompanyName(Utility.stringInput());
		System.out.println("Enter shares of company: ");
		companyDetails.setNoOfShares(Utility.integerInput());
		System.out.println("Set price of 1 share: ");
		companyDetails.setPrice(Utility.floatInput());
		compList.add(companyDetails);
		System.out.println("Data added successfully!");
		return compList;
	}

	public List<CustomerDetails> addCustomer(List<CustomerDetails> custList) {
		System.out.println("Enter the name of customer: ");
		customerDetails.setCustName(Utility.stringInput());
		custList.add(customerDetails);
		System.out.println("Data added successfully!");
		return custList;
	}

	public List<CustomerDetails> sellShare(List<CompanyDetails> compList, List<CustomerDetails> custList,
			List<TransactionDetails> txnList) throws JsonGenerationException, JsonMappingException, IOException {
		for (int i = 0; i < compList.size(); i++) {
			System.out.println(compList.get(i).getCompanyName());
		}
		int temp = 0;
		int findCust = 0;
		int findComp = 0;
		System.out.println("Enter name of company to sell shares: ");
		String compName = Utility.stringInput();
		for (int i = 0; i < compList.size(); i++) {
			if (compList.get(i).getCompanyName().equalsIgnoreCase(compName)) {
				findComp = 1;
				transactionDetails.setCompanyName(compName);
				for (int j = 0; j < custList.size(); j++) {
					System.out.println(custList.get(j).getCustName() + " " + custList.get(j).getNoOfShares());
				}
				System.out.println("Enter customer name to sell shares: ");
				String custName = Utility.stringInput();
				for (int j = 0; j < custList.size(); j++) {
					if (custList.get(j).getCustName().equalsIgnoreCase(custName)) {
						findCust = 1;
						transactionDetails.setCustomerName(custName);
						System.out.println("your available shares are " + custList.get(j).getNoOfShares());
						System.out.println("Enter number of shares to sell: ");
						int numOfShare = Utility.integerInput();
						if (numOfShare <= custList.get(j).getNoOfShares()) {
							temp = 1;
							int custRemainingShares = custList.get(j).getNoOfShares() - numOfShare;
							System.out.println("After selling " + numOfShare + " shares, remaining shares of "
									+ custList.get(j).getCustName() + " are " + custRemainingShares);
							int compRemainingShares = compList.get(i).getNoOfShares() + numOfShare;
							System.out.println("After selling " + numOfShare + " shares, remaining shares of "
									+ compList.get(i).getCompanyName() + " are " + compRemainingShares);
							LocalDateTime datetime = LocalDateTime.now();
							custList.get(j).setNoOfShares(custRemainingShares);
							compList.get(i).setNoOfShares(compRemainingShares);
							transactionDetails.setNoOfCustomerShares(custRemainingShares);
							transactionDetails.setNoOfCompanyShares(compRemainingShares);
							transactionDetails.setDatetime(datetime);
						}
						if (temp == 0) {
							System.out.println("You dont have enough shares to sell!");
						}
					}
				}
				if (findCust == 0) {
					System.out.println("User not found!");
				}
				break;
			}
		}
		if (findComp == 0) {
			System.out.println("Company not found!");
		}
		txnList.add(transactionDetails);
		controller.writeFileCompany(compList);
		controller.writeFileTransaction(txnList);
		return custList;
	}

	public List<CustomerDetails> buyShare(List<CompanyDetails> compList, List<CustomerDetails> custList,
			List<TransactionDetails> txnList) throws JsonGenerationException, JsonMappingException, IOException {
		for (int i = 0; i < compList.size(); i++) {
			System.out.println(compList.get(i).getCompanyName() + " " + compList.get(i).getNoOfShares());
		}
		int temp = 0;
		int findCust = 0;
		int findComp = 0;
		System.out.println("Enter name of company to buy shares: ");
		String compName = Utility.stringInput();
		for (int i = 0; i < compList.size(); i++) {
			if (compList.get(i).getCompanyName().equalsIgnoreCase(compName)) {
				findComp = 1;
				transactionDetails.setCompanyName(compName);
				for (int j = 0; j < custList.size(); j++) {
					System.out.println(custList.get(j).getCustName());
				}
				System.out.println("Enter customer name to buy shares: ");
				String custName = Utility.stringInput();
				for (int j = 0; j < custList.size(); j++) {
					if (custList.get(j).getCustName().equalsIgnoreCase(custName)) {
						findCust = 1;
						transactionDetails.setCustomerName(custName);
						System.out.println("available shares of company " + compList.get(i).getNoOfShares());
						System.out.println("Enter number of shares to buy: ");
						int numOfShares = Utility.integerInput();
						if (numOfShares <= compList.get(i).getNoOfShares()) {
							temp = 1;
							int custRemainingShares = custList.get(j).getNoOfShares() + numOfShares;
							System.out.println("After buying " + numOfShares + " shares, total shares of "
									+ custList.get(j).getCustName() + " are " + custRemainingShares);
							int compRemainingShares = compList.get(i).getNoOfShares() - numOfShares;
							System.out.println("After buying " + numOfShares + " shares, remaining shares of "
									+ compList.get(i).getCompanyName() + " are " + compRemainingShares);
							LocalDateTime datetime = LocalDateTime.now();
							custList.get(j).setNoOfShares(custRemainingShares);
							compList.get(i).setNoOfShares(compRemainingShares);
							transactionDetails.setNoOfCustomerShares(custRemainingShares);
							transactionDetails.setNoOfCompanyShares(compRemainingShares);
							transactionDetails.setDatetime(datetime);
						}
						if (temp == 0) {
							System.out.println("you are crossing the limit of company shares!");
						}
					}
				}
				if (findCust == 0) {
					System.out.println("User not found!");
				}
				break;
			}
		}
		if (findComp == 0) {
			System.out.println("Company not found!");
		}
		txnList.add(transactionDetails);
		controller.writeFileCompany(compList);
		controller.writeFileTransaction(txnList);
		return custList;
	}

	public int totalSharesOfCompanies(List<CompanyDetails> compList) {
		int allShares = 0;
		for (int i = 0; i < compList.size(); i++) {
			System.out.println("Name: "+compList.get(i).getCompanyName()+"\nShares: "+compList.get(i).getNoOfShares());
			allShares = allShares + compList.get(i).getNoOfShares();
		}
		return allShares;
	}

	public int totalSharesOfCustomers(List<CustomerDetails> custList) {
		int allShares = 0;
		for (int i = 0; i < custList.size(); i++) {
			System.out.println("Name: "+custList.get(i).getCustName()+"\nShares: "+custList.get(i).getNoOfShares());
			allShares = allShares + custList.get(i).getNoOfShares();
		}
		return allShares;
	}

}
