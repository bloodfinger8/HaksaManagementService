package kr.co.bit.login;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Member implements MemberInterface{
	
	private String searchId ;
	
	public Search() {
		super();
		searchId=null;
	}
	
	public void insertId() throws IOException {
		System.out.println("찾는 ID를 입력 : ");
		searchId = Register.br.readLine();
	}
	@Override
	public void memberSql() {
		sql = "select id,passwd,juso,bunho from member where id=?";
	}	
	
	public void searchProcess() throws SQLException, IOException {
		insertId();
		memberTitle();
		conn=Member.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchId);
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
