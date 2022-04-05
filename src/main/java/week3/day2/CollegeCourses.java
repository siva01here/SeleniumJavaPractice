package week3.day2;

public class CollegeCourses extends University{

	@Override
	void ug() {
		System.out.println("Under graduate course");
	}
	
	public static void main(String[] args) {
		University objUniv= new CollegeCourses();
		CollegeCourses objCollege= new CollegeCourses();
		
		//call methods from abstract class using abstract class reference
		objUniv.pg();
		objUniv.ug();
		
		//call methods from non abstract class using child class reference
		objCollege.pg();
		objCollege.ug();
	}

}
