class CarExtends {
	public CarExtends() { System.out.println("CarExtends");}
	public CarExtends(String name) { System.out.println(name);}
}

public class Car02 extends CarExtends{

	public Car02() { System.out.println("Car02");}
	public Car02(String name) { super(name);
		System.out.println("Car02");}
	
	public static void main(String[] args) {
	
		Car02 car02 = new Car02("AB");
	}

}
