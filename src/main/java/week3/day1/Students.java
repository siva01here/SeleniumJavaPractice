package week3.day1;

public class Students {
	
	//class with multipe overloaded methods
	
	void getStudentInfo(int id)
	{
		System.out.println("Returns the student info for the provided student ID");
	}
	
	void getStudentInfo(String name)
	{
		System.out.println("Returns the student info for the provided student name");
	}
	
	void getStudentInfo(int id, String name)
	{
		System.out.println("Returns the student info for the provided student ID & name");
	}
	
	void getStudentInfo(String email, String phoneNumber)
	{
		System.out.println("Returns the student info for the provided student email and phonenumber");
	}
	
	public static void main(String[] args) {
		Students objStudents= new Students();
		
		//Call the overloaded methods
		objStudents.getStudentInfo(100);
		objStudents.getStudentInfo("TestName");
		objStudents.getStudentInfo(100, "TestName");
		objStudents.getStudentInfo("studentEmail@emil.com", "9870228901");
		
	}

}
