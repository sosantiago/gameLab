
public class World {
	
	
	
	public static Room buildWorld() {
		
	//Creating Room objects
	Room mudPuddle = new Room("mudPuddle", "MUD_PUDDLE1");
	Room cave = new Room("cave", "CAVE1");
	Room caveManHouse = new Room("caveManHouse", "CAVE_HOUSE");
	Room jungle = new Room("jungle", "JUNGLE");
	Room canopy = new Room("canopy", "CANOPY");
	Room pond = new Room("pond", "POND1");
	Room deepPond = new Room("deepPond", "DEEP1");
	Room venice = new Room("venice", "VENICE");
	Room vinciHouse = new Room("vinciHouse", "VINCI1");
	Room gallery = new Room("vinciGallery", "GALLERY1");
	
	
	//Adding Items to Rooms
	caveManHouse.addItem(new Club());
	canopy.addItem(new elephantLeaf());
	canopy.addItem(new Remote());
	deepPond.addItem(new TimeMachine());
	mudPuddle.addItem(new Item("mud", "It is a glob of smelly mud."));
	pond.addItem(new Whistle());
	caveManHouse.addItem(new Dog()); //Will likely become character, but it functions as I intend it to right now.
	jungle.addItem(new Bone());
	gallery.addItem(new MonaLisa());
	
	
	//Adding "exits" to Rooms
	mudPuddle.addTwoWay(cave, 'e');
	mudPuddle.addTwoWay(jungle, 'w');
	mudPuddle.addTwoWay(pond, 'n');
	cave.addTwoWay(caveManHouse, 'e');
	pond.addTwoWay(deepPond, 'd');
	jungle.addTwoWay(canopy, 'u');
	venice.addTwoWay(vinciHouse, 'e');
	vinciHouse.addTwoWay(gallery, 'u');
	
	//Adding locks and traps
	caveManHouse.setLocked(true, "You politely knocked on the door. There was a grunt from the inside.");
	
	return mudPuddle;
	}
	
}
