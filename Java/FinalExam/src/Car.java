
public class Car {

	int speed;
	String color;
	String carName;
	
	void speedUp() {
		speed += 20;
	}
	
	void speedDown() {
		speed -= 10;
	}
	
	void nowSpeed() {
		System.out.println("현재 속도는 " + speed + "입니다.");
	}
	
	void stop() {
		speed = 0;
	}
	
	public static void main(String[] args) {
		
		Car car = new Car();
		car.speedUp();
		car.speedUp();
		car.speedUp();
		car.carName = "Sonata";
		car.color = "검정색";
		System.out.print(car.carName + "의 색깔은 " + car.color + "이고, ");
		car.nowSpeed();
	}
}
