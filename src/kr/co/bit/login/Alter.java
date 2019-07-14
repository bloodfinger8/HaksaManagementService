package kr.co.bit.login;

import java.io.IOException;
import java.sql.SQLException;

public class Alter extends Member implements MemberInterface {

	private String sql2;
	
	public Alter(){
		super();
		sql2=null;
	}
	@Override
	public void memberSql() {
		sql = "select id,passwd,juso,bunho from member where id=?";
	}
	
	
	public void alterSql2() {
		sql2 = "update member set id=?,passwd=?,juso=?,bunho=? where id =? ";
	}
		
	
	public void alterProcess() throws SQLException, IOException {
		if(Login.session==null) {
			System.out.println("로그인을 먼저");
			return;
		}
		conn=Member.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,Login.session);
		rs = pstmt.executeQuery();  //rs는 ResultSet형
		while (rs.next()) {
			id = rs.getString("id");
			passwd = rs.getString("passwd");
			juso = rs.getString("juso");
			bunho = rs.getString("bunho");
			memberResult();
		}

		insertInformation();//상속받은 메소드 사용.

		alterSql2();
		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		pstmt.setString(3, juso);
		pstmt.setString(4, bunho);
		pstmt.setString(5, Login.session);
		cnt = pstmt.executeUpdate();  //rs2는 int형

		if (cnt == 0) {
			System.out.println("업데이트 실패");
		} else {
			Login.session = id; // 변경된 아이디를 다시 session에 저장
			System.out.println("업데이트 성공");
		}
		memberClose(); //상속받아서 사용

	}
	
	
	
	
}
