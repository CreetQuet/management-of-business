package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Formatter;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Business.UserRepository;
import View.AddEmployeeView;
import Model.User.UserModel;;


public class AddUserController implements ActionListener{

	private AddEmployeeView view;
	private UserRepository model;
	
	//private ArrayList<String> Ccharge = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public AddUserController(AddEmployeeView v, UserRepository m) {
		view = v;
		model = m;
		view.btnRegister.addActionListener(this);
		view.cBCharge.addActionListener(this);
		
		view.cBCharge.addItem("Administrador");
		view.cBCharge.addItem("Cajero");
		
		/*Ccharge = model.charge();
		
		for (String c : Ccharge) {
			view.cBCharge.addItem(c);
		}*/
	}

	
	@SuppressWarnings("unchecked")
	public void initCombobox() {
		//view.cBCharge.addItem("Root");
		
		/*Ccharge = model.charge();
		
		for (String c : Ccharge) {
			view.cBCharge.addItem(c.toString());
		}*/
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnRegister) {
			int code, charge = 0;
			String name, username, password, RFC, NSS;
			java.sql.Date date;
			Date cDate = new Date();
			
			String fYear = new SimpleDateFormat("yy").format(cDate);
			Formatter fmt = new Formatter();
			int totalUsers = model.CountUsers(fYear) + 1;
			
			//System.out.println(totalUsers);
			
			code = Integer.parseInt(fYear.concat(String.valueOf(fmt.format("%04d", totalUsers))));
			name = view.txtName.getText();
			username = view.txtUserName.getText();
			password = model.encryptPassword(view.txtPassword.getText());
			RFC = view.txtRFC.getText();
			NSS = view.txtNSS.getText();
			date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		
		
			charge = view.cBCharge.getSelectedIndex(); // Falta obtener el Index del puesto;
			if (model.AddUser(new UserModel(code, name, username, password, RFC, NSS, date, charge))) {
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				view.dispose();
			}
			
		}
		
	}

}
