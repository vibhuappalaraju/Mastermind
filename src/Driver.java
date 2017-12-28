

package mastermind;
import java.util.*;

public class Driver {
	public static void main(String[] args){
		boolean testmode;    // created a boolean testmode to check whether the game is in test mode or not
		if (args.length != 0) {
		if (args[0].equals("1")) {  // we have to use .equals because the argument is passed as a string
		testmode = true;
		} else
		testmode = false;
		} else {
		testmode = false;
		}
		Game Game = new Game(testmode); // created a game object which will use the argument to either pass true or false
		Game.rungame();
		
		
		
	}
}
