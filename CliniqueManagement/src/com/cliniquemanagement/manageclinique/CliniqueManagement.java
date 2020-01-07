package com.cliniquemanagement.manageclinique;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cliniquemanagement.controller.Controller;
import com.cliniquemanagement.model.DoctorDetails;
import com.cliniquemanagement.model.PatientDetails;
import com.cliniquemanagement.operations.Operations;
import com.cliniquemanagement.utility.Utility;

public class CliniqueManagement {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Controller controller = new Controller();
		Operations operations = new Operations();
		
		System.out.println("1.Add Doctor\n2.Add Patient\n3.Doctor Details\n4.Patient Details\n5.Take Appointment\n6.Appointment Details\nEnter your choice: ");
		int choice = Utility.integerInput();
		
		switch(choice) {
		case 1:
			List<DoctorDetails> read1 = controller.readFileDoc();
			List<DoctorDetails> list1 = operations.addDoctor(read1);
			controller.writeFileDoc(list1);
			break;
		case 2:
			List<PatientDetails> read2 = controller.readFilePat();
			List<PatientDetails> list2 = operations.addPatient(read2);
			controller.writeFilePat(list2);
			break;
		case 3:
			List<DoctorDetails> read3 = controller.readFileDoc();
			operations.getDoctorDetails(read3);
			break;
		case 4:
			List<PatientDetails> read4 = controller.readFilePat();
			operations.getPatientDetails(read4);
			break;
		case 5:
			
			
			break;
		case 6:
			
			
			break;
		default:
			System.out.println("Enter correct choice!");
		}

	}

}
