package Core.UI;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class TextField extends JTextField implements KeyListener{

	private int type;
	
	public TextField(int type) {
		
		this.type = type;
		
		CustomFont f = new CustomFont();
		this.setCaretColor(Color.WHITE);
		this.setFont(f.Font(f.Roboto_Regular, 0, 14));
		this.setForeground(Color.decode("#ffffff"));
		this.setBackground(new Color(26, 26, 26));
		this.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 120, 215)));
		this.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int key = (int) e.getKeyChar();
		if (type == 1) { // Validación con punto decimal
			if (e.getSource() == this) {
				if (key >= 46 && key <= 57) {
					if (key == 46) {
						String data = this.getText();
						int n = data.length();
						for(int i = 0; i <= n; i++) {
							if (data.contains("."))
								e.setKeyChar((char) KeyEvent.VK_CLEAR);
						}
					}if (key == 47)
						e.setKeyChar((char) KeyEvent.VK_CLEAR);
				}else {
					e.setKeyChar((char) KeyEvent.VK_CLEAR);
					e.consume();
				}
			}
		}else if (type == 2) { // Solo letras con espacio
			if (key >= 65 && key <= 90 || key == 32 || key >= 97 && key <= 122) {
				
			}else {
				e.setKeyChar((char) KeyEvent.VK_CLEAR);
				e.consume();
			}
		}else if(type == 3) { // Solo numeros
			if (key >= 48 && key <= 57) {
				
			}else {
				e.setKeyChar((char) KeyEvent.VK_CLEAR);
				e.consume();
			}
		}else if (type == 4) {//Numeros y letras sin espacios
			if (key >= 65 && key <= 90  || key >= 97 && key <= 122 || key >= 48 && key <= 57) {
				
			}else {
				e.setKeyChar((char) KeyEvent.VK_CLEAR);
				e.consume();
			}
		}else if (type == 5) {
			if (key >= 65 && key <= 90  || key >= 97 && key <= 122) { // Solo letras
				
			}else {
				e.setKeyChar((char) KeyEvent.VK_CLEAR);
				e.consume();
			}
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
}
