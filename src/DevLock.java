
public class DevLock extends Item {

	public DevLock() {
		super("devlock", "It is a magical lock. It can lock all doors in a room.");
	}
		
	public void use() {
		boolean u = Game.getCurrentRoom().lockAll("Yup, that's locked alright.");
		if (u) {
			Game.print("You locked every door in this room.");
		} else {
			Game.print("Locking failed.");
		}
	}

}
