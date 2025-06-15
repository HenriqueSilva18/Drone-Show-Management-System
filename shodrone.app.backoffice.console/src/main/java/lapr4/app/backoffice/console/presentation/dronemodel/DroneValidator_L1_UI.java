package lapr4.app.backoffice.console.presentation.dronemodel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DroneValidator_L1_UI extends JFrame {
    public DroneValidator_L1_UI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Drone Script Validator (Language 1)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Language 1 Validator UI - To be implemented");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(label, BorderLayout.CENTER);

        add(mainPanel);
    }

    public void display() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DroneValidator_L1_UI().display();
        });
    }
}
