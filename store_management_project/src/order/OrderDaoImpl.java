package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import setting.MyConn;

public class OrderDaoImpl implements DaoOrder{
	
	private static OrderDaoImpl instance = new OrderDaoImpl();
	private OrderDaoImpl() {}
	public static OrderDaoImpl getInstance() {
		return instance;
	}
	

	//오더리스트조회
	@Override
	public List<DtoOrder> orderListFindAll() throws ClassNotFoundException, SQLException {
		// order_id, merchandise_id, category, name, quantity, price
		String sql = "select * from order_list";
		try (Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			List<DtoOrder> ordList = new ArrayList<DtoOrder>();

			while (rs.next()) {
				ordList.add(convertOrd(rs));
			}
			return ordList;
		}
	}
	
	
	//order_List에 추가하는 메소드
	@Override
	public int insert(DtoOrder order) throws ClassNotFoundException, SQLException {
		// order_id, merchandise_id, category, name, quantity, price
		String sql = "insert into order_list values(?,?,?,?,?,?);";
		try(Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getMerchandiseId());
			pst.setString(3, order.getCategory());
			pst.setString(4, order.getName());
			pst.setInt(5, order.getQuantity());
			pst.setInt(6, order.getPrice());
			return pst.executeUpdate();
		}
	}

	private DtoOrder convertOrd(ResultSet rs) throws SQLException {
		// order_id, merchandise_id, category, name, quantity, price
		return new DtoOrder(
				rs.getInt("order_Id"), 
				rs.getInt("merchandise_Id"), 
				rs.getString("category"), 
				rs.getString("name"),
				rs.getInt("quantity"), 
				rs.getInt("price"));
	}

}
