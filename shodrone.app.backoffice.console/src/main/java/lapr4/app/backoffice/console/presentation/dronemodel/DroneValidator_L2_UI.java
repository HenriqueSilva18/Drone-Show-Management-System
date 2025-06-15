//package lapr4.app.backoffice.console.presentation.dronemodel;
//
//import drone_plugin.DroneLanguagePlugin;
//import drone_plugin.DroneValidator;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//public class DroneValidator_L2_UI extends JFrame {
//    private JTextArea outputArea;
//    private JTextField filePathField;
//    private JComboBox<String> droneModelComboBox;
//    private DroneLanguagePlugin plugin;
//
//    public DroneValidator_L2_UI() {
//        plugin = new DroneLanguagePlugin();
//        initializeUI();
//    }
//
//    private void initializeUI() {
//        setTitle("Drone Script Validator");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600);
//        setLocationRelativeTo(null);
//
//        // Create main panel with padding
//        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
//        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        // Create top panel for file selection and validation
//        JPanel topPanel = new JPanel(new BorderLayout(5, 0));
//
//        // File selection panel
//        JPanel filePanel = new JPanel(new BorderLayout(5, 0));
//        filePathField = new JTextField();
//        filePathField.setEditable(false);
//        JButton browseButton = new JButton("Browse");
//        browseButton.addActionListener((ActionEvent e) -> browseFile());
//        filePanel.add(filePathField, BorderLayout.CENTER);
//        filePanel.add(browseButton, BorderLayout.EAST);
//
//        // Drone model selection
//        JPanel modelPanel = new JPanel(new BorderLayout(5, 0));
//        modelPanel.add(new JLabel("Drone Model: "), BorderLayout.WEST);
//        droneModelComboBox = new JComboBox<>(plugin.getRegisteredDroneModels().toArray(new String[0]));
//        modelPanel.add(droneModelComboBox, BorderLayout.CENTER);
//
//        // Validation button
//        JButton validateButton = new JButton("Validate Script");
//        validateButton.addActionListener((ActionEvent e) -> validateScript());
//
//        // Add components to top panel
//        topPanel.add(filePanel, BorderLayout.CENTER);
//        topPanel.add(modelPanel, BorderLayout.EAST);
//        topPanel.add(validateButton, BorderLayout.SOUTH);
//
//        // Create output area
//        outputArea = new JTextArea();
//        outputArea.setEditable(false);
//        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
//        JScrollPane scrollPane = new JScrollPane(outputArea);
//
//        // Add components to main panel
//        mainPanel.add(topPanel, BorderLayout.NORTH);
//        mainPanel.add(scrollPane, BorderLayout.CENTER);
//
//        // Add main panel to frame
//        add(mainPanel);
//    }
//
//    private void browseFile() {
//        JFileChooser fileChooser = new JFileChooser();
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            filePathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
//        }
//    }
//
//    private void validateScript() {
//        String filePath = filePathField.getText();
//        if (filePath.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please select a script file first.", "Error",
//                    JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        outputArea.setText("Validating script...\n");
//        try {
//            Path path = Paths.get(filePath);
//            if (!Files.exists(path)) {
//                outputArea.append("Error: File does not exist.\n");
//                return;
//            }
//
//            // Validate the script
//            try {
//                DroneValidator.validate(path);
//                outputArea.append(" Script is valid!\n");
//
//                // Generate code for the selected drone model
//                String selectedModel = (String) droneModelComboBox.getSelectedItem();
//                if (selectedModel != null) {
//                    String generatedCode = plugin.generateCode(path, selectedModel);
//                    outputArea.append("\nGenerated code for " + selectedModel + ":\n");
//                    outputArea.append("----------------------------------------\n");
//                    outputArea.append(generatedCode);
//                }
//            } catch (RuntimeException e) {
//                outputArea.append(" Validation failed:\n");
//                outputArea.append(e.getMessage() + "\n");
//            }
//        } catch (IOException e) {
//            outputArea.append("Error reading file: " + e.getMessage() + "\n");
//        }
//    }
//    public void display() {
//        setVisible(true);
//    }
//}
