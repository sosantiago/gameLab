
public class Bed extends Item {
	
	public Bed() {
		super("bed", "It's your bed! Tired?");
		setHeavy(true);
	}
	
	public void use() {
		if (((Remote) Game.getItem("remote")).getVinci()>1) {
			Game.print("You gracefully fall asleep in your bed. Home sweet home! \nTHE END");
		} else {
			Game.print("You toss in turn in your bed for a bit. You can't sleep.");
		}
	}
}
