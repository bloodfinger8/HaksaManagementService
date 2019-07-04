package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public class Update extends Board implements BoardInter{
	
	
	public Update() {
		super();
	}
	
	public void updateTitle() throws IOException{
		System.out.println("수정할게시글제목입력:");
		titleInput=Register.br.readLine();
	}
	public void updateConfirm() {
		System.out.println("수정전내용입니다.");
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
	}
	@Override
	public void boardSql() {
		sql = "SELECT NO,TITLE,CONTENTS,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE=?";
	}
	public void updateTitleContent() throws IOException{
		System.out.println("해당 게시물이 검색되었습니다.");
		System.out.println("제목|내용");
		titleContent=Register.br.readLine();
	}
	
	public void updateSearchSql() {
		sql = "UPDATE BOARD SET TITLE=?,CONTENTS=? WHERE TITLE=?";
	}
	
	@Override
	public void boardProcess() throws SQLException,IOException, ClassNotFoundException {
		conn=Board.getConnection();
		updateTitle();
		updateConfirm();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleInput);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			no= rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("contents");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readcount = rs.getInt("readcount");
			System.out.print(no+"\t"+title+"\t"+content+"\t"+author+"\t"+nal+"\t"+readcount+"\n");
		}
		updateTitleContent();
		titleContentsProcess();//제목|내용 분리 메소드
		updateSearchSql(); 
	    pstmt =conn.prepareStatement(sql);
	    pstmt.setString(1, title);
	    pstmt.setString(2, content);
	    pstmt.setString(3, titleInput);
	    cnt=pstmt.executeUpdate();
	    System.out.println(cnt+"건 게시글이 수정되었습니다.");
	   
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
