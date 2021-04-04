package Core.UI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import View.MainScreen;

public class CloseButton extends MouseAdapter{

	private JButton button;
	
	public CloseButton(JButton btn) {
		button = btn;
		this.button.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_close_white_18dp.png")));
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		button.setBackground(Color.decode("#e81123"));
		button.setForeground(Color.decode("#FFFFFF"));
	}
	@Override
	public void mouseExited(MouseEvent e) {
		button.setBackground(Color.decode("#202124"));
		button.setForeground(Color.decode("#909090"));
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		button.setBackground(Color.decode("#8b0a14"));
		System.exit(0);
	}

}
