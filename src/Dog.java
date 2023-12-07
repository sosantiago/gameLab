
public class Dog extends Item{

	public Dog() {
		super("dog", "It clearly isn't a dog, but you're not sure what else to call it.");
		setHeavy(true);
	}
	
	public void use() {
		Game.print("You want to USE the dog? What do you mean by that?");
	}

}
