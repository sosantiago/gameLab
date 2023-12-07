import java.io.IOException;

public class Bed extends Item {
	
	public Bed() {
		super("bed", "It's your bed! Tired?");
		setHeavy(true);
	}
	
	public void use() throws ClassNotFoundException, IOException {
		if (((Remote) Game.getItem("remote")).getVinci()>1) {
			Game.print("You gracefully fall asleep in your bed. You may have learned a lesson in this adventure! Home sweet home! \n\nTHE END");
			Game.die();
		} else {
			Game.print("You toss in turn in your bed for a bit. You can't sleep.");
		}
	}
}
