package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Search {
	
	private String irumSearch;
	private int select;

	private String sql;
	private ResultSet rs; 
	private int no;
	private String age;
	private String irum;
	private String hakbun;
	private String subject;
	private String part;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public Search() {
		irumSearch=null; pstmt=null; 
		no=0; age=null; irum=null; hakbun=null; sql=null; subject=null; part=null;
		
	}
	
	public void searchProcess() {

		System.out.println("ã�� �̸��� �Է��Ͻÿ�");
		irumSearch = Regist.input.next();
		System.out.println("1.�л� 2.���� 3.������");
		select = Regist.input.nextInt();
		if(select == 1) {//�л� ã��!
			try {
				conn = Regist.getConnection();
				
				//stmt =conn.createStatement(); //createStatement()�� �̿��� ������ �����.
				//sql = "SELECT NO,AGE,IRUM,HAKBUN FROM STUDENT WHERE IRUM ='" +irumSearch+ "' ";
				//rs = stmt.executeQuery(sql); //rs�� �ᱹ sutudent���̺��� ����Ų��.
				
				sql = "SELECT NO,AGE,IRUM,HAKBUN FROM STUDENT WHERE IRUM = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, irumSearch);
				rs = pstmt.executeQuery();
				
				while(rs.next()) { //rs.next()�� ���� ���� ���� ������ true�� ��ȯ�Ѵ� 
					no = rs.getInt("no");
					age = rs.getString("age");
					irum = rs.getString("irum");
					hakbun = rs.getString("hakbun");
					System.out.println(no +"\t"+ age + "\t"+ irum + "\t" +hakbun + "\t");							
				}
				conn.close();
				pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}else if(select ==2) {//���� ã�� 
			try {
				conn = Regist.getConnection();
				
				sql = "SELECT NO,AGE,IRUM,SUBJECT FROM PROFESSOR WHERE IRUM = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, irumSearch);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					irum = rs.getString("irum");
					subject = rs.getString("subject");
					System.out.println(no +"\t"+ age + "\t"+ irum + "\t" +subject + "\t");
				
				}
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {  //������ ã�� 
			try {
				conn = Regist.getConnection();
				
				sql = "SELECT NO,AGE,IRUM,PART FROM MANAGER WHERE IRUM = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, irumSearch);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					no = rs.getInt("no");
					age = rs.getString("age");
					irum = rs.getString("irum");
					part = rs.getString("part");
					System.out.println(no +"\t"+ age + "\t"+ irum + "\t" +part + "\t");
				}
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	

}
