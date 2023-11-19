import java.util.Random;

public class MiniGame {

	public static String rockPaperScissors(int you) {
		
		/* 
		 * 0 is rock
		 * 1 is paper
		 * 2 is scissors
		 */
		
		Random x = new Random();
		int opponent = x.nextInt(3);
		
		switch(opponent) {
		case 0:
			Game.print("Your opponent chose rock.");
			break;
		case 1:
			Game.print("Your opponent chose paper.");
			break;
		case 2:
			Game.print("Your opponent chose scissors.");
			break;
		}
		
		if(opponent==(you)) {
			return "tie";
		}
		
		switch(you) {
		case 0:
			if (opponent==(1)) {
				return "lose";
			} else {
				return "win";
			}
		case 1:
			if (opponent==(2)) {
				return "lose";
			} else {
				return "win";
			}
		case 2:
			if (opponent==(0)) {
				return "lose";
			} else {
				return "win";
			}
		}
		
		return "huh";
		
	}

}
