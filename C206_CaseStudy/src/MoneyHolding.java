// Create by Ling Ying.
public class MoneyHolding {
	private String iso;
	private double holdingAmt;
	private double thresHold;
	
	public MoneyHolding(String iso, double holdingAmt, double thresHold) {
		this.iso = iso;
		this.holdingAmt = holdingAmt;
		this.thresHold = thresHold;
	}
	public String getIso() {
		return iso;
	}
	public double getHoldingAmt() {
		return holdingAmt;
	}
	public double getthresHold() {
		return thresHold;
	}
	public void setthresHold(double thresHold) {
		this.thresHold = thresHold;
	}
	public String toString() {
		String output = "";
		output += "Iso: " + iso + "\n";
		output += "HoldingAmt: " + holdingAmt + "\n";
		output += "ThresHold: " + thresHold + "\n";
		return output;
	} 
} 
