
public class CatchCat {

	public static void main(String[] args) {
		
		char[][] arr = new char[][] {
			{'X', 'R', 'X', 'X', 'X'},
			{'R', 'X', 'R', 'X', 'R'},
			{'X', 'R', 'X', 'F', 'X'},
			{'X', 'R', 'X', 'X', 'X'},
			{'R', 'X', 'X', 'R', 'X'}
		}; // R = 8 F = 1
		
		int fX = 0, fY = 0, cnt = 0 ;
		
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------------------");
		
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				if(arr[i][j] == 'F') {
					fX = i;
					fY = j;
					break;
				}
			}
		}
		
		arr[fX][fY] = 'X';
		
		while(fX != 0) {
			if(arr[fX][fY] == 'R') {
				cnt++;
				arr[fX][fY] = 'X';
			}
			fX--;
		}
				
		while(fY != 0) {
			if(arr[fX][fY] == 'R') {
				cnt++;
				arr[fX][fY] = 'X';
			}
			fY--;
		}
		
		arr[fX][fY] = 'F';
		
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				if(arr[i][j] == 'R') {
					arr[i][j] = 'X';
					cnt++;
				}
			}
		}
		
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(cnt);
	}
}
