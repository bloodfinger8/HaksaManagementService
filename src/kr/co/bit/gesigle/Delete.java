package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public class Delete extends Board implements BoardInter {
	
	public Delete() {
		super();
	}
	
	public void deleteTitle() throws IOException{
		System.out.println("������ �Խñ� ���� �Է�");
		titleInput=Register.br.readLine();	
	}
	
	
	
	@Override
	public void boardSql() {
		sql = "delete from board where title=?";
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

	@Override
	public void boardProcess() throws SQLException,IOException {
		deleteTitle();
		conn = Board.getConnection(); //RegisterŬ�������� static�Լ� ȣ��
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleInput);
		cnt=pstmt.executeUpdate();
		System.out.println(cnt + "�� ���� ����");
	}
	

}
