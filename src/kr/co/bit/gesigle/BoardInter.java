package kr.co.bit.gesigle;

import java.io.IOException;
import java.sql.SQLException;

public interface BoardInter {
	
	//�߻� �޼ҵ�
	public abstract void boardSql();
	public abstract void boardClose();
	public abstract void boardProcess() throws SQLException, IOException, ClassNotFoundException;

}
