package Business;

import Model.User.UserModel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Core.SQLConnection;

public class UserRepository extends SQLConnection{
	
	private String username;
	private String password;
	
	public UserModel userInfo = null;
	
	public Boolean ValidateUser() {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		String query =
				"SELECT * FROM empleados WHERE Username=? and Password=?";
		
		/*Date cDate = new Date();
		
		String fCode = new SimpleDateFormat("yyMM").format(cDate);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
		
		Formatter fmt = new Formatter();
		int totalUsers = CountUsers(fCode.substring(0, 2), fCode.substring(2, 3));
		String y = fCode.concat(String.valueOf(fmt.format("%02d", totalUsers)));
		
		System.out.println(y);*/
		
		String pwd = encryptPassword(password);
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				userInfo = new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8));
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
	
	public UserModel User(ResultSet rs) {
	//	UserModel u = null;
		try {
			if (rs.next()) {
				userInfo = new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8));
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Boolean AddUser(UserModel user) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"INSERT INTO empleados (CodigoEmpleado, Nombre, Username, Password, RFC, NSS, Fecha, CodigoPuesto)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, user.getCode());
			ps.setString(2, user.getName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getRFC());
			ps.setString(6, user.getNSS());
			ps.setDate(7, user.getDate());
			ps.setInt(8, user.getCharge());
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
	
	public Boolean ModifyUser(UserModel user) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"UPDATE empleados SET Nombre=?, Username=?, Password=?, RFC=?, NSS=?, CodigoPuesto=? WHERE CodigoEmpleado = ? ";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, encryptPassword(user.getPassword()));
			ps.setString(4, user.getRFC());
			ps.setString(5, user.getNSS());
			ps.setInt(6, user.getCharge());
			ps.setInt(7, user.getCode());
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
	
	public Boolean DeleteUser(int code) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		String query =
				"DELETE FROM empleados WHERE CodigoEmpleado = ? ";

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
	
	public Boolean SearchUser(UserModel user) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		//UserModel user2 = null;
		
		String query =
				"SELECT * FROM empleados WHERE CodigoEmpleado = ? ";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, user.getCode());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				user.setCode(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setRFC(rs.getString(5));
				user.setNSS(rs.getString(6));
				user.setDate(rs.getDate(7));
				user.setCharge(rs.getInt(8));
			}
			
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
	
	public int CountUsers(String year) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		int res;
		
		String query =
				"SELECT Count(*) FROM empleados WHERE Fecha LIKE ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "__%" + year + "%");

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
	
	public ArrayList<String> charge(){
		
		ArrayList <String> charge = new ArrayList<String>(); 
		
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		String query =
				"SELECT Nombre FROM puesto";
		
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
	
	
	public String encryptPassword (String s) {
		try {
			
			MessageDigest encrypt = MessageDigest.getInstance("SHA-1");
			byte[] array = encrypt.digest(s.getBytes());
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF | 0x100)).substring(1,3));
			}
	
			return sb.toString();
			
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*import java.security.MessageDigest;
	import javax.crypto.Cipher;
	import javax.crypto.spec.SecretKeySpec;*/
	/*public String EncryptPassword(byte[] a) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		return a.toString();
	}
	public byte[] Encrypt(String sinCifrar) throws Exception {
		final byte[] bytes = sinCifrar.getBytes("UTF-8");
		final Cipher aes = getCipher(true);
		final byte[] cifrado = aes.doFinal(bytes);
		return cifrado;
	}

	public String Decrypt(byte[] cifrado) throws Exception {
		final Cipher aes = getCipher(false);
		final byte[] bytes = aes.doFinal(cifrado);
		final String sinCifrar = new String(bytes, "UTF-8");
		return sinCifrar;
	}

	private Cipher getCipher(boolean paraCifrar) throws Exception {
		final String frase = "/8Wncr26eAmxD1l6cAF9F8";
		final MessageDigest digest = MessageDigest.getInstance("SHA1");
		digest.update(frase.getBytes("UTF-8"));
		final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

		final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		if (paraCifrar) {
			aes.init(Cipher.ENCRYPT_MODE, key);
		} else {
			aes.init(Cipher.DECRYPT_MODE, key);
		}
		return aes;
	}*/
	
	
	
	public String getUsername() {
		return username;
	}

	public UserModel getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserModel userInfo) {
		this.userInfo = userInfo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
