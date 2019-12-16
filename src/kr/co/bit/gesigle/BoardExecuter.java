package kr.co.bit.gesigle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;


public class BoardExecuter {

	public static void main(String[] args) {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//클래스 객체 생성
			Register register = new Register();
			Search search = new Search();
			Delete delete = new Delete();
			List list = new List();
			Update update = new Update();
			BoardPoly boardPoly = new BoardPoly();
			
			
			while (true) {
				Connection conn=null;
				
				try {
					conn = Register.getConnection();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				if (conn == null) {
					System.out.println("연결싶패");
				} else {
					System.out.println("성공 ");
					System.out.println("R등록 S검색 D삭제 U수정 L목록");
					String protocol = null;
					try {
						protocol = br.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (protocol.equals("R") || protocol.equals("r")) { //등록
						try {
							boardPoly.boardSQL(register);
							register.boardProcess();
							boardPoly.boardClose(register);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if(protocol.equals("L")||protocol.equals("l")) { //전체출력
						try {
							boardPoly.boardSQL(list);
							list.boardProcess();
							boardPoly.boardClose(list);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}else if(protocol.equals("S")||protocol.equals("s")) { //검색
						try {
							boardPoly.boardSQL(search);
							search.boardProcess();
							boardPoly.boardClose(search);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if(protocol.equals("D")||protocol.equals("d")) {//삭제
						try {
							boardPoly.boardSQL(delete);
							delete.boardProcess();
							boardPoly.boardClose(delete);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if(protocol.equals("U")||protocol.equals("u")) {//삭제
						try {
							boardPoly.boardSQL(update);
							update.boardProcess();
							boardPoly.boardClose(update);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				} 
		
		
		
			}
	}

}

