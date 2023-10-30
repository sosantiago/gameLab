
public class Chain extends Item {
	
	public Chain() {
		super("chain", "A chain hangs ominously from the sky.");
		setHeavy(true);
	}
	
	public void use() {
		Game.addItem(new Goo());
		Game.print("The sky let forth a downpour of sticky goo unto you.");
	}
}
