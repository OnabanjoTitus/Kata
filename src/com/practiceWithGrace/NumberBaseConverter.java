package com.practiceWithGrace;

public class NumberBaseConverter {
    public static int convertBinaryToBaseTen(String number) {
        char[] numbersToCharArray = number.toCharArray();

        int lenghtofnumbers = numbersToCharArray.length-1;
        int binaryToBaseTen = 0;
        for(char numbers: numbersToCharArray){
            binaryToBaseTen+= (int) (Integer.parseInt(String.valueOf(numbers)) * Math.pow(2, lenghtofnumbers));

            lenghtofnumbers--;
        }
        return binaryToBaseTen;

    }
}
