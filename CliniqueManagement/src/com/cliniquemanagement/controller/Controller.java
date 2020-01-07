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

public class Controller {

	AppointmentDetails appointmentDetails = new AppointmentDetails();
	DoctorDetails doctorDetails = new DoctorDetails();
	PatientDetails patientDetails = new PatientDetails();
	
	static ObjectMapper mapper = new ObjectMapper();
	
	File docFile = new File("doctor.json");
	File patFile = new File("patient.json");
	File appointFile = new File("appointment.json");
	
	public List<DoctorDetails> readFileDoc() throws JsonParseException, JsonMappingException, IOException{
		List<DoctorDetails> read = mapper.readValue(docFile, new TypeReference<List<DoctorDetails>>() {});
		return read;
	}
	
	public void writeFileDoc(List<DoctorDetails> docList) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(docFile, docList);
	}
	
	public List<PatientDetails> readFilePat() throws JsonParseException, JsonMappingException, IOException{
		List<PatientDetails> read = mapper.readValue(patFile, new TypeReference<List<PatientDetails>>() {});
		return read;
	}
	
	public void writeFilePat(List<PatientDetails> patList) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(patFile, patList);
	}
	
	public List<AppointmentDetails> readFileAppoint() throws JsonParseException, JsonMappingException, IOException{
		List<AppointmentDetails> read = mapper.readValue(appointFile, new TypeReference<List<AppointmentDetails>>() {});
		return read;
	}
	
	public void writeFileAppoint(List<AppointmentDetails> appointList) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.defaultPrettyPrintingWriter().writeValue(appointFile, appointList);
	}
	
	
	
	
	
}
