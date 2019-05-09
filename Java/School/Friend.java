
public class Friend extends Person{

	String phoneNumber;
	String emailAddr;
	
	Friend(String name, String phoneNumber, String emailAddr){
		super(name);
		this.phoneNumber = phoneNumber;
		this.emailAddr = emailAddr;
	}
	
	public String getInfo() {
		String str = super.getInfo() + "       " + this.phoneNumber + "    " + this.emailAddr;
		return str;
	}
}
