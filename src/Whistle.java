import java.io.IOException;

public class Whistle extends Item {
	
	public Whistle() {
		super("whistle", "It is a primitive whistle.");
	}

	public void use() throws ClassNotFoundException, IOException {
		if(isUsed()) {
			boolean angry = ((CaveMan) Game.findNPC("caveman")).getAnger();
		}
		
		if(Game.getCurrentRoom().hasNPC("caveman")) {
			Game.print("The cave-man lunged at you and ripped your face off. You knew he didn't like it! Should have been more considerate.");
			Game.die();
			return;
		}
		
		if(Game.getCurrentRoom().getName().equals("cave")) {
			if (!isUsed()) {
				Game.print("From the locked door comes a hulking cave-man."
					+ " He threateningly gestures you. You want to run, but you also really want to invade his home.");
				setUsed(true);
				Game.getCurrentRoom().setID("CAVE2");
				Game.getCurrentRoom().addNPC(new CaveMan());
				Game.getCurrentRoom().getExit('e').setLocked(true, "Do you really want to try and sneak past the cave man that is very clearly mad at you?");
			} 
		} else {
			if (!isUsed()) {
			Game.print("You blew into the whistle. It made"
					+ " a loud, piercing cry. You hear a startled grunt"
					+ " deep in the cave.");
			} else {
				if(Game.getCurrentRoom().isAccessable()) {
					if(((CaveMan) Game.findNPC("caveman")).getAnger()) {
						Game.getCurrentRoom().lockAll("caveman: NUH UH. YOU TALK TO ME FIRST WIMP.");
						Game.bringNPC("caveman");
						Game.print("The caveman ran to " + Game.getCurrentRoom().getName() + " in a blind rage. You should probably try to apologize.");
					} else {
						Game.bringNPC("caveman");
						Game.print("The caveman runs to you. He looks frusterated, but you don't think he is going to kill you.");
					}
				} else {
					Game.print("You blew the whistle, but nobody came.");
				}
			}
		}
	}
	
	public void take() {
		if (!isHeavy()) {
			Game.addItem(Game.getCurrentRoom().removeItem(getName()));
			Game.print("You took the " + getName() + ".");
		} else {
			Game.print(getName() + " is too heavy!");
		}
		Game.changeRoomId("pond", "POND1a");
	}
	
}
