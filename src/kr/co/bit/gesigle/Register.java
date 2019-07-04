package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Board implements BoardInter {

	public Register() {
		super();
	}

	public void setNo() throws IOException{
		System.out.println("�Խñ۹�ȣ�Է� : ");
		no = Integer.parseInt(br.readLine());
	}
	
	public void setTitleContents() throws IOException {
		System.out.println("����|����");
		titleContent = br.readLine();
	}	
	
	
	@Override
	public void boardSql() {
		sql = "INSERT into board(no,title,contents,author,nal,readcount) values(?,?,?,?,?,?)";
	}
	public void boardSqlExecute() throws SQLException,IOException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3,content);
		pstmt.setString(4, "�����");
		pstmt.setString(5, "20190701");
		pstmt.setInt(6, 0);
		cnt = pstmt.executeUpdate();
	}
	@Override
	public void boardProcess() throws ClassNotFoundException,SQLException,IOException{
		setNo();
		setTitleContents();
		titleContentsProcess();
		
		//boardSql();
		conn=Board.getConnection();
		boardSqlExecute();
		
		System.out.println(cnt + "����� �Ǿ����ϴ�.");
		
		//totalClose();
	}

	@Override
	public void boardClose() {
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
