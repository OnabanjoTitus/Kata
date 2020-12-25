package com.katasWithGrace.numberUtils;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final TimeUtil timeUtil = new TimeUtilImpl();
    private  static final NumberUtilities numberUtilities = new NumberUtilitiesImpl();
    private static final JFrame APPLICATION_MAIN_WINDOW = new JFrame();
    private static final JPanel USER_INPUT_AND_OUTPUT_DISPLAY_PANEL = new JPanel();
    private static final Font TIME_RESULT_FONT = new Font("Tahoma", Font.BOLD, 30);
    private static final Font APPLICATION_COMPONENTS_FONT = new Font("Tahoma", Font.BOLD, 12);
    private static  final Font NUMBER_TO_WORD_FONT = new Font("Tahoma", Font.BOLD, 45);
    private static  final JLabel LABEL_FOR_USER_INPUT_TEXT_FIELD = new JLabel();
    private static final  JTextField USER_INPUT_TEXT_FIELD = new JTextField(15);
    private static final JLabel USER_RESULT_LABEL = new JLabel();
    private static final JButton CLICK_ME_BUTTON = new JButton();
    private static final JPanel RADIO_BUTTONS_PANEL = new JPanel(); // the panel is not visible in output
    private static final JRadioButton WHAT_IS_THE_TIME_RADIO = new JRadioButton("What is the Time");
    private static final JRadioButton NUMBER_TO_WORD_RADIO = new JRadioButton("Number to Word");
    private static final JRadioButton WHAT_IS_THE_CURRENT_TIME_RADIO = new JRadioButton("Check current Time?");

    private static final ButtonGroup buttonGroup = new ButtonGroup();

    private static void setComponentText(String applicationTitle, String clickMeButtonText, String labelForInputField){
        APPLICATION_MAIN_WINDOW.setTitle(applicationTitle);
        CLICK_ME_BUTTON.setText(clickMeButtonText);
        LABEL_FOR_USER_INPUT_TEXT_FIELD.setText(labelForInputField);
        USER_RESULT_LABEL.setText("");

    }

    private static void makeComponentsVisible(boolean makeVisible, Component... components){
        for (Component component : components) {
            component.setVisible(true);
            component.setEnabled(makeVisible);
        }
    }
    private static void makeComponentsInvisibleForTime(Component... components){
        for (Component component : components) {
            component.setVisible(false);
            component.setEnabled(false);
        }
    }

    public static void main(String[] args) {

        initialRender();
        renderNumberDisplay();

    }
    private static void initialRender(){
        APPLICATION_MAIN_WINDOW.setSize(350   , 350);
        APPLICATION_MAIN_WINDOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        USER_INPUT_TEXT_FIELD.setFont(TIME_RESULT_FONT);
        CLICK_ME_BUTTON.setFont(APPLICATION_COMPONENTS_FONT);
        LABEL_FOR_USER_INPUT_TEXT_FIELD.setFont(APPLICATION_COMPONENTS_FONT);
        USER_RESULT_LABEL.setBackground(Color. BLACK);
        USER_RESULT_LABEL.setForeground(Color.BLACK);
        USER_INPUT_AND_OUTPUT_DISPLAY_PANEL.add(LABEL_FOR_USER_INPUT_TEXT_FIELD); // Components Added using Flow Layout
        USER_INPUT_AND_OUTPUT_DISPLAY_PANEL.add(USER_INPUT_TEXT_FIELD);
        USER_INPUT_AND_OUTPUT_DISPLAY_PANEL.add(CLICK_ME_BUTTON);
        USER_INPUT_AND_OUTPUT_DISPLAY_PANEL.setBackground(Color.GRAY);
        USER_INPUT_AND_OUTPUT_DISPLAY_PANEL.add(USER_RESULT_LABEL);
        WHAT_IS_THE_TIME_RADIO.setFont(APPLICATION_COMPONENTS_FONT);
        NUMBER_TO_WORD_RADIO.setFont(APPLICATION_COMPONENTS_FONT);
        WHAT_IS_THE_CURRENT_TIME_RADIO.setFont(APPLICATION_COMPONENTS_FONT);
        NUMBER_TO_WORD_RADIO.setSelected(true);


        buttonGroup.add(NUMBER_TO_WORD_RADIO);
        buttonGroup.add(WHAT_IS_THE_TIME_RADIO);
        buttonGroup.add(WHAT_IS_THE_CURRENT_TIME_RADIO);
        RADIO_BUTTONS_PANEL.add(NUMBER_TO_WORD_RADIO);
        RADIO_BUTTONS_PANEL.add(WHAT_IS_THE_CURRENT_TIME_RADIO);
        RADIO_BUTTONS_PANEL.add(WHAT_IS_THE_TIME_RADIO); // Components Added using Flow Layout


        APPLICATION_MAIN_WINDOW.getContentPane().add(BorderLayout.CENTER, USER_INPUT_AND_OUTPUT_DISPLAY_PANEL);
        APPLICATION_MAIN_WINDOW.getContentPane().add(BorderLayout.PAGE_END, RADIO_BUTTONS_PANEL);
        APPLICATION_MAIN_WINDOW.setVisible(true);
        displayResult();
        timeRadioOnclick();
        numberRadioOnclickHandler();
        whatIsTheCurrentTimeOnclickHandler();


    }

    private static void whatIsTheCurrentTimeOnclickHandler() {
        WHAT_IS_THE_CURRENT_TIME_RADIO.addActionListener(actionEvent -> {
            if(WHAT_IS_THE_CURRENT_TIME_RADIO.isSelected()){
                renderWhatIsTheCurrentTime();
            }
        });
    }

    private static void numberRadioOnclickHandler() {
        NUMBER_TO_WORD_RADIO.addActionListener(actionEvent -> {
            if (NUMBER_TO_WORD_RADIO.isSelected()) {
                renderNumberDisplay();
            }
        });
    }

    private static void timeRadioOnclick() {
        WHAT_IS_THE_TIME_RADIO.addActionListener(actionEvent -> {
            if (WHAT_IS_THE_TIME_RADIO.isSelected()) {
                renderTimeDisplay();
            }
        });
    }

    private static void displayResult() {
        CLICK_ME_BUTTON.addActionListener(actionEvent -> {
            String result = null;
            if (WHAT_IS_THE_TIME_RADIO.isSelected()) {
                try {
                    result = timeUtil.tellTheTime(USER_INPUT_TEXT_FIELD.getText());
                    result= String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 100, result);
                } catch (Time.InvalidTimeException invalidTimeException) {
                    result = invalidTimeException.getMessage();
                }

            }
            if(WHAT_IS_THE_CURRENT_TIME_RADIO.isSelected()){
                result = timeUtil.greetUser()+"," + "<br/>"+ timeUtil.whatIsTheCurrentTime();
                result= String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 150, result);
                makeComponentsInvisibleForTime(CLICK_ME_BUTTON);
            }
            if(NUMBER_TO_WORD_RADIO.isSelected()){
                try {
                    result = numberUtilities.convertAnyNumberToWords(USER_INPUT_TEXT_FIELD.getText());
                    result = String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 500, result);
                    APPLICATION_MAIN_WINDOW.setSize(720, 600);
                } catch (NumberUtilitiesImpl.InvalidInputException invalidInputException) {
                    result = invalidInputException.getMessage();
                }
            }
            USER_RESULT_LABEL.setText(result);

        });
    }

    private static void renderWhatIsTheCurrentTime() {
        setComponentText("Clock Application", "What is the Time", "Enter Time");
        makeComponentsInvisibleForTime(LABEL_FOR_USER_INPUT_TEXT_FIELD, USER_INPUT_TEXT_FIELD, WHAT_IS_THE_CURRENT_TIME_RADIO);
        renderTimeApplicationHelper();
        makeComponentsVisible(true, NUMBER_TO_WORD_RADIO, CLICK_ME_BUTTON, WHAT_IS_THE_TIME_RADIO);
    }

    private static void renderTimeApplicationHelper() {
        USER_INPUT_TEXT_FIELD.setColumns(5);
        APPLICATION_MAIN_WINDOW.setSize(350, 350);
        USER_RESULT_LABEL.setFont(TIME_RESULT_FONT);
        USER_RESULT_LABEL.setBounds(2, 4, 300, 300);
    }

    public static void renderTimeDisplay(){
        setComponentText("What is the Time Application", "Get Time", "Enter Time");
        renderTimeApplicationHelper();
        makeComponentsVisible(false, WHAT_IS_THE_TIME_RADIO);
        makeComponentsVisible(true, WHAT_IS_THE_CURRENT_TIME_RADIO, NUMBER_TO_WORD_RADIO, USER_INPUT_TEXT_FIELD, CLICK_ME_BUTTON);
    }

    public static void renderNumberDisplay(){
        setComponentText("Number to Words Application", "Get Words", "Enter Number");
        USER_INPUT_TEXT_FIELD.setColumns(15);
        makeComponentsVisible(true, WHAT_IS_THE_TIME_RADIO, WHAT_IS_THE_CURRENT_TIME_RADIO, USER_INPUT_TEXT_FIELD, CLICK_ME_BUTTON);
        makeComponentsVisible(false, NUMBER_TO_WORD_RADIO);
        USER_RESULT_LABEL.setBounds(9,18,220,900);
        USER_RESULT_LABEL.setFont(NUMBER_TO_WORD_FONT);
       USER_RESULT_LABEL.setFont(TIME_RESULT_FONT);

    }
}

