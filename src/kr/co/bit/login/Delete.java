package kr.co.bit.login;

import java.sql.SQLException;

public class Delete extends Member implements MemberInterface{    //로그인중인 회원을 삭제!
	
	public Delete() {
		super();
	}
	@Override
	public void memberSql() {
		sql = "delete from member where id=?";
	}
	
	public void deleteProcess() throws SQLException {
		
		if(Login.session==null) {
			System.out.println("로그인 되어있지 않습니다.");
			return;
		}
		conn=Member.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Login.session);
		cnt = pstmt.executeUpdate();
		if (cnt == 0) {
			System.out.println("회원탈퇴 실패되었습니다.");
		} else {
			Login.session = null;
			System.out.println("회원탈퇴 되었습니다.");
		}
		memberClose();

	}
	
	
	
}
