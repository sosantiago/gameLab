
public class World {
	
	public static Room buildWorld() {
		
	//Creating Room objects
	Room mudPuddle = new Room("mudPuddle", "You are in a puddle of sticky mud.");
	Room cave = new Room("cave", "You are in a cave.");
	Room caveManHouse = new Room("caveManHouse", "You are in a well-lit cave abode.");
	Room jungle = new Room("jungle", "You are in a clearing, surrounded by tall trees.");
	Room canopy = new Room("canopy", "Large green jungle canopy.");
	Room hollowTree = new Room("hollowTree", "You are inside of a suspiciously large tree");
	Room strangePool = new Room("strangePool", "You are in a pool full of a weird blue goo.");
	
	
	//Setting Room descriptions.
	caveManHouse.setDesc("You are in a well-lit cave abode. There is a wooden club on a rack, and a hairy, dog-like creature"
			+ " sleeping on a crude bed.");
	
	
	//Adding Items to Rooms
	caveManHouse.addItem(new Club());
	canopy.addItem(new Item("elephantleaf", "It is a large, green leaf, resembling an elephant's ear."));
	mudPuddle.addItem(new Item("mud", "It is a glob of smelly mud."));
	strangePool.addItem(new Whistle());
	caveManHouse.addItem(new Dog());
	jungle.addItem(new Key());
	
	
	//Game Lab Items Additions
	mudPuddle.addItem(new Chain());
	strangePool.addItem(new Shower());
	
	
	//Adding "exits" to Rooms
	mudPuddle.addTwoWay(cave, 'e');
	mudPuddle.addTwoWay(jungle, 'w');
	cave.addTwoWay(caveManHouse, 'e');
	jungle.addTwoWay(hollowTree, 'n');
	jungle.addTwoWay(strangePool, 's');
	jungle.addTwoWay(canopy, 'u');
	
	//Adding locks
	caveManHouse.setLocked(true);
	hollowTree.setLocked(true);
	
	return mudPuddle;
	}
	
}
