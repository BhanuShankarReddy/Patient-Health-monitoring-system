package PatientHealthmonitoringSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PatientHealthmonitoringSystem.Patient;



public class DAoPatient {
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
	
	
	
	public String SavePatientDetails(Patient patient)  {
		try {
			
			String query ="INSERT Into patienttable Values (?,?,?,?)";
			PreparedStatement ps= getConnection().prepareStatement(query);
			ps.setInt(1, patient.getPatientId());
			ps.setString(2, patient.getPatientName());
			ps.setInt(3, patient.getPatientAge());
			ps.setString(4, patient.getPatientBlock());
			
			
			int res=ps.executeUpdate();
			ps.close();
			
			return res+" patient details";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "please wait for some time";
	

}
	public Patient getPatientByID(int PatientId)
	{
		String query="SELECT * FROM patienttable Where PatientId=?";
		Connection connection = getConnection();
		try { 
			PreparedStatement ps = connection.prepareStatement(query);
			
		ps.setInt(1,PatientId);
		
		ResultSet resultSet = ps.executeQuery();
		
		Patient patient = new Patient();
		
		while(resultSet.next())
			
		{
			
			patient.setPatientId(resultSet.getInt(1));
			patient.setPatientName(resultSet.getString(2));
			patient.setPatientAge(resultSet.getInt(3));
			patient.setPatientBlock(resultSet.getString(4));
			
		}
		connection.close();
		
		return patient;
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
