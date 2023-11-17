
public class DevLock extends Item {

	public DevLock() {
		super("devlock", "It is a magical lock. It can lock all doors in a room.");
	}
		
	public void use() {
		Game.getCurrentRoom().lockAll("Yup, that's locked alright.");
	}

}
