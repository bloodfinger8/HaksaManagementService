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
	protected int indexI; //구분자 "|"
	public static Connection conn;
	public static BufferedReader br;
	
	protected String titleInput; //제목 입력
	protected String titleContent; //제목과내용 입력 
	
		
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
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
	}
	
	protected void titleContentsProcess() {
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0,indexI);
		content = titleContent.substring(indexI+1);
	}	
	
	

}
