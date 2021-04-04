package Core.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import View.MainScreen;

public class DragBarAction extends JPanel implements MouseListener, MouseMotionListener{

	private int xMouse, yMouse;
	private JPanel Jpanel;
	
	public DragBarAction() {
		//Jpanel = jp;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//this.setLayout(null);
		//this.setBackground(Color.decode("#202124"));
		/*btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon(MainScreen.class.getResource("/Img/baseline_close_white_18dp.png")));
		btnClose.setPreferredSize(new Dimension(20, 9));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.decode("#202124"));
		btnClose.setBounds(1158, 0, 37, 33);
		
		btnClose.addMouseListener(new CloseButton(btnClose));
		
		this.add(btnClose);*/
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.setLocation(e.getXOnScreen() - xMouse, e.getYOnScreen() - yMouse);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
