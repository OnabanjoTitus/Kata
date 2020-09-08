package com.practiceWithGrace;

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
         stringTime =  "It's "+ numberToWord(hour) + " O'"+ numberToWord(minutes);
        }
        else {

            stringTime = "It's " + numberToWord(hour) + " " + numberToWord(minutes);
        }}
        return stringTime;
    }

    private static String numberToWord(int number){
        String word = "O' clock";
        if(number>0 && number <= 10){
            word = unit[number];
        }
     if(number>10 && number <= 20){
            word = tens[number%10];
        }

        if(number>20){
            word = hundreds[Integer.parseInt(String.valueOf(String.valueOf(number).charAt(0)))];
            word = word + "-" +unit[Integer.parseInt(String.valueOf(String.valueOf(number).charAt(1)))];
        }

        return word;
    }

    public static  String whatIsTheTime(){
        return tellTheTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }


    public static String convertNumberToWord(String userInput){
        int lengthOfNumber = userInput.length();
        if(lengthOfNumber== 1){
            return unit[Integer.parseInt(userInput)];
        }
        if(lengthOfNumber== 2){
            int numberFromUserInput = Integer.parseInt(userInput);
            if(numberFromUserInput>=10 && numberFromUserInput<19){
            return tens[(Integer.parseInt(userInput))%10];}
            else{
                String result = hundreds[Integer.parseInt(String.valueOf(String.valueOf(userInput).charAt(0)))];
                final var secondDigit = Integer.parseInt(String.valueOf(String.valueOf(userInput).charAt(1)));
                if(secondDigit ==0){
                    return result;
                }
                else{

                return result + "-" +unit[secondDigit];}
            }
        }

        return null;
    }

}
