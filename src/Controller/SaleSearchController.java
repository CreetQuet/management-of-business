package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Core.SQLConnection;
import View.MainScreen;
import View.SaleDetailsView;
import View.SearchOptionsSale;

public class SaleSearchController extends SQLConnection implements ActionListener, FocusListener{

	private SearchOptionsSale view;
	private MainScreen mainView;
	private String fromDate, toDate;
	private Date fDate, tDate;
	private int folio;
	private SimpleDateFormat sdf;
	
	private DefaultTableModel dm, dmDetails;
	
	public SaleSearchController(SearchOptionsSale v, MainScreen m) {
		view = v;
		mainView = m;
		view.btnSearchSale.addActionListener(this);
		mainView.btnShowDetails.addActionListener(this);
		view.rdbtnFechas.addFocusListener(this);
		view.rdbtnFolio.addFocusListener(this);
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnSearchSale) {
			if (view.rdbtnFechas.isSelected() || view.rdbtnFolio.isSelected()) {
				if (view.rdbtnFechas.isSelected()) {
					fDate = view.fromDate.getDate();
					tDate = view.toDate.getDate();
					if (fDate != null && tDate != null) {
						long fd = fDate.getTime();
						long td = tDate.getTime();
						
						java.sql.Date fromD = new java.sql.Date(fd);
						java.sql.Date toD   = new java.sql.Date(td);
						
						if (fd <= td) {
							fromDate = fromD.toString() + " 00:00:00";
							toDate   = toD.toString() + " 23:59:59";
							view.dispose();
							showSales(1);
							//System.out.println("Desde: " + fromDate + " Hasta: " + toDate);
						}else {
							//System.out.println(fromD.toString() + " Debe ser menor o igual a " + toD.toString());
							JOptionPane.showMessageDialog(view, sdf.format(tDate) + " debe ser mayor o igual a: " + sdf.format(fDate));
						}
					}else {
						JOptionPane.showMessageDialog(view, "Selecciona un rango de fechas");
					}
				}else if (view.rdbtnFolio.isSelected()){
					if (view.txtFolio.getText() != null) {
						folio = Integer.parseInt(view.txtFolio.getText());
						view.dispose();
						showSales(2);
						//System.out.println("Folio: " + folio);
					}else {
						JOptionPane.showMessageDialog(view, "Ingresa un folio");
					}
				}
			}else {
				JOptionPane.showMessageDialog(view, "Elige el tipo de busqueda");
			}
		}else if (e.getSource() == mainView.btnShowDetails) {
			int row = mainView.tableSales.getSelectedRow();
			System.out.println("Fila: " + row);
			if (row != -1) {
				int idSale = Integer.parseInt(mainView.tableSales.getValueAt(row, 0).toString());
				System.out.println("Folio de venta: " + idSale);
				showSaleDetails(idSale);
			}else
				JOptionPane.showMessageDialog(mainView, "Selecciona una venta primero.");
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == view.rdbtnFolio) {
			view.fromDate.setCalendar(null);
			view.toDate.setCalendar(null);
		}
		if (e.getSource() == view.rdbtnFechas) 
			view.txtFolio.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
	
	public void showSaleDetails(int idSale) {
		SaleDetailsView saleDetail = new SaleDetailsView();
		saleDetail.setLocationRelativeTo(null);
		saleDetail.lblFolio.setText("Folio: " + idSale);
		
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		String query = "SELECT DV.CodigoProducto, P.Nombre, DV.Precio, DV.Cantidad, DV.Subtotal FROM detallesventa AS DV LEFT JOIN productos AS P ON DV.CodigoProducto = P.Codigo WHERE DV.idVenta = ?";
		dmDetails = new DefaultTableModel();
		dmDetails.addColumn("Código");
		dmDetails.addColumn("Nombre");
		dmDetails.addColumn("Precio");
		dmDetails.addColumn("Cantidad");
		dmDetails.addColumn("Importe");
		
		
		try {
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, idSale);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int totalColumn = rsMd.getColumnCount();
			
			while(rs.next()) {
				Object[] row = new Object[totalColumn];
				
				for(int i = 0; i < totalColumn; i++) {
					row[i] = rs.getObject(i+1);
				}
				dmDetails.addRow(row);
			}
			saleDetail.table.setModel(dmDetails);
			int[] width = {20, 200, 50, 50, 50};
			
			for (int i = 0; i < 5; i++) {
				saleDetail.table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally {
			try {
				conn.close();
			}catch (SQLException ex) {
				System.out.println(ex);
			}
		}
		saleDetail.setVisible(true);
	}
	
	public void showSales(int type) {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		String query = null;
		
		if (type == 1) // Fechas
			query = "SELECT V.idVenta, E.Nombre, V.Fecha, V.Total, V.Efectivo, V.CAMBIO FROM venta AS V LEFT JOIN empleados AS E ON V.CodigoEmpleado = E.CodigoEmpleado WHERE V.Fecha BETWEEN ? AND ?";
		else if (type == 2) // Folio
			query = "SELECT V.idVenta, E.Nombre, V.Fecha, V.Total, V.Efectivo, V.CAMBIO FROM venta AS V LEFT JOIN empleados AS E ON V.CodigoEmpleado = E.CodigoEmpleado WHERE V.idVenta = ?";
		else
			System.out.println("Selecciona un tipo");
		
		dm = new DefaultTableModel();
		dm.addColumn("Folio");
		dm.addColumn("Empleado que atendio");
		dm.addColumn("Fecha");
		dm.addColumn("Total");
		dm.addColumn("Pagó");
		dm.addColumn("Cambio");
		
		
		try {
			
			ps = conn.prepareStatement(query);
			if (type == 1) {
				ps.setString(1, getFromDate());
				ps.setString(2, getToDate());
			} else if (type == 2) {
				ps.setInt(1, getFolio());
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int totalColumn = rsMd.getColumnCount();
			
			//int  r = 0;
			while(rs.next()) {
				Object[] row = new Object[totalColumn];
				
				for(int i = 0; i < totalColumn; i++) {
					row[i] = rs.getObject(i+1);
				}
				
				dm.addRow(row);
			}
			mainView.tableSales.setModel(dm);
			int[] width = {20, 200, 50, 50, 50, 50};
			
			for (int i = 0; i < 6; i++) {
				mainView.tableSales.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
			}
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
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}
	
}
