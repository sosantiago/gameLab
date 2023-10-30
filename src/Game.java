import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	private static boolean dead;
	
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void move(char dir) {
		Room nextRoom = currentRoom.getExit(dir);
		if (nextRoom != null) {
			if(nextRoom.isLocked()) {
				System.out.println("The room is locked.");
			} else {
				currentRoom = currentRoom.getExit(dir);
				System.out.println(currentRoom);
			}
		} else {
			System.out.println("You can't go that way.");
		}
	}
	
	public static void drop(String name) {
		Item x;
		for (int i = 0; i < inventory.size(); i++) {
			x = inventory.get(i);
			if(x.getName().equals(name)) {
				inventory.remove(i);
				return;
			}
		}
	}
	
	public static void addItem(Item x) {
		inventory.add(x);
	}
	
	public static Item getItem(String s) {
		for (Item x : inventory) {
			if (x.getName().equals(s)) {
				return x;
			}
		}
		return null;
	}
	
	public static boolean hasItem(String s) {
		for (Item x : inventory) {
			if (x.getName().equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	public static void print(String message) {
		System.out.print(message+"\n");
	}
	
	public static void print(Item message) {
		System.out.println(message+"\n");
	}
	
	public static void lose() {
		dead = true;
	}
	
	public static void main(String[] args) {
		
		currentRoom = World.buildWorld();
		
		Scanner input = new Scanner(System.in);
		String[] playerCommand;
		boolean present = false;

		
		System.out.println(currentRoom);
		
		do {
			System.out.print("What do you want to do? ");
			playerCommand = input.nextLine().split(" ");
			switch(playerCommand[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				move(playerCommand[0].charAt(0));
				break;
			case "take":
				if (currentRoom.hasItem(playerCommand[1])){
					Item item = currentRoom.getItem(playerCommand[1]);
					if (!item.isHeavy()) {
						inventory.add(currentRoom.removeItem(playerCommand[1]));
						print("You took the " + playerCommand[1] + ".");
					} else {
						print(item + " is too heavy!");
					}
				} else {
					print("There is no " + playerCommand[1] + "!");
				}
				break;
			case "i":
				print("You are currently holding:");
				if(inventory.isEmpty()) {
					print("You are holding nothing");
				} else {
					for (Item i : inventory) {
						print(i);
					}
				}
				break;
			case "look":
				if (hasItem(playerCommand[1])) {
					getItem(playerCommand[1]).look();
					present = true;
				}
				if (currentRoom.hasItem(playerCommand[1])) {
					currentRoom.getItem(playerCommand[1]).look();
					present = true;
				}
				if (!present) {
					print("You don't have " + playerCommand[1] + "!");
					}
					present = false;
				break;
			case "use":
				if (hasItem(playerCommand[1])) {
					getItem(playerCommand[1]).use();
					present = true;
				}
				if (currentRoom.hasItem(playerCommand[1])) {
					currentRoom.getItem(playerCommand[1]).use();
					present = true;
				}
				if (!present) {
					print("You don't have " + playerCommand[1] + "!");
				}
				present = false;
				break;
			case "code":
				if (playerCommand[1].equals("00001")) {
					inventory.add(new DevKey());
				}
				break;
			case "x":
				lose();
				print("GAME OVER.");
				break;
			default:
				print("This command is invalid.");
				break;
			}

		} while(!dead);
		
		input.close();
		
	}

}
