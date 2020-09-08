package com.creditCardVerification;

public class VisaCard extends CreditCard {
    private final String CARDTYPE = "VisaCard";
    public VisaCard(String creditCardNumber) {
        super(creditCardNumber);
    }
    public String getCardType() {
        return CARDTYPE;
    }
}
