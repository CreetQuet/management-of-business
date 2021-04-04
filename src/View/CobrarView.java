package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Core.UI.Button;
import Core.UI.CustomFont;
import Core.UI.TextField;

import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CobrarView extends JFrame {

	private JPanel contentPane;
	public JTextField txtMoney;
	public JLabel lblPagaCon, lblCambio, lblTotal;
	public JButton btnCancelSale;
	
	public CobrarView() {
		CustomFont f = new CustomFont();
		//setVisible(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#2e2e2e"));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#282828"));
		
		lblTotal = new JLabel("$100.0");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(f.Font(f.Roboto_Black, 0, 19));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textHighlight);
		separator.setBackground(SystemColor.textHighlight);
		
		txtMoney = new TextField(1);
		txtMoney.setColumns(10);
		
		lblPagaCon = new JLabel("Paga con $:");
		lblPagaCon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPagaCon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagaCon.setForeground(Color.WHITE);
		lblPagaCon.setFont(new Font("Roboto Black", Font.PLAIN, 19));
		
		lblCambio = new JLabel("Cambio: $00.0");
		lblCambio.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCambio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambio.setForeground(Color.GREEN);
		lblCambio.setFont(new Font("Dialog", Font.PLAIN, 19));
		
		btnCancelSale = new Button("     Cancelar           ", 2);
		btnCancelSale.setIcon(new ImageIcon(CobrarView.class.getResource("/Img/outline_cancel_white_18dp.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCambio, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPagaCon, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblTotal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtMoney, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))))
					.addGap(273))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCancelSale, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(633, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelSale, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPagaCon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtMoney, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(lblCambio, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(43))
		);
		
		JLabel lblCobrar = new JLabel("COBRAR");
		lblCobrar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCobrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCobrar.setForeground(Color.WHITE);
		lblCobrar.setFont(f.Font(f.Roboto_Regular, 0, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(194)
					.addComponent(lblCobrar, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblCobrar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
