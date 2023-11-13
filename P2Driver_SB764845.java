/* ICSI 201 -Introduction to Computer Science
 * Fall 2023
 * CSI 201- 8878
 * Samantha Bosch
 * SB764845
 * sbosch@albany.edu
 * 
 * This project will ask the user to choose a number from the prompted menu and return their choice by calling methods used in a class.
 * 
 * The program was tested with
 * <1 7 0>
 * <Hammer hammer pencil>
*/
import java.io.IOException;
import java.util.Scanner;

public class P2Driver_SB764845 {
	
	public static void main(String[] args)throws IOException {
		
		Item_SB764845[] inventory = Item_SB764845.readInventoryFromFile("Items.txt"); // Created an object from the Item class
		int itemCount = Item_SB764845.countItems(inventory); // the data from the text file
	    boolean exit = false; 
		Scanner keyboard = new Scanner(System.in); // scanner to get user input
		int choice; 
		 
		while(!exit) { //while loop to repeat menu options until user decides to quit
			printMenu();
			choice = keyboard.nextInt();
		 
		
			switch(choice) {
			case 1:
			 		Item_SB764845.showInventory(inventory, itemCount);
			 		break;
			case 2:
			 		double totalValue = Item_SB764845.calculateInventoryValue(inventory, itemCount);
			 		System.out.printf("The total value of the inventory is $%.2f\n", totalValue);
			 		System.out.println("");
			 		break;
			case 3:
				 Item_SB764845.sortInventoryByPrice(inventory, itemCount);
		 		 Item_SB764845.showInventory(inventory, itemCount);
			 		break;
			case 4:
			 		 Item_SB764845.sortInventoryByName(inventory, itemCount);
			 		 Item_SB764845.showInventory(inventory, itemCount);
			 		break;
			case 5:
			 		keyboard.nextLine();  // Consume the newline character
			 		System.out.print("Enter the name of the item to search: ");
			 		String nameOfItem = keyboard.nextLine();
			 		Item_SB764845 foundItem = Item_SB764845.findItem(inventory, itemCount, nameOfItem);
             		if (foundItem != null) {
             			System.out.println(foundItem);
             		} else 
             			System.out.println("Item not found.");
             		break;
			case 6:
				exit = true;
				break;
			default:
				System.out.println("Invalid number.");
				break;
			}
		 
	 
		}
			keyboard.close();
	
}
	// Method used to create menu
	public static void printMenu()
		{
			System.out.println( "1. Show the inventory.\n"
				  + "2. Calculate the value of the inventory\n"
				  + "3. Sort the inventory by price.\n"
				  + "4. Sort the inventory by name.\n"
				  + "5. Find an item.\n" 
				  + "6. Quit" );
		}
	
	





}
