package Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Core.SQLConnection;
import Model.Product.CartModel;
import Model.Product.ProductModel;
import Model.User.UserModel;

public class ProductRepository extends SQLConnection{
	
	public Boolean AddProduct(ProductModel p) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		
		
		if (!ExistProduct(p.getCodigo())) {
		
			String query =
					"INSERT INTO productos (Codigo, idCategoria, idProveedor, Nombre, Descripcion, PrecioVenta, PrecioCompra, Stock)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			try {
				
				ps = conn.prepareStatement(query);
				ps.setString(1, p.getCodigo());
				ps.setInt(2, p.getCategoria());
				ps.setInt(3, p.getProvedor());
				ps.setString(4, p.getNombre());
				ps.setString(5, p.getDescripcion());
				ps.setFloat(6, p.getPrecioVenta());
				ps.setFloat(7, p.getPrecioCompra());
				ps.setInt(8, p.getStock());
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
		return false;
	}
	
	public ProductModel getProduct(String code) {
		ProductModel product = null;
		
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		//public ProductModel(String code, String name, String desc, int category, int prove, int stock, float priceV, float priceC ) {
		String query = "SELECT Codigo, Nombre, Descripcion, idCategoria, idProveedor, Stock, PrecioVenta, PrecioCompra FROM productos WHERE Codigo = ?";
		try {
			ps = conn.prepareStatement(query);
			/*ps.setString(1, username);
			ps.setString(2, pwd);*/
			ps.setString(1, code);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				//charge.add(rs.getString(1));
				product = new ProductModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getFloat(7), rs.getFloat(8));
			}
			return product;
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	public Boolean ExistProduct(String code) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		String query =
				"SELECT Codigo FROM productos WHERE Codigo = ?";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setString(1, code);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
			}
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
		return false;
	}
	///UPDATE `shop`.`productos` SET `Nombre` = 'Mota2', `Descripcion` = 'Un guato de mota 1kg2', `PrecioVenta` = '51.00', `PrecioCompra` = '31.00', `Stock` = '200' WHERE (`Codigo` = '3');
	public Boolean ModifyProduct(ProductModel p) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"UPDATE productos SET Nombre=?, Descripcion=?, PrecioVenta=?, PrecioCompra=?, Stock=? WHERE Codigo = ? ";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getDescripcion());
			ps.setFloat(3, p.getPrecioVenta());
			ps.setFloat(4, p.getPrecioCompra());
			ps.setInt(5, p.getStock());
			ps.setString(6, p.getCodigo());
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
	public Boolean DeleteProduct(String code) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"DELETE FROM productos WHERE Codigo = ?";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setString(1, code);
			ps.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> Category(){
			
			ArrayList <String> charge = new ArrayList<String>(); 
			
			PreparedStatement ps = null;
			Connection conn = getConnection();
			ResultSet rs = null;
			
			String query =
					"SELECT Nombre FROM categoria";
			
			/*Date cDate = new Date();
			
			String fCode = new SimpleDateFormat("yyMM").format(cDate);
			String date = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
			
			Formatter fmt = new Formatter();
			int totalUsers = CountUsers(fCode.substring(0, 2), fCode.substring(2, 3));
			String y = fCode.concat(String.valueOf(fmt.format("%02d", totalUsers)));
			
			System.out.println(y);*/
			try {
				ps = conn.prepareStatement(query);
				/*ps.setString(1, username);
				ps.setString(2, pwd);*/
				rs = ps.executeQuery();
				
				while (rs.next()) {
					charge.add(rs.getString(1));
				}
				return charge;
			}catch(SQLException e) {
				System.out.println(e);
			}finally {
				try {
					conn.close();
				}catch (SQLException e) {
					System.out.println(e);
				}
			}
			return null;
		}
	
	public ArrayList<String> Provedor(){
		
		ArrayList <String> charge = new ArrayList<String>(); 
		
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		String query =
				"SELECT Nombre FROM proveedor";
		
		try {
			ps = conn.prepareStatement(query);
			/*ps.setString(1, username);
			ps.setString(2, pwd);*/
			rs = ps.executeQuery();
			
			while (rs.next()) {
				charge.add(rs.getString(1));
			}
			return charge;
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}
	
	public Boolean UpdateStock(String code, int stock) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query = "UPDATE productos SET Stock = Stock - ? WHERE Codigo = ?";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, stock);
			ps.setString(2, code);
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
}
