package kr.co.bit.gesigle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Board {
	
	protected int no;
	protected String title;
	protected String content;
	protected String author;
	protected String nal;
	protected int readcount;
	protected int cnt;
	protected String sql;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected int indexI; //������ "|"
	public static Connection conn;
	public static BufferedReader br;
	
	protected String titleInput; //���� �Է�
	protected String titleContent; //��������� �Է� 
	
		
	public Board() {
		no=0; title=null; content=null; author=null; nal=null; readcount=0; cnt=0; sql=null;
		pstmt=null; rs=null; conn=null;
		titleInput=null; titleContent=null;
	}
	
	static {
		br =new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	public static Connection getConnection() throws SQLException{
		conn =DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		return conn;
	}
		
	protected void setTitle() {
		System.out.print("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
	}
	
	protected void titleContentsProcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0,indexI);
		content = titleContent.substring(indexI+1);
	}	
	
	

}
