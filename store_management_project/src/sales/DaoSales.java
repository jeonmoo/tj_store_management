package sales;

import java.sql.SQLException;
import java.util.List;

public interface DaoSales {
	
	//판매를 하는 메소드
	public int sales(DtoSales sales) throws ClassNotFoundException, SQLException;

	//판매기록 전부를 조회하는 메소드
	public List<DtoSales> salesFindAll() throws ClassNotFoundException, SQLException;
	
	//기간동안 판매기록을 조회하는 메소드
	public List<DtoSales> salesFindTerm(String selectStart, String selectEnd) throws ClassNotFoundException, SQLException;
	
	
}
