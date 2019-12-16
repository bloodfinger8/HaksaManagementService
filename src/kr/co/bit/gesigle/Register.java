package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Board implements BoardInter {

	public Register() {
		super();
	}

	public void setNo() throws IOException{
		System.out.println("게시글번호입력 : ");
		no = Integer.parseInt(br.readLine());
	}
	
	public void setTitleContents() throws IOException {
		System.out.println("제목|내용");
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
		pstmt.setString(4, "양재우");
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
		
		System.out.println(cnt + "등록이 되었습니다.");
		
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
