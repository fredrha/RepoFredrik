package DiceMaths;


public class RunDiceMaths {
	
	//Glue code that runs all components
	public RunDiceMaths() {
		Model myModel = new Model();
		View myView = new View();
		Controller myController = new Controller();
		
		myController.addModel(myModel);
		myController.addView(myView);
		myController.initModel();
		myView.addController(myController);
		
	}
	
}
