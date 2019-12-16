package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public class Update extends Board implements BoardInter{
	
	
	public Update() {
		super();
	}
	
	public void updateTitle() throws IOException{
		System.out.println("�����ҰԽñ������Է�:");
		titleInput=Register.br.readLine();
	}
	public void updateConfirm() {
		System.out.println("�����������Դϴ�.");
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
	}
	@Override
	public void boardSql() {
		sql = "SELECT NO,TITLE,CONTENTS,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE=?";
	}
	public void updateTitleContent() throws IOException{
		System.out.println("�ش� �Խù��� �˻��Ǿ����ϴ�.");
		System.out.println("����|����");
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
		titleContentsProcess();//����|���� �и� �޼ҵ�
		updateSearchSql(); 
	    pstmt =conn.prepareStatement(sql);
	    pstmt.setString(1, title);
	    pstmt.setString(2, content);
	    pstmt.setString(3, titleInput);
	    cnt=pstmt.executeUpdate();
	    System.out.println(cnt+"�� �Խñ��� �����Ǿ����ϴ�.");
	   
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
