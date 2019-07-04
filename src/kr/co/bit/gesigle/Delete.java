package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public class Delete extends Board implements BoardInter {
	
	public Delete() {
		super();
	}
	
	public void deleteTitle() throws IOException{
		System.out.println("삭제할 게시글 제목 입력");
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
		conn = Board.getConnection(); //Register클래스에서 static함수 호출
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleInput);
		cnt=pstmt.executeUpdate();
		System.out.println(cnt + "건 삭제 성공");
	}
	

}
