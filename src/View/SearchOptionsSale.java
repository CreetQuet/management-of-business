package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.UI.Button;
import Core.UI.CloseButtonv2;
import Core.UI.CustomFont;
import Core.UI.TextField;

import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class SearchOptionsSale extends JFrame {

	private JPanel contentPane;
	public JDateChooser fromDate, toDate;
	public JButton btnSearchSale;
	public JTextField txtFolio;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton rdbtnFolio, rdbtnFechas;
	
	public SearchOptionsSale() {
		CustomFont f = new CustomFont();
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchOptionsSale.class.getResource("/Img/baseline_search_white_18dp.png")));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 563, 358);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#2e2e2e"));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#202124"));
		panel.setLayout(null);
		
		CloseButtonv2 btnNewButton = new CloseButtonv2(1, this);
		btnNewButton.inizializer();
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(516, 0, 43, 43);
		panel.add(btnNewButton);
		
		fromDate = new JDateChooser();
		fromDate.setFocusable(true);
		fromDate.getCalendarButton().setBorderPainted(false);
		fromDate.setDateFormatString("dd/MM/yyyy");
		fromDate.getCalendarButton().setBackground(Color.decode("#282828"));
		fromDate.setFont(f.Font(f.Roboto_Regular, 0, 14));
		fromDate.setBackground(Color.decode("#282828"));
		fromDate.getCalendarButton().setIcon(new ImageIcon(SearchOptionsSale.class.getResource("/Img/baseline_calendar_today_white_18dp.png")));
		
		toDate = new JDateChooser();
		toDate.setFocusable(true);
		toDate.setDateFormatString("dd/MM/yyyy");
		toDate.getCalendarButton().setBackground(Color.decode("#282828"));
		toDate.getCalendarButton().setIcon(new ImageIcon(SearchOptionsSale.class.getResource("/Img/baseline_calendar_today_white_18dp.png")));
		toDate.getCalendarButton().setBorderPainted(false);
		toDate.setBackground(Color.decode("#282828"));
		toDate.setFont(f.Font(f.Roboto_Regular, 0, 14));
		toDate.getCalendarButton().setBackground(new Color(40, 40, 40));
		
		JLabel lblSeleccionaUnRango = new JLabel("Selecciona un rango de fechas de ventas");
		lblSeleccionaUnRango.setFont(f.Font(f.Roboto_Regular, 0, 15));
		lblSeleccionaUnRango.setForeground(SystemColor.text);
		
		JLabel lblDesde = new JLabel("Desde: ");
		lblDesde.setForeground(SystemColor.text);
		lblDesde.setFont(f.Font(f.Roboto_Regular, 0, 15));
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setForeground(Color.WHITE);
		lblHasta.setFont(f.Font(f.Roboto_Regular, 0, 15));
		
		btnSearchSale = new Button("Buscar", 1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textHighlight);
		separator.setBackground(SystemColor.textHighlight);
		
		JLabel lblFolio = new JLabel("Folio:");
		lblFolio.setForeground(Color.WHITE);
		lblFolio.setFont(new Font("Roboto", Font.PLAIN, 15));
		
		txtFolio = new TextField(3);
		txtFolio.setFocusable(true);
		txtFolio.setColumns(10);
		
		rdbtnFolio = new JRadioButton("Folio");
		rdbtnFolio.setFont(f.Font(f.Roboto_Light, 0, 15));
		rdbtnFolio.setForeground(Color.WHITE);
		rdbtnFolio.setBackground(Color.decode("#2e2e2e"));
		buttonGroup.add(rdbtnFolio);
		
		rdbtnFechas = new JRadioButton("Fechas");
		rdbtnFechas.setFont(f.Font(f.Roboto_Light, 0, 15));
		rdbtnFechas.setForeground(Color.WHITE);
		rdbtnFechas.setBackground(Color.decode("#2e2e2e"));
		buttonGroup.add(rdbtnFechas);
		
		JLabel lblTipoDeBusqueda = new JLabel("Tipo de busqueda");
		lblTipoDeBusqueda.setForeground(Color.WHITE);
		lblTipoDeBusqueda.setFont(f.Font(f.Roboto_Regular, 0, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblDesde, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(fromDate, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblHasta, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(toDate, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSeleccionaUnRango, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(250, Short.MAX_VALUE)
					.addComponent(btnSearchSale, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(220))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFolio, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFolio, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rdbtnFolio)
							.addGap(18)
							.addComponent(rdbtnFechas))
						.addComponent(lblTipoDeBusqueda, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblSeleccionaUnRango, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDesde, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(fromDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHasta, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(toDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtFolio, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(lblTipoDeBusqueda))
						.addComponent(lblFolio, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnFechas)
						.addComponent(rdbtnFolio))
					.addGap(46)
					.addComponent(btnSearchSale, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
