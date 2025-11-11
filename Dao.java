package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Dao {
	public static void createEmployee(Employee employee) throws SQLException{
		Connection conn= DB.connect();
		String querry = Querry.insert;
		PreparedStatement preparestatement = conn.prepareStatement(querry);
		preparestatement.setInt(1,employee.getId());
		preparestatement.setString(2,employee.getName());
		preparestatement.setString(3,employee.getEmail());
		preparestatement.setInt(4,employee.getSalary());
		
		System.out.println("\n ps = "+preparestatement+"\n"+employee);
		preparestatement.executeUpdate();
		preparestatement.close();
	}
	
	public static void UpdteEmployee(int id , String name ) throws SQLException{
		Connection conn= DB.connect();
		String querry = Querry.update;
		PreparedStatement preparestatement = conn.prepareStatement(querry);
		preparestatement.setInt(2,id);
		preparestatement.setString(1,name);
		
		System.out.println("\n ps = "+preparestatement);
		preparestatement.executeUpdate();
		preparestatement.close();
	}
	
	public static ArrayList<Employee> readAllEmployee() throws SQLException{
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		Connection conn= DB.connect();
		String querry =  Querry.select;
		PreparedStatement statement = conn.prepareStatement(querry);	
		System.out.println("\n ps = "+statement);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			Employee emp = new Employee(rs.getInt("id"),
										rs.getString("name"),
										rs.getString("email"),
										rs.getInt("salary"));
			emplist.add(emp);
		}
		statement.close();
		return emplist;
		
	}
	public static void deleteEmployee(Employee employee) throws SQLException{
		Connection conn= DB.connect();
		String querry = Querry.delete;
		PreparedStatement preparestatement = conn.prepareStatement(querry);
		preparestatement.setInt(1,employee.getId());
		
		System.out.println("\n ps = "+preparestatement);
		preparestatement.executeUpdate();
		preparestatement.close();
	}
}
