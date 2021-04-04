package Business;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import Core.SQLConnection;
import Model.Configuration;
import Model.Report.ReportModel;

public class ReportRepository extends SQLConnection{
	private ArrayList<ReportModel> report;
	
	protected HashMap<String, String> data;
	
	private String d1,d2;
	private float realPercent;
	private Boolean useVat;
	//private float vatPercentage;
	public ReportRepository(String d1, String d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public void inizializer() {
		Configuration cfg = new Configuration();
		data = cfg.getConfiguration();
		//realPercent = (Float.parseFloat(data.get("vatPercent")) * 0.01f);
		useVat = Boolean.parseBoolean(data.get("vat"));
		//vatPercentage = Float.parseFloat(data.get("vatPercent"));
		realPercent = useVat ? (Float.parseFloat(data.get("vatPercent")) * 0.01f) : 1;
	}
	
	public ArrayList<ReportModel> getDataReport(){
		report = new ArrayList<ReportModel>();
		PreparedStatement ps = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		System.out.println(realPercent);
		String query = "SELECT C.Nombre, SUM(DV.Subtotal) + (SUM(DV.Subtotal) * "+ realPercent +") FROM detallesventa AS DV RIGHT JOIN productos AS P ON DV.CodigoProducto = P.Codigo"
				+ " LEFT JOIN venta AS V ON V.idVenta = DV.idVenta "
				+ "LEFT JOIN categoria AS C ON P.idCategoria = C.idCategoria WHERE V.Fecha BETWEEN ? AND ? GROUP BY C.idCategoria";

		try {
			
			ps = conn.prepareStatement(query);
			ps.setString(1, d1);
			ps.setString(2, d2);
			rs = ps.executeQuery();
			while (rs.next()) {
				report.add(new ReportModel(rs.getString(1), rs.getFloat(2)));
				System.out.println(rs.getString(1) + rs.getFloat(2));
			}
			return report;
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				conn.close();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		return report;
	}
}
