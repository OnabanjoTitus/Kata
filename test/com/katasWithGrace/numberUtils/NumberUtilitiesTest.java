package com.katasWithGrace.numberUtils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println(result);
       assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime(10, 00);
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime("10", "00");
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime(10);
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);

        result = timeUtil.tellTheTime(new Time(10));
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);




    }

    @Test
    void numberUtilitiesCanTellTheTimeInMinutesTest(){
       System.out.println(numberUtilities.convertAnyNumberToWords("2456543689465982735913"));
       String result = timeUtil.tellTheTime("10:12");
        System.out.println(result);
       assertEquals("It's Ten Twelve", result);


        result = timeUtil.tellTheTime("10:19");
        System.out.println(result);
        assertEquals("It's Ten Nineteen", result);


        result = timeUtil.tellTheTime("12:19");
        System.out.println(result);
        assertEquals("It's Twelve Nineteen", result);


    }



    @Test
    void numberUtilitiesCanTellTheTImeCorrectlyTest(){
        String result = timeUtil.tellTheTime("10:35");
        System.out.println(result);
        assertEquals("It's Ten Thirty-Five", result);

        result = timeUtil.tellTheTime("10 35");
        System.out.println(result);
        assertEquals("It's Ten Thirty-Five", result);

        result = timeUtil.tellTheTime("10.35");
        System.out.println(result);
        assertEquals("It's Ten Thirty-Five", result);


        result = timeUtil.tellTheTime("10");
        System.out.println(result);
        assertEquals("It's Ten O' clock", result);




        result = timeUtil.tellTheTime("11:54");
        System.out.println(result);

result = timeUtil.tellTheTime("12:56");
        System.out.println(result);
result = timeUtil.tellTheTime("23:35");
        System.out.println(result);
result = timeUtil.tellTheTime("16:23");
        System.out.println(result);
result = timeUtil.tellTheTime("04:13");
        System.out.println(result);

        result = timeUtil.tellTheTime("00:13");
        System.out.println(result);


    }


    @Test
    void numberUtilitiesCanTellTheTImeIfItIsTwentyFourHourTest() {
        String result = timeUtil.tellTheTime("13:35");
        System.out.println(result);
        assertEquals("It's One Thirty-Five", result);

        result = timeUtil.tellTheTime("24:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

    }



    @Test
    void numberUtilitiesCanTellTheTImeIfItIsZeroHours() {
        String result = timeUtil.tellTheTime("0:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

        result = timeUtil.tellTheTime("24:35");
        System.out.println(result);
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
        System.out.println(result);
        assertEquals("It's Twelve O' clock", result);

    }

    @Test
    void numberUtilitiesCanTellTimeCorrectlyWhenMinuteIsLessThanTenTest() {
        String result = timeUtil.tellTheTime("0:05");
        System.out.println(result);
        assertEquals("It's Twelve O'Five", result);
        System.out.println(timeUtil.whatIsTheCurrentTime());

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

        System.out.println(timeUtil.whatIsTheCurrentTime());
        System.out.println(timeUtil.greetUser());
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