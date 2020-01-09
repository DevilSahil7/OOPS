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

/**
 * Purpose: to read and write json files from storage
 * 
 * @author Sahil Kudake
 *
 */
public class Controller {

	StockDetails stockDetails = new StockDetails();
	static ObjectMapper mapper = new ObjectMapper();

	File file = new File("companyshare.json"); // accessing json file

	public List<StockDetails> readFile() throws JsonParseException, JsonMappingException, IOException { // reading json file
		List<StockDetails> read = mapper.readValue(file, new TypeReference<List<StockDetails>>() { //mapping file with data
		}); 
		return read; //returning list of data
	}

	public void writeFile(List<StockDetails> list) throws JsonGenerationException, JsonMappingException, IOException { //writing data in json file
		mapper.defaultPrettyPrintingWriter().writeValue(file, list); //mapping data in file to write in json file
	}

}
