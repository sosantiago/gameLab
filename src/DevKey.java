
public class DevKey extends Item{
	
	public DevKey() {
		super("devkey", "It is a magical key. It can unlock any door.");
	}
	
	public void use() {
		boolean u = Game.getCurrentRoom().unlockAll();
		if (u) {
			Game.print("You unlocked every locked door in this room.");
		} else {
			Game.print("There were no locked doors.");
		}
	}
}
