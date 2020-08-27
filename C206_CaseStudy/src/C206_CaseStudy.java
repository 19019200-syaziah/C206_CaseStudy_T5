import java.util.ArrayList;
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList <MoneyHolding> MHList = new ArrayList <MoneyHolding>();
		ArrayList<Transaction>TList = new ArrayList <Transaction>();
		TList.add(new Transaction("21/8/2020","sell","KRW",500,"SGD",436700,873.4));
		TList.add(new Transaction("20/8/2020","buy","SGD",700,"MYR",2147.18,3.0674));
		TList.add(new Transaction("19/8/2020","sell","THB",100,"SGD",2275,22.75));
		TList.add(new Transaction("18/8/2020","buy","SGD",1000,"JPY",77519.3,77.5193));
		int option = 0;
		
		while (option != 5) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				MoneyHolding mh =  inputMoneyHolding();
				C206_CaseStudy.addMoneyHolding(MHList, mh);
				
			} 
			else if(option == 2) {
				if (MHList.isEmpty()) {
					System.out.println("List is empty.");
					
				} 
				else {
					C206_CaseStudy.viewAllMoneyHolding(MHList);
					
				}
					
			}
			else if (option == 3) {
				if (MHList.isEmpty()) {
					System.out.println("List is empty.");
						
				}
				else {
					C206_CaseStudy.deleteMoneyHolding(MHList, TList);
					
				}
						
			}
			else if (option == 4) {
				if (MHList.isEmpty()) {
					System.out.println("List is empty.");
						
				}
				else {
					C206_CaseStudy.UpdateMoneyHolding(MHList);
				}
			}
			
			else if (option == 5) {
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
		System.out.println("1. Add MoneyHolding");
		System.out.println("2. View MoneyHolding");
		System.out.println("3. Delete MoneyHolding");
		System.out.println("4. Update MoneyHolding");
		
		System.out.println("5. Quit");
		Helper.line(80, "-");
		
	}
	


	//Moneyholding input
	public static MoneyHolding inputMoneyHolding() {
		String iso = Helper.readString("Enter ISO > ");
		Double holdingAmt = Helper.readDouble("Enter holding amount > ");
		Double threshold = Helper.readDouble("Enter threshold > ");
		MoneyHolding mh = new MoneyHolding(iso, holdingAmt, threshold);
		return mh;
	}
	//Add money holding
	public static void addMoneyHolding(ArrayList<MoneyHolding>MHList, MoneyHolding mh) {
		MHList.add(mh);
		System.out.println("MoneyHolding added!");
	}
	
	
	//RetrieveAllMoneyHolding
	public static String retrieveAllMoneyHolding(ArrayList<MoneyHolding>MHList) {
		String output = "";
		for(int i = 0; i < MHList.size(); i++) {
			output += String.format("%-10s %-30s\n", MHList.get(i).toString());
			
		}
		return output;
	}
	//View money holding
	public static void viewAllMoneyHolding(ArrayList<MoneyHolding>MHList) {
		C206_CaseStudy.setHeader("LIST OF MONEYHOLDINGS");
		String output = String.format("%-10s %-20s %-20s \n", "ISO","HOLDING AMOUNT","THRESHOLD");
		for (int i  = 0; i < MHList.size(); i++) {
			output += String.format(MHList.get(i).toString());
			
		}
		System.out.println(output);
	}
    //Delete money holding
	public static void deleteMoneyHolding(ArrayList<MoneyHolding>MHList, ArrayList<Transaction>TList) {
		C206_CaseStudy.viewAllMoneyHolding(MHList);
		String iso = Helper.readString("Enter ISO to delete > ");
		
		boolean check = true;
		
		int i = 0;
		int delete = 0;
		while (i < MHList.size()) {
			if (MHList.get(i).getIso().equals(iso)) {
				String test = MHList.get(i).getIso();
				for (int a = 0; a < MHList.size(); a++) {
					if (test == TList.get(i).getCcyIn() || test == TList.get(i).getCcyOut()) {
						check = false;
					}
					else {
						check = true;
						delete = i;
						break;
					}
				}
				
			} 
			else {
				check = false;
		
			}
			i++;
			
		}
		if (check == true) {
			MHList.remove(delete);
			System.out.println("Moneyholding deleted");
		}
		else{
			System.out.println("Invalid ISO");
		}

	}
	//Update MoneyHolding
	public static void UpdateMoneyHolding(ArrayList<MoneyHolding>MHList) {
		String iso = Helper.readString("Enter the MoneyHolding iso to update > ");
		for (int i = 0; i < MHList.size(); i++) {
			if(MHList.get(i).getIso().equals(iso)) {
				Double MoneyHolding = Helper.readDouble("Enter MoneyHolding > ");
				MHList.get(i).setIso(MoneyHolding);
			}
	}
}
	
	
}
		
			
			
				



	
