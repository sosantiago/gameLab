
public class MonaLisa extends Item {

	public MonaLisa() {
		super("monalisa", "It's the frickin' Mona Lisa! Get back home with it so you can gloat!");
	}
	
	public void take() {
		super.take();
		Game.getCurrentRoom().setId("GALLERY2");
	}

}
