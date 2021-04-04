package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Business.ProductRepository;
import Core.SQLConnection;
import Model.Product.ProductModel;
import View.MainScreen;
import View.ModifyProductView;

public class ModifyProductController extends SQLConnection implements ActionListener{
	
	private MainScreen view;
	private ProductRepository repo;
	private ModifyProductView modifyV;
	private ProductModel product;
	
	private String code;
	
	public ModifyProductController(MainScreen v, ModifyProductView mv, String code) {
		view = v;
		modifyV = mv;
		this.code = code;
		modifyV.btnGuardar.addActionListener(this);
		repo = new ProductRepository();
		product = repo.getProduct(code);
		modifyV.txtName.setText(product.getNombre());
		modifyV.txtDesc.setText(product.getDescripcion());
		modifyV.txtPriceC.setText(Float.toString(product.getPrecioCompra()));
		modifyV.txtPriceV.setText(Float.toString(product.getPrecioVenta()));
		modifyV.txtStock.setText(Integer.toString(product.getStock()));
		modifyV.lblProducto.setText("Producto: " + product.getCodigo());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == modifyV.btnGuardar) {
			String name = modifyV.txtName.getText();
			String desc = modifyV.txtDesc.getText();
			int stock = Integer.parseInt(modifyV.txtStock.getText());
			float precioV = Float.parseFloat(modifyV.txtPriceV.getText());
			float precioC = Float.parseFloat(modifyV.txtPriceC.getText());
			if (!name.isEmpty() && !desc.isEmpty() && stock >= 0 && precioV >= 0 && precioC >= 0) {
				if (repo.ModifyProduct(new ProductModel(code, name, desc, product.getCategoria(), product.getProvedor(), stock, product.getPrecioVenta(), product.getPrecioCompra()))) {
					JOptionPane.showMessageDialog(modifyV, "Modificación realizada con éxito.");
					modifyV.dispose();
				}else {
					JOptionPane.showMessageDialog(modifyV, "Ocurrio un error");
				}	
			}else {
				JOptionPane.showMessageDialog(modifyV,"Algun campo está vacio o con números negativos");
			}
		}
	}
	
}
