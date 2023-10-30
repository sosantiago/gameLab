
public class Drawing extends Item {

	public Drawing() {
		super("oxdrawing", "It is a poorly illustrated ox on a piece of brittle tree bark.");
	}
	
	public void use() {
		//if cave-man is with you: "You show to cave-man, he shows gratitude for finding his magnum opus. He is forever in your debt." else:
		Game.print("You failed to admire the hidden genuis of this piece.");
	}
}
