package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Core.UI.Button;
import Core.UI.CloseButton;
import Core.UI.CustomFont;
import Core.UI.DisposeButton;
import Core.UI.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddProvedorView extends JFrame {

	private JPanel contentPane;
	public JTextField textCategoryName;
	public JTable table;
	
	private int xMouse, yMouse;
	
	public JButton btnAgregar, btnEliminar;
	public TextField txtTel;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public AddProvedorView() {
		
		CustomFont f = new CustomFont();
		
		setUndecorated(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		contentPane.setBackground(Color.decode("#282828"));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		
		textCategoryName = new TextField(2);
		textCategoryName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setFont(f.Font(f.Roboto_Regular, 0, 14));
		scrollPane.setBackground(new Color(26, 26, 26));
		scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setRowMargin(4);
		table.setRowHeight(25);
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		table.setShowVerticalLines(false);
		table.setGridColor(SystemColor.textHighlight);
		table.setForeground(SystemColor.text);
		table.setSelectionForeground(Color.WHITE);
		table.setBackground(Color.decode("#1a1a1a"));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Provedor", "Telefono"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		/*table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFocusable(false);
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		table.setBackground(Color.decode("#282828"));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Categoria"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		table.getColumnModel().getColumn(0).setResizable(false);*/
		scrollPane.setViewportView(table);
		
		btnAgregar = new Button("Agregar", 1);
		
		btnEliminar = new Button("Eliminar", 1);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				AddProvedorView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
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
		panel.setLayout(null);
		
		JButton btnClose = new JButton();
		btnClose.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_close_white_18dp.png")));
		btnClose.setPreferredSize(new Dimension(20, 9));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.decode("#202124"));
		btnClose.setBounds(470, 0, 34, 34);
		btnClose.addMouseListener(new DisposeButton(btnClose, this));
		
		panel.add(btnClose);
		
		txtTel = new TextField(3);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCategoryName, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefono)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNombre)
							.addGap(11)
							.addComponent(textCategoryName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
