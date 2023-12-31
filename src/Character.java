import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Character implements Serializable {

	private String name;
	private String desc;
	
	public Character(String name) {
		this.name = name;
	}
	
	public Character(String name, String s) {
		this.name = name;
		this.desc = s;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String s) {
		desc = s;
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public void say(String s) {
		Game.print(name+": "+s);
	}
	
	public void talk() throws IOException, ClassNotFoundException {
		Game.print("You can't talk to "+name+".");
	}
	
	public void getResponse(String[] options) throws ClassNotFoundException, IOException {
		for (int s=0; s<options.length; s++) {
			Game.print("Option" + (s+1) + ": " + options[s]);
		}
		Game.gui.prompt("What say you?");
	}
	
	public void response(int choice) throws ClassNotFoundException, IOException {
		
	}
	
	public void give (Item i) {
		Game.print("You gave your " + i.getName() + " to " + name + ".");
		Game.drop(i.getName(), false);
	}
	
}
