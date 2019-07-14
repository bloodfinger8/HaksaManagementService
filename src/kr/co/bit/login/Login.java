package kr.co.bit.login;

import java.io.IOException;
import java.sql.SQLException;

public class Login extends Member implements MemberInterface{

	private String dbId;
	private String dbPasswd;
	
	public static String session;
	public static int count;
	
	static {
		session=null;
		count=0;
	}
	
	public Login() {
		super();
		dbId = null;
		dbPasswd = null;
	}
	

	public void loginCheak() {
		if (count == 3) {
			System.out.println("로그인 3회 실패");
			System.exit(0);
		}
	}
	
	public void insertIdPwd() throws IOException{
		System.out.println("아이디 입력 : ");
		id = Register.br.readLine();
		System.out.println("패스워드 입력 : ");
		passwd = Register.br.readLine();
	}
	@Override
	public void memberSql() {
		sql = "select id,passwd,juso,bunho from member where id=?";
	}

	public void loginProcess() throws IOException, SQLException {
		while (true) {
			loginCheak();
			if (session != null) {
				System.out.println("로그인 중입니다.");
				return;
			}
			insertIdPwd();
			conn = Member.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				System.out.println("아이디가 존재하지 않는다.");
				count++;
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dbId = rs.getString("id");
				dbPasswd = rs.getString("passwd");

				if (id.equals(dbId) && passwd.equals(dbPasswd)) {
					session = id;
					count = 0; //초기화
					System.out.println("로그인 성공");
					return;
				} else if (!passwd.equals(dbPasswd)) {
					System.out.println("비밀번호가 틀렸습니다");
					count++;
				}

			}
			memberClose();
		}
	}

}
