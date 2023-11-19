import java.io.IOException;

public class Puppy extends Character {
	
	int state;
	
	public Puppy() {
			super("puppy", "A hideous puppy wags his tail.");
			state = 0;
	}
	@Override
	public void talk() throws ClassNotFoundException, IOException {
		if (state==0) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
				"Yes you are! Who's a good boy?",
				"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
		} else if (state==1) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options = {
				"Yes! I love fetch!",
				"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
		} else {
			say("Yip!");
		}
	}
	@Override
	public void response(int option) {
		if (state==0) {
			switch(option) {
				case 1:
					say("I am! I'm a good boy!");
					break;
				case 2:
					say("I am too adorable! Why are you so mean?");
					Game.print("The puppy bites you. You deserve it.");
					break;
			}
			state++;
		} else {
			switch(option) {
				case 1:
					say("Yay! Fetch! (The puppy runs off and returns with a ball. The player receives the ball.)");
					break;
				case 2:
					say("You're a bad person! I don't like you! (The puppy runs away and doesn't come back.)");
					Game.getCurrentRoom().removeNPC("puppy");
					break;
			}
			state++;
		}
	}
}
