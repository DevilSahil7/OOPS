package com.commercialdataproccessing.dataprocessmanagement.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.commercialdataproccessing.dataprocessmanagement.model.CompanyDetails;
import com.commercialdataproccessing.dataprocessmanagement.model.CustomerDetails;
import com.commercialdataproccessing.dataprocessmanagement.model.TransactionDetails;

/**
 * Purpose: to read and write json files from storage
 * 
 * @author Sahil Kudake
 *
 */
public class Controller {

	CompanyDetails companyDetails = new CompanyDetails();
	CustomerDetails customerDetails = new CustomerDetails();
	static ObjectMapper mapper = new ObjectMapper();
	// accessing json files
	File file1 = new File("companyshare.json");
	File file2 = new File("customershare.json");
	File file3 = new File("transactions.json");

	public List<CompanyDetails> readFileCompany() throws JsonParseException, JsonMappingException, IOException { // reading company details json file
		List<CompanyDetails> read = mapper.readValue(file1, new TypeReference<List<CompanyDetails>>() { //mapping data with file
		});
		return read; // returning list of company data
	}

	@SuppressWarnings("deprecation")
	public void writeFileCompany(List<CompanyDetails> list)
			throws JsonGenerationException, JsonMappingException, IOException { //writing company details file in json file
		mapper.defaultPrettyPrintingWriter().writeValue(file1, list); //mapping data with json file
	}

	public List<CustomerDetails> readFileCustomer() throws JsonParseException, JsonMappingException, IOException { // reading customer details json file
		List<CustomerDetails> read = mapper.readValue(file2, new TypeReference<List<CustomerDetails>>() { //mapping data with file
		});
		return read; // returning list of customer data
	}

	@SuppressWarnings("deprecation")
	public void writeFileCustomer(List<CustomerDetails> list)
			throws JsonGenerationException, JsonMappingException, IOException { //writing company details file in json file
		mapper.defaultPrettyPrintingWriter().writeValue(file2, list); //mapping data with json file
	}

	public List<TransactionDetails> readFileTransaction() throws JsonParseException, JsonMappingException, IOException { // reading transaction details json file
		List<TransactionDetails> read = mapper.readValue(file3, new TypeReference<List<TransactionDetails>>() { //mapping data with file
		});
		return read; // returning list of transaction data
	}

	@SuppressWarnings("deprecation")
	public void writeFileTransaction(List<TransactionDetails> list)
			throws JsonGenerationException, JsonMappingException, IOException { //writing transaction details file in json file
		mapper.defaultPrettyPrintingWriter().writeValue(file3, list); //mapping data with json file
	}

}
