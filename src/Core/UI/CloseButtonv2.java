package Core.UI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import View.MainScreen;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class CloseButtonv2 extends JButton implements MouseListener{
	private int type;
	private JFrame frame;
	
	public CloseButtonv2(int type, JFrame frame) {
		this.type = type;
		this.frame = frame;
		this.addMouseListener(this);
		inizializer();
	}

	public void inizializer() {
		this.setBackground(Color.decode("#202124"));
		this.setForeground(Color.decode("#909090"));
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_close_white_18dp.png")));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setBackground(Color.decode("#8b0a14"));
		if (type == 0)
			System.exit(0);
		else
			frame.dispose();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.decode("#e81123"));
		this.setForeground(Color.decode("#FFFFFF"));	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.decode("#202124"));
		this.setForeground(Color.decode("#909090"));
	}

}
