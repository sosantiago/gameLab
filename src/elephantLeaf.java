
public class elephantLeaf extends Item {

	public elephantLeaf() {
		super("elephantleaf", "It is a large, green leaf, resembling an elephant's ear. There is a weird air-filled sack on the stem of the leaf.");
	}

	public void use() {
		if(Game.getCurrentRoom().equals("canopy")) {
			Game.getCurrentRoom().getExit('d').setLocked(false);
		}
	}
}
