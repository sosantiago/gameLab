
public class elephantLeaf extends Item {

	public elephantLeaf() {
		super("elephantleaf", "It is a large, green leaf, resembling an elephant's ear. There is a weird air-filled sack on the stem of the leaf.");
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("canopy")&&Game.hasItem("elephantleaf")) {
			boolean u = Game.getCurrentRoom().unlockAll();
			if (u) {
				Game.print("You ready the leaf above your head. It may be large enough to act as a parachute.");
			} else {
				Game.print("Huh?");
			}
		} else {
			Game.print("You fan yourself with the leaf. You feel refreshed.");
		}
	}
	
	public void take() {
		super.take();
		if (Game.getOtherRoom("canopy").getId().equals("CANOPY1b")) {
			Game.getOtherRoom("canopy").setID("CANOPY1ab");
		} else {
			Game.getOtherRoom("canopy").setID("CANOPY1a");
		}
	}
}
