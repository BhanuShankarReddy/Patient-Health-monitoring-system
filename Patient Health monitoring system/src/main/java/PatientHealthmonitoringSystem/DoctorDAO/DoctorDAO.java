package PatientHealthmonitoringSystem.DoctorDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PatientHealthmonitoringSystem.Patient;
import PatientHealthmonitoringSystem.Doctor.Doctor;



public class DoctorDAO {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/cd1";
			String user="root";
			String password="root";
		Connection connection=DriverManager.getConnection(url,user,password);

			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	public String SaveDoctorDetails(Doctor doctor)  {
		try {
			
			String query ="INSERT Into doctortable Values (?,?,?,?)";
			
			PreparedStatement ps= getConnection().prepareStatement(query);
			
			ps.setInt(1, doctor.getDoctorId());
			ps.setString(2, doctor.getDoctorName());
			ps.setString(3, doctor.getSpecialization());
			
			
			int res = ps.executeUpdate();
			ps.close();
			
			return res+"Doctor details";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "please wait for some time";
	

}
	public Doctor getDoctorByID(int DoctorId)
	{
		String query = "SELECT * FROM doctortable Where DoctorId=?";
		Connection connection = getConnection();
		
		try { 
			
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1,DoctorId);
			
		ResultSet resultSet=ps.executeQuery();
		
		Doctor doctor = new Doctor();
		
		while(resultSet.next())
			
		{
			
			doctor.setDoctorId(resultSet.getInt(1));
			doctor.setDoctorName(resultSet.getString(2));
			doctor.setSpecialization(resultSet.getString(3));
			
		}
		
		connection.close();
		
		return doctor;
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
