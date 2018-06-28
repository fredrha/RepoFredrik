import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
       /* // TODO create error handlers for inputs
		String inputNumberOfDice = JOptionPane.showInputDialog("How many dice to roll?");
		String inputNumberOfSides = JOptionPane.showInputDialog("How many sides should the dice have?");
		String InputReRollValue = JOptionPane.showInputDialog("What value do we reroll?");
		String InputTargetValue = JOptionPane.showInputDialog("What is the target value?");

       
        int numberOfDice = Integer.parseInt(inputNumberOfDice);
        int numberOfSides = Integer.parseInt(inputNumberOfSides);
        int reRollValue = Integer.parseInt(InputReRollValue);
        int targetValue = Integer.parseInt(InputTargetValue);
        
        //If we only want to roll one die call rollDice directly
        if(numberOfDice == 1) {
        	DiceMethods.rollDice(numberOfSides);
        	
        }
        //If we want to roll multiple die call rollNDice
        else {
        	ArrayList<Integer> resultList = DiceMethods.rollNDice(numberOfDice, numberOfSides);
        	int tempInt = DiceMethods.successfulRolls(resultList, targetValue);
        	System.out.println("The number of successful rolls were " + tempInt);
        }
        */
		
	}
	//TODO refactor all values used for defining dimensions of GUI into variables
	//TODO Figure out how to easily group labels and input fields
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the main panel for the frame and set it layout
        createMainPanel(frame);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	private static void createMainPanel(JFrame frame) {
		
		JPanel mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
 
        //Create an input labels to put in the content pane.
        JLabel inputLabel1 = new JLabel("Hur många tärningar vill du rulla?");
        inputLabel1.setOpaque(true);
        inputLabel1.setPreferredSize(new Dimension(500, 20));
        
        JLabel inputLabel2 = new JLabel("Hur många sidor ska de ha?");
        inputLabel2.setOpaque(true);
        inputLabel2.setPreferredSize(new Dimension(500, 20));
        
        JLabel inputLabel3 = new JLabel("Vilka värden ska rullas om?");
        inputLabel3.setOpaque(true);
        inputLabel3.setPreferredSize(new Dimension(500, 20));
       
        JLabel inputLabel4 = new JLabel("Vilket är minsta värde för lyckat kast?");
        inputLabel3.setOpaque(true);
        inputLabel3.setPreferredSize(new Dimension(500, 20));
        
        //Add input fields
        JTextField field1 = new JTextField(50);
        JTextField field2 = new JTextField(50);
        JTextField field3 = new JTextField(50);
        JTextField field4 = new JTextField(50);
        
        Button rollButton = new Button();
        rollButton.setLabel("Rulla tärningar");
        
        
        //Add all fields and labels to the mainPanel
        mainPanel.add(inputLabel1);
        mainPanel.add(field1);
        mainPanel.add(inputLabel2);
        mainPanel.add(field2);
        mainPanel.add(inputLabel3);
        mainPanel.add(field3);
        mainPanel.add(inputLabel4);
        mainPanel.add(field4);
        mainPanel.add(rollButton);
        
        //add the mainPanel to the frame
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
	}
	
	

}
