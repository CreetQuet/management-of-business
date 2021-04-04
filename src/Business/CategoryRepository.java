package Business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Core.SQLConnection;

public class CategoryRepository extends SQLConnection{

	public Boolean AddCategory(String name) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"INSERT INTO categoria (Nombre) VALUES(?)";
		try {
			
			ps = conn.prepareStatement(query);
			//ps.setInt(1, user.getCode());
			ps.setString(1, name);
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
	
	public Boolean DeleteCategory(int code) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"DELETE FROM categoria WHERE idCategoria = ? ";

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
	
	public int SearchCategory(String name) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		int res = 0;
		String query =
				"SELECT idCategoria FROM categoria WHERE Nombre = ? ";

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
