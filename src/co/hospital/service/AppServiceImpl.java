package co.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.hospital.dao.AppDao;
import co.hospital.model.Appointment;
import co.hospital.model.PatientList;
import co.hospital.model.addDoctor;
import co.hospital.model.addRec;

@Service
public class AppServiceImpl implements AppService{

@Autowired AppDao ao;

@Override
public int adminlogin(String email, String pass) {
	
	return ao.adlogin(email, pass);
}

@Override
public int doctorlogin(String email, String pass) {
	
	return ao.doclogin(email,pass);
}

@Override
public String adminName(String email, String pass) {
	
	return ao.adName(email,pass);
}

@Override
public void insertDoc(addDoctor doc) {
	
	ao.addDoc(doc);
}

@Override
public List<addDoctor> doctorList() {
	
	return ao.doctorList();
	
}

@Override
public void updateDoc(addDoctor doc) {
	ao.updateDoctor(doc);
}

@Override
public void deleteDoc(addDoctor doc) {

	ao.deteleDoctor(doc);
}

@Override
public void insertRec(addRec rec) {

	ao.addRec(rec);
	
}

@Override
public List<addRec> recList() {
	
	return ao.recList();
}

@Override
public void updateRec(addRec rec) {
	ao.updateRec(rec);
	
}

@Override
public void deleteRec(addRec rec) {
	ao.deleteRec(rec);
}

@Override
public List<PatientList> patList() {
	
	return ao.patientList();
}

@Override
public int reclogin(String email, String pass) {
	
	return ao.recLogin(email,pass);
}

@Override
public void addPatient(PatientList p) {
	ao.addPatient(p);
	
}

@Override
public void patDischarge(int id) {
ao.patDischargeDate(id);
}

@Override
public void deletePat(PatientList p) {
	ao.deletePatient(p);
}

@Override
public void updatePatient(PatientList p) {
	ao.updatePatient(p);
}

@Override
public void appointment(Appointment app) {
ao.appontment(app);
}

@Override
public List<Appointment> appointmentList() {
	
	return ao.appointmentList() ;
}

@Override
public List<addRec> getEmail() {
	// TODO Auto-generated method stub
	return ao.getEmail();
}

@Override
public void deleteAppt(Appointment p) {
	ao.deleteAppt(p);	
}

}
