package order;

import java.sql.SQLException;
import java.util.List;

public interface DaoOrder {

	//order_list를 조회하는 메소드
	public List<DtoOrder> orderListFindAll() throws ClassNotFoundException, SQLException;
	
	//order_List에 추가하는 메소드
	public int insert(DtoOrder order) throws ClassNotFoundException, SQLException;
	
	
	
	
	
	
	
	
	
	
	
	
}
