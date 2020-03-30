package co.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.hospital.model.Appointment;
import co.hospital.model.PatientList;
import co.hospital.model.SendMail;
import co.hospital.model.SessionBean;
import co.hospital.model.addDoctor;
import co.hospital.model.addRec;
import co.hospital.service.AppService;

@Controller
public class Home {
 
@Autowired AppService as;
	@RequestMapping(value="/")
	public String m1()
	{
		return "index";
	}
	@RequestMapping(value="home")
	public String m4()
	{
		return "index";
	}
	@RequestMapping(value="adlogin")
	public String m2()
	{
		return "adlogin";
	}
	
	@RequestMapping(value="admin",method=RequestMethod.POST)
	public String admin(HttpServletRequest req,HttpSession session)
	{
		String pass=req.getParameter("pass");
		String email=req.getParameter("email");
		int x=as.adminlogin(email,pass);
		 SessionBean sessionbean = new SessionBean();
		if(x==0)
		{
			System.out.println("email id is not register");
			String y="email id is not registed";
			req.setAttribute("msg","invalid user");
		   return "adlogin";
		}	
		else if(x==2)
		{
			System.out.println("password is not correct");
			req.setAttribute("msg","password is not correct");
			return "adlogin";
			
		}	
		else
		{
			
			  sessionbean.setUsername(email);
			  
			  session.setAttribute("sessionBean", sessionbean);
			  
			 
			String s=as.adminName(email,pass);
			req.setAttribute("msg",s);
			return "adminPage";
		}
	}	
		
		@RequestMapping(value="doclogin")
		public String m3()
		{
			return "doclogin";
		}
		
		@RequestMapping(value="doctor",method=RequestMethod.POST)
		public String doctor(HttpServletRequest req)
		{
			String pass=req.getParameter("pass");
			String email=req.getParameter("email");
			int x=as.doctorlogin(email,pass);
			if(x==0)
			{
				System.out.println("email id is not register");
				String y="email id is not registed";
				req.setAttribute("msg","invalid user");
			   return "doclogin";
			}	
			else if(x==2)
			{
				System.out.println("password is not correct");
				req.setAttribute("msg","password is not correct");
				return "doclogin";
				
			}	
			else
				return "doctorPage";
		
	    }
		
		@RequestMapping(value="adddoctor",method=RequestMethod.POST)
		public String addDoctor(addDoctor doc)
		{
			as.insertDoc(doc);
			System.out.println("insert doctor");
			return "adminPage";
		}
	   
	@RequestMapping(value="doclist")
	public String docList(HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUsername();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}


		List<addDoctor> l=as.doctorList();
		req.setAttribute("list",l);
		return "docList";
	}
	@RequestMapping(value="updateDoctor",method=RequestMethod.POST)
	public String updateDoctor(addDoctor doc,HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUsername();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}


		as.updateDoc(doc);
		List<addDoctor> l=as.doctorList();
		req.setAttribute("list",l);
		
		return "docList";
		
	}
	@RequestMapping(value="deleteDoctor",method=RequestMethod.POST)
	public String deleteDoctor(addDoctor doc,HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUsername();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		as.deleteDoc(doc);
		List<addDoctor> l=as.doctorList();
		req.setAttribute("list",l);
		return "docList";
	}
	@RequestMapping(value="addRec",method=RequestMethod.POST)
	public String addReceotionist(addRec rec,HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUsername();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		as.insertRec(rec);
		return "adminPage";
	}
	
	@RequestMapping(value="reclist")
	public String recList(HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUsername();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		List<addRec> l=as.recList();
		req.setAttribute("list",l);
		return "reclist";
		
	}
		
	@RequestMapping(value="updateRec",method=RequestMethod.POST)
	public String updateRec(addRec rec,HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUsername();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		as.updateRec(rec);
		List<addRec> l=as.recList();
		req.setAttribute("list",l);
		
		return "reclist";
		
	}
	@RequestMapping(value="deleteRec",method=RequestMethod.POST)
	public String deleteRec(addRec rec,HttpServletRequest req)
	{
		String username;
		try
		{
		SessionBean sbean=(SessionBean)req.getSession().getAttribute("sessionBean");
		 username=sbean.getUsername();
		
		if(username==null)
		{
			return "index";
		}
		}catch(Exception e){
			return "index";
		}

		as.deleteRec(rec);
		List<addRec> l=as.recList();
		req.setAttribute("list",l);
		return "reclist";
	}
	@RequestMapping(value="logoutA")
	public String adminLogOut(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IOException
	{
		
			session.removeAttribute("sessionBean");
			request.getSession().invalidate();
			
		return "index";
	}
	@RequestMapping(value="patlist")
	public String patientList(HttpServletRequest req)
	{
		List<PatientList> l=as.patList();
		req.setAttribute("list",l);
		return "patientList";
	}
	@RequestMapping(value="reclogin" )
	public String recLogin() 
	
	{
		return "reclogin";
	}
	@RequestMapping(value="receptionist",method=RequestMethod.POST)
	public String receptionist(HttpServletRequest req)
	{
		String pass=req.getParameter("pass");
		String email=req.getParameter("email");
		int x=as.reclogin(email,pass);
		if(x==0)
		{
			System.out.println("email id is not register");
			String y="email id is not registed";
			req.setAttribute("msg","invalid user");
		   return "reclogin";
		}	
		else if(x==2)
		{
			System.out.println("password is not correct");
			req.setAttribute("msg","password is not correct");
			return "reclogin";
			
		}	
		else
			return "recPage";
	}
	@RequestMapping(value="addpat",method=RequestMethod.POST)
	public String addPat(PatientList p)
	{
		as.addPatient(p);
		return "recPage";
	}
	@RequestMapping(value="appt")
	public String apponitment()
	{
		return "recPage";
	}
	
	@RequestMapping(value="discharge",method=RequestMethod.POST)
	public String dischargePatient(HttpServletRequest req)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		as.patDischarge(id);
		return "recPage";
	}
	@RequestMapping(value="deletePat",method=RequestMethod.POST)
	public String deletePatient(PatientList p,HttpServletRequest req)
	{
		as.deletePat(p);
		List<PatientList> l=as.patList();
		req.setAttribute("list",l);
		return "patientList";
	}
	@RequestMapping(value="updatePat",method=RequestMethod.POST)
	public String updatePatient(PatientList p,HttpServletRequest req)
	{
		as.updatePatient(p);
		List<PatientList> l=as.patList();
		req.setAttribute("list",l);
		
		return "patientList";
		
	}
	@RequestMapping(value="appt",method=RequestMethod.POST)
	public String appointment(Appointment app)
	{
		as.appointment(app);
		return "recPage";
	}
	@RequestMapping(value="seeAppt")
	public String seeAppointment(HttpServletRequest req)
	{
		//List<addRec> l1=as.getEmail();
		SendMail sm=new SendMail();
		sm.sendMail("hii","akumar69141@gmail.com"," ");
		List<Appointment> l=as.appointmentList();
		req.setAttribute("list",l);
		return "seeAppointment";
	}
	@RequestMapping(value="deleteAppt")
	public String deleteAppointment(HttpServletRequest req,Appointment p)
	{
		as.deleteAppt(p);
		List<Appointment> l=as.appointmentList();
		req.setAttribute("list",l);
		return "seeAppointment";
	}
}
