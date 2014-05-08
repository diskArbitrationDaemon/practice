package receiptGen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class runReceiptGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReceiptGenerator r = new ReceiptGenerator();
		
		String configFile = "data.dat";
		int week;
		int year;
		
		try {
			System.out.println("Reading config from " + System.getProperty("user.dir") + "/" + configFile);
			Scanner in = new Scanner(new FileReader(configFile));
			System.out.println("Config read successfully");
			week = Integer.parseInt(in.nextLine());
			year = Integer.parseInt(in.nextLine());
			in.close();
			r.newReceipt(year, week);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			boolean valid = false;

			System.out.println("config file not found.");
			System.out.println("Enter year:");
			Scanner in = new Scanner(System.in);
			year = 0;
			week = 0;
			while (!valid){
				year = in.nextInt();
				if (year >= 2014){
					valid = true;
				}
			}
			
			valid = false;
			while (!valid){
				System.out.println("Enter week of year:");
				week = in.nextInt();
				if (week > 0 && week <= 52){
					valid = true;
				}
			}
			in.close();
			if (valid) r.newReceipt(year, week);

		} catch (NumberFormatException e){
			System.out.println("data.dat contains in valid data. It should be in the form of"
					+ "\nWW   (Week of Year)" + "\nYYYY   (Year)");
		}
		

	}

}
