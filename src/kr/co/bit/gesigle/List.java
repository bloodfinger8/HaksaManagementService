package kr.co.bit.gesigle;
import java.sql.SQLException;

public class List extends Board implements BoardInter{
	
	public List() {
		super();
	}
	
	public void boardTitle() {
		System.out.println("===��ü���===");
		System.out.println("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��");
	}
	
		
	@Override
	public void boardProcess() throws SQLException {
		boardTitle();
		//boardSql();
		conn = Board.getConnection(); //RegisterŬ�������� static�Լ� ȣ��
		pstmt = conn.prepareStatement(sql);
		rs =pstmt.executeQuery(); //Resultset�� �������̽��� ���̺��� ����Ų��.
		while(rs.next()) {//�������̺��� ���� ���������� ����Ų��.
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
