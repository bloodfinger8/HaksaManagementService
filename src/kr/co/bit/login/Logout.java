package kr.co.bit.login;

import java.sql.SQLException;

public class Logout extends Member{

	public void logoutProcess() throws SQLException{
		System.out.println("로그아웃 되었습니다.");
		conn=Member.getConnection();
		Login.session = null;
		
		conn.close();
	}
}
