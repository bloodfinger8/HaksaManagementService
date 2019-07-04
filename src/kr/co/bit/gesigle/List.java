package kr.co.bit.gesigle;
import java.sql.SQLException;

public class List extends Board implements BoardInter{
	
	public List() {
		super();
	}
	
	public void boardTitle() {
		System.out.println("===전체출력===");
		System.out.println("번호\t제목\t내용\t작성자\t날짜\t조회수");
	}
	
		
	@Override
	public void boardProcess() throws SQLException {
		boardTitle();
		//boardSql();
		conn = Board.getConnection(); //Register클래스에서 static함수 호출
		pstmt = conn.prepareStatement(sql);
		rs =pstmt.executeQuery(); //Resultset은 인터페이스로 테이블을 가르킨다.
		while(rs.next()) {//보드테이블의 행을 연속적으로 가르킨다.
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
	public void boardSql() {
		sql = "select no,title,contents,author,nal,readcount from board ORDER BY no";
	}
	@Override
	public void boardClose() {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
