import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
	
	//Room Description
	private String roomName = null;
	private String id = null;
	
	//Room Position
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	
	//Room Conditions
	private boolean locked; //Is the room locked?
	private String lockedMessage;
	
	/*
	 * HashMap for Item Objects.
	 */
	private HashMap<String, Item> roomItems;
	
	//Constructors
	public Room(String n, String d) {
		roomName = n;
		id = d;
		roomItems = new HashMap<String, Item>();
		Game.addRoom(n, this); //Room object places self on map
	}

	//Getters
	public Room getExit(char dir) {
		if (dir == 'e') {
			return east;
		} else if (dir == 'w'){
			return west;
		} else if (dir == 'n'){
			return north;
		} else if (dir == 's'){
			return south;
		} else if (dir == 'u'){
			return up;
		} else if (dir == 'd'){
			return down;
		}
		return null;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void wasLocked() {
		Game.print(lockedMessage);
	}
	
	public String getName() {
		return roomName;
	}
	
	//Setters
	public void addExit(Room r, char dir) {
		if (dir == 'e') {
			east = r;
		} else if (dir == 'w'){
			west = r;
		} else if (dir == 'n'){
			north = r;
		} else if (dir == 's'){
			south = r;
		} else if (dir == 'u'){
			up = r;
		} else if (dir == 'd'){
			down = r;
		}
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public void setLocked(boolean b, String s) {
		lockedMessage = s;
		locked = b;
	}
	
	public void setID(String s) {
		setId(s);
	}
	
	/*
	 * addTwoWay method: 
	 * 1. Creates an exit for this that leads to Room r in dir direction,
	 * 2. creates an exit to this room from Room r in opposite direction.
	 */
	public void addTwoWay(Room r, char dir) {
		addExit(r, dir);
		if (dir == 'w') {
			r.addExit(this, 'e');
		} else if (dir == 'e'){
			r.addExit(this, 'w');
		} else if (dir == 's'){
			r.addExit(this, 'n');
		} else if (dir == 'n'){
			r.addExit(this, 's');
		} else if (dir == 'd'){
			r.addExit(this, 'u');
		} else if (dir == 'u'){
			r.addExit(this, 'd');
		}
	}
	
	/*
	 * Remove Item from room
	 */
	public Item removeItem(String name) {
		return getRoomItems().remove(name);
	}
	
	/*
	 * Get item in room
	 */
	
	public Item getItem(String name) {
		return getRoomItems().get(name);
	}
	
	/*
	 * Add Item to room
	 */
	public void addItem(Item i) {
		getRoomItems().put(i.getName(), i);
	}
	
	/*
	 * Check for item
	 */
	public boolean hasItem(String itemName) {
		return getRoomItems().containsKey(itemName);
	}
	
	private HashMap<String, Item> getRoomItems() {
		return roomItems;
	}

	//ToString
	public String toString() {
		return Game.getRoomDesc(getId());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
