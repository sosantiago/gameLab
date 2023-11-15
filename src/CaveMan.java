
public class CaveMan extends Character{

	public CaveMan() {
		super("caveman", "A hulking cave man");
	}
	
	public void talk() {
		say("*Angry incoherent grunts* (He beats his fist against an open palm. All of that rock paper scissors may just pay off.");
		String[] options = {
				"*Rock*",
				"*Paper*",
				"*Scissors*"
		};
		getResponse(options);
	}
	
	public void response(int choice) {
		switch(choice) {
			case 1:
				say("A tie... what a shame... (so now he can talk?)");
				break;
			case 2:
				say("*keels back in pain* You have proven yourself in battle. You may enter my home.");
				break;
			case 3:
				say("RAAAAGGGGHHHHHH");
				Game.print("The caveman punches you so hard in the face that you die, instantly.");
				Game.die();
		}
	}

}
