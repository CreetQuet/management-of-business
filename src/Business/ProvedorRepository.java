package Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Core.SQLConnection;

public class ProvedorRepository extends SQLConnection{
	
	public Boolean AddProvedor(String name, String tel) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"INSERT INTO proveedor (Nombre, Telefono) VALUES(?,?)";
		try {
			
			ps = conn.prepareStatement(query);
			//ps.setInt(1, user.getCode());
			ps.setString(1, name);
			ps.setString(2, tel);
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
	public Boolean DeleteProvedor(int code) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"DELETE FROM proveedor WHERE idProveedor = ? ";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, code);
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
	public int SearchProvedor(String name) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		int res = 0;
		String query =
				"SELECT idProveedor FROM proveedor WHERE Nombre = ? ";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
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
