package Core.UI;

import java.awt.Color;

import javax.swing.JLabel;

public class Label extends JLabel{

	public Label(String title) {
		
		CustomFont f = new CustomFont();
		this.setText(title);
		this.setForeground(Color.decode("#FFFFFF"));
		this.setFont(f.Font(f.Roboto_Black, 0, 14));
	}

}
