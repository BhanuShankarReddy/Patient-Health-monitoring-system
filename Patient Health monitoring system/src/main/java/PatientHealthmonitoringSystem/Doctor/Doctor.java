package PatientHealthmonitoringSystem.Doctor;

public class Doctor

{
	
private int DoctorId;
private String DoctorName;
private String Specialization;


public int getDoctorId() {
	return DoctorId;
}
public void setDoctorId(int DoctorId) {
	this.DoctorId = DoctorId;
}
public String getDoctorName() {
	return DoctorName;
}
public void setDoctorName(String DoctorName) {
	this.DoctorName = DoctorName;
}
public String getSpecialization() {
	return Specialization;
}
public void setSpecialization(String Specialization) {
	this.Specialization = Specialization;
}

@Override
public String toString() {
	return "Student [DoctorId=" + DoctorId + ", DoctorName=" + DoctorName + ", Specialization=" + Specialization + "]";
}


}
