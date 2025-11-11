package CRUD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {
		while(true) {
			System.out.println("Employee Management App");
			System.out.println("1.create  2.Read  3.Update  4.Delete");
			Scanner sc= new Scanner(System.in);
			int choice = sc.nextInt();
			if (choice<1 || choice>4)break;
			switch(choice) {
			case 1:
				System.out.println("Id , Name , Email , Salary");
				int Id = sc.nextInt();
				sc.nextLine();
				String Name = sc.nextLine();
				String Email = sc.nextLine();
				int Salary = sc.nextInt();
				Employee emp = new Employee(Id,Name,Email,Salary);
				Dao.createEmployee(emp);
				break;
				
			case 2:
				ArrayList<Employee> List = Dao.readAllEmployee();
				for (Employee employee : List) {
					System.out.println(employee);
				}
				break;
				
			case 3:
				System.out.println("Id & Name :");
				Id = sc.nextInt();
				sc.nextLine();
				Name = sc.nextLine();
				Dao.UpdteEmployee(Id,Name);
				break;
			case 4:
				System.out.println("Id :");
				Id = sc.nextInt();
				Employee delEmp = new Employee(Id,"","",0);
                delEmp.getId();
				Dao.deleteEmployee(delEmp);
				break;
			default :
				System.out.println("Please enter a valid Value!");
				break;
			}
			
		}
		

	}

}
