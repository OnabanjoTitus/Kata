package com.katasWithGrace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class numberUtilitiesTest {

    NumberUtilities numberUtilities;
    @BeforeEach
    void setUp() {
        numberUtilities = new NumberUtilitiesImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void numberUtilitiesCanTellTheTimeInHoursTest(){
       String result = numberUtilities.tellTheTime("10 00");
        System.out.println(result);
       assertEquals("It's Ten O' clock", result);

        result = numberUtilities.tellTheTime(10, 00);
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);

        result = numberUtilities.tellTheTime("10", "00");
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);


    }

    @Test
    void numberUtilitiesCanTellTheTimeInMinutesTest(){
       System.out.println(numberUtilities.convertAnyNumberToWords("2456543689465982735913"));
       String result = numberUtilities.tellTheTime("10:12");
        System.out.println(result);
       assertEquals("It's Ten Twelve", result);


        result = numberUtilities.tellTheTime("10:19");
        System.out.println(result);
        assertEquals("It's Ten Nineteen", result);


        result = numberUtilities.tellTheTime("12:19");
        System.out.println(result);
        assertEquals("It's Twelve Nineteen", result);


    }



    @Test
    void numberUtilitiesCanTellTheTImeCorrectlyTest(){
        String result = numberUtilities.tellTheTime("10:35");
        System.out.println(result);
        assertEquals("It's Ten Thirty-Five", result);

        result = numberUtilities.tellTheTime("10 35");
        System.out.println(result);
        assertEquals("It's Ten Thirty-Five", result);

        result = numberUtilities.tellTheTime("10.35");
        System.out.println(result);
        assertEquals("It's Ten Thirty-Five", result);


        result = numberUtilities.tellTheTime("10");
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);




        result = numberUtilities.tellTheTime("11:54");
        System.out.println(result);

result = numberUtilities.tellTheTime("12:56");
        System.out.println(result);
result = numberUtilities.tellTheTime("23:35");
        System.out.println(result);
result = numberUtilities.tellTheTime("16:23");
        System.out.println(result);
result = numberUtilities.tellTheTime("04:13");
        System.out.println(result);

        result = numberUtilities.tellTheTime("00:13");
        System.out.println(result);


    }


    @Test
    void numberUtilitiesCanTellTheTImeIfItIsTwentyFourHourTest() {
        String result = numberUtilities.tellTheTime("13:35");
        System.out.println(result);
        assertEquals("It's One Thirty-Five", result);

        result = numberUtilities.tellTheTime("24:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

    }



    @Test
    void numberUtilitiesCanTellTheTImeIfItIsZeroHours() {
        String result = numberUtilities.tellTheTime("0:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

        result = numberUtilities.tellTheTime("24:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

    }

    @Test
    void numberUtilitiesWillNotTellTheTimeIfTheHourExceedsTwentyFour() {
        String result = numberUtilities.tellTheTime("35:35");
        System.out.println(result);
        assertEquals("invalid input", result);

    }
    @Test
    void numberUtilitiesWillNotTellTheTimeIfTheMinutesExceedsSixty() {
        String result = numberUtilities.tellTheTime("24:65");
        System.out.println(result);
        assertEquals("invalid input", result);

    }


    @Test
    void numberUtilitiesGraceTest() {
        String result = numberUtilities.tellTheTime("0:00");
        System.out.println(result);
        assertEquals("It's Twelve O' clock", result);

    }

    @Test
    void numberUtilitiesCanTellTimeCorrectlyWhenMinuteIsLessThanTenTest() {
        String result = numberUtilities.tellTheTime("0:05");
        System.out.println(result);
        assertEquals("It's Twelve O'Five", result);
        System.out.println(numberUtilities.whatIsTheCurrentTime());

    }

    @Test
    void numberUtilitiesCanTellUnitCorrectly(){
        String result = numberUtilities.convertNumberToWord("3");
        System.out.println(result);
        assertEquals("Three", result);


        result = numberUtilities.convertNumberToWord("8");
        System.out.println(result);
        assertEquals("Eight", result);

        result = numberUtilities.convertNumberToWord("0");
        System.out.println(result);
        assertEquals("Zero", result);
    }


    @Test
    void numberUtilitiesCanTellTensCorrectly(){
        String result = numberUtilities.convertNumberToWord("12");
        System.out.println(result);
        assertEquals("Twelve", result);


        result = numberUtilities.convertNumberToWord("18");
        System.out.println(result);
        assertEquals("Eighteen", result);

        result = numberUtilities.convertNumberToWord("10");
        System.out.println(result);
        assertEquals("Ten", result);


        result = numberUtilities.convertAnyNumberToWords(10L);
        System.out.println(result);
        assertEquals("Ten", result);

        result = numberUtilities.convertAnyNumberToWords(10);
        System.out.println(result);
        assertEquals("Ten", result);
    }

    @Test
    void numberUtilitiesCanTellHigherTensCorrectly(){
        String result = numberUtilities.convertNumberToWord("35");
        System.out.println(result);
        assertEquals("Thirty-Five", result);


        result = numberUtilities.convertNumberToWord("42");
        System.out.println(result);
        assertEquals("Forty-Two", result);

        result = numberUtilities.convertNumberToWord("85");
        System.out.println(result);
        assertEquals("Eighty-Five", result);


        result = numberUtilities.convertNumberToWord("20");
        System.out.println(result);
        assertEquals("Twenty", result);


        result = numberUtilities.convertNumberToWord("40");
        System.out.println(result);
        assertEquals("Forty", result);

        System.out.println(numberUtilities.whatIsTheCurrentTime());
        System.out.println(numberUtilities.greetUser());
    }

    @Test
    void numberUtilitiesCanTellHundredCorrectly(){
        String result = numberUtilities.convertNumberToWord("125");
        System.out.println(result);
        assertEquals("One Hundred and Twenty-Five", result);


        result = numberUtilities.convertNumberToWord("530");
        System.out.println(result);
        assertEquals("Five Hundred and Thirty", result);

        result = numberUtilities.convertNumberToWord("685");
        System.out.println(result);
        assertEquals("Six Hundred and Eighty-Five", result);


        result = numberUtilities.convertNumberToWord("956");
        System.out.println(result);
        assertEquals("Nine Hundred and Fifty-Six", result);


        result = numberUtilities.convertNumberToWord("40");
        System.out.println(result);
        assertEquals("Forty", result);



    }


    @Test
    void numberUtilitiesCanTellAnyNumberCorrectly(){
        String result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(34569));
        System.out.println(result);
        assertEquals("Thirty-Four Thousand, Five Hundred and Sixty-Nine", result);


        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(18000000));
        System.out.println(result);
        assertEquals("Eighteen Million", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(502));
        System.out.println(result);
        assertEquals("Five Hundred and Two", result);



        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(0));
        System.out.println(result);
        assertEquals("Zero", result);

                result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(1_502_938_593));
        System.out.println(result);
        assertEquals("One Billion, Five Hundred and Two Million, Nine Hundred and Thirty-Eight Thousand, Five Hundred and Ninety-Three", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(1_502_938_593.34));
        System.out.println(result);
        assertEquals("One Billion, Five Hundred and Two Million, Nine Hundred and Thirty-Eight Thousand, Five Hundred and Ninety-Three point Thirty-Four", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(18000023));
        System.out.println(result);
        assertEquals("Eighteen Million and Twenty-Three", result);


        result = numberUtilities.convertNumberToWord("685");
        System.out.println(result);
        assertEquals("Six Hundred and Eighty-Five", result);


        result = numberUtilities.convertNumberToWord("956");
        System.out.println(result);
        assertEquals("Nine Hundred and Fifty-Six", result);


        result = numberUtilities.convertNumberToWord("40");
        System.out.println(result);
        assertEquals("Forty", result);




        LocalDate date= LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy")));
    }





}