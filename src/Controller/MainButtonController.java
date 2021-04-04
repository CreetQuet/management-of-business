package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Business.CategoryRepository;
import Business.ProductRepository;
import Business.ProvedorRepository;
import Business.UserRepository;
import View.AddCategoryView;
import View.AddEmployeeView;
import View.AddProductView;
import View.AddProvedorView;
import View.MainScreen;
import View.ModifyProductView;
import View.SearchOptionsSale;
import View.SearchProductView;
import View.SelectDateRange;

public class MainButtonController implements ActionListener{

	private MainScreen view;
	
	public MainButtonController(MainScreen v) {
		view = v;
		view.btnAgregarEmpleado.addActionListener(this);
		view.btnCategory.addActionListener(this);
		view.btnAddProduct.addActionListener(this);
		view.btnSearchSale.addActionListener(this);
		
		view.btnVentas.addActionListener(this);
		view.btnPanel.addActionListener(this);
		view.btnUsers.addActionListener(this);
		view.btnInventory.addActionListener(this);
		
		view.btnGenerateReport.addActionListener(this);
		view.btnSearchProduct.addActionListener(this);
		view.btnModifyProduct.addActionListener(this);
		view.btnProvedores.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnAgregarEmpleado) {
			//System.out.println("Boton Empleado");
			AddEmployeeView adu = new AddEmployeeView();
			adu.setLocationRelativeTo(null);
			AddUserController aC = new AddUserController(adu, new UserRepository());
			//aC.initCombobox();
			adu.setVisible(true);
		}else if (e.getSource() == view.btnCategory) {
			//System.out.println("HOla");
			AddCategoryView avc = new AddCategoryView();
			avc.setLocationRelativeTo(null);
			//AddCategoryController acc = new AddCategoryController(avc, new CategoryRepository());
			TableCategoryController tbc = new TableCategoryController(avc, new CategoryRepository());
			tbc.showCategorys();
			avc.setVisible(true);
		}else if (e.getSource() == view.btnAddProduct) {
			AddProductView apv = new AddProductView();
			apv.setLocationRelativeTo(null);
			AddProductController apc = new AddProductController(apv, new ProductRepository());
			apv.setVisible(true);
		}else if (e.getSource() == view.btnSearchSale) {
			SearchOptionsSale searchOptionSale = new SearchOptionsSale();
			SaleSearchController controller = new SaleSearchController(searchOptionSale, view);
			//controller.inizializer();
			searchOptionSale.setTitle("Buscar venta");
			searchOptionSale.setLocationRelativeTo(null);
			searchOptionSale.setVisible(true);
		}else if (e.getSource() == view.btnPanel) { // Panel de control
			view.pControlPanel.setVisible(true);
			view.pUserMainPanel.setVisible(false);
			view.pInventoryMainPanel.setVisible(false);
			view.pManageShopMainPanel.setVisible(false);
		}else if (e.getSource() == view.btnUsers) {
			view.pUserMainPanel.setVisible(true);
			view.pControlPanel.setVisible(false);
			view.pInventoryMainPanel.setVisible(false);
			view.pManageShopMainPanel.setVisible(false);
		}else if (e.getSource() == view.btnVentas) {
			view.pManageShopMainPanel.setVisible(true);
			view.pUserMainPanel.setVisible(false);
			view.pControlPanel.setVisible(false);
			view.pInventoryMainPanel.setVisible(false);
		}else if (e.getSource() == view.btnInventory){
			view.pInventoryMainPanel.setVisible(true);
			view.pManageShopMainPanel.setVisible(false);
			view.pUserMainPanel.setVisible(false);
			view.pControlPanel.setVisible(false);
		}else if (e.getSource() == view.btnGenerateReport) {
			SelectDateRange selectDateRange = new SelectDateRange();
			ReportGenerationController controllerReport = new ReportGenerationController(selectDateRange);
			selectDateRange.setLocationRelativeTo(null);
			selectDateRange.setVisible(true);
		}else if (e.getSource() == view.btnSearchProduct) {
			SearchProductView spv = new SearchProductView();
			SearchProductController spc = new SearchProductController(spv, view);
			//TableProductController tpc= new TableProductController(view);
			spv.setLocationRelativeTo(null);
			spv.setVisible(true);
		}else if (e.getSource() == view.btnModifyProduct) {
			// Modificación de producto
			// Modificación de producto
			int row = view.tableProduct.getSelectedRow();
			if (row != -1) {
				String code = view.tableProduct.getValueAt(row, 0).toString();
				if (new ProductRepository().ExistProduct(code)) {
					ModifyProductView mpv = new ModifyProductView();
					ModifyProductController mpc = new ModifyProductController(view, mpv, code);
					mpv.setLocationRelativeTo(null);
					mpv.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(view, "El producto con el código: " + code + " No existe.");
				}
			}else {
				JOptionPane.showMessageDialog(view, "Selecciona un producto.");
			}
		}else if (e.getSource() == view.btnProvedores) {
			AddProvedorView apv = new AddProvedorView();
			TableProvedorController tpc = new TableProvedorController(apv, new ProvedorRepository());
			tpc.showProvedor();
			apv.setLocationRelativeTo(null);
			apv.setVisible(true);
		}
	}

}
