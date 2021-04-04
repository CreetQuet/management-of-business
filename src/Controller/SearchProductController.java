package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Business.CategoryRepository;
import Business.ProductRepository;
import Business.ProvedorRepository;
import Core.SQLConnection;
import View.MainScreen;
import View.SearchProductView;

public class SearchProductController extends SQLConnection implements ActionListener{

	private SearchProductView view;
	private MainScreen mainView;
	private ProductRepository model;
	
	private DefaultTableModel dm;
	
	private ArrayList<String> Ccategory = new ArrayList<String>();
	private ArrayList<String> Cprovedor = new ArrayList<String>();
	
	private TableProductController tableP;
	
	public SearchProductController(SearchProductView v,  MainScreen m) {
		view = v;
		mainView = m;
		model = new ProductRepository();
		view.btnBuscar.addActionListener(this);
		view.cboxCategory.addActionListener(this);
		view.cboxProvedor.addActionListener(this);
		mainView.btnDeleteProduct.addActionListener(this);
		
		Ccategory = model.Category();
		Cprovedor = model.Provedor();
		if (Ccategory != null && Cprovedor != null) {
			for (String c : Ccategory) {
				view.cboxCategory.addItem(c);
			}
			
			for (String c : Cprovedor) {
				view.cboxProvedor.addItem(c);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnBuscar) {
			if (view.rdbtnCategoria.isSelected()) {
				showAllProductsOfCategory(view.cboxCategory.getSelectedItem().toString());
				System.out.println(view.cboxCategory.getSelectedItem());
				view.dispose();
			}else if (view.rdbtnProveedor.isSelected()) {
				showAllProductsOfProvedor(view.cboxProvedor.getSelectedItem().toString());
				view.dispose();
			}else if (view.rdbtnCodigo.isSelected()) {
				showProductPerCode(view.txtCode.getText());
				view.dispose();
			}else if (view.rdbtnTodos.isSelected()) {
				showAllProducts();
				view.dispose();
			}else {
				JOptionPane.showMessageDialog(view, "Selecciona un tipo de busqueda");
			}
		}else if (e.getSource() == mainView.btnDeleteProduct) {
			int row = mainView.tableProduct.getSelectedRow();
			if (row != -1) {
				String code = mainView.tableProduct.getValueAt(row, 0).toString();
				//System.out.println("#"+code);
				if (model.DeleteProduct(code)) {
					dm.removeRow(row);
				}else {
					JOptionPane.showMessageDialog(view, "Ocurrio un error");
				}
			}else {
				JOptionPane.showMessageDialog(view, "Selecciona un producto");
			}
		}
	}
	
	private void showAllProductsOfProvedor(String name) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		//int sCode = view.textCodigo != null ? Integer.parseInt(view.textCodigo.getText()) : 0;
		
		//String sCode = view.textCodigo.getText();
		
		String query = "SELECT P.Codigo, P.Nombre, P.Descripcion,  P.Stock, P.PrecioCompra, P.PrecioVenta, C.Nombre, PV.Nombre  FROM productos AS P LEFT JOIN categoria AS C ON P.idCategoria = C.idCategoria LEFT JOIN proveedor AS PV ON P.idProveedor = PV.idProveedor WHERE P.idProveedor = ?";
		
		dm = new DefaultTableModel();
	
		dm.addColumn("Codigo");
		dm.addColumn("Nombre");
		dm.addColumn("Descripción");
		dm.addColumn("Cantidad");
		dm.addColumn("Precio de Compra");
		dm.addColumn("Precio de Venta");
		dm.addColumn("Categoria");
		dm.addColumn("Provedor");
		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, new ProvedorRepository().SearchProvedor(name));
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int totalColumn = rsMd.getColumnCount();
			
			//int  r = 0;
			while(rs.next()) {
				Object[] row = new Object[totalColumn];
				
				for(int i = 0; i < totalColumn; i++) {
					row[i] = rs.getObject(i+1);
				}
				//r++;
				dm.addRow(row);
			}
			/*int[] width = {25, 200, 50, 50, 50, 50, 50};
			
			for (int i = 0; i < totalColumn; i++) {
				view.tableProduct.getColumnModel().getColumn(i+1).setPreferredWidth(width[i]);
			}*/
			mainView.tableProduct.setModel(dm);
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			try {
				conn.close();
			}catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}
	private void showProductPerCode(String code) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		//int sCode = view.textCodigo != null ? Integer.parseInt(view.textCodigo.getText()) : 0;
		
		//String sCode = view.textCodigo.getText();
		
		String query = "SELECT P.Codigo, P.Nombre, P.Descripcion,  P.Stock, P.PrecioCompra, P.PrecioVenta, C.Nombre, PV.Nombre  FROM productos AS P LEFT JOIN categoria AS C ON P.idCategoria = C.idCategoria LEFT JOIN proveedor AS PV ON P.idProveedor = PV.idProveedor WHERE P.Codigo = ?";

		dm = new DefaultTableModel();
		dm.addColumn("Codigo");
		dm.addColumn("Nombre");
		dm.addColumn("Descripción");
		dm.addColumn("Cantidad");
		dm.addColumn("Precio de Compra");
		dm.addColumn("Precio de Venta");
		dm.addColumn("Categoria");
		dm.addColumn("Provedor");
		try {
			
			ps = conn.prepareStatement(query);
			ps.setString(1, code);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int totalColumn = rsMd.getColumnCount();
			
			//int  r = 0;
			while(rs.next()) {
				Object[] row = new Object[totalColumn];
				
				for(int i = 0; i < totalColumn; i++) {
					row[i] = rs.getObject(i+1);
				}
				//r++;
				dm.addRow(row);
			}
			/*int[] width = {25, 200, 50, 50, 50, 50, 50};
			
			for (int i = 0; i < totalColumn; i++) {
				view.tableProduct.getColumnModel().getColumn(i+1).setPreferredWidth(width[i]);
			}*/
			mainView.tableProduct.setModel(dm);
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			try {
				conn.close();
			}catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}
	public void showAllProducts() {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		//int sCode = view.textCodigo != null ? Integer.parseInt(view.textCodigo.getText()) : 0;
		
		//String sCode = view.textCodigo.getText();
		
		String query = "SELECT P.Codigo, P.Nombre, P.Descripcion,  P.Stock, P.PrecioCompra, P.PrecioVenta, C.Nombre, PV.Nombre  FROM productos AS P LEFT JOIN categoria AS C ON P.idCategoria = C.idCategoria LEFT JOIN proveedor AS PV ON P.idProveedor = PV.idProveedor";

		dm = new DefaultTableModel();
		dm.addColumn("Codigo");
		dm.addColumn("Nombre");
		dm.addColumn("Descripción");
		dm.addColumn("Cantidad");
		dm.addColumn("Precio de Compra");
		dm.addColumn("Precio de Venta");
		dm.addColumn("Categoria");
		dm.addColumn("Provedor");
		try {
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int totalColumn = rsMd.getColumnCount();
			
			//int  r = 0;
			while(rs.next()) {
				Object[] row = new Object[totalColumn];
				
				for(int i = 0; i < totalColumn; i++) {
					row[i] = rs.getObject(i+1);
				}
				//r++;
				dm.addRow(row);
			}
			/*int[] width = {25, 200, 50, 50, 50, 50, 50};
			
			for (int i = 0; i < totalColumn; i++) {
				view.tableProduct.getColumnModel().getColumn(i+1).setPreferredWidth(width[i]);
			}*/
			mainView.tableProduct.setModel(dm);
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			try {
				conn.close();
			}catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}
	
	public void showAllProductsOfCategory(String name) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		//int sCode = view.textCodigo != null ? Integer.parseInt(view.textCodigo.getText()) : 0;
		
		//String sCode = view.textCodigo.getText();
		
		String query = "SELECT P.Codigo, P.Nombre, P.Descripcion,  P.Stock, P.PrecioCompra, P.PrecioVenta, C.Nombre, PV.Nombre  FROM productos AS P LEFT JOIN categoria AS C ON P.idCategoria = C.idCategoria LEFT JOIN proveedor AS PV ON P.idProveedor = PV.idProveedor WHERE P.idCategoria = ?";

		dm = new DefaultTableModel();
		dm.addColumn("Codigo");
		dm.addColumn("Nombre");
		dm.addColumn("Descripción");
		dm.addColumn("Cantidad");
		dm.addColumn("Precio de Compra");
		dm.addColumn("Precio de Venta");
		dm.addColumn("Categoria");
		dm.addColumn("Provedor");
		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, new CategoryRepository().SearchCategory(name));
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int totalColumn = rsMd.getColumnCount();
			
			//int  r = 0;
			while(rs.next()) {
				Object[] row = new Object[totalColumn];
				
				for(int i = 0; i < totalColumn; i++) {
					row[i] = rs.getObject(i+1);
				}
				//r++;
				dm.addRow(row);
			}
			/*int[] width = {25, 200, 50, 50, 50, 50, 50};
			
			for (int i = 0; i < totalColumn; i++) {
				view.tableProduct.getColumnModel().getColumn(i+1).setPreferredWidth(width[i]);
			}*/
			mainView.tableProduct.setModel(dm);
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			try {
				conn.close();
			}catch (SQLException ex) {
				System.out.println(ex);
			}
		}
	}
}
