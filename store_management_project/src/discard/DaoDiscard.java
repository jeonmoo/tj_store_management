package discard;

import java.sql.SQLException;
import java.util.List;

public interface DaoDiscard {
	
	//폐기리스트 전체를 출력하는 메소드
	public List<Dtodiscard> discardFindAll() throws ClassNotFoundException, SQLException;
	
	//입력한 기간동안의 폐기리스트를 출력하는 메소드 
	public List<Dtodiscard> discardFindTerm(String selectStart, String selectEnd) throws ClassNotFoundException, SQLException;
	
	//폐기시키는 메소드(폐기리스트에 추가하고 재고목록에서 삭제)
	public int insertDiscard(Dtodiscard discard) throws ClassNotFoundException, SQLException;

}
