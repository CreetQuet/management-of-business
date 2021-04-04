package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Core.UI.CloseButtonv2;
import Core.UI.CustomFont;

import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class SaleDetailsView extends JFrame {

	private JPanel contentPane;
	public JTable table;

	public JLabel lblFolio;
	
	int xMouse, yMouse;
	
	public SaleDetailsView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SaleDetailsView.class.getResource("/Img/baseline_account_balance_wallet_white_18dp.png")));
		
		CustomFont f = new CustomFont();
		
		setUndecorated(true);
		setTitle("Detalles de venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 622);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#2e2e2e"));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				SaleDetailsView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Symbol", Font.PLAIN, 11));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		
		table = new JTable();
		table.setFocusTraversalKeysEnabled(false);
		table.setFocusable(false);
		table.setUpdateSelectionOnSort(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setForeground(Color.WHITE);
		table.setFont(f.Font(f.Roboto_Regular, 0, 15));
		table.setRowMargin(4);
		table.setRowHeight(30);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.decode("#2e2e2e"));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Precio", "Cantidad", "Importe"
			}
		));
		scrollPane.setViewportView(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		CloseButtonv2 button = new CloseButtonv2(1, this);
		button.inizializer();
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBounds(553, 0, 43, 43);
		panel.add(button);
		
		lblFolio = new JLabel("Folio: 0001");
		lblFolio.setBounds(10, 11, 200, 21);
		panel.add(lblFolio);
		lblFolio.setFont(f.Font(f.Roboto_Regular, 0, 14));
		lblFolio.setForeground(SystemColor.text);
		contentPane.setLayout(gl_contentPane);
		//scrollPane.setColumnHeaderView(table);
	}
}
