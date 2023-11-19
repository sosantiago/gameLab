
public class World {
	
	
	
	public static Room buildWorld() {
		
	char[] dir = Directions.get();
		
	//Creating Room objects
	Room mudPuddle = new Room("mudPuddle", "MUD_PUDDLE1");
	Room cave = new Room("cave", "CAVE1");
	Room caveManHouse = new Room("caveManHouse", "CAVE_HOUSE");
	Room jungle = new Room("jungle", "JUNGLE1");
	Room canopy = new Room("canopy", "CANOPY1");
	Room pond = new Room("pond", "POND1");
	Room deepPond = new Room("deepPond", "DEEP1");
	Room venice = new Room("venice", "VENICE");
	Room vinciHouse = new Room("vinciHouse", "VINCI1");
	Room gallery = new Room("vinciGallery", "GALLERY1");
	Room bathroom = new Room("bathroom", "BATHROOM1");
	Room bedroom = new Room("bedroom", "BEDROOM1");
	Room hallway = new Room ("hallway", "HALLWAY1");
	Room livingroom = new Room ("livingroom", "LIVINGROOM1");
	Room exit = new Room ("exit", "EXIT");
	Room dystopia = new Room ("dystopia", "DYSTOPIA1");
	Room butterfly = new Room ("butterfly", "BUTTERFLY");
	
	
	//Adding Items and NPCs to Rooms
	caveManHouse.addItem(new Club());
	canopy.addItem(new elephantLeaf());
	canopy.addItem(new Remote());
	deepPond.addItem(new TimeMachine());
	bedroom.addItem(new Bed());
	bedroom.addItem(new TimeMachine(true));
	bathroom.addItem(new Toilet());
	mudPuddle.addItem(new Item("mud", "It is a glob of smelly mud."));
	pond.addItem(new Whistle());
	caveManHouse.addItem(new Dog()); //Will likely become character, but it functions as I intend it to right now.
	jungle.addItem(new Bone());
	gallery.addItem(new MonaLisa());
	gallery.addItem(new TimeMachine());
	
	gallery.addNPC(new DaVinci());
	butterfly.addNPC(new OldMan());
	
	
	//Adding "exits" to Rooms
	mudPuddle.addTwoWay(cave, 'e');
	mudPuddle.addTwoWay(jungle, 'w');
	mudPuddle.addTwoWay(pond, 'n');
	cave.addTwoWay(caveManHouse, 'e');
	pond.addTwoWay(deepPond, 'd');
	canopy.addExit(jungle, 'd');
	venice.addTwoWay(vinciHouse, 'e');
	vinciHouse.addTwoWay(gallery, 'u');
	bathroom.addTwoWay(bedroom, 's');
	bedroom.addTwoWay(hallway, 'w');
	hallway.addTwoWay(livingroom, 'w');
	livingroom.addTwoWay(exit, 'w');
	
	for(char d : dir) {
		dystopia.addExit(dystopia, d);
	}
	
	
	//Adding locks and traps
	caveManHouse.setLocked(true, "You politely knocked on the door. There was a grunt from the inside.");
	exit.setLocked(true, "You could leave your house, but you don't feel the need to.");
	
	
	//Setting "movemessages" (used only once lol)
	canopy.setMoveMessage("You gracefully float down with the help of the leaf.");
	
	
	//GAME LAB NPCS OBJECTIVES
	mudPuddle.addNPC(new Puppy());
	
	return mudPuddle;
	}
	
}
