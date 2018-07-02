import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//View
public class View implements Observer{
	
	private static int inputBarWidth = 300;
	private static Dimension inputBarSize = new Dimension(300,20);
	
	private Button rollButton;
	private JFrame frame;
	private JPanel mainPanel;
	private JLabel outPutLabel;
	
	
	public void addController(ActionListener controller){
		rollButton.addActionListener(controller);	//need instance of controller before can add it as a listener 
	} //addController(
	
		//TODO Figure out how to easily group labels and input fields
		public void createAndShowGUI() {
	        //Create and set up the window.
	        frame = new JFrame("DiceMaths");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Create and set up the main panel for the frame and set it layout
	        setupMainPanel();
	        
	    }
		
		private void setupMainPanel() {
			mainPanel= new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			 
	        //Create an input labels to put in the content pane.
	        JLabel inputLabel1 = new JLabel("Hur många tärningar vill du rulla?");
	        inputLabel1.setOpaque(true);
	        inputLabel1.setPreferredSize(inputBarSize);
	        
	        JLabel inputLabel2 = new JLabel("Hur många sidor ska de ha?");
	        inputLabel2.setOpaque(true);
	        inputLabel2.setPreferredSize(inputBarSize);
	        
	        JLabel inputLabel3 = new JLabel("Vilka värden ska rullas om?");
	        inputLabel3.setOpaque(true);
	        inputLabel3.setPreferredSize(inputBarSize);
	       
	        JLabel inputLabel4 = new JLabel("Vilket är minsta värde för lyckat kast?");
	        inputLabel3.setOpaque(true);
	        inputLabel3.setPreferredSize(inputBarSize);
	        
	        //Add input fields
	        JTextField field1 = new JTextField(50);
	        JTextField field2 = new JTextField(50);
	        JTextField field3 = new JTextField(50);
	        JTextField field4 = new JTextField(50);      
	        
	        rollButton = new Button("Rulla tärningar");  
	        rollButton.setPreferredSize(new Dimension(50,50));
	        
	        //TODO Find better object than label for showing results
	        outPutLabel = new JLabel("Antal lyckade kast: ");
	        outPutLabel.setOpaque(true);
	        outPutLabel.setPreferredSize(new Dimension(inputBarWidth, 50));
	        
	        //Add all fields and labels to the mainPanel
	        mainPanel.add(inputLabel1);
	        mainPanel.add(field1);
	        mainPanel.add(inputLabel2);
	        mainPanel.add(field2);
	        mainPanel.add(inputLabel3);
	        mainPanel.add(field3);
	        mainPanel.add(inputLabel4);
	        mainPanel.add(field4);
	        
	        //TODO Refactor into own panel below main panel. Rename input/output panel
	        mainPanel.add(rollButton);
	        mainPanel.add(outPutLabel);
	        
	        //add the mainPanel to the frame
	        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	        
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
		}

		//Sends an update with the number of successful rolls
		@Override
		public void update(Observable DiceMathsGui, Object result) {
			int tempint = ((Integer)result).intValue(); 
			outPutLabel.setText("Antal lyckade kast: " + tempint);
		}

		

	
	

}
