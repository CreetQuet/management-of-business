package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Business.CategoryRepository;
import Business.ProductRepository;
import Business.ProvedorRepository;
import Model.Product.ProductModel;
import View.AddProductView;

public class AddProductController implements ActionListener{

	private AddProductView view;
	private ProductRepository model;
	
	private ArrayList<String> Ccategory = new ArrayList<String>();
	private ArrayList<String> Cprovedor = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public AddProductController(AddProductView v, ProductRepository pr) {
		view = v;
		model = pr;
		
		view.cbCategory.addActionListener(this);
		view.cbProvedor.addActionListener(this);
		view.btnRegisterProduct.addActionListener(this);
		
		Ccategory = model.Category();
		Cprovedor = model.Provedor();
		if (Ccategory != null && Cprovedor != null) {
			for (String c : Ccategory) {
				view.cbCategory.addItem(c);
			}
			
			for (String c : Cprovedor) {
				view.cbProvedor.addItem(c);
			}
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if (e.getSource() == view.btnRegisterProduct) {
				int categoria = 0, provedor = 0;
				String code = view.txtCode.getText();
				int stock = Integer.parseInt(view.txtStock.getText());
				
				float priceV = Float.parseFloat(view.txtPriceA.getText());
				float priceC = Float.parseFloat(view.txtPriceB.getText());
				
				String name = view.txtName.getText();
				String descp = view.txtDescription.getText();
				CategoryRepository catRepo = new CategoryRepository();
				ProvedorRepository proRepo = new ProvedorRepository();

				categoria = catRepo.SearchCategory(view.cbCategory.getSelectedItem().toString());
				provedor = proRepo.SearchProvedor(view.cbProvedor.getSelectedItem().toString());
				if (model.AddProduct(new ProductModel(code, name, descp, categoria, provedor, stock, priceV, priceC))) {
					JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
					view.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Ya hay un producto con el código: " + code);
				}
			}
		}catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

}
