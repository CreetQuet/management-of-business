package Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimerTask;

import Core.SQLConnection;
import View.MainScreen;

public class UpdateSalesOfDayTask extends TimerTask{

	private MainScreen view;
	private SQLConnection con;
	public UpdateSalesOfDayTask(MainScreen v) {
		view = v;
		con = new SQLConnection();
	}

	@Override
	public void run() {
		
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		Connection conn = con.getConnection();
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		float bruto = 0, neto = 0;
		String query  = "SELECT SUM(Total) FROM venta"; // Bruto
		String query2  = "SELECT SUM(P.PrecioCompra * DV.Cantidad) FROM detallesventa AS DV LEFT JOIN productos AS P ON DV.CodigoProducto = P.Codigo LEFT JOIN venta AS V ON V.idVenta = DV.idVenta"; // Bruto
		try {
			ps  = conn.prepareStatement(query);
			ps2 = conn.prepareStatement(query2);
			rs2 = ps2.executeQuery();
			rs  = ps.executeQuery();			
			while (rs.next()) {
				bruto = rs.getFloat(1);
				//neto  = rs.getFloat(2);
			}
			
			while (rs2.next())
				neto = rs2.getFloat(1);
			
			view.lblMoneyB.setText("$" + bruto);
			view.lblMoneyN.setText("$" + (bruto - neto));
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

}
