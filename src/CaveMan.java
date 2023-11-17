
public class CaveMan extends Character{

	private boolean angry;
	private boolean debt; //Becomes endebted to you once you give him his pretty picture.
	
	public CaveMan() {
		super("caveman", "A hulking cave man stands in your presence.");
		angry = true;	
	}
	
	public void talk() {
		if (angry) {
			if (Game.getCurrentRoom().getName().equals("cave")) {
				say("*Angry incoherent grunts*");
				Game.print("He beats his fist against an open palm. No time for apologies. All of that rock paper scissors practice may just pay off.");
				String[] options = {
						"*Rock*",
						"*Paper*",
						"*Scissors*"
				};
				getResponse(options);
			} else {
				say("LET'S TAKE THIS BACK TO CAVE PUNK!");
				Game.getCurrentRoom().unlockAll();
				Game.print("The cave man hobbles back to the cave, murmuring to himself.");
				Game.bringNPC(this.getName(), "cave");
			}
		} else {
			say("WHAT YOU WANT NOW? I DON'T WANT TO TALK TO YOU!");
			if (debt) {
				say("WHAT YOU NEED FRIEND?");
				if(Game.getCurrentRoom().getName().equals("jungle")) {
				String[] options = {
						"Could you get me up into the treetops? I can't climb those trees.",
						"Nevermind, old chap."
				};
				} else {
					say("JUST DON'T PLAY THAT WHISTLE AGAIN.");
					Game.print("He'll probably come to you when you blow it again, perhaps you could use that...");
				}
		}
		}
	}
	
	public void response(int choice) {
		if (angry) {
			String result = MiniGame.rockPaperScissors(choice);
			switch (result) {
			case "tie":
				say("DARN! A TIE!");
				break;
			case "win":
				say("AAAAUUUUUUUGGGGGGGHHHHH!!! YOU WIN! LEAVE ME ALONE!");
				Game.print("The brute leaves his defensive position. I suppose you could enter his house now.");
				Game.getCurrentRoom().getExit('e').setLocked(false);
				angry=false;
				break;
			case "lose":
				say("RAAAAAAUUUUUUUAAAAGGGGGGHHHHHHHH!!!!!");
				Game.print("The caveman releases a savage blow to your skull, killing you instantly.");
				Game.die();
			}
			
		} else if (debt) {
			switch (choice) {
			case 1:
				say("WHATEVER YOU SAY!!!");
				Game.print("The caveman picks you up and violently throws you into the treetops.");
				Game.teleport("canopy");
			}
		}
	}
	
	public boolean getAnger() {
		return angry;
	}

}
