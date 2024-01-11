package PatientHealthmonitoringSystem.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import PatientHealthmonitoringSystem.Patient;
import PatientHealthmonitoringSystem.dao.DAoPatient;


@WebServlet("/patientDetails")
public class ControllerPatient extends GenericServlet 
{
@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	int PatientId=Integer.parseInt(req.getParameter("PatientId"));
	String PatientName=req.getParameter("PatientName");
	int PatientAge=Integer.parseInt(req.getParameter("PatientAge"));
	String PatientBlock=req.getParameter("PatientBlock");
	
	Patient s = new Patient();
	
	s.setPatientId(PatientId);
	s.setPatientName(PatientName);
	s.setPatientAge(PatientAge);
	s.setPatientBlock(PatientBlock);
	
	
	DAoPatient s1=new DAoPatient();
	
	PrintWriter p=res.getWriter();
	
	p.println(s1.SavePatientDetails(s));
}
}
