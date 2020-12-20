package com.katasWithGrace;

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
    void Invoice_canBeConstructed(){
        invoice = new Invoice(2330, 3, "ueey272", "Honda");
        Assertions.assertEquals(2330,invoice.getPrice());
        Assertions.assertEquals(3,invoice.getQuantityOfItemPurchased());
        Assertions.assertEquals("ueey272",invoice.getPartNumber());
        Assertions.assertEquals("Honda",invoice.getPartDescription());
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

        invoice.setPrice(2300);
        result = invoice.getPrice();
        Assertions.assertEquals(result, 2300);


    }

    @Test
    void InvoiceCannotTakeNegativeQuantityTest(){
        invoice.setQuantityOfItemPurchased(-2);
        double result =invoice.getQuantityOfItemPurchased();
        Assertions.assertEquals(result, 0);

        invoice.setQuantityOfItemPurchased(45);
        result =invoice.getQuantityOfItemPurchased();
        Assertions.assertEquals(result, 45);
    }

    @Test
    void invoiceAmount_canBeCalculated(){
        invoice = new Invoice(2000, 3, "ueey272", "Honda");
        Assertions.assertEquals(6000,invoice.getInvoiceAmount());

    }

    @Test
    void partNumberAndDescription_canBeSet(){
        invoice = new Invoice(2000, 3, "ueey272", "Honda");
        invoice.setPartNumber("TOYOTA");
        invoice.setPartDescription("Car");
        Assertions.assertEquals("TOYOTA",invoice.getPartNumber());
        Assertions.assertEquals("Car",invoice.getPartDescription());
    }
}