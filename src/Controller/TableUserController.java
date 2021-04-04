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

import Business.UserRepository;
import Core.SQLConnection;
import Model.User.UserModel;
import View.MainScreen;

@SuppressWarnings("unused")
public class TableUserController extends SQLConnection implements ActionListener{

	private MainScreen view;
	private UserRepository userRep;
	private DefaultTableModel dm;
	
	public TableUserController(MainScreen v, UserRepository ur) {
		view = v;
		userRep = ur;
		
		view.btnShow.addActionListener(this);
		view.btnDeleteUser.addActionListener(this);
		//view.btnModifyUser.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == view.btnShow) {
			
			PreparedStatement ps = null;
			Connection conn = getConnection();
			ResultSet rs = null;
			
			//int sCode = view.textCodigo != null ? Integer.parseInt(view.textCodigo.getText()) : 0;
			
			String sCode = view.textCodigo.getText();
			
			String query = "SELECT E.CodigoEmpleado, E.Nombre, E.Username, E.RFC, E.NSS, E.Fecha, E.CodigoPuesto FROM empleados AS E";
			if (!"".contains(sCode)) {
				query = "SELECT E.CodigoEmpleado, E.Nombre, E.Username, E.RFC, E.NSS, E.Fecha, E.CodigoPuesto FROM empleados AS E WHERE E.CodigoEmpleado = " + sCode;;
			}
			
			dm = new DefaultTableModel();
			dm.addColumn("Codigo");
			dm.addColumn("Nombre");
			dm.addColumn("Usuario");
			dm.addColumn("RFC");
			dm.addColumn("NSS");
			dm.addColumn("Fecha de Ingreso");
			dm.addColumn("Puesto");
			
			
			try {
				
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				ResultSetMetaData rsMd = rs.getMetaData();
				int totalColumn = rsMd.getColumnCount();
				
				//int  r = 0;
				while(rs.next()) {
					Object[] row = new Object[totalColumn];
					
					for(int i = 0; i < totalColumn; i++) {
						if (i+1 < totalColumn) {
							System.out.println(rs.getObject(i+1).toString());
							row[i] = rs.getObject(i+1);
						}else {
							if (Integer.parseInt(rs.getObject(i+1).toString()) == 0) {
								row[i] = "Administrador";
							}else {
								row[i] = "Cajero";
							}
						}
					}
					//r++;
					dm.addRow(row);
				}
				view.tableUser.setModel(dm);
				int[] width = {25, 200, 50, 50, 50, 50, 50};
				
				for (int i = 0; i < 7; i++) {
					view.tableUser.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
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
		}else if (e.getSource() == view.btnDeleteUser) {
			int row = view.tableUser.getSelectedRow();
			if (row != -1) {
				int code = Integer.parseInt(view.tableUser.getValueAt(row, 0).toString());
				if (userRep.DeleteUser(code))
					dm.removeRow(row);
				else
					JOptionPane.showMessageDialog(view, "Ocurrio un error");
			}else {
				JOptionPane.showMessageDialog(view, "Selecciona un usuario.");
			}
		}
	}
}
