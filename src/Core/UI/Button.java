package Core.UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Button extends JButton implements MouseListener{

	//private JButton button;
	private int type;
	private String type2Button = "#912828";
	
	public Button(String title, int type) {
		//button = btn;
		this.type = type;
		CustomFont f = new CustomFont();
		
		this.setText(title);
		//this.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		this.setFont(f.Font(f.Roboto_Regular, 0, 14));
		this.setFocusPainted(false);
		this.setBorder(null);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		customButton();
		this.addMouseListener(this);
		
	}
	
	private void customButton() {
		if (type == 1) {
			this.setBackground(Color.decode("#393939"));
			this.setForeground(Color.decode("#909090"));
		}else if (type == 2) {
			this.setBackground(Color.decode(type2Button));
			this.setForeground(Color.decode("#909090"));
		}else if (type == 3) {
			this.setBackground(Color.decode("#329128"));
			this.setForeground(Color.decode("#909090"));
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if (type == 1) {
			this.setBackground(Color.decode("#0072ff"));
			this.setForeground(Color.decode("#FFFFFF"));
		}else if (type == 2) {
			this.setBackground(Color.decode("#bc1616"));
		}else if (type == 3) {
			this.setBackground(Color.decode("#2ab51b"));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (type == 1) {
			this.setBackground(Color.decode("#393939"));
			this.setForeground(Color.decode("#909090"));
		}else if (type == 2) {
			this.setBackground(Color.decode(type2Button));
		}else if (type == 3) {
			this.setBackground(Color.decode("#329128"));
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (type == 1) {
			this.setBackground(Color.decode("#004eaf"));
		}else if (type == 2) {
			this.setBackground(Color.decode("#af0000"));
		}else if (type == 3) {
			this.setBackground(Color.decode("#00af19"));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
