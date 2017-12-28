
package mastermind;
import java.util.*;


public class Pegs {
/**
 * This function takes the guess and the secret code and modifies a copy of the secret code by replacing 
 * the positions where the guess and the secretcopy are the same color  with a dash
 * @param guess is a string of what pattern of colors the user guessed
 * @param secretcode is the secret code string
 * @return we return the StringBuilder of the modified secretcode
 */
	public static StringBuilder Blackpegs(String guess,String secretcode){
		
		StringBuilder Secretcpy = new StringBuilder(secretcode);
		StringBuilder guesses = new StringBuilder(guess);
		int i=0;
		char dash = '-';
		while(i<GameConfiguration.pegNumber){
			
			if(guesses.charAt(i)==Secretcpy.charAt(i)){ // we check the index of the secret code and guess to see if they are the same character
				Secretcpy.setCharAt(i,dash); //  replaces the char with a "-" where they are equal
				guesses.setCharAt(i, dash);
				i++;
				
			}
			else{
				i++;
			}
			
			
			
		}
		
		return Secretcpy;
		
	}
	
	/**
	 * This function takes the guess and the secret code and modifies the guess by replacing 
	 * the positions where the guess and the secretcopy are the same color with a "-"
	 * @param guess is a string of what pattern of colors the user guessed
	 * @param secretcode is the secret code string
	 * @return we return the StringBuilder of the modified guess
	 */
public static StringBuilder guessmodified(String guess,String secretcode){
		
		StringBuilder Secretcpy = new StringBuilder(secretcode);
		StringBuilder guesses = new StringBuilder(guess);
		int i=0;
		char dash = '-';
		while(i<GameConfiguration.pegNumber){
			
			if(guesses.charAt(i)==Secretcpy.charAt(i)){// we check the index of the secret code and guess to see if they are the same character
				Secretcpy.setCharAt(i,dash);
				guesses.setCharAt(i, dash);//  replaces the char with a "-" where they are equal
				i++;
				
			}
			else{
				i++;
			}
			
			
			
		}
		
		return guesses;
		
	}
	
	
	
	/**
	 * This counts the no of black pegs by counting the number of dashes in the string
	 * @param secretcode is a StringBuilder that is modified version of the secretcode
	 * @return this returns the number of blackpegs
	 */
	public static int noofblackpegs(StringBuilder secretcode){
		
		int i=0;
		int counter=0;
		while(i<GameConfiguration.pegNumber){
			if(secretcode.charAt(i)=='-'){
				counter++;
			}
			i++;
		}
		
		return counter;
		
	}
	
	
	/**
	 * This functions takes the modified version of the guess and the modified version of the secretcode and compares them to see 
	 * any colors of the guess are in the secretcode and replaces that position of the respective StringBuilders with a "/"
	 * @param guesses is the modified version of the guess
	 * @param Secretcode is the modified version of the Secretcode
	 * @return this returns the newly modified Secretcopy 
	 */
	public static StringBuilder whitepegs(StringBuilder guesses, StringBuilder Secretcode){
		
		//StringBuilder guesses = new StringBuilder(guess);
		char slash='/';
		int p=0;
		int q=0;
		
		while(p<GameConfiguration.pegNumber){
			if(guesses.charAt(p)=='-'){
				p++;
			}
			q=0;
			while(q<GameConfiguration.pegNumber && p<GameConfiguration.pegNumber){
				
				if(Secretcode.charAt(q)=='-'){
					q++;
				}
				
				else if(Secretcode.charAt(q)=='/'){
					q++;
				}
				else if (guesses.charAt(p)==Secretcode.charAt(q)){
					guesses.setCharAt(p,slash);
					Secretcode.setCharAt(q,slash);
					q=GameConfiguration.pegNumber;
				}
				else{q++;}
				
			}
			
			
			p++;
			
		}
		return Secretcode;
	}
	
	/**
	 * This functions counts the number of "/" which is the number of white pegs
	 * @param secretcode is the modified version of the secret which is replaced with "/" to count the number of white pegs
	 * @return this returns the number of white pegs
	 */
public static int noofwhitepegs(StringBuilder secretcode){
		
		int i=0;
		int counter=0;
		while(i<GameConfiguration.pegNumber){
			if(secretcode.charAt(i)=='/'){
				counter++;
				//System.out.print(counter);
			}
			i++;
		}
		
		return counter;
		
	}
	
	
	
	
}
