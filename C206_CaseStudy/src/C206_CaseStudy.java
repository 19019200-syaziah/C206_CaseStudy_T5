import java.util.ArrayList;
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Currency> cList = new ArrayList <Currency>();
		int option = 0;
		
		while (option != 4) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				Currency c =  inputCurrency();
				C206_CaseStudy.addCurrencyInfo(cList, c);
				
			} 
			else if(option == 2) {
				if (cList.isEmpty()) {
					System.out.println("List is empty.");
					
				} 
				else {
					C206_CaseStudy.viewCurrencyInfo(cList);
					
				}
					
			}
			else if (option == 3) {
				if (cList.isEmpty()) {
					System.out.println("List is empty.");
						
				}
				else {
					C206_CaseStudy.deleteCurrencyInfo(cList);
					
				}
						
			}
			else if (option == 4) {
				System.out.println("Program End.");
				
			}
			else {
				System.out.print("Invalid Option.");
			}
				
			
			
		}
		
	}
	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Money Exchange");
		System.out.println("1. Add Currency");
		System.out.println("2. View Currencies");
		System.out.println("3. Delete Currency");
		System.out.println("4. Quit");
		Helper.line(80, "-");
		
	}
	private static Currency inputCurrency() {
		String iso = Helper.readString("Enter Currency ISO > ");
		String name = Helper.readString("Enter Currency Name > ");
		int buyRate = Helper.readInt("Enter Currency Buy Rate > ");
		int sellRate = Helper.readInt("Enter Currency Sell Rate > ");
		Currency c = new Currency(iso, name, buyRate, sellRate);
		return c;
		
	}
	//Add
	public static void addCurrencyInfo(ArrayList<Currency>cList, Currency c) {
		cList.add(c);
		System.out.println("Currency added.");
		
	}
	//View
	public static String retrieveAllCurrencyInfo(ArrayList<Currency>cList) {
		String output = "";
		for (int i  = 0; i < cList.size(); i++) {
			Currency cur = cList.get(i);
			
		}
		return output;
		
	}
	public static void viewCurrencyInfo(ArrayList<Currency>cList) {
		C206_CaseStudy.setHeader("List of Currencies");
		String output = String.format("%-10s %-10s %17s %11s\n", "ISO", "Name", "Buy Rate", "Sell Rate");
		for (int i  = 0; i < cList.size(); i++) {
			output += String.format(cList.get(i).toString());
			
		}
		System.out.println(output);
		
	}
	//Delete
	public static void deleteCurrencyInfo(ArrayList<Currency>cList) {
		C206_CaseStudy.viewCurrencyInfo(cList);
		String iso = Helper.readString("Enter ISO to delete > ");
		
		boolean check = true;
		int d = 0;
		
		while (d < cList.size()) {
			if (cList.get(d).getIso() == iso) {
				check = true;
				break;
				
			} 
			else {
				check = false;
		
			}
			d++;
			
		}
		if (check == true) {
			cList.remove(d);
			System.out.println("Currency Deleted.");
			
		} 
		else {
			System.out.println("Invalid Currency ISO.");
		}
	}
	

	}

