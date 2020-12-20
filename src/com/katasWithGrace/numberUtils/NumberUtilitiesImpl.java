package com.katasWithGrace.numberUtils;

import java.math.BigDecimal;

public class NumberUtilitiesImpl implements NumberUtilities {
    static String[] unit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    static String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"};
    static String[] thousands = {"Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Pentallion"};

    private  String convertTensToWordHelper(int number) {
        if (number < 10 && number > 0) {
            return unit[number];
        }
        if (number >= 10 && number <= 19) {
            return teens[number % 10];
        } else {
            return convertTensToWordHelperHelper(number);
        }
    }

    private  String convertTensToWordHelperHelper(int number) {
        String result = tens[Integer.parseInt(String.valueOf(String.valueOf(number).charAt(0)))];
        final var secondDigit = Integer.parseInt(String.valueOf(String.valueOf(number).charAt(1)));
        if (secondDigit == 0) {
            return result;
        } else {

            return result + "-" + unit[secondDigit];
        }
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
                convertAnyIntoWordHelper(amountToWord, numbersArray, thousandsCounter--, i);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "Number is too large";
        }
        return amountToWord.append(convertNumberToWord(numbersArray[numberOfCommas - 1])).toString();

    }

    private String convertUnitsToWords(int number) {
        return unit[number];
    }

    private String convertUnitsToWords(String stringNumber) {
        return convertUnitsToWords(Integer.parseInt(stringNumber));
    }

    private String convertTensToWords(String number) {
        return convertTensToWords(Integer.parseInt(number));
    }

    private String convertTensToWords(int number) {

        if (String.valueOf(number).length() <= 2) {
            return convertTensToWordHelper(number);
        }
        return null;
    }

    private String convertNumberToWordHelper(String[] numberWithDecimal) {
        if (Integer.parseInt(numberWithDecimal[1]) > 0) {
            return numberToWordHelper(numberWithDecimal[0]) + " point " + numberToWordHelper(numberWithDecimal[1]);
        } else {
            return numberToWordHelper(numberWithDecimal[0]);
        }
    }

    private String numberToWordHelper(String number) {
        String numberToWord = "";
        int lengthOfNumber = number.length();
        if (lengthOfNumber == 1) {
            numberToWord = convertUnitsToWords(number);
        }
        if (lengthOfNumber == 2) {
            numberToWord = convertTensToWords(number);
        }
        if (lengthOfNumber == 3) {
            if (Integer.parseInt(number) != 0) {
                numberToWord = convertHundredsToWord(number);

            }

        }

        return numberToWord;
    }

    private String convertHundredsToWord(String userInput) {
        if (Integer.parseInt(userInput.substring(0, 1)) == 0) {
            return " and " + convertTensToWords(userInput.substring(1));
        } else {
            return convertUnitsToWords(userInput.substring(0, 1)) + " Hundred and " + convertTensToWords(userInput.substring(1));
        }
    }

    private void convertAnyIntoWordHelper(StringBuilder amountToWord, String[] numbersArray, int thousandsCounter, int i) {
        if (Integer.parseInt(numbersArray[i]) == 0) {
            amountToWord.replace(amountToWord.length() - 2, amountToWord.length(), "");
        } else {

            amountToWord.append(convertNumberToWord(numbersArray[i])).append(" ").append(thousands[thousandsCounter]).append(", ");

        }
    }

    private String convertNumberToWord(String userInput) {
        String[] numberWithDecimal = userInput.split("\\.");
        if (numberWithDecimal.length > 1) {
            return convertNumberToWordHelper(numberWithDecimal);
        } else {
            return numberToWordHelper(userInput);
        }

    }
}
