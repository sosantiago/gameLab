import java.io.IOException;

public class OldMan extends Character {
	
	int state = 0;
	
	public OldMan() {
		super("oldman", "The old man glares at you.");
	}

	public void talk() throws ClassNotFoundException, IOException {
		String[] options = {};
		if (state==0) {
			say("Hey, you don't look like your from around here. You must be another time traveller.");
			options = new String[]{
				"Yeah, I am. What of it?",
				"AHHHHHHHH!!!! Where am I?!"
			};
			getResponse(options);
		} else {
			say("And no, there is no way out. Have fun here, forever.");
			Game.print("THE END");
			Game.die();
		}
	}

	public void response(int option) {
		if (state==0) {
			switch(option) {
				case 1:
					say("This, my friend, is the butterfly affect.");
					break;
				case 2:
					say("You're in the butterfly. He eats time travellers who aren't responsible enough to consider the buttefly affect.");
					break;
			}
			state++;
		}	
	}
}
