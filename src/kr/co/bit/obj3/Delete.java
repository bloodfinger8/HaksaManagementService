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

		System.out.println("삭제할 이름을 입력하시오");
		deletIrum = Regist.input.next();
		System.out.println("1.학생  2.교수  3.관리자");
		select = Regist.input.nextInt();
		System.out.println("no 번호를 입력하시오");
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
					System.out.println("학생삭제 실패");
				} else {
					
					System.out.println(cnt + "건학생 삭제 성공");

				}
				conn.close();// 종료
				pstmt.close();// 종료
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
					System.out.println("교수삭제 실패");
				} else {
					
					System.out.println(cnt + "교수 삭제 성공");

				}
				conn.close();// 종료
				pstmt.close();// 종료
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
					System.out.println("매니저 삭제 실패");
				} else {
					
					System.out.println(cnt + "매니저  삭제 성공");
					

				}
				conn.close();// 종료
				pstmt.close();// 종료
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}	
	
	}
	

}
