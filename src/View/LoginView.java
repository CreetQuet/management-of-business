package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

import Core.UI.Button;
import Core.UI.CloseButton;

import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginView extends JFrame {

	private JPanel contentPane;
	
	public JPasswordField txtPwd;
	public JTextField txtUser;
	
	private JLabel lblUsername;
	private JLabel lblPassword;

	int xMouse, yMouse;
	public JLabel lblError;
	public JButton btnLogin;
	public JButton btnClose;

	public LoginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/Img/icon-128.png")));
		setTitle("LOGIN");
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#282828"));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);

		txtPwd = new JPasswordField();
		txtPwd.setFocusTraversalPolicyProvider(true);
		txtPwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int k = (int) e.getKeyChar();
				if (k >= 65 && k <= 90 || k >= 97 && k <= 122 || k >= 48 && k <= 57) {
					
				}else {
					e.setKeyChar((char) KeyEvent.VK_CLEAR);
					e.consume();
				}
			}
		});
		txtPwd.setToolTipText("Contrase\u00F1a");
		txtPwd.setFont(new Font("Dialog", Font.BOLD, 13));
		txtPwd.setForeground(SystemColor.text);
		txtPwd.setCaretColor(Color.WHITE);
		txtPwd.setBackground(Color.decode("#282828"));
		txtPwd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.textHighlight));
		txtPwd.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtUser = new JTextField();
		txtUser.setCaretColor(Color.WHITE);
		txtUser.setToolTipText("Usuario");
		txtUser.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		txtUser.setForeground(SystemColor.text);
		txtUser.setBackground(Color.decode("#282828"));
		txtUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.textHighlight));
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		/*txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUser.setBackground(Color.decode("#121212"));
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtUser.setBackground(Color.decode("#282828"));
			}
		});*/
		
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int k = (int) e.getKeyChar();
				if (k >= 65 && k <= 90 || k >= 97 && k <= 122 || k >= 48 && k <= 57) {
					
				}else {
					e.setKeyChar((char) KeyEvent.VK_CLEAR);
					e.consume();
				}
			}
		});
		
		lblUsername = new JLabel("");
		lblUsername.setIcon(new ImageIcon(LoginView.class.getResource("/Img/baseline_perm_identity_white_18dp.png")));
		lblUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.textHighlight));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);
		//Image img 
		
		lblPassword = new JLabel("");
		lblPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) SystemColor.textHighlight));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setIcon(new ImageIcon(LoginView.class.getResource("/Img/outline_lock_white_18dp.png")));
		
		lblError = new JLabel("");
		lblError.setForeground(Color.WHITE);
		lblError.setFont(new Font("Agency FB", Font.PLAIN, 18));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnLogin = new Button("INGRESAR", 1);
		//btnLogin.addMouseListener(new Button(btnLogin));
		
		btnLogin.setBackground(Color.decode("#393939"));
		btnLogin.setForeground(Color.decode("#909090"));
		
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(null);

		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				LoginView.this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/Img/Logov2.png")));
		//
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textHighlight);
		separator.setBackground(SystemColor.textHighlight);
		
		JLabel lblLuisAlbertoNava = new JLabel("Nava Castro Luis Alberto");
		lblLuisAlbertoNava.setForeground(SystemColor.controlDkShadow);
		lblLuisAlbertoNava.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		lblLuisAlbertoNava.setIcon(new ImageIcon(LoginView.class.getResource("/Img/baseline_code_white_18dp.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(157, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(140))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblUsername))
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUser, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPwd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(98, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addContainerGap(29, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblLuisAlbertoNava, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(121)
					.addComponent(lblNewLabel)
					.addGap(35)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, Alignment.TRAILING)
						.addComponent(txtUser, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtPwd, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(20)
					.addComponent(btnLogin)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(lblLuisAlbertoNava, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {txtPwd, txtUser, btnLogin});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtPwd, txtUser});
		panel.setLayout(null);
		
		btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon(LoginView.class.getResource("/Img/baseline_close_white_18dp.png")));
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		btnClose.setBackground(Color.BLACK);
		btnClose.setBorder(new EmptyBorder(0, 0, 0, 0));
		//btnClose.setIcon(new ImageIcon("F:\\Topicos Avanzados de Programaci\u00F3n\\Project SHOP V2\\Resources\\baseline_close_white_18dp.png"));
		btnClose.setBounds(413, 0, 33, 34);
		btnClose.addMouseListener(new CloseButton(btnClose));
		panel.add(btnClose);
		contentPane.setLayout(gl_contentPane);
	}
}
