package com.addressbook.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.addressbook.model.PersonDetails;


public class Controller {

	PersonDetails person = new PersonDetails();
	static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
	}
	File file = new File("AddressBook.json");
	
	public List<PersonDetails> readFile() throws JsonParseException, JsonMappingException, IOException{
		List<PersonDetails> person = mapper.readValue(file, new TypeReference <List<PersonDetails>>() {});
		return person;
	}
	
	public void writeFile(List<PersonDetails> listOfPerson) throws JsonGenerationException, JsonProcessingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file, listOfPerson);
	}
}
