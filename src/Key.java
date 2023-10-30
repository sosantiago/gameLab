
public class Key extends Item{
	
	public Key() {
		super("bonekey", "It's a small bone, carved into the shape of a key.");
	}

	public void use() {
		if(Game.getCurrentRoom().getName().equals("caveManHouse")) {
			if (!isUsed()) {
				setUsed(true);
				Game.print("You threw the bone. "
						+ "The \"dog\" hastily spat up a picture of a poorly drawn ox. "
						+ "Then, the satisfied creature fetched the key back to you.");
				Item drawing = new Drawing();
				Game.getCurrentRoom().addItem(drawing);
			} else {
				Game.print("The creature is satisfied.");
			}
		} else {
			Game.print("You bit the bone key — hard. You may have to see a dentist when this is all over.");
		}
	}
}
