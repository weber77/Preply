package main;

public abstract class Item implements Comparable<Item> {
	private String Name;
	private double Weight;
	private double Value;
	private int Durability;
	private int ID;
	private String category;
	
	public Item() {
		
	}
	
	public Item(String Name, double Weight, double Value, int Durability, int ID, String category) {
		this.Name = Name;
		this.Weight = Weight;
		this.Value = Value;
		this.Durability = Durability;
		this.ID = ID;
		this.category = category;
	}

	
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

	public double getValue() {
		return Value;
	}

	public void setValue(double value) {
		Value = value;
	}

	public int getDurability() {
		return Durability;
	}

	public void setDurability(int durability) {
		Durability = durability;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int compareTo(Item item) {
		
		if( Value == item.getValue())
		{
			return 0;
		}
		else if( Value > item.getValue()) {
			return 1;
		}
		else
			
		return -1;
	}

	@Override
	public String toString() {
		return "Item [Name=" + Name + ", Weight=" + Weight + ", Value=" + Value + ", Durability=" + Durability
				+ ", category=" + category + "]";
	}

	
	public String formatObject() {
		return  Name + "," + Weight + "," + Value + "," + Durability+ "," + ID + "," + category;
	}

	
	
	
	
	
	
}


