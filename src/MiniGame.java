import java.util.Random;

public class MiniGame {

	public static String rockPaperScissors(int you) {
		
		Random x = new Random();
		int opponent = x.nextInt(3);
		
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
