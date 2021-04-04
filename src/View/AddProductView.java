package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Core.UI.Button;
import Core.UI.CustomFont;
import Core.UI.DisposeButton;
import Core.UI.Label;
import Core.UI.TextField;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddProductView extends JFrame {

	public JPanel contentPane;
	public JTextField txtCode;
	public JTextField txtName;
	public JTextField txtPriceB;
	public JTextField txtPriceA;
	public JTextField txtStock;
	public JTextPane txtDescription ;
	public JButton btnRegisterProduct;
	
	public JComboBox cbCategory, cbProvedor;
	
	int xMouse, yMouse;
	
	public AddProductView() {
		CustomFont f = new CustomFont();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(0, 2, 2, 2, (Color) SystemColor.textHighlight));
		contentPane.setBackground(Color.decode("#282828"));
		setContentPane(contentPane);
		
		JLabel lblCodigoDeBarras = new Label("Codigo de barras");
		
		txtCode = new TextField(3);
		txtCode.setColumns(10);
		
		cbCategory = new JComboBox();
		
		JLabel lblCategoria = new Label("Categoria");
		
		txtName = new TextField(2);
		txtName.setColumns(10);
		
		JLabel lblNombre = new Label("Nombre");
		
		JLabel lblDescripcin = new Label("Descripci\u00F3n");
		
		txtDescription = new JTextPane();
		
		JLabel lblPrecioDeCompra = new Label("Precio de compra");
		
		txtPriceB = new TextField(1);
		txtPriceB.setColumns(10);
		
		txtPriceA = new TextField(1);
		txtPriceA.setColumns(10);
		
		JLabel lblPrecioDeVenta = new Label("Precio de venta");
		
		txtStock = new TextField(3);
		txtStock.setColumns(10);
		
		JLabel lblCantidad = new Label("Cantidad");
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textHighlight);
		separator.setBackground(SystemColor.textHighlight);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		btnRegisterProduct = new Button("Registrar", 1);
		btnRegisterProduct.setIcon(new ImageIcon(AddProductView.class.getResource("/Img/baseline_add_white_18dp.png")));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				AddProductView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panel.setBackground(Color.decode("#202124"));
		
		JButton btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_close_white_18dp.png")));
		btnClose.setPreferredSize(new Dimension(20, 9));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.decode("#202124"));
		btnClose.addMouseListener(new DisposeButton(btnClose, this));
		btnClose.setBounds(514, 0, 34, 34);
		panel.add(btnClose);
		
		Label label = new Label("Provedor");
		
		cbProvedor = new JComboBox();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbCategory, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCodigoDeBarras, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescripcin, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrecioDeCompra, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecioDeVenta, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPriceB, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPriceA, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addComponent(txtStock, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegisterProduct, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbProvedor, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(cbCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addComponent(lblCodigoDeBarras, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblDescripcin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrecioDeCompra, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(txtPriceB, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addGap(9)
							.addComponent(lblPrecioDeVenta, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPriceA, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtStock, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbProvedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addComponent(btnRegisterProduct, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
