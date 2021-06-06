package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;


public class Assignment05Driver {

       Scanner input = new Scanner(System.in);
       public static int IdCount = 0;
       static ArrayList<Item> cargohold = new ArrayList<>();
       static double[] weight = new double[100];
 
       public static void main(String[] args) {
    	   		readFile();

              new Assignment05Driver();
       }
       
       // This will act as our program switchboard
       public Assignment05Driver() {

              System.out.println("Welcome to the BlackStar Cargo Hold interface.");

              System.out.println("Please select a number from the options below");

              System.out.println("");

              while (true) {

                     // Give the user a list of their options

                     System.out.println("1: Add an item to the cargo hold.");

                     System.out.println("2: Remove an item from the cargo hold.");

                     System.out.println("3: Sort the contents of the cargo hold.");

                     System.out.println("4: Search for an item.");

                     System.out.println("5: Display the items in the cargo hold.");

                     System.out.println("0: Exit the BlackStar Cargo Hold interface.");

 
                     // Get the user input
                     int userChoice = input.nextInt();

                     input.nextLine();

                     switch (userChoice) {

                     case 1:
                           addItem();
                           break;

                     case 2:
                    	   removeItemByName();
                           break;

                     case 3:
                           sortItems();
                           break;

                     case 4:
                    	   searchItemByName();
                            break;

                     case 5:
                           displayItems(cargohold);
                           break;
                    

                     case 0:
                           System.out.println("Thank you for using the BlackStar Cargo Hold interface. See you again soon!");
                           storeItems();

                           System.exit(0);

                     }

              }

 

       }

       private void addItem() {

    	   
    	  
           // TODO: Add an item that is specified by the user
    	   IdCount++;
	    	   
    
	 	   try {
	 		  System.out.println("Enter an item name.");
		 	  String itemname = input.nextLine();
		 	   
		 	  System.out.println("Enter the category of an item (Equipment, Consumable or Material).");
		 	  String itemCategory = "";
		 	   
		 	  while(true) {
		 		 
			 	   itemCategory = input.nextLine().toLowerCase();
			 	   if(itemCategory.equals("equipment") || itemCategory.equals("consumable") || itemCategory.equals("material")) {
			 		   break;
			 	   }
			 	   System.out.println("Category must : Equipment, Consumable or Material");
		 	   }
		 	   
		 	   System.out.println("Enter the weight of the item in tons.");
		 	   double itemweight = input.nextDouble();
		 	   
		 	   System.out.println("Enter the value of the item.");
		 	   double itemvalue = input.nextDouble();
		 	   
		 	   System.out.println("Enter the durability of the item.");
		 	   int itemdurability = input.nextInt();
	 	   
	 	   
	 	   Equipment addedEquipment = null;
	 	   Consumable addedConsumable = null;
	 	   Material addedMaterial = null;
	 	   
	 	   
	 	   if(itemCategory.equals("equipment")) {
	 		   System.out.println("Is the equipmnent radiationResistant?");
	 		   boolean radiationResistant = input.nextBoolean();
	 		   
	 		   input.nextLine();
	 		   System.out.println("What's the equipments purpose?");
	 		   String purpose = input.nextLine();
	 		   
	 		   System.out.println("What's the equipments volume?");
	 		   double volume = input.nextDouble();
	 		   
	 		   addedEquipment  = new Equipment(itemname, itemweight, itemvalue, itemdurability, IdCount, itemCategory, purpose, volume, radiationResistant);
	 		   
	 	   }
	 	   else if(itemCategory.equals("consumable")) {
	 		   System.out.println("Is the consumable solid?");
	 		   boolean isSolid = input.nextBoolean();
	 		   
	 		   System.out.println("Is the consumable canned?");
	 		   boolean cannedFood = input.nextBoolean();
	 		   
	 		   System.out.println("Is the consumable raw?");
	 		   boolean rawFood = input.nextBoolean();
	 		   
	 		   addedConsumable  = new Consumable(itemname, itemweight, itemvalue, itemdurability, IdCount, itemCategory, isSolid, cannedFood, rawFood);
	 	   }
	 	   else if(itemCategory.equals("material")) {
	 		   
	 		   input.nextLine();
	 		   System.out.println("Is the material metal?");
	 		   String metal = input.nextLine();
	 		   
	 		   System.out.println("What's the materials freezing point?");
	 		   double freezingPoint = input.nextDouble();
	 		   
	 		   System.out.println("What's the materials melting point?");
	 		   double meltingPoint = input.nextDouble();
	 		   
	 		   addedMaterial = new Material(itemname, itemweight, itemvalue, itemdurability, IdCount, itemCategory, metal, freezingPoint, meltingPoint);
	 	   }
	 	   else {
	 		   System.out.println("The category doesn't exist.");
	 		   return;
	 	   }

			   if (cargohold.size() < 100) {
				   if (itemCategory.equals("equipment") && !checkWeight(itemweight)) {
					   cargohold.add(addedEquipment);
					   return;
				   }
				   else if (itemCategory.equals("material")&& !checkWeight(itemweight) ) {
					   cargohold.add(addedMaterial);
					   return;
				   }
				   else if (itemCategory.equals("consumable")  && !checkWeight(itemweight)) {
					   cargohold.add(addedEquipment);
					   return;
				   }
			   }

	 		   System.out.println("The cargohold is full.");
	 		   
	 	  }catch(InputMismatchException e) {
	 		   System.out.println("input the right data: " + e);
	 		   input.nextLine();

	 	   }

    }
        
    private void removeItemByName() {

           // TODO: Remove an item that is specified by the user
 	   System.out.println("Below are the items and their quantities.\nEnter the name of the item you want to remove.");
 	   
 	   displayItems(cargohold);
 	   
 	   System.out.println("Which item will you like to delete?");
 	   
 	   String userchoice = input.nextLine();
 	   
 	   for(int i = 0; i < cargohold.size(); i++)
 	   {
 		   if(cargohold.get(i).getName().equals(userchoice)) {
 			   cargohold.remove(i);
 		   }
 	   }

    }

    private void sortItems() {


		Collections.sort(cargohold);


    }

    private void searchItemByName() {

           // TODO: Search for a user specified item
 	   	//USing Linear search
 	   ArrayList<Item> foundItems = new ArrayList<>();
 	   boolean found = false;
 	   System.out.println("Enter the name of the item you're searching for: ");
 	   String userItem = input.nextLine();
 	   
 	   for( int i = 0; i < cargohold.size(); i++)
 	   {
 		   if(cargohold.get(i).getName().compareToIgnoreCase(userItem) == 0)
 		   {
 			   //System.out.println(userItem + " is at index: " + i);
 			  for(int j = 0; j < foundItems.size(); j++)
 		 	   {
 		 	   		found = true;
 		 	   		foundItems.add(cargohold.get(i));
 		 	   		break;

 		 	   }
 		   }
 	   }
 	   
 	  if(!found) {
	 	   System.out.println("item not found!");
	 	   return;
	   }
 	   
 	   System.out.println("The following items have the name you inputted:");
 	   displayItems(foundItems);
 	   
 	   System.out.println("Do you want to search the above found items by attribute? (y or n?)");
 	   char answer = input.next().charAt(0);
 	   
 	   if(answer == 'y') {
 		 
 		   searchAttribute(foundItems);
 		   return;
 	   }
 	   
 	   


    }
    
    public void searchAttribute(ArrayList<Item> items) {
	 	input.nextLine();
	 	boolean found = false;

    	
    	 if(items.get(0).getCategory().equals("equipment")) {
    		 	input.nextLine();
    		 
    		 	System.out.println("What attributes are you searching for? (radiationResistant, purpose, volume)");	
    	    	String attribute = input.nextLine();
	 		   
    	    	if(attribute.equals("radiationResistant")) {
    	    		
    	    		System.out.println("it is radiation resistant true or false?");
    	    		boolean userchoice = input.nextBoolean();
    	    		
    	    		
    	    		for(int i=0; i<items.size(); i++) {
    	    			if(userchoice ==  ((Equipment) items.get(i)).isRadiationResistant()) {
    	    				System.out.println("Item found: ");
    	    				System.out.println(items.get(i).toString());
    	    				 found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
    	    		
    	    	}
    	    	else if(attribute.equals("purpose")) {
    	    		System.out.println("Enter the purpose:");
    	    		String userchoice = input.nextLine();
    	    		
    	    		
    	    		for(int i=0; i<items.size(); i++) {
    	    			if(userchoice.equals(((Equipment) items.get(i)).getPurpose())) {
    	    				System.out.println("Item found: ");
    	    				System.out.println(items.get(i).toString());
    	    				 found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
    	    	}
    	    	else if(attribute.equals("volume")) {
    	    		System.out.println("Enter the volume:");
    	    		double userchoice = input.nextDouble();
    	    		
    	    		
    	    		for(int i=0; i<items.size(); i++) {
    	    			if(userchoice ==  ((Equipment) items.get(i)).getVolume()) {
    	    				System.out.println("Item found: ");
    	    				System.out.println(items.get(i).toString());
    	    				 found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
    	    	}
    	    	else {
    	    		System.out.println("Attribute not found!");
    	    		return;
    	    	}
	 		   	 		   
	 	   }
	 	   else if(items.get(0).getCategory().equals("consumable")) {
	 		  
	 		   System.out.println("What attributes are you searching for? (isSolid, cannedFood, rawFood)");	
	 		   String attribute = input.nextLine();
		 		   
	  	    	if(attribute.equals("isSolid")) {
	  	    		
	  	    		System.out.println("It is a solid food. True or false?");
	  	    		boolean userchoice = input.nextBoolean();
	  	    		
	  	    		
	  	    		for(int i=0; i<items.size(); i++) {
	  	    			if(userchoice ==  ((Consumable) items.get(i)).isSolid()) {
	  	    				System.out.println("Item found: ");
	  	    				System.out.println(items.get(i).toString());
	  	    				found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
	  	    		
	  	    	}
	  	    	else if(attribute.equals("cannedFood")) {
	  	    		System.out.println("It is canned food. True or false?");
	  	    		boolean userchoice = input.nextBoolean();
	  	    		
	  	    		
	  	    		for(int i=0; i<items.size(); i++) {
	  	    			if(userchoice ==  ((Consumable) items.get(i)).isCannedFood()) {
	  	    				System.out.println("Item found: ");
	  	    				System.out.println(items.get(i).toString());
	  	    				found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
	  	    	}
	  	    	else if(attribute.equals("rawFood")) {
	  	    		System.out.println("It is raw food. True or false?");
	  	    		boolean userchoice = input.nextBoolean();
	  	    		
	  	    		
	  	    		for(int i=0; i<items.size(); i++) {
	  	    			if(userchoice ==  ((Consumable) items.get(i)).isRawFood()) {
	  	    				System.out.println("Item found: ");
	  	    				System.out.println(items.get(i).toString());
	  	    				found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
	  	    	}
	  	    	else {
	  	    		System.out.println("Attribute not found!");
	  	    		return;
	  	    	}
	 	   }
	 	  else if(items.get(0).getCategory().equals("material")) {
	 		   System.out.println("What attributes are you searching for? (metal, freezingPoint, meltingPoint)");	
	 		   String attribute = input.nextLine();
		 		   
	  	    	if(attribute.equals("metal")) {
	  	    		
	  	    		System.out.println("It's metal true or false?.");
	  	    		String userchoice = input.nextLine();
	  	    		
	  	    		
	  	    		for(int i=0; i<items.size(); i++) {
	  	    			if(userchoice.equals(((Material) items.get(i)).getMetal())) {
	  	    				System.out.println("Item found: ");
	  	    				System.out.println(items.get(i).toString());
	  	    				found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
	  	    		
	  	    	}
	  	    	else if(attribute.equals("freezingPoint")) {
	  	    		System.out.println("Enter the freezing point: ");
	  	    		double userchoice = input.nextDouble();
	  	    		
	  	    		
	  	    		for(int i=0; i<items.size(); i++) {
	  	    			if(userchoice ==  ((Material) items.get(i)).getFreezingPoint()) {
	  	    				System.out.println("Item found: ");
	  	    				System.out.println(items.get(i).toString());
	  	    				found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
	  	    	}
	  	    	else if(attribute.equals("meltingPoint")) {
	  	    		System.out.println("Enter the melting point: ");
	  	    		double userchoice = input.nextDouble();
	  	    		
	  	    		
	  	    		for(int i=0; i<items.size(); i++) {
	  	    			if(userchoice ==  ((Material) items.get(i)).getMeltingPoint()) {
	  	    				System.out.println("Item found: ");
	  	    				System.out.println(items.get(i).toString());
	  	    				found = true;
    	    			}
    	    		}
    	    		if(!found) {
    	    			System.out.println("Item with that attribute not found!\n");
    	    		}
	  	    	}
	  	    	else {
	  	    		System.out.println("Attribute not found!");
	  	    		return;
	  	    	}
	 	   }
    }
    
    private void displayItems(ArrayList<Item> cargohold) {

          
 	   
 	   ArrayList<ItemQty> items = new ArrayList<>(); // list to contain item names and respective quantities
 	   boolean itemFound = false; // used to check if item already exists in items list
 	   
 	   

 	   
 	   for(int i = 0; i < cargohold.size(); i++) { // loops through the cargohold

 		   for(int j = 0; j < items.size(); j++) { // loops through the items list

 			   if(cargohold.get(i).getName().compareToIgnoreCase(items.get(j).getItem().getName()) == 0 )

 			   { //
 				   items.get(j).setQuantity(1);
 				   itemFound = true;

 			   }

     	   }
 		   
 		   if(!itemFound)
 		   {

 		   		items.add(new ItemQty(cargohold.get(i), 1));
			   	itemFound = false;

 		   }
 		   
 		   itemFound = false;
 	   }

		System.out.println("found item size: " + cargohold.size());
 	   for(int i = 0 ; i < items.size() ; i++) {
 		   if( items.get(i).getItem() != null ) {
 			   System.out.println(items.get(i).getItem().getName() +" - "+ items.get(i).getQuantity());
 			   
 			   for(int j = 0; j< cargohold.size(); j++) {
 				   if(items.get(i).getItem().getName().equals(cargohold.get(j).getName())) {
 					  System.out.println("\t" + cargohold.get(j).toString());
 				   }
 			   }
 		   }
 		   else
 			   return;
 	   }
       }

 
	   private static boolean checkWeight(double itemweight) {
    	
    	double sumOfWeight = 0;
    	for(int i = 0; i < weight.length; i++) {
    		
    			sumOfWeight = sumOfWeight + weight[i];
    	}
    	if(sumOfWeight + itemweight > 25)
    		return true;
    	else 
    		return false;
    	
    }
    		
    class ItemQty
    {
	  private Item item;
	  private int Quantity;
	  private Item[] items = new Item[100];
	  
		ItemQty(Item item, int Quantity)
		{
			this.item = item;
			this.Quantity =Quantity;
		}
	  
		public ItemQty(Item item, int quantity, Item[] items) {
			this.item = item;
			Quantity = quantity;
			this.items = items;
		}

		public void addItems(Item item) {
			for(int i = 0; i < items.length; i++) {
				if(items[i] != null) {
					items[i] = item;
				}
			}
		}
		
		
		public int getQuantity() {
			return Quantity;
		}

		public void setQuantity(int qty) {
			Quantity += qty;
		}

		public Item getItem() {
			return item;
		}
	   
    }
    
	public void storeItems() {
		try {
			File outFile = new File("items.txt");
			FileOutputStream fos = new FileOutputStream(outFile);
			PrintWriter pw = new PrintWriter(fos);
					
			for(int i=0; i< cargohold.size(); i++) {
				pw.println(cargohold.get(i).formatObject());
			}
					
			pw.close();
					
		} catch (FileNotFoundException e) {
					System.out.println("Error Writing to File");
		}
	}
	
    public static void readLoot() {



    	try {
			Scanner fileInput = new Scanner(new File("loot.txt"));
			while(fileInput.hasNextLine()) {
				
				
				String[] words = fileInput.nextLine().split(", ");
				
				if(words[0].compareToIgnoreCase("consumable") == 0) {
					System.out.println("working...");
					Consumable c = new Consumable(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]),
													words[0], false, false, false);
					
					if(!checkWeight(c.getWeight())) {
							cargohold.add(c);
					}
					
				}
				else if(words[0].compareToIgnoreCase("material") == 0) {
					Material m = new Material(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]),
												words[0], words[6], Double.parseDouble(words[7]), Double.parseDouble(words[8]));

							if(!checkWeight( m.getWeight())) {
								cargohold.add(m);
							}
					
				}else if(words[0].compareToIgnoreCase("equipment") == 0) {
					Equipment e = new Equipment(words[1], Double.parseDouble(words[2]), Double.parseDouble(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]),
												words[0], words[6] , Double.parseDouble(words[7]), false);

					if(!checkWeight(e.getWeight())) {
						cargohold.add(e);
					}
				}
			
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

    public static void readFile() {



    	try {
			Scanner fileInput = new Scanner(new File("items.txt"));
			while(fileInput.hasNextLine()) {
				String[] words = fileInput.nextLine().split(",");
				
				if(words[5].compareToIgnoreCase("consumable") == 0) {
					Consumable c = new Consumable(words[0], Double.parseDouble(words[1]), Double.parseDouble(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]),
													words[5], Boolean.parseBoolean(words[6]), Boolean.parseBoolean(words[7]), Boolean.parseBoolean(words[8]));
					
					if(!checkWeight(c.getWeight())) {
							cargohold.add(c);
					}
					
				}
				else if(words[5].compareToIgnoreCase("material") == 0) {
					Material m = new Material(words[0], Double.parseDouble(words[1]), Double.parseDouble(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]),
												words[5], words[6], Double.parseDouble(words[7]), Double.parseDouble(words[8]));

							if(!checkWeight( m.getWeight())) {
								cargohold.add(m);
							}
					
				}else if(words[5].compareToIgnoreCase("equipment") == 0) {
					Equipment e = new Equipment(words[0], Double.parseDouble(words[1]), Double.parseDouble(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]),
												words[5], words[6] , Double.parseDouble(words[7]), Boolean.parseBoolean(words[8]));

					if(!checkWeight(e.getWeight())) {
						cargohold.add(e);
					}
				}
			
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found - exiting");
		}
    	
    	readLoot();
	}

	public static double loot(ArrayList<Item> loot) {
		
		ArrayList<int> valueSum = new ArrayList<>();
		double weight = 0;
		double value = 0;
		
		Collections.sort(loot);
		
		if ( loot.size() == 0) {
			return 0;
		}
		
		for(int i=0; i < loot.size(); i++){
			if( value <25 ){
				weight += loot.get(i).getWeight();
				value 

			}
		}
		return 0.0;
	}
}


