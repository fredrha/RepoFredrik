import java.util.*;

public class DiceMethods {

/**
 * Method that rolls one dice with nSides sides.
 * @param nSides the number of sides of the dice
 * @return the value of the dice roll
 */
	public static int rollDice(int nSides) {
		Random randomno = new Random();
		if(nSides >3) {
			int tempInt = randomno.nextInt(nSides)+1;
			System.out.println(tempInt);
			return (int) tempInt;
		}
		else {
			System.out.println("nSides must be greater than 2");
			return 0;
		}
	}
	/**
	 * Method that rolls n dice of nSides sides
	 * @param n the number of dice to roll
	 * @param nSides the number of sides the dice have
	 * @return an ArrayList of dice results
	 */
	public static ArrayList<Integer> rollNDice(int n, int nSides) {
		int count = 0;
		ArrayList<Integer> diceResults = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			
			int tempInt = (int) rollDice(nSides);
			diceResults.add(tempInt);
			
			}
		return diceResults;
	}
	
	/**
	 * Method that reRolls dice of a certain value
	 * @param diceResults a list of rolled dice
	 * @param V the target value of dice that will be rerolled
	 * @param nSides the number of sides the dice have
	 * @return returns a list of re rolled dice results
	 */
	public static ArrayList<Integer> reRollDiceOfV(ArrayList<Integer> diceResults, int V, int nSides){
		int count = 0;
		
		for (int i = 0; i < diceResults.size(); i++) {
			if(diceResults.get(i) == V) {
				count = count + 1;
		
			}
		}
		System.out.println(count);
		return rollNDice(count, nSides);
	}
	
	/**
	 * Method that determines the number of results that were successful
	 * @param diceResults a list of dice results
	 * @param targetValue the value that the results must equal to or larger
	 * @return the number of successful rolls
	 */
	public static int successfulRolls(ArrayList<Integer> diceResults, int targetValue) {
		int count = 0;
	
		for (int i = 0; i < diceResults.size(); i++) {
			if(diceResults.get(i) >= targetValue) {
				count = count + 1;
				}
			}
	return count;
	}
}


