package sdbms;

public class Student {
	private String id;
	private int age;
	private String name;
	private int marks;
	static int count=101;
	public Student(int age, String name, int marks) {
		this.id = "JSP"+count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "Student id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks;
	}

}
