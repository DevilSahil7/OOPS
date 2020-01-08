package com.cliniquemanagement.operations;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.cliniquemanagement.controller.Controller;
import com.cliniquemanagement.model.AppointmentDetails;
import com.cliniquemanagement.model.DoctorDetails;
import com.cliniquemanagement.model.PatientDetails;
import com.cliniquemanagement.utility.Utility;

public class Operations {

	DoctorDetails doctorDetails = new DoctorDetails();
	PatientDetails patientDetails = new PatientDetails();
	Controller controller = new Controller();
	AppointmentDetails appointmentDetails = new AppointmentDetails();

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

	public List<AppointmentDetails> takeAppointment(List<AppointmentDetails> appointList, List<DoctorDetails> docList,
			List<PatientDetails> patList) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("available doctors are: ");
		getDoctorDetails(docList);

		System.out.println("choose available doctor: ");
		String docName = Utility.stringInput();
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getDoctorName().equalsIgnoreCase(docName)) {
				if (docList.get(i).getAppointment() <= 5) {
					System.out.println("Enter name of patient: ");
					String patientName = Utility.stringInput();
					patientDetails.setPatientName(patientName);
					appointmentDetails.setPatientName(patientName);
					patientDetails.setAssignDocotor(docName);
					System.out.println("Enter mobile number of patient: ");
					patientDetails.setMobileNumber(Utility.longInput());
					System.out.println("Enter age of patient: ");
					patientDetails.setAge(Utility.integerInput());
					patientDetails.setPatientId(patList.size() + 1);
					int appointment = docList.get(i).getAppointment();
					appointment = appointment + 1;

					docList.get(i).setAppointment(appointment);
					appointmentDetails.setDoctorAppointment(appointment);
					appointmentDetails.setPatientId(patList.size() + 1);
					appointmentDetails.setDoctorName(docName);
					appointmentDetails.setDoctorSpecialization(docList.get(i).getSpecialization());
					appointmentDetails.setDoctorAvailability(docList.get(i).getAvailability());
					System.out.println("Appointment booked!!!");
					break;
				} else {
					System.out.println("Appointment full!!\nPlease take tomorrows appointment");
					System.out.println("Enter name of patient: ");
					String patientName = Utility.stringInput();
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
		controller.writeFileDoc(docList);
		controller.writeFilePat(patList);
		return appointList;
	}

	public void getAppointmentDetails(List<AppointmentDetails> appointList) {
		for (int i = 0; i < appointList.size(); i++) {
			System.out.println("Doctor Name: " + appointList.get(i).getDoctorName() + "\nPatient Name: "
					+ appointList.get(i).getPatientName() + "\nDoctor Specialization: "
					+ appointList.get(i).getDoctorSpecialization() + "\nDoctor Availability: "
					+ appointList.get(i).getDoctorAvailability());
			System.out.println();
		}
	}

	public void searchDoctor(List<DoctorDetails> docList) {
		for (int i = 0; i < docList.size(); i++) {
			System.out.println(docList.get(i).getDoctorName());
		}
		System.out.println("Enter name of doctor: ");
		String docName = Utility.stringInput();
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getDoctorName().equalsIgnoreCase(docName)) {
				System.out.println("Name: " + docList.get(i).getDoctorName() + "\nId: " + docList.get(i).getDoctorId()
						+ "\nSpecialization: " + docList.get(i).getSpecialization() + "\nAvailability: "
						+ docList.get(i).getAvailability() + "\nAppointments: " + docList.get(i).getAppointment());
				break;
			}
		}
	}

	public void searchPatient(List<PatientDetails> patList) {
		for (int i = 0; i < patList.size(); i++) {
			System.out.println(patList.get(i).getPatientName());
		}
		System.out.println("Enter name of patient: ");
		String patName = Utility.stringInput();
		for (int i = 0; i < patList.size(); i++) {
			if (patList.get(i).getPatientName().equalsIgnoreCase(patName)) {
				System.out.println("Name: " + patList.get(i).getPatientName() + "\nID: " + patList.get(i).getPatientId()
						+ "\nMobile number: " + patList.get(i).getMobileNumber() + "\nAge: " + patList.get(i).getAge()
						+ "\nAssigned doctor: " + patList.get(i).getAssignDocotor());
			}
		}
	}

}
