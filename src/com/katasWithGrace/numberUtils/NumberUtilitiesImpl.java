package com.katasWithGrace.numberUtils;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class NumberUtilitiesImpl implements NumberUtilities {
    static String[] unit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight","Nine", "Ten" };
    static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen", "Twenty" };
    static String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety", "Hundred" };
    static String[]  thousands = {"Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Pentallion"};



@Override
    public String tellTheTime(String hour, String minute) {
        return tellTheTimeHelper(new Time(hour, minute));
    }

    @Override
    public  String tellTheTime(String time) {
           return tellTheTimeHelper(new Time(time));
    }
@Override
    public String tellTheTime(int hour, int minute) {
    return tellTheTimeHelper(new Time(hour, minute));
}
    @Override
    public  String tellTheTime(Time time){
    return tellTheTimeHelper(time);
    }

@Override
    public  String convertNumberToWord(String userInput) {
        String[] numberWithDecimal = userInput.split("\\.");
        if (numberWithDecimal.length > 1) {
            return NumberUtilitiesImpl.convertNumberToWordHelper(numberWithDecimal);
        } else {
            return NumberUtilitiesImpl.numberToWordHelper(userInput);
        }

    }
@Override
    public String whatIsTheCurrentTime() {
        return tellTheTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
@Override
    public String greetUser() {
        return "Good " + NumberUtilitiesImpl.whatIsTheTimeOfDay(LocalTime.now().format((DateTimeFormatter.ofPattern("HH:mm")))) + " " + NumberUtilitiesImpl.whatIsTheNameOfTheOwnerOfThisComputer();
    }
@Override
    public String convertAnyNumberToWords(String number) {
        return convertAnyNumberToWords(BigDecimal.valueOf(Double.parseDouble(number)));
    }
@Override
    public String convertAnyNumberToWords(Double number) {
        return convertAnyNumberToWords(BigDecimal.valueOf(number));

    }
@Override
    public String convertAnyNumberToWords(int number) {
        return convertAnyNumberToWords(Double.valueOf(number));
    }

    @Override
    public String convertAnyNumberToWords(long number) {
        return convertAnyNumberToWords(BigDecimal.valueOf(number));
    }
@Override
    public String convertAnyNumberToWords(BigDecimal number) {
        StringBuilder amountToWord = new StringBuilder();
        String numberWithComma = String.format("%,.2f", number);
        String[] numbersArray = numberWithComma.split(",");
        int numberOfCommas = numbersArray.length;
        int thousandsCounter = numberOfCommas - 2;
        try {
            for (int i = 0; i < numberOfCommas - 1; i++) {
                convertAnyIntoWordHelper(amountToWord, numbersArray, thousandsCounter, i);
                thousandsCounter--;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "Number is too large";
        }
        return amountToWord.append(convertNumberToWord(numbersArray[numberOfCommas - 1])).toString();

    }

    @Override
    public String tellTheTime(int hour) {
        return tellTheTimeHelper(new Time(hour));
    }

    private static String tellTheTimeHelper(Time time) {
        String stringTime;
        int hour = time.getHour();
        int minute = time.getMinute();
        if(hour >12){
            hour =hour %12;
        }
        if(hour == 0){
            hour =12;
        }

        if(minute >0 && minute < 10){
         stringTime =  "It's "+ convertTimeDigitsToWordHelper(hour) + " O'"+ convertTimeDigitsToWordHelper(minute);
        }
        else {

            stringTime = "It's " + convertTimeDigitsToWordHelper(hour) + " " + convertTimeDigitsToWordHelper(minute);
        }
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
    private static String whatIsTheNameOfTheOwnerOfThisComputer(){
         return System.getProperty("user.name");
    }
    private static String whatIsTheTimeOfDay(String systemTime){
        String[] timeParts = systemTime.split(":");
        int hour =Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        return whatIsTheTImeOfTheDayHelper(hour, minutes);
    }

    private static String whatIsTheTImeOfTheDayHelper(int hour, int minutes) {
        String result;
        boolean isNoon = hour == 12 && minutes == 0;
        boolean isMidnight = (hour == 24 || hour ==0) && minutes == 0;
        if(isNoon){
            result="Noon";
        }
        else if(isMidnight){
            result="Mid-Night";
        }

        else result= (whatIsTheTimeOfDayHelper(hour));

        return result;
    }

    private static String whatIsTheTimeOfDayHelper(int hourOfTheDay){
        String result ="";
        boolean isMorning = hourOfTheDay >=0 && hourOfTheDay<12;
        boolean isAfternoon = hourOfTheDay>=12 && hourOfTheDay<18;
        boolean isEvening = !isMorning && !isAfternoon;
        if(isMorning){
            result="Morning";
        }
        if(isAfternoon){
            result="Afternoon";
        }
        if(isEvening) {
            result="Evening";
        }
    return result;
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

        if (String.valueOf(number).length() <= 2) {
            return convertTensToWordHelper(number);
        }
        return null;
    }

    private static String convertTensToWordHelper(int number) {
        if(number <10 && number >0){
            return unit[number];

        }
        if (number >= 10 && number <= 19) {
            return teens[number % 10];
        } else {
            return convertTensToWordHelperHelper(number);
        }
    }

    private static String convertTensToWordHelperHelper(int number) {
        String result = tens[Integer.parseInt(String.valueOf(String.valueOf(number).charAt(0)))];
        final var secondDigit = Integer.parseInt(String.valueOf(String.valueOf(number).charAt(1)));
        if (secondDigit == 0) {
            return result;
        } else {

            return result + "-" + unit[secondDigit];
        }
    }


    private static String convertNumberToWordHelper(String[] numberWithDecimal) {
        if(Integer.parseInt(numberWithDecimal[1])>0){
                return numberToWordHelper(numberWithDecimal[0]) + " point " + numberToWordHelper(numberWithDecimal[1]);
        }
        else{
            return numberToWordHelper(numberWithDecimal[0]);
        }
    }

    private static String numberToWordHelper(String number){
        String numberToWord ="";
        int lengthOfNumber = number.length();
        if(lengthOfNumber== 1){
            numberToWord= convertUnitsToWords(number);
        }
        if(lengthOfNumber== 2){
            if(Integer.parseInt(number)== 0){
            }
            numberToWord= convertTensToWords(number);
        }
        if(lengthOfNumber ==3){
            if(Integer.parseInt(number)!= 0){
                numberToWord= convertHundredsToWord(number);

            }

        }

        return numberToWord;
    }

    private static String convertHundredsToWord(String userInput) {
        if(Integer.parseInt(userInput.substring(0,1))==0){
            return " and "+ convertTensToWords(userInput.substring(1));
        }
        else {
            return convertUnitsToWords(userInput.substring(0, 1)) + " Hundred and " + convertTensToWords(userInput.substring(1));
        }
    }
    private void convertAnyIntoWordHelper(StringBuilder amountToWord, String[] numbersArray, int thousandsCounter, int i) {
        if (Integer.parseInt(numbersArray[i]) == 0) {
            amountToWord.replace(amountToWord.length() - 2, amountToWord.length(), "");
        }
        else
            {

            amountToWord.append(convertNumberToWord(numbersArray[i])).append(" ").append(thousands[thousandsCounter]).append(", ");

        }
    }

}
