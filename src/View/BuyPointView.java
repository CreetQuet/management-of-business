package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.UI.Button;
import Core.UI.CustomFont;
import Core.UI.TextField;
import Task.DateTimeTask;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Timer;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Label;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BuyPointView extends JFrame {

	public JPanel contentPane, mainPane;
	public JLabel lblTime;
	public JLabel lblDate;
	public JLabel lblName;
	public JLabel lblTotal;
	public JPanel paneTotal;
	
	int xMouse, yMouse;
	public JTextField txtCode;
	public JButton btnDeleteP;
	public JButton btnCheckout;
	public JButton btnCancelBuy;
	private JScrollPane scrollPane;
	public JTable table;
	@SuppressWarnings("serial")
	public BuyPointView() {
		
		CustomFont f = new CustomFont();
		setResizable(false);
		setUndecorated(true);
		setTitle("Administraci\u00F3n Nava");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.desktop));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel topBar = new JPanel();
		topBar.setLayout(null);
		topBar.setBounds(2, 2, 1196, 60);
		topBar.setBackground(Color.decode("#1a1a1a"));
		topBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				BuyPointView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		topBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		contentPane.add(topBar);
		
		lblDate = new JLabel("05/Nov/2019");
		lblDate.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblDate.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDate.setFont(f.Font(f.Roboto_Regular, 0, 17));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(1086, 0, 114, 25);
		topBar.add(lblDate);
		
		lblTime = new JLabel("12:00");
		lblTime.setVerticalTextPosition(SwingConstants.TOP);
		lblTime.setVerticalAlignment(SwingConstants.TOP);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Roboto", Font.PLAIN, 24));
		lblTime.setBounds(1086, 25, 114, 25);
		topBar.add(lblTime);
		
		lblName = new JLabel("Nava Castro Luis Alberto | Cajero");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(10, 9, 278, 41);
		lblName.setFont(new Font("Roboto", Font.PLAIN, 15));
		topBar.add(lblName);
		
		mainPane = new JPanel();
		mainPane.setBounds(2, 60, 1196, 838);
		mainPane.setBackground(Color.decode("#2e2e2e"));
		contentPane.add(mainPane);
		
		txtCode = new TextField(3);
		txtCode.setBounds(30, 60, 220, 40);
		txtCode.setColumns(10);
		
		JLabel lblCodeProduct = new JLabel("C\u00F3digo del producto (F1)");
		lblCodeProduct.setBounds(30, 26, 220, 40);
		lblCodeProduct.setForeground(Color.WHITE);
		lblCodeProduct.setFont(new Font("Roboto", Font.PLAIN, 15));
		
		btnDeleteP = new Button("      Borrar producto (F2)         ", 1);
		btnDeleteP.setBounds(30, 120, 220, 40);
		btnDeleteP.setIcon(new ImageIcon(BuyPointView.class.getResource("/Img/baseline_delete_white_18dp.png")));
		
		btnCancelBuy = new Button("      Cancelar compra (F3)       ", 2);
		btnCancelBuy.setBounds(30, 176, 220, 40);
		btnCancelBuy.setIcon(new ImageIcon(BuyPointView.class.getResource("/Img/outline_cancel_white_18dp.png")));
		
		btnCheckout = new Button("       Cobrar venta (F5)             ", 3);
		btnCheckout.setBounds(30, 236, 220, 40);
		btnCheckout.setIcon(new ImageIcon(BuyPointView.class.getResource("/Img/baseline_attach_money_white_18dp.png")));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(319, 26, 26, 783);
		separator.setForeground(SystemColor.textHighlight);
		separator.setBackground(SystemColor.textHighlight);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		paneTotal = new JPanel();
		paneTotal.setBounds(620, 744, 576, 94);
		paneTotal.setBackground(SystemColor.desktop);
		paneTotal.setLayout(null);
		
		lblTotal = new JLabel("TOTAL: $00.0");
		lblTotal.setFont(new Font(f.Roboto_Black, Font.PLAIN, 30));
		lblTotal.setForeground(SystemColor.text);
		lblTotal.setBounds(296, 11, 270, 74);
		paneTotal.add(lblTotal);
		mainPane.setLayout(null);
		mainPane.add(txtCode);
		mainPane.add(lblCodeProduct);
		mainPane.add(btnDeleteP);
		mainPane.add(btnCancelBuy);
		mainPane.add(btnCheckout);
		mainPane.add(separator);
		mainPane.add(paneTotal);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(376, 26, 772, 667);
		mainPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setRowMargin(4);
		table.setRowHeight(25);
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		table.setFont(f.Font(f.Roboto_Regular, 0, 14));
		table.setShowVerticalLines(false);
		table.setGridColor(SystemColor.textHighlight);
		table.setForeground(SystemColor.text);
		table.setSelectionForeground(Color.WHITE);
		table.setBackground(Color.decode("#1a1a1a"));
		table.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"Codigo Producto", "Cantidad","Descripci\u00F3n", "Precio",  "Importe"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		table.getColumnModel().getColumn(2).setPreferredWidth(274);
		table.getColumnModel().getColumn(3).setPreferredWidth(58);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		

		/*DateTimeTask date = new DateTimeTask(this);
		Timer time = new Timer();
		time.scheduleAtFixedRate(date, 0, 1000);*/
	}
}
