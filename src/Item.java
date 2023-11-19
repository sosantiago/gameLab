import java.io.IOException;
import java.io.Serializable;

public class Item implements Serializable{

	
	private String name;
	private String desc;
	private boolean heavy;
	private boolean used;
	
	public Item(String name, String desc) {
		this.name = name;
		this.desc = desc;
		heavy = false;
		setUsed(false);
	}
	/*
	public void uniqueCommand(String s) {
		if (command.equals)
	}
	*/
	public void setHeavy(boolean b) {
		heavy = b;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

	public void look() {
		System.out.println(desc);
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void use() throws ClassNotFoundException, IOException {
		Game.print("You can't use this item... yet.");
	}
	
	public void take() {
		if (!heavy) {
			Game.addItem(Game.getCurrentRoom().removeItem(name));
			Game.print("You took the " + name + ".");
		} else {
			Game.print(name + " is too heavy!");
		}
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	
}
