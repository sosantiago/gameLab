import java.io.Serializable;

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
	
	public void talk() {
		Game.print("You can't talk to "+name+".");
	}
	
	public void getResponse(String[] options) {
		for (int s=0; s<options.length; s++) {
			Game.print("Option" + (s+1) + ": " + options[s]);
		}
		Game.print("What say you?");
		int choice = Game.input.nextInt();
		Game.input.nextLine();
		response(choice);
	}
	
	public void response(int choice) {
		
	}
	
}
