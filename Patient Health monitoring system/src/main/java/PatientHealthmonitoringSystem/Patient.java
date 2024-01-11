package PatientHealthmonitoringSystem;

public class Patient

{
	
private int PatientId;
private String PatientName;
private int PatientAge;
private String PatientBlock;


public int getPatientId() {
	return PatientId;
}
public void setPatientId(int PatientId) {
	this.PatientId = PatientId;
}
public String getPatientName() {
	return PatientName;
}
public void setPatientName(String PatientName) {
	this.PatientName = PatientName;
}
public int getPatientAge() {
	return PatientAge;
}
public void setPatientAge(int PatientAge) {
	this.PatientAge = PatientAge;
}
public String getPatientBlock() {
	return PatientBlock;
}
public void setPatientBlock(String PatientBlock) {
	this.PatientBlock = PatientBlock;
}
@Override
public String toString() {
	return "Student [PatientId=" + PatientId + ", PatientName=" + PatientName + ", PatientAge=" + PatientAge + ", PatientBlock=" + PatientBlock + "]";
}


}
