
public class Club extends Item{
	
	public Club() {
		super("woodenclub", "It is a large, unwieldy wooden club.");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("jungle")) {
			if (!isUsed()) {
				Game.print("You thwacked the suspicious-looking tree. You uncovered a secret door!");
				setUsed(true);
				Game.getCurrentRoom().getExit('n').setLocked(false);
			} else {
				Game.print("You aimlessly swung around the heavy club.");
			}
		} else {
			Game.print("You aimlessly swung around the heavy club.");
		}
		
	}
}
