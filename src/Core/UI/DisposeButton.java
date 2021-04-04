package Core.UI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DisposeButton extends MouseAdapter{

	private JButton button;
	private JFrame jframe;
	public DisposeButton(JButton btn, JFrame jf) {
		button = btn;
		jframe = jf;
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
		jframe.dispose();
	}

}
