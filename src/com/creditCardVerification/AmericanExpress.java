package com.creditCardVerification;

public class AmericanExpress extends CreditCard {
    private final String CARDTYPE = "American Express";


    public AmericanExpress(String creditCardNumber) {
        super(creditCardNumber);
    }
    public String getCardType() {
        return CARDTYPE;
    }
}
