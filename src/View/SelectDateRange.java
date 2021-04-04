package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import Core.UI.Button;
import Core.UI.CloseButtonv2;
import Core.UI.CustomFont;

import java.awt.Color;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
public class SelectDateRange extends JFrame {

	private JPanel contentPane;
	public JButton btnGenerar;
	public JDateChooser date1, date2;
	public SelectDateRange() {
		CustomFont f = new CustomFont();
		setUndecorated(true);
		setTitle("Reporte de ventas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		contentPane.setBackground(Color.decode("#2e2e2e"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1a1a1a"));
		panel.setBounds(2, 2, 440, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		CloseButtonv2 button = new CloseButtonv2(1, this);
		button.inizializer();
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBounds(397, 0, 43, 43);
		panel.add(button);
		
		date1 = new JDateChooser();
		date1.setDateFormatString("dd/MM/yyyy");
		date1.setFont(f.Font(f.Roboto_Regular, 0, 15));
		date1.getCalendarButton().setBackground(SystemColor.textHighlight);
		date1.getCalendarButton().setBorderPainted(false);
		date1.getCalendarButton().setIcon(new ImageIcon(SelectDateRange.class.getResource("/Img/baseline_date_range_white_18dp.png")));
		date1.setBounds(59, 95, 111, 25);
		contentPane.add(date1);
		
		date2 = new JDateChooser();
		date2.setDateFormatString("dd/MM/yyyy");
		date2.setFont(f.Font(f.Roboto_Regular, 0, 15));
		date2.getCalendarButton().setIcon(new ImageIcon(SelectDateRange.class.getResource("/Img/baseline_date_range_white_18dp.png")));
		date2.getCalendarButton().setBorderPainted(false);
		date2.getCalendarButton().setBackground(SystemColor.textHighlight);
		date2.setBounds(274, 95, 111, 25);
		contentPane.add(date2);
		
		JLabel lblGenerarReporte = new JLabel("Generar reporte");
		lblGenerarReporte.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGenerarReporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarReporte.setForeground(SystemColor.text);
		lblGenerarReporte.setBounds(86, 56, 243, 28);
		contentPane.add(lblGenerarReporte);
		
		JLabel lblDel = new JLabel("Del:");
		lblDel.setForeground(Color.WHITE);
		lblDel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDel.setBounds(2, 95, 46, 25);
		contentPane.add(lblDel);
		
		JLabel lblAl = new JLabel("Al:");
		lblAl.setForeground(Color.WHITE);
		lblAl.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAl.setBounds(213, 95, 51, 25);
		contentPane.add(lblAl);
		
		btnGenerar = new Button("Generar", 1);
		btnGenerar.setIcon(new ImageIcon(SelectDateRange.class.getResource("/Img/baseline_save_white_18dp.png")));
		btnGenerar.setBounds(117, 240, 200, 43);
		contentPane.add(btnGenerar);
	}
}
