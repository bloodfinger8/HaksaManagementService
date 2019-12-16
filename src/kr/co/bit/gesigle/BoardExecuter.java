package kr.co.bit.gesigle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;


public class BoardExecuter {

	public static void main(String[] args) {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//Ŭ���� ��ü ����
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
					System.out.println("�������");
				} else {
					System.out.println("���� ");
					System.out.println("R��� S�˻� D���� U���� L���");
					String protocol = null;
					try {
						protocol = br.readLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (protocol.equals("R") || protocol.equals("r")) { //���
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
					}else if(protocol.equals("L")||protocol.equals("l")) { //��ü���
						try {
							boardPoly.boardSQL(list);
							list.boardProcess();
							boardPoly.boardClose(list);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}else if(protocol.equals("S")||protocol.equals("s")) { //�˻�
						try {
							boardPoly.boardSQL(search);
							search.boardProcess();
							boardPoly.boardClose(search);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if(protocol.equals("D")||protocol.equals("d")) {//����
						try {
							boardPoly.boardSQL(delete);
							delete.boardProcess();
							boardPoly.boardClose(delete);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else if(protocol.equals("U")||protocol.equals("u")) {//����
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

