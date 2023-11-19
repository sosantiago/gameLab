import java.io.IOException;

public class CaveMan extends Character{

	private boolean angry;
	private boolean debt; //Becomes indebted to you once you give him his pretty picture.
	
	public CaveMan() {
		super("caveman", "A hulking cave man stands in your presence.");
		angry = true;	
	}
	
	public void talk() throws ClassNotFoundException, IOException {
		
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
			if (debt) {
				say("WHAT YOU NEED FRIEND?");
				if(Game.getCurrentRoom().getName().equals("jungle")) {
					String [] options = {
							"Could you get me up into the treetops? I can't climb those trees.",
							"Nevermind, old chap."
					};
					getResponse(options);
				} else {
					String [] options = {
							"Nothing, just admiring your physique."
					};
					getResponse(options);
				}
			} else {
				if (!Game.hasItem("oxdrawing")) {
					say("WHAT YOU WANT NOW? I DON'T WANT TO TALK TO YOU!");
					String[] options = {
							"I won fair and square, rock-eater!",
							"Sorry man."
					};
					getResponse(options);
				} else {
					say("IS THAT MY DRAWING?!");
					String[] options = {
							"I saw it first, bucky!",
							"Sure, you can have it!"
					};
					getResponse(options);
				}
			}
		}
	}
	
	public void response(int choice) throws ClassNotFoundException, IOException {
		if (angry) {
			String result = MiniGame.rockPaperScissors(choice-1);
			switch (result) {
			case "tie":
				say("DARN! A TIE!");
				break;
			case "win":
				say("AAAAUUUUUUUGGGGGGGHHHHH!!! YOU WIN! LEAVE ME ALONE!");
				Game.print("The brute leaves his defensive position. I suppose you could enter his house now.");
				Game.getCurrentRoom().getExit('e').setLocked(false);
				Game.changeRoomId("cave", "CAVE3");
				angry=false;
				break;
			case "lose":
				say("RAAAAAAUUUUUUUAAAAGGGGGGHHHHHHHH!!!!!");
				Game.print("The caveman releases a savage blow to your skull, killing you instantly.");
				Game.die();
			}
		} else {
			if (debt) {
				if(Game.getCurrentRoom().getName().equals("jungle")) {
					switch (choice) {
					case 1:
						say("WHATEVER YOU SAY!!!");
						Game.print("The cave man hurls you into the treetops with inhuman strength.");
						Game.teleport("canopy");
						Game.getCurrentRoom().getExit('d').setLocked(true, "It's too far to go down on your own. Perhaps there is something around you that you can use to get down safely.");
						break;
					case 2:
						say("OKAY...");
						break;
					}
				} else {
					say("AYYOOOOOOO??");
				}
			} else {
				if (!Game.hasItem("oxdrawing")) {
					Game.drop("oxdrawing", false);
					switch (choice) {
					case 1:
						say("Woah, dude. That's too far.");
						Game.print("The caveman walks away in disappointment. You succumb to your guilt and have a shame-induced heart-attack.");
						Game.die();
						break;
					case 2:
						say("DON'T CARE!");
						break;
					}
				} else {
					switch (choice) {
					case 1:
						say("RRRAAAAAUUUUUGGGGGGHHHHHH NO IT'S MINE!");
						Game.print("The caveman snatches the drawing and smashes it over your head, shattering it in the process. Also, you die.");
						say("Awwww, my drawing...");
						Game.die();
						break;
					case 2:
						say("THANK YOU FOR FINDING IT!!! I LOVE YOU!");
						debt=true;
						break;
					}

				}
			}
		}
	}
	
	public boolean getAnger() {
		return angry;
	}

}
