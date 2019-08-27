
int button1Pin 13;
int button1State;

void setup() {
  pinMode(button1Pin, INPUT);
}

void loop() {
  button1State = digitalRead(button1Pin);
  
}
