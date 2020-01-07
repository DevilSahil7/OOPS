package com.cliniquemanagement.operations;

import java.util.List;

import com.cliniquemanagement.model.AppointmentDetails;
import com.cliniquemanagement.model.DoctorDetails;
import com.cliniquemanagement.model.PatientDetails;
import com.cliniquemanagement.utility.Utility;

public class Operations {

	DoctorDetails doctorDetails = new DoctorDetails();
	PatientDetails patientDetails = new PatientDetails();

	public List<DoctorDetails> addDoctor(List<DoctorDetails> docList) {
		System.out.println("Enter name of doctor: ");
		doctorDetails.setDoctorName(Utility.stringInput());
		System.out.println("Set ID for doctor: ");
		doctorDetails.setDoctorId(Utility.integerInput());
		System.out.println("Enter specialization of doctor: ");
		doctorDetails.setSpecialization(Utility.stringInput());
		System.out.println("Enter availability of doctor: ");
		doctorDetails.setAvailability(Utility.stringInput());
		
		docList.add(doctorDetails);
		System.out.println("Details added successfully!");
		return docList;
	}

	public List<PatientDetails> addPatient(List<PatientDetails> patList) {
		System.out.println("Enter name of patient: ");
		patientDetails.setPatientName(Utility.stringInput());
		System.out.println("Set ID for patient: ");
		patientDetails.setPatientId(Utility.integerInput());
		System.out.println("Enter mobile number of patient: ");
		patientDetails.setMobileNumber(Utility.longInput());
		System.out.println("Enter age of patient: ");
		patientDetails.setAge(Utility.integerInput());
		

		patList.add(patientDetails);
		System.out.println("Data added successfully!");
		return patList;
	}

	public void getDoctorDetails(List<DoctorDetails> docList) {
		System.out.println("*****Doctor Details*****");
		for (int i = 0; i < docList.size(); i++) {
			System.out.println("Name: " + docList.get(i).getDoctorName() + "\nId: " + docList.get(i).getDoctorId()
					+ "\nSpecialization: " + docList.get(i).getSpecialization() + "\nAvailability: "
					+ docList.get(i).getAvailability() + "\nAppointments: " + docList.get(i).getAppointment());
			System.out.println();
		}
	}

	public void getPatientDetails(List<PatientDetails> patList) {
		System.out.println("*****Patient Details*****");
		for (int i = 0; i < patList.size(); i++) {
			System.out.println("Name: " + patList.get(i).getPatientName() + "\nId: " + patList.get(i).getPatientId()
					+ "\nMobile number: " + patList.get(i).getMobileNumber() + "\nAge: " + patList.get(i).getAge());
			System.out.println();
		}
	}
	
	public List<AppointmentDetails> takeAppointment(List<AppointmentDetails> appointList, List<DoctorDetails> docList, List<PatientDetails> patList){
		System.out.println("available doctors are: ");
		getDoctorDetails(docList);
		System.out.println("Enter name of patient: ");
		patientDetails.setPatientName(Utility.stringInput());
		System.out.println("choose available doctor: ");
		String docName = Utility.stringInput();
		if(doctorDetails.getDoctorName().equalsIgnoreCase(docName)) {
			if(doctorDetails.getAppointment()<=5) {
				patientDetails.setAssignDocotor(Utility.stringInput());
				int appointment = doctorDetails.getAppointment();
				appointment = appointment+1;
				doctorDetails.setAppointment(appointment);
			}
			else {
				System.out.println("appointment full!!");
			}
		}
		patList.add(patientDetails);
		docList.add(doctorDetails);
		return appointList;
		
		
		
		
	}

}
