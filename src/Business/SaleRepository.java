package Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Core.SQLConnection;
import Model.Sale.SaleModel;

public class SaleRepository extends SQLConnection{
	
	public Boolean AddSale(SaleModel sale) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"INSERT INTO venta (idVenta, CodigoEmpleado, Fecha, Total, Efectivo, Cambio) VALUES(?,?,now(),?,?,?)";
		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, sale.getIdSale());
			ps.setInt(2, sale.getCodeEmploy());
			//ps.setDate(2, sale.getDateTime());
			ps.setFloat(3, sale.getTotal());
			ps.setFloat(4, sale.getMoney());
			ps.setFloat(5, sale.getMoneyChange());
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	public Boolean AddDetailSale(int idSale, String code, float price, int cant, float imp) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"INSERT INTO detallesventa (idVenta, CodigoProducto, Precio, Cantidad, Subtotal) VALUES(?,?,?,?,?)";
		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, idSale);
			ps.setString(2, code);
			ps.setFloat(3, price);
			ps.setInt(4, cant);
			ps.setFloat(5, imp);
			ps.execute();
			
			return true;
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	public int CountSales() {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		int res;
		
		String query =
				"SELECT Count(*) FROM venta";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				res = rs.getInt(1);
				return res;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			return 0;
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		return 0;
	}
}
