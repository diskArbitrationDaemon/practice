package receiptGen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;

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

public class ReceiptGenerator {
	
	private String fileName = "";
	
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	      Font.BOLD);
	
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 13,
		      Font.NORMAL);
	
	private static Font cellFont = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
	
	
	
	public void newReceipt(int receiptYear, int receiptWeek){
		
		System.out.println("Generating Receipt...");
		Document document = new Document();
		fileName = "receipt_" + receiptYear + "_" + receiptWeek + ".pdf";
	    try {
	    	FileOutputStream fos = new FileOutputStream(fileName);
	    	
			PdfWriter.getInstance(document, fos);
		    document.open();
		    
		    System.out.println("Generating receipt for Week " + receiptWeek + ", " + receiptYear);
		    
			Receipt r = new Receipt(receiptYear, receiptWeek);
			document.add(addHeader(r));
		    document.add(generateContent(r));
		    
		    System.out.println("Receipt saved at " + System.getProperty("user.dir") + "/" + fileName);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			
			document.close();
//			try {
//				PrintWriter writer = new PrintWriter("data.dat");
//				
//				receiptWeek++;
//				if (receiptWeek == 53){
//					receiptWeek = 1;
//					receiptYear++;
//				}
//				
//				writer.println(receiptWeek);
//				writer.println(receiptYear);
//				writer.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				System.out.println("unable to save data.dat");
//			}

		}
	    
		
		
	}
	
	public Paragraph addHeader(Receipt r){
		Paragraph preface = new Paragraph();
	    // We add one empty line
	    addEmptyLine(preface, 1);
	    
	    preface.add(new Paragraph("Receipt", catFont));
	    addEmptyLine(preface, 1);

	    preface.add(new Paragraph("Receipt:     #" + r.getRentReceiptNumber(), subFont));
	    preface.add(new Paragraph("Issue date:   " + r.getIssueDate(), subFont));
	    
	    addEmptyLine(preface, 1);

	    preface.add(new Paragraph(r.getPropertyAddress(), cellFont));
	    	    
	    addEmptyLine(preface, 1);

	    return preface;

	}
	
	public PdfPTable generateContent(Receipt r){
		PdfPTable table = new PdfPTable(2);

	     //t.setBorderColor(BaseColor.WHITE);
	    // t.setPadding(4);
	    // t.setSpacing(4);
	    // t.setBorderWidth(1);
	    
	    
	    PdfPCell c1 = new PdfPCell(new Phrase("Rent paid for", cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);

	    table.addCell(c1);

	    
	    
	    
	    c1 = new PdfPCell(new Phrase(r.getPaidStartDate() + "  to  "+ r.getPaidEndDate(), cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("Amount received", cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("$ " + r.getRentAmount(), cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    c1.setPaddingBottom(20f);
	    
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("From", cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase(r.getPayer(), cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase("To", cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    
	    table.addCell(c1);
	    
	    c1 = new PdfPCell(new Phrase(r.getRecipient(), cellFont));
	    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	    c1.setBorder(Rectangle.NO_BORDER);
	    
	    table.addCell(c1);

	  
	    
	    return table;
	}
	
	private void addEmptyLine(Paragraph paragraph, int number) {
	    for (int i = 0; i < number; i++) {
	      paragraph.add(new Paragraph(" "));
	    }
	  }
}
