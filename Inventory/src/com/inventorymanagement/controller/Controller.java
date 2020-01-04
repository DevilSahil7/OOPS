package com.inventorymanagement.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.inventorymanagement.model.Properties;

public class Controller {

	Properties properties = new Properties();
	static ObjectMapper mapper = new ObjectMapper();
	File file = new File("inventory.json");
	
	public List<Properties> readFile() throws IOException{
		List<Properties> list = mapper.readValue(file, new TypeReference <List<Properties>>() {});
		return list;
	}
	
	public void writeFile(List<Properties> list) throws IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file, list);
	}
}
