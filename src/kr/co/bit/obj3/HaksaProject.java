package kr.co.bit.obj3;


public class HaksaProject {

	public static void main(String[] args) {
		
		// 1.�ε� -�ڹٿ��� �����ͺ��̽�����Ŭ�� ����Ѵٰ� �˸� Class.forName("oracle.jdbc.driver.OracleDriver");
		Regist regist = new Regist();
		Search search = new Search();
		Delete delete =new Delete();
		List list = new List();
		
		while (true) {
			System.out.println("�л����");
			System.out.println("�޴�");
			System.out.println("1.��� ");
			System.out.println("2.ã�� ");
			System.out.println("3.����");
			System.out.println("4.��ü���");
			System.out.println("0.���ư���");
			System.out.println("========");
			System.out.println("��ȣ�� ���� ");
			int protocol = Regist.input.nextInt();

			if (protocol == 1) { //ã�� 
				regist.registProcess();
			}else if (protocol == 2) {
				search.searchProcess();
//------------------------------------------------------------------------------------------------����					
			} else if (protocol == 3) {
				delete.deleteProcess();
//------------------------------------------------------------------------------------------------��ü���
			} else if (protocol == 4) { //�μ����� ������ ���!
				list.listProcess();
			} 
		}

	}
}
