package kr.co.bit.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member {
	 
	protected String id;
	protected String passwd;
	protected String juso;
	protected String bunho;
	protected String sql;
	protected PreparedStatement pstmt;
	public static Connection conn; //conn은 상속이 되지않는데...왜 다른클래스에서 없어도 되는걸까?...
	protected int cnt;
	protected ResultSet rs;
	
	public Member() {
		id=null; passwd=null; juso=null; bunho=null; sql=null;
		pstmt=null; cnt=0; rs=null;
	}
	static {
		conn=null;
	}
	//satic초기화에 넣을수도 있지만 그러면 반복문안에 계속해서 객체를 만들어야 연결이 가능하기 때문에
	//함수로 만들어서 사용하려고 했다.
	public static Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		return conn;
	}
	
	
	public void memberResult() {
		System.out.println(id + "\t" + passwd + "\t" + juso + "\t" + bunho);
	}
	
	public void memberTitle() {
		System.out.println("회원아이디 \t 회원패스워드 \t 회원주소 \t 회원전화번호");
	}
	
	public void memberClose() throws SQLException{

		conn.close();
		pstmt.close();

	}
	
	

	public void insertInformation() throws IOException {

		System.out.println("회원아이디입력");
		id = Register.br.readLine();
		System.out.println("회원패스워드입력");
		passwd = Register.br.readLine();
		System.out.println("회원주소입력");
		juso = Register.br.readLine();
		System.out.println("회원전화번호입력");
		bunho = Register.br.readLine();

	}
	
	
	
}
