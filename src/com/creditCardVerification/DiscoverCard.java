package com.creditCardVerification;

public class DiscoverCard extends CreditCard {
    private final String CARDTYPE = "Discover";


    public DiscoverCard(String creditCardNumber) {
        super(creditCardNumber);
    }
    public String getCardType() {
        return CARDTYPE;
    }
}
