package com.katasWithGrace.numberUtils;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final TimeUtil timeUtil = new TimeUtilImpl();
    private  static final NumberUtilities numberUtilities = new NumberUtilitiesImpl();
    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final Font displayFont = new Font("Tahoma", Font.BOLD, 22);
    private static final Font componentFont = new Font("Tahoma", Font.BOLD, 14);
    private static  final Font resultFont = new Font("Tahoma", Font.BOLD, 30);
    private static  final JLabel labelForUserInputTextField = new JLabel("Enter Number");
    private static final  JTextField userInputTextField = new JTextField(20);
   private static final JLabel userResultLabel = new JLabel("");
    private static final JButton clickMeButton = new JButton("CLICK ME");
    private static final JPanel optionsPanel = new JPanel(); // the panel is not visible in output
    private static final JRadioButton timeRadio = new JRadioButton("What is the Time Application");
    private static final JRadioButton numberRadio = new JRadioButton("Number to Word Application");
    private static final JRadioButton whatIsTheTime = new JRadioButton("What is the current Time?");

    private static final ButtonGroup buttonGroup = new ButtonGroup();



    public static void main(String[] args) {

        initialRender();
        renderNumberDisplay();

       }
       public static void initialRender(){
           frame.setSize(720, 600);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           //creating panel components
           userInputTextField.setFont(displayFont);



           clickMeButton.setFont(componentFont);
           labelForUserInputTextField.setFont(componentFont);
           panel.add(labelForUserInputTextField); // Components Added using Flow Layout
           panel.add(userInputTextField);
           panel.add(clickMeButton);
           panel.add(userResultLabel);
           timeRadio.setFont(componentFont);
           numberRadio.setFont(componentFont);
           whatIsTheTime.setFont(componentFont);
           numberRadio.setSelected(true);

           buttonGroup.add(numberRadio);
           buttonGroup.add(timeRadio);
           buttonGroup.add(whatIsTheTime);
           optionsPanel.add(numberRadio);
           optionsPanel.add(whatIsTheTime);
           optionsPanel.add(timeRadio); // Components Added using Flow Layout
           clickMeButton.addActionListener(actionEvent -> {
               String result = null;
               if (timeRadio.isSelected()) {
                   try {
                       result = timeUtil.tellTheTime(userInputTextField.getText());
                       result= String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 500, result);
                   } catch (Time.InvalidTimeException invalidTimeException) {
                       result = invalidTimeException.getMessage();
                   }

               }
               if(whatIsTheTime.isSelected()){
                   result = timeUtil.greetUser() +"\n";
                   result =result+ "\n"+ timeUtil.whatIsTheCurrentTime();
               }
               if(numberRadio.isSelected()){
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

           whatIsTheTime.addActionListener(actionEvent -> {
               if(whatIsTheTime.isSelected()){
                   renderWhatIsTheTimeDisplay();
               }
           });

           frame.getContentPane().add(BorderLayout.CENTER, panel);
           frame.getContentPane().add(BorderLayout.NORTH, optionsPanel);
           frame.setVisible(true);

       }

    private static void renderWhatIsTheTimeDisplay() {
        labelForUserInputTextField.setText("Enter Time");
        labelForUserInputTextField.setVisible(false);
        clickMeButton.setText("What is the Time?");
        userInputTextField.setVisible(false);
        frame.setTitle("Clock Application");
        userInputTextField.setColumns(5);
        userResultLabel.setText("");
        frame.setSize(350   , 350);
        userResultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        userResultLabel.setBounds(2,4,200,200);
        timeRadio.setVisible(true);
        whatIsTheTime.setVisible(false);
        numberRadio.setVisible(true);
    }

    public static void renderTimeDisplay(){
           labelForUserInputTextField.setText("Enter Time");
           frame.setTitle("What is the Time Application");
           userInputTextField.setColumns(5);
           userInputTextField.setVisible(true);
           userResultLabel.setText("");
           frame.setSize(350   , 350);
           userResultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
           userResultLabel.setBounds(2,4,200,200);
           timeRadio.setVisible(false);
           whatIsTheTime.setVisible(true);
           numberRadio.setVisible(true);


       }

    public static void renderNumberDisplay(){
        frame.setTitle("Numbers to Words Application");
        labelForUserInputTextField.setText("Enter Number");
        userInputTextField.setColumns(20);
        userInputTextField.setVisible(true);
        userResultLabel.setText("");
        frame.setSize(720, 600);
        userResultLabel.setBounds(2,4,220,900);
        userResultLabel.setFont(resultFont);

        userResultLabel.setFont(displayFont);
        timeRadio.setVisible(true);
        whatIsTheTime.setVisible(true);
        numberRadio.setVisible(false);
    }
    }

