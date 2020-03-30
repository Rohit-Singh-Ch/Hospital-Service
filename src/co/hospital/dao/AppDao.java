package co.hospital.dao;

import java.util.List;

import co.hospital.model.Appointment;
import co.hospital.model.PatientList;
import co.hospital.model.addDoctor;
import co.hospital.model.addRec;

public interface AppDao {

	int adlogin(String email, String pass);

	int doclogin(String email, String pass);

	String adName(String email, String pass);

	void addDoc(addDoctor doc);

	List<addDoctor> doctorList();

	void updateDoctor(addDoctor doc);

	void deteleDoctor(addDoctor doc);

	void addRec(addRec rec);

	List<addRec> recList();

	void updateRec(addRec rec);

	void deleteRec(addRec rec);

	List<PatientList> patientList();

	int recLogin(String email, String pass);

	void addPatient(PatientList p);

	void patDischargeDate(int id);

	void deletePatient(PatientList p);

	void updatePatient(PatientList p);

	void appontment(Appointment app);

	List<Appointment> appointmentList();

	List<addRec> getEmail();

	void deleteAppt(Appointment p);

	

}
