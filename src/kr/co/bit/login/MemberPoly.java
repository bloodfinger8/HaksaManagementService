package kr.co.bit.login;

public class MemberPoly {
	//매개변수 다형성 구현
	public void memberSQL(MemberInterface memberinterface) {
		memberinterface.memberSql();
		
	}
	
}
