import java.awt.EventQueue;
import javax.swing.UIManager;
import Business.UserRepository;
import Controller.LoginController;
import Model.Configuration;
import View.LoginView;

public class Main {
	
	public static void main(String[] args) {
				
		Configuration cfg = new Configuration();
		cfg.createConfigurationFile();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Toolkit t = Toolkit.getDefaultToolkit();
					/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);*/
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UserRepository lm = new UserRepository();
					LoginView lv = new LoginView();
					LoginController lc = new LoginController(lv, lm);
					
					lc.startLoginView();
					lv.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
