package merchandise;

import java.sql.SQLException;
import java.util.List;

public interface DaoMerchandise {
	
	// 데이터베이스에 merchandise객체 삽입
	public int insert(DtoMerchandise merchandise) throws ClassNotFoundException, SQLException;

	// 디비에서 id로 조회하는 메서드
	public DtoMerchandise merchandiseFindById(int id) throws ClassNotFoundException, SQLException;

	// 디비에서 전체 조회하는 메서드
	public List<DtoMerchandise> merchandiseFindAll() throws ClassNotFoundException, SQLException;

	// 디비에서 이름을 조회 메서드
	public List<DtoMerchandise> merchandiseFindByName(String name) throws ClassNotFoundException, SQLException;

	// 디비에서 id로 삭제 메서드
	public int delete(int id) throws ClassNotFoundException, SQLException;

	// 디비에서 merchandise를 수정하는 메서드
	public int update(DtoMerchandise merchandise) throws ClassNotFoundException, SQLException;
	
	//디비에서 판매현황 조회
	public List<DtoMerchandise> merchandiseFindsale () throws ClassNotFoundException, SQLException;

	
	
	

}
