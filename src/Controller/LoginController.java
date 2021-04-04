package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import Business.ProductRepository;
import Business.UserRepository;
import Model.Configuration;
import Model.User.UserModel;
import Task.UpdateSalesOfDayTask;
import View.BuyPointView;
import View.LoginView;
import View.MainScreen;


public class LoginController implements ActionListener{

	private LoginView view;
	private UserRepository model;
	
	private Boolean IsLogin;
	
	private ArrayList<UserModel> userInfo = new ArrayList<>();
	
	public String Name;
	public int Rank = 0;
	
	public LoginController(LoginView v, UserRepository m) {
		view = v;
		model = m;
		view.btnLogin.addActionListener(this);
	}
	
	public void startLoginView() {
		view.setUndecorated(true);
		view.setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e) {
		view.btnLogin.setEnabled(false);
		model.setUsername(view.txtUser.getText());
		model.setPassword(view.txtPwd.getText());
		
		IsLogin = model.ValidateUser();
		userInfo.add(model.getUserInfo());
		
		Rank = userInfo.get(0).getCharge();
		Name = userInfo.get(0).getName();
		
		/*for (UserModel u : userInfo) {
			System.out.println(u.getName() + " CodigoPuesto: " + u.getCharge());
		}*/
		
		if (IsLogin) {
			//System.out.println("TEST");
			view.lblError.setText("Logeado Correctamente");
			
			if (Rank == 0) {
				///Administrador
				MainScreen mn = new MainScreen();
				UserRepository uR = new UserRepository();
				MainButtonController uC = new MainButtonController(mn);
				
				TableUserController TUC = new TableUserController(mn, uR);
				//TableProductController tpc= new TableProductController(mn, new ProductRepository());
				Timer timer = new Timer();
				timer.scheduleAtFixedRate(new UpdateSalesOfDayTask(mn), 1000, 1000);
				//tpc.showProducts();
				mn.setLocationRelativeTo(null);
				mn.setVisible(true);
				
			}else if (Rank == 1) {
				BuyPointView bPView = new BuyPointView();
				UserModel user = userInfo.get(0);
				ProductRepository repoP = new ProductRepository();
				//TableBuyPointController tbpC = new TableBuyPointController(bPView, repoP);
				//Configuration conf = new Configuration();
				BuyPointMainController controller = new BuyPointMainController(bPView, user);
				bPView.setLocationRelativeTo(null);
				bPView.setVisible(true);
			}
			
			view.dispose();
			
		}else {
			view.lblError.setText("Credenciales Incorrectas");
			view.btnLogin.setEnabled(true);
		}
	}

	public Boolean getIsLogin() {
		return IsLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		IsLogin = isLogin;
	}
	
/*	class Login implements Runnable{

		@Override
		public void run() {
			view.btnLogin.setEnabled(false);
			model.setUsername(view.txtUser.getText());
			model.setPassword(view.txtPwd.getText());
			IsLogin = model.ValidateUser();
			if (IsLogin) {
				view.lblError.setText("Logeado Correctamente");
				MainScreen mn = new MainScreen();
				mn.setLocationRelativeTo(null);
				mn.setVisible(true);
				view.dispose();
			}else {
				view.lblError.setText("Credenciales Incorrectas");
				view.btnLogin.setEnabled(true);
			}
		}
	}*/
}
