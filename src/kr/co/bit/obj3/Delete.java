package kr.co.bit.obj3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {
	private String deletIrum;
	private int select;
	private PreparedStatement pstmt;
	private int deletNo;
	private String sql;
	private int cnt;
	private Connection conn;
	
	public Delete() {
		deletIrum=null; select=0; deletNo=0; sql=null; cnt =0;
	
	}
	
	public void deleteProcess() {

		System.out.println("������ �̸��� �Է��Ͻÿ�");
		deletIrum = Regist.input.next();
		System.out.println("1.�л�  2.����  3.������");
		select = Regist.input.nextInt();
		System.out.println("no ��ȣ�� �Է��Ͻÿ�");
		deletNo = Regist.input.nextInt();
		
		if(select == 1) {
			try {
				conn = Regist.getConnection();

				sql = "DELETE FROM STUDENT WHERE irum = ? AND no = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, deletIrum);
				pstmt.setInt(2, deletNo);
				cnt = pstmt.executeUpdate();

				if (cnt == 0) {
					System.out.println("�л����� ����");
				} else {
					
					System.out.println(cnt + "���л� ���� ����");

				}
				conn.close();// ����
				pstmt.close();// ����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}else if(select ==2) {
			try {
				conn = Regist.getConnection();
				
				sql = "DELETE FROM PROFESSOR WHERE irum = ? AND no = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, deletIrum);
				pstmt.setInt(2, deletNo);
				cnt = pstmt.executeUpdate();
				
				if (cnt == 0) {
					System.out.println("�������� ����");
				} else {
					
					System.out.println(cnt + "���� ���� ����");

				}
				conn.close();// ����
				pstmt.close();// ����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(select ==3) {
			try {
				conn = Regist.getConnection();
				sql = "DELETE FROM PROFESSOR WHERE irum = ? AND no = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, deletIrum);
				pstmt.setInt(2, deletNo);
				cnt = pstmt.executeUpdate();
				if (cnt == 0) {
					System.out.println("�Ŵ��� ���� ����");
				} else {
					
					System.out.println(cnt + "�Ŵ���  ���� ����");
					

				}
				conn.close();// ����
				pstmt.close();// ����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}	
	
	}
	

}
