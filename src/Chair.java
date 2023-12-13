
public class Chair extends Item {

	public Chair() {
		super("chair", "It's a rustic wooden chair.");
	}
	
	public void use() {
		Game.print("You sit in the chair. You don't know if you'll ever get up again, or have a need to.");
	}

}
