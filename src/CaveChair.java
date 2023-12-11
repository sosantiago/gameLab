
public class CaveChair extends Item {

	public CaveChair() {
		super("chair", "It's a crude, wooden chair. It could not possibly be comfortable.");
		setHeavy(true);
	}
	
	public void use() {
		Game.print("You sit in the chair, and are bewildered by how comfortable it is.");
	}

}
