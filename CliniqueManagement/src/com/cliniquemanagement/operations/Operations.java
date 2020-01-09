package com.cliniquemanagement.operations;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cliniquemanagement.controller.Controller;
import com.cliniquemanagement.model.AppointmentDetails;
import com.cliniquemanagement.model.DoctorDetails;
import com.cliniquemanagement.model.PatientDetails;
import com.cliniquemanagement.utility.Utility;

/**
 * Purpose: To perform operations of users choice
 * 
 * @author Sahil Kudake
 *
 */
public class Operations {

	DoctorDetails doctorDetails = new DoctorDetails();
	PatientDetails patientDetails = new PatientDetails();
	Controller controller = new Controller();
	AppointmentDetails appointmentDetails = new AppointmentDetails();

	public List<DoctorDetails> addDoctor(List<DoctorDetails> docList) { // method to add doctor details
		try {
			// taking required information from user
			System.out.println("Enter name of doctor: ");
			String docName = Utility.stringInput();
			doctorDetails.setDoctorName(Utility.stringValidation(docName)); // String validation for alphabet input only											
			System.out.println("Set ID for doctor: ");
			doctorDetails.setDoctorId(Utility.integerInput());
			System.out.println("Enter specialization of doctor: ");
			String docSpec = Utility.stringInput();
			doctorDetails.setSpecialization(Utility.stringValidation(docSpec));
			System.out.println("Enter availability of doctor: ");
			String avail = Utility.stringInput();
			doctorDetails.setAvailability(Utility.stringValidation(avail));
		} catch (InputMismatchException e) {
			System.out.println("Enter valid input!");
		}
		docList.add(doctorDetails); // adding data in list
		System.out.println("Details added successfully!");
		return docList; // returning list of doctor details
	}

	public List<PatientDetails> addPatient(List<PatientDetails> patList) {//method to add patients
		try {
			// taking required information from user
			System.out.println("Enter name of patient: ");
			String patName = Utility.stringInput();
			patientDetails.setPatientName(Utility.stringValidation(patName));
			System.out.println("Set ID for patient: ");
			patientDetails.setPatientId(Utility.integerInput());
			System.out.println("Enter mobile number of patient: ");
			patientDetails.setMobileNumber(Utility.longInput());
			System.out.println("Enter age of patient: ");
			patientDetails.setAge(Utility.integerInput());
		} catch (InputMismatchException e) {
			System.out.println("Enter valid input!");
		}
		patList.add(patientDetails);// adding data in list
		System.out.println("Data added successfully!");
		return patList;// returning list of patient details
	}

	public void getDoctorDetails(List<DoctorDetails> docList) {	//method to get details of doctor
		System.out.println("*****Doctor Details*****");
		//displaying all doctor details
		for (int i = 0; i < docList.size(); i++) { 
			System.out.println("Name: " + docList.get(i).getDoctorName() + "\nId: " + docList.get(i).getDoctorId()
					+ "\nSpecialization: " + docList.get(i).getSpecialization() + "\nAvailability: "
					+ docList.get(i).getAvailability() + "\nAppointments: " + docList.get(i).getAppointment());
			System.out.println();
		}
	}

	public void getPatientDetails(List<PatientDetails> patList) {	//method to get details of patients
		System.out.println("*****Patient Details*****");
		//displaying all patient details
		for (int i = 0; i < patList.size(); i++) {
			System.out.println("Name: " + patList.get(i).getPatientName() + "\nId: " + patList.get(i).getPatientId()
					+ "\nMobile number: " + patList.get(i).getMobileNumber() + "\nAge: " + patList.get(i).getAge());
			System.out.println();
		}
	}

	public List<AppointmentDetails> takeAppointment(List<AppointmentDetails> appointList, List<DoctorDetails> docList,
			List<PatientDetails> patList) throws JsonGenerationException, JsonMappingException, IOException {// method to book appointment
		try {
			System.out.println("available doctors are: ");
			getDoctorDetails(docList);
			System.out.println("choose available doctor: ");	//choosing available doctor
			String docName = Utility.stringValidation(Utility.stringInput());
			for (int i = 0; i < docList.size(); i++) {
				if (docList.get(i).getDoctorName().equalsIgnoreCase(docName)) { //if doctor found, booking appointment
					if (docList.get(i).getAppointment() <= 5) { //a doctor should take only 5 patients
						//asking for patient details
						System.out.println("Enter name of patient: ");
						String patientName = Utility.stringValidation(Utility.stringInput());
						patientDetails.setPatientName(patientName);
						appointmentDetails.setPatientName(patientName);
						patientDetails.setAssignDocotor(docName);
						System.out.println("Enter mobile number of patient: ");
						patientDetails.setMobileNumber(Utility.longInput());
						System.out.println("Enter age of patient: ");
						patientDetails.setAge(Utility.integerInput());
						patientDetails.setPatientId(patList.size() + 1);
						int appointment = docList.get(i).getAppointment();
						appointment = appointment + 1; //increasing doctors appointment
						//setting data to fields of doctor and patient
						docList.get(i).setAppointment(appointment);
						appointmentDetails.setDoctorAppointment(appointment);
						appointmentDetails.setPatientId(patList.size() + 1);
						appointmentDetails.setDoctorName(docName);
						appointmentDetails.setDoctorSpecialization(docList.get(i).getSpecialization());
						appointmentDetails.setDoctorAvailability(docList.get(i).getAvailability());
						System.out.println("Appointment booked!!!");
						break;
					} else {	//if more than 5 patients, booking appointment for next day
						System.out.println("Appointment full!!\nPlease take tomorrows appointment");
						System.out.println("Enter name of patient: ");
						String patientName = Utility.stringValidation(Utility.stringInput());
						patientDetails.setPatientName(patientName);
						appointmentDetails.setPatientName(patientName);
						patientDetails.setAssignDocotor(docName);
						System.out.println("Enter mobile number of patient: ");
						patientDetails.setMobileNumber(Utility.longInput());
						System.out.println("Enter age of patient: ");
						patientDetails.setAge(Utility.integerInput());
						patientDetails.setPatientId(patList.size() + 1);
						appointmentDetails.setPatientId(patList.size() + 1);
						appointmentDetails.setDoctorName(docName);
						appointmentDetails.setDoctorSpecialization(docList.get(i).getSpecialization());
						appointmentDetails.setDoctorAvailability(docList.get(i).getAvailability());
						System.out.println("Appointment booked!!!");
					}
				}
			}
			patList.add(patientDetails);
			appointList.add(appointmentDetails);
			controller.writeFileDoc(docList); //writing doctor details in json file of doctor
			controller.writeFilePat(patList); //writing patient details in json file of patient

		} catch (InputMismatchException e) {
			System.out.println("Enter valid input!");
		}
		return appointList;	//returning list of appointment details
	}

	public void getAppointmentDetails(List<AppointmentDetails> appointList) {	//method to get detail of appointments
		for (int i = 0; i < appointList.size(); i++) {	//showing details one by one
			System.out.println("Doctor Name: " + appointList.get(i).getDoctorName() + "\nPatient Name: "
					+ appointList.get(i).getPatientName() + "\nDoctor Specialization: "
					+ appointList.get(i).getDoctorSpecialization() + "\nDoctor Availability: "
					+ appointList.get(i).getDoctorAvailability());
			System.out.println();
		}
	}

	public void searchDoctor(List<DoctorDetails> docList) {	//method to search of doctors
		for (int i = 0; i < docList.size(); i++) {
			System.out.println(docList.get(i).getDoctorName());	//showing list of doctors
		}
		System.out.println("Enter name of doctor: ");
		String docName = Utility.stringInput();
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getDoctorName().equalsIgnoreCase(docName)) {	//searching name of doctor in list
				//displaying details of particular doctor
				System.out.println("Name: " + docList.get(i).getDoctorName() + "\nId: " + docList.get(i).getDoctorId()
						+ "\nSpecialization: " + docList.get(i).getSpecialization() + "\nAvailability: "
						+ docList.get(i).getAvailability() + "\nAppointments: " + docList.get(i).getAppointment());
				break;
			}
		}
	}

	public void searchPatient(List<PatientDetails> patList) {	//method to seatch patient
		for (int i = 0; i < patList.size(); i++) {
			System.out.println(patList.get(i).getPatientName());	//showing list of patients
		}
		System.out.println("Enter name of patient: ");
		String patName = Utility.stringInput();
		for (int i = 0; i < patList.size(); i++) {
			if (patList.get(i).getPatientName().equalsIgnoreCase(patName)) {	//searching name of patient in list
				//displaying details of particular doctor
				System.out.println("Name: " + patList.get(i).getPatientName() + "\nID: " + patList.get(i).getPatientId()
						+ "\nMobile number: " + patList.get(i).getMobileNumber() + "\nAge: " + patList.get(i).getAge()
						+ "\nAssigned doctor: " + patList.get(i).getAssignDocotor());
			}
		}
	}

}
