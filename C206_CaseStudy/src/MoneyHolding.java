
public class MoneyHolding {
	
	private String iso;
	private double holdingAmt;
	private double threshold;
	
	public MoneyHolding(String iso, double holdingAmt, double threshold) {
		this.iso = iso;
		this.holdingAmt = holdingAmt;
		this.threshold = threshold;
	}
	
	public String getIso() {
		return iso;
	}
	public double getHoldingAmt() {
		return holdingAmt;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public void setIso(Double holdingAmt) {
		this.holdingAmt = holdingAmt;
	}
	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}
	public String toString() {
		String output = "";
		output = String.format("%-10s %-20.2f %-20.2f\n", getIso(),getHoldingAmt(),getThreshold());
		return output;
	}
	

}

	
