
public class Drawing extends Item {

	public Drawing() {
		super("oxdrawing", "It is a poorly illustrated ox on a piece of brittle tree bark.");
	}
	
	public void use() {
		Game.print("It is close enough to the Mona Lisa... maybe it is worth something? Either way, you still need to find a way back home.");
	}
}
