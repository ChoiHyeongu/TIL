#include <Servo.h>

Servo servo;

int button1Pin = 2; 
int servoPin = 8; 

void setup() {
  
  pinMode(button1Pin, INPUT_PULLUP);
  servo.attach(servoPin);
  
  Serial.begin(9600);
}

void loop() {
  
  int button1State;     
  
  button1State = digitalRead(button1Pin);    
    
  if(button1State == LOW){         
    servo.write(180);
    delay(300);
    servo.write(0);
  } 

  Serial.println(button1State);  
}   
