package discard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import setting.MyConn;

public class DiscardDaoImpl implements DaoDiscard{

	private static DiscardDaoImpl instance = new DiscardDaoImpl();
	private DiscardDaoImpl() {}
	public static DiscardDaoImpl getInstance() {
		return instance;
	}

	//폐기리스트 전체를 출력하는 메소드
	@Override
	public List<Dtodiscard> discardFindAll() throws ClassNotFoundException, SQLException {
		//discard_id, merchandise_id, category, name, quantity, price, discard_datetime
		String sql = "select * from discard_list;";
		try(Connection conn = MyConn.getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){

			List<Dtodiscard> disList = new ArrayList<Dtodiscard>();
			while(rs.next()) {
				disList.add(convertDis(rs));
			}
			return disList;
		}
	}

	//입력한 기간동안의 폐기리스트를 출력하는 메소드 
	@Override
	public List<Dtodiscard> discardFindTerm(String selectStart, String selectEnd) throws ClassNotFoundException, SQLException {
		//discard_id, merchandise_id, category, name, quantity, price, discard_datetime
		String sql = "select * from discard_list where discard_datetime >= ? and discard_datetime <= ?;";
		try(Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, selectStart);
			pst.setString(2, selectEnd);
			try(ResultSet rs = pst.executeQuery()){
				List<Dtodiscard> disList = new ArrayList<Dtodiscard>();
				while(rs.next()) {
					disList.add(convertDis(rs));
				}
				return disList;
			}
			
		}

	}

	//폐기시키는 메소드(폐기리스트에 추가하고 재고목록에서 삭제)
	@Override
	public int insertDiscard(Dtodiscard discard) throws ClassNotFoundException, SQLException {
		//discard_id, merchandise_id, category, name, quantity, price, discard_datetime
		String sql = "insert into discard_list values (?,?,?,?,?,?,?);";
		try(Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, 0);
			pst.setInt(2, discard.getMerchandiseId());
			pst.setString(3, discard.getCategory());
			pst.setString(4, discard.getName());
			pst.setInt(5, discard.getQuantity());
			pst.setInt(6, discard.getPrice());
			pst.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			
			return pst.executeUpdate();
		}


	}

	private Dtodiscard convertDis(ResultSet rs) throws SQLException {
		return new Dtodiscard(
				rs.getInt("discard_id"),
				rs.getInt("merchandise_id"),
				rs.getString("category"),
				rs.getString("name"),
				rs.getInt("quantity"),
				rs.getInt("price"),
				rs.getTimestamp("discard_datetime").toLocalDateTime()

				);
	}



























}
