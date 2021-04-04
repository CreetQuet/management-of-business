package Model.Sale;

import java.sql.Date;

public class SaleModel {

	private int idSale;
	private int codeEmploy;
	private Date dateTime;
	private float money;
	private float moneyChange;
	private float total;
	
	public SaleModel(int id, int codeEmp, float t, float money, float moneyChang) {
		this.idSale = id;
		this.codeEmploy = codeEmp;
		//this.dateTime = dateTime;
		this.total = t;
		this.money = money;
		this.moneyChange = moneyChang;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public int getCodeEmploy() {
		return codeEmploy;
	}

	public void setCodeEmploy(int codeEmploy) {
		this.codeEmploy = codeEmploy;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public float getMoneyChange() {
		return moneyChange;
	}

	public void setMoneyChange(float moneyChange) {
		this.moneyChange = moneyChange;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
