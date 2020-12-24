package com.katasWithGrace.numberUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

        //Creating the Frame
        JFrame frame = new JFrame("Number Utilities");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton accept = new JButton("accept");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(accept);

        JPanel optionsPanel = new JPanel(); // the panel is not visible in output
        JRadioButton timeRadio = new JRadioButton("Time");
        timeRadio.setSelected(true);
        JRadioButton numberRadio = new JRadioButton("Number");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(numberRadio);
        buttonGroup.add(timeRadio);
        optionsPanel.add(numberRadio);
        optionsPanel.add(timeRadio); // Components Added using Flow Layout


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, optionsPanel);
        frame.setVisible(true);

        if(timeRadio.isSelected()){
            label.setText("Enter Time");

        }


        if(numberRadio.isSelected()){
            label.setText("Enter Number");

        }


        accept.setMnemonic(KeyEvent.VK_D);


//
////        displayOutput("Welcome to our Application");
//
//        int input= Integer.parseInt(collectInputs("Type 1 for Time to Word\nType 2 for Number to word",displayBoard));
//        switch (input){
//            case 1:
//                runTimeToWordApplication(displayBoard);
//                break;
//            case 2:
//                runNumberToWordApplication(displayBoard);
//                break;
//            default:
//                displayOutput("Invalid input");
//                System.exit(0);
//                break;
//        }

    }

    public static String collectInputs(String promptMessage, JFrame component) {
        return JOptionPane.showInputDialog(component, promptMessage);
    }
    public static void runTimeToWordApplication(JFrame jFrame) {
        TimeUtil timeUtil = new TimeUtilImpl();
        String time = collectInputs("Enter Time", jFrame);
        displayOutput(timeUtil.tellTheTime(time));

    }
    public static void runNumberToWordApplication(JFrame jFrame) {
        NumberUtilities numberUtilities = new NumberUtilitiesImpl();
        String userInput = collectInputs("Enter number to convert to word", jFrame);
        displayOutput(numberUtilities.convertAnyNumberToWords(userInput));

    }

    public static void  displayOutput(String messageToOutput){
        System.out.println(messageToOutput);
//        JOptionPane.showMessageDialog(null, messageToOutput);

    }

}
