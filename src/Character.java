import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Character implements Serializable {

	private String name;
	private String desc;
	private int atk;
	private int hp;
	private ArrayList<Item> npcInv;
	
	public Character(String name) {
		this.name = name;
	}
	
	public Character(String name, String s) {
		this.name = name;
		this.desc = s;
		hp = 100;
		npcInv = new ArrayList<Item>();
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
		Game.print("What say you?");
		int choice = Game.input.nextInt();
		Game.input.nextLine();
		response(choice);
	}
	
	public void response(int choice) throws ClassNotFoundException, IOException {
		
	}
	
	public void give (Item i) {
		npcInv.add(i);
		Game.print("You gave your " + i.getName() + " to " + name + ".");
		Game.drop(i.getName(), false);
	}
	
	public void attack (Item weapon) {
		Random r = new Random();
		int roll = r.nextInt(20)-10;
		int dmg = weapon.getDMG()+roll;
		hp -= dmg;
		int rcl = atk-dmg;
		String rcls = "";
		if(rcl>0) {
			rcls=" You took " + rcl + " DMG in the process!";
		}
		Game.print("You attacked " + name + " with " + weapon.getName() + "! You dealt " + dmg + " DMG!" + rcls);
		Game.takeDMG(rcl);
		if(Game.getHP()>=0) {
			Game.print(name + " killed you!");
			Game.die();
		}
	}
	
}
