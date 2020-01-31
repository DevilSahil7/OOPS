package com.cliniquemanagement.model;

public class DoctorDetails {

	public String doctorName;
	public int doctorId;
	public String specialization;
	public String availability;
	public int appointment;
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctornName) {
		this.doctorName = doctornName;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getAppointment() {
		return appointment;
	}
	public void setAppointment(int appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "DoctorDetails [doctornName=" + doctorName + ", doctorId=" + doctorId + ", specialization="
				+ specialization + ", availability=" + availability + ", appointment=" + appointment + "]";
	}
	
	
}
