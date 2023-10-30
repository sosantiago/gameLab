
public class DevKey extends Item{
	
	public DevKey() {
		super("devkey", "It is a magical key. It can unlock any door.");
	}
	
	public void use() {
		char[] x = Directions.get();
		boolean u = false;
		for(char d : x) {
			if (!(Game.getCurrentRoom().getExit(d)==null)) {
				if(Game.getCurrentRoom().getExit(d).isLocked()) {
					Game.getCurrentRoom().getExit(d).setLocked(false);
					u = true;
				}
			}
		}
		if (u) {
			Game.print("You unlocked every locked door in this room.");
		} else {
			Game.print("There were no locked doors.");
		}
	}
}
