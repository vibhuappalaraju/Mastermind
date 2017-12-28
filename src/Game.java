package mastermind;


import java.util.*;

public class Game {
	static boolean flag = false; // this flag checks if you won the game and if
									// you did it will break out of the first
									// while loop
	boolean test = false; // this is also used as a flag to check if it is in
							// testing mode or not

	public Game(boolean testmode) { // constructor for the game
		this.test = testmode;
	}
/** 
 * 
 * 
 * 
 * 
 * 
 * 
 */
	public void rungame() { // runs the game

		initialGreeting(); //greets the user
		Scanner console = new Scanner(System.in); //the scanner object takes the users response if they want to play
		String response = console.nextLine();

		if (response.charAt(0) == 'N') {
			return;
		}
		while (true) {

			History h1 = new History(); // creating a history object

			flag = false;
			String result = SecretCodeGenerator.getInstance().getNewSecretCode(); //then generates a secret,  and accepts a users guess. 
			if (this.test) { // if they are in test mode the secret code will be shown
				System.out.println("Secret code: " + result);
			}
			int i = GameConfiguration.guessNumber;
			
			while (i > 0) {
				System.out.println("");
				System.out.println("You have " + i + " guess(es) left.");
				System.out.println("Enter guess:");
				String theguess = console.nextLine();
				theguess = theguess.trim();
				if (theguess.equals("HISTORY")) { //  checks if the users guess is history 
					h1.PrintHistory();
					i++;
				} else {

					Boolean validation = validGuess(theguess); // checks if the users guess is  an invalid guess

					if (!validation) {
						System.out.println(theguess + " -> INVALID GUESS");
						i++;
					} else {
						
						// this takes the input of the guess and the secret code and creates a string which will if
						// passed through the no of black pegs function will give us the no of black pegs
						StringBuilder Bpegs = new StringBuilder(Pegs.Blackpegs(theguess, result)); 
						
						//guessmodified is a modified version of the guess string. 
						StringBuilder guessmodified = new StringBuilder(Pegs.guessmodified(theguess, result));
						int printbp = 0;
						
						printbp = Pegs.noofblackpegs(Bpegs); // this returns the number of black pegs
						//the white pegs function compares the Bpegs string and the guess modified string to modify the string once more.
						StringBuilder Wpegs = new StringBuilder(Pegs.whitepegs(Bpegs, guessmodified));

						int printwp = 0;
						// this final modified string is passed as a paramter and used to calculate the number ofr white pegs
						printwp = Pegs.noofwhitepegs(Wpegs);

						if (printbp == GameConfiguration.pegNumber) {
							System.out.println(theguess + " -> " + printbp + "b_" + printwp + "w");
							System.out.println("You win!");
							flag = true; // we print the no of black pegs and white pegs and if we win we set a flag
						}

						if (flag == true) { // if the flag set is true then we win and want to break out of the while
							break;
						}

						else {
							System.out.println(theguess + " -> " + printbp + "b_" + printwp + "w");
							h1.HistoryAdd(theguess, printbp, printwp);
						}// we have not won the game and output the black and white pegs of the guess, we also add the guess to the history

					}

				}

				i--;

			}
			if (flag == false) {// this is out of the while loop there are two ways to break out. by losing or by setting the flag
				System.out.println("You lose! The pattern was " + result);
			}
			// we asked to play a new game and record the response and reset the flag
			System.out.println("");
			System.out.println("Do you want to play a new game? (Y/N):");
			flag = false;
			response = console.nextLine();
			if (response.charAt(0) == 'N') {
				return;
			}

		}
	}
/**
 * This function is used to check if the guess is a valid guess.
 * @param guess is a string obtained from the user which is supposed to be a guess of the secret code 
 * @return this is true if the guess is valid and false if it is not
 */
	public static Boolean validGuess(String guess) {
		if (guess.length() != GameConfiguration.pegNumber) {
			return false;
		}
		int x = 0;
		int y = 0;
		int counter = 0;
		// this nested while loop checks if each character of the guess is part of the given colors they can guess from
		while (x < GameConfiguration.pegNumber) {
			while (y < GameConfiguration.colors.length) {
				if (guess.charAt(x) == GameConfiguration.colors[y].charAt(0)) {
					counter++;
					
				}

				y++;
			}
			y = 0;
			x++;
		}
		if (counter == GameConfiguration.pegNumber) {
			return true;
		} else {
			return false;
		}

	}
/**
 * This function is called in the beginning and welcomes the user to the game mastermind and then asks them if they want to play
 */
	public static void initialGreeting() {
		System.out.println("Welcome to Mastermind.");
		System.out.println("Do you want to play a new game? (Y/N):");

	}

}
