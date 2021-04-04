package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Business.GenerarPDF;
import Business.ReportRepository;
import View.SelectDateRange;

public class ReportGenerationController implements ActionListener {

	private SelectDateRange view;
	private String ruta = null;
	private Date fDate, tDate;
	private String fromDate, toDate;
	private SimpleDateFormat sdf;
	
	public ReportGenerationController(SelectDateRange v) {
		view = v;
		view.btnGenerar.addActionListener(this);
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnGenerar) {
			//System.out.println(dlg.getFileFilter());
				try {
					
					fDate = view.date1.getDate();
					tDate = view.date2.getDate();
					
					if (fDate != null && tDate != null) {
						
						long fd = fDate.getTime();
						long td = tDate.getTime();
						
						java.sql.Date fromD = new java.sql.Date(fd);
						java.sql.Date toD   = new java.sql.Date(td);
						
						if (fd <= td) {
							fromDate = fromD.toString() + " 00:00:00";
							toDate   = toD.toString() + " 23:59:59";
							/*===============================================================================*/
							JFileChooser dlg = new JFileChooser();
							dlg.setDialogTitle("Guardar reporte...");
							
							dlg.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
							
							int option = dlg.showSaveDialog(view);
							File f = dlg.getSelectedFile();
							ruta = f.toString();
							
							if (option == JFileChooser.APPROVE_OPTION) {
								ReportRepository repo = new ReportRepository(fromDate, toDate);
								repo.inizializer();
								GenerarPDF pdf = new GenerarPDF(ruta + ".pdf", repo.getDataReport(), sdf.format(fDate), sdf.format(tDate));
								view.dispose();
							}else {
								System.out.println("No eligió");
							}
							/*===============================================================================*/
							System.out.println("Desde: " + fromDate + " Hasta: " + toDate);
						}else {
							//System.out.println(fromD.toString() + " Debe ser menor o igual a " + toD.toString());
							JOptionPane.showMessageDialog(view, sdf.format(tDate) + " debe ser mayor o igual a: " + sdf.format(fDate));
						}
					}else {
						JOptionPane.showMessageDialog(view, "Selecciona un rango de fechas");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
	}

}
