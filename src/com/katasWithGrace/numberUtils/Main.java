package com.katasWithGrace.numberUtils;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final TimeUtil timeUtil = new TimeUtilImpl();
    private  static final NumberUtilities numberUtilities = new NumberUtilitiesImpl();
    private static final JFrame frame = new JFrame("Number to Word Converter");
    private static final JPanel panel = new JPanel();
    private static final JLabel titleLabel = new JLabel("Choose Input type");
    private static final Font displayFont = new Font("Tahoma", Font.BOLD, 22);
    private static final Font componentFont = new Font("Tahoma", Font.BOLD, 14);
    private static  final Font resultFont = new Font("Tahoma", Font.BOLD, 30);
    private static  final JLabel labelForUserInputTextField = new JLabel("Enter Number");
    private static final  JTextField userInputTextField = new JTextField(20);
   private static final JLabel userResultLabel = new JLabel("");
    private static final JButton clickMeButton = new JButton("CLICK ME");
    private static final JPanel optionsPanel = new JPanel(); // the panel is not visible in output
    private static final JRadioButton timeRadio = new JRadioButton("Time");
    private static final JRadioButton numberRadio = new JRadioButton("Number");



    public static void main(String[] args) {

        initialRender();
        renderNumberDisplay();

       }
       public static void initialRender(){
           frame.setSize(720, 600);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           //creating panel components
           titleLabel.setFont(componentFont);
           userInputTextField.setFont(displayFont);



           clickMeButton.setFont(componentFont);
           labelForUserInputTextField.setFont(componentFont);
           panel.add(labelForUserInputTextField); // Components Added using Flow Layout
           panel.add(userInputTextField);
           panel.add(clickMeButton);
           panel.add(userResultLabel);
           userInputTextField.addActionListener(actionEvent -> userResultLabel.setText(""));


           timeRadio.setFont(componentFont);
           numberRadio.setFont(componentFont);
           numberRadio.setSelected(true);
           ButtonGroup buttonGroup = new ButtonGroup();

           buttonGroup.add(numberRadio);
           buttonGroup.add(timeRadio);
           optionsPanel.add(numberRadio);
           optionsPanel.add(timeRadio); // Components Added using Flow Layout
           clickMeButton.addActionListener(actionEvent -> {
               String result;
               if (timeRadio.isSelected()) {
                   try {
                       result = timeUtil.tellTheTime(userInputTextField.getText());
                       result= String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 500, result);
                   } catch (Time.InvalidTimeException invalidTimeException) {
                       result = invalidTimeException.getMessage();
                   }

               } else {
                   try {


                       result = numberUtilities.convertAnyNumberToWords(userInputTextField.getText());
                       result = String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 500, result);
                   } catch (NumberUtilitiesImpl.InvalidInputException invalidInputException) {
                       result = invalidInputException.getMessage();
                   }
               }
               userResultLabel.setText(result);

           });


           timeRadio.addActionListener(actionEvent -> {
               if (timeRadio.isSelected()) {
                   renderTimeDisplay();
               }
           });

           numberRadio.addActionListener(actionEvent -> {
               if (numberRadio.isSelected()) {
                   renderNumberDisplay();



               }
           });

           frame.getContentPane().add(BorderLayout.CENTER, panel);
           frame.getContentPane().add(BorderLayout.NORTH, optionsPanel);
           frame.setVisible(true);

       }

       public static void renderTimeDisplay(){
           labelForUserInputTextField.setText("Enter Time");
           userInputTextField.setColumns(5);
           userResultLabel.setText("");
           frame.setSize(350   , 350);
           userResultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
           userResultLabel.setBounds(2,4,200,200);


       }

    public static void renderNumberDisplay(){
        labelForUserInputTextField.setText("Enter Number");
        userInputTextField.setColumns(20);
        userResultLabel.setText("");
        frame.setSize(720, 600);
        userResultLabel.setBounds(2,4,220,900);
        userResultLabel.setFont(resultFont);

        userResultLabel.setFont(displayFont);
    }
    }

