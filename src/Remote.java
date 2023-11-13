
public class Remote extends Item {

	public Remote() {
		super("remote", "It is a futuristic remote. Perhaps this is what you need to go home?");
	}
	
	public void use() {
		Game.print("You are overwhelmed by the sheer amount of buttons on the remote. "
				+ "You anxiously press the \"Start\" button, anticipating to be brought back home immediately. However, you instead to hear a whirring from the pond.");
		Game.changeRoomId("pond", "pond2");
	}

}
