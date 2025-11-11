package CRUD;

public class Employee {
	private int Id;
	private String Name;
	private String Email;
	private int Salary;
	
	public Employee(int id,String name,String email,int salary) {
		this.Id=id;
		this.Name=name;
		this.Email=email;
		this.Salary=salary;
	}
	
	public int getId() {return Id;}
	public String getName() {return Name;}
	public String getEmail() {return Email;}
	public int getSalary() {return Salary;}
	
	@Override
	public String toString() {
	    return "Employee {" +
	           "id=" + Id +
	           ", name='" + Name + '\'' +
	           ", email='" + Email + '\'' +
	           ", salary=" + Salary +
	           '}';
	}


}
