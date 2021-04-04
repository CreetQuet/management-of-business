package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.UI.Button;
import Core.UI.CloseButtonv2;
import Core.UI.TextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.border.MatteBorder;

public class AddEmployeeView extends JFrame {

	public JPanel contentPane;
	public JTextField txtName;
	public JTextField txtUserName;
	public JTextField txtPassword;
	public JTextField txtRFC;
	public JTextField txtNSS;
	public JComboBox cBCharge;
	int xMouse, yMouse;

	public JButton btnRegister;
	private JButton button;
	
	/**
	 * Create the frame.
	 */
	public AddEmployeeView() {
		setUndecorated(true);
		setTitle("Registrar usuario");
		
		
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 224, 578);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#2e2e2e"));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegister = new Button("REGISTRAR EMPLEADO", 3);
		btnRegister.setBounds(25, 483, 175, 42);
		contentPane.add(btnRegister);
		
		txtName = new TextField(2);
		txtName.setBounds(24, 105, 176, 29);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(24, 84, 176, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(24, 145, 176, 14);
		contentPane.add(lblUsuario);
		
		txtUserName = new TextField(5);
		txtUserName.setColumns(10);
		txtUserName.setBounds(24, 166, 176, 29);
		contentPane.add(txtUserName);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(24, 206, 176, 14);
		contentPane.add(lblContrasea);
		
		txtPassword = new TextField(3);
		txtPassword.setColumns(10);
		txtPassword.setBounds(24, 227, 176, 29);
		contentPane.add(txtPassword);
		
		JLabel lblRfc = new JLabel("RFC");
		lblRfc.setForeground(Color.WHITE);
		lblRfc.setBounds(24, 267, 176, 14);
		contentPane.add(lblRfc);
		
		txtRFC = new TextField(4);
		txtRFC.setColumns(10);
		txtRFC.setBounds(24, 288, 176, 29);
		contentPane.add(txtRFC);
		
		JLabel lblNss = new JLabel("NSS");
		lblNss.setForeground(Color.WHITE);
		lblNss.setBounds(24, 328, 176, 14);
		contentPane.add(lblNss);
		
		txtNSS = new TextField(3);
		txtNSS.setColumns(10);
		txtNSS.setBounds(24, 349, 176, 29);
		contentPane.add(txtNSS);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setForeground(Color.WHITE);
		lblPuesto.setBounds(24, 389, 176, 14);
		contentPane.add(lblPuesto);
		
		cBCharge = new JComboBox();
		cBCharge.setBounds(24, 414, 176, 29);
		contentPane.add(cBCharge);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				AddEmployeeView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(2, 2, 220, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		button = new CloseButtonv2(1, this);
		button.setBounds(185, 0, 35, 35);
		panel.add(button);
	}
}
