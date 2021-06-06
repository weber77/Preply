package main;

public class Equipment extends Item {
	private String purpose;
	private double volume;
	private boolean radiationResistant;
	
	public Equipment() {
		
	}
	
	
	
	public Equipment(String Name, double Weight, double Value, int Durability, int ID, String category, String purpose,
			double volume, boolean radiationResistant) {
		super(Name, Weight, Value, Durability, ID, category);
		this.purpose = purpose;
		this.volume = volume;
		this.radiationResistant = radiationResistant;
	}



	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public boolean isRadiationResistant() {
		return radiationResistant;
	}
	public void setRadiationResistant(boolean radiationResistant) {
		this.radiationResistant = radiationResistant;
	}



	@Override
	public String toString() {
		return "Equipment [purpose=" + purpose + ", volume=" + volume + ", radiationResistant=" + radiationResistant + super.toString()
				+ "]";
	}
	
	public String formatObject() {
		return super.formatObject() + "," + purpose + "," + volume + "," + radiationResistant;
	}
	
	
	
	
}
