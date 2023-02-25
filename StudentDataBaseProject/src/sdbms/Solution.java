package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Student DB Management System");
		Scanner scan =new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		while(true) {
			System.out.println("1:Add Student\n2:displayAllStudent\n3:displayStudent\n4:removeStudent\n5:removeAllStudent\n6:updateStuedent");
			System.out.println("7:countStuden\n8:sortStudent\n9:getStudentWithHighestMarks\n10:getStudentWithLowestMarks\n11:Exit");
			int choice=scan.nextInt();
			switch (choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You");
				System.exit(0);



			default:
				try {
					throw new InvalidChoiceException("Invalid Choice, Enter Valid Choice");//invoking using throw keyword
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				
			}//end of switch
			System.out.println("-----------------");
		}//end of while loop
	}//end of main method

}//end of class
//addStudent();
//void displayStudent();
//void displayAllStudent();
//void removeStudent();
//void removeAllStudent();
//void updateStudent();
//void countStudent();
//void sortStudent();
//void getStudentWithLowestMarks();
//void getStudentWithHighestMarks();