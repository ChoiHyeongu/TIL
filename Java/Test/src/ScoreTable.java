import java.util.Scanner;

public class ScoreTable {

	public static void main(String[] args) {

		String scoreTable[][] = new String[5][8];
		int sum = 0, average = 0, choice = 0, cnt = 0;
		String grade;

		Scanner scanner = new Scanner(System.in);

		while (choice != 4) { //왜 chocie 인지? 왜 choice != 4인지 에 대해
			System.out.println("[입력형식] 1.성적입력  2.성적처리 3.성적표확인 4.프로그램 종료");
			System.out.print("[실행번호 입력 1~4] : ");

			choice = scanner.nextInt();
			switch (choice) { //1,2,3,4, default 각 뭐가 이뤄지는지
			case 1:
				if(cnt >= 5) { // 왜 cnt >=5 ?
					System.out.println("학생 데이터를 추가하지 못합니다.");
					System.out.println("성적처리를 하시길 바랍니다.");
					System.out.println();
					continue; // continue 존재의 이유
				}
				
				System.out.print((cnt+1)+"번째 학생의 이름을 입력하세요 : ");
				scoreTable[cnt][0] = scanner.next();
				System.out.print((cnt+1)+"번째 학생의 국어점수를 입력하세요 : ");
				scoreTable[cnt][1] = scanner.next();
				System.out.print((cnt+1)+"번째 학생의 수학점수를 입력하세요 : ");
				scoreTable[cnt][2] = scanner.next();
				System.out.print((cnt+1)+"번째 학생의 영어점수를 입력하세요 : ");
				scoreTable[cnt][3] = scanner.next();
				System.out.print((cnt+1)+"번째 학생의 과학점수를 입력하세요 : ");
				scoreTable[cnt][4] = scanner.next(); 
				cnt++; // 이게 왜 있는지
				System.out.println();
				break;
			case 2:
				if(cnt < 5) { //왜 cnt < 5인지
					System.out.println("모든 자료가 입력되지 않아 성적처리를 할 수 없습니다.");
					System.out.println("모든 성적을 입력하시길 바랍니다.");
					System.out.println();
					continue; // continue;
				}
				
				System.out.println("(--)(__)(--)(__)(--)(__)(--)(__)(--)(__)(--)(__)");
				for (int i = 0; i < scoreTable.length; i++) { 
					for (int j = 1; j < scoreTable[i].length - 3; j++) { // j = 1 ;j<5; j++
						sum += Integer.parseInt(scoreTable[i][j]);
						//sum = sum + Integer.parseInt(scoreTable[i][j]);
					}
					
					average = sum / 4; //평균 구하는 공식
					if (average >= 90)  // 평균이 90 이상힐떄 ~ 80 일때 ~
						grade = "1등급";
					else if (average >= 80)
						grade = "2등급";
					else if (average >= 70)
						grade = "3등급";
					else if (average >= 60)
						grade = "4등급";
					else if (average >= 50)	
						grade = "5등급";
					else if (average >= 40)
						grade = "6등급";
					else if (average >= 30)
						grade = "7등급";
					else if (average >= 20)
						grade = "8등급";
					else
						grade = "9등급";// 그외에는 9등급 입니다.

					//String.value() 그리고 이게 하는게 뭔지
					scoreTable[i][5] = String.valueOf(sum);
					scoreTable[i][6] = String.valueOf(average);
					scoreTable[i][7] = String.valueOf(grade);

					sum = 0; //왜 sum = 0 인지
				}
				System.out.println("성적처리가 완료 되었습니다^^ 결과를 확인하세요");
				break;
			case 3:
				System.out.println("================================================================");
				System.out.println("학생명\t국어\t영어\t수학\t과학\t총점\t평균\t등급");
				System.out.println("================================================================");
				for (int i = 0; i < scoreTable.length; i++) {
					for (int j = 0; j < scoreTable[i].length; j++) {
						System.out.printf("%3s\t",scoreTable[i][j]); //%3s
					}
					System.out.println();
					System.out.println();
				}
				break;
			case 4: // 프로그램이 종료되기전 출력
				System.out.println("수고하셨습니다. 프로그램을 종료합니다.");
				break;
			default: // 이게 뭐하는건지
				System.out.println("ERROR : 옳바른 처리 숫자를 입력하시길 바랍니다.");
				System.out.println();
				break;
			}
		}
	}
}
