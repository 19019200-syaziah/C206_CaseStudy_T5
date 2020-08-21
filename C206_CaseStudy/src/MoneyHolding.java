
public class MoneyHolding {
	
	private String iso;
	private double holdingAmt;
	
	public MoneyHolding(String iso, double holdingAmt) {
		this.iso = iso;
		this.holdingAmt = holdingAmt;
	}
	
	public String getIso() {
		return iso;
	}
	public double getHoldingAmt() {
		return holdingAmt;
	}
	public String toString() {
		String output = "";
		output = String.format("%-10s %-10s %10s %10d\n", getIso(),getHoldingAmt());
		return output;
	}
	

}

	
