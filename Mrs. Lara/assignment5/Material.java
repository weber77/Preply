package main;

public class Material extends Item{
	private String metal;
	private double freezingPoint;
	private double meltingPoint;
	
	public Material() {
		
	}
	
	

	public Material(String Name, double Weight, double Value, int Durability, int ID, String category, String metal,
			double freezingPoint, double meltingPoint) {
		super(Name, Weight, Value, Durability, ID, category);
		this.metal = metal;
		this.freezingPoint = freezingPoint;
		this.meltingPoint = meltingPoint;
	}



	public String getMetal() {
		return metal;
	}
	public void setMetal(String metal) {
		this.metal = metal;
	}
	public double getFreezingPoint() {
		return freezingPoint;
	}
	public void setFreezingPoint(double freezingPoint) {
		this.freezingPoint = freezingPoint;
	}
	public double getMeltingPoint() {
		return meltingPoint;
	}
	public void setMeltingPoint(double meltingPoint) {
		this.meltingPoint = meltingPoint;
	}



	@Override
	public String toString() {
		return "Material [metal=" + metal + ", freezingPoint=" + freezingPoint + ", meltingPoint=" + meltingPoint + ", " + super.toString()
				+ "]";
	}
	
	public String formatObject() {
		return  super.formatObject() + " ," + metal + "," + freezingPoint + ", " + meltingPoint;
	}
	
}
