package org.student;

import org.department.Department;

public class Student extends Department {
	
	//method to get studentName
	public void studentName()
	{
		System.out.println("Prints the student name");
	}
	
	//method to get studentDept
	public void studentDept()
	{
		System.out.println("Prints the student department");
	}
	
	//method to get studentID
	public void studentID()
	{
		System.out.println("Print the student ID");
	}
	
	public static void main(String[] args) {
		Student objStudent= new Student();
		
		//Call the methods from grand parent class
		objStudent.collegeName();
		objStudent.collegeCode();
		objStudent.collegeRank();
		
		//Call the methods from parent class
		objStudent.deptName();
		
		//Call the methods from same class
		objStudent.studentName();
		objStudent.studentDept();
		objStudent.studentID();
		
	}

}
