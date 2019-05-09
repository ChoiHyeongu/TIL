
public class FriendTest {
	
	public static void main(String[] args) {
		
		Friend[] friend = new Friend[5];
		friend[0] = new Friend("김길동", "010-9673-9372", "aaa@naver.com");
		friend[1] = new Friend("이길동", "010-9673-9372", "bbb@naver.com");
		friend[2] = new Friend("홍길동", "010-9673-9372", "ccc@naver.com");
		friend[3] = new Friend("장길동", "010-9673-9372", "ddd@naver.com");
		friend[4] = new Friend("차길동", "010-9673-9372", "eee@naver.com");

		System.out.println("이름              전화번호                메일주소");
		System.out.println("----------------------------------------------------------------");
		for(int i = 0; i <friend.length; i++) {
			System.out.println(friend[i].getInfo());
		}
	}

}
