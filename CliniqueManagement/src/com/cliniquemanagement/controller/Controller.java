package com.cliniquemanagement.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.cliniquemanagement.model.AppointmentDetails;
import com.cliniquemanagement.model.DoctorDetails;
import com.cliniquemanagement.model.PatientDetails;

/**
 * Purpose: To read and write json file from storage
 * 
 * 
 * @author Sahil Kudake
 *
 */
public class Controller {

	AppointmentDetails appointmentDetails = new AppointmentDetails();
	DoctorDetails doctorDetails = new DoctorDetails();
	PatientDetails patientDetails = new PatientDetails();
	
	static ObjectMapper mapper = new ObjectMapper(); //jackson mapper object to map the values with file
	
	//accessing json files of doctor, patient, appointment
	File docFile = new File("doctor.json");
	File patFile = new File("patient.json");
	File appointFile = new File("appointment.json");
	
	public List<DoctorDetails> readFileDoc() throws JsonParseException, JsonMappingException, IOException{	//reading doctor details file
		List<DoctorDetails> read = mapper.readValue(docFile, new TypeReference<List<DoctorDetails>>() {});	//mapping doctor data with doctor file
		return read; //returning list of doctor data
	}
	
	public void writeFileDoc(List<DoctorDetails> docList) throws JsonGenerationException, JsonMappingException, IOException {//writing doctor details file
		mapper.defaultPrettyPrintingWriter().writeValue(docFile, docList);	//writing doctor data into file
	}
	
	public List<PatientDetails> readFilePat() throws JsonParseException, JsonMappingException, IOException{ //reading patient file
		List<PatientDetails> read = mapper.readValue(patFile, new TypeReference<List<PatientDetails>>() {});// mapping patient data with patient file
		return read; //returning list of patient data
	}
	
	public void writeFilePat(List<PatientDetails> patList) throws JsonGenerationException, JsonMappingException, IOException {//writing patient details file
		mapper.defaultPrettyPrintingWriter().writeValue(patFile, patList);	//writing patient data into file
	}
	
	public List<AppointmentDetails> readFileAppoint() throws JsonParseException, JsonMappingException, IOException{//reading appointment file
		List<AppointmentDetails> read = mapper.readValue(appointFile, new TypeReference<List<AppointmentDetails>>() {});//mapping appointment file with appointment file
		return read;// returning list of appointments
	}
	
	public void writeFileAppoint(List<AppointmentDetails> appointList) throws JsonGenerationException, JsonMappingException, IOException {//writing appointment file
		mapper.defaultPrettyPrintingWriter().writeValue(appointFile, appointList);	//writing appointment data into file
	}
}
