
public class StaticVarExam {

	public static void main(String[] args) {
		Student kim = new Student();
		Student jang = new Student("Jang");
		System.out.println(kim.name);
		System.out.println(jang.name);
		System.out.println(Student.count);
	}	
}

class Student{
	String name;
	int grade;
	static int count = 0;

	public Student() {
		count++;
	}
	
	public Student(String n) {
		name = n;
		count++;
	}
}
