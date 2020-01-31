package com.commercialdataproccessing.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.commercialdataproccessing.model.CompanyDetails;
import com.commercialdataproccessing.model.CustomerDetails;
import com.commercialdataproccessing.model.TransactionDetails;


public class Controller {

	CompanyDetails companyDetails = new CompanyDetails();
	CustomerDetails customerDetails = new CustomerDetails();
	static ObjectMapper mapper = new ObjectMapper();
	File file1 = new File("companyshare.json");
	File file2 = new File("customershare.json");
	File file3 = new File("transactions.json");
	
	public List<CompanyDetails> readFileCompany() throws JsonParseException, JsonMappingException, IOException{
		List<CompanyDetails> read = mapper.readValue(file1, new TypeReference<List<CompanyDetails>>() {});
		return read;
	}
	
	public void writeFileCompany(List<CompanyDetails> list) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file1, list);
	}
	
	
	public List<CustomerDetails> readFileCustomer() throws JsonParseException, JsonMappingException, IOException{
		List<CustomerDetails> read = mapper.readValue(file2, new TypeReference<List<CustomerDetails>>() {});
		return read;
	}
	
	public void writeFileCustomer(List<CustomerDetails> list) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file2, list);
	}
	
	public List<TransactionDetails> readFileTransaction() throws JsonParseException, JsonMappingException, IOException{
		List<TransactionDetails> read = mapper.readValue(file3, new TypeReference<List<TransactionDetails>>() {});
		return read;
	}
	
	public void writeFileTransaction(List<TransactionDetails> list) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file3, list);
	}
	
}
