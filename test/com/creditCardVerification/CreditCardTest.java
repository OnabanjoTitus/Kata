package com.creditCardVerification;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CreditCardTest {
    CreditCard newCC;


    @BeforeEach
    void setUp() {
        newCC = CreditCardFactory.createCreditCard("4593847493847933");

    }

    @AfterEach
    void tearDown() {
        newCC =null;
    }

//    @Test
//    void cardDigitsIsBetween13and16Test() {
//    assertNotNull(newCC);
//        assertTrue(newCC.isValidNumber());
//        newCC.setCreditCardNumber("45094850948304");
//        assertTrue(newCC.isValidNumber());
//        newCC.setCreditCardNumber("450948509483044");
//        assertTrue(newCC.isValidNumber());
//        newCC.setCreditCardNumber("4509485059483044");
//        assertTrue(newCC.isValidNumber());
//        newCC.setCreditCardNumber("450948505948304432");
//        assertFalse(newCC.isValidNumber());
//        System.out.println(newCC.getClass());
//
//    }

    @Test
    void isFirstNumberValid() {
        newCC = CreditCardFactory.createCreditCard("8593847493847933");
        assertEquals("Invalid", newCC.isValidNumber());
    }

    @Test
    void sumOfDoubleEvenPlace() {
        newCC.setCreditCardNumber("4388576018402626");
        assertEquals(37, newCC.sumOfDoubleEvenPlace());

    }

    @Test
    void creditCardValidityByDivisibilityTest() {
        newCC = CreditCardFactory.createCreditCard("4388576018402626 ");
        //newCC.setCreditCardNumber("4388576018402626");
        assertNotEquals("Valid", newCC.isValidNumber());


        newCC = CreditCardFactory.createCreditCard("4388576018410707 ");
       // newCC.setCreditCardNumber("");
        assertEquals("Valid", newCC.isValidNumber());

    }

    @Test
    void sumOfOddPlace() {
        newCC= CreditCardFactory.createCreditCard("4388576018402626");
     //   newCC.setCreditCardNumber("4388576018402626");
        assertEquals(38, newCC.sumOfOddPlace());
    }

    @Test
    void creditCardsCanBeValidatedTest(){
       newCC= CreditCardFactory.createCreditCard("4982918273746");
       assertEquals("Invalid", newCC.isValidNumber());

    }
}