package com.cliniquemanagement.manageclinique;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cliniquemanagement.manageclinique.controller.Controller;
import com.cliniquemanagement.manageclinique.model.AppointmentDetails;
import com.cliniquemanagement.manageclinique.model.DoctorDetails;
import com.cliniquemanagement.manageclinique.model.PatientDetails;
import com.cliniquemanagement.manageclinique.operations.Operations;
import com.cliniquemanagement.manageclinique.utility.Utility;

/**
 * Purpose: To perform clinique operations
 * 
 * @author Sahil Kudake
 *
 */
public class CliniqueManagement {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Controller controller = new Controller();
		Operations operations = new Operations();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("++++++++Welcome to Clinique++++++++");

			System.out.println("1.Add Doctor\n2.Add Patient\n3.Doctor Details\n4.Patient Details\n"
					+ "5.Take Appointment\n6.Appointment Details\n7.Search Doctor\n8.Search Patient\n9.Exit\nEnter your choice: ");
			try {
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					List<DoctorDetails> read1 = controller.readFileDoc(); // reading json file
					List<DoctorDetails> list1 = operations.addDoctor(read1); // method to add doctor
					controller.writeFileDoc(list1); // writing list of doctor in json file
					break;
				case 2:
					List<PatientDetails> read2 = controller.readFilePat();// reading json file
					List<PatientDetails> list2 = operations.addPatient(read2); // method to add patient
					controller.writeFilePat(list2); // writing list of patient in json file
					break;
				case 3:
					List<DoctorDetails> read3 = controller.readFileDoc();// reading json file
					operations.getDoctorDetails(read3); // method to get doctor details
					break;
				case 4:
					List<PatientDetails> read4 = controller.readFilePat();// reading json file
					operations.getPatientDetails(read4); // method to get patient details
					break;
				case 5:
					List<AppointmentDetails> read5 = controller.readFileAppoint();// reading json file
					List<DoctorDetails> docList = controller.readFileDoc();
					List<PatientDetails> patList = controller.readFilePat();
					List<AppointmentDetails> list5 = operations.takeAppointment(read5, docList, patList);// method to
																											// take
																											// appointment
					controller.writeFileAppoint(list5); // writing list of appointments in json file

					break;
				case 6:
					List<AppointmentDetails> read6 = controller.readFileAppoint();// reading json file
					operations.getAppointmentDetails(read6); // method to get details of appointments
					break;
				case 7:
					List<DoctorDetails> read7 = controller.readFileDoc();// reading json file
					operations.searchDoctor(read7); // method to search doctor
					break;
				case 8:
					List<PatientDetails> read8 = controller.readFilePat();// reading json file
					operations.searchPatient(read8); // method to search patient
					break;
				case 9:
					System.out.println("Thank you!");
					return;
				default:
					System.out.println("Enter correct choice!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter integer only!");
				sc.next();
			}
		} while (choice != 9);

	}

}
