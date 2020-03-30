package co.hospital.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.hospital.model.Appointment;
import co.hospital.model.PatientList;
import co.hospital.model.addDoctor;
import co.hospital.model.addRec;

@Repository
public class AppDaoImpl implements AppDao {
	
@Autowired JdbcTemplate jdbcTemplate;

  @Override
  public int adlogin(String email, String pass) {
	int flag=0;
	final String procedurecall="{call Proc_Hos1(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"signin");
		 cs.setString(2,email);
		ResultSet res=cs.executeQuery();
		if(res.next())
		{
			if(res.getString("password").equals(pass))
				flag=1;
			else
				flag=2;
		}
		else{
			flag=0;
		    System.out.println("email id is not register");
		}
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
  return flag;

 }

@Override
public int doclogin(String email, String pass) {
	int flag=0;
	final String procedurecall="{call Proc_Hos2(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"signin");
		 cs.setString(2,email);
		ResultSet res=cs.executeQuery();
		if(res.next())
		{
			if(res.getString("password").equals(pass))
				flag=1;
			else
				flag=2;
		}
		else{
			flag=0;
		    System.out.println("email id is not register");
		}
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
  return flag;
}

@Override
public String adName(String email, String pass) {
	String s = null;
	final String procedurecall="{call Proc_Hos1(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"signin");
		 cs.setString(2,email);
		ResultSet res=cs.executeQuery();
		if(res.next())
		{
			s=res.getString(2);
		}
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
     return s;
 }

@Override
public void addDoc(addDoctor doc) {
	final String procedurecall="{call Proc_Hos2(?,?,?,?,?,?,?,?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"insert");
		 cs.setString(2,doc.getFname());
		 cs.setString(3,doc.getLname());
		 cs.setString(4,doc.getEmail());
		 cs.setString(5,doc.getPass());
		 cs.setString(6,doc.getUsername());
		 cs.setString(7,doc.getQualification());
		 cs.setString(8,doc.getAddress());
		 cs.setString(9,doc.getMobileno());
		 cs.execute();
		 System.out.println("inserted doctor");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
	
}

@Override
public List<addDoctor> doctorList() {
	List<addDoctor> l=new ArrayList();
	final String procedurecall="{call Proc_Hos2(?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"getlist");
		ResultSet res=cs.executeQuery();
		while(res.next())
		{
			addDoctor d=new addDoctor();
			d.setFname(res.getString("firstName"));
			d.setLname(res.getString("lastName"));
			d.setAddress(res.getString("addres"));
			d.setEmail(res.getString("email"));
			d.setMobileno(res.getString("mobileNo"));
			d.setQualification(res.getString("qualification"));
			d.setUsername(res.getString("userName"));
			d.setId(Integer.parseInt(res.getString("userId")));
			l.add(d);
		}
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	 return l;
	
}

@Override
public void updateDoctor(addDoctor doc) {
	System.out.print(doc.getId());
	final String procedurecall="{call Proc_Hos2(?,?,?,?,?,?,?,?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"update");
		 cs.setInt(2,doc.getId());
		 cs.setString(3,doc.getFname());
		 cs.setString(4,doc.getLname());
		 cs.setString(5,doc.getUsername());
		 cs.setString(6,doc.getEmail());
		 cs.setString(7,doc.getQualification());
		 cs.setString(8,doc.getAddress());
		 cs.setString(9,doc.getMobileno());

		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
}

@Override
public void deteleDoctor(addDoctor doc) {

	final String procedurecall="{call Proc_Hos2(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"delete");
		 cs.setInt(2,doc.getId());
		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
}

@Override
public void addRec(co.hospital.model.addRec rec) {
	final String procedurecall="{call Proc_Hos3(?,?,?,?,?,?,?,?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"insert");
		 cs.setString(2,rec.getFname());
		 cs.setString(3,rec.getLname());
		 cs.setString(4,rec.getEmail());
		 cs.setString(5,rec.getPass());
		 cs.setString(6,rec.getMobileno());
		 cs.setString(7,rec.getUsername());
		 cs.setString(8,rec.getAddress());
		 cs.setString(9,rec.getQuali());
		 cs.execute();
		 System.out.println("inserted receptionist");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
}

@Override
public List<co.hospital.model.addRec> recList() {
	
	List<addRec> l=new ArrayList();
	final String procedurecall="{call Proc_Hos3(?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"getlist");
		ResultSet res=cs.executeQuery();
		while(res.next())
		{
			co.hospital.model.addRec r=new addRec();
			r.setFname(res.getString("Fname"));
			r.setLname(res.getString("Lname"));
			r.setEmail(res.getString("emailId"));
			r.setMobileno(res.getString("mobileNo"));
			r.setUsername(res.getString("userName"));
			r.setAddress(res.getString("address"));
			r.setQuali(res.getString("qualification"));
			r.setUserId(Integer.parseInt(res.getString("userId")));
			l.add(r);
		}
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	 return l;
	
}

@Override
public void updateRec(co.hospital.model.addRec rec) {
	
	System.out.print(rec.getUserId());
	final String procedurecall="{call Proc_Hos3(?,?,?,?,?,?,?,?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"update");
		 cs.setInt(2,rec.getUserId());
		 cs.setString(3,rec.getFname());
		 cs.setString(4,rec.getLname());
		 cs.setString(5,rec.getUsername());
		 cs.setString(6,rec.getEmail());
		 cs.setString(7,rec.getQuali());
		 cs.setString(8,rec.getAddress());
		 cs.setString(9,rec.getMobileno());

		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
}

@Override
public void deleteRec(co.hospital.model.addRec rec) {
	final String procedurecall="{call Proc_Hos3(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"delete");
		 cs.setInt(2,rec.getUserId());
		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
}

@Override
public List<PatientList> patientList() {
	List<PatientList> l=new ArrayList();
	final String procedurecall="{call Proc_Hos4(?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"getlist");
		ResultSet res=cs.executeQuery();
		while(res.next())
		{
			PatientList r=new PatientList();
			r.setFname(res.getString("firstName"));
			r.setLname(res.getString("lastName"));
			r.setMobile(res.getString("mobileNo"));
			r.setAddress(res.getString("address"));
			r.setUserId(Integer.parseInt(res.getString("userId")));
			r.setAdmitDate(res.getString("admitDate"));
			r.setDischargeDate(res.getString("dischargeDate"));
			l.add(r);
		}
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	 return l;
}

@Override
public int recLogin(String email, String pass) {
	int flag=0;
	final String procedurecall="{call Proc_Hos3(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"signin");
		 cs.setString(2,email);
		ResultSet res=cs.executeQuery();
		if(res.next())
		{
			if(res.getString("password").equals(pass))
				flag=1;
			else
				flag=2;
		}
		else{
			flag=0;
		    System.out.println("email id is not register");
		}
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
  return flag;

}

@Override
public void addPatient(PatientList p) {
	final String procedurecall="{call Proc_Hos4(?,?,?,?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"insert");
		 cs.setString(2,p.getFname());
		 cs.setString(3,p.getLname());
		 cs.setString(4,p.getMobile());
		 cs.setString(5,p.getAddress());
		 cs.execute();
		 System.out.println("inserted patient");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	

}

@Override
public void patDischargeDate(int id) {

	final String procedurecall="{call Proc_Hos4(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"discharge");
		 cs.setInt(2,id);
		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
}

@Override
public void deletePatient(PatientList p) {
	final String procedurecall="{call Proc_Hos4(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"delete");
		 cs.setInt(2,p.getUserId());
		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
}

@Override
public void updatePatient(PatientList p) {
	System.out.print(p.getUserId());
	final String procedurecall="{call Proc_Hos4(?,?,?,?,?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"update");
		 cs.setInt(2,p.getUserId());
		 cs.setString(3,p.getFname());
		 cs.setString(4,p.getLname());
		 cs.setString(5,p.getAddress());
		 cs.setString(6,p.getMobile());
		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	

}

@Override
public void appontment(Appointment app) {
	String date=app.getDate();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");	
	final String procedurecall="{call Proc_Hos5(?,?,?,?,?,?,?)}";
	 Connection con=null;
	 try{
		 java.util.Date d=sdf.parse(date);
		 long ms=d.getTime();
		 java.sql.Date d1=new java.sql.Date(ms);
		 System.out.print(d1);
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"insert");
		 cs.setString(2,app.getFname());
		 cs.setString(3,app.getLname());
		 cs.setString(4,app.getAddress());
		 cs.setString(5,app.getMobile());
		 cs.setString(6,app.getDoctorName());
		 cs.setDate(7, d1);
		 cs.execute();
		 System.out.println("appointment fix");
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
}

@Override
public List<Appointment> appointmentList() {
	final String procedurecall="{call Proc_Hos5(?)}";
	 Connection con=null;
	 List<Appointment> l= new ArrayList();
	 try{
		  
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"getlist");
		 ResultSet rs= cs.executeQuery();
		 while(rs.next())
		 {
			   Appointment r=new Appointment();
			   r.setId(Integer.parseInt(rs.getString("userId")));
			   r.setFname(rs.getString("fname"));
			   r.setLname(rs.getString("lname"));
			   r.setMobile(rs.getString("mobileNo"));
			   r.setAddress(rs.getString("address"));
			   r.setDoctorName(rs.getString("doctorName"));
			   r.setDate(rs.getString("date"));
			   l.add(r);
		 }
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }

		return l;
 }

@Override
public List<co.hospital.model.addRec> getEmail() {
	final String procedurecall="{call Proc_Hos3(?)}";
	 Connection con=null;
	 List<addRec> l= new ArrayList();
	 try{
		  
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"getlist");
		 ResultSet rs= cs.executeQuery();
		 while(rs.next())
		 {
			   addRec r=new addRec();
			   r.setEmail(rs.getString("emailId"));
			   l.add(r);
		 }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }

		return l;
	
}

@Override
public void deleteAppt(Appointment p) {
	final String procedurecall="{call Proc_Hos5(?,?)}";
	 Connection con=null;
	 try{
		 
		 con=jdbcTemplate.getDataSource().getConnection();
		 CallableStatement cs=con.prepareCall(procedurecall);
		 cs.setString(1,"delete");
		 cs.setInt(2,p.getId());
		 cs.execute();
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try{
			 con.close();
		 } 
		 catch(Exception e)
		 {}
	 }
	
}


}



