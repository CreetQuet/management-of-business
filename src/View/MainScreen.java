package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.MatteBorder;


import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Core.UI.Button;
import Core.UI.CloseButton;
import Core.UI.CustomFont;

import java.awt.CardLayout;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JProgressBar;
import com.toedter.components.JSpinField;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	private JPanel contentPane;
	
	//private ArrayList<String> level = new ArrayList<String>();
	
	public JLabel lblMoneyB, lblMoneyN;
	
	private JLayeredPane ContainerPanel;
	private JPanel pUser;
	
	public JButton btnUsers;
	public JButton btnInventory;
	public JButton btnClose;
	
	public JButton btnDeleteUser, btnGenerateReport;
	public JButton btnShow, btnShowDetails;
	
	public JButton btnAgregarEmpleado;
	
	public JButton btnCategory, btnAddProduct, btnSearchSale, btnPanel, btnVentas, btnSearchProduct;
	
	public JPanel pInventory, pInventoryMainPanel, pControlPanel, pManageShopMainPanel, pUserMainPanel;
	
	int xMouse, yMouse;
	
	public JLabel lblUsername;
	
	
	public JTable tableUser;
	public JTextField textCodigo;
	public JTable tableProduct;
	public JButton btnDeleteProduct;
	//private JPanel pManageShopMainPanel;
	public JTable tableSales;
	private JLabel lblDineroBruto;
	private JLabel lblPrximaActualizacin;
	private JLabel lblTimeRemaing;
	public JButton btnModifyProduct, btnProvedores;
	//public DefaultTableModel model;
	
	
	public MainScreen()  {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/Img/icon-128.png")));
		CustomFont f = new CustomFont();
		setTitle("Administraci\u00F3n Nava");
		setResizable(true);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1199, 813);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		//contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		contentPane.setBackground(Color.decode("#282828"));
		setContentPane(contentPane);
		
		JPanel pMenu = new JPanel();
		pMenu.setBounds(2, 41, 148, 732);
		pMenu.setFocusable(false);
		pMenu.setLayout(null);
		pMenu.setBackground(Color.decode("#1a1a1a"));
		
		ContainerPanel = new JLayeredPane();
		ContainerPanel.setBounds(160, 41, 1027, 759);
		ContainerPanel.setBackground(Color.decode("#282828"));
		ContainerPanel.setRequestFocusEnabled(false);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(2, 2, 1195, 33);
		panel.setLayout(null);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				MainScreen.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
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
		
		btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_close_white_18dp.png")));
		btnClose.setPreferredSize(new Dimension(20, 9));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.decode("#202124"));
		btnClose.setBounds(1158, 0, 37, 33);
		
		btnClose.addMouseListener(new CloseButton(btnClose));
		
		panel.add(btnClose);
		
		JLabel lblDevelopment = new JLabel("v1 @LuisNava");
		lblDevelopment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopment.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDevelopment.setBounds(2, 784, 148, 16);
		lblDevelopment.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblDevelopment.setForeground(SystemColor.textHighlight);
		
		btnUsers = new Button("Empleados", 1);
		btnUsers.setAlignmentX(0.5f);
		btnUsers.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername = new JLabel("Name");
		lblUsername.setVisible(false);
		
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(20, 101, 128, 14);
		//lblUsername.setText(_SESSIONINFO.getUsername());
		pMenu.add(lblUsername);
		btnUsers.setMargin(new Insets(2, 0, 2, 2));
		btnUsers.setBounds(0, 173, 148, 36);
		btnUsers.setBorder(null);
		btnUsers.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/account_circle_white_18dp.png")));
		pMenu.add(btnUsers);
		
		//btnInventory = new JButton("Inventario");
		btnInventory = new Button("Almacen    ", 1);
		btnInventory.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventory.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_label_white_18dp.png")));
		btnInventory.setBounds(0, 220, 148, 36);
		//btnInventory.addMouseListener(new Button(btnInventory));
				
		pMenu.add(btnInventory);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/topMenu.png")));
		lblNewLabel.setBounds(0, 0, 148, 90);
		pMenu.add(lblNewLabel);
				
		ContainerPanel.setLayout(new CardLayout(0, 0));
		
		pControlPanel = new JPanel();
		pControlPanel.setBackground(Color.decode("#1a1a1a"));
		ContainerPanel.add(pControlPanel, "name_5083686677900");
		pControlPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 1031, 43);
		pControlPanel.add(panel_1);
		
		JLabel lblPanelDeControl = new JLabel("Panel de control");
		lblPanelDeControl.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblPanelDeControl.setBounds(10, 0, 189, 40);
		panel_1.add(lblPanelDeControl);
		
		JLabel lblSdasd = new JLabel("");
		lblSdasd.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_account_balance_white_18dp.png")));
		lblSdasd.setBounds(10, 360, 34, 34);
		pControlPanel.add(lblSdasd);
		
		lblMoneyB = new JLabel("$00.0");
		lblMoneyB.setForeground(Color.WHITE);
		lblMoneyB.setFont(f.Font(f.Roboto_Black, 0, 16));
		lblMoneyB.setBounds(54, 360, 285, 34);
		pControlPanel.add(lblMoneyB);
		
		lblDineroBruto = new JLabel("Dinero bruto");
		lblDineroBruto.setForeground(SystemColor.textHighlight);
		lblDineroBruto.setFont(f.Font(f.Roboto_Regular, Font.PLAIN, 15));
		lblDineroBruto.setBounds(10, 322, 224, 27);
		pControlPanel.add(lblDineroBruto);
		
		lblMoneyN = new JLabel("$00.0");
		lblMoneyN.setForeground(Color.WHITE);
		lblMoneyN.setFont(f.Font(f.Roboto_Black, Font.PLAIN, 16));
		lblMoneyN.setBounds(54, 443, 285, 34);
		pControlPanel.add(lblMoneyN);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_account_balance_wallet_white_18dp.png")));
		label_2.setBounds(10, 443, 34, 34);
		pControlPanel.add(label_2);
		
		JLabel lblDineroNeto = new JLabel("Dinero neto");
		lblDineroNeto.setForeground(SystemColor.textHighlight);
		lblDineroNeto.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblDineroNeto.setBounds(10, 405, 224, 27);
		pControlPanel.add(lblDineroNeto);
		
		lblPrximaActualizacin = new JLabel("*Pr\u00F3xima actualizaci\u00F3n: ");
		lblPrximaActualizacin.setVisible(false);
		lblPrximaActualizacin.setForeground(SystemColor.controlHighlight);
		lblPrximaActualizacin.setBounds(10, 512, 115, 14);
		pControlPanel.add(lblPrximaActualizacin);
		
		lblTimeRemaing = new JLabel("30mins");
		lblTimeRemaing.setVisible(false);
		lblTimeRemaing.setForeground(SystemColor.controlHighlight);
		lblTimeRemaing.setBounds(135, 512, 46, 14);
		pControlPanel.add(lblTimeRemaing);
		
		btnGenerateReport = new Button("Generar reporte", 1);
		btnGenerateReport.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnGenerateReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnGenerateReport.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_print_white_18dp.png")));
		btnGenerateReport.setBounds(10, 555, 153, 58);
		pControlPanel.add(btnGenerateReport);
		
		pUserMainPanel = new JPanel();
		ContainerPanel.add(pUserMainPanel, "name_27609979382900");
		
		pUserMainPanel.setBackground(Color.decode("#282828"));
		pUserMainPanel.setLayout(null);
		
		pUser = new JPanel();
		pUser.setBackground(new Color(26, 26, 26));
		pUser.setBounds(0, 0, 1027, 759);
		pUserMainPanel.add(pUser);
		
		pInventoryMainPanel = new JPanel();
		pInventoryMainPanel.setLayout(null);
		pInventoryMainPanel.setBackground(new Color(40, 40, 40));
		ContainerPanel.add(pInventoryMainPanel, "name_29169152583500");
		
		pInventory = new JPanel();
		pInventory.setBackground(new Color(26, 26, 26));
		pInventory.setBounds(0, 0, 1031, 759);
		pInventoryMainPanel.add(pInventory);
		pInventory.setLayout(null);
		
		JPanel titleBar = new JPanel();
		titleBar.setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel("Empleados");
		label.setForeground(Color.BLACK);
		label.setFont(f.Font(f.Roboto_Regular, 0, 15));
		GroupLayout gl_titleBar = new GroupLayout(titleBar);
		gl_titleBar.setHorizontalGroup(
			gl_titleBar.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1031, Short.MAX_VALUE)
				.addGroup(gl_titleBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(565, Short.MAX_VALUE))
		);
		gl_titleBar.setVerticalGroup(
			gl_titleBar.createParallelGroup(Alignment.LEADING)
				.addGap(0, 43, Short.MAX_VALUE)
				.addGroup(gl_titleBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addContainerGap())
		);
		titleBar.setLayout(gl_titleBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setFont(f.Font(f.Roboto_Regular, 0, 14));
		scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		scrollPane.setBackground(new Color(26, 26, 26));
		
		tableUser = new JTable();
		tableUser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableUser.setFillsViewportHeight(true);
		tableUser.setRowMargin(4);
		tableUser.setRowHeight(25);
		tableUser.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		tableUser.setFont(f.Font(f.Roboto_Regular, 0, 14));
		tableUser.setShowVerticalLines(false);
		tableUser.setGridColor(SystemColor.textHighlight);
		tableUser.setForeground(SystemColor.text);
		tableUser.setSelectionForeground(Color.WHITE);
		tableUser.setBackground(Color.decode("#1a1a1a"));
		tableUser.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Usuario", "RFC", "NSS", "Ingreso", "Puesto"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableUser.getColumnModel().getColumn(0).setResizable(false);
		tableUser.getColumnModel().getColumn(1).setResizable(false);
		tableUser.getColumnModel().getColumn(2).setResizable(false);
		tableUser.getColumnModel().getColumn(3).setResizable(false);
		tableUser.getColumnModel().getColumn(4).setResizable(false);
		tableUser.getColumnModel().getColumn(5).setResizable(false);
		tableUser.getColumnModel().getColumn(6).setResizable(false);
		scrollPane.setViewportView(tableUser);
		
		//model = (DefaultTableModel) tableUser.getModel();
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		
		btnDeleteUser = new Button("Dar de baja", 1);
		btnDeleteUser.setBorder(null);
		
		btnShow = new Button("Buscar", 1);
		btnShow.setBorder(null);
		
		btnAgregarEmpleado = new Button("Agregar", 1);
		btnAgregarEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarEmpleado.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_add_circle_white_18dp.png")));
		btnAgregarEmpleado.setBorder(null);
		btnAgregarEmpleado.setBounds(896, 76, 125, 43);
		
		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Dialog", Font.PLAIN, 13));
		textCodigo.setForeground(SystemColor.text);
		textCodigo.setBackground(new Color(26, 26, 26));
		textCodigo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 120, 215)));
		textCodigo.setColumns(10);
		
		GroupLayout gl_pUser = new GroupLayout(pUser);
		gl_pUser.setHorizontalGroup(
			gl_pUser.createParallelGroup(Alignment.LEADING)
				.addComponent(titleBar, GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
				.addGroup(gl_pUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_pUser.createSequentialGroup()
					.addGap(98)
					.addComponent(btnDeleteUser, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 599, Short.MAX_VALUE)
					.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_pUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_pUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAgregarEmpleado, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(910, Short.MAX_VALUE))
		);
		gl_pUser.setVerticalGroup(
			gl_pUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pUser.createSequentialGroup()
					.addComponent(titleBar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnAgregarEmpleado, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pUser.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDeleteUser, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
						.addGroup(gl_pUser.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pUser.setLayout(gl_pUser);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 1031, 43);
		panel_5.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblInventario = new JLabel("Almacen");
		lblInventario.setForeground(Color.BLACK);
		lblInventario.setFont(f.Font(f.Roboto_Regular, 0, 15));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1031, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInventario, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(565, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 43, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInventario, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		pInventory.add(panel_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.desktop);
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(10, 147, 1011, 11);
		pInventory.add(separator_1);
		
		btnAddProduct = new Button("Agregar", 1);
		btnAddProduct.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_add_circle_white_18dp.png")));
		btnAddProduct.setBounds(10, 76, 111, 43);
		pInventory.add(btnAddProduct);
		
		btnCategory = new Button("Categorias", 1);
		btnCategory.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/outline_category_white_18dp.png")));
		btnCategory.setBounds(892, 76, 125, 43);
		
		pInventory.add(btnCategory);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		scrollPane_1.setBounds(10, 169, 1007, 579);
		pInventory.add(scrollPane_1);
		
		tableProduct = new JTable();
		tableProduct.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableProduct.setFillsViewportHeight(true);
		tableProduct.setRowMargin(4);
		tableProduct.setRowHeight(25);
		tableProduct.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		
		tableProduct.setFont(f.Font(f.Roboto_Regular, 0, 14));
		
		tableProduct.setShowVerticalLines(false);
		tableProduct.setGridColor(SystemColor.textHighlight);
		tableProduct.setForeground(SystemColor.text);
		tableProduct.setSelectionForeground(Color.WHITE);
		tableProduct.setBackground(Color.decode("#1a1a1a"));
		tableProduct.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Descripcion", "Precio de Venta", "Precio de Compra", "Cantidad"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableProduct.getColumnModel().getColumn(0).setResizable(false);
		tableProduct.getColumnModel().getColumn(1).setResizable(false);
		tableProduct.getColumnModel().getColumn(2).setResizable(false);
		tableProduct.getColumnModel().getColumn(3).setResizable(false);
		tableProduct.getColumnModel().getColumn(4).setResizable(false);
		tableProduct.getColumnModel().getColumn(5).setResizable(false);
		scrollPane_1.setViewportView(tableProduct);
		
		btnDeleteProduct = new Button("Eliminar", 1);
		btnDeleteProduct.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_delete_white_18dp.png")));
		btnDeleteProduct.setBounds(127, 76, 111, 43);
		pInventory.add(btnDeleteProduct);
		
		btnSearchProduct = new Button("Buscar", 1);
		btnSearchProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchProduct.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_search_white_18dp.png")));
		btnSearchProduct.setBounds(244, 76, 111, 43);
		pInventory.add(btnSearchProduct);
		
		btnModifyProduct = new Button("Modificar", 1);
		btnModifyProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifyProduct.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_change_history_white_18dp.png")));
		btnModifyProduct.setBounds(361, 76, 111, 43);
		pInventory.add(btnModifyProduct);
		
		btnProvedores = new Button("Provedores", 1);
		btnProvedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnProvedores.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_label_important_white_18dp.png")));
		btnProvedores.setBounds(722, 76, 121, 43);
		pInventory.add(btnProvedores);
		
		contentPane.setLayout(null);
		contentPane.add(lblDevelopment);
		contentPane.add(pMenu);
		
		btnVentas = new Button("Ventas       ", 1);
		btnVentas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVentas.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_account_balance_wallet_white_18dp.png")));
		btnVentas.setBounds(0, 267, 148, 36);
		pMenu.add(btnVentas);
		
		btnPanel = new Button("Panel de control", 1);
		btnPanel.setHorizontalAlignment(SwingConstants.LEFT);
		btnPanel.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_dashboard_white_18dp.png")));
		btnPanel.setBounds(0, 126, 148, 36);
		pMenu.add(btnPanel);
		contentPane.add(ContainerPanel);
		
		pManageShopMainPanel = new JPanel();
		pManageShopMainPanel.setBounds(0,0, 1031, 759);
		pManageShopMainPanel.setBackground(new Color(26, 26, 26));
		ContainerPanel.add(pManageShopMainPanel, "name_1662272148800");
		pManageShopMainPanel.setLayout(null);
		
		JPanel topBar = new JPanel();
		topBar.setBackground(Color.LIGHT_GRAY);
		topBar.setBounds(0, 0, 1031, 43);
		pManageShopMainPanel.add(topBar);
		topBar.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ventas");
		lblNewLabel_1.setFont(f.Font(f.Roboto_Regular, 0, 15));
		lblNewLabel_1.setBounds(10, 0, 189, 40);
		topBar.add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.textHighlight);
		separator_2.setBackground(SystemColor.textHighlight);
		separator_2.setBounds(0, 150, 1031, 10);
		pManageShopMainPanel.add(separator_2);
		
		btnSearchSale = new Button("Buscar       ", 1);
		btnSearchSale.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_search_white_18dp.png")));
		btnSearchSale.setBounds(10, 76, 125, 43);
		pManageShopMainPanel.add(btnSearchSale);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 171, 1007, 577);
		scrollPane_2.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pManageShopMainPanel.add(scrollPane_2);
		
		tableSales = new JTable();
		tableSales.setFocusable(false);
		tableSales.setFocusTraversalKeysEnabled(false);
		tableSales.setShowGrid(false);
		tableSales.setShowHorizontalLines(false);
		tableSales.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableSales.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableSales.setFillsViewportHeight(true);
		tableSales.setRowMargin(4);
		tableSales.setRowHeight(35);
		tableSales.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		
		tableSales.setFont(f.Font(f.Roboto_Regular, 0, 14));
		
		tableSales.setShowVerticalLines(false);
		tableSales.setGridColor(SystemColor.textHighlight);
		tableSales.setForeground(SystemColor.text);
		tableSales.setSelectionForeground(Color.WHITE);
		tableSales.setBackground(Color.decode("#1a1a1a"));
		tableSales.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Folio", "Empleado que antendio", "Fecha", "Total", "Pago", "Cambio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableSales.getColumnModel().getColumn(0).setResizable(false);
		tableSales.getColumnModel().getColumn(1).setResizable(false);
		tableSales.getColumnModel().getColumn(2).setResizable(false);
		tableSales.getColumnModel().getColumn(3).setResizable(false);
		tableSales.getColumnModel().getColumn(4).setResizable(false);
		tableSales.getColumnModel().getColumn(5).setResizable(false);
		scrollPane_2.setViewportView(tableSales);
		
		btnShowDetails = new Button("Detalles", 1);
		btnShowDetails.setBounds(145, 76, 125, 43);
		pManageShopMainPanel.add(btnShowDetails);
		contentPane.add(panel);
	}
}
