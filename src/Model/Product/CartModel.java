package Model.Product;

public class CartModel {

	private String code, description;
	private int cantidad;
	private float price, importe;
	
	public CartModel(String c, int cant, String desc, float p, float imp) {
		code = c;
		cantidad = cant;
		description = desc;
		price = p;
		importe = imp;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	

}
