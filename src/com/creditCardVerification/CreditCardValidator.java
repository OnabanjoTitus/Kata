package com.creditCardVerification;

import java.util.stream.IntStream;

public class CreditCardValidator {




    public static boolean isCreditCardValid(CreditCardInterface creditCard){
        boolean isCardValid = false;
        if (isCreditCardDigitContainingOnlyDigits(creditCard))
           if(isCreditCardFirstDigitValid(creditCard)) {
               if (isCreditCardDigitComplete(creditCard)) {
                   if (isCreditCardDigitDivisibleByTen(creditCard)) {
                       isCardValid = true;
                   }
               }
           }

        return isCardValid;
    }

    public static boolean isCreditCardDigitContainingOnlyDigits(CreditCardInterface creditCard){
        boolean isCardValid = false;
        if (creditCard.getDigit().matches("\\d+")) {
            isCardValid = true;
        }
          return isCardValid;

   }

//    public static boolean isCreditCardDigitContainingOnlyDigits(String creditCardDigits){
//        boolean isCardValid = false;
//        if (creditCardDigits.matches("\\d+")) {
//            isCardValid = true;
//        }
//            return isCardValid;
//    }




    public static boolean isCreditCardDigitComplete(CreditCardInterface creditCard){
        boolean isCardValid = false;
        int[] creditCardNumber = new int[creditCard.getDigit().length()];
        for (int i = 0; i< creditCard.getDigit().length(); i++){
            creditCardNumber[i]= Integer.parseInt(String.valueOf(creditCard.getDigit().charAt(i)));//Integer.parseInt(String.valueOf(creditCard.getDigit().toCharArray()[i]));
        }
        if (IntStream.of((creditCardNumber))
                .count() >= 13
                &&
                IntStream.of((creditCardNumber)).count()<=16 )
          isCardValid = true;


        return isCardValid;
    }

    public static boolean isCreditCardFirstDigitValid(CreditCardInterface creditCard){
        boolean isCardValid = false;
       if(creditCard!= null){
           isCardValid = true;
       }

        return isCardValid;
    }

    public static boolean isCreditCardDigitDivisibleByTen(CreditCardInterface creditCard){
        boolean isCardValid = false;
        if(((creditCard.sumOfDoubleEvenPlace()+ creditCard.sumOfOddPlace()) %10) == 0 ) {
            isCardValid = true;
        }
        return isCardValid;
    }



}
