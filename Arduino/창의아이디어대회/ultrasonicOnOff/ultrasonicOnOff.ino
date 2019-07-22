// 스마트폰으로 LED 켜기
#include <RFduinoBLE.h>  // 블루투스 라이브러리를 사용하기 위해 헤더 파일 추가

int led = 2;                   // LED에 연결된 핀을  2번으로 설정 
int isOn = false;
int echoPin = 14;
int trigPin = 13; 
void setup() {
pinMode(led, OUTPUT);   // LED를 출력으로 설정 
    RFduinoBLE.advertisementData = "ledbtn";      // 블루투스 통신 데이타를  
                                                                 // ledbtn 포맷 적용
Serial.begin(9600);
RFduinoBLE.begin();    // 블루투스 (BLE) 스택의 시작함을 의미하며, 
                               // 이를 통하여 관련 서비스를  할 수 있습니다.
                pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
}
 void loop() {
  if(isOn){
    onUltrasonic();
  } 
}

void RFduinoBLE_onReceive(char *data, int len) // 블루투스 수신 데이터를 처리 함수
                          // char data 란에 데이터(0~F), len 란에는 길이 표시 
{                                                               
  if(data[0]==0){
     Serial.print("0\n");
    isOn = false;
    digitalWrite(led, LOW);
  } else if(data[0]){ 
    Serial.print("1\n");
    isOn = true;
    digitalWrite(led, HIGH);
  }
}

void onUltrasonic(){
   float duration, distance;
   String value;
   
  // 초음파를 보낸다. 다 보내면 echo가 HIGH 상태로 대기하게 된다.
  digitalWrite(trigPin, HIGH);
  delay(10);
  digitalWrite(trigPin, LOW);
  
  // echoPin 이 HIGH를 유지한 시간을 저장 한다.
  duration = pulseIn(echoPin, HIGH); 
  // HIGH 였을 때 시간(초음파가 보냈다가 다시 들어온 시간)을 가지고 거리를 계산 한다.
  distance = ((float)(340 * duration) / 10000) / 2;  
  
  Serial.print(distance);
  Serial.println("cm");
  //dtostrf(distance, 4, 6, value);
  RFduinoBLE.send("문자열");
  // 수정한 값을 출력
  delay(500);
}
