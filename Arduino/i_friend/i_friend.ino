#include <RFduinoBLE.h>

int ledPin = 13;
int echoPin = 11;
int trigPin = 10;
int pirPin = 3;
int buzzerPin = 4;

int ultraState = 2;
int pirState = 4;
int sosState = 6;

int length = 2;     

char notes[] = "af";
char notes2[] = "a";
int beats[] = {1,1};
int beats2[] = {1};

int tempo = 300;                              
 
void setup() {

  moduleSetup();

  Serial.begin(9600);
  RFduinoBLE.begin();     
}

void loop(){

  if(Serial.available()>0){
    char c = Serial.read();
    Serial.print("Input : ");
    Serial.println(c);
    testMethod(c);
  }
  
  if(ultraState == 1)
    onUltrasonic();

  if(pirState == 3)
    onPIR();

  if(sosState == 5)
    onSOS();
  else
    offSOS(); 
}

void testMethod(char c){
   switch(c){
    case '1':
      ultraState = 1;
      break;
    case '2':
      ultraState = 2;
      break;
    case '3':
      pirState = 3;
      break;
    case '4':
      pirState = 4;
      break;
    case '5':
      sosState = 5;
      break;
    case '6':
      sosState = 6;
      break;
  }
}

void RFduinoBLE_onReceive(char *data, int len) {                                                               
  switch(data[0]){
    case '1':
      ultraState = 1;
      break;
    case '2':
      ultraState = 2;
      break;
    case '3':
      pirState = 3;
      break;
    case '4':
      pirState = 4;
      break;
    case '5':
      sosState = 5;
      break;
    case '6':
      sosState = 6;
      break;
  }

  Serial.println(data[0]);
}

void moduleSetup(){
  pinMode(ledPin, OUTPUT);
                                   
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);

  pinMode(pirPin, INPUT);

  pinMode(buzzerPin, OUTPUT);
}

void onUltrasonic(){
  float duration;
  int distance;
   
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
  // 수정한 값을 출력
  RFduinoBLE.sendInt(distance);
  delay(2500);
}

void onPIR(){
  int pirValue = digitalRead(pirPin);
  Serial.println(pirValue);
  if(pirValue == HIGH){
    onSOS();
  } else {
    offSOS();
  }
  delay(500);
}

void onLED(){
  digitalWrite(ledPin, HIGH);
}

void offLED(){
  digitalWrite(ledPin, LOW);
}

void onBuzzer(){
    for (int i = 0; i < length; i++){
    if (notes[i] == ' ')
    {delay(beats[i] * tempo); // rest
    }
    else{
      playNote(notes[i], beats[i] * tempo);
    }
    delay(tempo / 10);
  }
  delay(500);
}

void offBuzzer(){
  digitalWrite(buzzerPin, LOW);
}

void onSOS(){
  onLED();
  onBuzzer();
}

void offSOS(){
  offLED();
  offBuzzer();
}

void playTone(int tone, int duration){
  for (long i = 0; i < duration * 1000L; i += tone * 2){
    digitalWrite(buzzerPin, HIGH);
    delayMicroseconds(tone);
    digitalWrite(buzzerPin, LOW);
    delayMicroseconds(tone);
  }
}

void playNote(char note, int duration){
  char names[] = { 'c', 'd', 'e', 'f', 'g', 'a', 'b', 'C' };
  int tones[] = { 1915, 1700, 1519, 1432, 7040, 1136, 1014, 956 };

  for (int i = 0; i < 8; i++){
    if (names[i] == note){
      playTone(tones[i], duration);
    }
  }
}
