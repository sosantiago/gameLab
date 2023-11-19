import java.io.IOException;

public class DaVinci extends Character{

	int state = 0;
	boolean distressed;
	
	public DaVinci() {
		super("davinci", "It's Da Vinci in the flesh! He is spindly with a big long white beard and he is wearing a blue robe. You are also unsure if this is historically accurate.");
		distressed=false;
	}
	
	public void talk() throws ClassNotFoundException, IOException {
		if (state==0) {
			say("Yo, what's up! It's Da Vinci!");
			String[] options = null;
			if (Game.hasItem("monalisa")) {
				Game.print("*Is he not upset that you're stealing his magnum opus?*");
				options = new String[]{
					"Yoo!",
					"Are you not mad that I'm stealing your painting, dude?"
				};
			} else {
				options = new String[]{
						"Yoo!"
				};
			}
			getResponse(options);
		} else if (state==1){
			say("Do you need something, little child person?");
			String[] options = {
				"Yes, actually. Could you help me back home? I time-travelled here and need to get back to my time."
			};
			getResponse(options);
		} else if (state==2) {
			say("You've got that time residue I need?");
			String[] options = {
					"Yep! Please get it off of me!",
					"Not for you, nerd."
			};
			getResponse(options);
		} else {
			say("What are you waiting for! Get out of here! And make sure not to bring anything with you!");
		}
	}
	
	public void getResponse(String[] options) throws ClassNotFoundException, IOException {
		for (int s=0; s<options.length; s++) {
			Game.print("Option" + (s+1) + ": " + options[s]);
		}
		Game.print("What say you?");
		int choice = Game.input.nextInt();
		Game.input.nextLine();
		response(choice);
	}
	
	public void response(int choice) throws ClassNotFoundException, IOException {
		if (state==0) {
			switch (choice) {
			case 1:
				say("Yoo!");
				Game.print("Odd. What a productive conversation. This is not how you expected Da Vinci to be at all..");
				break;
			case 2:
				say("You what?!");
				Game.print("Da Vinci puts on his spectacles, and his expression grows very concerned.");
				say("You can't do that! Think about the Butterfly Effect!");
				break;
			}
			state++;
		} else if (state==1) {
			say("Yes, I can! I've met a few time travellers, and this always seems to happen. If you had some time residue on you, I could power up the ol' time machine I have in here.");
			Game.print("You wonder why no one has stolen the Mona Lisa before you if you're not the first to come here...");
			state++;
		} else if (state==2) {
			switch (choice) {
			case 1:
				say("Okay, just let me take that from you, do some calibrations, and you'll be set to go!");
				Game.print("Da Vinci removes the residue from you with a weird futuristic pump and funnels it into the machine. It should be working now!");
				Game.drop("timeresidue", false);
				((Remote) Game.getItem("remote")).vinciDidIt();
				state++;
				break;
			case 2:
				say("Oh, well, have fun staying here then...");
				break;
			}
		}
	}
	
	
}
