package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class StudentManagementSystemImpl implements StudentManagementSystem {
	Scanner scan=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String, Student>();

	@Override
	public void addStudent() {
		System.out.println("enter the age");
		int age=scan.nextInt();
		System.out.println("enter the name");
		String name=scan.next();
		System.out.println("enter the marks");
		int marks=scan.nextInt();
		Student std=new Student(age,name,marks);
		db.put(std.getId(), std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is"+std.getId());

	}

	@Override
	public void displayStudent() {
		System.out.println("enter the student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("Id: "+std.getId());
			System.out.println("age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());
			//System.out.println(std);-> printing ref variable as toString() is overridden

		}
		else {
			try {
				String message="Student with the Id "+id+"is not Found";
				throw new StudentNotFoundException(message);//invoking
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}


	}

	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			Set<String> keys= db.keySet();//
			for (String key : keys) {
				Student value=db.get(key);//Student is return type student object
				System.out.println(value);//2 nd way Sysout(db.get(key)) directly
			}	
		}
		else {
			try {
				String message="Student Records Not Found";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}



	@Override
	public void removeStudent() {
		System.out.println("enter the student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student Record Found");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record Deleted Succesfully!");
		}
		else {
			try {
				String message="Student with id"+id+" Records Not Found!";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student  Records Avialable"+db.size());
			db.clear();
			System.out.println("All records removed");
			System.out.println("Student Records Available : "+db.size());
		}
		else {
			try {
				String message="Student Database is empty";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void updateStudent() {
		System.out.println("enter the id of the student");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std= (db.get(id));
			System.out.println("1:UpdateAge\n2:updateName\n3:updateMarks");
			System.out.println("enter Choice: ");
			int choice=scan.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("enter the age");
				int age=scan.nextInt();
				std.setAge(age);
				System.out.println("Student age updated succefully");
				break;

			case 2:
				System.out.println("enter the name");
				String name=scan.next();
				std.setName(name);
				System.out.println("Student name updated succefully");
				break;

			case 3:
				System.out.println("enter the marks");
				int marks=scan.nextInt();
				std.setMarks(marks);
				System.out.println("Student marks updated succefully");

			default:
				try {
					String message="Please enter the valid choice";
					throw new StudentNotFoundException(message);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}






			}
		}
		else {
			try {
				String message="Student records not avialable to display";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}






	@Override
	public void countStudent() {
		System.out.println("No of Student Records: "+db.size());

	}

	@Override
	public void sortStudent() {
		//converting map into set->key		//Le keys -> get the value(Student object)
		//add it into List
		if(db.size()>=2) {
		Set<String> keys =db.keySet();
		List<Student>list = new ArrayList<Student>();
		for (String key : keys) {
			list.add(db.get(key));

		}
		System.out.println("1:SortById\n2:sortByAge\n3:sortByAge\n4:sortByname\n5:sortByMarks\n enter choice");
		int choice=scan.nextInt();
		switch (choice) {
		case 1: 
			Collections.sort(list, new SortStudentById());
			display(list);
			break;
		case 2:
			Collections.sort(list, new SortStudentByAge());
			display(list);
			break;
		case 3:
			Collections.sort(list, new SortStudentByName());
			display(list);
			break;
		case 4:
			Collections.sort(list, new SortStudentByMarks());
			break;

		default:
			try {
				String message="Please enter the valid choice";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		}
		else {
			try {
				String message="No Sufficient Student Objects to Sort";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		

	}
	private static void display(List<Student> list) {
		for (Student s : list) {
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for (String key : keys) {
				list.add(db.get(key));

			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.get(0));

		}
		else {
			try {
				String message="No sufficient Student objects to compare";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>2) {
			Set<String> keys=db.keySet();
			List<Student> list=new ArrayList<Student>();
			for (String key : keys) {
				list.add(db.get(key));

			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.size()-1);

		}
		else {
			try {
				String message="No sufficient Student objects to compare";
				throw new StudentNotFoundException(message);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}


}
