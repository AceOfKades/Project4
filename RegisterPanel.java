//GUI Panel for Register

//needed for GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    //object declarations
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    RegisterPanel() { //Panel logic
        input = new JTextField(16); //input box
        register = Register.getInstance();  //for using Register logic
        inputPanel = new JPanel();  //panel for holding input
        changePanel = new PursePanel(); //for using purse and draw logic

        input.addActionListener(new InputListener()); // shh, listen closely

        inputPanel.add(input);  //add input text to input panel
        inputPanel.setPreferredSize(new Dimension(500, 100));   //setting size

        changePanel.setBackground(Color.gray);  //setting PursePanel background to grey (for differentiation
        changePanel.setPreferredSize(new Dimension(800, 800));  //setting size

        this.add(inputPanel);   //add input panel to register frame
        this.add(changePanel);  //add change panel to register frame

    }
    public class InputListener implements ActionListener {  //are you listening? (pick up on specific actions)

        public void actionPerformed(ActionEvent e) {    //what happens when the action is triggered?
            String text = input.getText();  //translate input in box to String
            double amt; //double, for converting strings
            try
            {
                amt = Double.parseDouble(text); //try to turn the String conversion from input into a double...
            }
            catch(Exception InputMismatchException) // if that doesn't work,
            {
                amt = 0.0;  // set to 0.
            }
            changePanel.setPurse(register.makeChange(amt)); //and now update the purse panel with the parsed double.
        }
    }
}

