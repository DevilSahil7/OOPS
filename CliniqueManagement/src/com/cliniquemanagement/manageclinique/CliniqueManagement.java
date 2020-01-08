package com.cliniquemanagement.manageclinique;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cliniquemanagement.controller.Controller;
import com.cliniquemanagement.model.AppointmentDetails;
import com.cliniquemanagement.model.DoctorDetails;
import com.cliniquemanagement.model.PatientDetails;
import com.cliniquemanagement.operations.Operations;
import com.cliniquemanagement.utility.Utility;

public class CliniqueManagement {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Controller controller = new Controller();
		Operations operations = new Operations();
		int choice;
		do{
			System.out.println("++++++++Welcome to Clinique++++++++");
		
		System.out.println("1.Add Doctor\n2.Add Patient\n3.Doctor Details\n4.Patient Details\n5.Take Appointment\n6.Appointment Details\n7.Search Doctor\n8.Search Patient\n9.Exit\nEnter your choice: ");
		choice = Utility.integerInput();
		
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
			List<AppointmentDetails> read5 = controller.readFileAppoint();
			List<DoctorDetails> docList = controller.readFileDoc();
			List<PatientDetails> patList = controller.readFilePat();
			List<AppointmentDetails> list5 = operations.takeAppointment(read5, docList, patList);
			controller.writeFileAppoint(list5);
			
			break;
		case 6:
			List<AppointmentDetails> read6 = controller.readFileAppoint();
			operations.getAppointmentDetails(read6);
			break;
		case 7:
			List<DoctorDetails> read7 = controller.readFileDoc();
			operations.searchDoctor(read7);
			break;
		case 8:
			List<PatientDetails> read8 = controller.readFilePat();
			operations.searchPatient(read8);
			break;
		case 9:
			System.out.println("Thank you!");
			return;
		default:
			System.out.println("Enter correct choice!");
		}
		}while(choice!=9);

	}

}
