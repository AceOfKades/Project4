
//Driver for GUI

//Needed for GUI
import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] args){
        JFrame frame = new JFrame("MakingChange"); // title of container JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //operation of x button

        RegisterPanel panel = new RegisterPanel();  //add a register panel to container
        panel.setPreferredSize(new Dimension(1000, 1000));  //set size

        //make that thang work
        frame.getContentPane().add(panel);
        frame.pack();

        frame.setVisible(true);
    }
}
