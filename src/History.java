package mastermind;

import java.util.*;

public class History {
	
				ArrayList<String> HistoryList = new ArrayList<String>();
			/**
			 * This functions adds the guess, the number of white pegs and the number of black pegs to the history list of guess
			 * @param guess is the String the user guesses
			 * @param blackpegs is the number of black pegs
			 * @param whitepegs is the number of white pegs
			 */
			public void HistoryAdd(String guess, int blackpegs, int whitepegs){
				String Concat = (guess+ " -> "+blackpegs+"b_"+whitepegs+"w");
				HistoryList.add(Concat);
				
				
				
			}
			/**
			 * This function prints the history array list so the user can see all the guesses he guessed and the feedback pegs as well
			 */
			public void PrintHistory(){
				for(String his : HistoryList){
					System.out.println(his);
				}
				
			}
}
