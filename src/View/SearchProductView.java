package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
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
import javax.swing.ButtonGroup;

public class SearchProductView extends JFrame {

	private JPanel contentPane;
	public JTextField txtCode;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public JComboBox cboxCategory, cboxProvedor;
	public JRadioButton rdbtnCodigo, rdbtnCategoria, rdbtnProveedor, rdbtnTodos;
	public JButton btnBuscar;
	int xMouse, yMouse;
	public SearchProductView() {
		CustomFont f = new CustomFont();
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchProductView.class.getResource("/Img/baseline_search_white_18dp.png")));
		setResizable(false);
		setTitle("Busqueda de producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 328);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#2e2e2e"));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		
		rdbtnCodigo = new JRadioButton("Codigo");
		buttonGroup.add(rdbtnCodigo);
		rdbtnCodigo.setForeground(Color.WHITE);
		rdbtnCodigo.setBackground(Color.decode("#2e2e2e"));
		rdbtnCodigo.setBounds(6, 249, 59, 23);
		
		rdbtnCategoria = new JRadioButton("Categoria");
		buttonGroup.add(rdbtnCategoria);
		rdbtnCategoria.setForeground(Color.WHITE);
		rdbtnCategoria.setBackground(Color.decode("#2e2e2e"));
		rdbtnCategoria.setBounds(67, 249, 83, 23);
		
		rdbtnProveedor = new JRadioButton("Provedor");
		buttonGroup.add(rdbtnProveedor);
		rdbtnProveedor.setForeground(Color.WHITE);
		rdbtnProveedor.setBackground(Color.decode("#2e2e2e"));
		rdbtnProveedor.setBounds(152, 249, 83, 23);
		
		rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.setBackground(Color.decode("#2e2e2e"));
		buttonGroup.add(rdbtnTodos);
		rdbtnTodos.setForeground(Color.WHITE);
		rdbtnTodos.setBounds(237, 249, 83, 23);
		
		btnBuscar = new Button("Buscar", 1);
		btnBuscar.setBounds(138, 284, 105, 33);
		
		cboxCategory = new JComboBox();
		cboxCategory.setBounds(38, 138, 110, 25);
		
		cboxProvedor = new JComboBox();
		cboxProvedor.setBounds(222, 138, 110, 25);
		
		txtCode = new TextField(3);
		txtCode.setBounds(126, 75, 120, 28);
		txtCode.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblCdigo.setBounds(126, 53, 105, 23);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblCategoria.setBounds(38, 114, 105, 23);
		
		JLabel lblProvedor = new JLabel("Provedor");
		lblProvedor.setFont(f.Font(f.Roboto_Regular, 0, 12));
		lblProvedor.setForeground(Color.WHITE);
		lblProvedor.setBounds(222, 114, 105, 23);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(2, 2, 388, 33);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				SearchProductView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(rdbtnCodigo);
		contentPane.add(rdbtnCategoria);
		contentPane.add(rdbtnProveedor);
		contentPane.add(rdbtnTodos);
		contentPane.add(btnBuscar);
		contentPane.add(cboxCategory);
		contentPane.add(cboxProvedor);
		contentPane.add(txtCode);
		contentPane.add(lblCdigo);
		contentPane.add(lblCategoria);
		contentPane.add(lblProvedor);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBusquedaDeProductos = new JLabel("Busqueda de productos");
		lblBusquedaDeProductos.setForeground(Color.WHITE);
		lblBusquedaDeProductos.setFont(f.Font(f.Roboto_Black, 0, 14));
		lblBusquedaDeProductos.setBounds(10, 0, 222, 33);
		panel.add(lblBusquedaDeProductos);
		
		JButton button = new CloseButtonv2(1, this);
		button.setBounds(355, 0, 33, 33);
		panel.add(button);
	}
}
