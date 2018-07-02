import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	Model model;
	View view;
	
	public Controller(){
		//System.out.println("Controller");
	}
	
	
	public void addModel(Model m){
		this.model = m;
	} //addModel()

	public void addView(View v){
		this.view = v;
	} //addView()
	
	//Starts the model
	public void initModel() {
		model.start();
	}

	//Listen to the buttonpress
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO refactor ints
		int nDice = 0;
		int nSides = 0;
		int targetValue = 0;
		int reRollValue = 0;
		
		//Get the input strings from the view and parse to integers
		//TODO handle other errors
		try {
		nDice = Integer.parseInt(view.field1.getText());
		nSides = Integer.parseInt(view.field2.getText());
		reRollValue = Integer.parseInt(view.field3.getText());
		targetValue = Integer.parseInt(view.field4.getText());
		}
		catch(Exception e1){
			System.out.println("Input was not correct");
		}
		
		System.out.println("Rullar " + nDice +" Tärningar");
		
		int successfulRolls = model.performDiceRolling(nDice, nSides, targetValue, reRollValue);
		view.showResults(successfulRolls);
	}

}
