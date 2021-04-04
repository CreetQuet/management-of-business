package Business;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Model.Report.ReportModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class GenerarPDF {
	
	private Font fBold = new Font(Font.FontFamily.COURIER, 24, Font.BOLD);
	private Font fNormal = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
	private Font font = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
	private Font font2 = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
	private float total;
	
	public GenerarPDF(String DEST, ArrayList<ReportModel> data, String d1, String d2) {
		try {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        
        document.add(getHeader("Reporte de ventas"));
        document.add(getDate());
        document.add(getInfo("Del "+ d1 + " al "+ d2));
        document.add(getInfo(" "));
        document.add(getInfo(" "));
        document.add(getInfo(" "));
        document.add(getInfo(" "));
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(50);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.setWidths(new int[]{8, 4});
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        font.setColor(BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase("Categoria", font));
        PdfPCell cell2 = new PdfPCell(new Phrase("Total", font));
        cell.setBackgroundColor(new BaseColor(46, 46, 46));
        cell2.setBackgroundColor(new BaseColor(46, 46, 46));
        cell.setFixedHeight(25f);
        cell2.setFixedHeight(25f);
        table.addCell(cell);
        table.addCell(cell2);
        //cell.setBackgroundColor(Color.decode("#1a1a1a"));
        total = 0;
        int i = 0;
        for (ReportModel d : data) {
        	if (i == 1) {
        		font2.setColor(BaseColor.BLACK);
        		PdfPCell c = new PdfPCell(new Phrase(d.getCategoryName(), font2));
        		c.setBackgroundColor(new BaseColor(33, 137, 255));
        		c.setFixedHeight(15f);
        		PdfPCell c2 = new PdfPCell(new Phrase(Float.toString(d.getSaleTotal()), font2));
        		c2.setBackgroundColor(new BaseColor(33, 137, 255));
        		c2.setFixedHeight(25f);
        		table.addCell(c);
        		table.addCell(c2);
        		i = 0;
        	}else {
        		font2.setColor(BaseColor.BLACK);
        		PdfPCell c3 = new PdfPCell(new Phrase(d.getCategoryName(), font2));
        		c3.setBackgroundColor(BaseColor.WHITE);
        		c3.setFixedHeight(25f);
        		PdfPCell c4 = new PdfPCell(new Phrase(Float.toString(d.getSaleTotal()), font2));
        		c4.setBackgroundColor(BaseColor.WHITE);
        		c4.setFixedHeight(25f);
        		table.addCell(c3);
    			table.addCell(c4);
    			i++;
        	}
        	total += d.getSaleTotal();
		}
        
        PdfPCell cellw = new PdfPCell(new Phrase("Total", font));
        PdfPCell cellT = new PdfPCell(new Phrase(Float.toString(total), font));
        cellw.setBackgroundColor(new BaseColor(131, 131, 131));
        cellT.setBackgroundColor(new BaseColor(131, 131, 131));
        cellw.setFixedHeight(25f);
        cellT.setFixedHeight(25f);
        table.addCell(cellw);
        table.addCell(cellT);
       
        document.add(table);
        document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private Paragraph getHeader(String text) {
		Paragraph p = new Paragraph();
		Chunk c= new Chunk();
		p.setAlignment(Element.ALIGN_CENTER);
		c.append(text);
		c.setFont(fBold);
		p.add(c);
		return p;
	}
	private Paragraph getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Paragraph p = new Paragraph();
		Chunk c= new Chunk();
		p.setAlignment(Element.ALIGN_RIGHT);
		c.append("Generado: " + sdf.format(new Date()));
		c.setFont(fNormal);
		p.add(c);
		return p;
	}
	private Paragraph getInfo(String text) {
		Paragraph p = new Paragraph();
		Chunk c= new Chunk();
		p.setAlignment(Element.ALIGN_CENTER);
		c.append(text);
		c.setFont(fNormal);
		p.add(c);
		return p;
	}
}
