import java.io.IOException;

public class Remote extends Item{

	int vinci = 2;
	
	public Remote() {
		super("remote", "It is a futuristic remote. Perhaps this is what you need to go home?");
	}
	
	public void use() throws ClassNotFoundException, IOException {
		Game.setTalkingTo("remote?");
		Game.gui.setConvo(true);
		Game.print("You stare at the remote for a few minutes. All of its buttons are perplexing to you. This is what you can make out:");
		String[] options = {
				"Maybe a start button? It's big and red, so it must be.",
				"A button with a caveman on it. This must be how you got here!",
				"A button with Da Vinci on it. Bingo!",
				"A button with a city building on it. Maybe it is how you get back home?"
		};
		getResponse(options);
	}
	
	public void getResponse(String[] options) throws ClassNotFoundException, IOException {
		for (int s=0; s<options.length; s++) {
			Game.print("Option" + (s+1) + ": " + options[s]);
		}
		Game.gui.prompt("What will you press?");
	}
	
	public void response(int choice) throws ClassNotFoundException, IOException {
		String[] rooms = {"deepPond", "bedroom", "vinciGallery"};
		for (int i = 0; i < vinci; i++) {
			switch (choice) {
			case 1:
				switch (i) {
				case 0:
					Game.changeRoomId("pond", "POND2");
					Game.changeRoomId("deepPond", "DEEP2");
					Game.getOtherRoom("deepPond").getItem("machine").setUsed(true);
					break;
				case 1:
					Game.changeRoomId("vinciGallery", "GALLERY3");
					Game.getOtherRoom("vinciGallery").getItem("machine").setUsed(true);
					break;
				case 2:
					Game.changeRoomId("bedroom", "BEDROOM2");
					Game.getOtherRoom("bedroom").getItem("machine").setUsed(true);
					break;
				}
				break;
			case 2:
				((TimeMachine) Game.getOtherRoom(rooms[i]).getItem("machine")).setMode('a');
				break;
			case 3:
				((TimeMachine) Game.getOtherRoom(rooms[i]).getItem("machine")).setMode('b');
				break;
			case 4:
				((TimeMachine) Game.getOtherRoom(rooms[i]).getItem("machine")).setMode('c');
				break;
			}
		}
		switch (choice) {
		case 1:
			Game.print("You anxiously press the \"Start\" button, anticipating to be brought back home immediately. Something MUST have turned on.");
			break;
		case 2:
			Game.print("You pressed the button with the caveman on it. A growling noise came from the remote.");
			break;
		case 3:
			Game.print("You pressed the Da Vinci button. A funny \"hurrmmmm\" sound came from the remote.");
			break;
		case 4:
			Game.print("You pressed the city-lookin' button. A car beeping sound came from the remote. Who made this?!");
			break;
		}
		
		Game.gui.setConvo(false);
		Game.setTalkingTo("no one");
	}
	
	public void take() {
		super.take();
		if (Game.getOtherRoom("canopy").getId().equals("CANOPY1a")) {
			Game.getOtherRoom("canopy").setID("CANOPY1ab");
		} else {
			Game.getOtherRoom("canopy").setID("CANOPY1b");
		}
	}
	
	public void vinciDidIt() {
		vinci++;
	}
	
	public int getVinci() {
		return vinci;
	}

}
