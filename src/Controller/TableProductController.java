package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Business.ProductRepository;
import Core.SQLConnection;
import View.MainScreen;

public class TableProductController extends SQLConnection implements ActionListener{

	
	private DefaultTableModel dm;
	private MainScreen view;
	
	public TableProductController(MainScreen v) {
		view = v;
		
		view.btnDeleteProduct.addActionListener(this);
		//dm = new DefaultTableModel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnDeleteProduct) {
			int row = view.tableProduct.getSelectedRow();
			if (row != -1) {
				String code = view.tableProduct.getValueAt(row, 0).toString();
				System.out.println("#"+code);
				if (new ProductRepository().DeleteProduct(code)) {
					//dm.removeRow(row);
					//view.tableProduct.removeRowSelectionInterval(row, row);
				}else {
					JOptionPane.showMessageDialog(view, "Ocurrio un error");
				}
			}else {
				JOptionPane.showMessageDialog(view, "Selecciona un producto");
			}
		}
	}

}
