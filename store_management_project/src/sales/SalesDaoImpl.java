package sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import setting.MyConn;

public class SalesDaoImpl implements DaoSales{
	
	private static SalesDaoImpl instance = new SalesDaoImpl();
	private SalesDaoImpl() {}
	public static SalesDaoImpl getInstance() {
		return instance;
	}
	
	//판매목록에 추가하는 메소드
	@Override
	public int sales(DtoSales sales) throws ClassNotFoundException, SQLException {
		//sales_list - sales_id, merchandise_id, category, name, quantity, price, sales_datetime
//		String sql = "delete from merchandise where id = ?;";
		String sql = "insert into sales_list values (?,?,?,?,?,?,?);";
		try(Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, 0);
			pst.setInt(2, sales.getMerchandise_Id());
			pst.setString(3, sales.getCategory());
			pst.setString(4, sales.getName());;
			pst.setInt(5, sales.getQuantity());
			pst.setInt(6, sales.getPrice());
			pst.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			return pst.executeUpdate();
			}
		}
	
		
		
	

	//판매기록 전부를 조회하는 메소드
	@Override
	public List<DtoSales> salesFindAll() throws ClassNotFoundException, SQLException {
		//sales_id, merchandise_id, category, name, quantity, price, sales_datetime
		String sql = "select * from sales_list;";
		try(Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()){
			
			List<DtoSales> salesList = new ArrayList<DtoSales>();
			while(rs.next()) {
				salesList.add(convertSal(rs));
			}
			return salesList;
		}
		
	}

	//기간동안 판매기록을 조회하는 메소드
	@Override
	public List<DtoSales> salesFindTerm(String selectStart, String selectEnd) throws ClassNotFoundException, SQLException {
		//sales_id, merchandise_id, category, name, quantity, price, sales_datetime
		String sql = "select * from sales_list where sales_datetime >= ? and sales_datetime <= ?;";
		try(Connection conn = MyConn.getConn();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, selectStart);
			pst.setString(2, selectEnd);
			try(ResultSet rs = pst.executeQuery()){
				List<DtoSales> salesList = new ArrayList<DtoSales>();
				while(rs.next()) {
					salesList.add(convertSal(rs));
				}
				return salesList;
			}
		
		}
		
	}
	
	public DtoSales convertSal(ResultSet rs) throws SQLException {
		//sales_id, merchandise_id, category, name, quantity, price, sales_datetime
		return new DtoSales(
				rs.getInt("sales_id"),
				rs.getInt("merchandise_id"),
				rs.getString("category"),
				rs.getString("name"),
				rs.getInt("quantity"),
				rs.getInt("price"),
				rs.getTimestamp("sales_datetime").toLocalDateTime()
				);
	}

}
