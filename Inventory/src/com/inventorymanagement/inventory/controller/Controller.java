package com.inventorymanagement.inventory.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.inventorymanagement.inventory.model.Properties;

/**
 * Purpose: To read and write json file from storage
 * 
 * @author Sahil Kudake
 *
 */
public class Controller {

	Properties properties = new Properties();
	static ObjectMapper mapper = new ObjectMapper(); // jackson mapper object to map data with json file
	File file = new File("inventory.json"); // accessing json file of inventory

	public List<Properties> readFile() throws IOException { // reading inventory json file
		List<Properties> list = mapper.readValue(file, new TypeReference<List<Properties>>() { //mapping data with json file
		});
		return list; //returning list of inventory
	}

	@SuppressWarnings("deprecation")
	public void writeFile(List<Properties> list) throws IOException {	//writing json file
		mapper.defaultPrettyPrintingWriter().writeValue(file, list); // writing data in inventory json file
	}
}
