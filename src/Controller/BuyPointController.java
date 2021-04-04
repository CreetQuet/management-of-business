package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Business.ProductRepository;
import View.BuyPointView;

public class BuyPointController implements ActionListener, KeyListener{

	private BuyPointView view;
	private ProductRepository repo;
	
	public BuyPointController(BuyPointView v, ProductRepository r) {
		view = v;
		repo = r;
		
		//Action Listener
		view.btnCancelBuy.addActionListener(this);
		view.btnCheckout.addActionListener(this);
		view.btnDeleteP.addActionListener(this);
		
		//Key Listener
		view.btnDeleteP.addKeyListener(this);
		view.btnCheckout.addKeyListener(this);
		view.btnCancelBuy.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == view.btnCancelBuy) {
			System.out.println("Tecla: " + e.getKeyCode());
			System.out.println("Se preciono cancelar F2");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
