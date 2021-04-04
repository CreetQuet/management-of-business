package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.border.MatteBorder;

import Core.UI.Button;
import Core.UI.CloseButtonv2;
import Core.UI.CustomFont;
import Core.UI.TextField;

import java.awt.Color;
import java.awt.SystemColor;

public class ModifyProductView extends JFrame {

	private JPanel contentPane;
	public JTextField txtName, txtDesc;
	public JTextField txtPriceC;
	public JTextField txtPriceV;
	public JTextField txtStock;
	public JButton btnGuardar;
	public JLabel lblProducto;
	
	int xMouse, yMouse;
	
	public ModifyProductView() {
		CustomFont f = new CustomFont();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModifyProductView.class.getResource("/Img/baseline_save_white_18dp.png")));
		setTitle("Modificando producto");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 202, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#2e2e2e"));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 120, 215)));
		setContentPane(contentPane);
		
		JLabel lblC = new JLabel("Nombre");
		lblC.setForeground(SystemColor.text);
		lblC.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblC.setBounds(10, 60, 100, 19);
		
		txtName = new TextField(2);
		txtName.setBounds(10, 79, 181, 25);
		txtName.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setForeground(SystemColor.text);
		lblDescripcin.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblDescripcin.setBounds(10, 115, 100, 19);
		
		txtDesc = new TextField(2);
		txtDesc.setBounds(10, 134, 181, 80);
		
		txtPriceC = new TextField(1);
		txtPriceC.setBounds(10, 245, 181, 25);
		txtPriceC.setColumns(10);
		
		JLabel lblPrecioDeCompra = new JLabel("Precio de compra");
		lblPrecioDeCompra.setForeground(SystemColor.text);
		lblPrecioDeCompra.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblPrecioDeCompra.setBounds(10, 226, 181, 19);
		
		txtPriceV = new TextField(1);
		txtPriceV.setBounds(10, 300, 181, 25);
		txtPriceV.setColumns(10);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de venta");
		lblPrecioDeVenta.setForeground(SystemColor.text);
		lblPrecioDeVenta.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblPrecioDeVenta.setBounds(10, 281, 181, 19);
		
		txtStock = new TextField(3);
		txtStock.setBounds(10, 355, 181, 25);
		txtStock.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(SystemColor.text);
		lblCantidad.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblCantidad.setBounds(10, 336, 181, 19);
		
		btnGuardar = new Button("Guardar", 1);
		btnGuardar.setBounds(54, 420, 100, 40);
		contentPane.setLayout(null);
		contentPane.add(lblC);
		contentPane.add(txtName);
		contentPane.add(lblDescripcin);
		contentPane.add(txtDesc);
		contentPane.add(txtPriceC);
		contentPane.add(lblPrecioDeCompra);
		contentPane.add(txtPriceV);
		contentPane.add(lblPrecioDeVenta);
		contentPane.add(txtStock);
		contentPane.add(lblCantidad);
		contentPane.add(btnGuardar);
		
		JPanel panel = new JPanel();
		panel.setBounds(2, 2, 198, 34);
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				ModifyProductView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new CloseButtonv2(1, this);
		button.setBounds(164, 0, 34, 34);
		panel.add(button);
		
		lblProducto = new JLabel("Producto: 57575558");
		lblProducto.setForeground(SystemColor.text);
		lblProducto.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblProducto.setBounds(10, 0, 118, 34);
		panel.add(lblProducto);
	}
}
