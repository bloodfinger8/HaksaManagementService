package kr.co.bit.gesigle;

public class BoardPoly {
	// 파라미터의 다형성을 구현하기 위해서 만들었다
	public void boardSQL(BoardInter board) { 
		board.boardSql();
	}
	
	public void boardClose(BoardInter board) {
		board.boardClose();
	}
	
	
}
