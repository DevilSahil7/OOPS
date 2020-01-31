package com.stockmanagement.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.stockmanagement.model.StockDetails;

public class Controller {

	StockDetails stockDetails = new StockDetails();
	static ObjectMapper mapper = new ObjectMapper();
	
	File file = new File("companyshare.json");
	public List<StockDetails> readFile() throws JsonParseException, JsonMappingException, IOException{
		List<StockDetails> read = mapper.readValue(file, new TypeReference<List<StockDetails>>() {});
		return read;
	}
	
	public void writeFile(List<StockDetails> list) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file, list);
	}
	
}
