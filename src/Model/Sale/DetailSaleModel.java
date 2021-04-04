package Model.Sale;

public class DetailSaleModel {

	private int idSale;
	private String productCode;
	private float price;
	private int cant;
	private float subTotal;
	
	public DetailSaleModel(int id, String code, float p, int c, float sT) {
		idSale = id;
		productCode = code;
		price = p;
		cant = c;
		subTotal = sT;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	
	
}
