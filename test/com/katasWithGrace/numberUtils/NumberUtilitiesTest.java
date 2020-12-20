package com.katasWithGrace.numberUtils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class numberUtilitiesTest {

    NumberUtilities numberUtilities;
    TimeUtil timeUtil;
    @BeforeEach
    void setUp() {
        numberUtilities = new NumberUtilitiesImpl();
        timeUtil = new TimeUtilImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void numberUtilitiesCanTellTheTimeInHoursTest(){
       String result = timeUtil.tellTheTime("10 00");
       assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime(10, 0);
        assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime("10", "00");
        assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime(10);
        assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime(new Time(10));
        assertEquals("It's Ten O' clock", result);
}
    @Test
    void numberUtilitiesCanTellTheTimeInMinutesTest(){
       System.out.println(numberUtilities.convertAnyNumberToWords("2456543689465982735913"));
       String result = timeUtil.tellTheTime("10:12");
       assertEquals("It's Ten Twelve", result);

        result = timeUtil.tellTheTime("10:19");
        assertEquals("It's Ten Nineteen", result);

        result = timeUtil.tellTheTime("12:19");
        assertEquals("It's Twelve Nineteen", result);
    }



    @Test
    void numberUtilitiesCanTellTheTImeCorrectlyTest(){
        String result = timeUtil.tellTheTime("10:35");
        assertEquals("It's Ten Thirty-Five", result);

        result = timeUtil.tellTheTime("10 35");
        assertEquals("It's Ten Thirty-Five", result);

        result = timeUtil.tellTheTime("10.35");
        assertEquals("It's Ten Thirty-Five", result);

        result = timeUtil.tellTheTime("10");
        assertEquals("It's Ten O' clock", result);

    }


    @Test
    void numberUtilitiesCanTellTheTImeIfItIsTwentyFourHourTest() {
        String result = timeUtil.tellTheTime("13:35");
        assertEquals("It's One Thirty-Five", result);

        result = timeUtil.tellTheTime("24:35");
        assertEquals("It's Twelve Thirty-Five", result);

    }



    @Test
    void numberUtilitiesCanTellTheTImeIfItIsZeroHours() {
        String result = timeUtil.tellTheTime("0:35");
        assertEquals("It's Twelve Thirty-Five", result);

        result = timeUtil.tellTheTime("24:35");
        assertEquals("It's Twelve Thirty-Five", result);

    }

    @Test
    void numberUtilitiesWillNotTellTheTimeIfTheHourExceedsTwentyFour() throws Time.InvalidTimeException {
       try {
           timeUtil.tellTheTime("35:35");
       }
       catch (Time.InvalidTimeException exception){
           assertEquals(exception.getMessage(), "Time Entered is invalid");
       }

    }
    @Test
    void numberUtilitiesWillNotTellTheTimeIfTheMinutesExceedsSixty() throws Time.InvalidTimeException {
        try {
            timeUtil.tellTheTime("24:65");
        }
        catch (Time.InvalidTimeException exception){
            assertEquals(exception.getMessage(), "Time Entered is invalid");
        }


    }


    @Test
    void numberUtilitiesGraceTest() {
        String result = timeUtil.tellTheTime("0:00");
        assertEquals("It's Twelve O' clock", result);

    }

    @Test
    void numberUtilitiesCanTellTimeCorrectlyWhenMinuteIsLessThanTenTest() {
        String result = timeUtil.tellTheTime("0:05");
        assertEquals("It's Twelve O'Five", result);

    }

    @Test
    void numberUtilitiesCanTellUnitCorrectly(){
        String result = numberUtilities.convertAnyNumberToWords("3");
        assertEquals("Three", result);


        result = numberUtilities.convertAnyNumberToWords("8");
        assertEquals("Eight", result);

        result = numberUtilities.convertAnyNumberToWords("0");
        assertEquals("Zero", result);
    }


    @Test
    void numberUtilitiesCanTellTensCorrectly(){
        String result = numberUtilities.convertAnyNumberToWords("12");
        assertEquals("Twelve", result);


        result = numberUtilities.convertAnyNumberToWords("18");
        assertEquals("Eighteen", result);

        result = numberUtilities.convertAnyNumberToWords("10");
        assertEquals("Ten", result);


        result = numberUtilities.convertAnyNumberToWords(10L);
        assertEquals("Ten", result);

        result = numberUtilities.convertAnyNumberToWords(10);
        assertEquals("Ten", result);
    }

    @Test
    void numberUtilitiesCanTellHigherTensCorrectly(){
        String result = numberUtilities.convertAnyNumberToWords("35");
        assertEquals("Thirty-Five", result);

        result = numberUtilities.convertAnyNumberToWords("42");
        assertEquals("Forty-Two", result);

        result = numberUtilities.convertAnyNumberToWords("85");
        assertEquals("Eighty-Five", result);

        result = numberUtilities.convertAnyNumberToWords("20");
        assertEquals("Twenty", result);

        result = numberUtilities.convertAnyNumberToWords("40");
        assertEquals("Forty", result);

        System.out.println(timeUtil.whatIsTheCurrentTime());
        System.out.println(timeUtil.greetUser());
    }

    @Test
    void numberUtilitiesCanTellHundredCorrectly(){
        String result = numberUtilities.convertAnyNumberToWords("125");
        assertEquals("One Hundred and Twenty-Five", result);


        result = numberUtilities.convertAnyNumberToWords("530");
        assertEquals("Five Hundred and Thirty", result);

        result = numberUtilities.convertAnyNumberToWords("685");
        assertEquals("Six Hundred and Eighty-Five", result);

        result = numberUtilities.convertAnyNumberToWords("956");
        assertEquals("Nine Hundred and Fifty-Six", result);


        result = numberUtilities.convertAnyNumberToWords("40");
        assertEquals("Forty", result);

    }


    @Test
    void numberUtilitiesCanTellAnyNumberCorrectly(){
        String result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(34569));
        assertEquals("Thirty-Four Thousand, Five Hundred and Sixty-Nine", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(18000000));
        assertEquals("Eighteen Million", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(502));
        assertEquals("Five Hundred and Two", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(0));
        assertEquals("Zero", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(1_502_938_593));
        assertEquals("One Billion, Five Hundred and Two Million, Nine Hundred and Thirty-Eight Thousand, Five Hundred and Ninety-Three", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(1_502_938_593.34));
        assertEquals("One Billion, Five Hundred and Two Million, Nine Hundred and Thirty-Eight Thousand, Five Hundred and Ninety-Three point Thirty-Four", result);

        result = numberUtilities.convertAnyNumberToWords(BigDecimal.valueOf(18000023));
        assertEquals("Eighteen Million and Twenty-Three", result);

        result = numberUtilities.convertAnyNumberToWords("685");
        assertEquals("Six Hundred and Eighty-Five", result);

        result = numberUtilities.convertAnyNumberToWords("956");
        assertEquals("Nine Hundred and Fifty-Six", result);


        result = numberUtilities.convertAnyNumberToWords("40");
        assertEquals("Forty", result);

    }





}