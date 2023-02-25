package sdbms;

public class Employee {
	String id;
	String name;
	static int count;

	public Employee(String name) {
		this.id="jsp"+count;
		this.name=name;
		count++;
	}
	public static void main(String[] args) {
		Employee employee= new Employee("tom");
		System.out.println(employee.id+" "+employee.name);
		Employee employee1= new Employee("jack");
		System.out.println(employee1.id+" "+employee.name);
	}
}

