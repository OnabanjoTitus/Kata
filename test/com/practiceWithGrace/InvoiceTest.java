package com.practiceWithGrace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvoiceTest {
Invoice invoice;
    @BeforeEach
    void setUp(){
        invoice = new Invoice();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void InvoiceAmountCanBeCalculatedTest(){
        invoice.setPrice(2300);
        invoice.setQuantityOfItemPurchased(2);
        double result =invoice.getInvoiceAmount();
        Assertions.assertEquals(result, 4600);
    }


    @Test
    void InvoiceCannotTakeNegativePriceTest(){
        invoice.setPrice(-2300);
        double result = invoice.getPrice();
        Assertions.assertEquals(result, 0);
    }

    @Test
    void InvoiceCannotTakeNegativeQuantityTest(){
        invoice.setQuantityOfItemPurchased(-2);
        double result =invoice.getQuantityOfItemPurchased();
        Assertions.assertEquals(result, 0);
    }
}