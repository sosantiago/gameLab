
public class Shower extends Item{
	
	public Shower() {
		super("shower", "It is an aluminum shower head. You can rinse off with it.");
		setHeavy(true);
	}
	
	public void use() {
		if (Game.hasItem("goo")) {
			Game.drop("goo");
			Game.print("You rinsed the goo off of yourself.");
		} else {
			Game.print("The shower head rudely refused to activate.");
		}
	}
}
