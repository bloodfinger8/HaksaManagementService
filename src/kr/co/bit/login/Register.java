package kr.co.bit.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
//의문점 1.conn은 부모클래스의 static변수인데 가져다쓰려면 앞에 클래스 이름을 적어야되는데 필요가 없네?...
public class Register extends Member implements MemberInterface{
	
	public static BufferedReader br;
	
	public Register() {
		super();
	}
	
	static {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void registerLoginCheak() {
		if (Login.session != null) {
			System.out.println("이미 로그인중입니다.");
			System.exit(0);
		}
	}
	
	@Override
	public void memberSql(){
		sql = "insert into member(id,passwd,juso,bunho) values(?,?,?,?)";
	}
	
	public void registerSqlExecute() throws SQLException, IOException{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, juso);
		pstmt.setString(4, bunho);
		cnt = pstmt.executeUpdate();
		System.out.println(cnt+"건의 회원등록 되었습니다.");
	}

	public void registerProcess() throws SQLException, IOException, ClassNotFoundException{
		registerLoginCheak();
		insertInformation();//상속받은 메소드사용
		Member.conn=Member.getConnection();
		registerSqlExecute();
		memberClose();

	}
	
	

}
