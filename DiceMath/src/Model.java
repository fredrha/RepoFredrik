import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

//TODO investigate the necessity of this class. Can we merge this with dicemethods?
public class Model implements Observer{
	private int successfulRolls;
	private ArrayList<Integer> successfulRollsList;
	private ArrayList<Integer> failedRollsList;
	
	
	public Model() {
	}
	
	//Method for calling the view to update based on the calculated results
	public void performDiceRolling(int nDice, int nSides, int targetValue, int reRollValue) {
		ArrayList<Integer> rolledDice;
		
		
		//Roll dice and check how many were successful
		rolledDice = DiceMethods.rollNDice(nDice, nSides);
		successfulRolls = DiceMethods.successfulRolls(rolledDice, targetValue);
		successfulRollsList = DiceMethods.successfulRollsList(rolledDice, targetValue);
		
		//If rerollValue not 0 we re roll dice of value reRollValue
		if(reRollValue > 0){
			ArrayList<Integer> reRolledice = DiceMethods.reRollDiceOfV(rolledDice, reRollValue, nSides);
			//Check how many rolls were successful and add to succesFulRolls
			int tempint = DiceMethods.successfulRolls(reRolledice, targetValue); 
			successfulRolls = successfulRolls + tempint;
			//add a list of the successful rerolls to the list of successful rolls
			ArrayList<Integer> tempList = DiceMethods.successfulRollsList(rolledDice, targetValue);
			successfulRollsList.addAll(tempList);
		}
			//return successFullRolls;
	}
	
	public void start() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
        }
    });
}

	@Override
	public void update(Observable o, Object arg) {
			
	}
	
	public int getSuccessfulRolls() {
		return successfulRolls;
	}
	
	public ArrayList<Integer> getSuccessfulRollsList() {
		return successfulRollsList;
	}
	
	

}
