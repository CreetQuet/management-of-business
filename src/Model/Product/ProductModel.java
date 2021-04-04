package Model.Product;

public class ProductModel {

	private int Categoria, Provedor, Stock;
	private float PrecioVenta, PrecioCompra;
	private String Nombre, Descripcion, Codigo;
	
	public ProductModel() {
		super();
	}
	
	public ProductModel(String code, String name, String desc, int category, int prove, int stock, float priceV, float priceC ) {
		Codigo = code;
		Nombre = name;
		Descripcion = desc;
		Categoria = category;
		Provedor = prove;
		Stock = stock;
		PrecioVenta = priceV;
		PrecioCompra = priceC;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public int getCategoria() {
		return Categoria;
	}

	public void setCategoria(int categoria) {
		Categoria = categoria;
	}

	public int getProvedor() {
		return Provedor;
	}

	public void setProvedor(int provedor) {
		Provedor = provedor;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public float getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		PrecioVenta = precioVenta;
	}

	public float getPrecioCompra() {
		return PrecioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		PrecioCompra = precioCompra;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	

}
