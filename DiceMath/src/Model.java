import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

//TODO investigate the necessity of this class. Can we merge this with dicemethods?
public class Model implements Observer{
	
	public Model() {
	}
	
	//Method for calling the view to update based on the calculated results
	public int performDiceRolling(int nDice, int nSides, int targetValue, int reRollValue) {
		ArrayList<Integer> rolledDice;
		int successFullRolls;
		
		//Roll dice and check how many were successful
		rolledDice = DiceMethods.rollNDice(nDice, nSides);
		successFullRolls = DiceMethods.successfulRolls(rolledDice, targetValue);
		
		//If rerollValue not 0 we re roll dice of value reRollValue
		if(reRollValue > 0){
			ArrayList<Integer> reRolledice = DiceMethods.reRollDiceOfV(rolledDice, reRollValue, nSides);
			int tempint = DiceMethods.successfulRolls(reRolledice, targetValue); 
			successFullRolls = successFullRolls + tempint;
		}
			return successFullRolls;
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
	
	

}
