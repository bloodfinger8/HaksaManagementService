package kr.co.bit.login;

import java.sql.SQLException;

public class List extends Member implements MemberInterface {
	
	public List() {
		super();
	}
	
	@Override
	public void memberSql() {
		sql = "select id,passwd,juso,bunho from member";
	}
	
	public void listProcess() throws SQLException {
		memberTitle();
		conn=Member.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			id = rs.getString("id");
			passwd = rs.getString("passwd");
			juso = rs.getString("juso");
			bunho = rs.getString("bunho");
			memberResult();
		}
		memberClose();
	}

}
