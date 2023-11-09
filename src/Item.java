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
	
	public void use() {
		Game.print("You can't use this item... yet.");
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	
}
