package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

import Business.ProductRepository;
import Business.SaleRepository;
import Core.SQLConnection;
import Model.Product.CartModel;
import Model.Sale.DetailSaleModel;
import Model.Sale.SaleModel;
import View.CobrarView;

public class SaleController extends SQLConnection implements KeyListener, ActionListener{

	private CobrarView view;
	private BuyPointMainController controller;
	private DecimalFormat formateador;
	private ProductRepository productRepo;
	private SaleRepository saleRepo;
	protected float cambio, money;
	protected float total, subTotal;
	protected ArrayList<CartModel> cart;
	//protected ArrayList<DetailSaleModel> detail = new ArrayList<DetailSaleModel>();
	
	public SaleController(CobrarView cv, BuyPointMainController bpc) {
		view = cv;
		controller = bpc;
		view.txtMoney.addKeyListener(this);
		total = controller.getTotal();
		//subTotal = controller.getSubTotal();
		cart = controller.getCart();
		formateador = new DecimalFormat("##.#");
		productRepo = new ProductRepository();
		saleRepo = new SaleRepository();
		view.lblTotal.setText(formateador.format(total));
		view.btnCancelSale.addActionListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == view.txtMoney) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				money = Float.parseFloat(view.txtMoney.getText());
				if (money >= total) {
					cambio = money - total;
					view.lblCambio.setText("Cambio: $" + formateador.format(cambio));
					
					for (CartModel cartModel : cart) {
						productRepo.UpdateStock(cartModel.getCode(), cartModel.getCantidad());
						System.out.println("Code: " + cartModel.getCode() + " Cantidad: " + cartModel.getCantidad());
					}
					//public SaleModel(int codeEmp, Date dateTime, float t, float money, float moneyChang)
					int idSale = saleRepo.CountSales() + 1;
					saleRepo.AddSale(new SaleModel(idSale, controller.getUser().getCode(), total, money, cambio));
					for (CartModel cartModel : cart) {
						//detail.add(new DetailSaleModel(idSale, cartModel.getCode(), cartModel.getPrice(), cartModel.getCantidad(), cartModel.getImporte()));
						saleRepo.AddDetailSale(idSale, cartModel.getCode(), cartModel.getPrice(), cartModel.getCantidad(), cartModel.getImporte()); //Detalles de venta	
					}
					
					controller.Cancel();
					
					JOptionPane.showMessageDialog(view, "La venta se ha realizado con éxito.");
					view.dispose();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnCancelSale) {
			controller.Cancel();
			view.dispose();
		}
	}

}
