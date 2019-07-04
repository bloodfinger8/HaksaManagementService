package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Board implements BoardInter {

	public Search() {
		super();
	}
	
	public void boardSearch() throws SQLException, IOException {
		System.out.println("찾는 게시물 제목 입력 : ");
		titleInput = Register.br.readLine();
		
	}	
	
	@Override
	public void boardSql() {
		sql = "select no,title,contents,author,nal,readcount from board where title=?";
	}
	
	@Override
	public void boardProcess() throws SQLException, IOException{
		boardSearch();
		setTitle();
		//boardSql();
		conn = Board.getConnection(); //Register클래스에서 static함수 호출
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,titleInput );
		rs=pstmt.executeQuery();
		while(rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("contents");
			author = rs.getString("author");
			nal =rs.getString("nal");
			readcount =rs.getInt("readcount");
			System.out.println(no+"\t"+ title+"\t"+ content+"\t"+ author+"\t"+ nal+"\t"+ readcount);
		}
	}

	@Override
	public void boardClose() {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
