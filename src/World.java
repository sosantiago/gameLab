
public class World {
	
	
	
	public static Room buildWorld() {
		
	//Creating Room objects
	Room mudPuddle = new Room("mudPuddle", "MUD_PUDDLE1");
	Room cave = new Room("cave", "CAVE1");
	Room caveManHouse = new Room("caveManHouse", "CAVE_HOUSE");
	Room jungle = new Room("jungle", "JUNGLE");
	Room canopy = new Room("canopy", "CANOPY");
	Room pond = new Room("pond", "POND");
	Room deepPond = new Room("deepPond", "PONDd");
	Room pit = new Room("Pit", "PIT");
	
	
	//Adding Items to Rooms
	caveManHouse.addItem(new Club());
	canopy.addItem(new Item("elephantleaf", "It is a large, green leaf, resembling an elephant's ear. There is a weird air-filled sack on the stem of the leaf."));
	mudPuddle.addItem(new Item("mud", "It is a glob of smelly mud."));
	pond.addItem(new Whistle());
	caveManHouse.addItem(new Dog()); //Will likely become character, but it functions as I intend it to right now.
	jungle.addItem(new Bone());
	
	
	//Adding "exits" to Rooms
	mudPuddle.addTwoWay(cave, 'e');
	mudPuddle.addTwoWay(jungle, 'w');
	mudPuddle.addTwoWay(pond, 'n');
	cave.addTwoWay(caveManHouse, 'e');
	
	jungle.addExit(canopy, 'u');
	canopy.addExit(pit, 'd');
	
	//Adding locks and traps
	caveManHouse.setLocked(true, "You politely knocked on the door. There was a grunt from the inside.");
	
	return mudPuddle;
	}
	
}
