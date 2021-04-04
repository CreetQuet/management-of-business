package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Business.CategoryRepository;
import Business.ProvedorRepository;
import Core.SQLConnection;
import View.AddCategoryView;
import View.AddProvedorView;


public class TableProvedorController extends SQLConnection implements ActionListener{

	private AddProvedorView view;
	
	private DefaultTableModel dm;
	private ProvedorRepository categRepo;
	
	public TableProvedorController(AddProvedorView adc, ProvedorRepository cr) {
		view = adc;
		categRepo = cr;
		view.btnAgregar.addActionListener(this);
		view.btnEliminar.addActionListener(this);
	}
	
	public void showProvedor() {
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		
		//int sCode = view.textCodigo != null ? Integer.parseInt(view.textCodigo.getText()) : 0;
		
		//String sCode = view.textCodigo.getText();
		
		String query = "SELECT Nombre, Telefono FROM proveedor";

		dm = new DefaultTableModel();
		dm.addColumn("Proveedor");
		dm.addColumn("Telefono");
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
			view.table.setModel(dm);
			//int[] width = {25, 200, 50, 50, 50, 50, 50};
			
		/*	for (int i = 0; i < 7; i++) {
				view.table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
			}*/
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnEliminar) {
			int row = view.table.getSelectedRow();
			if (row != -1) {
				//int code = Integer.parseInt(view.table.getValueAt(row, 0).toString());
				int code = categRepo.SearchProvedor(view.table.getValueAt(row, 0).toString());
				if (categRepo.DeleteProvedor(code)) {
					dm.removeRow(row);
				}else {
					JOptionPane.showMessageDialog(view, "Ocurrio un error");
				}
			}else {
				JOptionPane.showMessageDialog(view, "Selecciona una categoria");
			}
		}else if (e.getSource() == view.btnAgregar) {
			String cat = view.textCategoryName.getText();
			String tel = view.txtTel.getText();
			if (!cat.isEmpty() && !tel.isEmpty()) {
				if (categRepo.AddProvedor(cat, tel)) {
					Object[][] r = {{cat, tel}};
					dm.addRow(r);
				}else {
					JOptionPane.showMessageDialog(view, "Ocurrio un error");
				}
			}else {
				JOptionPane.showMessageDialog(view, "Rellena los campos");
			}
		}
	}

}
