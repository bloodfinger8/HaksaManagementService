package kr.co.bit.login;

import java.io.IOException;
import java.sql.SQLException;

public class MemberExecute {

	
	public static void main(String[] args) {
		
		try {
			Login login = new Login();
			Logout logout = new Logout();
			Register register = new Register();
			List list = new List();
			Search search = new Search();
			Delete delete = new Delete();
			Alter alter = new Alter();
			MemberPoly memberpoly = new MemberPoly();
	
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			while(true) {
				
				System.out.println("R:회원가입 L:회원목록 S:ID찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃");
				String protocol =Register.br.readLine();
				
					
				if (protocol.equals("R") || protocol.equals("r")) { 
					memberpoly.memberSQL(register);
					register.registerProcess();
				}else if(protocol.equals("L")||protocol.equals("l")){
					memberpoly.memberSQL(list);
					list.listProcess();
				}else if(protocol.equals("S")||protocol.equals("s")){ 
					memberpoly.memberSQL(search);
					search.searchProcess();	
				}else if(protocol.equals("D")||protocol.equals("d")){ 
					memberpoly.memberSQL(delete);
					delete.deleteProcess();	
				} else if (protocol.equals("E") || protocol.equals("e")) {
					memberpoly.memberSQL(alter);
					alter.alterProcess();
				}else if(protocol.equals("I")||protocol.equals("i")) {
					memberpoly.memberSQL(login);
					login.loginProcess();
				}else if(protocol.equals("O")||protocol.equals("o")) {
					logout.logoutProcess();
				}else {
					System.out.println("잘못입력 하셨습니다.");
				}
				
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
