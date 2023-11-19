
public class Bone extends Item{
	
	public Bone() {
		super("bone", "It's a cartoonishly-shaped bone");
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("caveManHouse")) {
			if (!isUsed()) {
				setUsed(true);
				Game.print("You threw the bone. "
						+ "The \"dog\" hastily spat up a picture of a poorly drawn ox. "
						+ "Then, the satisfied creature fetched the bone back to you.");
				Item drawing = new Drawing();
				Game.getCurrentRoom().addItem(drawing);
			} else {
				Game.print("You threw the bone, but the dog did not fetch it this time, for he is satisfied. Pick it up yourself.");
				Game.drop("bone", true);
			}
		} else {
			Game.print("You bit the bone — hard. What compelled you to do this? No one will know, but you may have to see a dentist when this is all over.");
		}
	}
	
	public void take() {
		super.take();
		Game.getOtherRoom("jungle").setId("JUNGLE1a");
	}
}
