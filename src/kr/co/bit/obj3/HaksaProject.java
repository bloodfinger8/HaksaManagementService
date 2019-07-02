package kr.co.bit.obj3;


public class HaksaProject {

	public static void main(String[] args) {
		
		// 1.로드 -자바에게 데이터베이스오라클을 사용한다고 알림 Class.forName("oracle.jdbc.driver.OracleDriver");
		Regist regist = new Regist();
		Search search = new Search();
		Delete delete =new Delete();
		List list = new List();
		
		while (true) {
			System.out.println("학사관리");
			System.out.println("메뉴");
			System.out.println("1.등록 ");
			System.out.println("2.찾기 ");
			System.out.println("3.삭제");
			System.out.println("4.전체출력");
			System.out.println("0.돌아가기");
			System.out.println("========");
			System.out.println("번호를 선택 ");
			int protocol = Regist.input.nextInt();

			if (protocol == 1) { //찾기 
				regist.registProcess();
			}else if (protocol == 2) {
				search.searchProcess();
//------------------------------------------------------------------------------------------------삭제					
			} else if (protocol == 3) {
				delete.deleteProcess();
//------------------------------------------------------------------------------------------------전체출력
			} else if (protocol == 4) { //부서별로 나눠서 출력!
				list.listProcess();
			} 
		}

	}
}
