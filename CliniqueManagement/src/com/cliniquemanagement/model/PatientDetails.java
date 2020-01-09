package com.cliniquemanagement.model;

/**
 * Purpose: To set and get the values of specified fields
 * 
 * @author Sahil Kudake
 *
 */
public class PatientDetails {

	public String patientName;
	public int patientId;
	public long mobileNumber;
	public int age;
	public String assignDocotor;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAssignDocotor() {
		return assignDocotor;
	}

	public void setAssignDocotor(String assignDocotor) {
		this.assignDocotor = assignDocotor;
	}

	@Override
	public String toString() {
		return "PatientDetails [patientName=" + patientName + ", patientId=" + patientId + ", mobileNumber="
				+ mobileNumber + ", age=" + age + ", assignDocotor=" + assignDocotor + "]";
	}

}
