package PatientHealthmonitoringSystem.DoctorController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import PatientHealthmonitoringSystem.Patient;
import PatientHealthmonitoringSystem.Doctor.Doctor;
import PatientHealthmonitoringSystem.DoctorDAO.DoctorDAO;
import PatientHealthmonitoringSystem.dao.DAoPatient;


@WebServlet("/doctorDetails")
public class ControllerDoctor extends GenericServlet 
{
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	int DoctorId=Integer.parseInt(req.getParameter("DoctorId"));
	String DoctorName=req.getParameter("DoctorName");
	String Specialization=req.getParameter("Specialization");
	
	Doctor d = new Doctor();
	
	d.setDoctorId(DoctorId);
	d.setDoctorName(DoctorName);
	d.setSpecialization(Specialization);
	
	
	DoctorDAO s1=new DoctorDAO();
	
	PrintWriter p=res.getWriter();
	
	p.println(s1.SaveDoctorDetails(d));
}
}
