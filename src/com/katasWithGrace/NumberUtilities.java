package com.katasWithGrace;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class NumberUtilities {
    static String[] unit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight","Nine", "Ten" };
    static String[] tens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen", "Twenty" };
    static String[] hundreds = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety", "Hundred" };
    static String[]  thousands = {"Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Pentallion"};



    public static String tellTheTime(String time) {
        String stringTime = "";
        String[]  timeArray = time.split(":");
        int hour = Integer.parseInt(timeArray[0]);
        int minutes =Integer.parseInt(timeArray[1]);

        if (hour>24)
        {
            stringTime = "Hour cannot exceed 24 hours";
        }
        else if(minutes>60){stringTime = "Minutes cannot exceed sixty";}


        else{
        if(hour>12){
            hour = hour%12;
        }
        if(hour == 0){
            hour =12;
        }

        if(minutes>0 && minutes < 10){
         stringTime =  "It's "+ convertTimeDigitsToWordHelper(hour) + " O'"+ convertTimeDigitsToWordHelper(minutes);
        }
        else {

            stringTime = "It's " + convertTimeDigitsToWordHelper(hour) + " " + convertTimeDigitsToWordHelper(minutes);
        }}
        return stringTime;
    }

    private static String convertTimeDigitsToWordHelper(int number){
        String word = "O' clock";
        if(number>0 && number <= 10){
            word = convertUnitsToWords(number);
        }
     if(number>10){
        return convertTensToWords(number);
        }

        return word;
    }

    public static  String whatIsTheCurrentTime(){
          return tellTheTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    public static String greetUser(){
        return "Good " + whatIsTheTimeOfDay(LocalTime.now().format((DateTimeFormatter.ofPattern("HH:mm")))) +" "+ whatIsTheNameOfTheOwnerOfThisComputer();
    }
    private static String whatIsTheNameOfTheOwnerOfThisComputer(){
        return System.getProperty("user.name");
    }
    private static String whatIsTheTimeOfDay(String systemTime){
        String[] timeParts = systemTime.split(":");
        int hour =Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        if(hour == 12 && minutes == 0){
            return "Noon";
        }
        else if((hour == 24 || hour ==0) && minutes == 0){
            return "Mid-Night";
        }
        else return (whatIsTheTimeOfDayHelper(hour));
        
    }
    private static String whatIsTheTimeOfDayHelper(int hourOfTheDay){
        if(hourOfTheDay >=0 && hourOfTheDay<12){
            return "Morning";
        }
        if(hourOfTheDay>=12 && hourOfTheDay<18){
            return "Afternoon";
        }
        else {
            return "Evening";
        }

    }

    private static String convertUnitsToWords(int number){
        return unit[number];
    }
    private static String convertUnitsToWords(String stringNumber){
        return convertUnitsToWords(Integer.parseInt(stringNumber));
    }
    private static String convertTensToWords(String number) {
        return convertTensToWords(Integer.parseInt(number));
    }

    private static String convertTensToWords(int number) {

        if (String.valueOf(number).length() == 2) {

            if (number >= 10 && number <= 19) {
                return tens[(number) % 10];
            } else {
                String result = hundreds[Integer.parseInt(String.valueOf(String.valueOf(number).charAt(0)))];
                final var secondDigit = Integer.parseInt(String.valueOf(String.valueOf(number).charAt(1)));
                if (secondDigit == 0) {
                    return result;
                } else {

                    return result + "-" + unit[secondDigit];
                }
            }
        }
        return null;
    }
    public static String convertNumberToWord(String userInput){
        int lengthOfNumber = userInput.length();
        if(lengthOfNumber== 1){
            return convertUnitsToWords(userInput);
        }
        if(lengthOfNumber== 2){
           return convertTensToWords(userInput);
        }

        return null;
    }

}
