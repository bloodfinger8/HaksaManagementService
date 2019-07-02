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
		System.out.println("전체출력");
		System.out.println("1.학생전체출력 2.교수전체출력 3.관리자전체출력 4.전체출력");
		select = Regist.input.nextInt();
		if(select ==1) { //학생전체 출력
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
			//교수전체 출력
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

		} else if(select==4) { //학사 전체 출력
			
			try {
				conn = Regist.getConnection();
				
				//sql = "select s.no as 번호,s.age as 학생나이,s.irum as 학생이름,s.hakbun as 학번,p.age as 교수나이,p.irum as 교수이름,p.subject as 과목,m.age as 관리자나이,m.irum as 관리자이름,m.part as 부서 from (student s left join professor p on s.no=p.no) left join manager m on s.no=m.no ORDER BY 번호 ASC";
				sql = "select  s.no AS 번호 ,s.age AS 학생나이,s.irum AS 학생이름 ,s.hakbun AS 학번 ,p.age AS 교수나이 ,p.irum AS 교수이름 ,p.subject AS 과목 ,m.age AS 관리자나이,m.irum AS 관리자이름,m.part AS 부서 from student s, professor p, manager m where s.no=p.no AND s.no=m.no order by 번호 asc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println("번호\t나이\t이름\t학번 \t교수나이\t교수이름\t과목\t관리자나이\t관리자이름\t부서");
				System.out.println("----------------------------------------------------------------------------");
				while(rs.next()) {
					no = rs.getInt("번호");
					age = rs.getString("학생나이");
					irum = rs.getString("학생이름");
					hakbun = rs.getString("학번");
					age1 = rs.getString("교수나이");
					irum1 = rs.getString("교수이름");					
					subject = rs.getString("과목");
					age2 = rs.getString("관리자나이");
					irum2 = rs.getString("관리자이름");	
					part = rs.getString("부서");
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
