
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
		System.out.println("���� �ӵ��� " + speed + "�Դϴ�.");
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
		car.color = "������";
		System.out.print(car.carName + "�� ������ " + car.color + "�̰�, ");
		car.nowSpeed();
	}
}
