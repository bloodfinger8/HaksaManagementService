package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class List {
	private int select;
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	private int no;
	private String age;
	private String irum;
	private String hakbun;
	private String subject;
	private String part;
	private Connection conn;
	private String age1;
	private String irum1;
	private String age2;
	private String irum2;
	
	public List() {
		select = 0; no=0; age=null; irum=null; hakbun=null; part=null; part=null;
		sql=null; subject=null;
		
	}
	

	
	public void listProcess() {
		System.out.println("��ü���");
		System.out.println("1.�л���ü��� 2.������ü��� 3.��������ü��� 4.��ü���");
		select = Regist.input.nextInt();
		if(select ==1) { //�л���ü ���
			try {
				conn = Regist.getConnection();
				sql = "SELECT NO,AGE,IRUM, HAKBUN FROM STUDENT ORDER BY NO ASC";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
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
		}else if(select ==2 ) {
			try {
			//������ü ���
				conn = Regist.getConnection();
				sql = "SELECT NO,AGE,IRUM,SUBJECT FROM PROFESSOR ORDER BY NO ASC";
				pstmt = conn.prepareStatement(sql);
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
		}else if(select == 3) {
			try {
				conn = Regist.getConnection();
				sql = "SELECT NO,AGE,IRUM, PART FROM MANAGER ORDER BY NO ASC";
				pstmt = conn.prepareStatement(sql);
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

		} else if(select==4) { //�л� ��ü ���
			
			try {
				conn = Regist.getConnection();
				
				//sql = "select s.no as ��ȣ,s.age as �л�����,s.irum as �л��̸�,s.hakbun as �й�,p.age as ��������,p.irum as �����̸�,p.subject as ����,m.age as �����ڳ���,m.irum as �������̸�,m.part as �μ� from (student s left join professor p on s.no=p.no) left join manager m on s.no=m.no ORDER BY ��ȣ ASC";
				sql = "select  s.no AS ��ȣ ,s.age AS �л�����,s.irum AS �л��̸� ,s.hakbun AS �й� ,p.age AS �������� ,p.irum AS �����̸� ,p.subject AS ���� ,m.age AS �����ڳ���,m.irum AS �������̸�,m.part AS �μ� from student s, professor p, manager m where s.no=p.no AND s.no=m.no order by ��ȣ asc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println("��ȣ\t����\t�̸�\t�й� \t��������\t�����̸�\t����\t�����ڳ���\t�������̸�\t�μ�");
				System.out.println("----------------------------------------------------------------------------");
				while(rs.next()) {
					no = rs.getInt("��ȣ");
					age = rs.getString("�л�����");
					irum = rs.getString("�л��̸�");
					hakbun = rs.getString("�й�");
					age1 = rs.getString("��������");
					irum1 = rs.getString("�����̸�");					
					subject = rs.getString("����");
					age2 = rs.getString("�����ڳ���");
					irum2 = rs.getString("�������̸�");	
					part = rs.getString("�μ�");
					System.out.println(no +"\t"+ age + "\t"+ irum +"\t"+ hakbun +"\t"+ age1 + "\t" + irum1 +"\t"+ subject +"\t"+ age2 + "\t"+ irum2 +"\t" +part + "\t");
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
