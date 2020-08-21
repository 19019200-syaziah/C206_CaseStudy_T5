
public class Currency {
	
	private String iso;
	private String name;
	private int buyRate;
	private int sellRate;
	
	public Currency(String iso, String name, int buyRate, int sellRate) {
		super();
		this.iso = iso;
		this.name = name;
		this.buyRate = buyRate;
		this.sellRate = sellRate;
	}
	public String getIso() {
		return iso;
	}
	public String getName() {
		return name;
	}
	public int getBuyRate() {
		return buyRate;
	}
	public int getSellRate() {
		return sellRate;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyRate(int buyRate) {
		this.buyRate = buyRate;
	}
	public void setSellRate(int sellRate) {
		this.sellRate = sellRate;
	}
	public String  toString() {
		String output = "";
		output = String.format("%-10s %-10s %10s %10d\n", getIso(),getName(), getBuyRate(), getSellRate());
		return output;
	}

}
