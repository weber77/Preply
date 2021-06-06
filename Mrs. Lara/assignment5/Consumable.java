package main;

public class Consumable extends Item {
	private boolean isSolid;
	private boolean cannedFood;
	private boolean rawFood;
	
	public Consumable() {
		
	}
	
	
	
	public Consumable(String Name, double Weight, double Value, int Durability, int ID, String category,
			boolean isSolid, boolean cannedFood, boolean rawFood) {
		super(Name, Weight, Value, Durability, ID, category);
		this.isSolid = isSolid;
		this.cannedFood = cannedFood;
		this.rawFood = rawFood;
	}



	public boolean isSolid() {
		return isSolid;
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public boolean isCannedFood() {
		return cannedFood;
	}
	public void setCannedFood(boolean cannedFood) {
		this.cannedFood = cannedFood;
	}
	public boolean isRawFood() {
		return rawFood;
	}
	public void setRawFood(boolean rawFood) {
		this.rawFood = rawFood;
	}



	@Override
	public String toString() {
		return "Consumable [isSolid=" + isSolid + ", cannedFood=" + cannedFood + ", rawFood=" + rawFood +  super.toString() + "]";
	}
	
	public String formatObject() {
		return super.formatObject() + "," + isSolid + "," + cannedFood + "," + rawFood;
	
	}
	
	
	
}
