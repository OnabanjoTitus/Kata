package com.katasWithGrace.numberUtils;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        TimeUtil timeUtil = new TimeUtilImpl();
        NumberUtilities numberUtilities = new NumberUtilitiesImpl();


        //Creating the Frame
        JFrame frame = new JFrame("Number Utilities");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 600);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel();

        //creating panel components
        Font displayFont = new Font("Tahoma", Font.BOLD, 19);
        JLabel label = new JLabel("Enter Time");
        JTextField userInput = new JTextField(25);
        userInput.setFont(displayFont);
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(2,4,220,700);
        resultLabel.setFont(displayFont);

        JButton accept = new JButton("accept");
        panel.add(label); // Components Added using Flow Layout
        panel.add(userInput);
        panel.add(accept);
        panel.add(resultLabel);
        userInput.addActionListener(actionEvent -> resultLabel.setText(""));

        JPanel optionsPanel = new JPanel(); // the panel is not visible in output
        JRadioButton timeRadio = new JRadioButton("Time");
        timeRadio.setSelected(true);
        JRadioButton numberRadio = new JRadioButton("Number");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(numberRadio);
        buttonGroup.add(timeRadio);
        optionsPanel.add(numberRadio);
        optionsPanel.add(timeRadio); // Components Added using Flow Layout
        accept.addActionListener(actionEvent -> {
            String result = "";
            if (timeRadio.isSelected()) {
                try {
                    result = timeUtil.tellTheTime(userInput.getText());
                   result= String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 500, result);
                } catch (Time.InvalidTimeException invalidTimeException) {
                    result = invalidTimeException.getMessage();
                }

            } else {
                try {


                    result = numberUtilities.convertAnyNumberToWords(userInput.getText());
                    result = String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 500, result);
                } catch (NumberUtilitiesImpl.InvalidInputException invalidInputException) {
                    result = invalidInputException.getMessage();
                }
            }
            resultLabel.setText(result);

        });


        timeRadio.addActionListener(actionEvent -> {
            if (timeRadio.isSelected()) {
                label.setText("Enter Time");
                resultLabel.setText("");

            }

        });

        numberRadio.addActionListener(actionEvent -> {
            if (numberRadio.isSelected()) {
                label.setText("Enter Number");
                resultLabel.setText("");

            }
        });
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, optionsPanel);
        frame.setVisible(true);
       }
    }

