import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//View
public class View{
	
	private static int inputBarWidth = 300;
	private static Dimension inputBarSize = new Dimension(300,20);
	
	private Button rollButton;
	private JFrame frame;
	private JPanel mainPanel;
	private JLabel outPutLabel;
	private JLabel outPutLabel2;
	private JPanel diceSelectLayout;
	private JButton[] diceButtonList;
	
	//TODO rename field appropriately
	public JTextField field1;
	public JTextField field3;
	public JTextField field4;
	private int selectedDice = 0;
	
	
	public void addController(ActionListener controller){
		rollButton.addActionListener(controller);	//need instance of controller before can add it as a listener 
	} //addController(
	
		//TODO Figure out how to easily group labels and input fields
		public View() {
	        //Create and set up the window.
	        frame = new JFrame("DiceMaths");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Create and set up the main panel for the frame and set it layout
	        setupMainPanel();
	        
	    }
		
		private void setupMainPanel() {
			mainPanel= new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			 
	        //Create and add input label and input bar for the amount of dice to roll
	        JLabel inputLabel1 = new JLabel("Hur många tärningar vill du rulla?");
	        inputLabel1.setOpaque(true);
	        inputLabel1.setPreferredSize(inputBarSize); 
	        field1 = new JTextField(50);
	        mainPanel.add(inputLabel1);
	        mainPanel.add(field1);
	        
	      //Create and add input label and selectDicelayout for selecting the type of dice
	        JLabel inputLabel2 = new JLabel("Hur många sidor ska de ha?");
	        inputLabel2.setOpaque(true);
	        inputLabel2.setPreferredSize(inputBarSize);
	        diceSelectLayout = createButtonRow(4);
	        mainPanel.add(inputLabel2);
	        mainPanel.add(diceSelectLayout);
	        
	        //Create and add input label and input bar for what values to re roll
	        JLabel inputLabel3 = new JLabel("Vilka värden ska rullas om?");
	        inputLabel3.setOpaque(true);
	        inputLabel3.setPreferredSize(inputBarSize);
	        field3 = new JTextField(50);
	        mainPanel.add(inputLabel3);
	        mainPanel.add(field3);
	       
	        //Create and add input label and input bar for what value is necessary for success
	        JLabel inputLabel4 = new JLabel("Vilket är minsta värde för lyckat kast?");
	        inputLabel3.setOpaque(true);
	        inputLabel3.setPreferredSize(inputBarSize);
	        field4 = new JTextField(50);      
	        mainPanel.add(inputLabel4);
	        mainPanel.add(field4);
	        
	        //Add button for rolling dice
	        rollButton = new Button("Rulla tärningar");  
	        rollButton.setPreferredSize(new Dimension(50,50));
	        mainPanel.add(rollButton);
	        
	        //TODO Find better object than label for showing results
	        outPutLabel = new JLabel("Antal lyckade kast: ");
	        outPutLabel.setOpaque(true);
	        outPutLabel.setPreferredSize(new Dimension(inputBarWidth, 50));
	        mainPanel.add(outPutLabel);
	        
	        outPutLabel2 = new JLabel("Lyckade resultat: ");
	        outPutLabel2.setOpaque(true);
	        outPutLabel2.setPreferredSize(new Dimension(inputBarWidth, 50));
	        mainPanel.add(outPutLabel2);
	        
	        //add the mainPanel to the frame
	        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
	        
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
		}
		
		
		private JPanel createButtonRow(int nButtons) {
			JPanel buttonPanel = new JPanel();
			diceButtonList = new JButton[nButtons];
			int nSides = 4;
			for (int i = 0; i < nButtons; i++){
	            
	            	JButton button = new JButton(Integer.toString(nSides));
	            	nSides = nSides + 2;
	            	diceButtonList[i] = button;
	            
	            	button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							selectedDice = Integer.parseInt(button.getText());
							for(JButton b:diceButtonList) {
								b.setEnabled(true);
								button.setEnabled(false);
							}
						}	
	            	});
	            	buttonPanel.add(button);  
	        }
			return buttonPanel;
			
		}
		
		public int getSelecteDice() {
			return selectedDice;
		}
		
		public void showResults(int successfulRolls) {
			outPutLabel.setText("Antal lyckade kast: " + successfulRolls);
		}

		public void showResultsList(ArrayList<Integer> successfulRollsList) {
			outPutLabel2.setText("Lyckade resultat: " + successfulRollsList);
			
		}
		

}
