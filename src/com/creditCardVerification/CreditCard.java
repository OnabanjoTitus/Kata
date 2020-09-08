package com.creditCardVerification;

public abstract class CreditCard implements CreditCardInterface {
    //private final String CARDTYPE = "Standard Card";
    private String creditCardNumber;
    private int[] creditCardNumberArray;


    public CreditCard(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber.trim();
        creditCardNumberArray = new int[this.creditCardNumber.length()];
        for (int i = 0; i < creditCardNumberArray.length; i++) {
            creditCardNumberArray[i] = Integer.parseInt(String.valueOf(this.getDigit().charAt(i)));//Integer.parseInt(String.valueOf(this.getDigit().toCharArray()[i]));
        }
    }

    public abstract String getCardType();


    public int getSize() {
        return creditCardNumber.length();
    }

//    public int getSize(String creditCardNumber) {
//        return creditCardNumber.length();
//    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String isValidNumber() {
        boolean isCardValid = CreditCardValidator.isCreditCardValid(this);
        return (isCardValid ? "Valid" : "Invalid");
    }

    @Override
    public int sumOfDoubleEvenPlace() {
        //int[] creditCardNumber = new int[this.getDigit().length()];
        int sum = 0;

        for (int i = 0; i < creditCardNumber.length(); i += 2) {
            if (creditCardNumberArray[i] > 4) {
                sum += (1 + ((creditCardNumberArray[i] * 2) % 10));
            } else {
                sum += (creditCardNumberArray[i] * 2);
            }
        }
        return sum;
    }

    @Override
    public String getDigit() {
        return creditCardNumber;
    }

    @Override
    public int sumOfOddPlace() {
        int sum = 0;
        for (int i = 1; i < creditCardNumberArray.length; i += 2) {
            sum += (creditCardNumberArray[i]);
        }
        return sum;
    }

    @Override
    public String toString() {
        String cardDetails = "**************************************\n**Credit Card Type: " + this.getCardType() +
                "\n**Credit Card Number: " + this.getCreditCardNumber() +
                "\n**Credit Card Digit Length: " + this.getSize() +
                "\n**Credit Card Validity Status: " + this.isValidNumber() +
                "\n***************************************";
        return cardDetails;
    }


}
