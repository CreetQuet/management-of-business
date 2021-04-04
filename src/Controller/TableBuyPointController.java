package Controller;

import javax.swing.table.DefaultTableModel;

import Business.ProductRepository;
import View.BuyPointView;

public class TableBuyPointController {
	private BuyPointView view;
	private ProductRepository repo;
	private DefaultTableModel dm;
	
	public TableBuyPointController(BuyPointView v, ProductRepository ur) {
		view = v;
		repo = ur;
		inizializer();
	}
	
	private void inizializer() {
		dm = new DefaultTableModel();
		dm.addColumn("Codigo Producto");
		dm.addColumn("Cantidad");
		dm.addColumn("Descripción");
		dm.addColumn("Precio");
		dm.addColumn("Importe");
		view.table.setModel(dm);
	}	
}
