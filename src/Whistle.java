
public class Whistle extends Item {
	
	public Whistle() {
		super("whistle", "It is a primitive whistle.");
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("cave")) {
			if (!isUsed()) {
				Game.print("From the locked door comes a hulking cave-man."
					+ " He threateningly gestures you. You'd better run, frankly.");
				setUsed(true);
				Game.getCurrentRoom().getExit('e').setLocked(false);
			} else {
				Game.lose();
				Game.print("The cave-man lunged at you and ripped your face off. Should have been more considerate. GAME OVER.");
			}
		} else {
			if (!isUsed()) {
			Game.print("You blew into the whistle. It made"
					+ " a loud, piercing cry. You hear a startled grunt"
					+ " in the distance.");
			} else {
				Game.print("The disgruntled cave-man rushed to you. He repeatedly slammed his giant fist against his open palm. Is this mercy?");
				//Ideally, once we add characters, I will make the player fight the cave-man in rock-paper scissors. Until then, this is the cliff-hanger.
			}
		}
	}
	
}
