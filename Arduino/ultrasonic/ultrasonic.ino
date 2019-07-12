//초음파 센서의 핀번호를 설정한다.
int echoPin = 12;
int trigPin = 13;
int piezo = 3;
int sw = 5;

int numTones = 8;
int tones[] = {261, 294, 330, 349, 392, 440, 494, 523};
 

void setup() {
  Serial.begin(9600);
  // trig를 출력모드로 설정, echo를 입력모드로 설정
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);

   // 피에조 부저가 연결된 핀을 OUTPUT으로 설정합니다.
  pinMode(piezo, OUTPUT);
  // 스위치가 연결된 핀의 모드를 INPUT_PULLUP 상태(초기 로직레벨을 HIGH로 설정)로 설정합니다.
  pinMode(sw, INPUT_PULLUP);
}

void loop() {
  float duration, distance;
  
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
  // 수정한 값을 출력
  delay(500);

   if (digitalRead(sw) == LOW) {
    for (int i = 0; i < numTones; i++) {
      //numTones(8)의 수만큼 반복 실행합니다.
      // tone함수를 통해 피에조부저에서 소리가 나며 tones[]배열에 있는 주파수에 해당하는 음계가 출력됩니다.
      tone(piezo, tones[i]);
      // 0.5초 동안 대기합니다.
      delay(500);
    }
    // 피에조 부저가 연결된 핀으로부터 square-ware를 생성을 중단하도록 설정합니다.
    noTone(piezo);
  }
}
