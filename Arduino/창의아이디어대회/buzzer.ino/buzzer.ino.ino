int buzzer = 2;                         // buzzer을 9로 설정합니다.
void setup()
{
  pinMode(buzzer,OUTPUT);   // buzzer를 출력핀으로 설정합니다.
}
void loop()
{
 tone(buzzer,956);
 delay(500);                          // buzzer에 0.5초간 도를 출력하도록 합니다.
 tone(buzzer,1014);
 delay(500);                          //buzzer에 0.5초간 레를 출력하도록 합니다.
 tone(buzzer,1136);
 delay(500);                          //buzzer에 0.5초간 미를 출력하도록 합니다.
 tone(buzzer,1275);
 delay(500);                          //buzzer에 0.5초간 파를 출력하도록 합니다.
}
