// 스마트폰으로 LED 켜기
#include <RFduinoBLE.h>  // 블루투스 라이브러리를 사용하기 위해 헤더 파일 추가

int led = 2;    // LED에 연결된 핀을  2번으로 설정 
int buzzer = 4;
int isOn = false;
int echoPin = 14;
int trigPin = 13; 
int ultrasonic = 1;
void setup() {
pinMode(led, OUTPUT);   
pinMode(buzzer, OUTPUT);
RFduinoBLE.advertisementData = "I_Frind";   
                                                                 
Serial.begin(9600);
RFduinoBLE.begin();    
                               
pinMode(trigPin, OUTPUT);
pinMode(echoPin, INPUT);

}

 void loop() {
   if(ultrasonic == 1){
     onUltrasonic();
   }
}

void RFduinoBLE_onReceive(char *data, int len) {                                                               
  switch(data[0]){
    case '1':
      ultrasonic = 1;
      break;
    case '2':
      ultrasonic = 2;
      break;
    case '3':
      onSOS();
      break;
    case '4':
      offSOS();
      break;
    default:
      Serial.println(data[0]);
      break;
  }
}

void onUltrasonic(){
   float duration;
   int distance;
   String value;
   
  digitalWrite(led, HIGH);
  // 초음파를 보낸다. 다 보내면 echo가 HIGH 상태로 대기하게 된다.
  digitalWrite(trigPin, HIGH);
  delay(10);
  digitalWrite(trigPin, LOW);
  
  // echoPin 이 HIGH를 유지한 시간을 저장 한다.
  duration = pulseIn(echoPin, HIGH); 
  // HIGH 였을 때 시간(초음파가 보냈다가 다시 들어온 시간)을 가지고 거리를 계산 한다.
  distance = ((int)(340 * duration) / 10000) / 2;  
  
  Serial.print(distance);
  Serial.println("cm");
  //dtostrf(distance, 4, 6, value);
  RFduinoBLE.sendInt(distance);
  // 수정한 값을 출력
  delay(300);

}

void onSOS(){
  Serial.println("sos on");
   digitalWrite(buzzer, HIGH);
}  

void offSOS(){
  Serial.println("sos off");
   digitalWrite(buzzer, LOW);
}
