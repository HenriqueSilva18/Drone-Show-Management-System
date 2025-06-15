package lapr4.app.backoffice.console.presentation.dronemodel;

import drone_plugin.DroneValidator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DroneValidator_L1_UI extends JFrame {
    private JTextArea outputArea;
    private JTextField filePathField;

    public DroneValidator_L1_UI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Drone Script Validator (Language 1)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Painel superior com seleção de ficheiro
        JPanel topPanel = new JPanel(new BorderLayout(5, 0));
        filePathField = new JTextField();
        filePathField.setEditable(false);
        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener((ActionEvent e) -> browseFile());
        topPanel.add(filePathField, BorderLayout.CENTER);
        topPanel.add(browseButton, BorderLayout.EAST);

        JButton validateButton = new JButton("Validate Script");
        validateButton.addActionListener((ActionEvent e) -> validateScript());

        topPanel.add(validateButton, BorderLayout.SOUTH);

        // Área de output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Montar os painéis
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void browseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            filePathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void validateScript() {
        String filePath = filePathField.getText();
        if (filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a script file first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        outputArea.setText("Validating script...\n");
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                outputArea.append("Error: File does not exist.\n");
                return;
            }

            try {
                // Validação (sem geração de código para L1)
                DroneValidator.validate(path);
                outputArea.append(" Script is valid!\n");

            } catch (RuntimeException e) {
                outputArea.append(" Validation failed:\n");
                outputArea.append(e.getMessage() + "\n");
            }
        } catch (IOException e) {
            outputArea.append("Error reading file: " + e.getMessage() + "\n");
        }
    }

    public void display() {
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DroneValidator_L1_UI().display());
    }
}
