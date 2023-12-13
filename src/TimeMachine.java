
public class TimeMachine extends Item {
	
	private char mode = 'b';
	
	public TimeMachine() {
		super("machine", "It is very obviously a time machine. I mean, look at it!");
	}
	
	public TimeMachine(boolean b) {
		super("machine", "It is very obviously a time machine. I mean, look at it!");
		setUsed(b);
	}
	
	public void use() {
		if(isUsed()) {
			Game.print("You enter the time machine.");
			if (mode=='a') {
				Game.changeRoomId("mudPuddle", "MUD_PUDDLE3");
				Game.teleport("mudPuddle");
			} else if (mode=='b') {
				Game.teleport("venice");
			} else {
				if (Game.hasItem("monalisa")) {
					Game.teleport("dystopia");
				} else {
					Game.teleport("bathroom");
				}
			}
			Game.addItem(new TimeDust());
		} else {
			Game.print("You try to enter the time machine, but it is closed.");
		}
	}
	
	public void setMode(char x) {
		mode = x;
	}

}
