
public class CaveBed extends Item {

	public CaveBed() {
		super("bed", "It's the caveman's bed. It is suprisingly well made.");
		setHeavy(true);
	}
	
	public void use() {
		Game.print("You lay in the caveman's bed. A stench comes from it, and you promptly get up.");
	}

}
