package co.hospital.service;

import java.util.List;

import co.hospital.model.Appointment;
import co.hospital.model.PatientList;
import co.hospital.model.addDoctor;
import co.hospital.model.addRec;

public interface AppService {

	int adminlogin(String email, String pass);

	int doctorlogin(String email, String pass);

	String adminName(String email, String pass);

	void insertDoc(co.hospital.model.addDoctor doc);

	List<addDoctor> doctorList();

	void updateDoc(co.hospital.model.addDoctor doc);

	void deleteDoc(co.hospital.model.addDoctor doc);

	void insertRec(addRec rec);

	List<addRec> recList();

	void updateRec(addRec rec);

	void deleteRec(addRec rec);

	List<PatientList> patList();

	int reclogin(String email, String pass);

	void addPatient(PatientList p);

	void patDischarge(int id);

	void deletePat(PatientList p);

	void updatePatient(PatientList p);

	void appointment(Appointment app);

	List<Appointment> appointmentList();

	List<addRec> getEmail();

	void deleteAppt(Appointment p);

	

}
