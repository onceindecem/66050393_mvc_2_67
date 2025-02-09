package mvc_2_67.View;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc_2_67.Controller.SuperheroSuitController;

public class SuperheroSuitView extends JFrame {
    private JTextField idField;
    private JTextArea outputArea;
    private JButton repairButton;
    private SuperheroSuitController controller;

    public SuperheroSuitView() {
        Font thaiFont = new Font("Tahoma", Font.PLAIN, 16); // enable thai font
        setTitle("Superhero Suit Checker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Center the window on the screen
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter Suit ID: "));

        idField = new JTextField(10);
        inputPanel.add(idField);

        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new CheckSuitButtonListener());
        inputPanel.add(checkButton);

        add(inputPanel, BorderLayout.NORTH);
        
        repairButton = new JButton("Repair");
        repairButton.setEnabled(false);
        repairButton.addActionListener(new RepairSuitListener());
        add(repairButton, BorderLayout.SOUTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        outputArea.setFont(thaiFont);
        outputArea.setText("Total Power Suit are Reapaired : 0\n" + "Total Stealth Suit are Reapaired : 0\n" + "Total Conceal Suit are Reapaired : 0\n");
    }

    // when submit button is pressed
    private class CheckSuitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = idField.getText();
            if (controller != null) {
                controller.checkSuit(id);
            }
        }
    }

    // enable the repair button when the suit needs repair
    public void needRepair(boolean checkIfNeedRepair) {
        repairButton.setEnabled(checkIfNeedRepair);
    }

    private class RepairSuitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (controller != null) {
                controller.repairSuit();
            }
            repairButton.setEnabled(false);
        }
    }

    public void displayResult(String output) {
        outputArea.setText(output); // Update the result area with the output string
    }

    public void clearInput() {
        idField.setText(""); // Clear the text in the input field
    }

    public void setController(SuperheroSuitController controller) {
        this.controller = controller; // Assign the controller to the view
    }
}
