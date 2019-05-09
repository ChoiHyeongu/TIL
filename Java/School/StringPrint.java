
public class StringPrint {

	public static void main(String[] args) {

		char[] ch = { '자', '바', '프', '로', '그', '래', '밍' };
		
		for (int i = 0; i <ch.length; i++) {
			System.out.print(ch[i]);
			if(i!=ch.length - 1)
				System.out.print(",");
		}
		
		System.out.println();

		for (int i = ch.length - 1; i >= 0; i--) {
			System.out.print(ch[i]);
			if(i!=0)
				System.out.print(",");
		}
	}
	

}
