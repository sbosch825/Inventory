import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Item_SB764845 {

 	private String name; // name of item
	private double price; // item price
	private int amount; // item quantity
	
	
	 
	public Item_SB764845(String name, double price, int amount)
	   {
	      this.name = name;		
	      this.price = price; 	
	      this.amount = amount;
	   }
	
	
	/**
     *  The getName returns the name of the item.
     * 
     *
     * @return The name of the item.
     */
	
	public String getName() {
		
		return name;
	}
	
	/**
     *  The getPrice returns the price of the item.
     *
     * @return The price of the item.
     */
	
	public double getPrice() {
		
		return price;
	}
	
	/**
     *  The getAmount returns the quantity of the item.
     * 
     *
     * @return The quantity of the item.
     */
	
	public int getAmount() {
		
		return amount;
	}
	
	/**
     *  The toString returns the String of each item.
     * 
     * @param None
     *
     * @return The format in strings.
     */
	public String toString() {
		 return "Name: " + name + " Price: " + price + " Amount: " + amount;
    }
	
	/**
     *  The getName returns the name of the item.
     * 
     *@param fileName
     *
     *
     * @return The data from the text file
     */
	public static Item_SB764845[] readInventoryFromFile(String fileName) {
       
		 Item_SB764845[] inventory = new Item_SB764845[100]; // Array to store inventory items
		    int itemCount = 0; // Actual number of inventory items

		    try {	//method to read data from text file
		        File file = new File(fileName); 
		        Scanner scanner = new Scanner(file);

		        while (scanner.hasNextLine() && itemCount < 100) {
		            String line = scanner.nextLine();
		            String[] parts = line.split(",\\s+"); // Splits the line using the comma found in the data file

		            if (parts.length == 3) {
		                String name = parts[0];
		                double price = Double.parseDouble(parts[1]);
		                int amount = Integer.parseInt(parts[2]);
		                Item_SB764845 item = new Item_SB764845(name, price, amount);
		                inventory[itemCount] = item;
		                itemCount++;
		            }
		        }

		        scanner.close();
		    	} catch (FileNotFoundException e) {
		    			e.printStackTrace();
		    		}

		    return inventory;
		
    }//end of readInventoryFromFile
	
	/**
	     *  The showInventory outputs the text file.
	     * 
	     * @param inventory
	     *            The array of the inventory of the text file
	     * @param itemCount
	     * 			  The number of items in the inventory
	     *
	     * @return None
	     */
	   public static void showInventory(Item_SB764845[] inventory, int itemCount) {
		  
	        for (int i = 0; i < itemCount; i++) {  // for loop to output data from text file
	            System.out.println(inventory[i] + "\n");
	        }
	        
	   }//end of showInventory
	        
	        
	   /**
	     *  The countItems counts the number of items in the text file.
	     * 
	     * @param inventory
	     *            The array of the inventory of the text file
	     * 
	     * @return The number of items
	     */
	   public static int countItems(Item_SB764845[] inventory) {
			 int count = 0;
		        for (Item_SB764845 item : inventory) {
		            if (item != null) {
		                count++;
		            }
		        }
		        return count;
	    }//end of countItems
	   
	   /**
	     *  The calculateInventoryValue outputs the text file.
	     * 
	     * @param inventory
	     *            The array of the inventory of the text file
	     * @param itemCount
	     * 			  The number of items in the inventory
	     * 
	     * @return 
	     */
	   public static double calculateInventoryValue(Item_SB764845[] inventory, int itemCount) {
	        double totalValue = 0.0;
	        for (int i = 0; i < itemCount; i++) {
	            totalValue += inventory[i].getPrice() * inventory[i].getAmount();
	        }
	        return totalValue;
	    }// end of calculateInventoryValue
	
	   
	   /**
	     *  The sortInventoryByPrice rearranges the inventory from lowest to highest price.
	     * 
	     * @param inventory
	     *            The array of the inventory of the text file
	     * @param itemCount
	     * 			  The number of items in the inventory
	     *
	     * @return None
	     */
	   public static void sortInventoryByPrice(Item_SB764845[] inventory, int itemCount) {
	        // Implement a simple sorting algorithm, e.g., bubble sort, to sort by price
		   for (int i = 0; i < itemCount - 1; i++) {
		        for (int j = 0; j < itemCount - i - 1; j++) {
		            if (inventory[j].getPrice() > inventory[j + 1].getPrice()) { // Changed the comparison to sort from lowest to highest
		                // Swap items
		                Item_SB764845 temp = inventory[j];
		                inventory[j] = inventory[j + 1];
		                inventory[j + 1] = temp;
		            }
		        }
		    }
	        
	    }//end of sortInventoryByPrice
	   
	   /**
	     *  The sortInventoryByPrice rearranges the inventory from alphabetically.
	     * 
	     * @param inventory
	     *            The array of the inventory of the text file
	     * @param itemCount
	     * 			  The number of items in the inventory
	     *
	     * @return None
	     */
	   public static void sortInventoryByName(Item_SB764845[] inventory, int itemCount) {
		   for (int i = 1; i < itemCount; i++) {
	            Item_SB764845 list = inventory[i];
	            int j = i - 1;
	            while (j >= 0 && inventory[j].getName().compareTo(list.getName()) > 0) {
	                inventory[j + 1] = inventory[j];
	                j = j - 1;
	            }
	            inventory[j + 1] = list;
	        }
	    }// end of sortInventoryByName

	   /**
	     *  The findItemByName binary searches the text file for the matching name of the user input, case-sensitive.
	     * 
	     * @param inventory
	     *            The array of the inventory of the text file
	     * @param itemCount
	     * 			  The number of items in the inventory
	     *@param name
	     *			The name of the item inputted by the user
	     *
	     * @return Null
	     */
	   public static Item_SB764845 findItem(Item_SB764845[] inventory, int itemCount, String name) { //uses binary search to return info of desired item
	        int left = 0;
	        int right = itemCount - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            int compare = inventory[mid].getName().compareTo(name);
	            if (compare == 0) {
	                return inventory[mid]; // Found the item
	            }
	            if (compare < 0) {
	                left = mid + 1; // Item may be in the right half
	            } else {
	                right = mid - 1; // Item may be in the left half
	            }
	        }
	        return null; // Item not found
	    } // end of findItemByName
	
	   
	   
}// end of class
    
	
	
	

