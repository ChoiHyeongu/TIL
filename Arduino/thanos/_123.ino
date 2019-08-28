#include <Servo.h>

Servo myservo;

int pos=0;
int toggle=0;
void setup() {
Serial.begin(9600);
myservo.attach(13);
pinMode(12, INPUT);  
myservo.write(90);
}
void loop() {
  delay(200); 
  if(digitalRead(12) != 0) {
    if ( toggle == 0) {
      toggle=1;
      Serial.println("toggle = 0? " + toggle);
    }
    else if ( toggle== 1) {
      toggle=0;
      Serial.println("toggle = 1? " + toggle);
    }
  }
  if(toggle == 0) {
    myservo.write(180);
  }
  if(toggle == 1) {
    myservo.write(pos);
  }
  Serial.println(toggle);
}
