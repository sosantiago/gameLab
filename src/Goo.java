
public class Goo extends Item {
	
	public Goo() {
		super("goo", "It is an extraordinarily sticky glob of goo. You can't get it off!");
	}
	
	public void use() {
		Game.print("You futily attempt to remove the goo.");
	}
}
