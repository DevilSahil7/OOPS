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

/**
 * Purpose: To read and write json file from storage
 * 
 * @author Sahil Kudake
 *
 */
public class Controller {

	PersonDetails person = new PersonDetails();
	static ObjectMapper mapper = new ObjectMapper(); // using jackson mapper to map the data with specified file
	File file = new File("AddressBook.json"); // accessing json file

	public List<PersonDetails> readFile() throws JsonParseException, JsonMappingException, IOException { // reading json
																											// file
		List<PersonDetails> person = mapper.readValue(file, new TypeReference<List<PersonDetails>>() { // mapping data
																										// with file
		});
		return person; // returning list of person
	}

	public void writeFile(List<PersonDetails> listOfPerson) // writing data to json file
			throws JsonGenerationException, JsonProcessingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(file, listOfPerson); // mappping data with json file
	}
}
