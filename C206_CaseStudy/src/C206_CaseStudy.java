// Create by Ling Ying.
import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int VIEW_ALLTHRESHOLD = 4;
	private static final int UPDATE_THRESHOLD = 3;
	private static final int SEARCH_HOLDING = 2;
	private static final int VIEW_ALLHOLDING = 1;
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		
		ArrayList<MoneyHolding> MoneyHoldingList = new ArrayList<MoneyHolding>();
		
		MoneyHoldingList.add(new MoneyHolding("USD", 100000.00, 10000.00));
		MoneyHoldingList.add(new MoneyHolding("MYR", 500000.00, 50000.00));
		MoneyHoldingList.add(new MoneyHolding("THB", 2000000.00, 100000.00));
		MoneyHoldingList.add(new MoneyHolding("JPY", 1500000.00, 500000.00));
		MoneyHoldingList.add(new MoneyHolding("KRW", 200000.00, 1000000.00));
		
		MoneyHolding[] ThresHoldList = new MoneyHolding [5];
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			int menu = Helper.readInt("Enter an option: ");

			//MoneyHolding
			if (menu == VIEW_ALLHOLDING) {
				C206_CaseStudy.viewAllHoldingAndSgdValue(MoneyHoldingList);
				}
			else if (menu == SEARCH_HOLDING) {
				C206_CaseStudy.searchHoldingCurrencies(MoneyHoldingList);
				}
			else if (menu == UPDATE_THRESHOLD) {
				C206_CaseStudy.updateThresholdHoldings(MoneyHoldingList);
				}
			else if (menu == VIEW_ALLTHRESHOLD) {
				C206_CaseStudy.viewAllThresholdHoldings(MoneyHoldingList);
				}
			else {
				System.out.println("Invalid");	
				}
			}
		}
	
	public static void menu() {
		C206_CaseStudy.setHeader("MONEY EXCHANGE SYSTEM [HOLDINGS AND SGD VALUE]");
		System.out.println("1. VIEW MONEY HOLDING WITH VARIOUS CURRENCIES");
		System.out.println("2. SEARCH HOLDING OF CURRENCIES");
		System.out.println("3. UPDATE THRESHOLD OF CURRENCIES");
		System.out.println("4. VIEW THRESHOLD HOLDINGS");
		Helper.line(80, "-");
		}
			
	public static void setHeader(String header) {
		Helper.line(80, "=");
		System.out.println(header);
		Helper.line(80, "=");
		}
	
	public static String retrieveAllHoldingAndSgdValue(ArrayList<MoneyHolding> MoneyHoldingList) {
		String output = " ";
		for (int i = 0; i < MoneyHoldingList.size(); i++) {
			String iso = MoneyHoldingList.get(i).getIso();
			double holdingAmt = MoneyHoldingList.get(i).getHoldingAmt();
			output += String.format("%-80s \n", MoneyHoldingList.get(i).toString());
			}
		return output;
		}
	
	//ViewAllHoldingAndSgdValue
	public static void viewAllHoldingAndSgdValue (ArrayList<MoneyHolding> MoneyHoldingList) {
		C206_CaseStudy.setHeader("MONEY HOLDING LIST");
		String output = " ";
		System.out.println(String.format("%-20s %-20s %-20s\n", "ISO", "HOLDINGS", "SGD_VALUE"));
		for (int i = 0; i < MoneyHoldingList.size(); i++) {
			
			double rate = 0.0;
			if (MoneyHoldingList.get(i).getIso().equals("USD")) {
				rate = 0.73;
			}
			else if (MoneyHoldingList.get(i).getIso().equals("MYR")) {
				rate = 3.05;
			}
			else if (MoneyHoldingList.get(i).getIso().equals("THB")) {
				rate = 23.04;
			}
			else if (MoneyHoldingList.get(i).getIso().equals("JPY")) {
				rate = 77.21;
			}
			else if (MoneyHoldingList.get(i).getIso().equals("KRW")) {
				rate = 869.85;
			}
			else {
				System.out.println("Invalid");
			}
			output += String.format("%-20s %-20.2f %-20.2f\n", MoneyHoldingList.get(i).getIso(), 
				MoneyHoldingList.get(i).getHoldingAmt(), (MoneyHoldingList.get(i).getHoldingAmt() * rate));
		}
		System.out.println(output);
		}
	
	//SearchHoldingCurrencies
	public static void searchHoldingCurrencies(ArrayList<MoneyHolding> MoneyHoldingList) {
		String output = " ";
		String search = Helper.readString("Enter currency > ");
		System.out.println(String.format("%-20s %-20s %-20s\n", "ISO", "HOLDINGS", "SGD_VALUE"));
		
		double rate = 0.0;
		if (search.equalsIgnoreCase("USD")) {
			rate = 0.73;
			System.out.println(String.format("%-20s %-20.2f %-20.2f\n", "USD", 100000.00, 100000.00 * rate));
		}
		else if (search.equalsIgnoreCase("MYR")) {
			rate = 3.05;
			System.out.println(String.format("%-20s %-20.2f %-20.2f\n", "MYR", 500000.00, 100000.00 * rate));
		}
		else if (search.equalsIgnoreCase("THB")) {
			rate = 23.04;
			System.out.println(String.format("%-20s %-20.2f %-20.2f\n", "THB", 2000000.00, 100000.00 * rate));
		}
		else if (search.equalsIgnoreCase("JPY")) {
			rate = 77.21;
			System.out.println(String.format("%-20s %-20.2f %-20.2f\n", "JPY", 1500000.00, 100000.00 * rate));
		}
		else if (search.equalsIgnoreCase("KRW")) {
			rate = 869.85;
			System.out.println(String.format("%-20s %-20.2f %-20.2f\n", "KRW", 200000.00, 100000.00 * rate));
		}
		else {
			System.out.println("Invalid");
		}
		System.out.println(output);
		}
	
	public static void updateThresholdHoldings (ArrayList<MoneyHolding> MoneyHoldingList) {
		C206_CaseStudy.setHeader("UPDATE THRESHOLD");
		String output = " ";
		
		for (int i = 0; i < MoneyHoldingList.size(); i++) {
			Helper.line(80, "*");;
			String iso = Helper.readString("Enter currency > ");
			double newThresHold = Helper.readDouble("Enter new threshold > ");
			
			if (iso.equalsIgnoreCase("USD")) {
				MoneyHoldingList.get(i).setthresHold(newThresHold);
				System.out.println("The threshold have been updated!");
			}
			else if (iso.equalsIgnoreCase("MYR")) {
				MoneyHoldingList.get(i).setthresHold(newThresHold);
				System.out.println("The threshold have been updated!");
			}
			else if (iso.equalsIgnoreCase("THB")) {
				MoneyHoldingList.get(i).setthresHold(newThresHold);
				System.out.println("The threshold have been updated!");
			}
			else if (iso.equalsIgnoreCase("JPY")) {
				MoneyHoldingList.get(i).setthresHold(newThresHold);
				System.out.println("The threshold have been updated!");
			}
			else if (iso.equalsIgnoreCase("KRW")) {
				MoneyHoldingList.get(i).setthresHold(newThresHold);
				System.out.println("The threshold have been updated!");
			}
			else {
				System.out.println("Invalid");
			}
			output += String.format("%-20s %-20.2f\n", MoneyHoldingList.get(i).getIso(), 
					MoneyHoldingList.get(i).getthresHold());
		}
	}
	
	public static void viewAllThresholdHoldings (ArrayList<MoneyHolding> MoneyHoldingList) {
		C206_CaseStudy.setHeader("THRESHOLD HOLDINGS");
		String output = " ";
		
		double threshold = Helper.readDouble("Enter the threshold amount > ");
		System.out.println(String.format("%-20s %-20s\n", "ISO", "HOLDINGS"));
		
		double [] ThresHoldList = {10000.00, 50000.00, 100000.00, 500000.00, 1000000.00};
		
		for (int i = 0; i < ThresHoldList.length; i++) {
			if (ThresHoldList[i] < threshold) {
				output += String.format("%-20s %-20.2f\n", MoneyHoldingList.get(i).getIso(), MoneyHoldingList.get(i).getHoldingAmt());
			}
			
		}
		System.out.println(output);
	}
}

