package Controller;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Business.ProductRepository;
import Core.UI.CustomFont;
import Model.Configuration;
import Model.Product.CartModel;
import Model.Product.ProductModel;
import Model.User.UserModel;
import Task.DateTimeTask;
import View.BuyPointView;
import View.CobrarView;

public class BuyPointMainController implements ActionListener, KeyListener{
	private BuyPointView view;
	public UserModel user;
	private ProductRepository repo;
	private DefaultTableModel dm;
	
	private int cant;
	public float subTotal, Total;
	private float impor;
	//private float money, cambio;
	
	public ArrayList<CartModel> cart = new ArrayList<CartModel>();
	private ProductModel object;
	
	protected HashMap<String, String> data;
	
	protected Boolean useVat;
	protected float vatPercentage, realPercent;
	
	private Configuration config;
	
	private JLabel lblSubTotal, lblIva;
	
	public BuyPointMainController(BuyPointView v, UserModel u) {
		view = v;
		user = u;
		//Action Listener
		view.btnCancelBuy.addActionListener(this);
		view.btnCheckout.addActionListener(this);
		view.btnDeleteP.addActionListener(this);
		
		view.txtCode.addKeyListener(this);
		repo = new ProductRepository();
		//Key Listener
		/*view.btnDeleteP.addKeyListener(this);
		view.btnCheckout.addKeyListener(this);
		view.btnCancelBuy.addKeyListener(this);*/
		//this.view.addKeyListener(this);
		inizializer();
	}
	
	public void inizializer() {
		view.lblName.setText(user.getName() + " | Cajero");
		DateTimeTask date = new DateTimeTask(view);
		Timer time = new Timer();
		time.scheduleAtFixedRate(date, 0, 1000);
		
		dm = new DefaultTableModel();
		dm.addColumn("Codigo Producto");
		dm.addColumn("Cantidad");
		dm.addColumn("Descripción");
		dm.addColumn("Precio");
		dm.addColumn("Importe");
		view.table.setModel(dm);
		config = new Configuration();
		data = config.getConfiguration();
		useVat = Boolean.parseBoolean(data.get("vat"));
		vatPercentage = Float.parseFloat(data.get("vatPercent"));
		//float p = Float.parseFloat(data.get("vatPercent")) * 0.01f;
		realPercent = useVat ? (Float.parseFloat(data.get("vatPercent")) * 0.01f) : 1;
		System.out.println("UseVat: " + useVat + " Porcentaje de iva: " + vatPercentage + " Porcentaje Real: " + realPercent);
		impor = 0;
		component();
	}
	public void component() {
		if (useVat) {
			CustomFont f = new CustomFont();
			lblSubTotal = new JLabel("SUBTOTAL:  $00.0");
			lblSubTotal.setBounds(10, 11, 175, 29);
			lblSubTotal.setFont(f.Font(f.Roboto_Black, 0, 15));
			lblSubTotal.setForeground(SystemColor.text);
			view.paneTotal.add(lblSubTotal);
			
			lblIva = new JLabel("IVA " + vatPercentage + "%: $00.0");
			lblIva.setBounds(10, 56, 175, 29);
			lblIva.setFont(f.Font(f.Roboto_Black, 0, 15));
			lblIva.setForeground(SystemColor.text);
			view.paneTotal.add(lblIva);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnDeleteP) {
			try {
				int row = view.table.getSelectedRow();
				if (row != -1) {
					System.out.println("Row: " + row);
					float impor = (float) view.table.getValueAt(row, 4);
					System.out.println(view.table.getValueAt(row, 4));
					subTotal -= impor;
					float iva = subTotal * realPercent;
					Total = subTotal + iva;
					view.lblTotal.setText("TOTAL: $" + Total);
					if (useVat) {
						lblSubTotal.setText("SUBTOTAL: $" + subTotal);
						lblIva.setText("IVA " + vatPercentage + "%: $" + iva);
					}
					dm.removeRow(row);
					cart.remove(row);
					impor = 0;
				}else {
					JOptionPane.showMessageDialog(view, "Selecciona el producto que deseas eliminar");
				}
			}catch(ArrayIndexOutOfBoundsException ex) {
				ex.printStackTrace();
			}
		}
		if (e.getSource() == view.btnCancelBuy) {
			Cancel(); // Cancela la compra
		}
		if (e.getSource() == view.btnCheckout) {
			CheckOut(); // Cobra la compra
		}
	}

	public void Cancel() {
		cart.clear();
		System.out.println("Cancel");
		while (dm.getRowCount() > 0 ) {
			dm.removeRow(0);
		}
		impor = 0;
		subTotal = 0;
		Total = 0;
		subTotal = 0;
		float iva = 0;
		view.lblTotal.setText("TOTAL: $" + Total);
		if (useVat) {
			lblSubTotal.setText("SUBTOTAL: $" + subTotal);
			lblIva.setText("IVA " + vatPercentage + "%: $" + iva);
		}
	}
	
	private void CheckOut() {
		if (!cart.isEmpty()) {
			//money = JOptionPane.showInputDialog(view, "")
			CobrarView cV = new CobrarView();
			SaleController sC = new SaleController(cV, this);
			cV.setLocationRelativeTo(null);
			cV.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(view, "No hay productos para cobrar", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == view.txtCode) {
			int key = (int) e.getKeyChar();
			if (key >= 48 && key <= 57) {
			}else {
				e.setKeyChar((char) KeyEvent.VK_CLEAR);
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == view.txtCode) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				String code = view.txtCode.getText();
				if (code != null) {
					if (repo.ExistProduct(code)) {
						cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));
						
						object = repo.getProduct(code);
						Object row[] = new Object[5];
						
						subTotal += object.getPrecioVenta() * cant;
						
						cart.add(new CartModel(object.getCodigo(), cant, object.getDescripcion(), object.getPrecioVenta(), object.getPrecioVenta() * cant));
						
						for (CartModel object : cart) {
							row[0] = object.getCode();
							row[1] = object.getCantidad();
							row[2] = object.getDescription();
							row[3] = object.getPrice();
							row[4] = object.getImporte();
						}
						
						dm.addRow(row);
						float iva = subTotal * realPercent;
						if (useVat) {
							lblSubTotal.setText("SUBTOTAL: $" + subTotal);
							lblIva.setText("IVA " + vatPercentage + "%: $" + iva);
						}
						Total = subTotal + iva;
						iva = 0;
						view.lblTotal.setText("TOTAL: $" + Total);
						view.txtCode.setText("");
					}else {
						JOptionPane.showMessageDialog(view, "El código no existe en la base de datos.");
					}
				}else {
					JOptionPane.showMessageDialog(view, "Primero ingresa un código");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	public ArrayList<CartModel> getCart() {
		return cart;
	}

	public void setCart(ArrayList<CartModel> cart) {
		this.cart = cart;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
	
}
