
interface Say {
	int something(int a, int b);
}

class Person {
	public void hi(Say line) {
		{
			int number = line.something(3, 4);
			System.out.println("Number is " + number);
		}
	}
}

class PersonTes {
	public static void main(String[] args) {
		Person rin = new Person();
		rin.hi((a,b)->{
			System.out.println("This is Coding-Factory!");
			System.out.println("Tank you Lamda");
			System.out.println("parameter number is "+a+","+b);
			
			return 7;
		});
	}
}
