
public class TimeMachine extends Item {
	
	public TimeMachine() {
		super("machine", "It is very obviously a time machine. I mean, look at it!");
	}
	
	
	
	public void use() {
		if(isUsed()) {
			Game.print("You quickly enter the time machine before you drown.");
			Game.teleport("venice");
		} else {
			Game.print("You try to enter the time machine, but it is closed.");
		}
	}

}
