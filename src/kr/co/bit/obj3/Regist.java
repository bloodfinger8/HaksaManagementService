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
			Class.forName("oracle.jdbc.driver.OracleDriver");//�ε带 ����ƽ�� 
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
		System.out.println("��� �޴�");
		System.out.println("1.�л� ");
		System.out.println("2.���� ");
		System.out.println("3.������");
		System.out.println("4.�����޴�");
		System.out.println("��ȣ�� ���� ");
		protocol = input.nextInt();
	}

	public void registProcess() {
		getConnection();
		setProtocol();
		if (protocol == 1) {
			System.out.println("��ȣ");
			no = input.nextInt();
			System.out.println("����");
			age = input.next();
			System.out.println("�̸�");
			irum = input.next();
			System.out.println("�й�");
			hakbun = input.next();
			// 3. ������ �غ��ϰ� ������ �غ��Ѵ�. Stantement stmt = conn.crateStatement();
			try { //preparedStatement�� ���� �ǹ����� ���� ���ȴ�
				conn = getConnection();
				sql = "INSERT INTO STUDENT(NO,AGE,IRUM,HAKBUN) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,no); //setInt��� �Լ��� �̿��ؼ� ���� �ִ´�...
				pstmt.setString(2, age);
				pstmt.setString(3, irum);
				pstmt.setString(4, hakbun);
				cnt = pstmt.executeUpdate();
				//Statement stmt = conn.createStatement();
				//String sql = "INSERT INTO STUDENT(NO,AGE,IRUM,HAKBUN) VALUES(" + no + ",'" + age + "','" + irum + "','"+ hakbun + "')";
				// 4.���� executeUpdate(sql) / executeQuery(sql)
				//cnt = stmt.executeUpdate(sql);
				System.out.println("�л������� �߰� �Ǿ����ϴ�.");
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (protocol == 2) {
			System.out.println("��ȣ");
			no = input.nextInt();
			System.out.println("����");
			age = input.next();
			System.out.println("�̸�");
			irum = input.next();
			System.out.println("����");
			subject = input.next();

			try {
				conn = getConnection();
				
				sql = "INSERT INTO STUDENT(NO,AGE,IRUM,SUBJECT) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,no); //setInt��� �Լ��� �̿��ؼ� ���� �ִ´�...
				pstmt.setString(2, age);
				pstmt.setString(3, irum);
				pstmt.setString(4, subject);
				cnt = pstmt.executeUpdate();
				
				if (cnt == 0) {
					System.out.println("���������� �߰��� �����߽��ϴ�.");
				} else {
					System.out.println("���������� �߰� �Ǿ����ϴ�.");
				}
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (protocol == 3) {
			System.out.println("��ȣ");
			no = input.nextInt();
			System.out.println("����");
			age = input.next();
			System.out.println("�̸�");
			irum = input.next();
			System.out.println("�μ�");
			part = input.next();
			try {
				conn = getConnection();
				
				sql = "INSERT INTO STUDENT(NO,AGE,IRUM,PART) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,no); //setInt��� �Լ��� �̿��ؼ� ���� �ִ´�...
				pstmt.setString(2, age);
				pstmt.setString(3, irum);
				pstmt.setString(4, part);
				cnt = pstmt.executeUpdate();
				
				if (cnt == 0) {
					System.out.println("������������ �߰��� �����߽��ϴ�. ");
				} else {
					System.out.println("������������ �߰��� �����߽��ϴ�. ");
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
