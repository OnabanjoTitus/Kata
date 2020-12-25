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
    private static  final JLabel labelForUserInputTextField = new JLabel();
    private static final  JTextField userInputTextField = new JTextField(20);
    private static final JLabel userResultLabel = new JLabel();
    private static final JButton clickMeButton = new JButton();
    private static final JPanel optionsPanel = new JPanel(); // the panel is not visible in output
    private static final JRadioButton timeRadio = new JRadioButton("What is the Time");
    private static final JRadioButton numberRadio = new JRadioButton("Number to Word");
    private static final JRadioButton whatIsTheTime = new JRadioButton("Check current Time?");

    private static final ButtonGroup buttonGroup = new ButtonGroup();

    private static void setComponentText(String applicationTitle, String clickMeButtonText, String labelForInputField){
        frame.setTitle(applicationTitle);
        clickMeButton.setText(clickMeButtonText);
        labelForUserInputTextField.setText(labelForInputField);
        userResultLabel.setText("");

    }

    private static void makeComponentsVisible(boolean makeVisible, Component... components){
        for (Component component : components) {
            component.setVisible(makeVisible);
        }
    }

    public static void main(String[] args) {

        initialRender();
        renderNumberDisplay();

    }
    public static void initialRender(){
        //frame.setSize(720, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                    result= String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 100, result);
                } catch (Time.InvalidTimeException invalidTimeException) {
                    result = invalidTimeException.getMessage();
                }

            }
            if(whatIsTheTime.isSelected()){
//                result = String.format("%s%n%s", timeUtil.greetUser(), timeUtil.whatIsTheCurrentTime() );
                result = timeUtil.greetUser() + "<br/>"+ timeUtil.whatIsTheCurrentTime();
                result= String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 150, result);
                makeComponentsVisible(false, clickMeButton);
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
        frame.getContentPane().add(BorderLayout.PAGE_END, optionsPanel);
        frame.setVisible(true);

    }

    private static void renderWhatIsTheTimeDisplay() {
        setComponentText("Clock Application", "What is the Time", "Enter Time");
        makeComponentsVisible(false, labelForUserInputTextField, userInputTextField, whatIsTheTime);
        userInputTextField.setColumns(5);
        frame.setSize(350   , 350);
        userResultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        userResultLabel.setBounds(2,4,200,200);
        makeComponentsVisible(true, numberRadio, clickMeButton);
    }

    public static void renderTimeDisplay(){
        labelForUserInputTextField.setText("Enter Time");
        frame.setTitle("What is the Time Application");
        clickMeButton.setText("Get Time");
        userInputTextField.setColumns(5);
        userResultLabel.setText("");
        frame.setSize(350   , 350);
        userResultLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        userResultLabel.setBounds(2,4,200,200);
        timeRadio.setVisible(false);

        makeComponentsVisible(true, whatIsTheTime,numberRadio, userInputTextField, clickMeButton);


    }

    public static void renderNumberDisplay(){
        setComponentText("Number to Words Application", "Get Words", "Enter Number");
        userInputTextField.setColumns(20);
        makeComponentsVisible(true, timeRadio,whatIsTheTime, userInputTextField, clickMeButton);
        makeComponentsVisible(false, numberRadio);
        frame.setSize(720, 600);
        userResultLabel.setBounds(2,4,220,900);
        userResultLabel.setFont(resultFont);

        userResultLabel.setFont(displayFont);

    }
}

