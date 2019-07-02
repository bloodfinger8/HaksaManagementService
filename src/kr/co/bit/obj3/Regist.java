package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Regist {

	private int protocol;
	public static Scanner input;
	public static Connection conn; 
	private int no;
	private String age;
	private String irum;
	private String hakbun;
	private String sql;
	private int cnt;
	private String subject;
	private String part;
	private PreparedStatement pstmt;

	static {
		input = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//로드를 스태틱에 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Regist() {

		protocol = 0;
		no = 0;
		age = null;
		irum = null;
		hakbun = null;
		sql = null;
		cnt = 0;
		subject = null;
		pstmt = null;
		part = null;

	}

	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void setProtocol() {
		System.out.println("등록 메뉴");
		System.out.println("1.학생 ");
		System.out.println("2.교수 ");
		System.out.println("3.관리자");
		System.out.println("4.이전메뉴");
		System.out.println("번호를 선택 ");
		protocol = input.nextInt();
	}

	public void registProcess() {
		getConnection();
		setProtocol();
		if (protocol == 1) {
			System.out.println("번호");
			no = input.nextInt();
			System.out.println("나이");
			age = input.next();
			System.out.println("이름");
			irum = input.next();
			System.out.println("학번");
			hakbun = input.next();
			// 3. 공간을 준비하고 문장을 준비한다. Stantement stmt = conn.crateStatement();
			try { //preparedStatement로 발전 실무에서 많이 사용된다
				conn = getConnection();
				sql = "INSERT INTO STUDENT(NO,AGE,IRUM,HAKBUN) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,no); //setInt라는 함수를 이용해서 값을 넣는다...
				pstmt.setString(2, age);
				pstmt.setString(3, irum);
				pstmt.setString(4, hakbun);
				cnt = pstmt.executeUpdate();
				//Statement stmt = conn.createStatement();
				//String sql = "INSERT INTO STUDENT(NO,AGE,IRUM,HAKBUN) VALUES(" + no + ",'" + age + "','" + irum + "','"+ hakbun + "')";
				// 4.실행 executeUpdate(sql) / executeQuery(sql)
				//cnt = stmt.executeUpdate(sql);
				System.out.println("학생정보가 추가 되었습니다.");
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (protocol == 2) {
			System.out.println("번호");
			no = input.nextInt();
			System.out.println("나이");
			age = input.next();
			System.out.println("이름");
			irum = input.next();
			System.out.println("과목");
			subject = input.next();

			try {
				conn = getConnection();
				
				sql = "INSERT INTO STUDENT(NO,AGE,IRUM,SUBJECT) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,no); //setInt라는 함수를 이용해서 값을 넣는다...
				pstmt.setString(2, age);
				pstmt.setString(3, irum);
				pstmt.setString(4, subject);
				cnt = pstmt.executeUpdate();
				
				if (cnt == 0) {
					System.out.println("교수정보가 추가가 실패했습니다.");
				} else {
					System.out.println("교수정보가 추가 되었습니다.");
				}
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (protocol == 3) {
			System.out.println("번호");
			no = input.nextInt();
			System.out.println("나이");
			age = input.next();
			System.out.println("이름");
			irum = input.next();
			System.out.println("부서");
			part = input.next();
			try {
				conn = getConnection();
				
				sql = "INSERT INTO STUDENT(NO,AGE,IRUM,PART) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,no); //setInt라는 함수를 이용해서 값을 넣는다...
				pstmt.setString(2, age);
				pstmt.setString(3, irum);
				pstmt.setString(4, part);
				cnt = pstmt.executeUpdate();
				
				if (cnt == 0) {
					System.out.println("관리자정보가 추가가 실패했습니다. ");
				} else {
					System.out.println("관리자정보가 추가가 성공했습니다. ");
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
