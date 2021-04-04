package Model.User;

import java.sql.Date;

/*
 *  Date miFechaYHora = new Date(rs.getTimestamp(1).getTime());
 * */

public class UserModel {

	private int code, charge;
	private String name, username, password, RFC, NSS;
	private Date date;
	
	public UserModel() {
		super();
	}
	
	public UserModel(int code, String name, String user, String pwd, String rfc, String nss, Date date, int charge) {
		this.code = code;
		this.name = name;
		this.username = user;
		this.password = pwd;
		this.RFC = rfc;
		this.NSS = nss;
		this.date = date;
		this.charge = charge;
	}
	
	
	/*public User() {
		super();
	}
	
	public User(int code, int charge, String name, String username, String RFC, String NSS, Date date) {
		this.code = code;
		this.charge = charge;
		this.name = name;
		this.username = username;
		this.RFC = RFC;
		this.NSS = NSS;
		this.date = date;
	}*/

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCode() {
		return code;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public Date getDate() {
		return date;
	}
	
	

}
