
public class Guide extends Item {

	public Guide() {
		super("note", "It is a note in your handwriting which reads \"How to beat Awesome Time Travel Game!\"");
	}
	
	public void take() {
		super.take();
		if (Game.getOtherRoom("mudPuddle").getId().equals("MUD_PUDDLE1a")){
			Game.getOtherRoom("mudPuddle").setId("MUD_PUDDLE1b");
		} else if (Game.getOtherRoom("mudPuddle").getId().equals("MUD_PUDDLE2a")) {
			Game.getOtherRoom("mudPuddle").setId("MUD_PUDDLE2b");
		} else {
			Game.getOtherRoom("mudPuddle").setId("MUD_PUDDLE3b");
		}
			
	}
	
	public void use() {
		Game.print("You read the entire note. Apparently you need to get back home with the Mona Lisa? But you have a choice to not bring it and instead learn the moral of not messing with time?");
	}

}
