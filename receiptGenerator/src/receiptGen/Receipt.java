package receiptGen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/***
 * Recipt class that contains all receipt data.
 * @author chengzhewu
 *
 */
public class Receipt {

	private int week;
	private int year;
	private Calendar issueDate;
	private Calendar rentStart;
	private int weeksPaidInAdvance = 1;
	private int rentAmount = 410;
	
	private String payer = "Adam & Angela Hayes";
	private String recipient = "Shubiao Wu & Xuemei Han";
	
	private String propertyAddress = "73 Norris Dr, Armidale NSW 2350";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Receipt(int year, int week) throws ParseException{
		this.week = week;
		this.year = year;
		Calendar rentStart = Calendar.getInstance();
		rentStart.set(Calendar.YEAR, year);
		rentStart.set(Calendar.WEEK_OF_YEAR, this.week);
		rentStart.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		
		issueDate = Calendar.getInstance();
		this.rentStart = rentStart;
	}
	
	public String getRentReceiptNumber(){
		
		return (Integer.toString(year) + String.format("%02d", week));
	}
	
	public String getIssueDate(){
		return sdf.format(this.issueDate.getTime());
	}
	
	public String getPaidStartDate(){
		
		return sdf.format(rentStart.getTime());
	}
	
	public String getPaidEndDate(){
		Calendar endDate = (Calendar) rentStart.clone();
		endDate.add(Calendar.WEEK_OF_YEAR, weeksPaidInAdvance);
		endDate.add(Calendar.DATE, -1);
		
		return sdf.format(endDate.getTime());
	}
	
	public int getRentAmount(){
		return rentAmount;
	}
	
	public String getPayer(){
		return this.payer;
	}
	
	public String getRecipient(){
		return this.recipient;
	}
	
	public String getPropertyAddress(){
		return this.propertyAddress;
	}
	
}
