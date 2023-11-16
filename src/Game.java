
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Game {

	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	private static HashMap<String, String> roomDescs = new HashMap<String, String>();
	private static boolean dead;
	private static HashMap<String, Room> roomsMap = new HashMap<String, Room>();
	public static Scanner input = new Scanner(System.in);
	
	/*
	 * Populates roomDescs HashMap with room descriptions and their associated keys.
	 */
	public static void popDescs() {
		Scanner scan;
		try {
			scan = new Scanner(new File("rooms.txt"));
			while(scan.hasNextLine()) {
				String key = scan.nextLine();
				String desc = scan.nextLine();
				roomDescs.put(key, desc);
				scan.nextLine();
			}
		} catch (FileNotFoundException e) {
			print("You forgot a # in rooms.txt numbnuts.");
		}
	}
	
	public static Room getOtherRoom(String key) {
		return roomsMap.get(key);
	}
	
	public static void changeRoomId(String key, String id) {
		roomsMap.get(key).setID(id);
	}
	
	public static void addRoom(String n, Room r) {
		roomsMap.put(n, r);
	}
	
	public static String getRoomDesc(String id) {
		return roomDescs.get(id);
	}
	
	public static void saveGame() {
		File saveFile = new File("save");
		try {
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(roomsMap);
			stream.close();
			print("Game saved successfully.");
		} catch (IOException e) {
			print("Whoops! Save file could not be saved.");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void loadGame() throws IOException, ClassNotFoundException {
		try {
			@SuppressWarnings("resource")
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream("save"));
			currentRoom = (Room) stream.readObject();
			inventory = (ArrayList<Item>) stream.readObject();
			roomsMap = (HashMap<String, Room>) stream.readObject();
			print("File loaded successfully"); print(currentRoom);
		} catch (FileNotFoundException e) {
			print("Whoops! Save file could not be loaded.");
		}
	}
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void teleport(String s) {
		currentRoom = roomsMap.get(s);
		Game.print(currentRoom);
	}
	
	/*
	 * How you, as a character, move around.
	 */
	public static void move(char dir) {
		if (currentRoom.getName().equals("mudPuddle")) {
			currentRoom.setId("MUD_PUDDLE2");
		} else if (currentRoom.getName().equals("jungle")) {
			currentRoom.setLocked(true, "If you try to go back down, you will plummet to your death. Perhaps you possess a large, parachute like item that could allow you to go down easier?");
		}
		Room nextRoom = currentRoom.getExit(dir);
		if (nextRoom != null) {
			if(nextRoom.isLocked()) {
				nextRoom.wasLocked();
			} else {
				currentRoom = currentRoom.getExit(dir);
				print(currentRoom);
			}
		} else {
			print("You can't go that way.");
		}
	}
	
	public static void drop(String name) {
		for (Item i : inventory) {
			if(i.getName().equals(name)) {
				currentRoom.addItem(i);
				inventory.remove(i);
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
	
	public static void bringNPC(String name) {
		Character temp = null;
		for (Room r : roomsMap.values()) {
			if (r.getNPC(name).getName().equals(name)) { //Redundant but I see no need to fix it
				temp=r.getNPC(name);
			}
		}
		Game.currentRoom.addNPC(temp);
	}
	
	public static void print(String message) {
		System.out.print(message+"\n");
	}
	
	public static void print(Item message) {
		System.out.println(message+"\n");
	}
	
	public static void print(Room message) {
		System.out.println(message+"\n");
	}
	
	public static void die() {
		dead = true;
		print("GAME OVER.");
	}
	
	/*
	 * MAIN METHOD:
	 * 
	 * WHERE THE MAGIC HAPPENS.
	 */
	public static void main(String[] args) {
		
		currentRoom = World.buildWorld();
		
		popDescs();
		String[] playerCommand;
		boolean present = false;

		
		print(currentRoom);
		
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
				if (playerCommand.length==2) {
					if (currentRoom.hasItem(playerCommand[1])){
						Item item = currentRoom.getItem(playerCommand[1]);
							item.take();
					} else {
						print("There is no " + playerCommand[1] + "!");
					}
				} else
					print("You violently grasped at the air. You took nothing.");
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
				if (playerCommand.length==2) {
					if (hasItem(playerCommand[1])) {
						getItem(playerCommand[1]).look();
						present = true;
					}
					if (currentRoom.hasItem(playerCommand[1])) {
						currentRoom.getItem(playerCommand[1]).look();
						present = true;
					}
					if (currentRoom.hasNPC(playerCommand[1])) {
						currentRoom.getNPC(playerCommand[1]).look();
						present = true;
					}
					if (!present) {
						print("You don't have " + playerCommand[1] + "!");
					}
				present = false;
				} else
					print("You simply just... observe...");
				break;
			case "use":
				if (playerCommand.length==2) {
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
				} else
					print("You bite your hand ferociously. Ouch.");
				break;
			/*
			 * Dev commands, for testing use only
			 */
			case "dev":
				if (playerCommand[1].equals("key")) { //DEV KEY: OPENS ALL DOORS
					inventory.add(new DevKey());
				} else if(playerCommand[1].equals("currentRoom")) { //PRINT() CURRENT ROOM DESCRIPTION
					print(currentRoom);
				} else if(playerCommand[1].equals("currentRoomName")) { //PRINT() CURRENT ROOM DESCRIPTION
						print(currentRoom.getName());
				} else { //PRINT DESC OF SELECT ROOM
					print(roomsMap.get(playerCommand[1]));
				}
				break;
			case "save":
				saveGame();
				break;
			case "load":
				try {
					loadGame();
				} catch (ClassNotFoundException e) {
					print("Cannot load save file.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					print("Cannot load save file.");
				}
				break;
			case "talk":
				if (playerCommand.length==2) {
					currentRoom.getNPC(playerCommand[1]).talk();
				}
				break;
			case "x":
				die();
				break;
			default:
				print("This command is invalid.");
				break;
			}

		} while(!dead);
		
		input.close();
		
	}

}
