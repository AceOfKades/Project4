//needed for GUI
import javax.swing.*;
import java.awt.*;
import java.util.Map;

//Logic for drawing images

//I will be so honest, I consulted the dark forces on this one. This is almost all copy-pasted with updated variable names.
public class PursePanel extends JPanel {
    private Purse purse;

    // JPanel to hold the image labels
    private JPanel imagePanel;

    public PursePanel() {
        // Set the layout of the PursePanel
        setLayout(new BorderLayout());

        // Create a new JPanel to hold the image labels
        imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.setBackground(Color.gray);

        // Add the imagePanel to the PursePanel
        add(imagePanel, BorderLayout.CENTER);
    }

    // Method to set the Purse
    public void setPurse(Purse purse) {
        this.purse = purse;
        updateImages();  // Update images whenever the purse is set
    }

    // Update the displayed images and text
    private void updateImages() {
        // Clear the current content in the imagePanel
        imagePanel.removeAll();

        // Add a new label for each denomination in the purse
        if (purse == null || purse.cash.isEmpty()) {
            imagePanel.add(new JLabel("Empty Purse"));
        } else {
            for (Map.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
                Denomination denom = entry.getKey();
                int count = entry.getValue();

                // Load the image for this denomination
                ImageIcon icon = new ImageIcon(denom.img());
                JLabel imgLabel = new JLabel(icon);
                imgLabel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Align image to the left

                // Create a label to display the denomination name and count
                JLabel textLabel = new JLabel(denom.name() + ": x" + count);
                textLabel.setAlignmentX(Component.LEFT_ALIGNMENT);  // Align text to the left

                // Add both the image and the text label to the imagePanel
                imagePanel.add(imgLabel);
                imagePanel.add(textLabel);
            }
        }

        // Revalidate the layout and repaint the panel to reflect the changes
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // No need to manually draw the images here, as the layout manager handles it.
    }
}
