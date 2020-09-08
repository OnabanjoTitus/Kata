package com.creditCardVerification;

public class Mastercard extends CreditCard {
    private final String CARDTYPE = "MasterCard";

    public Mastercard(String creditCardNumber) {
        super(creditCardNumber);
    }

    public String getCardType() {
        return CARDTYPE;
    }


}
